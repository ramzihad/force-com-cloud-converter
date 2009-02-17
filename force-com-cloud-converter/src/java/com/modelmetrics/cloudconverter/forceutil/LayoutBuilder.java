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

package com.modelmetrics.cloudconverter.forceutil;

import com.modelmetrics.cloudconverter.engine.AbstractMigrationContextAware;
import com.sforce.soap._2006._04.metadata.Layout;
import com.sforce.soap._2006._04.metadata.LayoutColumn;
import com.sforce.soap._2006._04.metadata.LayoutItem;
import com.sforce.soap._2006._04.metadata.LayoutSection;
import com.sforce.soap._2006._04.metadata.LayoutSectionStyle;
import com.sforce.soap._2006._04.metadata.RelatedListItem;
import com.sforce.soap._2006._04.metadata.UiBehavior;

public class LayoutBuilder extends AbstractMigrationContextAware {

	public Layout build() throws Exception {

		if (this.getMigrationContext() == null) {
			throw new RuntimeException("missing Migration Context");
		}

		Layout layout = new Layout();

		LayoutSection[] layoutSections = new LayoutSection[4];

		layoutSections[0] = new LayoutSection();
		layoutSections[0].setEditHeading(Boolean.TRUE);
		layoutSections[0].setStyle(LayoutSectionStyle.TwoColumnsTopToBottom);
		layoutSections[0].setLabel("Information");

		LayoutColumn[] layoutColumnsOne = new LayoutColumn[2];
		layoutColumnsOne[0] = new LayoutColumn();
		layoutColumnsOne[0].setLayoutItems(this.getLayoutItemArray(
				UiBehavior.Readonly, "Name"));

		layoutColumnsOne[1] = new LayoutColumn();
		layoutColumnsOne[1].setLayoutItems(this.getLayoutItemArray(
				UiBehavior.Edit, "OwnerId"));

		layoutSections[0].setLayoutColumns(layoutColumnsOne);

		/*
		 * here are the new fields
		 */
		layoutSections[1] = new LayoutSection();
		layoutSections[1].setEditHeading(Boolean.TRUE);
		layoutSections[1].setStyle(LayoutSectionStyle.TwoColumnsTopToBottom);
		layoutSections[1].setCustomLabel(Boolean.TRUE);
		layoutSections[1].setLabel("Imported Information");
		layoutSections[1].setDetailHeading(Boolean.TRUE);

		layoutColumnsOne = new LayoutColumn[2];
		
		LayoutItem[] newFields = new LayoutItem[this.getMigrationContext().getCustomFieldShortNames().length];
		
		for (int i = 0; i < this.getMigrationContext().getCustomFieldShortNames().length; i++) {
			newFields[i] = this.getLayoutItem(UiBehavior.Edit, this.getMigrationContext().getCustomFieldShortNames()[i]);
		}
		
		layoutColumnsOne[0] = new LayoutColumn();
		layoutColumnsOne[0].setLayoutItems(newFields);

//		layoutItem = new LayoutItem();
//		layoutItem.setBehavior(UiBehavior.Edit);
//		layoutItem.setField("birthdate__c");
		layoutColumnsOne[1] = new LayoutColumn();
		layoutColumnsOne[1].setLayoutItems(new LayoutItem[] {  });
		layoutSections[1].setLayoutColumns(layoutColumnsOne);

		/*
		 * end new fields
		 */

		layoutSections[2] = new LayoutSection();
		layoutSections[2].setEditHeading(Boolean.TRUE);
		layoutSections[2].setStyle(LayoutSectionStyle.TwoColumnsTopToBottom);
		layoutSections[2].setLabel("System Information");

		layoutColumnsOne = new LayoutColumn[2];
		layoutColumnsOne[0] = new LayoutColumn();
		layoutColumnsOne[0].setLayoutItems(this.getLayoutItemArray(
				UiBehavior.Readonly, "CreatedById"));
		layoutColumnsOne[1] = new LayoutColumn();
		layoutColumnsOne[1].setLayoutItems(this.getLayoutItemArray(
				UiBehavior.Readonly, "LastModifiedById"));
		layoutSections[2].setLayoutColumns(layoutColumnsOne);

		layoutSections[3] = new LayoutSection();
		layoutSections[3].setEditHeading(Boolean.TRUE);
		layoutSections[3].setStyle(LayoutSectionStyle.CustomLinks);

		layoutColumnsOne = new LayoutColumn[3];
		layoutColumnsOne[0] = new LayoutColumn();
		layoutColumnsOne[1] = new LayoutColumn();
		layoutColumnsOne[2] = new LayoutColumn();

		layoutSections[3].setLayoutColumns(layoutColumnsOne);

		layout.setLayoutSections(layoutSections);

		RelatedListItem[] relatedList = new RelatedListItem[2];
		relatedList[0] = new RelatedListItem();
		relatedList[0].setFields(new String[] { "TASK.SUBJECT",
				"TASK.WHO_NAME", "ACTIVITY.TASK", "TASK.DUE_DATE",
				"TASK.STATUS", "TASK.PRIORITY", "CORE.USERS.FULL_NAME" });
		relatedList[0].setRelatedList("RelatedActivityList");

		relatedList[1] = new RelatedListItem();
		relatedList[1].setFields(new String[] { "TASK.SUBJECT",
				"TASK.WHO_NAME", "ACTIVITY.TASK", "TASK.DUE_DATE",
				"TASK.STATUS", "TASK.PRIORITY", "CORE.USERS.FULL_NAME" });
		relatedList[1].setRelatedList("RelatedHistoryList");

		layout.setRelatedLists(relatedList);

		layout.setFullName(this.getMigrationContext().getCustomObject()
				.getFullName()
				+ "-"
				+ this.getMigrationContext().getCustomObject().getLabel()
				+ " Layout");

		return layout;
	}

	LayoutItem[] getLayoutItemArray(UiBehavior uiBehavior, String name) {

		return new LayoutItem[] { this.getLayoutItem(uiBehavior, name) };

	}

	LayoutItem getLayoutItem(UiBehavior uiBehavior, String name) {

		LayoutItem layoutItem = new LayoutItem();
		layoutItem = new LayoutItem();
		layoutItem.setBehavior(uiBehavior);
		layoutItem.setField(name);
		return layoutItem;
		
	}
}
