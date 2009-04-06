/**
 * Profile.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.sforce.soap._2006._04.metadata;

public class Profile  extends com.sforce.soap._2006._04.metadata.Metadata  implements java.io.Serializable {
    private com.sforce.soap._2006._04.metadata.ProfileApplicationVisibility[] applicationVisibilities;

    private com.sforce.soap._2006._04.metadata.ProfileApexClassAccess[] classAccesses;

    private com.sforce.soap._2006._04.metadata.ProfileFieldLevelSecurity[] fieldLevelSecurities;

    private com.sforce.soap._2006._04.metadata.ProfileLayoutAssignment[] layoutAssignments;

    private com.sforce.soap._2006._04.metadata.ProfileObjectPermissions[] objectPermissions;

    private com.sforce.soap._2006._04.metadata.ProfileApexPageAccess[] pageAccesses;

    private com.sforce.soap._2006._04.metadata.ProfileRecordTypeVisibility[] recordTypeVisibilities;

    private com.sforce.soap._2006._04.metadata.ProfileTabVisibility[] tabVisibilities;

    public Profile() {
    }

    public Profile(
           java.lang.String fullName,
           com.sforce.soap._2006._04.metadata.ProfileApplicationVisibility[] applicationVisibilities,
           com.sforce.soap._2006._04.metadata.ProfileApexClassAccess[] classAccesses,
           com.sforce.soap._2006._04.metadata.ProfileFieldLevelSecurity[] fieldLevelSecurities,
           com.sforce.soap._2006._04.metadata.ProfileLayoutAssignment[] layoutAssignments,
           com.sforce.soap._2006._04.metadata.ProfileObjectPermissions[] objectPermissions,
           com.sforce.soap._2006._04.metadata.ProfileApexPageAccess[] pageAccesses,
           com.sforce.soap._2006._04.metadata.ProfileRecordTypeVisibility[] recordTypeVisibilities,
           com.sforce.soap._2006._04.metadata.ProfileTabVisibility[] tabVisibilities) {
        super(
            fullName);
        this.applicationVisibilities = applicationVisibilities;
        this.classAccesses = classAccesses;
        this.fieldLevelSecurities = fieldLevelSecurities;
        this.layoutAssignments = layoutAssignments;
        this.objectPermissions = objectPermissions;
        this.pageAccesses = pageAccesses;
        this.recordTypeVisibilities = recordTypeVisibilities;
        this.tabVisibilities = tabVisibilities;
    }


    /**
     * Gets the applicationVisibilities value for this Profile.
     * 
     * @return applicationVisibilities
     */
    public com.sforce.soap._2006._04.metadata.ProfileApplicationVisibility[] getApplicationVisibilities() {
        return applicationVisibilities;
    }


    /**
     * Sets the applicationVisibilities value for this Profile.
     * 
     * @param applicationVisibilities
     */
    public void setApplicationVisibilities(com.sforce.soap._2006._04.metadata.ProfileApplicationVisibility[] applicationVisibilities) {
        this.applicationVisibilities = applicationVisibilities;
    }

    public com.sforce.soap._2006._04.metadata.ProfileApplicationVisibility getApplicationVisibilities(int i) {
        return this.applicationVisibilities[i];
    }

    public void setApplicationVisibilities(int i, com.sforce.soap._2006._04.metadata.ProfileApplicationVisibility _value) {
        this.applicationVisibilities[i] = _value;
    }


    /**
     * Gets the classAccesses value for this Profile.
     * 
     * @return classAccesses
     */
    public com.sforce.soap._2006._04.metadata.ProfileApexClassAccess[] getClassAccesses() {
        return classAccesses;
    }


    /**
     * Sets the classAccesses value for this Profile.
     * 
     * @param classAccesses
     */
    public void setClassAccesses(com.sforce.soap._2006._04.metadata.ProfileApexClassAccess[] classAccesses) {
        this.classAccesses = classAccesses;
    }

    public com.sforce.soap._2006._04.metadata.ProfileApexClassAccess getClassAccesses(int i) {
        return this.classAccesses[i];
    }

    public void setClassAccesses(int i, com.sforce.soap._2006._04.metadata.ProfileApexClassAccess _value) {
        this.classAccesses[i] = _value;
    }


    /**
     * Gets the fieldLevelSecurities value for this Profile.
     * 
     * @return fieldLevelSecurities
     */
    public com.sforce.soap._2006._04.metadata.ProfileFieldLevelSecurity[] getFieldLevelSecurities() {
        return fieldLevelSecurities;
    }


    /**
     * Sets the fieldLevelSecurities value for this Profile.
     * 
     * @param fieldLevelSecurities
     */
    public void setFieldLevelSecurities(com.sforce.soap._2006._04.metadata.ProfileFieldLevelSecurity[] fieldLevelSecurities) {
        this.fieldLevelSecurities = fieldLevelSecurities;
    }

    public com.sforce.soap._2006._04.metadata.ProfileFieldLevelSecurity getFieldLevelSecurities(int i) {
        return this.fieldLevelSecurities[i];
    }

    public void setFieldLevelSecurities(int i, com.sforce.soap._2006._04.metadata.ProfileFieldLevelSecurity _value) {
        this.fieldLevelSecurities[i] = _value;
    }


    /**
     * Gets the layoutAssignments value for this Profile.
     * 
     * @return layoutAssignments
     */
    public com.sforce.soap._2006._04.metadata.ProfileLayoutAssignment[] getLayoutAssignments() {
        return layoutAssignments;
    }


    /**
     * Sets the layoutAssignments value for this Profile.
     * 
     * @param layoutAssignments
     */
    public void setLayoutAssignments(com.sforce.soap._2006._04.metadata.ProfileLayoutAssignment[] layoutAssignments) {
        this.layoutAssignments = layoutAssignments;
    }

    public com.sforce.soap._2006._04.metadata.ProfileLayoutAssignment getLayoutAssignments(int i) {
        return this.layoutAssignments[i];
    }

    public void setLayoutAssignments(int i, com.sforce.soap._2006._04.metadata.ProfileLayoutAssignment _value) {
        this.layoutAssignments[i] = _value;
    }


    /**
     * Gets the objectPermissions value for this Profile.
     * 
     * @return objectPermissions
     */
    public com.sforce.soap._2006._04.metadata.ProfileObjectPermissions[] getObjectPermissions() {
        return objectPermissions;
    }


    /**
     * Sets the objectPermissions value for this Profile.
     * 
     * @param objectPermissions
     */
    public void setObjectPermissions(com.sforce.soap._2006._04.metadata.ProfileObjectPermissions[] objectPermissions) {
        this.objectPermissions = objectPermissions;
    }

    public com.sforce.soap._2006._04.metadata.ProfileObjectPermissions getObjectPermissions(int i) {
        return this.objectPermissions[i];
    }

    public void setObjectPermissions(int i, com.sforce.soap._2006._04.metadata.ProfileObjectPermissions _value) {
        this.objectPermissions[i] = _value;
    }


    /**
     * Gets the pageAccesses value for this Profile.
     * 
     * @return pageAccesses
     */
    public com.sforce.soap._2006._04.metadata.ProfileApexPageAccess[] getPageAccesses() {
        return pageAccesses;
    }


    /**
     * Sets the pageAccesses value for this Profile.
     * 
     * @param pageAccesses
     */
    public void setPageAccesses(com.sforce.soap._2006._04.metadata.ProfileApexPageAccess[] pageAccesses) {
        this.pageAccesses = pageAccesses;
    }

    public com.sforce.soap._2006._04.metadata.ProfileApexPageAccess getPageAccesses(int i) {
        return this.pageAccesses[i];
    }

    public void setPageAccesses(int i, com.sforce.soap._2006._04.metadata.ProfileApexPageAccess _value) {
        this.pageAccesses[i] = _value;
    }


    /**
     * Gets the recordTypeVisibilities value for this Profile.
     * 
     * @return recordTypeVisibilities
     */
    public com.sforce.soap._2006._04.metadata.ProfileRecordTypeVisibility[] getRecordTypeVisibilities() {
        return recordTypeVisibilities;
    }


    /**
     * Sets the recordTypeVisibilities value for this Profile.
     * 
     * @param recordTypeVisibilities
     */
    public void setRecordTypeVisibilities(com.sforce.soap._2006._04.metadata.ProfileRecordTypeVisibility[] recordTypeVisibilities) {
        this.recordTypeVisibilities = recordTypeVisibilities;
    }

    public com.sforce.soap._2006._04.metadata.ProfileRecordTypeVisibility getRecordTypeVisibilities(int i) {
        return this.recordTypeVisibilities[i];
    }

    public void setRecordTypeVisibilities(int i, com.sforce.soap._2006._04.metadata.ProfileRecordTypeVisibility _value) {
        this.recordTypeVisibilities[i] = _value;
    }


    /**
     * Gets the tabVisibilities value for this Profile.
     * 
     * @return tabVisibilities
     */
    public com.sforce.soap._2006._04.metadata.ProfileTabVisibility[] getTabVisibilities() {
        return tabVisibilities;
    }


    /**
     * Sets the tabVisibilities value for this Profile.
     * 
     * @param tabVisibilities
     */
    public void setTabVisibilities(com.sforce.soap._2006._04.metadata.ProfileTabVisibility[] tabVisibilities) {
        this.tabVisibilities = tabVisibilities;
    }

    public com.sforce.soap._2006._04.metadata.ProfileTabVisibility getTabVisibilities(int i) {
        return this.tabVisibilities[i];
    }

    public void setTabVisibilities(int i, com.sforce.soap._2006._04.metadata.ProfileTabVisibility _value) {
        this.tabVisibilities[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Profile)) return false;
        Profile other = (Profile) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.applicationVisibilities==null && other.getApplicationVisibilities()==null) || 
             (this.applicationVisibilities!=null &&
              java.util.Arrays.equals(this.applicationVisibilities, other.getApplicationVisibilities()))) &&
            ((this.classAccesses==null && other.getClassAccesses()==null) || 
             (this.classAccesses!=null &&
              java.util.Arrays.equals(this.classAccesses, other.getClassAccesses()))) &&
            ((this.fieldLevelSecurities==null && other.getFieldLevelSecurities()==null) || 
             (this.fieldLevelSecurities!=null &&
              java.util.Arrays.equals(this.fieldLevelSecurities, other.getFieldLevelSecurities()))) &&
            ((this.layoutAssignments==null && other.getLayoutAssignments()==null) || 
             (this.layoutAssignments!=null &&
              java.util.Arrays.equals(this.layoutAssignments, other.getLayoutAssignments()))) &&
            ((this.objectPermissions==null && other.getObjectPermissions()==null) || 
             (this.objectPermissions!=null &&
              java.util.Arrays.equals(this.objectPermissions, other.getObjectPermissions()))) &&
            ((this.pageAccesses==null && other.getPageAccesses()==null) || 
             (this.pageAccesses!=null &&
              java.util.Arrays.equals(this.pageAccesses, other.getPageAccesses()))) &&
            ((this.recordTypeVisibilities==null && other.getRecordTypeVisibilities()==null) || 
             (this.recordTypeVisibilities!=null &&
              java.util.Arrays.equals(this.recordTypeVisibilities, other.getRecordTypeVisibilities()))) &&
            ((this.tabVisibilities==null && other.getTabVisibilities()==null) || 
             (this.tabVisibilities!=null &&
              java.util.Arrays.equals(this.tabVisibilities, other.getTabVisibilities())));
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
        if (getApplicationVisibilities() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getApplicationVisibilities());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getApplicationVisibilities(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getClassAccesses() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getClassAccesses());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getClassAccesses(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getFieldLevelSecurities() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getFieldLevelSecurities());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getFieldLevelSecurities(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getLayoutAssignments() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getLayoutAssignments());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getLayoutAssignments(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getObjectPermissions() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getObjectPermissions());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getObjectPermissions(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getPageAccesses() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPageAccesses());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPageAccesses(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getRecordTypeVisibilities() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getRecordTypeVisibilities());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getRecordTypeVisibilities(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getTabVisibilities() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getTabVisibilities());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getTabVisibilities(), i);
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
        new org.apache.axis.description.TypeDesc(Profile.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "Profile"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("applicationVisibilities");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "applicationVisibilities"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "ProfileApplicationVisibility"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("classAccesses");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "classAccesses"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "ProfileApexClassAccess"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fieldLevelSecurities");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "fieldLevelSecurities"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "ProfileFieldLevelSecurity"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("layoutAssignments");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "layoutAssignments"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "ProfileLayoutAssignment"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("objectPermissions");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "objectPermissions"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "ProfileObjectPermissions"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pageAccesses");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "pageAccesses"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "ProfileApexPageAccess"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("recordTypeVisibilities");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "recordTypeVisibilities"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "ProfileRecordTypeVisibility"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tabVisibilities");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "tabVisibilities"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "ProfileTabVisibility"));
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
