/**
 * ReportGrouping.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.sforce.soap._2006._04.metadata;

public class ReportGrouping  implements java.io.Serializable {
    private com.sforce.soap._2006._04.metadata.UserDateGranularity dateGranularity;

    private java.lang.String field;

    private com.sforce.soap._2006._04.metadata.SortOrder sortOrder;

    public ReportGrouping() {
    }

    public ReportGrouping(
           com.sforce.soap._2006._04.metadata.UserDateGranularity dateGranularity,
           java.lang.String field,
           com.sforce.soap._2006._04.metadata.SortOrder sortOrder) {
           this.dateGranularity = dateGranularity;
           this.field = field;
           this.sortOrder = sortOrder;
    }


    /**
     * Gets the dateGranularity value for this ReportGrouping.
     * 
     * @return dateGranularity
     */
    public com.sforce.soap._2006._04.metadata.UserDateGranularity getDateGranularity() {
        return dateGranularity;
    }


    /**
     * Sets the dateGranularity value for this ReportGrouping.
     * 
     * @param dateGranularity
     */
    public void setDateGranularity(com.sforce.soap._2006._04.metadata.UserDateGranularity dateGranularity) {
        this.dateGranularity = dateGranularity;
    }


    /**
     * Gets the field value for this ReportGrouping.
     * 
     * @return field
     */
    public java.lang.String getField() {
        return field;
    }


    /**
     * Sets the field value for this ReportGrouping.
     * 
     * @param field
     */
    public void setField(java.lang.String field) {
        this.field = field;
    }


    /**
     * Gets the sortOrder value for this ReportGrouping.
     * 
     * @return sortOrder
     */
    public com.sforce.soap._2006._04.metadata.SortOrder getSortOrder() {
        return sortOrder;
    }


    /**
     * Sets the sortOrder value for this ReportGrouping.
     * 
     * @param sortOrder
     */
    public void setSortOrder(com.sforce.soap._2006._04.metadata.SortOrder sortOrder) {
        this.sortOrder = sortOrder;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ReportGrouping)) return false;
        ReportGrouping other = (ReportGrouping) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.dateGranularity==null && other.getDateGranularity()==null) || 
             (this.dateGranularity!=null &&
              this.dateGranularity.equals(other.getDateGranularity()))) &&
            ((this.field==null && other.getField()==null) || 
             (this.field!=null &&
              this.field.equals(other.getField()))) &&
            ((this.sortOrder==null && other.getSortOrder()==null) || 
             (this.sortOrder!=null &&
              this.sortOrder.equals(other.getSortOrder())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getDateGranularity() != null) {
            _hashCode += getDateGranularity().hashCode();
        }
        if (getField() != null) {
            _hashCode += getField().hashCode();
        }
        if (getSortOrder() != null) {
            _hashCode += getSortOrder().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ReportGrouping.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "ReportGrouping"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dateGranularity");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "dateGranularity"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "UserDateGranularity"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("field");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "field"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sortOrder");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "sortOrder"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "SortOrder"));
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
