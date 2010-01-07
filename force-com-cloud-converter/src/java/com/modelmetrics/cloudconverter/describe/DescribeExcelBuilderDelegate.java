package com.modelmetrics.cloudconverter.describe;

import java.util.Collection;

public interface DescribeExcelBuilderDelegate {

	public void handleBuild(Collection<DisplayableFieldMetadataBean> metadata,  String sheetName) throws Exception;
	
}
