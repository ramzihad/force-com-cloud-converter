package com.modelmetrics.cloudconverter.forceutil;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import com.modelmetrics.cloudconverter.util.MetadataProxy;
import com.sforce.soap.partner.Field;

import junit.framework.TestCase;

public class MetadataReadinessCheckerTest extends TestCase {

	public void testContainsSucceeds() throws Exception {
		
		List<MetadataProxy> proxies = new ArrayList<MetadataProxy>();
		
		MetadataProxy metadataProxy = new MetadataProxy();
		metadataProxy.setName("Name1");
		
		proxies.add(metadataProxy);
		
		metadataProxy = new MetadataProxy();
		metadataProxy.setName("Name2");
		
		proxies.add(metadataProxy);
		
		Field[] fields = new Field[2];
		
		fields[0] = new Field();
		fields[0].setName("Name1");
		
		fields[1] = new Field();
		fields[1].setName("Name2");
		
		MetadataReadinessChecker checker = new MetadataReadinessChecker();
		
		assertTrue(checker.isMetadataReady(proxies, fields));
	}
	
	public void testContainsFails() throws Exception {
		
		List<MetadataProxy> proxies = new ArrayList<MetadataProxy>();
		
		MetadataProxy metadataProxy = new MetadataProxy();
		metadataProxy.setName("Name1");
		
		proxies.add(metadataProxy);
		
		metadataProxy = new MetadataProxy();
		metadataProxy.setName("Name3");
		
		proxies.add(metadataProxy);
		
		Field[] fields = new Field[2];
		
		fields[0] = new Field();
		fields[0].setName("Name1");
		
		fields[1] = new Field();
		fields[1].setName("Name2");
		
		MetadataReadinessChecker checker = new MetadataReadinessChecker();
		
		assertFalse(checker.isMetadataReady(proxies, fields));
	}
}
