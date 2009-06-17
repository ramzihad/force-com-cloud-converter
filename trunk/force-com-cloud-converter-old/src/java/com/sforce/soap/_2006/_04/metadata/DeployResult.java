/**
 * DeployResult.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.sforce.soap._2006._04.metadata;

public class DeployResult  implements java.io.Serializable {
    private java.lang.String id;

    private com.sforce.soap._2006._04.metadata.DeployMessage[] messages;

    private com.sforce.soap._2006._04.metadata.RetrieveResult retrieveResult;

    private com.sforce.soap._2006._04.metadata.RunTestsResult runTestResult;

    private boolean success;

    public DeployResult() {
    }

    public DeployResult(
           java.lang.String id,
           com.sforce.soap._2006._04.metadata.DeployMessage[] messages,
           com.sforce.soap._2006._04.metadata.RetrieveResult retrieveResult,
           com.sforce.soap._2006._04.metadata.RunTestsResult runTestResult,
           boolean success) {
           this.id = id;
           this.messages = messages;
           this.retrieveResult = retrieveResult;
           this.runTestResult = runTestResult;
           this.success = success;
    }


    /**
     * Gets the id value for this DeployResult.
     * 
     * @return id
     */
    public java.lang.String getId() {
        return id;
    }


    /**
     * Sets the id value for this DeployResult.
     * 
     * @param id
     */
    public void setId(java.lang.String id) {
        this.id = id;
    }


    /**
     * Gets the messages value for this DeployResult.
     * 
     * @return messages
     */
    public com.sforce.soap._2006._04.metadata.DeployMessage[] getMessages() {
        return messages;
    }


    /**
     * Sets the messages value for this DeployResult.
     * 
     * @param messages
     */
    public void setMessages(com.sforce.soap._2006._04.metadata.DeployMessage[] messages) {
        this.messages = messages;
    }

    public com.sforce.soap._2006._04.metadata.DeployMessage getMessages(int i) {
        return this.messages[i];
    }

    public void setMessages(int i, com.sforce.soap._2006._04.metadata.DeployMessage _value) {
        this.messages[i] = _value;
    }


    /**
     * Gets the retrieveResult value for this DeployResult.
     * 
     * @return retrieveResult
     */
    public com.sforce.soap._2006._04.metadata.RetrieveResult getRetrieveResult() {
        return retrieveResult;
    }


    /**
     * Sets the retrieveResult value for this DeployResult.
     * 
     * @param retrieveResult
     */
    public void setRetrieveResult(com.sforce.soap._2006._04.metadata.RetrieveResult retrieveResult) {
        this.retrieveResult = retrieveResult;
    }


    /**
     * Gets the runTestResult value for this DeployResult.
     * 
     * @return runTestResult
     */
    public com.sforce.soap._2006._04.metadata.RunTestsResult getRunTestResult() {
        return runTestResult;
    }


    /**
     * Sets the runTestResult value for this DeployResult.
     * 
     * @param runTestResult
     */
    public void setRunTestResult(com.sforce.soap._2006._04.metadata.RunTestsResult runTestResult) {
        this.runTestResult = runTestResult;
    }


    /**
     * Gets the success value for this DeployResult.
     * 
     * @return success
     */
    public boolean isSuccess() {
        return success;
    }


    /**
     * Sets the success value for this DeployResult.
     * 
     * @param success
     */
    public void setSuccess(boolean success) {
        this.success = success;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DeployResult)) return false;
        DeployResult other = (DeployResult) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.id==null && other.getId()==null) || 
             (this.id!=null &&
              this.id.equals(other.getId()))) &&
            ((this.messages==null && other.getMessages()==null) || 
             (this.messages!=null &&
              java.util.Arrays.equals(this.messages, other.getMessages()))) &&
            ((this.retrieveResult==null && other.getRetrieveResult()==null) || 
             (this.retrieveResult!=null &&
              this.retrieveResult.equals(other.getRetrieveResult()))) &&
            ((this.runTestResult==null && other.getRunTestResult()==null) || 
             (this.runTestResult!=null &&
              this.runTestResult.equals(other.getRunTestResult()))) &&
            this.success == other.isSuccess();
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
        if (getRetrieveResult() != null) {
            _hashCode += getRetrieveResult().hashCode();
        }
        if (getRunTestResult() != null) {
            _hashCode += getRunTestResult().hashCode();
        }
        _hashCode += (isSuccess() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DeployResult.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "DeployResult"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("messages");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "messages"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "DeployMessage"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("retrieveResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "retrieveResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "RetrieveResult"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("runTestResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "runTestResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "RunTestsResult"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("success");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "success"));
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
