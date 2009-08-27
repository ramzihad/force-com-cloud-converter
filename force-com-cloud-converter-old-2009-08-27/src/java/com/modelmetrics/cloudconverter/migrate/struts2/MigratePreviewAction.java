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

import org.springframework.util.StringUtils;

import com.modelmetrics.cloudconverter.migrate.DataMigrator;
import com.modelmetrics.cloudconverter.migrate.DataMigratorFactory;
import com.modelmetrics.common.sforce.dao.SalesforceDAO;
import com.modelmetrics.common.sforce.dao.Sproxy;
import com.opensymphony.xwork2.Action;

public class MigratePreviewAction extends AbstractMigrateContextAware {

	private String submit;
	
	private Collection<MigrateVO> results;

	public String execute() throws Exception {


		
		SalesforceDAO dao = new SalesforceDAO();
		dao.setSalesforceSession(this.getSalesforceSessionContext()
				.getSalesforceSession());

		Collection<Sproxy> preview = dao.query(new MigrateSoqlBuilder().build(
				this.getDescribeContext(), this.getMigrateContext())
				+ " limit 25 ");

		Collection<MigrateVO> results = new ArrayList<MigrateVO>();

		DataMigrator dataMigrator = new DataMigratorFactory().build(this
				.getMigrateContext());

		MigrateVOBuilder builder = new MigrateVOBuilder();

		for (Iterator iter = preview.iterator(); iter.hasNext();) {
			Sproxy element = (Sproxy) iter.next();

			MigrateVO vo = builder.build(dataMigrator, element, this
					.getMigrateContext());

			results.add(vo);

		}

		this.setResults(results);

		return Action.INPUT;
	}

	public Collection<MigrateVO> getResults() {
		return results;
	}

	public void setResults(Collection<MigrateVO> results) {
		this.results = results;
	}

	public String getSubmit() {
		return submit;
	}

	public void setSubmit(String submit) {
		this.submit = submit;
	}
}
