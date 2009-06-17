/**
 * ApexComponent.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.sforce.soap._2006._04.metadata;

public class ApexComponent  extends com.sforce.soap._2006._04.metadata.MetadataWithContent  implements java.io.Serializable {
    private java.lang.Double apiVersion;

    private java.lang.String description;

    private java.lang.String label;

    private com.sforce.soap._2006._04.metadata.PackageVersion[] packageVersions;

    public ApexComponent() {
    }

    public ApexComponent(
           java.lang.String fullName,
           byte[] content,
           java.lang.Double apiVersion,
           java.lang.String description,
           java.lang.String label,
           com.sforce.soap._2006._04.metadata.PackageVersion[] packageVersions) {
        super(
            fullName,
            content);
        this.apiVersion = apiVersion;
        this.description = description;
        this.label = label;
        this.packageVersions = packageVersions;
    }


    /**
     * Gets the apiVersion value for this ApexComponent.
     * 
     * @return apiVersion
     */
    public java.lang.Double getApiVersion() {
        return apiVersion;
    }


    /**
     * Sets the apiVersion value for this ApexComponent.
     * 
     * @param apiVersion
     */
    public void setApiVersion(java.lang.Double apiVersion) {
        this.apiVersion = apiVersion;
    }


    /**
     * Gets the description value for this ApexComponent.
     * 
     * @return description
     */
    public java.lang.String getDescription() {
        return description;
    }


    /**
     * Sets the description value for this ApexComponent.
     * 
     * @param description
     */
    public void setDescription(java.lang.String description) {
        this.description = description;
    }


    /**
     * Gets the label value for this ApexComponent.
     * 
     * @return label
     */
    public java.lang.String getLabel() {
        return label;
    }


    /**
     * Sets the label value for this ApexComponent.
     * 
     * @param label
     */
    public void setLabel(java.lang.String label) {
        this.label = label;
    }


    /**
     * Gets the packageVersions value for this ApexComponent.
     * 
     * @return packageVersions
     */
    public com.sforce.soap._2006._04.metadata.PackageVersion[] getPackageVersions() {
        return packageVersions;
    }


    /**
     * Sets the packageVersions value for this ApexComponent.
     * 
     * @param packageVersions
     */
    public void setPackageVersions(com.sforce.soap._2006._04.metadata.PackageVersion[] packageVersions) {
        this.packageVersions = packageVersions;
    }

    public com.sforce.soap._2006._04.metadata.PackageVersion getPackageVersions(int i) {
        return this.packageVersions[i];
    }

    public void setPackageVersions(int i, com.sforce.soap._2006._04.metadata.PackageVersion _value) {
        this.packageVersions[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ApexComponent)) return false;
        ApexComponent other = (ApexComponent) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.apiVersion==null && other.getApiVersion()==null) || 
             (this.apiVersion!=null &&
              this.apiVersion.equals(other.getApiVersion()))) &&
            ((this.description==null && other.getDescription()==null) || 
             (this.description!=null &&
              this.description.equals(other.getDescription()))) &&
            ((this.label==null && other.getLabel()==null) || 
             (this.label!=null &&
              this.label.equals(other.getLabel()))) &&
            ((this.packageVersions==null && other.getPackageVersions()==null) || 
             (this.packageVersions!=null &&
              java.util.Arrays.equals(this.packageVersions, other.getPackageVersions())));
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
        if (getApiVersion() != null) {
            _hashCode += getApiVersion().hashCode();
        }
        if (getDescription() != null) {
            _hashCode += getDescription().hashCode();
        }
        if (getLabel() != null) {
            _hashCode += getLabel().hashCode();
        }
        if (getPackageVersions() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPackageVersions());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPackageVersions(), i);
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
        new org.apache.axis.description.TypeDesc(ApexComponent.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "ApexComponent"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("apiVersion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "apiVersion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
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
        elemField.setFieldName("label");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "label"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("packageVersions");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "packageVersions"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "PackageVersion"));
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
