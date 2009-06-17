/**
 * DashboardComponent.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.sforce.soap._2006._04.metadata;

public class DashboardComponent  implements java.io.Serializable {
    private com.sforce.soap._2006._04.metadata.ChartRangeType chartAxisRange;

    private java.lang.Double chartAxisRangeMax;

    private java.lang.Double chartAxisRangeMin;

    private com.sforce.soap._2006._04.metadata.DashboardComponentType componentType;

    private com.sforce.soap._2006._04.metadata.ChartUnits displayUnits;

    private java.lang.String drillDownUrl;

    private java.lang.String footer;

    private java.lang.Double gaugeMax;

    private java.lang.Double gaugeMin;

    private java.lang.String header;

    private java.lang.Double indicatorBreakpoint1;

    private java.lang.Double indicatorBreakpoint2;

    private java.lang.String indicatorHighColor;

    private java.lang.String indicatorLowColor;

    private java.lang.String indicatorMiddleColor;

    private com.sforce.soap._2006._04.metadata.ChartLegendPosition legendPosition;

    private java.lang.Integer maxValuesDisplayed;

    private java.lang.String metricLabel;

    private java.lang.String report;

    private java.lang.String scontrol;

    private java.lang.Integer scontrolHeightInPixels;

    private com.sforce.soap._2006._04.metadata.DashboardComponentFilter sortBy;

    private java.lang.String title;

    public DashboardComponent() {
    }

    public DashboardComponent(
           com.sforce.soap._2006._04.metadata.ChartRangeType chartAxisRange,
           java.lang.Double chartAxisRangeMax,
           java.lang.Double chartAxisRangeMin,
           com.sforce.soap._2006._04.metadata.DashboardComponentType componentType,
           com.sforce.soap._2006._04.metadata.ChartUnits displayUnits,
           java.lang.String drillDownUrl,
           java.lang.String footer,
           java.lang.Double gaugeMax,
           java.lang.Double gaugeMin,
           java.lang.String header,
           java.lang.Double indicatorBreakpoint1,
           java.lang.Double indicatorBreakpoint2,
           java.lang.String indicatorHighColor,
           java.lang.String indicatorLowColor,
           java.lang.String indicatorMiddleColor,
           com.sforce.soap._2006._04.metadata.ChartLegendPosition legendPosition,
           java.lang.Integer maxValuesDisplayed,
           java.lang.String metricLabel,
           java.lang.String report,
           java.lang.String scontrol,
           java.lang.Integer scontrolHeightInPixels,
           com.sforce.soap._2006._04.metadata.DashboardComponentFilter sortBy,
           java.lang.String title) {
           this.chartAxisRange = chartAxisRange;
           this.chartAxisRangeMax = chartAxisRangeMax;
           this.chartAxisRangeMin = chartAxisRangeMin;
           this.componentType = componentType;
           this.displayUnits = displayUnits;
           this.drillDownUrl = drillDownUrl;
           this.footer = footer;
           this.gaugeMax = gaugeMax;
           this.gaugeMin = gaugeMin;
           this.header = header;
           this.indicatorBreakpoint1 = indicatorBreakpoint1;
           this.indicatorBreakpoint2 = indicatorBreakpoint2;
           this.indicatorHighColor = indicatorHighColor;
           this.indicatorLowColor = indicatorLowColor;
           this.indicatorMiddleColor = indicatorMiddleColor;
           this.legendPosition = legendPosition;
           this.maxValuesDisplayed = maxValuesDisplayed;
           this.metricLabel = metricLabel;
           this.report = report;
           this.scontrol = scontrol;
           this.scontrolHeightInPixels = scontrolHeightInPixels;
           this.sortBy = sortBy;
           this.title = title;
    }


    /**
     * Gets the chartAxisRange value for this DashboardComponent.
     * 
     * @return chartAxisRange
     */
    public com.sforce.soap._2006._04.metadata.ChartRangeType getChartAxisRange() {
        return chartAxisRange;
    }


    /**
     * Sets the chartAxisRange value for this DashboardComponent.
     * 
     * @param chartAxisRange
     */
    public void setChartAxisRange(com.sforce.soap._2006._04.metadata.ChartRangeType chartAxisRange) {
        this.chartAxisRange = chartAxisRange;
    }


    /**
     * Gets the chartAxisRangeMax value for this DashboardComponent.
     * 
     * @return chartAxisRangeMax
     */
    public java.lang.Double getChartAxisRangeMax() {
        return chartAxisRangeMax;
    }


    /**
     * Sets the chartAxisRangeMax value for this DashboardComponent.
     * 
     * @param chartAxisRangeMax
     */
    public void setChartAxisRangeMax(java.lang.Double chartAxisRangeMax) {
        this.chartAxisRangeMax = chartAxisRangeMax;
    }


    /**
     * Gets the chartAxisRangeMin value for this DashboardComponent.
     * 
     * @return chartAxisRangeMin
     */
    public java.lang.Double getChartAxisRangeMin() {
        return chartAxisRangeMin;
    }


    /**
     * Sets the chartAxisRangeMin value for this DashboardComponent.
     * 
     * @param chartAxisRangeMin
     */
    public void setChartAxisRangeMin(java.lang.Double chartAxisRangeMin) {
        this.chartAxisRangeMin = chartAxisRangeMin;
    }


    /**
     * Gets the componentType value for this DashboardComponent.
     * 
     * @return componentType
     */
    public com.sforce.soap._2006._04.metadata.DashboardComponentType getComponentType() {
        return componentType;
    }


    /**
     * Sets the componentType value for this DashboardComponent.
     * 
     * @param componentType
     */
    public void setComponentType(com.sforce.soap._2006._04.metadata.DashboardComponentType componentType) {
        this.componentType = componentType;
    }


    /**
     * Gets the displayUnits value for this DashboardComponent.
     * 
     * @return displayUnits
     */
    public com.sforce.soap._2006._04.metadata.ChartUnits getDisplayUnits() {
        return displayUnits;
    }


    /**
     * Sets the displayUnits value for this DashboardComponent.
     * 
     * @param displayUnits
     */
    public void setDisplayUnits(com.sforce.soap._2006._04.metadata.ChartUnits displayUnits) {
        this.displayUnits = displayUnits;
    }


    /**
     * Gets the drillDownUrl value for this DashboardComponent.
     * 
     * @return drillDownUrl
     */
    public java.lang.String getDrillDownUrl() {
        return drillDownUrl;
    }


    /**
     * Sets the drillDownUrl value for this DashboardComponent.
     * 
     * @param drillDownUrl
     */
    public void setDrillDownUrl(java.lang.String drillDownUrl) {
        this.drillDownUrl = drillDownUrl;
    }


    /**
     * Gets the footer value for this DashboardComponent.
     * 
     * @return footer
     */
    public java.lang.String getFooter() {
        return footer;
    }


    /**
     * Sets the footer value for this DashboardComponent.
     * 
     * @param footer
     */
    public void setFooter(java.lang.String footer) {
        this.footer = footer;
    }


    /**
     * Gets the gaugeMax value for this DashboardComponent.
     * 
     * @return gaugeMax
     */
    public java.lang.Double getGaugeMax() {
        return gaugeMax;
    }


    /**
     * Sets the gaugeMax value for this DashboardComponent.
     * 
     * @param gaugeMax
     */
    public void setGaugeMax(java.lang.Double gaugeMax) {
        this.gaugeMax = gaugeMax;
    }


    /**
     * Gets the gaugeMin value for this DashboardComponent.
     * 
     * @return gaugeMin
     */
    public java.lang.Double getGaugeMin() {
        return gaugeMin;
    }


    /**
     * Sets the gaugeMin value for this DashboardComponent.
     * 
     * @param gaugeMin
     */
    public void setGaugeMin(java.lang.Double gaugeMin) {
        this.gaugeMin = gaugeMin;
    }


    /**
     * Gets the header value for this DashboardComponent.
     * 
     * @return header
     */
    public java.lang.String getHeader() {
        return header;
    }


    /**
     * Sets the header value for this DashboardComponent.
     * 
     * @param header
     */
    public void setHeader(java.lang.String header) {
        this.header = header;
    }


    /**
     * Gets the indicatorBreakpoint1 value for this DashboardComponent.
     * 
     * @return indicatorBreakpoint1
     */
    public java.lang.Double getIndicatorBreakpoint1() {
        return indicatorBreakpoint1;
    }


    /**
     * Sets the indicatorBreakpoint1 value for this DashboardComponent.
     * 
     * @param indicatorBreakpoint1
     */
    public void setIndicatorBreakpoint1(java.lang.Double indicatorBreakpoint1) {
        this.indicatorBreakpoint1 = indicatorBreakpoint1;
    }


    /**
     * Gets the indicatorBreakpoint2 value for this DashboardComponent.
     * 
     * @return indicatorBreakpoint2
     */
    public java.lang.Double getIndicatorBreakpoint2() {
        return indicatorBreakpoint2;
    }


    /**
     * Sets the indicatorBreakpoint2 value for this DashboardComponent.
     * 
     * @param indicatorBreakpoint2
     */
    public void setIndicatorBreakpoint2(java.lang.Double indicatorBreakpoint2) {
        this.indicatorBreakpoint2 = indicatorBreakpoint2;
    }


    /**
     * Gets the indicatorHighColor value for this DashboardComponent.
     * 
     * @return indicatorHighColor
     */
    public java.lang.String getIndicatorHighColor() {
        return indicatorHighColor;
    }


    /**
     * Sets the indicatorHighColor value for this DashboardComponent.
     * 
     * @param indicatorHighColor
     */
    public void setIndicatorHighColor(java.lang.String indicatorHighColor) {
        this.indicatorHighColor = indicatorHighColor;
    }


    /**
     * Gets the indicatorLowColor value for this DashboardComponent.
     * 
     * @return indicatorLowColor
     */
    public java.lang.String getIndicatorLowColor() {
        return indicatorLowColor;
    }


    /**
     * Sets the indicatorLowColor value for this DashboardComponent.
     * 
     * @param indicatorLowColor
     */
    public void setIndicatorLowColor(java.lang.String indicatorLowColor) {
        this.indicatorLowColor = indicatorLowColor;
    }


    /**
     * Gets the indicatorMiddleColor value for this DashboardComponent.
     * 
     * @return indicatorMiddleColor
     */
    public java.lang.String getIndicatorMiddleColor() {
        return indicatorMiddleColor;
    }


    /**
     * Sets the indicatorMiddleColor value for this DashboardComponent.
     * 
     * @param indicatorMiddleColor
     */
    public void setIndicatorMiddleColor(java.lang.String indicatorMiddleColor) {
        this.indicatorMiddleColor = indicatorMiddleColor;
    }


    /**
     * Gets the legendPosition value for this DashboardComponent.
     * 
     * @return legendPosition
     */
    public com.sforce.soap._2006._04.metadata.ChartLegendPosition getLegendPosition() {
        return legendPosition;
    }


    /**
     * Sets the legendPosition value for this DashboardComponent.
     * 
     * @param legendPosition
     */
    public void setLegendPosition(com.sforce.soap._2006._04.metadata.ChartLegendPosition legendPosition) {
        this.legendPosition = legendPosition;
    }


    /**
     * Gets the maxValuesDisplayed value for this DashboardComponent.
     * 
     * @return maxValuesDisplayed
     */
    public java.lang.Integer getMaxValuesDisplayed() {
        return maxValuesDisplayed;
    }


    /**
     * Sets the maxValuesDisplayed value for this DashboardComponent.
     * 
     * @param maxValuesDisplayed
     */
    public void setMaxValuesDisplayed(java.lang.Integer maxValuesDisplayed) {
        this.maxValuesDisplayed = maxValuesDisplayed;
    }


    /**
     * Gets the metricLabel value for this DashboardComponent.
     * 
     * @return metricLabel
     */
    public java.lang.String getMetricLabel() {
        return metricLabel;
    }


    /**
     * Sets the metricLabel value for this DashboardComponent.
     * 
     * @param metricLabel
     */
    public void setMetricLabel(java.lang.String metricLabel) {
        this.metricLabel = metricLabel;
    }


    /**
     * Gets the report value for this DashboardComponent.
     * 
     * @return report
     */
    public java.lang.String getReport() {
        return report;
    }


    /**
     * Sets the report value for this DashboardComponent.
     * 
     * @param report
     */
    public void setReport(java.lang.String report) {
        this.report = report;
    }


    /**
     * Gets the scontrol value for this DashboardComponent.
     * 
     * @return scontrol
     */
    public java.lang.String getScontrol() {
        return scontrol;
    }


    /**
     * Sets the scontrol value for this DashboardComponent.
     * 
     * @param scontrol
     */
    public void setScontrol(java.lang.String scontrol) {
        this.scontrol = scontrol;
    }


    /**
     * Gets the scontrolHeightInPixels value for this DashboardComponent.
     * 
     * @return scontrolHeightInPixels
     */
    public java.lang.Integer getScontrolHeightInPixels() {
        return scontrolHeightInPixels;
    }


    /**
     * Sets the scontrolHeightInPixels value for this DashboardComponent.
     * 
     * @param scontrolHeightInPixels
     */
    public void setScontrolHeightInPixels(java.lang.Integer scontrolHeightInPixels) {
        this.scontrolHeightInPixels = scontrolHeightInPixels;
    }


    /**
     * Gets the sortBy value for this DashboardComponent.
     * 
     * @return sortBy
     */
    public com.sforce.soap._2006._04.metadata.DashboardComponentFilter getSortBy() {
        return sortBy;
    }


    /**
     * Sets the sortBy value for this DashboardComponent.
     * 
     * @param sortBy
     */
    public void setSortBy(com.sforce.soap._2006._04.metadata.DashboardComponentFilter sortBy) {
        this.sortBy = sortBy;
    }


    /**
     * Gets the title value for this DashboardComponent.
     * 
     * @return title
     */
    public java.lang.String getTitle() {
        return title;
    }


    /**
     * Sets the title value for this DashboardComponent.
     * 
     * @param title
     */
    public void setTitle(java.lang.String title) {
        this.title = title;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DashboardComponent)) return false;
        DashboardComponent other = (DashboardComponent) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.chartAxisRange==null && other.getChartAxisRange()==null) || 
             (this.chartAxisRange!=null &&
              this.chartAxisRange.equals(other.getChartAxisRange()))) &&
            ((this.chartAxisRangeMax==null && other.getChartAxisRangeMax()==null) || 
             (this.chartAxisRangeMax!=null &&
              this.chartAxisRangeMax.equals(other.getChartAxisRangeMax()))) &&
            ((this.chartAxisRangeMin==null && other.getChartAxisRangeMin()==null) || 
             (this.chartAxisRangeMin!=null &&
              this.chartAxisRangeMin.equals(other.getChartAxisRangeMin()))) &&
            ((this.componentType==null && other.getComponentType()==null) || 
             (this.componentType!=null &&
              this.componentType.equals(other.getComponentType()))) &&
            ((this.displayUnits==null && other.getDisplayUnits()==null) || 
             (this.displayUnits!=null &&
              this.displayUnits.equals(other.getDisplayUnits()))) &&
            ((this.drillDownUrl==null && other.getDrillDownUrl()==null) || 
             (this.drillDownUrl!=null &&
              this.drillDownUrl.equals(other.getDrillDownUrl()))) &&
            ((this.footer==null && other.getFooter()==null) || 
             (this.footer!=null &&
              this.footer.equals(other.getFooter()))) &&
            ((this.gaugeMax==null && other.getGaugeMax()==null) || 
             (this.gaugeMax!=null &&
              this.gaugeMax.equals(other.getGaugeMax()))) &&
            ((this.gaugeMin==null && other.getGaugeMin()==null) || 
             (this.gaugeMin!=null &&
              this.gaugeMin.equals(other.getGaugeMin()))) &&
            ((this.header==null && other.getHeader()==null) || 
             (this.header!=null &&
              this.header.equals(other.getHeader()))) &&
            ((this.indicatorBreakpoint1==null && other.getIndicatorBreakpoint1()==null) || 
             (this.indicatorBreakpoint1!=null &&
              this.indicatorBreakpoint1.equals(other.getIndicatorBreakpoint1()))) &&
            ((this.indicatorBreakpoint2==null && other.getIndicatorBreakpoint2()==null) || 
             (this.indicatorBreakpoint2!=null &&
              this.indicatorBreakpoint2.equals(other.getIndicatorBreakpoint2()))) &&
            ((this.indicatorHighColor==null && other.getIndicatorHighColor()==null) || 
             (this.indicatorHighColor!=null &&
              this.indicatorHighColor.equals(other.getIndicatorHighColor()))) &&
            ((this.indicatorLowColor==null && other.getIndicatorLowColor()==null) || 
             (this.indicatorLowColor!=null &&
              this.indicatorLowColor.equals(other.getIndicatorLowColor()))) &&
            ((this.indicatorMiddleColor==null && other.getIndicatorMiddleColor()==null) || 
             (this.indicatorMiddleColor!=null &&
              this.indicatorMiddleColor.equals(other.getIndicatorMiddleColor()))) &&
            ((this.legendPosition==null && other.getLegendPosition()==null) || 
             (this.legendPosition!=null &&
              this.legendPosition.equals(other.getLegendPosition()))) &&
            ((this.maxValuesDisplayed==null && other.getMaxValuesDisplayed()==null) || 
             (this.maxValuesDisplayed!=null &&
              this.maxValuesDisplayed.equals(other.getMaxValuesDisplayed()))) &&
            ((this.metricLabel==null && other.getMetricLabel()==null) || 
             (this.metricLabel!=null &&
              this.metricLabel.equals(other.getMetricLabel()))) &&
            ((this.report==null && other.getReport()==null) || 
             (this.report!=null &&
              this.report.equals(other.getReport()))) &&
            ((this.scontrol==null && other.getScontrol()==null) || 
             (this.scontrol!=null &&
              this.scontrol.equals(other.getScontrol()))) &&
            ((this.scontrolHeightInPixels==null && other.getScontrolHeightInPixels()==null) || 
             (this.scontrolHeightInPixels!=null &&
              this.scontrolHeightInPixels.equals(other.getScontrolHeightInPixels()))) &&
            ((this.sortBy==null && other.getSortBy()==null) || 
             (this.sortBy!=null &&
              this.sortBy.equals(other.getSortBy()))) &&
            ((this.title==null && other.getTitle()==null) || 
             (this.title!=null &&
              this.title.equals(other.getTitle())));
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
        if (getChartAxisRange() != null) {
            _hashCode += getChartAxisRange().hashCode();
        }
        if (getChartAxisRangeMax() != null) {
            _hashCode += getChartAxisRangeMax().hashCode();
        }
        if (getChartAxisRangeMin() != null) {
            _hashCode += getChartAxisRangeMin().hashCode();
        }
        if (getComponentType() != null) {
            _hashCode += getComponentType().hashCode();
        }
        if (getDisplayUnits() != null) {
            _hashCode += getDisplayUnits().hashCode();
        }
        if (getDrillDownUrl() != null) {
            _hashCode += getDrillDownUrl().hashCode();
        }
        if (getFooter() != null) {
            _hashCode += getFooter().hashCode();
        }
        if (getGaugeMax() != null) {
            _hashCode += getGaugeMax().hashCode();
        }
        if (getGaugeMin() != null) {
            _hashCode += getGaugeMin().hashCode();
        }
        if (getHeader() != null) {
            _hashCode += getHeader().hashCode();
        }
        if (getIndicatorBreakpoint1() != null) {
            _hashCode += getIndicatorBreakpoint1().hashCode();
        }
        if (getIndicatorBreakpoint2() != null) {
            _hashCode += getIndicatorBreakpoint2().hashCode();
        }
        if (getIndicatorHighColor() != null) {
            _hashCode += getIndicatorHighColor().hashCode();
        }
        if (getIndicatorLowColor() != null) {
            _hashCode += getIndicatorLowColor().hashCode();
        }
        if (getIndicatorMiddleColor() != null) {
            _hashCode += getIndicatorMiddleColor().hashCode();
        }
        if (getLegendPosition() != null) {
            _hashCode += getLegendPosition().hashCode();
        }
        if (getMaxValuesDisplayed() != null) {
            _hashCode += getMaxValuesDisplayed().hashCode();
        }
        if (getMetricLabel() != null) {
            _hashCode += getMetricLabel().hashCode();
        }
        if (getReport() != null) {
            _hashCode += getReport().hashCode();
        }
        if (getScontrol() != null) {
            _hashCode += getScontrol().hashCode();
        }
        if (getScontrolHeightInPixels() != null) {
            _hashCode += getScontrolHeightInPixels().hashCode();
        }
        if (getSortBy() != null) {
            _hashCode += getSortBy().hashCode();
        }
        if (getTitle() != null) {
            _hashCode += getTitle().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DashboardComponent.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "DashboardComponent"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("chartAxisRange");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "chartAxisRange"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "ChartRangeType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("chartAxisRangeMax");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "chartAxisRangeMax"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("chartAxisRangeMin");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "chartAxisRangeMin"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("componentType");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "componentType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "DashboardComponentType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("displayUnits");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "displayUnits"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "ChartUnits"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("drillDownUrl");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "drillDownUrl"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("footer");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "footer"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("gaugeMax");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "gaugeMax"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("gaugeMin");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "gaugeMin"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("header");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "header"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("indicatorBreakpoint1");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "indicatorBreakpoint1"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("indicatorBreakpoint2");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "indicatorBreakpoint2"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("indicatorHighColor");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "indicatorHighColor"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("indicatorLowColor");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "indicatorLowColor"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("indicatorMiddleColor");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "indicatorMiddleColor"));
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
        elemField.setFieldName("maxValuesDisplayed");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "maxValuesDisplayed"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("metricLabel");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "metricLabel"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("report");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "report"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("scontrol");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "scontrol"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("scontrolHeightInPixels");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "scontrolHeightInPixels"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sortBy");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "sortBy"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "DashboardComponentFilter"));
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
