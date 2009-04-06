/**
 * ReportChart.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.sforce.soap._2006._04.metadata;

public class ReportChart  implements java.io.Serializable {
    private java.lang.String backgroundColor1;

    private java.lang.String backgroundColor2;

    private com.sforce.soap._2006._04.metadata.ChartBackgroundDirection backgroundFadeDir;

    private com.sforce.soap._2006._04.metadata.ChartType chartType;

    private java.lang.String groupingColumn;

    private com.sforce.soap._2006._04.metadata.ChartLegendPosition legendPosition;

    private com.sforce.soap._2006._04.metadata.ChartPosition location;

    private java.lang.String secondaryGroupingColumn;

    private java.lang.Boolean showAxisLabels;

    private com.sforce.soap._2006._04.metadata.ReportChartSize size;

    private com.sforce.soap._2006._04.metadata.ReportSummaryType summaryAggregate;

    private java.lang.Double summaryAxisManualRangeEnd;

    private java.lang.Double summaryAxisManualRangeStart;

    private com.sforce.soap._2006._04.metadata.ChartRangeType summaryAxisRange;

    private java.lang.String summaryColumn;

    private java.lang.String textColor;

    private java.lang.Integer textSize;

    private java.lang.String title;

    private java.lang.String titleColor;

    private java.lang.Integer titleSize;

    public ReportChart() {
    }

    public ReportChart(
           java.lang.String backgroundColor1,
           java.lang.String backgroundColor2,
           com.sforce.soap._2006._04.metadata.ChartBackgroundDirection backgroundFadeDir,
           com.sforce.soap._2006._04.metadata.ChartType chartType,
           java.lang.String groupingColumn,
           com.sforce.soap._2006._04.metadata.ChartLegendPosition legendPosition,
           com.sforce.soap._2006._04.metadata.ChartPosition location,
           java.lang.String secondaryGroupingColumn,
           java.lang.Boolean showAxisLabels,
           com.sforce.soap._2006._04.metadata.ReportChartSize size,
           com.sforce.soap._2006._04.metadata.ReportSummaryType summaryAggregate,
           java.lang.Double summaryAxisManualRangeEnd,
           java.lang.Double summaryAxisManualRangeStart,
           com.sforce.soap._2006._04.metadata.ChartRangeType summaryAxisRange,
           java.lang.String summaryColumn,
           java.lang.String textColor,
           java.lang.Integer textSize,
           java.lang.String title,
           java.lang.String titleColor,
           java.lang.Integer titleSize) {
           this.backgroundColor1 = backgroundColor1;
           this.backgroundColor2 = backgroundColor2;
           this.backgroundFadeDir = backgroundFadeDir;
           this.chartType = chartType;
           this.groupingColumn = groupingColumn;
           this.legendPosition = legendPosition;
           this.location = location;
           this.secondaryGroupingColumn = secondaryGroupingColumn;
           this.showAxisLabels = showAxisLabels;
           this.size = size;
           this.summaryAggregate = summaryAggregate;
           this.summaryAxisManualRangeEnd = summaryAxisManualRangeEnd;
           this.summaryAxisManualRangeStart = summaryAxisManualRangeStart;
           this.summaryAxisRange = summaryAxisRange;
           this.summaryColumn = summaryColumn;
           this.textColor = textColor;
           this.textSize = textSize;
           this.title = title;
           this.titleColor = titleColor;
           this.titleSize = titleSize;
    }


    /**
     * Gets the backgroundColor1 value for this ReportChart.
     * 
     * @return backgroundColor1
     */
    public java.lang.String getBackgroundColor1() {
        return backgroundColor1;
    }


    /**
     * Sets the backgroundColor1 value for this ReportChart.
     * 
     * @param backgroundColor1
     */
    public void setBackgroundColor1(java.lang.String backgroundColor1) {
        this.backgroundColor1 = backgroundColor1;
    }


    /**
     * Gets the backgroundColor2 value for this ReportChart.
     * 
     * @return backgroundColor2
     */
    public java.lang.String getBackgroundColor2() {
        return backgroundColor2;
    }


    /**
     * Sets the backgroundColor2 value for this ReportChart.
     * 
     * @param backgroundColor2
     */
    public void setBackgroundColor2(java.lang.String backgroundColor2) {
        this.backgroundColor2 = backgroundColor2;
    }


    /**
     * Gets the backgroundFadeDir value for this ReportChart.
     * 
     * @return backgroundFadeDir
     */
    public com.sforce.soap._2006._04.metadata.ChartBackgroundDirection getBackgroundFadeDir() {
        return backgroundFadeDir;
    }


    /**
     * Sets the backgroundFadeDir value for this ReportChart.
     * 
     * @param backgroundFadeDir
     */
    public void setBackgroundFadeDir(com.sforce.soap._2006._04.metadata.ChartBackgroundDirection backgroundFadeDir) {
        this.backgroundFadeDir = backgroundFadeDir;
    }


    /**
     * Gets the chartType value for this ReportChart.
     * 
     * @return chartType
     */
    public com.sforce.soap._2006._04.metadata.ChartType getChartType() {
        return chartType;
    }


    /**
     * Sets the chartType value for this ReportChart.
     * 
     * @param chartType
     */
    public void setChartType(com.sforce.soap._2006._04.metadata.ChartType chartType) {
        this.chartType = chartType;
    }


    /**
     * Gets the groupingColumn value for this ReportChart.
     * 
     * @return groupingColumn
     */
    public java.lang.String getGroupingColumn() {
        return groupingColumn;
    }


    /**
     * Sets the groupingColumn value for this ReportChart.
     * 
     * @param groupingColumn
     */
    public void setGroupingColumn(java.lang.String groupingColumn) {
        this.groupingColumn = groupingColumn;
    }


    /**
     * Gets the legendPosition value for this ReportChart.
     * 
     * @return legendPosition
     */
    public com.sforce.soap._2006._04.metadata.ChartLegendPosition getLegendPosition() {
        return legendPosition;
    }


    /**
     * Sets the legendPosition value for this ReportChart.
     * 
     * @param legendPosition
     */
    public void setLegendPosition(com.sforce.soap._2006._04.metadata.ChartLegendPosition legendPosition) {
        this.legendPosition = legendPosition;
    }


    /**
     * Gets the location value for this ReportChart.
     * 
     * @return location
     */
    public com.sforce.soap._2006._04.metadata.ChartPosition getLocation() {
        return location;
    }


    /**
     * Sets the location value for this ReportChart.
     * 
     * @param location
     */
    public void setLocation(com.sforce.soap._2006._04.metadata.ChartPosition location) {
        this.location = location;
    }


    /**
     * Gets the secondaryGroupingColumn value for this ReportChart.
     * 
     * @return secondaryGroupingColumn
     */
    public java.lang.String getSecondaryGroupingColumn() {
        return secondaryGroupingColumn;
    }


    /**
     * Sets the secondaryGroupingColumn value for this ReportChart.
     * 
     * @param secondaryGroupingColumn
     */
    public void setSecondaryGroupingColumn(java.lang.String secondaryGroupingColumn) {
        this.secondaryGroupingColumn = secondaryGroupingColumn;
    }


    /**
     * Gets the showAxisLabels value for this ReportChart.
     * 
     * @return showAxisLabels
     */
    public java.lang.Boolean getShowAxisLabels() {
        return showAxisLabels;
    }


    /**
     * Sets the showAxisLabels value for this ReportChart.
     * 
     * @param showAxisLabels
     */
    public void setShowAxisLabels(java.lang.Boolean showAxisLabels) {
        this.showAxisLabels = showAxisLabels;
    }


    /**
     * Gets the size value for this ReportChart.
     * 
     * @return size
     */
    public com.sforce.soap._2006._04.metadata.ReportChartSize getSize() {
        return size;
    }


    /**
     * Sets the size value for this ReportChart.
     * 
     * @param size
     */
    public void setSize(com.sforce.soap._2006._04.metadata.ReportChartSize size) {
        this.size = size;
    }


    /**
     * Gets the summaryAggregate value for this ReportChart.
     * 
     * @return summaryAggregate
     */
    public com.sforce.soap._2006._04.metadata.ReportSummaryType getSummaryAggregate() {
        return summaryAggregate;
    }


    /**
     * Sets the summaryAggregate value for this ReportChart.
     * 
     * @param summaryAggregate
     */
    public void setSummaryAggregate(com.sforce.soap._2006._04.metadata.ReportSummaryType summaryAggregate) {
        this.summaryAggregate = summaryAggregate;
    }


    /**
     * Gets the summaryAxisManualRangeEnd value for this ReportChart.
     * 
     * @return summaryAxisManualRangeEnd
     */
    public java.lang.Double getSummaryAxisManualRangeEnd() {
        return summaryAxisManualRangeEnd;
    }


    /**
     * Sets the summaryAxisManualRangeEnd value for this ReportChart.
     * 
     * @param summaryAxisManualRangeEnd
     */
    public void setSummaryAxisManualRangeEnd(java.lang.Double summaryAxisManualRangeEnd) {
        this.summaryAxisManualRangeEnd = summaryAxisManualRangeEnd;
    }


    /**
     * Gets the summaryAxisManualRangeStart value for this ReportChart.
     * 
     * @return summaryAxisManualRangeStart
     */
    public java.lang.Double getSummaryAxisManualRangeStart() {
        return summaryAxisManualRangeStart;
    }


    /**
     * Sets the summaryAxisManualRangeStart value for this ReportChart.
     * 
     * @param summaryAxisManualRangeStart
     */
    public void setSummaryAxisManualRangeStart(java.lang.Double summaryAxisManualRangeStart) {
        this.summaryAxisManualRangeStart = summaryAxisManualRangeStart;
    }


    /**
     * Gets the summaryAxisRange value for this ReportChart.
     * 
     * @return summaryAxisRange
     */
    public com.sforce.soap._2006._04.metadata.ChartRangeType getSummaryAxisRange() {
        return summaryAxisRange;
    }


    /**
     * Sets the summaryAxisRange value for this ReportChart.
     * 
     * @param summaryAxisRange
     */
    public void setSummaryAxisRange(com.sforce.soap._2006._04.metadata.ChartRangeType summaryAxisRange) {
        this.summaryAxisRange = summaryAxisRange;
    }


    /**
     * Gets the summaryColumn value for this ReportChart.
     * 
     * @return summaryColumn
     */
    public java.lang.String getSummaryColumn() {
        return summaryColumn;
    }


    /**
     * Sets the summaryColumn value for this ReportChart.
     * 
     * @param summaryColumn
     */
    public void setSummaryColumn(java.lang.String summaryColumn) {
        this.summaryColumn = summaryColumn;
    }


    /**
     * Gets the textColor value for this ReportChart.
     * 
     * @return textColor
     */
    public java.lang.String getTextColor() {
        return textColor;
    }


    /**
     * Sets the textColor value for this ReportChart.
     * 
     * @param textColor
     */
    public void setTextColor(java.lang.String textColor) {
        this.textColor = textColor;
    }


    /**
     * Gets the textSize value for this ReportChart.
     * 
     * @return textSize
     */
    public java.lang.Integer getTextSize() {
        return textSize;
    }


    /**
     * Sets the textSize value for this ReportChart.
     * 
     * @param textSize
     */
    public void setTextSize(java.lang.Integer textSize) {
        this.textSize = textSize;
    }


    /**
     * Gets the title value for this ReportChart.
     * 
     * @return title
     */
    public java.lang.String getTitle() {
        return title;
    }


    /**
     * Sets the title value for this ReportChart.
     * 
     * @param title
     */
    public void setTitle(java.lang.String title) {
        this.title = title;
    }


    /**
     * Gets the titleColor value for this ReportChart.
     * 
     * @return titleColor
     */
    public java.lang.String getTitleColor() {
        return titleColor;
    }


    /**
     * Sets the titleColor value for this ReportChart.
     * 
     * @param titleColor
     */
    public void setTitleColor(java.lang.String titleColor) {
        this.titleColor = titleColor;
    }


    /**
     * Gets the titleSize value for this ReportChart.
     * 
     * @return titleSize
     */
    public java.lang.Integer getTitleSize() {
        return titleSize;
    }


    /**
     * Sets the titleSize value for this ReportChart.
     * 
     * @param titleSize
     */
    public void setTitleSize(java.lang.Integer titleSize) {
        this.titleSize = titleSize;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ReportChart)) return false;
        ReportChart other = (ReportChart) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.backgroundColor1==null && other.getBackgroundColor1()==null) || 
             (this.backgroundColor1!=null &&
              this.backgroundColor1.equals(other.getBackgroundColor1()))) &&
            ((this.backgroundColor2==null && other.getBackgroundColor2()==null) || 
             (this.backgroundColor2!=null &&
              this.backgroundColor2.equals(other.getBackgroundColor2()))) &&
            ((this.backgroundFadeDir==null && other.getBackgroundFadeDir()==null) || 
             (this.backgroundFadeDir!=null &&
              this.backgroundFadeDir.equals(other.getBackgroundFadeDir()))) &&
            ((this.chartType==null && other.getChartType()==null) || 
             (this.chartType!=null &&
              this.chartType.equals(other.getChartType()))) &&
            ((this.groupingColumn==null && other.getGroupingColumn()==null) || 
             (this.groupingColumn!=null &&
              this.groupingColumn.equals(other.getGroupingColumn()))) &&
            ((this.legendPosition==null && other.getLegendPosition()==null) || 
             (this.legendPosition!=null &&
              this.legendPosition.equals(other.getLegendPosition()))) &&
            ((this.location==null && other.getLocation()==null) || 
             (this.location!=null &&
              this.location.equals(other.getLocation()))) &&
            ((this.secondaryGroupingColumn==null && other.getSecondaryGroupingColumn()==null) || 
             (this.secondaryGroupingColumn!=null &&
              this.secondaryGroupingColumn.equals(other.getSecondaryGroupingColumn()))) &&
            ((this.showAxisLabels==null && other.getShowAxisLabels()==null) || 
             (this.showAxisLabels!=null &&
              this.showAxisLabels.equals(other.getShowAxisLabels()))) &&
            ((this.size==null && other.getSize()==null) || 
             (this.size!=null &&
              this.size.equals(other.getSize()))) &&
            ((this.summaryAggregate==null && other.getSummaryAggregate()==null) || 
             (this.summaryAggregate!=null &&
              this.summaryAggregate.equals(other.getSummaryAggregate()))) &&
            ((this.summaryAxisManualRangeEnd==null && other.getSummaryAxisManualRangeEnd()==null) || 
             (this.summaryAxisManualRangeEnd!=null &&
              this.summaryAxisManualRangeEnd.equals(other.getSummaryAxisManualRangeEnd()))) &&
            ((this.summaryAxisManualRangeStart==null && other.getSummaryAxisManualRangeStart()==null) || 
             (this.summaryAxisManualRangeStart!=null &&
              this.summaryAxisManualRangeStart.equals(other.getSummaryAxisManualRangeStart()))) &&
            ((this.summaryAxisRange==null && other.getSummaryAxisRange()==null) || 
             (this.summaryAxisRange!=null &&
              this.summaryAxisRange.equals(other.getSummaryAxisRange()))) &&
            ((this.summaryColumn==null && other.getSummaryColumn()==null) || 
             (this.summaryColumn!=null &&
              this.summaryColumn.equals(other.getSummaryColumn()))) &&
            ((this.textColor==null && other.getTextColor()==null) || 
             (this.textColor!=null &&
              this.textColor.equals(other.getTextColor()))) &&
            ((this.textSize==null && other.getTextSize()==null) || 
             (this.textSize!=null &&
              this.textSize.equals(other.getTextSize()))) &&
            ((this.title==null && other.getTitle()==null) || 
             (this.title!=null &&
              this.title.equals(other.getTitle()))) &&
            ((this.titleColor==null && other.getTitleColor()==null) || 
             (this.titleColor!=null &&
              this.titleColor.equals(other.getTitleColor()))) &&
            ((this.titleSize==null && other.getTitleSize()==null) || 
             (this.titleSize!=null &&
              this.titleSize.equals(other.getTitleSize())));
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
        if (getBackgroundColor1() != null) {
            _hashCode += getBackgroundColor1().hashCode();
        }
        if (getBackgroundColor2() != null) {
            _hashCode += getBackgroundColor2().hashCode();
        }
        if (getBackgroundFadeDir() != null) {
            _hashCode += getBackgroundFadeDir().hashCode();
        }
        if (getChartType() != null) {
            _hashCode += getChartType().hashCode();
        }
        if (getGroupingColumn() != null) {
            _hashCode += getGroupingColumn().hashCode();
        }
        if (getLegendPosition() != null) {
            _hashCode += getLegendPosition().hashCode();
        }
        if (getLocation() != null) {
            _hashCode += getLocation().hashCode();
        }
        if (getSecondaryGroupingColumn() != null) {
            _hashCode += getSecondaryGroupingColumn().hashCode();
        }
        if (getShowAxisLabels() != null) {
            _hashCode += getShowAxisLabels().hashCode();
        }
        if (getSize() != null) {
            _hashCode += getSize().hashCode();
        }
        if (getSummaryAggregate() != null) {
            _hashCode += getSummaryAggregate().hashCode();
        }
        if (getSummaryAxisManualRangeEnd() != null) {
            _hashCode += getSummaryAxisManualRangeEnd().hashCode();
        }
        if (getSummaryAxisManualRangeStart() != null) {
            _hashCode += getSummaryAxisManualRangeStart().hashCode();
        }
        if (getSummaryAxisRange() != null) {
            _hashCode += getSummaryAxisRange().hashCode();
        }
        if (getSummaryColumn() != null) {
            _hashCode += getSummaryColumn().hashCode();
        }
        if (getTextColor() != null) {
            _hashCode += getTextColor().hashCode();
        }
        if (getTextSize() != null) {
            _hashCode += getTextSize().hashCode();
        }
        if (getTitle() != null) {
            _hashCode += getTitle().hashCode();
        }
        if (getTitleColor() != null) {
            _hashCode += getTitleColor().hashCode();
        }
        if (getTitleSize() != null) {
            _hashCode += getTitleSize().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ReportChart.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "ReportChart"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("backgroundColor1");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "backgroundColor1"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("backgroundColor2");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "backgroundColor2"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("backgroundFadeDir");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "backgroundFadeDir"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "ChartBackgroundDirection"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("chartType");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "chartType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "ChartType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("groupingColumn");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "groupingColumn"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("legendPosition");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "legendPosition"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "ChartLegendPosition"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("location");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "location"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "ChartPosition"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("secondaryGroupingColumn");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "secondaryGroupingColumn"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("showAxisLabels");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "showAxisLabels"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("size");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "size"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "ReportChartSize"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("summaryAggregate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "summaryAggregate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "ReportSummaryType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("summaryAxisManualRangeEnd");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "summaryAxisManualRangeEnd"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("summaryAxisManualRangeStart");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "summaryAxisManualRangeStart"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("summaryAxisRange");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "summaryAxisRange"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "ChartRangeType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("summaryColumn");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "summaryColumn"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("textColor");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "textColor"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("textSize");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "textSize"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("title");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "title"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("titleColor");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "titleColor"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("titleSize");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "titleSize"));
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
