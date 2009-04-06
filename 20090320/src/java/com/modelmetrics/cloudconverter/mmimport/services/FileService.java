package com.modelmetrics.cloudconverter.mmimport.services;

import java.io.File;


public interface FileService {

	WrapperBean parseXLS(File file)
			throws ParseException;
}
