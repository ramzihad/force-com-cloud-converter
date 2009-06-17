/**
 * AsyncResult.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.sforce.soap._2006._04.metadata;

public class AsyncResult  implements java.io.Serializable {
    private java.lang.Boolean checkOnly;

    private boolean done;

    private java.lang.String id;

    private java.lang.String message;

    private java.lang.Integer numberComponentErrors;

    private java.lang.Integer numberComponentsDeployed;

    private java.lang.Integer numberComponentsTotal;

    private java.lang.Integer numberTestErrors;

    private java.lang.Integer numberTestsCompleted;

    private java.lang.Integer numberTestsTotal;

    private int secondsToWait;

    private com.sforce.soap._2006._04.metadata.AsyncRequestState state;

    private java.lang.String stateDetail;

    private java.util.Calendar stateDetailLastModifiedDate;

    private com.sforce.soap._2006._04.metadata.StatusCode statusCode;

    public AsyncResult() {
    }

    public AsyncResult(
           java.lang.Boolean checkOnly,
           boolean done,
           java.lang.String id,
           java.lang.String message,
           java.lang.Integer numberComponentErrors,
           java.lang.Integer numberComponentsDeployed,
           java.lang.Integer numberComponentsTotal,
           java.lang.Integer numberTestErrors,
           java.lang.Integer numberTestsCompleted,
           java.lang.Integer numberTestsTotal,
           int secondsToWait,
           com.sforce.soap._2006._04.metadata.AsyncRequestState state,
           java.lang.String stateDetail,
           java.util.Calendar stateDetailLastModifiedDate,
           com.sforce.soap._2006._04.metadata.StatusCode statusCode) {
           this.checkOnly = checkOnly;
           this.done = done;
           this.id = id;
           this.message = message;
           this.numberComponentErrors = numberComponentErrors;
           this.numberComponentsDeployed = numberComponentsDeployed;
           this.numberComponentsTotal = numberComponentsTotal;
           this.numberTestErrors = numberTestErrors;
           this.numberTestsCompleted = numberTestsCompleted;
           this.numberTestsTotal = numberTestsTotal;
           this.secondsToWait = secondsToWait;
           this.state = state;
           this.stateDetail = stateDetail;
           this.stateDetailLastModifiedDate = stateDetailLastModifiedDate;
           this.statusCode = statusCode;
    }


    /**
     * Gets the checkOnly value for this AsyncResult.
     * 
     * @return checkOnly
     */
    public java.lang.Boolean getCheckOnly() {
        return checkOnly;
    }


    /**
     * Sets the checkOnly value for this AsyncResult.
     * 
     * @param checkOnly
     */
    public void setCheckOnly(java.lang.Boolean checkOnly) {
        this.checkOnly = checkOnly;
    }


    /**
     * Gets the done value for this AsyncResult.
     * 
     * @return done
     */
    public boolean isDone() {
        return done;
    }


    /**
     * Sets the done value for this AsyncResult.
     * 
     * @param done
     */
    public void setDone(boolean done) {
        this.done = done;
    }


    /**
     * Gets the id value for this AsyncResult.
     * 
     * @return id
     */
    public java.lang.String getId() {
        return id;
    }


    /**
     * Sets the id value for this AsyncResult.
     * 
     * @param id
     */
    public void setId(java.lang.String id) {
        this.id = id;
    }


    /**
     * Gets the message value for this AsyncResult.
     * 
     * @return message
     */
    public java.lang.String getMessage() {
        return message;
    }


    /**
     * Sets the message value for this AsyncResult.
     * 
     * @param message
     */
    public void setMessage(java.lang.String message) {
        this.message = message;
    }


    /**
     * Gets the numberComponentErrors value for this AsyncResult.
     * 
     * @return numberComponentErrors
     */
    public java.lang.Integer getNumberComponentErrors() {
        return numberComponentErrors;
    }


    /**
     * Sets the numberComponentErrors value for this AsyncResult.
     * 
     * @param numberComponentErrors
     */
    public void setNumberComponentErrors(java.lang.Integer numberComponentErrors) {
        this.numberComponentErrors = numberComponentErrors;
    }


    /**
     * Gets the numberComponentsDeployed value for this AsyncResult.
     * 
     * @return numberComponentsDeployed
     */
    public java.lang.Integer getNumberComponentsDeployed() {
        return numberComponentsDeployed;
    }


    /**
     * Sets the numberComponentsDeployed value for this AsyncResult.
     * 
     * @param numberComponentsDeployed
     */
    public void setNumberComponentsDeployed(java.lang.Integer numberComponentsDeployed) {
        this.numberComponentsDeployed = numberComponentsDeployed;
    }


    /**
     * Gets the numberComponentsTotal value for this AsyncResult.
     * 
     * @return numberComponentsTotal
     */
    public java.lang.Integer getNumberComponentsTotal() {
        return numberComponentsTotal;
    }


    /**
     * Sets the numberComponentsTotal value for this AsyncResult.
     * 
     * @param numberComponentsTotal
     */
    public void setNumberComponentsTotal(java.lang.Integer numberComponentsTotal) {
        this.numberComponentsTotal = numberComponentsTotal;
    }


    /**
     * Gets the numberTestErrors value for this AsyncResult.
     * 
     * @return numberTestErrors
     */
    public java.lang.Integer getNumberTestErrors() {
        return numberTestErrors;
    }


    /**
     * Sets the numberTestErrors value for this AsyncResult.
     * 
     * @param numberTestErrors
     */
    public void setNumberTestErrors(java.lang.Integer numberTestErrors) {
        this.numberTestErrors = numberTestErrors;
    }


    /**
     * Gets the numberTestsCompleted value for this AsyncResult.
     * 
     * @return numberTestsCompleted
     */
    public java.lang.Integer getNumberTestsCompleted() {
        return numberTestsCompleted;
    }


    /**
     * Sets the numberTestsCompleted value for this AsyncResult.
     * 
     * @param numberTestsCompleted
     */
    public void setNumberTestsCompleted(java.lang.Integer numberTestsCompleted) {
        this.numberTestsCompleted = numberTestsCompleted;
    }


    /**
     * Gets the numberTestsTotal value for this AsyncResult.
     * 
     * @return numberTestsTotal
     */
    public java.lang.Integer getNumberTestsTotal() {
        return numberTestsTotal;
    }


    /**
     * Sets the numberTestsTotal value for this AsyncResult.
     * 
     * @param numberTestsTotal
     */
    public void setNumberTestsTotal(java.lang.Integer numberTestsTotal) {
        this.numberTestsTotal = numberTestsTotal;
    }


    /**
     * Gets the secondsToWait value for this AsyncResult.
     * 
     * @return secondsToWait
     */
    public int getSecondsToWait() {
        return secondsToWait;
    }


    /**
     * Sets the secondsToWait value for this AsyncResult.
     * 
     * @param secondsToWait
     */
    public void setSecondsToWait(int secondsToWait) {
        this.secondsToWait = secondsToWait;
    }


    /**
     * Gets the state value for this AsyncResult.
     * 
     * @return state
     */
    public com.sforce.soap._2006._04.metadata.AsyncRequestState getState() {
        return state;
    }


    /**
     * Sets the state value for this AsyncResult.
     * 
     * @param state
     */
    public void setState(com.sforce.soap._2006._04.metadata.AsyncRequestState state) {
        this.state = state;
    }


    /**
     * Gets the stateDetail value for this AsyncResult.
     * 
     * @return stateDetail
     */
    public java.lang.String getStateDetail() {
        return stateDetail;
    }


    /**
     * Sets the stateDetail value for this AsyncResult.
     * 
     * @param stateDetail
     */
    public void setStateDetail(java.lang.String stateDetail) {
        this.stateDetail = stateDetail;
    }


    /**
     * Gets the stateDetailLastModifiedDate value for this AsyncResult.
     * 
     * @return stateDetailLastModifiedDate
     */
    public java.util.Calendar getStateDetailLastModifiedDate() {
        return stateDetailLastModifiedDate;
    }


    /**
     * Sets the stateDetailLastModifiedDate value for this AsyncResult.
     * 
     * @param stateDetailLastModifiedDate
     */
    public void setStateDetailLastModifiedDate(java.util.Calendar stateDetailLastModifiedDate) {
        this.stateDetailLastModifiedDate = stateDetailLastModifiedDate;
    }


    /**
     * Gets the statusCode value for this AsyncResult.
     * 
     * @return statusCode
     */
    public com.sforce.soap._2006._04.metadata.StatusCode getStatusCode() {
        return statusCode;
    }


    /**
     * Sets the statusCode value for this AsyncResult.
     * 
     * @param statusCode
     */
    public void setStatusCode(com.sforce.soap._2006._04.metadata.StatusCode statusCode) {
        this.statusCode = statusCode;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AsyncResult)) return false;
        AsyncResult other = (AsyncResult) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.checkOnly==null && other.getCheckOnly()==null) || 
             (this.checkOnly!=null &&
              this.checkOnly.equals(other.getCheckOnly()))) &&
            this.done == other.isDone() &&
            ((this.id==null && other.getId()==null) || 
             (this.id!=null &&
              this.id.equals(other.getId()))) &&
            ((this.message==null && other.getMessage()==null) || 
             (this.message!=null &&
              this.message.equals(other.getMessage()))) &&
            ((this.numberComponentErrors==null && other.getNumberComponentErrors()==null) || 
             (this.numberComponentErrors!=null &&
              this.numberComponentErrors.equals(other.getNumberComponentErrors()))) &&
            ((this.numberComponentsDeployed==null && other.getNumberComponentsDeployed()==null) || 
             (this.numberComponentsDeployed!=null &&
              this.numberComponentsDeployed.equals(other.getNumberComponentsDeployed()))) &&
            ((this.numberComponentsTotal==null && other.getNumberComponentsTotal()==null) || 
             (this.numberComponentsTotal!=null &&
              this.numberComponentsTotal.equals(other.getNumberComponentsTotal()))) &&
            ((this.numberTestErrors==null && other.getNumberTestErrors()==null) || 
             (this.numberTestErrors!=null &&
              this.numberTestErrors.equals(other.getNumberTestErrors()))) &&
            ((this.numberTestsCompleted==null && other.getNumberTestsCompleted()==null) || 
             (this.numberTestsCompleted!=null &&
              this.numberTestsCompleted.equals(other.getNumberTestsCompleted()))) &&
            ((this.numberTestsTotal==null && other.getNumberTestsTotal()==null) || 
             (this.numberTestsTotal!=null &&
              this.numberTestsTotal.equals(other.getNumberTestsTotal()))) &&
            this.secondsToWait == other.getSecondsToWait() &&
            ((this.state==null && other.getState()==null) || 
             (this.state!=null &&
              this.state.equals(other.getState()))) &&
            ((this.stateDetail==null && other.getStateDetail()==null) || 
             (this.stateDetail!=null &&
              this.stateDetail.equals(other.getStateDetail()))) &&
            ((this.stateDetailLastModifiedDate==null && other.getStateDetailLastModifiedDate()==null) || 
             (this.stateDetailLastModifiedDate!=null &&
              this.stateDetailLastModifiedDate.equals(other.getStateDetailLastModifiedDate()))) &&
            ((this.statusCode==null && other.getStatusCode()==null) || 
             (this.statusCode!=null &&
              this.statusCode.equals(other.getStatusCode())));
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
        if (getCheckOnly() != null) {
            _hashCode += getCheckOnly().hashCode();
        }
        _hashCode += (isDone() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getId() != null) {
            _hashCode += getId().hashCode();
        }
        if (getMessage() != null) {
            _hashCode += getMessage().hashCode();
        }
        if (getNumberComponentErrors() != null) {
            _hashCode += getNumberComponentErrors().hashCode();
        }
        if (getNumberComponentsDeployed() != null) {
            _hashCode += getNumberComponentsDeployed().hashCode();
        }
        if (getNumberComponentsTotal() != null) {
            _hashCode += getNumberComponentsTotal().hashCode();
        }
        if (getNumberTestErrors() != null) {
            _hashCode += getNumberTestErrors().hashCode();
        }
        if (getNumberTestsCompleted() != null) {
            _hashCode += getNumberTestsCompleted().hashCode();
        }
        if (getNumberTestsTotal() != null) {
            _hashCode += getNumberTestsTotal().hashCode();
        }
        _hashCode += getSecondsToWait();
        if (getState() != null) {
            _hashCode += getState().hashCode();
        }
        if (getStateDetail() != null) {
            _hashCode += getStateDetail().hashCode();
        }
        if (getStateDetailLastModifiedDate() != null) {
            _hashCode += getStateDetailLastModifiedDate().hashCode();
        }
        if (getStatusCode() != null) {
            _hashCode += getStatusCode().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AsyncResult.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "AsyncResult"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("checkOnly");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "checkOnly"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("done");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "done"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("message");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "message"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numberComponentErrors");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "numberComponentErrors"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numberComponentsDeployed");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "numberComponentsDeployed"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numberComponentsTotal");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "numberComponentsTotal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numberTestErrors");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "numberTestErrors"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numberTestsCompleted");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "numberTestsCompleted"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numberTestsTotal");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "numberTestsTotal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("secondsToWait");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "secondsToWait"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("state");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "state"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "AsyncRequestState"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("stateDetail");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "stateDetail"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("stateDetailLastModifiedDate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "stateDetailLastModifiedDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("statusCode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "statusCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "StatusCode"));
        elemField.setMinOccurs(0);
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
