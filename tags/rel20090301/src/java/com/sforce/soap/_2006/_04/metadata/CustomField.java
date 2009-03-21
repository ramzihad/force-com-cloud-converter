/**
 * CustomField.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.sforce.soap._2006._04.metadata;

public class CustomField  extends com.sforce.soap._2006._04.metadata.Metadata  implements java.io.Serializable {
    private java.lang.Boolean caseSensitive;

    private java.lang.String customDataType;

    private java.lang.String defaultValue;

    private java.lang.String description;

    private java.lang.String displayFormat;

    private java.lang.Boolean externalId;

    private java.lang.String formula;

    private com.sforce.soap._2006._04.metadata.TreatBlanksAs formulaTreatBlanksAs;

    private java.lang.String inlineHelpText;

    private java.lang.String label;

    private java.lang.Integer length;

    private com.sforce.soap._2006._04.metadata.EncryptedFieldMaskChar maskChar;

    private com.sforce.soap._2006._04.metadata.EncryptedFieldMaskType maskType;

    private com.sforce.soap._2006._04.metadata.Picklist picklist;

    private java.lang.Boolean populateExistingRows;

    private java.lang.Integer precision;

    private java.lang.String referenceTo;

    private java.lang.String relationshipLabel;

    private java.lang.String relationshipName;

    private java.lang.Integer relationshipOrder;

    private java.lang.Boolean required;

    private java.lang.Boolean restrictedAdminField;

    private java.lang.Integer scale;

    private java.lang.Integer startingNumber;

    private java.lang.String summarizedField;

    private com.sforce.soap._2006._04.metadata.FilterItem[] summaryFilterItems;

    private java.lang.String summaryForeignKey;

    private com.sforce.soap._2006._04.metadata.SummaryOperations summaryOperation;

    private java.lang.Boolean trackHistory;

    private com.sforce.soap._2006._04.metadata.FieldType type;

    private java.lang.Boolean unique;

    private java.lang.Integer visibleLines;

    private java.lang.Boolean writeRequiresMasterRead;

    public CustomField() {
    }

    public CustomField(
           java.lang.String fullName,
           java.lang.Boolean caseSensitive,
           java.lang.String customDataType,
           java.lang.String defaultValue,
           java.lang.String description,
           java.lang.String displayFormat,
           java.lang.Boolean externalId,
           java.lang.String formula,
           com.sforce.soap._2006._04.metadata.TreatBlanksAs formulaTreatBlanksAs,
           java.lang.String inlineHelpText,
           java.lang.String label,
           java.lang.Integer length,
           com.sforce.soap._2006._04.metadata.EncryptedFieldMaskChar maskChar,
           com.sforce.soap._2006._04.metadata.EncryptedFieldMaskType maskType,
           com.sforce.soap._2006._04.metadata.Picklist picklist,
           java.lang.Boolean populateExistingRows,
           java.lang.Integer precision,
           java.lang.String referenceTo,
           java.lang.String relationshipLabel,
           java.lang.String relationshipName,
           java.lang.Integer relationshipOrder,
           java.lang.Boolean required,
           java.lang.Boolean restrictedAdminField,
           java.lang.Integer scale,
           java.lang.Integer startingNumber,
           java.lang.String summarizedField,
           com.sforce.soap._2006._04.metadata.FilterItem[] summaryFilterItems,
           java.lang.String summaryForeignKey,
           com.sforce.soap._2006._04.metadata.SummaryOperations summaryOperation,
           java.lang.Boolean trackHistory,
           com.sforce.soap._2006._04.metadata.FieldType type,
           java.lang.Boolean unique,
           java.lang.Integer visibleLines,
           java.lang.Boolean writeRequiresMasterRead) {
        super(
            fullName);
        this.caseSensitive = caseSensitive;
        this.customDataType = customDataType;
        this.defaultValue = defaultValue;
        this.description = description;
        this.displayFormat = displayFormat;
        this.externalId = externalId;
        this.formula = formula;
        this.formulaTreatBlanksAs = formulaTreatBlanksAs;
        this.inlineHelpText = inlineHelpText;
        this.label = label;
        this.length = length;
        this.maskChar = maskChar;
        this.maskType = maskType;
        this.picklist = picklist;
        this.populateExistingRows = populateExistingRows;
        this.precision = precision;
        this.referenceTo = referenceTo;
        this.relationshipLabel = relationshipLabel;
        this.relationshipName = relationshipName;
        this.relationshipOrder = relationshipOrder;
        this.required = required;
        this.restrictedAdminField = restrictedAdminField;
        this.scale = scale;
        this.startingNumber = startingNumber;
        this.summarizedField = summarizedField;
        this.summaryFilterItems = summaryFilterItems;
        this.summaryForeignKey = summaryForeignKey;
        this.summaryOperation = summaryOperation;
        this.trackHistory = trackHistory;
        this.type = type;
        this.unique = unique;
        this.visibleLines = visibleLines;
        this.writeRequiresMasterRead = writeRequiresMasterRead;
    }


    /**
     * Gets the caseSensitive value for this CustomField.
     * 
     * @return caseSensitive
     */
    public java.lang.Boolean getCaseSensitive() {
        return caseSensitive;
    }


    /**
     * Sets the caseSensitive value for this CustomField.
     * 
     * @param caseSensitive
     */
    public void setCaseSensitive(java.lang.Boolean caseSensitive) {
        this.caseSensitive = caseSensitive;
    }


    /**
     * Gets the customDataType value for this CustomField.
     * 
     * @return customDataType
     */
    public java.lang.String getCustomDataType() {
        return customDataType;
    }


    /**
     * Sets the customDataType value for this CustomField.
     * 
     * @param customDataType
     */
    public void setCustomDataType(java.lang.String customDataType) {
        this.customDataType = customDataType;
    }


    /**
     * Gets the defaultValue value for this CustomField.
     * 
     * @return defaultValue
     */
    public java.lang.String getDefaultValue() {
        return defaultValue;
    }


    /**
     * Sets the defaultValue value for this CustomField.
     * 
     * @param defaultValue
     */
    public void setDefaultValue(java.lang.String defaultValue) {
        this.defaultValue = defaultValue;
    }


    /**
     * Gets the description value for this CustomField.
     * 
     * @return description
     */
    public java.lang.String getDescription() {
        return description;
    }


    /**
     * Sets the description value for this CustomField.
     * 
     * @param description
     */
    public void setDescription(java.lang.String description) {
        this.description = description;
    }


    /**
     * Gets the displayFormat value for this CustomField.
     * 
     * @return displayFormat
     */
    public java.lang.String getDisplayFormat() {
        return displayFormat;
    }


    /**
     * Sets the displayFormat value for this CustomField.
     * 
     * @param displayFormat
     */
    public void setDisplayFormat(java.lang.String displayFormat) {
        this.displayFormat = displayFormat;
    }


    /**
     * Gets the externalId value for this CustomField.
     * 
     * @return externalId
     */
    public java.lang.Boolean getExternalId() {
        return externalId;
    }


    /**
     * Sets the externalId value for this CustomField.
     * 
     * @param externalId
     */
    public void setExternalId(java.lang.Boolean externalId) {
        this.externalId = externalId;
    }


    /**
     * Gets the formula value for this CustomField.
     * 
     * @return formula
     */
    public java.lang.String getFormula() {
        return formula;
    }


    /**
     * Sets the formula value for this CustomField.
     * 
     * @param formula
     */
    public void setFormula(java.lang.String formula) {
        this.formula = formula;
    }


    /**
     * Gets the formulaTreatBlanksAs value for this CustomField.
     * 
     * @return formulaTreatBlanksAs
     */
    public com.sforce.soap._2006._04.metadata.TreatBlanksAs getFormulaTreatBlanksAs() {
        return formulaTreatBlanksAs;
    }


    /**
     * Sets the formulaTreatBlanksAs value for this CustomField.
     * 
     * @param formulaTreatBlanksAs
     */
    public void setFormulaTreatBlanksAs(com.sforce.soap._2006._04.metadata.TreatBlanksAs formulaTreatBlanksAs) {
        this.formulaTreatBlanksAs = formulaTreatBlanksAs;
    }


    /**
     * Gets the inlineHelpText value for this CustomField.
     * 
     * @return inlineHelpText
     */
    public java.lang.String getInlineHelpText() {
        return inlineHelpText;
    }


    /**
     * Sets the inlineHelpText value for this CustomField.
     * 
     * @param inlineHelpText
     */
    public void setInlineHelpText(java.lang.String inlineHelpText) {
        this.inlineHelpText = inlineHelpText;
    }


    /**
     * Gets the label value for this CustomField.
     * 
     * @return label
     */
    public java.lang.String getLabel() {
        return label;
    }


    /**
     * Sets the label value for this CustomField.
     * 
     * @param label
     */
    public void setLabel(java.lang.String label) {
        this.label = label;
    }


    /**
     * Gets the length value for this CustomField.
     * 
     * @return length
     */
    public java.lang.Integer getLength() {
        return length;
    }


    /**
     * Sets the length value for this CustomField.
     * 
     * @param length
     */
    public void setLength(java.lang.Integer length) {
        this.length = length;
    }


    /**
     * Gets the maskChar value for this CustomField.
     * 
     * @return maskChar
     */
    public com.sforce.soap._2006._04.metadata.EncryptedFieldMaskChar getMaskChar() {
        return maskChar;
    }


    /**
     * Sets the maskChar value for this CustomField.
     * 
     * @param maskChar
     */
    public void setMaskChar(com.sforce.soap._2006._04.metadata.EncryptedFieldMaskChar maskChar) {
        this.maskChar = maskChar;
    }


    /**
     * Gets the maskType value for this CustomField.
     * 
     * @return maskType
     */
    public com.sforce.soap._2006._04.metadata.EncryptedFieldMaskType getMaskType() {
        return maskType;
    }


    /**
     * Sets the maskType value for this CustomField.
     * 
     * @param maskType
     */
    public void setMaskType(com.sforce.soap._2006._04.metadata.EncryptedFieldMaskType maskType) {
        this.maskType = maskType;
    }


    /**
     * Gets the picklist value for this CustomField.
     * 
     * @return picklist
     */
    public com.sforce.soap._2006._04.metadata.Picklist getPicklist() {
        return picklist;
    }


    /**
     * Sets the picklist value for this CustomField.
     * 
     * @param picklist
     */
    public void setPicklist(com.sforce.soap._2006._04.metadata.Picklist picklist) {
        this.picklist = picklist;
    }


    /**
     * Gets the populateExistingRows value for this CustomField.
     * 
     * @return populateExistingRows
     */
    public java.lang.Boolean getPopulateExistingRows() {
        return populateExistingRows;
    }


    /**
     * Sets the populateExistingRows value for this CustomField.
     * 
     * @param populateExistingRows
     */
    public void setPopulateExistingRows(java.lang.Boolean populateExistingRows) {
        this.populateExistingRows = populateExistingRows;
    }


    /**
     * Gets the precision value for this CustomField.
     * 
     * @return precision
     */
    public java.lang.Integer getPrecision() {
        return precision;
    }


    /**
     * Sets the precision value for this CustomField.
     * 
     * @param precision
     */
    public void setPrecision(java.lang.Integer precision) {
        this.precision = precision;
    }


    /**
     * Gets the referenceTo value for this CustomField.
     * 
     * @return referenceTo
     */
    public java.lang.String getReferenceTo() {
        return referenceTo;
    }


    /**
     * Sets the referenceTo value for this CustomField.
     * 
     * @param referenceTo
     */
    public void setReferenceTo(java.lang.String referenceTo) {
        this.referenceTo = referenceTo;
    }


    /**
     * Gets the relationshipLabel value for this CustomField.
     * 
     * @return relationshipLabel
     */
    public java.lang.String getRelationshipLabel() {
        return relationshipLabel;
    }


    /**
     * Sets the relationshipLabel value for this CustomField.
     * 
     * @param relationshipLabel
     */
    public void setRelationshipLabel(java.lang.String relationshipLabel) {
        this.relationshipLabel = relationshipLabel;
    }


    /**
     * Gets the relationshipName value for this CustomField.
     * 
     * @return relationshipName
     */
    public java.lang.String getRelationshipName() {
        return relationshipName;
    }


    /**
     * Sets the relationshipName value for this CustomField.
     * 
     * @param relationshipName
     */
    public void setRelationshipName(java.lang.String relationshipName) {
        this.relationshipName = relationshipName;
    }


    /**
     * Gets the relationshipOrder value for this CustomField.
     * 
     * @return relationshipOrder
     */
    public java.lang.Integer getRelationshipOrder() {
        return relationshipOrder;
    }


    /**
     * Sets the relationshipOrder value for this CustomField.
     * 
     * @param relationshipOrder
     */
    public void setRelationshipOrder(java.lang.Integer relationshipOrder) {
        this.relationshipOrder = relationshipOrder;
    }


    /**
     * Gets the required value for this CustomField.
     * 
     * @return required
     */
    public java.lang.Boolean getRequired() {
        return required;
    }


    /**
     * Sets the required value for this CustomField.
     * 
     * @param required
     */
    public void setRequired(java.lang.Boolean required) {
        this.required = required;
    }


    /**
     * Gets the restrictedAdminField value for this CustomField.
     * 
     * @return restrictedAdminField
     */
    public java.lang.Boolean getRestrictedAdminField() {
        return restrictedAdminField;
    }


    /**
     * Sets the restrictedAdminField value for this CustomField.
     * 
     * @param restrictedAdminField
     */
    public void setRestrictedAdminField(java.lang.Boolean restrictedAdminField) {
        this.restrictedAdminField = restrictedAdminField;
    }


    /**
     * Gets the scale value for this CustomField.
     * 
     * @return scale
     */
    public java.lang.Integer getScale() {
        return scale;
    }


    /**
     * Sets the scale value for this CustomField.
     * 
     * @param scale
     */
    public void setScale(java.lang.Integer scale) {
        this.scale = scale;
    }


    /**
     * Gets the startingNumber value for this CustomField.
     * 
     * @return startingNumber
     */
    public java.lang.Integer getStartingNumber() {
        return startingNumber;
    }


    /**
     * Sets the startingNumber value for this CustomField.
     * 
     * @param startingNumber
     */
    public void setStartingNumber(java.lang.Integer startingNumber) {
        this.startingNumber = startingNumber;
    }


    /**
     * Gets the summarizedField value for this CustomField.
     * 
     * @return summarizedField
     */
    public java.lang.String getSummarizedField() {
        return summarizedField;
    }


    /**
     * Sets the summarizedField value for this CustomField.
     * 
     * @param summarizedField
     */
    public void setSummarizedField(java.lang.String summarizedField) {
        this.summarizedField = summarizedField;
    }


    /**
     * Gets the summaryFilterItems value for this CustomField.
     * 
     * @return summaryFilterItems
     */
    public com.sforce.soap._2006._04.metadata.FilterItem[] getSummaryFilterItems() {
        return summaryFilterItems;
    }


    /**
     * Sets the summaryFilterItems value for this CustomField.
     * 
     * @param summaryFilterItems
     */
    public void setSummaryFilterItems(com.sforce.soap._2006._04.metadata.FilterItem[] summaryFilterItems) {
        this.summaryFilterItems = summaryFilterItems;
    }

    public com.sforce.soap._2006._04.metadata.FilterItem getSummaryFilterItems(int i) {
        return this.summaryFilterItems[i];
    }

    public void setSummaryFilterItems(int i, com.sforce.soap._2006._04.metadata.FilterItem _value) {
        this.summaryFilterItems[i] = _value;
    }


    /**
     * Gets the summaryForeignKey value for this CustomField.
     * 
     * @return summaryForeignKey
     */
    public java.lang.String getSummaryForeignKey() {
        return summaryForeignKey;
    }


    /**
     * Sets the summaryForeignKey value for this CustomField.
     * 
     * @param summaryForeignKey
     */
    public void setSummaryForeignKey(java.lang.String summaryForeignKey) {
        this.summaryForeignKey = summaryForeignKey;
    }


    /**
     * Gets the summaryOperation value for this CustomField.
     * 
     * @return summaryOperation
     */
    public com.sforce.soap._2006._04.metadata.SummaryOperations getSummaryOperation() {
        return summaryOperation;
    }


    /**
     * Sets the summaryOperation value for this CustomField.
     * 
     * @param summaryOperation
     */
    public void setSummaryOperation(com.sforce.soap._2006._04.metadata.SummaryOperations summaryOperation) {
        this.summaryOperation = summaryOperation;
    }


    /**
     * Gets the trackHistory value for this CustomField.
     * 
     * @return trackHistory
     */
    public java.lang.Boolean getTrackHistory() {
        return trackHistory;
    }


    /**
     * Sets the trackHistory value for this CustomField.
     * 
     * @param trackHistory
     */
    public void setTrackHistory(java.lang.Boolean trackHistory) {
        this.trackHistory = trackHistory;
    }


    /**
     * Gets the type value for this CustomField.
     * 
     * @return type
     */
    public com.sforce.soap._2006._04.metadata.FieldType getType() {
        return type;
    }


    /**
     * Sets the type value for this CustomField.
     * 
     * @param type
     */
    public void setType(com.sforce.soap._2006._04.metadata.FieldType type) {
        this.type = type;
    }


    /**
     * Gets the unique value for this CustomField.
     * 
     * @return unique
     */
    public java.lang.Boolean getUnique() {
        return unique;
    }


    /**
     * Sets the unique value for this CustomField.
     * 
     * @param unique
     */
    public void setUnique(java.lang.Boolean unique) {
        this.unique = unique;
    }


    /**
     * Gets the visibleLines value for this CustomField.
     * 
     * @return visibleLines
     */
    public java.lang.Integer getVisibleLines() {
        return visibleLines;
    }


    /**
     * Sets the visibleLines value for this CustomField.
     * 
     * @param visibleLines
     */
    public void setVisibleLines(java.lang.Integer visibleLines) {
        this.visibleLines = visibleLines;
    }


    /**
     * Gets the writeRequiresMasterRead value for this CustomField.
     * 
     * @return writeRequiresMasterRead
     */
    public java.lang.Boolean getWriteRequiresMasterRead() {
        return writeRequiresMasterRead;
    }


    /**
     * Sets the writeRequiresMasterRead value for this CustomField.
     * 
     * @param writeRequiresMasterRead
     */
    public void setWriteRequiresMasterRead(java.lang.Boolean writeRequiresMasterRead) {
        this.writeRequiresMasterRead = writeRequiresMasterRead;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CustomField)) return false;
        CustomField other = (CustomField) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.caseSensitive==null && other.getCaseSensitive()==null) || 
             (this.caseSensitive!=null &&
              this.caseSensitive.equals(other.getCaseSensitive()))) &&
            ((this.customDataType==null && other.getCustomDataType()==null) || 
             (this.customDataType!=null &&
              this.customDataType.equals(other.getCustomDataType()))) &&
            ((this.defaultValue==null && other.getDefaultValue()==null) || 
             (this.defaultValue!=null &&
              this.defaultValue.equals(other.getDefaultValue()))) &&
            ((this.description==null && other.getDescription()==null) || 
             (this.description!=null &&
              this.description.equals(other.getDescription()))) &&
            ((this.displayFormat==null && other.getDisplayFormat()==null) || 
             (this.displayFormat!=null &&
              this.displayFormat.equals(other.getDisplayFormat()))) &&
            ((this.externalId==null && other.getExternalId()==null) || 
             (this.externalId!=null &&
              this.externalId.equals(other.getExternalId()))) &&
            ((this.formula==null && other.getFormula()==null) || 
             (this.formula!=null &&
              this.formula.equals(other.getFormula()))) &&
            ((this.formulaTreatBlanksAs==null && other.getFormulaTreatBlanksAs()==null) || 
             (this.formulaTreatBlanksAs!=null &&
              this.formulaTreatBlanksAs.equals(other.getFormulaTreatBlanksAs()))) &&
            ((this.inlineHelpText==null && other.getInlineHelpText()==null) || 
             (this.inlineHelpText!=null &&
              this.inlineHelpText.equals(other.getInlineHelpText()))) &&
            ((this.label==null && other.getLabel()==null) || 
             (this.label!=null &&
              this.label.equals(other.getLabel()))) &&
            ((this.length==null && other.getLength()==null) || 
             (this.length!=null &&
              this.length.equals(other.getLength()))) &&
            ((this.maskChar==null && other.getMaskChar()==null) || 
             (this.maskChar!=null &&
              this.maskChar.equals(other.getMaskChar()))) &&
            ((this.maskType==null && other.getMaskType()==null) || 
             (this.maskType!=null &&
              this.maskType.equals(other.getMaskType()))) &&
            ((this.picklist==null && other.getPicklist()==null) || 
             (this.picklist!=null &&
              this.picklist.equals(other.getPicklist()))) &&
            ((this.populateExistingRows==null && other.getPopulateExistingRows()==null) || 
             (this.populateExistingRows!=null &&
              this.populateExistingRows.equals(other.getPopulateExistingRows()))) &&
            ((this.precision==null && other.getPrecision()==null) || 
             (this.precision!=null &&
              this.precision.equals(other.getPrecision()))) &&
            ((this.referenceTo==null && other.getReferenceTo()==null) || 
             (this.referenceTo!=null &&
              this.referenceTo.equals(other.getReferenceTo()))) &&
            ((this.relationshipLabel==null && other.getRelationshipLabel()==null) || 
             (this.relationshipLabel!=null &&
              this.relationshipLabel.equals(other.getRelationshipLabel()))) &&
            ((this.relationshipName==null && other.getRelationshipName()==null) || 
             (this.relationshipName!=null &&
              this.relationshipName.equals(other.getRelationshipName()))) &&
            ((this.relationshipOrder==null && other.getRelationshipOrder()==null) || 
             (this.relationshipOrder!=null &&
              this.relationshipOrder.equals(other.getRelationshipOrder()))) &&
            ((this.required==null && other.getRequired()==null) || 
             (this.required!=null &&
              this.required.equals(other.getRequired()))) &&
            ((this.restrictedAdminField==null && other.getRestrictedAdminField()==null) || 
             (this.restrictedAdminField!=null &&
              this.restrictedAdminField.equals(other.getRestrictedAdminField()))) &&
            ((this.scale==null && other.getScale()==null) || 
             (this.scale!=null &&
              this.scale.equals(other.getScale()))) &&
            ((this.startingNumber==null && other.getStartingNumber()==null) || 
             (this.startingNumber!=null &&
              this.startingNumber.equals(other.getStartingNumber()))) &&
            ((this.summarizedField==null && other.getSummarizedField()==null) || 
             (this.summarizedField!=null &&
              this.summarizedField.equals(other.getSummarizedField()))) &&
            ((this.summaryFilterItems==null && other.getSummaryFilterItems()==null) || 
             (this.summaryFilterItems!=null &&
              java.util.Arrays.equals(this.summaryFilterItems, other.getSummaryFilterItems()))) &&
            ((this.summaryForeignKey==null && other.getSummaryForeignKey()==null) || 
             (this.summaryForeignKey!=null &&
              this.summaryForeignKey.equals(other.getSummaryForeignKey()))) &&
            ((this.summaryOperation==null && other.getSummaryOperation()==null) || 
             (this.summaryOperation!=null &&
              this.summaryOperation.equals(other.getSummaryOperation()))) &&
            ((this.trackHistory==null && other.getTrackHistory()==null) || 
             (this.trackHistory!=null &&
              this.trackHistory.equals(other.getTrackHistory()))) &&
            ((this.type==null && other.getType()==null) || 
             (this.type!=null &&
              this.type.equals(other.getType()))) &&
            ((this.unique==null && other.getUnique()==null) || 
             (this.unique!=null &&
              this.unique.equals(other.getUnique()))) &&
            ((this.visibleLines==null && other.getVisibleLines()==null) || 
             (this.visibleLines!=null &&
              this.visibleLines.equals(other.getVisibleLines()))) &&
            ((this.writeRequiresMasterRead==null && other.getWriteRequiresMasterRead()==null) || 
             (this.writeRequiresMasterRead!=null &&
              this.writeRequiresMasterRead.equals(other.getWriteRequiresMasterRead())));
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
        if (getCaseSensitive() != null) {
            _hashCode += getCaseSensitive().hashCode();
        }
        if (getCustomDataType() != null) {
            _hashCode += getCustomDataType().hashCode();
        }
        if (getDefaultValue() != null) {
            _hashCode += getDefaultValue().hashCode();
        }
        if (getDescription() != null) {
            _hashCode += getDescription().hashCode();
        }
        if (getDisplayFormat() != null) {
            _hashCode += getDisplayFormat().hashCode();
        }
        if (getExternalId() != null) {
            _hashCode += getExternalId().hashCode();
        }
        if (getFormula() != null) {
            _hashCode += getFormula().hashCode();
        }
        if (getFormulaTreatBlanksAs() != null) {
            _hashCode += getFormulaTreatBlanksAs().hashCode();
        }
        if (getInlineHelpText() != null) {
            _hashCode += getInlineHelpText().hashCode();
        }
        if (getLabel() != null) {
            _hashCode += getLabel().hashCode();
        }
        if (getLength() != null) {
            _hashCode += getLength().hashCode();
        }
        if (getMaskChar() != null) {
            _hashCode += getMaskChar().hashCode();
        }
        if (getMaskType() != null) {
            _hashCode += getMaskType().hashCode();
        }
        if (getPicklist() != null) {
            _hashCode += getPicklist().hashCode();
        }
        if (getPopulateExistingRows() != null) {
            _hashCode += getPopulateExistingRows().hashCode();
        }
        if (getPrecision() != null) {
            _hashCode += getPrecision().hashCode();
        }
        if (getReferenceTo() != null) {
            _hashCode += getReferenceTo().hashCode();
        }
        if (getRelationshipLabel() != null) {
            _hashCode += getRelationshipLabel().hashCode();
        }
        if (getRelationshipName() != null) {
            _hashCode += getRelationshipName().hashCode();
        }
        if (getRelationshipOrder() != null) {
            _hashCode += getRelationshipOrder().hashCode();
        }
        if (getRequired() != null) {
            _hashCode += getRequired().hashCode();
        }
        if (getRestrictedAdminField() != null) {
            _hashCode += getRestrictedAdminField().hashCode();
        }
        if (getScale() != null) {
            _hashCode += getScale().hashCode();
        }
        if (getStartingNumber() != null) {
            _hashCode += getStartingNumber().hashCode();
        }
        if (getSummarizedField() != null) {
            _hashCode += getSummarizedField().hashCode();
        }
        if (getSummaryFilterItems() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getSummaryFilterItems());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getSummaryFilterItems(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getSummaryForeignKey() != null) {
            _hashCode += getSummaryForeignKey().hashCode();
        }
        if (getSummaryOperation() != null) {
            _hashCode += getSummaryOperation().hashCode();
        }
        if (getTrackHistory() != null) {
            _hashCode += getTrackHistory().hashCode();
        }
        if (getType() != null) {
            _hashCode += getType().hashCode();
        }
        if (getUnique() != null) {
            _hashCode += getUnique().hashCode();
        }
        if (getVisibleLines() != null) {
            _hashCode += getVisibleLines().hashCode();
        }
        if (getWriteRequiresMasterRead() != null) {
            _hashCode += getWriteRequiresMasterRead().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CustomField.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "CustomField"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("caseSensitive");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "caseSensitive"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("customDataType");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "customDataType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("defaultValue");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "defaultValue"));
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
        elemField.setFieldName("displayFormat");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "displayFormat"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("externalId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "externalId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
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
        elemField.setFieldName("formulaTreatBlanksAs");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "formulaTreatBlanksAs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "TreatBlanksAs"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("inlineHelpText");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "inlineHelpText"));
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
        elemField.setFieldName("length");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "length"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("maskChar");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "maskChar"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "EncryptedFieldMaskChar"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("maskType");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "maskType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "EncryptedFieldMaskType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("picklist");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "picklist"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "Picklist"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("populateExistingRows");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "populateExistingRows"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("precision");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "precision"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("referenceTo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "referenceTo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("relationshipLabel");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "relationshipLabel"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("relationshipName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "relationshipName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("relationshipOrder");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "relationshipOrder"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("required");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "required"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("restrictedAdminField");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "restrictedAdminField"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("scale");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "scale"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("startingNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "startingNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("summarizedField");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "summarizedField"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("summaryFilterItems");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "summaryFilterItems"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "FilterItem"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("summaryForeignKey");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "summaryForeignKey"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("summaryOperation");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "summaryOperation"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "SummaryOperations"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("trackHistory");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "trackHistory"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("type");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "type"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "FieldType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("unique");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "unique"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("visibleLines");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "visibleLines"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("writeRequiresMasterRead");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "writeRequiresMasterRead"));
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
