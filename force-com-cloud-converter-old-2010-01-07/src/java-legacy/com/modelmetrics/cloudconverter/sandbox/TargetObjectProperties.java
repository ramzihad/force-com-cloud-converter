/*
The MIT License

Copyright (c) 2008, 2009 Model Metrics, Inc.

http://ModelMetrics.com
http://ModelMetrics.com/authors/rcarlberg

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
 */
package com.modelmetrics.cloudconverter.sandbox;

import com.sforce.soap._2006._04.metadata.CustomField;
import com.sforce.soap._2006._04.metadata.CustomObject;
import com.sforce.soap._2006._04.metadata.CustomSettingsType;
import com.sforce.soap._2006._04.metadata.DeploymentStatus;
import com.sforce.soap._2006._04.metadata.Gender;
import com.sforce.soap._2006._04.metadata.SharingModel;
import com.sforce.soap._2006._04.metadata.StartsWith;

//goal for this is to be an intermediate object a user can work with.

public class TargetObjectProperties {

	private String originalName;
	
	private CustomObject target;
	
	private CustomField targetNameField;
	
	public TargetObjectProperties() {
		target = new CustomObject();
		targetNameField = new CustomField();
		target.setNameField(targetNameField);
	}
	
	public TargetObjectProperties(String originalName) {
		this();
		this.originalName = originalName;
	}

	public String getOriginalName() {
		return originalName;
	}

	public void setOriginalName(String originalName) {
		this.originalName = originalName;
	}

	public CustomObject getTarget() {
		return target;
	}

	public void setTarget(CustomObject target) {
		this.target = target;
	}

	public String getCustomHelp() {
		return target.getCustomHelp();
	}

	public CustomSettingsType getCustomSettingsType() {
		return target.getCustomSettingsType();
	}

	public DeploymentStatus getDeploymentStatus() {
		return target.getDeploymentStatus();
	}

	public String getDescription() {
		return target.getDescription();
	}

	public Boolean getEnableActivities() {
		return target.getEnableActivities();
	}

	public Boolean getEnableDivisions() {
		return target.getEnableDivisions();
	}

	public Boolean getEnableHistory() {
		return target.getEnableHistory();
	}

	public Boolean getEnableReports() {
		return target.getEnableReports();
	}

	public String getFullName() {
		return target.getFullName();
	}

	public Gender getGender() {
		return target.getGender();
	}

	public Boolean getHousehold() {
		return target.getHousehold();
	}

	public String getLabel() {
		return target.getLabel();
	}

	public CustomField getNameField() {
		return target.getNameField();
	}

	public String getPluralLabel() {
		return target.getPluralLabel();
	}

	public SharingModel getSharingModel() {
		return target.getSharingModel();
	}

	public void setCustomHelp(String customHelp) {
		target.setCustomHelp(customHelp);
	}

	public void setCustomSettingsType(CustomSettingsType customSettingsType) {
		target.setCustomSettingsType(customSettingsType);
	}

	public void setDeploymentStatus(DeploymentStatus deploymentStatus) {
		target.setDeploymentStatus(deploymentStatus);
	}

	public void setDescription(String description) {
		target.setDescription(description);
	}

	public void setEnableActivities(Boolean enableActivities) {
		target.setEnableActivities(enableActivities);
	}

	public void setEnableDivisions(Boolean enableDivisions) {
		target.setEnableDivisions(enableDivisions);
	}

	public void setEnableHistory(Boolean enableHistory) {
		target.setEnableHistory(enableHistory);
	}

	public void setEnableReports(Boolean enableReports) {
		target.setEnableReports(enableReports);
	}

	public void setFullName(String fullName) {
		target.setFullName(fullName);
	}

	public void setGender(Gender gender) {
		target.setGender(gender);
	}

	public void setHousehold(Boolean household) {
		target.setHousehold(household);
	}

	public void setLabel(String label) {
		target.setLabel(label);
	}

	public void setNameField(CustomField nameField) {
		target.setNameField(nameField);
	}

	public void setSharingModel(SharingModel sharingModel) {
		target.setSharingModel(sharingModel);
	}

	public void setStartsWith(StartsWith startsWith) {
		target.setStartsWith(startsWith);
	}

	public CustomField getTargetNameField() {
		return targetNameField;
	}

	public void setTargetNameField(CustomField targetNameField) {
		this.targetNameField = targetNameField;
	}
	
}
