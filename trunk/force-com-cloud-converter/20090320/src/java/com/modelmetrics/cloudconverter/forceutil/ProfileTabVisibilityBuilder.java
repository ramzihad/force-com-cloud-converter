package com.modelmetrics.cloudconverter.forceutil;

import com.sforce.soap._2006._04.metadata.Profile;
import com.sforce.soap._2006._04.metadata.ProfileTabVisibility;
import com.sforce.soap._2006._04.metadata.TabVisibility;

public class ProfileTabVisibilityBuilder {

	public Profile build(String profileName, String objectName, TabVisibility tabVisibility) throws Exception {
		
		Profile profile = new Profile();
		
		profile.setFullName(profileName);
		
		ProfileTabVisibility profileTabVisibility = new ProfileTabVisibility();
		
		profileTabVisibility.setTab(objectName);
		
		profileTabVisibility.setVisibility(tabVisibility);
		
		profile.setTabVisibilities(new ProfileTabVisibility[] { profileTabVisibility });
		
		return profile;
		
	}
	
	public Profile build(String profileName, String objectName) throws Exception {
		
		return this.build(profileName, objectName, TabVisibility.DefaultOn);
		
		
	}
}
