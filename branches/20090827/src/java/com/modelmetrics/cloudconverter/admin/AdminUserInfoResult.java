package com.modelmetrics.cloudconverter.admin;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.sforce.soap.partner.GetUserInfoResult;

public class AdminUserInfoResult {
	private final GetUserInfoResult getUserInfoResult;
	private final Date date = new Date();
	
	public AdminUserInfoResult(GetUserInfoResult result ) {
		this.getUserInfoResult = result;
	}
	public GetUserInfoResult getInfo() {
		
		return getUserInfoResult;
	}
	

	public Date getDate() {
		return date;
	}
	public String getFormattedDate() {
		return SimpleDateFormat.getDateTimeInstance().format(this.getDate());
	}
}
