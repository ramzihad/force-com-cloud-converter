package com.modelmetrics.cloudconverter.admin;

import java.util.ArrayList;
import java.util.List;

import com.sforce.soap.partner.GetUserInfoResult;

public class AdminBean {

	public static AdminBean instance = new AdminBean();
	
	private List<GetUserInfoResult> users = new ArrayList<GetUserInfoResult>();
	
	public void addUser(GetUserInfoResult user) {
		if (users.size() == 200) {
			users.remove(0);
		}
		users.add(user);
	}

	public List<GetUserInfoResult> getUsers() {
		return users;
	}

	public void setUsers(List<GetUserInfoResult> users) {
		this.users = users;
	}
	
	
}
