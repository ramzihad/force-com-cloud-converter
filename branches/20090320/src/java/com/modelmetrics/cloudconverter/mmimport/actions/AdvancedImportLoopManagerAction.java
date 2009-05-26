package com.modelmetrics.cloudconverter.mmimport.actions;

/**
 * For advanced options, with multiple objects, this action managed the flow
 * to either next next object to be imported OR the finish screen.
 * 
 * @author reidcarlberg
 * @since 2009-05-24
 */
public class AdvancedImportLoopManagerAction extends AbstractUploadContextAware {

	private static final String SUCCESS_NEXT = "success_next";
	
	private static final String SUCCESS_FINISH = "success_finish";
	
	public String execute() throws Exception {
		
		//first visit through
		if (this.getUploadContext().getCurrentCloudConverterObjectIndex() == -1) {
			
			/*
			 * not in love with the here.  kind hacky.
			 */
			this.getUploadContext().setCurrentCloudConverterObjectIndex(0);
			return SUCCESS_NEXT;
		}
		
		//each subsequent visit
		if (this.getUploadContext().isNextCloudConverterObjectPresent()) {
			this.getUploadContext().setCurrentCloudConverterObjectIndex(this.getUploadContext().getCurrentCloudConverterObjectIndex() + 1);
			return SUCCESS_NEXT;
		}
		
		//complete
		return SUCCESS_FINISH;
	}
}
