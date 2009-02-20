/**
 * WorkflowFieldUpdate.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package old.com.sforce.soap._2006._04.metadata;

public class WorkflowFieldUpdate  extends com.sforce.soap._2006._04.metadata.WorkflowAction  implements java.io.Serializable {
    private java.lang.String description;

    private java.lang.String field;

    private java.lang.String formula;

    private java.lang.String literalValue;

    private java.lang.String lookupValue;

    private com.sforce.soap._2006._04.metadata.LookupValueType lookupValueType;

    private boolean notifyAssignee;

    private com.sforce.soap._2006._04.metadata.FieldUpdateOperation operation;

    private boolean _protected;

    private java.lang.String targetObject;

    public WorkflowFieldUpdate() {
    }

    public WorkflowFieldUpdate(
           java.lang.String fullName,
           java.lang.String description,
           java.lang.String field,
           java.lang.String formula,
           java.lang.String literalValue,
           java.lang.String lookupValue,
           com.sforce.soap._2006._04.metadata.LookupValueType lookupValueType,
           boolean notifyAssignee,
           com.sforce.soap._2006._04.metadata.FieldUpdateOperation operation,
           boolean _protected,
           java.lang.String targetObject) {
        super(
            fullName);
        this.description = description;
        this.field = field;
        this.formula = formula;
        this.literalValue = literalValue;
        this.lookupValue = lookupValue;
        this.lookupValueType = lookupValueType;
        this.notifyAssignee = notifyAssignee;
        this.operation = operation;
        this._protected = _protected;
        this.targetObject = targetObject;
    }


    /**
     * Gets the description value for this WorkflowFieldUpdate.
     * 
     * @return description
     */
    public java.lang.String getDescription() {
        return description;
    }


    /**
     * Sets the description value for this WorkflowFieldUpdate.
     * 
     * @param description
     */
    public void setDescription(java.lang.String description) {
        this.description = description;
    }


    /**
     * Gets the field value for this WorkflowFieldUpdate.
     * 
     * @return field
     */
    public java.lang.String getField() {
        return field;
    }


    /**
     * Sets the field value for this WorkflowFieldUpdate.
     * 
     * @param field
     */
    public void setField(java.lang.String field) {
        this.field = field;
    }


    /**
     * Gets the formula value for this WorkflowFieldUpdate.
     * 
     * @return formula
     */
    public java.lang.String getFormula() {
        return formula;
    }


    /**
     * Sets the formula value for this WorkflowFieldUpdate.
     * 
     * @param formula
     */
    public void setFormula(java.lang.String formula) {
        this.formula = formula;
    }


    /**
     * Gets the literalValue value for this WorkflowFieldUpdate.
     * 
     * @return literalValue
     */
    public java.lang.String getLiteralValue() {
        return literalValue;
    }


    /**
     * Sets the literalValue value for this WorkflowFieldUpdate.
     * 
     * @param literalValue
     */
    public void setLiteralValue(java.lang.String literalValue) {
        this.literalValue = literalValue;
    }


    /**
     * Gets the lookupValue value for this WorkflowFieldUpdate.
     * 
     * @return lookupValue
     */
    public java.lang.String getLookupValue() {
        return lookupValue;
    }


    /**
     * Sets the lookupValue value for this WorkflowFieldUpdate.
     * 
     * @param lookupValue
     */
    public void setLookupValue(java.lang.String lookupValue) {
        this.lookupValue = lookupValue;
    }


    /**
     * Gets the lookupValueType value for this WorkflowFieldUpdate.
     * 
     * @return lookupValueType
     */
    public com.sforce.soap._2006._04.metadata.LookupValueType getLookupValueType() {
        return lookupValueType;
    }


    /**
     * Sets the lookupValueType value for this WorkflowFieldUpdate.
     * 
     * @param lookupValueType
     */
    public void setLookupValueType(com.sforce.soap._2006._04.metadata.LookupValueType lookupValueType) {
        this.lookupValueType = lookupValueType;
    }


    /**
     * Gets the notifyAssignee value for this WorkflowFieldUpdate.
     * 
     * @return notifyAssignee
     */
    public boolean isNotifyAssignee() {
        return notifyAssignee;
    }


    /**
     * Sets the notifyAssignee value for this WorkflowFieldUpdate.
     * 
     * @param notifyAssignee
     */
    public void setNotifyAssignee(boolean notifyAssignee) {
        this.notifyAssignee = notifyAssignee;
    }


    /**
     * Gets the operation value for this WorkflowFieldUpdate.
     * 
     * @return operation
     */
    public com.sforce.soap._2006._04.metadata.FieldUpdateOperation getOperation() {
        return operation;
    }


    /**
     * Sets the operation value for this WorkflowFieldUpdate.
     * 
     * @param operation
     */
    public void setOperation(com.sforce.soap._2006._04.metadata.FieldUpdateOperation operation) {
        this.operation = operation;
    }


    /**
     * Gets the _protected value for this WorkflowFieldUpdate.
     * 
     * @return _protected
     */
    public boolean is_protected() {
        return _protected;
    }


    /**
     * Sets the _protected value for this WorkflowFieldUpdate.
     * 
     * @param _protected
     */
    public void set_protected(boolean _protected) {
        this._protected = _protected;
    }


    /**
     * Gets the targetObject value for this WorkflowFieldUpdate.
     * 
     * @return targetObject
     */
    public java.lang.String getTargetObject() {
        return targetObject;
    }


    /**
     * Sets the targetObject value for this WorkflowFieldUpdate.
     * 
     * @param targetObject
     */
    public void setTargetObject(java.lang.String targetObject) {
        this.targetObject = targetObject;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof WorkflowFieldUpdate)) return false;
        WorkflowFieldUpdate other = (WorkflowFieldUpdate) obj;
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
            ((this.field==null && other.getField()==null) || 
             (this.field!=null &&
              this.field.equals(other.getField()))) &&
            ((this.formula==null && other.getFormula()==null) || 
             (this.formula!=null &&
              this.formula.equals(other.getFormula()))) &&
            ((this.literalValue==null && other.getLiteralValue()==null) || 
             (this.literalValue!=null &&
              this.literalValue.equals(other.getLiteralValue()))) &&
            ((this.lookupValue==null && other.getLookupValue()==null) || 
             (this.lookupValue!=null &&
              this.lookupValue.equals(other.getLookupValue()))) &&
            ((this.lookupValueType==null && other.getLookupValueType()==null) || 
             (this.lookupValueType!=null &&
              this.lookupValueType.equals(other.getLookupValueType()))) &&
            this.notifyAssignee == other.isNotifyAssignee() &&
            ((this.operation==null && other.getOperation()==null) || 
             (this.operation!=null &&
              this.operation.equals(other.getOperation()))) &&
            this._protected == other.is_protected() &&
            ((this.targetObject==null && other.getTargetObject()==null) || 
             (this.targetObject!=null &&
              this.targetObject.equals(other.getTargetObject())));
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
        if (getField() != null) {
            _hashCode += getField().hashCode();
        }
        if (getFormula() != null) {
            _hashCode += getFormula().hashCode();
        }
        if (getLiteralValue() != null) {
            _hashCode += getLiteralValue().hashCode();
        }
        if (getLookupValue() != null) {
            _hashCode += getLookupValue().hashCode();
        }
        if (getLookupValueType() != null) {
            _hashCode += getLookupValueType().hashCode();
        }
        _hashCode += (isNotifyAssignee() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getOperation() != null) {
            _hashCode += getOperation().hashCode();
        }
        _hashCode += (is_protected() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getTargetObject() != null) {
            _hashCode += getTargetObject().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(WorkflowFieldUpdate.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "WorkflowFieldUpdate"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("description");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "description"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
        elemField.setFieldName("formula");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "formula"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("literalValue");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "literalValue"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("lookupValue");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "lookupValue"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("lookupValueType");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "lookupValueType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "LookupValueType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("notifyAssignee");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "notifyAssignee"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("operation");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "operation"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "FieldUpdateOperation"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("_protected");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "protected"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("targetObject");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "targetObject"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
