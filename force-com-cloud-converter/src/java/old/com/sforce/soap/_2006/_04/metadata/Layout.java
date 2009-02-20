/**
 * Layout.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package old.com.sforce.soap._2006._04.metadata;

public class Layout  extends com.sforce.soap._2006._04.metadata.Metadata  implements java.io.Serializable {
    private java.lang.String[] customButtons;

    private java.lang.Boolean emailDefault;

    private java.lang.String[] excludeButtons;

    private com.sforce.soap._2006._04.metadata.LayoutHeader[] headers;

    private com.sforce.soap._2006._04.metadata.LayoutSection[] layoutSections;

    private com.sforce.soap._2006._04.metadata.MiniLayout miniLayout;

    private java.lang.String[] multilineLayoutFields;

    private com.sforce.soap._2006._04.metadata.RelatedListItem[] relatedLists;

    private java.lang.String[] relatedObjects;

    private java.lang.Boolean runAssignmentRulesDefault;

    private java.lang.Boolean showEmailCheckbox;

    private java.lang.Boolean showRunAssignmentRulesCheckbox;

    private java.lang.Boolean showSolutionSection;

    public Layout() {
    }

    public Layout(
           java.lang.String fullName,
           java.lang.String[] customButtons,
           java.lang.Boolean emailDefault,
           java.lang.String[] excludeButtons,
           com.sforce.soap._2006._04.metadata.LayoutHeader[] headers,
           com.sforce.soap._2006._04.metadata.LayoutSection[] layoutSections,
           com.sforce.soap._2006._04.metadata.MiniLayout miniLayout,
           java.lang.String[] multilineLayoutFields,
           com.sforce.soap._2006._04.metadata.RelatedListItem[] relatedLists,
           java.lang.String[] relatedObjects,
           java.lang.Boolean runAssignmentRulesDefault,
           java.lang.Boolean showEmailCheckbox,
           java.lang.Boolean showRunAssignmentRulesCheckbox,
           java.lang.Boolean showSolutionSection) {
        super(
            fullName);
        this.customButtons = customButtons;
        this.emailDefault = emailDefault;
        this.excludeButtons = excludeButtons;
        this.headers = headers;
        this.layoutSections = layoutSections;
        this.miniLayout = miniLayout;
        this.multilineLayoutFields = multilineLayoutFields;
        this.relatedLists = relatedLists;
        this.relatedObjects = relatedObjects;
        this.runAssignmentRulesDefault = runAssignmentRulesDefault;
        this.showEmailCheckbox = showEmailCheckbox;
        this.showRunAssignmentRulesCheckbox = showRunAssignmentRulesCheckbox;
        this.showSolutionSection = showSolutionSection;
    }


    /**
     * Gets the customButtons value for this Layout.
     * 
     * @return customButtons
     */
    public java.lang.String[] getCustomButtons() {
        return customButtons;
    }


    /**
     * Sets the customButtons value for this Layout.
     * 
     * @param customButtons
     */
    public void setCustomButtons(java.lang.String[] customButtons) {
        this.customButtons = customButtons;
    }

    public java.lang.String getCustomButtons(int i) {
        return this.customButtons[i];
    }

    public void setCustomButtons(int i, java.lang.String _value) {
        this.customButtons[i] = _value;
    }


    /**
     * Gets the emailDefault value for this Layout.
     * 
     * @return emailDefault
     */
    public java.lang.Boolean getEmailDefault() {
        return emailDefault;
    }


    /**
     * Sets the emailDefault value for this Layout.
     * 
     * @param emailDefault
     */
    public void setEmailDefault(java.lang.Boolean emailDefault) {
        this.emailDefault = emailDefault;
    }


    /**
     * Gets the excludeButtons value for this Layout.
     * 
     * @return excludeButtons
     */
    public java.lang.String[] getExcludeButtons() {
        return excludeButtons;
    }


    /**
     * Sets the excludeButtons value for this Layout.
     * 
     * @param excludeButtons
     */
    public void setExcludeButtons(java.lang.String[] excludeButtons) {
        this.excludeButtons = excludeButtons;
    }

    public java.lang.String getExcludeButtons(int i) {
        return this.excludeButtons[i];
    }

    public void setExcludeButtons(int i, java.lang.String _value) {
        this.excludeButtons[i] = _value;
    }


    /**
     * Gets the headers value for this Layout.
     * 
     * @return headers
     */
    public com.sforce.soap._2006._04.metadata.LayoutHeader[] getHeaders() {
        return headers;
    }


    /**
     * Sets the headers value for this Layout.
     * 
     * @param headers
     */
    public void setHeaders(com.sforce.soap._2006._04.metadata.LayoutHeader[] headers) {
        this.headers = headers;
    }

    public com.sforce.soap._2006._04.metadata.LayoutHeader getHeaders(int i) {
        return this.headers[i];
    }

    public void setHeaders(int i, com.sforce.soap._2006._04.metadata.LayoutHeader _value) {
        this.headers[i] = _value;
    }


    /**
     * Gets the layoutSections value for this Layout.
     * 
     * @return layoutSections
     */
    public com.sforce.soap._2006._04.metadata.LayoutSection[] getLayoutSections() {
        return layoutSections;
    }


    /**
     * Sets the layoutSections value for this Layout.
     * 
     * @param layoutSections
     */
    public void setLayoutSections(com.sforce.soap._2006._04.metadata.LayoutSection[] layoutSections) {
        this.layoutSections = layoutSections;
    }

    public com.sforce.soap._2006._04.metadata.LayoutSection getLayoutSections(int i) {
        return this.layoutSections[i];
    }

    public void setLayoutSections(int i, com.sforce.soap._2006._04.metadata.LayoutSection _value) {
        this.layoutSections[i] = _value;
    }


    /**
     * Gets the miniLayout value for this Layout.
     * 
     * @return miniLayout
     */
    public com.sforce.soap._2006._04.metadata.MiniLayout getMiniLayout() {
        return miniLayout;
    }


    /**
     * Sets the miniLayout value for this Layout.
     * 
     * @param miniLayout
     */
    public void setMiniLayout(com.sforce.soap._2006._04.metadata.MiniLayout miniLayout) {
        this.miniLayout = miniLayout;
    }


    /**
     * Gets the multilineLayoutFields value for this Layout.
     * 
     * @return multilineLayoutFields
     */
    public java.lang.String[] getMultilineLayoutFields() {
        return multilineLayoutFields;
    }


    /**
     * Sets the multilineLayoutFields value for this Layout.
     * 
     * @param multilineLayoutFields
     */
    public void setMultilineLayoutFields(java.lang.String[] multilineLayoutFields) {
        this.multilineLayoutFields = multilineLayoutFields;
    }

    public java.lang.String getMultilineLayoutFields(int i) {
        return this.multilineLayoutFields[i];
    }

    public void setMultilineLayoutFields(int i, java.lang.String _value) {
        this.multilineLayoutFields[i] = _value;
    }


    /**
     * Gets the relatedLists value for this Layout.
     * 
     * @return relatedLists
     */
    public com.sforce.soap._2006._04.metadata.RelatedListItem[] getRelatedLists() {
        return relatedLists;
    }


    /**
     * Sets the relatedLists value for this Layout.
     * 
     * @param relatedLists
     */
    public void setRelatedLists(com.sforce.soap._2006._04.metadata.RelatedListItem[] relatedLists) {
        this.relatedLists = relatedLists;
    }

    public com.sforce.soap._2006._04.metadata.RelatedListItem getRelatedLists(int i) {
        return this.relatedLists[i];
    }

    public void setRelatedLists(int i, com.sforce.soap._2006._04.metadata.RelatedListItem _value) {
        this.relatedLists[i] = _value;
    }


    /**
     * Gets the relatedObjects value for this Layout.
     * 
     * @return relatedObjects
     */
    public java.lang.String[] getRelatedObjects() {
        return relatedObjects;
    }


    /**
     * Sets the relatedObjects value for this Layout.
     * 
     * @param relatedObjects
     */
    public void setRelatedObjects(java.lang.String[] relatedObjects) {
        this.relatedObjects = relatedObjects;
    }

    public java.lang.String getRelatedObjects(int i) {
        return this.relatedObjects[i];
    }

    public void setRelatedObjects(int i, java.lang.String _value) {
        this.relatedObjects[i] = _value;
    }


    /**
     * Gets the runAssignmentRulesDefault value for this Layout.
     * 
     * @return runAssignmentRulesDefault
     */
    public java.lang.Boolean getRunAssignmentRulesDefault() {
        return runAssignmentRulesDefault;
    }


    /**
     * Sets the runAssignmentRulesDefault value for this Layout.
     * 
     * @param runAssignmentRulesDefault
     */
    public void setRunAssignmentRulesDefault(java.lang.Boolean runAssignmentRulesDefault) {
        this.runAssignmentRulesDefault = runAssignmentRulesDefault;
    }


    /**
     * Gets the showEmailCheckbox value for this Layout.
     * 
     * @return showEmailCheckbox
     */
    public java.lang.Boolean getShowEmailCheckbox() {
        return showEmailCheckbox;
    }


    /**
     * Sets the showEmailCheckbox value for this Layout.
     * 
     * @param showEmailCheckbox
     */
    public void setShowEmailCheckbox(java.lang.Boolean showEmailCheckbox) {
        this.showEmailCheckbox = showEmailCheckbox;
    }


    /**
     * Gets the showRunAssignmentRulesCheckbox value for this Layout.
     * 
     * @return showRunAssignmentRulesCheckbox
     */
    public java.lang.Boolean getShowRunAssignmentRulesCheckbox() {
        return showRunAssignmentRulesCheckbox;
    }


    /**
     * Sets the showRunAssignmentRulesCheckbox value for this Layout.
     * 
     * @param showRunAssignmentRulesCheckbox
     */
    public void setShowRunAssignmentRulesCheckbox(java.lang.Boolean showRunAssignmentRulesCheckbox) {
        this.showRunAssignmentRulesCheckbox = showRunAssignmentRulesCheckbox;
    }


    /**
     * Gets the showSolutionSection value for this Layout.
     * 
     * @return showSolutionSection
     */
    public java.lang.Boolean getShowSolutionSection() {
        return showSolutionSection;
    }


    /**
     * Sets the showSolutionSection value for this Layout.
     * 
     * @param showSolutionSection
     */
    public void setShowSolutionSection(java.lang.Boolean showSolutionSection) {
        this.showSolutionSection = showSolutionSection;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Layout)) return false;
        Layout other = (Layout) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.customButtons==null && other.getCustomButtons()==null) || 
             (this.customButtons!=null &&
              java.util.Arrays.equals(this.customButtons, other.getCustomButtons()))) &&
            ((this.emailDefault==null && other.getEmailDefault()==null) || 
             (this.emailDefault!=null &&
              this.emailDefault.equals(other.getEmailDefault()))) &&
            ((this.excludeButtons==null && other.getExcludeButtons()==null) || 
             (this.excludeButtons!=null &&
              java.util.Arrays.equals(this.excludeButtons, other.getExcludeButtons()))) &&
            ((this.headers==null && other.getHeaders()==null) || 
             (this.headers!=null &&
              java.util.Arrays.equals(this.headers, other.getHeaders()))) &&
            ((this.layoutSections==null && other.getLayoutSections()==null) || 
             (this.layoutSections!=null &&
              java.util.Arrays.equals(this.layoutSections, other.getLayoutSections()))) &&
            ((this.miniLayout==null && other.getMiniLayout()==null) || 
             (this.miniLayout!=null &&
              this.miniLayout.equals(other.getMiniLayout()))) &&
            ((this.multilineLayoutFields==null && other.getMultilineLayoutFields()==null) || 
             (this.multilineLayoutFields!=null &&
              java.util.Arrays.equals(this.multilineLayoutFields, other.getMultilineLayoutFields()))) &&
            ((this.relatedLists==null && other.getRelatedLists()==null) || 
             (this.relatedLists!=null &&
              java.util.Arrays.equals(this.relatedLists, other.getRelatedLists()))) &&
            ((this.relatedObjects==null && other.getRelatedObjects()==null) || 
             (this.relatedObjects!=null &&
              java.util.Arrays.equals(this.relatedObjects, other.getRelatedObjects()))) &&
            ((this.runAssignmentRulesDefault==null && other.getRunAssignmentRulesDefault()==null) || 
             (this.runAssignmentRulesDefault!=null &&
              this.runAssignmentRulesDefault.equals(other.getRunAssignmentRulesDefault()))) &&
            ((this.showEmailCheckbox==null && other.getShowEmailCheckbox()==null) || 
             (this.showEmailCheckbox!=null &&
              this.showEmailCheckbox.equals(other.getShowEmailCheckbox()))) &&
            ((this.showRunAssignmentRulesCheckbox==null && other.getShowRunAssignmentRulesCheckbox()==null) || 
             (this.showRunAssignmentRulesCheckbox!=null &&
              this.showRunAssignmentRulesCheckbox.equals(other.getShowRunAssignmentRulesCheckbox()))) &&
            ((this.showSolutionSection==null && other.getShowSolutionSection()==null) || 
             (this.showSolutionSection!=null &&
              this.showSolutionSection.equals(other.getShowSolutionSection())));
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
        if (getCustomButtons() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getCustomButtons());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getCustomButtons(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getEmailDefault() != null) {
            _hashCode += getEmailDefault().hashCode();
        }
        if (getExcludeButtons() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getExcludeButtons());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getExcludeButtons(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getHeaders() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getHeaders());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getHeaders(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getLayoutSections() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getLayoutSections());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getLayoutSections(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getMiniLayout() != null) {
            _hashCode += getMiniLayout().hashCode();
        }
        if (getMultilineLayoutFields() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getMultilineLayoutFields());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getMultilineLayoutFields(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getRelatedLists() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getRelatedLists());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getRelatedLists(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getRelatedObjects() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getRelatedObjects());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getRelatedObjects(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getRunAssignmentRulesDefault() != null) {
            _hashCode += getRunAssignmentRulesDefault().hashCode();
        }
        if (getShowEmailCheckbox() != null) {
            _hashCode += getShowEmailCheckbox().hashCode();
        }
        if (getShowRunAssignmentRulesCheckbox() != null) {
            _hashCode += getShowRunAssignmentRulesCheckbox().hashCode();
        }
        if (getShowSolutionSection() != null) {
            _hashCode += getShowSolutionSection().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Layout.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "Layout"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("customButtons");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "customButtons"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("emailDefault");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "emailDefault"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("excludeButtons");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "excludeButtons"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("headers");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "headers"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "LayoutHeader"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("layoutSections");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "layoutSections"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "LayoutSection"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("miniLayout");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "miniLayout"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "MiniLayout"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("multilineLayoutFields");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "multilineLayoutFields"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("relatedLists");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "relatedLists"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "RelatedListItem"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("relatedObjects");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "relatedObjects"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("runAssignmentRulesDefault");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "runAssignmentRulesDefault"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("showEmailCheckbox");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "showEmailCheckbox"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("showRunAssignmentRulesCheckbox");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "showRunAssignmentRulesCheckbox"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("showSolutionSection");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "showSolutionSection"));
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
