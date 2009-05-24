package com.modelmetrics.cloudconverter.mmimport.services;

import java.util.List;

import com.modelmetrics.cloudconverter.util.ExternalIdBean;
import com.modelmetrics.cloudconverter.util.LookupBean;

/*
 * RSC 2009-05-23 Can we remove ID?  Probably.
 */
public class LookupAndIdWrapper {

	private List<LookupBean> lookups;
//	private List<ExternalIdBean> externalIds;
	public List<LookupBean> getLookups() {
		return lookups;
	}
	public void setLookups(List<LookupBean> lookups) {
		this.lookups = lookups;
	}
//	public List<ExternalIdBean> getExternalIds() {
//		return externalIds;
//	}
//	public void setExternalIds(List<ExternalIdBean> externalIds) {
//		this.externalIds = externalIds;
//	}
}
