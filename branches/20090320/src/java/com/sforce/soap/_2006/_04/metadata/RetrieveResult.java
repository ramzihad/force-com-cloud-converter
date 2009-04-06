/**
 * RetrieveResult.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.sforce.soap._2006._04.metadata;

public class RetrieveResult  implements java.io.Serializable {
    private com.sforce.soap._2006._04.metadata.FileProperties[] fileProperties;

    private java.lang.String id;

    private com.sforce.soap._2006._04.metadata.RetrieveMessage[] messages;

    private byte[] zipFile;

    public RetrieveResult() {
    }

    public RetrieveResult(
           com.sforce.soap._2006._04.metadata.FileProperties[] fileProperties,
           java.lang.String id,
           com.sforce.soap._2006._04.metadata.RetrieveMessage[] messages,
           byte[] zipFile) {
           this.fileProperties = fileProperties;
           this.id = id;
           this.messages = messages;
           this.zipFile = zipFile;
    }


    /**
     * Gets the fileProperties value for this RetrieveResult.
     * 
     * @return fileProperties
     */
    public com.sforce.soap._2006._04.metadata.FileProperties[] getFileProperties() {
        return fileProperties;
    }


    /**
     * Sets the fileProperties value for this RetrieveResult.
     * 
     * @param fileProperties
     */
    public void setFileProperties(com.sforce.soap._2006._04.metadata.FileProperties[] fileProperties) {
        this.fileProperties = fileProperties;
    }

    public com.sforce.soap._2006._04.metadata.FileProperties getFileProperties(int i) {
        return this.fileProperties[i];
    }

    public void setFileProperties(int i, com.sforce.soap._2006._04.metadata.FileProperties _value) {
        this.fileProperties[i] = _value;
    }


    /**
     * Gets the id value for this RetrieveResult.
     * 
     * @return id
     */
    public java.lang.String getId() {
        return id;
    }


    /**
     * Sets the id value for this RetrieveResult.
     * 
     * @param id
     */
    public void setId(java.lang.String id) {
        this.id = id;
    }


    /**
     * Gets the messages value for this RetrieveResult.
     * 
     * @return messages
     */
    public com.sforce.soap._2006._04.metadata.RetrieveMessage[] getMessages() {
        return messages;
    }


    /**
     * Sets the messages value for this RetrieveResult.
     * 
     * @param messages
     */
    public void setMessages(com.sforce.soap._2006._04.metadata.RetrieveMessage[] messages) {
        this.messages = messages;
    }

    public com.sforce.soap._2006._04.metadata.RetrieveMessage getMessages(int i) {
        return this.messages[i];
    }

    public void setMessages(int i, com.sforce.soap._2006._04.metadata.RetrieveMessage _value) {
        this.messages[i] = _value;
    }


    /**
     * Gets the zipFile value for this RetrieveResult.
     * 
     * @return zipFile
     */
    public byte[] getZipFile() {
        return zipFile;
    }


    /**
     * Sets the zipFile value for this RetrieveResult.
     * 
     * @param zipFile
     */
    public void setZipFile(byte[] zipFile) {
        this.zipFile = zipFile;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof RetrieveResult)) return false;
        RetrieveResult other = (RetrieveResult) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.fileProperties==null && other.getFileProperties()==null) || 
             (this.fileProperties!=null &&
              java.util.Arrays.equals(this.fileProperties, other.getFileProperties()))) &&
            ((this.id==null && other.getId()==null) || 
             (this.id!=null &&
              this.id.equals(other.getId()))) &&
            ((this.messages==null && other.getMessages()==null) || 
             (this.messages!=null &&
              java.util.Arrays.equals(this.messages, other.getMessages()))) &&
            ((this.zipFile==null && other.getZipFile()==null) || 
             (this.zipFile!=null &&
              java.util.Arrays.equals(this.zipFile, other.getZipFile())));
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
        if (getFileProperties() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getFileProperties());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getFileProperties(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getId() != null) {
            _hashCode += getId().hashCode();
        }
        if (getMessages() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getMessages());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getMessages(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getZipFile() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getZipFile());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getZipFile(), i);
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
        new org.apache.axis.description.TypeDesc(RetrieveResult.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "RetrieveResult"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fileProperties");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "fileProperties"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "FileProperties"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("messages");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "messages"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "RetrieveMessage"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("zipFile");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "zipFile"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "base64Binary"));
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
