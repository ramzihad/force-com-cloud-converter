/**
 * CustomObject.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.sforce.soap._2006._04.metadata;

public class CustomObject  extends com.sforce.soap._2006._04.metadata.Metadata  implements java.io.Serializable {
    private java.lang.String customHelp;

    private com.sforce.soap._2006._04.metadata.CustomSettingsType customSettingsType;

    private com.sforce.soap._2006._04.metadata.DeploymentStatus deploymentStatus;

    private java.lang.String description;

    private java.lang.Boolean enableActivities;

    private java.lang.Boolean enableDivisions;

    private java.lang.Boolean enableEnhancedLookup;

    private java.lang.Boolean enableHistory;

    private java.lang.Boolean enableReports;

    private com.sforce.soap._2006._04.metadata.CustomField[] fields;

    private com.sforce.soap._2006._04.metadata.Gender gender;

    private java.lang.Boolean household;

    private java.lang.String label;

    private com.sforce.soap._2006._04.metadata.ListView[] listViews;

    private com.sforce.soap._2006._04.metadata.CustomField nameField;

    private java.lang.String pluralLabel;

    private com.sforce.soap._2006._04.metadata.RecordType[] recordTypes;

    private com.sforce.soap._2006._04.metadata.SearchLayouts searchLayouts;

    private com.sforce.soap._2006._04.metadata.SharingModel sharingModel;

    private com.sforce.soap._2006._04.metadata.SharingReason[] sharingReasons;

    private com.sforce.soap._2006._04.metadata.SharingRecalculation[] sharingRecalculations;

    private com.sforce.soap._2006._04.metadata.StartsWith startsWith;

    private com.sforce.soap._2006._04.metadata.ValidationRule[] validationRules;

    private com.sforce.soap._2006._04.metadata.WebLink[] webLinks;

    public CustomObject() {
    }

    public CustomObject(
           java.lang.String fullName,
           java.lang.String customHelp,
           com.sforce.soap._2006._04.metadata.CustomSettingsType customSettingsType,
           com.sforce.soap._2006._04.metadata.DeploymentStatus deploymentStatus,
           java.lang.String description,
           java.lang.Boolean enableActivities,
           java.lang.Boolean enableDivisions,
           java.lang.Boolean enableEnhancedLookup,
           java.lang.Boolean enableHistory,
           java.lang.Boolean enableReports,
           com.sforce.soap._2006._04.metadata.CustomField[] fields,
           com.sforce.soap._2006._04.metadata.Gender gender,
           java.lang.Boolean household,
           java.lang.String label,
           com.sforce.soap._2006._04.metadata.ListView[] listViews,
           com.sforce.soap._2006._04.metadata.CustomField nameField,
           java.lang.String pluralLabel,
           com.sforce.soap._2006._04.metadata.RecordType[] recordTypes,
           com.sforce.soap._2006._04.metadata.SearchLayouts searchLayouts,
           com.sforce.soap._2006._04.metadata.SharingModel sharingModel,
           com.sforce.soap._2006._04.metadata.SharingReason[] sharingReasons,
           com.sforce.soap._2006._04.metadata.SharingRecalculation[] sharingRecalculations,
           com.sforce.soap._2006._04.metadata.StartsWith startsWith,
           com.sforce.soap._2006._04.metadata.ValidationRule[] validationRules,
           com.sforce.soap._2006._04.metadata.WebLink[] webLinks) {
        super(
            fullName);
        this.customHelp = customHelp;
        this.customSettingsType = customSettingsType;
        this.deploymentStatus = deploymentStatus;
        this.description = description;
        this.enableActivities = enableActivities;
        this.enableDivisions = enableDivisions;
        this.enableEnhancedLookup = enableEnhancedLookup;
        this.enableHistory = enableHistory;
        this.enableReports = enableReports;
        this.fields = fields;
        this.gender = gender;
        this.household = household;
        this.label = label;
        this.listViews = listViews;
        this.nameField = nameField;
        this.pluralLabel = pluralLabel;
        this.recordTypes = recordTypes;
        this.searchLayouts = searchLayouts;
        this.sharingModel = sharingModel;
        this.sharingReasons = sharingReasons;
        this.sharingRecalculations = sharingRecalculations;
        this.startsWith = startsWith;
        this.validationRules = validationRules;
        this.webLinks = webLinks;
    }


    /**
     * Gets the customHelp value for this CustomObject.
     * 
     * @return customHelp
     */
    public java.lang.String getCustomHelp() {
        return customHelp;
    }


    /**
     * Sets the customHelp value for this CustomObject.
     * 
     * @param customHelp
     */
    public void setCustomHelp(java.lang.String customHelp) {
        this.customHelp = customHelp;
    }


    /**
     * Gets the customSettingsType value for this CustomObject.
     * 
     * @return customSettingsType
     */
    public com.sforce.soap._2006._04.metadata.CustomSettingsType getCustomSettingsType() {
        return customSettingsType;
    }


    /**
     * Sets the customSettingsType value for this CustomObject.
     * 
     * @param customSettingsType
     */
    public void setCustomSettingsType(com.sforce.soap._2006._04.metadata.CustomSettingsType customSettingsType) {
        this.customSettingsType = customSettingsType;
    }


    /**
     * Gets the deploymentStatus value for this CustomObject.
     * 
     * @return deploymentStatus
     */
    public com.sforce.soap._2006._04.metadata.DeploymentStatus getDeploymentStatus() {
        return deploymentStatus;
    }


    /**
     * Sets the deploymentStatus value for this CustomObject.
     * 
     * @param deploymentStatus
     */
    public void setDeploymentStatus(com.sforce.soap._2006._04.metadata.DeploymentStatus deploymentStatus) {
        this.deploymentStatus = deploymentStatus;
    }


    /**
     * Gets the description value for this CustomObject.
     * 
     * @return description
     */
    public java.lang.String getDescription() {
        return description;
    }


    /**
     * Sets the description value for this CustomObject.
     * 
     * @param description
     */
    public void setDescription(java.lang.String description) {
        this.description = description;
    }


    /**
     * Gets the enableActivities value for this CustomObject.
     * 
     * @return enableActivities
     */
    public java.lang.Boolean getEnableActivities() {
        return enableActivities;
    }


    /**
     * Sets the enableActivities value for this CustomObject.
     * 
     * @param enableActivities
     */
    public void setEnableActivities(java.lang.Boolean enableActivities) {
        this.enableActivities = enableActivities;
    }


    /**
     * Gets the enableDivisions value for this CustomObject.
     * 
     * @return enableDivisions
     */
    public java.lang.Boolean getEnableDivisions() {
        return enableDivisions;
    }


    /**
     * Sets the enableDivisions value for this CustomObject.
     * 
     * @param enableDivisions
     */
    public void setEnableDivisions(java.lang.Boolean enableDivisions) {
        this.enableDivisions = enableDivisions;
    }


    /**
     * Gets the enableEnhancedLookup value for this CustomObject.
     * 
     * @return enableEnhancedLookup
     */
    public java.lang.Boolean getEnableEnhancedLookup() {
        return enableEnhancedLookup;
    }


    /**
     * Sets the enableEnhancedLookup value for this CustomObject.
     * 
     * @param enableEnhancedLookup
     */
    public void setEnableEnhancedLookup(java.lang.Boolean enableEnhancedLookup) {
        this.enableEnhancedLookup = enableEnhancedLookup;
    }


    /**
     * Gets the enableHistory value for this CustomObject.
     * 
     * @return enableHistory
     */
    public java.lang.Boolean getEnableHistory() {
        return enableHistory;
    }


    /**
     * Sets the enableHistory value for this CustomObject.
     * 
     * @param enableHistory
     */
    public void setEnableHistory(java.lang.Boolean enableHistory) {
        this.enableHistory = enableHistory;
    }


    /**
     * Gets the enableReports value for this CustomObject.
     * 
     * @return enableReports
     */
    public java.lang.Boolean getEnableReports() {
        return enableReports;
    }


    /**
     * Sets the enableReports value for this CustomObject.
     * 
     * @param enableReports
     */
    public void setEnableReports(java.lang.Boolean enableReports) {
        this.enableReports = enableReports;
    }


    /**
     * Gets the fields value for this CustomObject.
     * 
     * @return fields
     */
    public com.sforce.soap._2006._04.metadata.CustomField[] getFields() {
        return fields;
    }


    /**
     * Sets the fields value for this CustomObject.
     * 
     * @param fields
     */
    public void setFields(com.sforce.soap._2006._04.metadata.CustomField[] fields) {
        this.fields = fields;
    }

    public com.sforce.soap._2006._04.metadata.CustomField getFields(int i) {
        return this.fields[i];
    }

    public void setFields(int i, com.sforce.soap._2006._04.metadata.CustomField _value) {
        this.fields[i] = _value;
    }


    /**
     * Gets the gender value for this CustomObject.
     * 
     * @return gender
     */
    public com.sforce.soap._2006._04.metadata.Gender getGender() {
        return gender;
    }


    /**
     * Sets the gender value for this CustomObject.
     * 
     * @param gender
     */
    public void setGender(com.sforce.soap._2006._04.metadata.Gender gender) {
        this.gender = gender;
    }


    /**
     * Gets the household value for this CustomObject.
     * 
     * @return household
     */
    public java.lang.Boolean getHousehold() {
        return household;
    }


    /**
     * Sets the household value for this CustomObject.
     * 
     * @param household
     */
    public void setHousehold(java.lang.Boolean household) {
        this.household = household;
    }


    /**
     * Gets the label value for this CustomObject.
     * 
     * @return label
     */
    public java.lang.String getLabel() {
        return label;
    }


    /**
     * Sets the label value for this CustomObject.
     * 
     * @param label
     */
    public void setLabel(java.lang.String label) {
        this.label = label;
    }


    /**
     * Gets the listViews value for this CustomObject.
     * 
     * @return listViews
     */
    public com.sforce.soap._2006._04.metadata.ListView[] getListViews() {
        return listViews;
    }


    /**
     * Sets the listViews value for this CustomObject.
     * 
     * @param listViews
     */
    public void setListViews(com.sforce.soap._2006._04.metadata.ListView[] listViews) {
        this.listViews = listViews;
    }

    public com.sforce.soap._2006._04.metadata.ListView getListViews(int i) {
        return this.listViews[i];
    }

    public void setListViews(int i, com.sforce.soap._2006._04.metadata.ListView _value) {
        this.listViews[i] = _value;
    }


    /**
     * Gets the nameField value for this CustomObject.
     * 
     * @return nameField
     */
    public com.sforce.soap._2006._04.metadata.CustomField getNameField() {
        return nameField;
    }


    /**
     * Sets the nameField value for this CustomObject.
     * 
     * @param nameField
     */
    public void setNameField(com.sforce.soap._2006._04.metadata.CustomField nameField) {
        this.nameField = nameField;
    }


    /**
     * Gets the pluralLabel value for this CustomObject.
     * 
     * @return pluralLabel
     */
    public java.lang.String getPluralLabel() {
        return pluralLabel;
    }


    /**
     * Sets the pluralLabel value for this CustomObject.
     * 
     * @param pluralLabel
     */
    public void setPluralLabel(java.lang.String pluralLabel) {
        this.pluralLabel = pluralLabel;
    }


    /**
     * Gets the recordTypes value for this CustomObject.
     * 
     * @return recordTypes
     */
    public com.sforce.soap._2006._04.metadata.RecordType[] getRecordTypes() {
        return recordTypes;
    }


    /**
     * Sets the recordTypes value for this CustomObject.
     * 
     * @param recordTypes
     */
    public void setRecordTypes(com.sforce.soap._2006._04.metadata.RecordType[] recordTypes) {
        this.recordTypes = recordTypes;
    }

    public com.sforce.soap._2006._04.metadata.RecordType getRecordTypes(int i) {
        return this.recordTypes[i];
    }

    public void setRecordTypes(int i, com.sforce.soap._2006._04.metadata.RecordType _value) {
        this.recordTypes[i] = _value;
    }


    /**
     * Gets the searchLayouts value for this CustomObject.
     * 
     * @return searchLayouts
     */
    public com.sforce.soap._2006._04.metadata.SearchLayouts getSearchLayouts() {
        return searchLayouts;
    }


    /**
     * Sets the searchLayouts value for this CustomObject.
     * 
     * @param searchLayouts
     */
    public void setSearchLayouts(com.sforce.soap._2006._04.metadata.SearchLayouts searchLayouts) {
        this.searchLayouts = searchLayouts;
    }


    /**
     * Gets the sharingModel value for this CustomObject.
     * 
     * @return sharingModel
     */
    public com.sforce.soap._2006._04.metadata.SharingModel getSharingModel() {
        return sharingModel;
    }


    /**
     * Sets the sharingModel value for this CustomObject.
     * 
     * @param sharingModel
     */
    public void setSharingModel(com.sforce.soap._2006._04.metadata.SharingModel sharingModel) {
        this.sharingModel = sharingModel;
    }


    /**
     * Gets the sharingReasons value for this CustomObject.
     * 
     * @return sharingReasons
     */
    public com.sforce.soap._2006._04.metadata.SharingReason[] getSharingReasons() {
        return sharingReasons;
    }


    /**
     * Sets the sharingReasons value for this CustomObject.
     * 
     * @param sharingReasons
     */
    public void setSharingReasons(com.sforce.soap._2006._04.metadata.SharingReason[] sharingReasons) {
        this.sharingReasons = sharingReasons;
    }

    public com.sforce.soap._2006._04.metadata.SharingReason getSharingReasons(int i) {
        return this.sharingReasons[i];
    }

    public void setSharingReasons(int i, com.sforce.soap._2006._04.metadata.SharingReason _value) {
        this.sharingReasons[i] = _value;
    }


    /**
     * Gets the sharingRecalculations value for this CustomObject.
     * 
     * @return sharingRecalculations
     */
    public com.sforce.soap._2006._04.metadata.SharingRecalculation[] getSharingRecalculations() {
        return sharingRecalculations;
    }


    /**
     * Sets the sharingRecalculations value for this CustomObject.
     * 
     * @param sharingRecalculations
     */
    public void setSharingRecalculations(com.sforce.soap._2006._04.metadata.SharingRecalculation[] sharingRecalculations) {
        this.sharingRecalculations = sharingRecalculations;
    }

    public com.sforce.soap._2006._04.metadata.SharingRecalculation getSharingRecalculations(int i) {
        return this.sharingRecalculations[i];
    }

    public void setSharingRecalculations(int i, com.sforce.soap._2006._04.metadata.SharingRecalculation _value) {
        this.sharingRecalculations[i] = _value;
    }


    /**
     * Gets the startsWith value for this CustomObject.
     * 
     * @return startsWith
     */
    public com.sforce.soap._2006._04.metadata.StartsWith getStartsWith() {
        return startsWith;
    }


    /**
     * Sets the startsWith value for this CustomObject.
     * 
     * @param startsWith
     */
    public void setStartsWith(com.sforce.soap._2006._04.metadata.StartsWith startsWith) {
        this.startsWith = startsWith;
    }


    /**
     * Gets the validationRules value for this CustomObject.
     * 
     * @return validationRules
     */
    public com.sforce.soap._2006._04.metadata.ValidationRule[] getValidationRules() {
        return validationRules;
    }


    /**
     * Sets the validationRules value for this CustomObject.
     * 
     * @param validationRules
     */
    public void setValidationRules(com.sforce.soap._2006._04.metadata.ValidationRule[] validationRules) {
        this.validationRules = validationRules;
    }

    public com.sforce.soap._2006._04.metadata.ValidationRule getValidationRules(int i) {
        return this.validationRules[i];
    }

    public void setValidationRules(int i, com.sforce.soap._2006._04.metadata.ValidationRule _value) {
        this.validationRules[i] = _value;
    }


    /**
     * Gets the webLinks value for this CustomObject.
     * 
     * @return webLinks
     */
    public com.sforce.soap._2006._04.metadata.WebLink[] getWebLinks() {
        return webLinks;
    }


    /**
     * Sets the webLinks value for this CustomObject.
     * 
     * @param webLinks
     */
    public void setWebLinks(com.sforce.soap._2006._04.metadata.WebLink[] webLinks) {
        this.webLinks = webLinks;
    }

    public com.sforce.soap._2006._04.metadata.WebLink getWebLinks(int i) {
        return this.webLinks[i];
    }

    public void setWebLinks(int i, com.sforce.soap._2006._04.metadata.WebLink _value) {
        this.webLinks[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CustomObject)) return false;
        CustomObject other = (CustomObject) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.customHelp==null && other.getCustomHelp()==null) || 
             (this.customHelp!=null &&
              this.customHelp.equals(other.getCustomHelp()))) &&
            ((this.customSettingsType==null && other.getCustomSettingsType()==null) || 
             (this.customSettingsType!=null &&
              this.customSettingsType.equals(other.getCustomSettingsType()))) &&
            ((this.deploymentStatus==null && other.getDeploymentStatus()==null) || 
             (this.deploymentStatus!=null &&
              this.deploymentStatus.equals(other.getDeploymentStatus()))) &&
            ((this.description==null && other.getDescription()==null) || 
             (this.description!=null &&
              this.description.equals(other.getDescription()))) &&
            ((this.enableActivities==null && other.getEnableActivities()==null) || 
             (this.enableActivities!=null &&
              this.enableActivities.equals(other.getEnableActivities()))) &&
            ((this.enableDivisions==null && other.getEnableDivisions()==null) || 
             (this.enableDivisions!=null &&
              this.enableDivisions.equals(other.getEnableDivisions()))) &&
            ((this.enableEnhancedLookup==null && other.getEnableEnhancedLookup()==null) || 
             (this.enableEnhancedLookup!=null &&
              this.enableEnhancedLookup.equals(other.getEnableEnhancedLookup()))) &&
            ((this.enableHistory==null && other.getEnableHistory()==null) || 
             (this.enableHistory!=null &&
              this.enableHistory.equals(other.getEnableHistory()))) &&
            ((this.enableReports==null && other.getEnableReports()==null) || 
             (this.enableReports!=null &&
              this.enableReports.equals(other.getEnableReports()))) &&
            ((this.fields==null && other.getFields()==null) || 
             (this.fields!=null &&
              java.util.Arrays.equals(this.fields, other.getFields()))) &&
            ((this.gender==null && other.getGender()==null) || 
             (this.gender!=null &&
              this.gender.equals(other.getGender()))) &&
            ((this.household==null && other.getHousehold()==null) || 
             (this.household!=null &&
              this.household.equals(other.getHousehold()))) &&
            ((this.label==null && other.getLabel()==null) || 
             (this.label!=null &&
              this.label.equals(other.getLabel()))) &&
            ((this.listViews==null && other.getListViews()==null) || 
             (this.listViews!=null &&
              java.util.Arrays.equals(this.listViews, other.getListViews()))) &&
            ((this.nameField==null && other.getNameField()==null) || 
             (this.nameField!=null &&
              this.nameField.equals(other.getNameField()))) &&
            ((this.pluralLabel==null && other.getPluralLabel()==null) || 
             (this.pluralLabel!=null &&
              this.pluralLabel.equals(other.getPluralLabel()))) &&
            ((this.recordTypes==null && other.getRecordTypes()==null) || 
             (this.recordTypes!=null &&
              java.util.Arrays.equals(this.recordTypes, other.getRecordTypes()))) &&
            ((this.searchLayouts==null && other.getSearchLayouts()==null) || 
             (this.searchLayouts!=null &&
              this.searchLayouts.equals(other.getSearchLayouts()))) &&
            ((this.sharingModel==null && other.getSharingModel()==null) || 
             (this.sharingModel!=null &&
              this.sharingModel.equals(other.getSharingModel()))) &&
            ((this.sharingReasons==null && other.getSharingReasons()==null) || 
             (this.sharingReasons!=null &&
              java.util.Arrays.equals(this.sharingReasons, other.getSharingReasons()))) &&
            ((this.sharingRecalculations==null && other.getSharingRecalculations()==null) || 
             (this.sharingRecalculations!=null &&
              java.util.Arrays.equals(this.sharingRecalculations, other.getSharingRecalculations()))) &&
            ((this.startsWith==null && other.getStartsWith()==null) || 
             (this.startsWith!=null &&
              this.startsWith.equals(other.getStartsWith()))) &&
            ((this.validationRules==null && other.getValidationRules()==null) || 
             (this.validationRules!=null &&
              java.util.Arrays.equals(this.validationRules, other.getValidationRules()))) &&
            ((this.webLinks==null && other.getWebLinks()==null) || 
             (this.webLinks!=null &&
              java.util.Arrays.equals(this.webLinks, other.getWebLinks())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = super.hashCode();
        if (getCustomHelp() != null) {
            _hashCode += getCustomHelp().hashCode();
        }
        if (getCustomSettingsType() != null) {
            _hashCode += getCustomSettingsType().hashCode();
        }
        if (getDeploymentStatus() != null) {
            _hashCode += getDeploymentStatus().hashCode();
        }
        if (getDescription() != null) {
            _hashCode += getDescription().hashCode();
        }
        if (getEnableActivities() != null) {
            _hashCode += getEnableActivities().hashCode();
        }
        if (getEnableDivisions() != null) {
            _hashCode += getEnableDivisions().hashCode();
        }
        if (getEnableEnhancedLookup() != null) {
            _hashCode += getEnableEnhancedLookup().hashCode();
        }
        if (getEnableHistory() != null) {
            _hashCode += getEnableHistory().hashCode();
        }
        if (getEnableReports() != null) {
            _hashCode += getEnableReports().hashCode();
        }
        if (getFields() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getFields());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getFields(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getGender() != null) {
            _hashCode += getGender().hashCode();
        }
        if (getHousehold() != null) {
            _hashCode += getHousehold().hashCode();
        }
        if (getLabel() != null) {
            _hashCode += getLabel().hashCode();
        }
        if (getListViews() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getListViews());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getListViews(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getNameField() != null) {
            _hashCode += getNameField().hashCode();
        }
        if (getPluralLabel() != null) {
            _hashCode += getPluralLabel().hashCode();
        }
        if (getRecordTypes() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getRecordTypes());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getRecordTypes(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getSearchLayouts() != null) {
            _hashCode += getSearchLayouts().hashCode();
        }
        if (getSharingModel() != null) {
            _hashCode += getSharingModel().hashCode();
        }
        if (getSharingReasons() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getSharingReasons());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getSharingReasons(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getSharingRecalculations() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getSharingRecalculations());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getSharingRecalculations(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getStartsWith() != null) {
            _hashCode += getStartsWith().hashCode();
        }
        if (getValidationRules() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getValidationRules());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getValidationRules(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getWebLinks() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getWebLinks());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getWebLinks(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CustomObject.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "CustomObject"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("customHelp");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "customHelp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("customSettingsType");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "customSettingsType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "CustomSettingsType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("deploymentStatus");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "deploymentStatus"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "DeploymentStatus"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("description");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "description"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("enableActivities");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "enableActivities"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("enableDivisions");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "enableDivisions"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("enableEnhancedLookup");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "enableEnhancedLookup"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("enableHistory");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "enableHistory"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("enableReports");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "enableReports"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fields");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "fields"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "CustomField"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("gender");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "gender"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "Gender"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("household");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "household"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("label");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "label"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("listViews");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "listViews"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "ListView"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nameField");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "nameField"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "CustomField"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pluralLabel");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "pluralLabel"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("recordTypes");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "recordTypes"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "RecordType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("searchLayouts");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "searchLayouts"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "SearchLayouts"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sharingModel");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "sharingModel"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "SharingModel"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sharingReasons");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "sharingReasons"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "SharingReason"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sharingRecalculations");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "sharingRecalculations"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "SharingRecalculation"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("startsWith");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "startsWith"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "StartsWith"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("validationRules");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "validationRules"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "ValidationRule"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("webLinks");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "webLinks"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "WebLink"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
