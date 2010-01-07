package com.modelmetrics.cloudconverter.admin;

import java.util.ArrayList;
import java.util.List;

import com.sforce.soap.partner.GetUserInfoResult;

public class AdminBean {

	public static AdminBean instance = new AdminBean();
	
	private List<AdminUserInfoResult> users = new ArrayList<AdminUserInfoResult>();
	
	public void addUser(GetUserInfoResult user, String what) {
		if (users.size() == 1000) {
			users.remove(0);
		}
		users.add(new AdminUserInfoResult(user, what));
	}

	public List<AdminUserInfoResult> getUsers() {
		return users;
	}

//	public void setUsers(List<GetUserInfoResult> users) {
//		this.users = users;
//	}
	
	
}
