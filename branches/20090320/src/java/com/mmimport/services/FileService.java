package com.mmimport.services;

import java.io.File;

import com.mmimport.beans.WrapperBean;
import com.mmimport.exceptions.ParseException;

public interface FileService {

	WrapperBean parseXLS(File file)
			throws ParseException;
}
