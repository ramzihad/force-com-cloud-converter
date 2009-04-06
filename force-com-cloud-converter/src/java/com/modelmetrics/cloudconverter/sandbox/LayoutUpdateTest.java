package com.modelmetrics.cloudconverter.sandbox;

import com.modelmetrics.common.util.TestCaseWithLog;

public class LayoutUpdateTest extends TestCaseWithLog {

	public void testBasic() throws Exception {

		// Layout layout = new Layout();
		//
		// LayoutSection[] layoutSections = new LayoutSection[4];
		//
		// layoutSections[0] = new LayoutSection();
		// layoutSections[0].setEditHeading(Boolean.TRUE);
		// layoutSections[0].setStyle(LayoutSectionStyle.TwoColumnsTopToBottom);
		// layoutSections[0].setLabel("Information");
		//
		// LayoutColumn[] layoutColumnsOne = new LayoutColumn[2];
		// LayoutItem layoutItem = new LayoutItem();
		// layoutItem.setBehavior(UiBehavior.Readonly);
		// layoutItem.setField("Name");
		// layoutColumnsOne[0] = new LayoutColumn();
		// layoutColumnsOne[0].setLayoutItems(new LayoutItem[] { layoutItem });
		//
		// layoutItem = new LayoutItem();
		// layoutItem.setBehavior(UiBehavior.Edit);
		// layoutItem.setField("OwnerId");
		// layoutColumnsOne[1] = new LayoutColumn();
		// layoutColumnsOne[1].setLayoutItems(new LayoutItem[] { layoutItem });
		//		
		// layoutSections[0].setLayoutColumns(layoutColumnsOne);
		//
		// /*
		// * here are the new fields
		// */
		// layoutSections[1] = new LayoutSection();
		// layoutSections[1].setEditHeading(Boolean.TRUE);
		// layoutSections[1].setStyle(LayoutSectionStyle.TwoColumnsTopToBottom);
		// layoutSections[1].setCustomLabel(Boolean.TRUE);
		// layoutSections[1].setLabel("Imported Information");
		//
		// layoutColumnsOne = new LayoutColumn[2];
		// layoutItem = new LayoutItem();
		// layoutItem.setBehavior(UiBehavior.Edit);
		// layoutItem.setField("dog_count__c");
		// layoutColumnsOne[0] = new LayoutColumn();
		// layoutColumnsOne[0].setLayoutItems(new LayoutItem[] { layoutItem });
		//
		// layoutItem = new LayoutItem();
		// layoutItem.setBehavior(UiBehavior.Edit);
		// layoutItem.setField("birthdate__c");
		// layoutColumnsOne[1] = new LayoutColumn();
		// layoutColumnsOne[1].setLayoutItems(new LayoutItem[] { layoutItem });
		// layoutSections[1].setLayoutColumns(layoutColumnsOne);
		//
		// /*
		// * end new fields
		// */
		//
		// layoutSections[2] = new LayoutSection();
		// layoutSections[2].setEditHeading(Boolean.TRUE);
		// layoutSections[2].setStyle(LayoutSectionStyle.TwoColumnsTopToBottom);
		// layoutSections[2].setLabel("System Information");
		//
		// layoutColumnsOne = new LayoutColumn[2];
		// layoutItem = new LayoutItem();
		// layoutItem.setBehavior(UiBehavior.Readonly);
		// layoutItem.setField("CreatedById");
		// layoutColumnsOne[0] = new LayoutColumn();
		// layoutColumnsOne[0].setLayoutItems(new LayoutItem[] { layoutItem });
		// layoutItem = new LayoutItem();
		// layoutItem.setBehavior(UiBehavior.Readonly);
		// layoutItem.setField("LastModifiedById");
		// layoutColumnsOne[1] = new LayoutColumn();
		// layoutColumnsOne[1].setLayoutItems(new LayoutItem[] { layoutItem });
		// layoutSections[2].setLayoutColumns(layoutColumnsOne);
		//
		// layoutSections[3] = new LayoutSection();
		// layoutSections[3].setEditHeading(Boolean.TRUE);
		// layoutSections[3].setStyle(LayoutSectionStyle.CustomLinks);
		//
		// layoutColumnsOne = new LayoutColumn[3];
		// layoutColumnsOne[0] = new LayoutColumn();
		// layoutColumnsOne[1] = new LayoutColumn();
		// layoutColumnsOne[2] = new LayoutColumn();
		//
		// layoutSections[3].setLayoutColumns(layoutColumnsOne);
		//
		// layout.setLayoutSections(layoutSections);
		//
		// RelatedListItem[] relatedList = new RelatedListItem[2];
		// relatedList[0] = new RelatedListItem();
		// relatedList[0].setFields(new String[] { "TASK.SUBJECT",
		// "TASK.WHO_NAME", "ACTIVITY.TASK", "TASK.DUE_DATE",
		// "TASK.STATUS", "TASK.PRIORITY", "CORE.USERS.FULL_NAME" });
		// relatedList[0].setRelatedList("RelatedActivityList");
		//
		// relatedList[1] = new RelatedListItem();
		// relatedList[1].setFields(new String[] { "TASK.SUBJECT",
		// "TASK.WHO_NAME", "ACTIVITY.TASK", "TASK.DUE_DATE",
		// "TASK.STATUS", "TASK.PRIORITY", "CORE.USERS.FULL_NAME" });
		// relatedList[1].setRelatedList("RelatedHistoryList");
		//
		// layout.setRelatedLists(relatedList);
		//
		// layout.setFullName("table1__c-table1 (3) Layout");
		//
		// MigrationContext migrationContext = SampleMigrationContextBuilder
		// .buildSample("table1__c");
		//
		// UpdateMetadata um = new UpdateMetadata();
		// um.setMetadata(layout);
		// um.setCurrentName("table1__c-table1 (2) Layout");
		//
		// UpdateExecutor executor = new UpdateExecutor(migrationContext
		//				.getSalesforceSession().getMetadataService(),
		//				new UpdateMetadata[] { um });
		//		
		//		executor.execute();
		//		
		//		log.info("test complete");

	}
}
