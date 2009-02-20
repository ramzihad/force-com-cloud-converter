/**
 * CustomApplication.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package old.com.sforce.soap._2006._04.metadata;

public class CustomApplication  extends com.sforce.soap._2006._04.metadata.Metadata  implements java.io.Serializable {
    private java.lang.String defaultLandingTab;

    private java.lang.String description;

    private java.lang.String label;

    private java.lang.String logo;

    private java.lang.String[] tab;

    public CustomApplication() {
    }

    public CustomApplication(
           java.lang.String fullName,
           java.lang.String defaultLandingTab,
           java.lang.String description,
           java.lang.String label,
           java.lang.String logo,
           java.lang.String[] tab) {
        super(
            fullName);
        this.defaultLandingTab = defaultLandingTab;
        this.description = description;
        this.label = label;
        this.logo = logo;
        this.tab = tab;
    }


    /**
     * Gets the defaultLandingTab value for this CustomApplication.
     * 
     * @return defaultLandingTab
     */
    public java.lang.String getDefaultLandingTab() {
        return defaultLandingTab;
    }


    /**
     * Sets the defaultLandingTab value for this CustomApplication.
     * 
     * @param defaultLandingTab
     */
    public void setDefaultLandingTab(java.lang.String defaultLandingTab) {
        this.defaultLandingTab = defaultLandingTab;
    }


    /**
     * Gets the description value for this CustomApplication.
     * 
     * @return description
     */
    public java.lang.String getDescription() {
        return description;
    }


    /**
     * Sets the description value for this CustomApplication.
     * 
     * @param description
     */
    public void setDescription(java.lang.String description) {
        this.description = description;
    }


    /**
     * Gets the label value for this CustomApplication.
     * 
     * @return label
     */
    public java.lang.String getLabel() {
        return label;
    }


    /**
     * Sets the label value for this CustomApplication.
     * 
     * @param label
     */
    public void setLabel(java.lang.String label) {
        this.label = label;
    }


    /**
     * Gets the logo value for this CustomApplication.
     * 
     * @return logo
     */
    public java.lang.String getLogo() {
        return logo;
    }


    /**
     * Sets the logo value for this CustomApplication.
     * 
     * @param logo
     */
    public void setLogo(java.lang.String logo) {
        this.logo = logo;
    }


    /**
     * Gets the tab value for this CustomApplication.
     * 
     * @return tab
     */
    public java.lang.String[] getTab() {
        return tab;
    }


    /**
     * Sets the tab value for this CustomApplication.
     * 
     * @param tab
     */
    public void setTab(java.lang.String[] tab) {
        this.tab = tab;
    }

    public java.lang.String getTab(int i) {
        return this.tab[i];
    }

    public void setTab(int i, java.lang.String _value) {
        this.tab[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CustomApplication)) return false;
        CustomApplication other = (CustomApplication) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.defaultLandingTab==null && other.getDefaultLandingTab()==null) || 
             (this.defaultLandingTab!=null &&
              this.defaultLandingTab.equals(other.getDefaultLandingTab()))) &&
            ((this.description==null && other.getDescription()==null) || 
             (this.description!=null &&
              this.description.equals(other.getDescription()))) &&
            ((this.label==null && other.getLabel()==null) || 
             (this.label!=null &&
              this.label.equals(other.getLabel()))) &&
            ((this.logo==null && other.getLogo()==null) || 
             (this.logo!=null &&
              this.logo.equals(other.getLogo()))) &&
            ((this.tab==null && other.getTab()==null) || 
             (this.tab!=null &&
              java.util.Arrays.equals(this.tab, other.getTab())));
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
        if (getDefaultLandingTab() != null) {
            _hashCode += getDefaultLandingTab().hashCode();
        }
        if (getDescription() != null) {
            _hashCode += getDescription().hashCode();
        }
        if (getLabel() != null) {
            _hashCode += getLabel().hashCode();
        }
        if (getLogo() != null) {
            _hashCode += getLogo().hashCode();
        }
        if (getTab() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getTab());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getTab(), i);
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
        new org.apache.axis.description.TypeDesc(CustomApplication.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "CustomApplication"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("defaultLandingTab");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "defaultLandingTab"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
        elemField.setFieldName("logo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "logo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tab");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "tab"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
