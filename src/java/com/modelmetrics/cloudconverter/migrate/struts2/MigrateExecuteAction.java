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
package com.modelmetrics.cloudconverter.migrate.struts2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.modelmetrics.cloudconverter.migrate.DataMigrator;
import com.modelmetrics.cloudconverter.migrate.DataMigratorFactory;
import com.modelmetrics.cloudconverter.util.OperationStatusSubscriberLifoImpl;
import com.modelmetrics.common.sforce.dao.SalesforceDAO;
import com.modelmetrics.common.sforce.dao.Sproxy;
import com.modelmetrics.common.sforce.dao.SproxySaveResult;
import com.opensymphony.xwork2.Action;

public class MigrateExecuteAction extends AbstractMigrateContextAware {

	private Log log = LogFactory.getLog(MigrateExecuteAction.class);

	private Collection<MigrateVO> errorObjects = new ArrayList<MigrateVO>();

	public String execute() throws Exception {

		this.getMigrateContext().setStatusSubscriber(new OperationStatusSubscriberLifoImpl());
		
		this.getMigrateContext().getStatusSubscriber().publish("Beginning field migration.");

		SalesforceDAO dao = new SalesforceDAO();
		
		dao.subscribeToStatus(this.getMigrateContext().getStatusSubscriber());
		
		dao.setSalesforceSession(this.getSalesforceSessionContext()
				.getSalesforceSession());

		Collection<Sproxy> preview = dao.queryAll(new MigrateSoqlBuilder().buildNoPreview(
				this.getDescribeContext(), this.getMigrateContext()));

		log.info("total elements returned: " + preview.size());
		Collection<Sproxy> toUpdate = new ArrayList<Sproxy>();

		DataMigrator dataMigrator = new DataMigratorFactory().build(this
				.getMigrateContext());

		for (Iterator iter = preview.iterator(); iter.hasNext();) {
			Sproxy element = (Sproxy) iter.next();

			String originalTarget = element.getValue(this.getMigrateContext()
					.getTargetField());

			String newResult = dataMigrator.migrate(element.getValue(this
					.getMigrateContext().getSourceField()), originalTarget);

			if ((newResult != null) && !(newResult.equalsIgnoreCase(originalTarget))) {
//				migrateServiceDelegate.saveDetail(element, newResult);

				element.setValue(this.getMigrateContext().getTargetField(),
						newResult);

				if (this.getMigrateContext().getDisposition() == SourceDispositionType.SET_TO_NULL) {
					element.setNull(this.getMigrateContext().getSourceField());
				}

				toUpdate.add(element);
			} else if (originalTarget != null && newResult == null) {
				element.setNull(this.getMigrateContext().getTargetField());
			}
		}

		Collection<SproxySaveResult> errors = dao.updateAll(toUpdate, this.getMigrateContext().getUpdateBatchSize());

		Collection<MigrateVO> errorVos = new ArrayList<MigrateVO>();
		MigrateVOBuilder builder = new MigrateVOBuilder();

		for (Iterator iter = errors.iterator(); iter.hasNext();) {
			SproxySaveResult element = (SproxySaveResult) iter.next();

			MigrateVO vo = builder.build(dataMigrator, element.getSproxy(),
					this.getMigrateContext());

			if (element.getSaveResult().getErrors() != null
					&& element.getSaveResult().getErrors().length > 0) {
				vo.setResult(element.getSaveResult().getErrors()[0]
						.getMessage());
			}

			errorVos.add(vo);

		}

		this.setErrorObjects(errorVos);

		log.info("To Update: " + toUpdate.size());
		log.info("Error size: " + errors.size());
		return Action.SUCCESS;
	}

	public Collection<MigrateVO> getErrorObjects() {
		return errorObjects;
	}

	public void setErrorObjects(Collection<MigrateVO> errorObjects) {
		this.errorObjects = errorObjects;
	}


}
