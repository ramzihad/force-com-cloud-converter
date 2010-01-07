/*
The MIT License

Copyright (c) 2008, 2009 Model Metrics, Inc.

http://ModelMetrics.com
http://ModelMetrics.com/authors/rcarlberg

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
 */

package com.modelmetrics.common.sforce.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.modelmetrics.common.sforce.AbstractSalesforceSessionAware;
import com.modelmetrics.common.sforce.SalesforceSession;
import com.sforce.soap._2006._04.metadata.StatusCode;
import com.sforce.soap.partner.QueryResult;
import com.sforce.soap.partner.SaveResult;
import com.sforce.soap.partner.SoapBindingStub;
import com.sforce.soap.partner.UpsertResult;
import com.sforce.soap.partner.sobject.SObject;

public class SalesforceDAO extends AbstractSalesforceSessionAware {

	private static Log log = LogFactory.getLog(SalesforceDAO.class);

	private static String INSERT = "insert";

	private static String UPDATE = "update";

	private static String UPSERT = "upsert";

	private String externalIdFieldForUpsert;

	public Sproxy querySingle(String soql) throws SalesforceDaoException {

		Sproxy ret = null;

		QueryResult queryResult;
		try {

			SalesforceSession SFSession = this.getSalesforceSession();
			SoapBindingStub SBStub = SFSession.getSalesforceService();
			queryResult = SBStub.query(soql);
			// queryResult = new QueryResult();
		} catch (Exception e) {
			throw new SalesforceDaoException(e);
		}

		if (queryResult.getSize() == 1) {
			ret = new SproxyBuilder().build(queryResult.getRecords()[0]);
		} else {

			throw new SalesforceDaoException("Expected one record, Found "
					+ queryResult.getSize());
		}

		return ret;

	}

	public Collection<Sproxy> query(String soql) throws SalesforceDaoException {

		Collection<Sproxy> ret = null;

		QueryResult queryResult;
		try {

			SalesforceSession SFSession = this.getSalesforceSession();
			SoapBindingStub SBStub = SFSession.getSalesforceService();
			queryResult = SBStub.query(soql);
			// queryResult = new QueryResult();
		} catch (Exception e) {
			throw new SalesforceDaoException(e);
		}

		ret = new SproxyBuilder().build(queryResult.getRecords());

		return ret;

	}

	public Collection<Sproxy> queryAll(String soql)
			throws SalesforceDaoException {

		Collection<Sproxy> ret = null;

		QueryResult queryResult;

		try {

			SalesforceSession session = this.getSalesforceSession();
			SoapBindingStub sforce = session.getSalesforceService();
			queryResult = sforce.query(soql);
			// queryResult = new QueryResult();

			ret = new SproxyBuilder().build(queryResult.getRecords());

			while (!queryResult.isDone()) {
				queryResult = this.getSalesforceSession()
						.getSalesforceService().queryMore(
								queryResult.getQueryLocator());

				ret.addAll(new SproxyBuilder().build(queryResult.getRecords()));
			}

		} catch (Exception e) {
			throw new SalesforceDaoException(e);
		}
		return ret;

	}

	public Sproxy save(Sproxy sproxy) throws SalesforceDaoException {

		SObject[] saveTarget = new SObject[1];

		try {
			saveTarget[0] = new SobjectBuilder().build(sproxy);
		} catch (Exception e) {
			throw new SalesforceDaoException("couldn't build sobject");
		}

		SaveResult[] results;
		try {
			results = this.getSalesforceSession().getSalesforceService()
					.create(saveTarget);
		} catch (Exception e) {
			throw new SalesforceDaoException("couldn't create new object", e);
		}

		if (results[0].isSuccess()) {
			sproxy.setValue("id", results[0].getId());
			return sproxy;
		} else {
			throw new SalesforceDaoException("create failed.");
		}
	}

	public Collection<SproxySaveResult> updateAll(Collection<Sproxy> toUpdate,
			int updateBatchSize) throws SalesforceDaoException {

		return this.saveAll(toUpdate, SalesforceDAO.UPDATE, updateBatchSize);

	}

	public Collection<SproxySaveResult> updateAll(Collection<Sproxy> toUpdate)
			throws SalesforceDaoException {

		return this.saveAll(toUpdate, SalesforceDAO.UPDATE, 100);

	}

	private Collection<SproxySaveResult> saveAll(Collection<Sproxy> toSave,
			String operation, int maxBatchSize) throws SalesforceDaoException {
		Collection<SproxySaveResult> errors = new ArrayList<SproxySaveResult>();

		int totalCountSoFar = 0;
		int batchCount = 0;
		Collection<Sproxy> batchToUpdate = new ArrayList<Sproxy>();

		for (Iterator iter = toSave.iterator(); iter.hasNext();) {
			Sproxy element = (Sproxy) iter.next();

			batchToUpdate.add(element);
			batchCount++;
			totalCountSoFar++;

			if (batchCount == maxBatchSize) {
				Collection<SproxySaveResult> batchErrors = this.save(
						batchToUpdate, operation);
				errors.addAll(batchErrors);
				batchCount = 0;
				batchToUpdate = new ArrayList<Sproxy>();
				this.publishStatus("Updated batch. Total updated: "
						+ totalCountSoFar);
				log.info("Completed batch save");
			}

		}

		if (batchToUpdate.size() > 0) {
			Collection<SproxySaveResult> batchErrors = this
					.update(batchToUpdate);
			errors.addAll(batchErrors);
		}

		log.info("total count saved: " + totalCountSoFar);
		return errors;
	}

	public Collection<SproxySaveResult> update(Collection<Sproxy> toUpdate)
			throws SalesforceDaoException {
		return this.save(toUpdate, SalesforceDAO.UPDATE);
	}

	public Collection<SproxySaveResult> insert(Collection<Sproxy> toInsert)
			throws SalesforceDaoException {
		return this.save(toInsert, SalesforceDAO.INSERT);
	}

	public Collection<SproxySaveResult> upsert(String externalIdForUpsert,
			Collection<Sproxy> toInsert) throws SalesforceDaoException {
		if (externalIdForUpsert == null || externalIdForUpsert.length() == 0) {
			throw new SalesforceDaoException(
					"External ID field is required for upsert.");
		}
		this.externalIdFieldForUpsert = externalIdForUpsert;
		return this.save(toInsert, SalesforceDAO.UPSERT);
	}

	private Collection<SproxySaveResult> save(Collection<Sproxy> toSave,
			String operation) throws SalesforceDaoException {

		Collection<SproxySaveResult> errors = new ArrayList<SproxySaveResult>();

		SObject[] saveTargets;
		try {
			saveTargets = new SobjectBuilder().build(toSave);
		} catch (Exception e) {
			throw new SalesforceDaoException(e);
		}

		SaveResult[] results = null;
		UpsertResult[] upsertResults = null;
		try {
			if (operation == SalesforceDAO.UPDATE) {
				results = this.getSalesforceSession().getSalesforceService()
						.update(saveTargets);
			} else if (operation == SalesforceDAO.INSERT) {
				results = this.getSalesforceSession().getSalesforceService()
						.create(saveTargets);
			} else if (operation == SalesforceDAO.UPSERT) {
				upsertResults = this.getSalesforceSession()
						.getSalesforceService().upsert(
								this.externalIdFieldForUpsert, saveTargets);
			} else {
				throw new SalesforceDaoException("invalid operation! "
						+ operation);
			}
		} catch (Exception e) {
			throw new SalesforceDaoException(e);
		}

		if (operation == SalesforceDAO.UPSERT) {
			try {
				for (int i = 0; i < upsertResults.length; i++) {
					if (!upsertResults[i].isSuccess()) {
						SproxySaveResult sproxySaveResult = new SproxySaveResult();
						sproxySaveResult.setSproxy(new SproxyBuilder()
								.build(saveTargets[i]));
						// sproxySaveResult.setSaveResult(upsertResults[i]);
						errors.add(sproxySaveResult);
						for (int j = 0; j < upsertResults[i].getErrors().length; j++) {
							log.info(upsertResults[i].getErrors()[j]
									.getMessage());
							if (upsertResults[i].getErrors()[j].getStatusCode()
									.getValue().equalsIgnoreCase(
											StatusCode.STORAGE_LIMIT_EXCEEDED
													.getValue())) {
								
								
								throw new RuntimeException(
										"Could not migrate data (upsert) -- Storage Limit Exceeded.");
							}
						}
						// log.info(results[i].getErrors());
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
				log.error(e);
				throw new SalesforceDaoException(e);
			}
		} else {
			try {
				for (int i = 0; i < results.length; i++) {
					if (!results[i].isSuccess()) {
						SproxySaveResult sproxySaveResult = new SproxySaveResult();
						sproxySaveResult.setSproxy(new SproxyBuilder()
								.build(saveTargets[i]));
						sproxySaveResult.setSaveResult(results[i]);
						errors.add(sproxySaveResult);
						for (int j = 0; j < results[i].getErrors().length; j++) {
							log.info(results[i].getErrors()[j].getMessage());
							if (results[i].getErrors()[j].getStatusCode()
									.getValue().equalsIgnoreCase(
											StatusCode.STORAGE_LIMIT_EXCEEDED
													.getValue())) {
								throw new RuntimeException(
										"Could not migrate data (insert) -- Storage Limit Exceeded.");
							}
						}
						// log.info(results[i].getErrors());
					}
				}
			} catch (Exception e) {
				log.error(e);
				throw new SalesforceDaoException(e);
			}
		}

		return errors;
	}

}
