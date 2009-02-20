/**
 * ReportAggregate.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package old.com.sforce.soap._2006._04.metadata;

public class ReportAggregate  implements java.io.Serializable {
    private java.lang.String calculatedFormula;

    private com.sforce.soap._2006._04.metadata.CustomFieldDatatypes datatype;

    private java.lang.String description;

    private java.lang.String developerName;

    private boolean isActive;

    private java.lang.String masterLabel;

    private java.lang.Integer scale;

    public ReportAggregate() {
    }

    public ReportAggregate(
           java.lang.String calculatedFormula,
           com.sforce.soap._2006._04.metadata.CustomFieldDatatypes datatype,
           java.lang.String description,
           java.lang.String developerName,
           boolean isActive,
           java.lang.String masterLabel,
           java.lang.Integer scale) {
           this.calculatedFormula = calculatedFormula;
           this.datatype = datatype;
           this.description = description;
           this.developerName = developerName;
           this.isActive = isActive;
           this.masterLabel = masterLabel;
           this.scale = scale;
    }


    /**
     * Gets the calculatedFormula value for this ReportAggregate.
     * 
     * @return calculatedFormula
     */
    public java.lang.String getCalculatedFormula() {
        return calculatedFormula;
    }


    /**
     * Sets the calculatedFormula value for this ReportAggregate.
     * 
     * @param calculatedFormula
     */
    public void setCalculatedFormula(java.lang.String calculatedFormula) {
        this.calculatedFormula = calculatedFormula;
    }


    /**
     * Gets the datatype value for this ReportAggregate.
     * 
     * @return datatype
     */
    public com.sforce.soap._2006._04.metadata.CustomFieldDatatypes getDatatype() {
        return datatype;
    }


    /**
     * Sets the datatype value for this ReportAggregate.
     * 
     * @param datatype
     */
    public void setDatatype(com.sforce.soap._2006._04.metadata.CustomFieldDatatypes datatype) {
        this.datatype = datatype;
    }


    /**
     * Gets the description value for this ReportAggregate.
     * 
     * @return description
     */
    public java.lang.String getDescription() {
        return description;
    }


    /**
     * Sets the description value for this ReportAggregate.
     * 
     * @param description
     */
    public void setDescription(java.lang.String description) {
        this.description = description;
    }


    /**
     * Gets the developerName value for this ReportAggregate.
     * 
     * @return developerName
     */
    public java.lang.String getDeveloperName() {
        return developerName;
    }


    /**
     * Sets the developerName value for this ReportAggregate.
     * 
     * @param developerName
     */
    public void setDeveloperName(java.lang.String developerName) {
        this.developerName = developerName;
    }


    /**
     * Gets the isActive value for this ReportAggregate.
     * 
     * @return isActive
     */
    public boolean isIsActive() {
        return isActive;
    }


    /**
     * Sets the isActive value for this ReportAggregate.
     * 
     * @param isActive
     */
    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }


    /**
     * Gets the masterLabel value for this ReportAggregate.
     * 
     * @return masterLabel
     */
    public java.lang.String getMasterLabel() {
        return masterLabel;
    }


    /**
     * Sets the masterLabel value for this ReportAggregate.
     * 
     * @param masterLabel
     */
    public void setMasterLabel(java.lang.String masterLabel) {
        this.masterLabel = masterLabel;
    }


    /**
     * Gets the scale value for this ReportAggregate.
     * 
     * @return scale
     */
    public java.lang.Integer getScale() {
        return scale;
    }


    /**
     * Sets the scale value for this ReportAggregate.
     * 
     * @param scale
     */
    public void setScale(java.lang.Integer scale) {
        this.scale = scale;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ReportAggregate)) return false;
        ReportAggregate other = (ReportAggregate) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.calculatedFormula==null && other.getCalculatedFormula()==null) || 
             (this.calculatedFormula!=null &&
              this.calculatedFormula.equals(other.getCalculatedFormula()))) &&
            ((this.datatype==null && other.getDatatype()==null) || 
             (this.datatype!=null &&
              this.datatype.equals(other.getDatatype()))) &&
            ((this.description==null && other.getDescription()==null) || 
             (this.description!=null &&
              this.description.equals(other.getDescription()))) &&
            ((this.developerName==null && other.getDeveloperName()==null) || 
             (this.developerName!=null &&
              this.developerName.equals(other.getDeveloperName()))) &&
            this.isActive == other.isIsActive() &&
            ((this.masterLabel==null && other.getMasterLabel()==null) || 
             (this.masterLabel!=null &&
              this.masterLabel.equals(other.getMasterLabel()))) &&
            ((this.scale==null && other.getScale()==null) || 
             (this.scale!=null &&
              this.scale.equals(other.getScale())));
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
        if (getCalculatedFormula() != null) {
            _hashCode += getCalculatedFormula().hashCode();
        }
        if (getDatatype() != null) {
            _hashCode += getDatatype().hashCode();
        }
        if (getDescription() != null) {
            _hashCode += getDescription().hashCode();
        }
        if (getDeveloperName() != null) {
            _hashCode += getDeveloperName().hashCode();
        }
        _hashCode += (isIsActive() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getMasterLabel() != null) {
            _hashCode += getMasterLabel().hashCode();
        }
        if (getScale() != null) {
            _hashCode += getScale().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ReportAggregate.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "ReportAggregate"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("calculatedFormula");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "calculatedFormula"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("datatype");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "datatype"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "CustomFieldDatatypes"));
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
        elemField.setFieldName("developerName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "developerName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isActive");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "isActive"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("masterLabel");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "masterLabel"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("scale");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "scale"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
