package com.modelmetrics.cloudconverter.mmimport.services;

import java.io.File;

import com.modelmetrics.cloudconverter.mmimport.beans.WrapperBean;
import com.modelmetrics.cloudconverter.mmimport.exceptions.ParseException;

public interface FileService {

	WrapperBean parseXLS(File file)
			throws ParseException;
}
