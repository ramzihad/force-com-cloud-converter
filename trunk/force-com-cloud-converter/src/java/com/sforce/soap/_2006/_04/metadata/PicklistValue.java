/**
 * PicklistValue.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.sforce.soap._2006._04.metadata;

public class PicklistValue  extends com.sforce.soap._2006._04.metadata.Metadata  implements java.io.Serializable {
    private java.lang.String[] controllingFieldValues;

    private boolean _default;

    public PicklistValue() {
    }

    public PicklistValue(
           java.lang.String fullName,
           java.lang.String[] controllingFieldValues,
           boolean _default) {
        super(
            fullName);
        this.controllingFieldValues = controllingFieldValues;
        this._default = _default;
    }


    /**
     * Gets the controllingFieldValues value for this PicklistValue.
     * 
     * @return controllingFieldValues
     */
    public java.lang.String[] getControllingFieldValues() {
        return controllingFieldValues;
    }


    /**
     * Sets the controllingFieldValues value for this PicklistValue.
     * 
     * @param controllingFieldValues
     */
    public void setControllingFieldValues(java.lang.String[] controllingFieldValues) {
        this.controllingFieldValues = controllingFieldValues;
    }

    public java.lang.String getControllingFieldValues(int i) {
        return this.controllingFieldValues[i];
    }

    public void setControllingFieldValues(int i, java.lang.String _value) {
        this.controllingFieldValues[i] = _value;
    }


    /**
     * Gets the _default value for this PicklistValue.
     * 
     * @return _default
     */
    public boolean is_default() {
        return _default;
    }


    /**
     * Sets the _default value for this PicklistValue.
     * 
     * @param _default
     */
    public void set_default(boolean _default) {
        this._default = _default;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PicklistValue)) return false;
        PicklistValue other = (PicklistValue) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.controllingFieldValues==null && other.getControllingFieldValues()==null) || 
             (this.controllingFieldValues!=null &&
              java.util.Arrays.equals(this.controllingFieldValues, other.getControllingFieldValues()))) &&
            this._default == other.is_default();
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
        if (getControllingFieldValues() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getControllingFieldValues());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getControllingFieldValues(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        _hashCode += (is_default() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PicklistValue.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "PicklistValue"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("controllingFieldValues");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "controllingFieldValues"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("_default");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "default"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
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
