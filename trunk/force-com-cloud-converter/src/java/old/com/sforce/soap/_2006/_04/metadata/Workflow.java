/**
 * Workflow.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package old.com.sforce.soap._2006._04.metadata;

public class Workflow  extends com.sforce.soap._2006._04.metadata.Metadata  implements java.io.Serializable {
    private com.sforce.soap._2006._04.metadata.WorkflowAlert[] alerts;

    private com.sforce.soap._2006._04.metadata.WorkflowFieldUpdate[] fieldUpdates;

    private com.sforce.soap._2006._04.metadata.WorkflowOutboundMessage[] outboundMessages;

    private com.sforce.soap._2006._04.metadata.WorkflowRule[] rules;

    private com.sforce.soap._2006._04.metadata.WorkflowTask[] tasks;

    public Workflow() {
    }

    public Workflow(
           java.lang.String fullName,
           com.sforce.soap._2006._04.metadata.WorkflowAlert[] alerts,
           com.sforce.soap._2006._04.metadata.WorkflowFieldUpdate[] fieldUpdates,
           com.sforce.soap._2006._04.metadata.WorkflowOutboundMessage[] outboundMessages,
           com.sforce.soap._2006._04.metadata.WorkflowRule[] rules,
           com.sforce.soap._2006._04.metadata.WorkflowTask[] tasks) {
        super(
            fullName);
        this.alerts = alerts;
        this.fieldUpdates = fieldUpdates;
        this.outboundMessages = outboundMessages;
        this.rules = rules;
        this.tasks = tasks;
    }


    /**
     * Gets the alerts value for this Workflow.
     * 
     * @return alerts
     */
    public com.sforce.soap._2006._04.metadata.WorkflowAlert[] getAlerts() {
        return alerts;
    }


    /**
     * Sets the alerts value for this Workflow.
     * 
     * @param alerts
     */
    public void setAlerts(com.sforce.soap._2006._04.metadata.WorkflowAlert[] alerts) {
        this.alerts = alerts;
    }

    public com.sforce.soap._2006._04.metadata.WorkflowAlert getAlerts(int i) {
        return this.alerts[i];
    }

    public void setAlerts(int i, com.sforce.soap._2006._04.metadata.WorkflowAlert _value) {
        this.alerts[i] = _value;
    }


    /**
     * Gets the fieldUpdates value for this Workflow.
     * 
     * @return fieldUpdates
     */
    public com.sforce.soap._2006._04.metadata.WorkflowFieldUpdate[] getFieldUpdates() {
        return fieldUpdates;
    }


    /**
     * Sets the fieldUpdates value for this Workflow.
     * 
     * @param fieldUpdates
     */
    public void setFieldUpdates(com.sforce.soap._2006._04.metadata.WorkflowFieldUpdate[] fieldUpdates) {
        this.fieldUpdates = fieldUpdates;
    }

    public com.sforce.soap._2006._04.metadata.WorkflowFieldUpdate getFieldUpdates(int i) {
        return this.fieldUpdates[i];
    }

    public void setFieldUpdates(int i, com.sforce.soap._2006._04.metadata.WorkflowFieldUpdate _value) {
        this.fieldUpdates[i] = _value;
    }


    /**
     * Gets the outboundMessages value for this Workflow.
     * 
     * @return outboundMessages
     */
    public com.sforce.soap._2006._04.metadata.WorkflowOutboundMessage[] getOutboundMessages() {
        return outboundMessages;
    }


    /**
     * Sets the outboundMessages value for this Workflow.
     * 
     * @param outboundMessages
     */
    public void setOutboundMessages(com.sforce.soap._2006._04.metadata.WorkflowOutboundMessage[] outboundMessages) {
        this.outboundMessages = outboundMessages;
    }

    public com.sforce.soap._2006._04.metadata.WorkflowOutboundMessage getOutboundMessages(int i) {
        return this.outboundMessages[i];
    }

    public void setOutboundMessages(int i, com.sforce.soap._2006._04.metadata.WorkflowOutboundMessage _value) {
        this.outboundMessages[i] = _value;
    }


    /**
     * Gets the rules value for this Workflow.
     * 
     * @return rules
     */
    public com.sforce.soap._2006._04.metadata.WorkflowRule[] getRules() {
        return rules;
    }


    /**
     * Sets the rules value for this Workflow.
     * 
     * @param rules
     */
    public void setRules(com.sforce.soap._2006._04.metadata.WorkflowRule[] rules) {
        this.rules = rules;
    }

    public com.sforce.soap._2006._04.metadata.WorkflowRule getRules(int i) {
        return this.rules[i];
    }

    public void setRules(int i, com.sforce.soap._2006._04.metadata.WorkflowRule _value) {
        this.rules[i] = _value;
    }


    /**
     * Gets the tasks value for this Workflow.
     * 
     * @return tasks
     */
    public com.sforce.soap._2006._04.metadata.WorkflowTask[] getTasks() {
        return tasks;
    }


    /**
     * Sets the tasks value for this Workflow.
     * 
     * @param tasks
     */
    public void setTasks(com.sforce.soap._2006._04.metadata.WorkflowTask[] tasks) {
        this.tasks = tasks;
    }

    public com.sforce.soap._2006._04.metadata.WorkflowTask getTasks(int i) {
        return this.tasks[i];
    }

    public void setTasks(int i, com.sforce.soap._2006._04.metadata.WorkflowTask _value) {
        this.tasks[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Workflow)) return false;
        Workflow other = (Workflow) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.alerts==null && other.getAlerts()==null) || 
             (this.alerts!=null &&
              java.util.Arrays.equals(this.alerts, other.getAlerts()))) &&
            ((this.fieldUpdates==null && other.getFieldUpdates()==null) || 
             (this.fieldUpdates!=null &&
              java.util.Arrays.equals(this.fieldUpdates, other.getFieldUpdates()))) &&
            ((this.outboundMessages==null && other.getOutboundMessages()==null) || 
             (this.outboundMessages!=null &&
              java.util.Arrays.equals(this.outboundMessages, other.getOutboundMessages()))) &&
            ((this.rules==null && other.getRules()==null) || 
             (this.rules!=null &&
              java.util.Arrays.equals(this.rules, other.getRules()))) &&
            ((this.tasks==null && other.getTasks()==null) || 
             (this.tasks!=null &&
              java.util.Arrays.equals(this.tasks, other.getTasks())));
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
        if (getAlerts() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getAlerts());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getAlerts(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getFieldUpdates() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getFieldUpdates());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getFieldUpdates(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getOutboundMessages() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getOutboundMessages());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getOutboundMessages(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getRules() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getRules());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getRules(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getTasks() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getTasks());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getTasks(), i);
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
        new org.apache.axis.description.TypeDesc(Workflow.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "Workflow"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("alerts");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "alerts"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "WorkflowAlert"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fieldUpdates");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "fieldUpdates"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "WorkflowFieldUpdate"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("outboundMessages");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "outboundMessages"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "WorkflowOutboundMessage"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("rules");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "rules"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "WorkflowRule"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tasks");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "tasks"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "WorkflowTask"));
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
