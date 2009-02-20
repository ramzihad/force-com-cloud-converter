/**
 * WorkflowOutboundMessage.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package old.com.sforce.soap._2006._04.metadata;

public class WorkflowOutboundMessage  extends com.sforce.soap._2006._04.metadata.WorkflowAction  implements java.io.Serializable {
    private java.lang.String description;

    private java.lang.String endpointUrl;

    private java.lang.String[] fields;

    private boolean includeSessionId;

    private java.lang.String integrationUser;

    private boolean _protected;

    private java.lang.Boolean useDeadLetterQueue;

    public WorkflowOutboundMessage() {
    }

    public WorkflowOutboundMessage(
           java.lang.String fullName,
           java.lang.String description,
           java.lang.String endpointUrl,
           java.lang.String[] fields,
           boolean includeSessionId,
           java.lang.String integrationUser,
           boolean _protected,
           java.lang.Boolean useDeadLetterQueue) {
        super(
            fullName);
        this.description = description;
        this.endpointUrl = endpointUrl;
        this.fields = fields;
        this.includeSessionId = includeSessionId;
        this.integrationUser = integrationUser;
        this._protected = _protected;
        this.useDeadLetterQueue = useDeadLetterQueue;
    }


    /**
     * Gets the description value for this WorkflowOutboundMessage.
     * 
     * @return description
     */
    public java.lang.String getDescription() {
        return description;
    }


    /**
     * Sets the description value for this WorkflowOutboundMessage.
     * 
     * @param description
     */
    public void setDescription(java.lang.String description) {
        this.description = description;
    }


    /**
     * Gets the endpointUrl value for this WorkflowOutboundMessage.
     * 
     * @return endpointUrl
     */
    public java.lang.String getEndpointUrl() {
        return endpointUrl;
    }


    /**
     * Sets the endpointUrl value for this WorkflowOutboundMessage.
     * 
     * @param endpointUrl
     */
    public void setEndpointUrl(java.lang.String endpointUrl) {
        this.endpointUrl = endpointUrl;
    }


    /**
     * Gets the fields value for this WorkflowOutboundMessage.
     * 
     * @return fields
     */
    public java.lang.String[] getFields() {
        return fields;
    }


    /**
     * Sets the fields value for this WorkflowOutboundMessage.
     * 
     * @param fields
     */
    public void setFields(java.lang.String[] fields) {
        this.fields = fields;
    }

    public java.lang.String getFields(int i) {
        return this.fields[i];
    }

    public void setFields(int i, java.lang.String _value) {
        this.fields[i] = _value;
    }


    /**
     * Gets the includeSessionId value for this WorkflowOutboundMessage.
     * 
     * @return includeSessionId
     */
    public boolean isIncludeSessionId() {
        return includeSessionId;
    }


    /**
     * Sets the includeSessionId value for this WorkflowOutboundMessage.
     * 
     * @param includeSessionId
     */
    public void setIncludeSessionId(boolean includeSessionId) {
        this.includeSessionId = includeSessionId;
    }


    /**
     * Gets the integrationUser value for this WorkflowOutboundMessage.
     * 
     * @return integrationUser
     */
    public java.lang.String getIntegrationUser() {
        return integrationUser;
    }


    /**
     * Sets the integrationUser value for this WorkflowOutboundMessage.
     * 
     * @param integrationUser
     */
    public void setIntegrationUser(java.lang.String integrationUser) {
        this.integrationUser = integrationUser;
    }


    /**
     * Gets the _protected value for this WorkflowOutboundMessage.
     * 
     * @return _protected
     */
    public boolean is_protected() {
        return _protected;
    }


    /**
     * Sets the _protected value for this WorkflowOutboundMessage.
     * 
     * @param _protected
     */
    public void set_protected(boolean _protected) {
        this._protected = _protected;
    }


    /**
     * Gets the useDeadLetterQueue value for this WorkflowOutboundMessage.
     * 
     * @return useDeadLetterQueue
     */
    public java.lang.Boolean getUseDeadLetterQueue() {
        return useDeadLetterQueue;
    }


    /**
     * Sets the useDeadLetterQueue value for this WorkflowOutboundMessage.
     * 
     * @param useDeadLetterQueue
     */
    public void setUseDeadLetterQueue(java.lang.Boolean useDeadLetterQueue) {
        this.useDeadLetterQueue = useDeadLetterQueue;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof WorkflowOutboundMessage)) return false;
        WorkflowOutboundMessage other = (WorkflowOutboundMessage) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.description==null && other.getDescription()==null) || 
             (this.description!=null &&
              this.description.equals(other.getDescription()))) &&
            ((this.endpointUrl==null && other.getEndpointUrl()==null) || 
             (this.endpointUrl!=null &&
              this.endpointUrl.equals(other.getEndpointUrl()))) &&
            ((this.fields==null && other.getFields()==null) || 
             (this.fields!=null &&
              java.util.Arrays.equals(this.fields, other.getFields()))) &&
            this.includeSessionId == other.isIncludeSessionId() &&
            ((this.integrationUser==null && other.getIntegrationUser()==null) || 
             (this.integrationUser!=null &&
              this.integrationUser.equals(other.getIntegrationUser()))) &&
            this._protected == other.is_protected() &&
            ((this.useDeadLetterQueue==null && other.getUseDeadLetterQueue()==null) || 
             (this.useDeadLetterQueue!=null &&
              this.useDeadLetterQueue.equals(other.getUseDeadLetterQueue())));
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
        if (getDescription() != null) {
            _hashCode += getDescription().hashCode();
        }
        if (getEndpointUrl() != null) {
            _hashCode += getEndpointUrl().hashCode();
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
        _hashCode += (isIncludeSessionId() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getIntegrationUser() != null) {
            _hashCode += getIntegrationUser().hashCode();
        }
        _hashCode += (is_protected() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getUseDeadLetterQueue() != null) {
            _hashCode += getUseDeadLetterQueue().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(WorkflowOutboundMessage.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "WorkflowOutboundMessage"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("description");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "description"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("endpointUrl");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "endpointUrl"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fields");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "fields"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("includeSessionId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "includeSessionId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("integrationUser");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "integrationUser"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("_protected");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "protected"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("useDeadLetterQueue");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "useDeadLetterQueue"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
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
