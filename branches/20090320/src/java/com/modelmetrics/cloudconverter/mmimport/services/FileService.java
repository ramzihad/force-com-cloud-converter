package com.modelmetrics.cloudconverter.mmimport.services;

import java.io.File;
import java.util.List;


public interface FileService {

	List<WrapperBean> parseXLS(File file)
			throws ParseException;
}
