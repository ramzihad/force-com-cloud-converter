package com.modelmetrics.cloudconverter.forceutil;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import com.modelmetrics.cloudconverter.engine.MigrationContext;
import com.modelmetrics.cloudconverter.util.MetadataProxy;
import com.sforce.soap.partner.Field;

/*
 * 2009-04-15
 * 
 * checks to see if the metadata API reflects all the field changes.
 * 
 * useful since layout builder occasionally gets exceptions thrown at it. 
 * 
 */
public class MetadataReadinessChecker {

	public boolean isMetadataReady(MigrationContext migrationContext) throws Exception {
		
		Field[] fields = migrationContext.getSalesforceSession().getSalesforceService().describeSObject(migrationContext.getCustomObject().getFullName()).getFields();

		return this.isMetadataReady(migrationContext.getMetadataProxies(), fields);
	}
	
	public boolean isMetadataReady(List<MetadataProxy> metadataProxies, Field[] fields) throws Exception {
		
		Set<String> potential = new TreeSet<String>();
		
		for (int i = 0; i < fields.length; i++) {
			potential.add(fields[i].getName().toLowerCase());
		}
		
		boolean ret = true;
		
		for (Iterator<MetadataProxy> iterator = metadataProxies.iterator(); iterator.hasNext();) {
			MetadataProxy current = iterator.next();
			
			if (!potential.contains(current.getName().toLowerCase() + "__c")) {
				ret = false;
				break;
			}
			
		}
		
		
		return ret;
		
	}
}
