/**
 * DeployOptions.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.sforce.soap._2006._04.metadata;

public class DeployOptions  implements java.io.Serializable {
    private boolean allowMissingFiles;

    private boolean autoUpdatePackage;

    private boolean checkOnly;

    private boolean performRetrieve;

    private boolean rollbackOnError;

    private boolean runAllTests;

    private java.lang.String[] runTests;

    private boolean singlePackage;

    public DeployOptions() {
    }

    public DeployOptions(
           boolean allowMissingFiles,
           boolean autoUpdatePackage,
           boolean checkOnly,
           boolean performRetrieve,
           boolean rollbackOnError,
           boolean runAllTests,
           java.lang.String[] runTests,
           boolean singlePackage) {
           this.allowMissingFiles = allowMissingFiles;
           this.autoUpdatePackage = autoUpdatePackage;
           this.checkOnly = checkOnly;
           this.performRetrieve = performRetrieve;
           this.rollbackOnError = rollbackOnError;
           this.runAllTests = runAllTests;
           this.runTests = runTests;
           this.singlePackage = singlePackage;
    }


    /**
     * Gets the allowMissingFiles value for this DeployOptions.
     * 
     * @return allowMissingFiles
     */
    public boolean isAllowMissingFiles() {
        return allowMissingFiles;
    }


    /**
     * Sets the allowMissingFiles value for this DeployOptions.
     * 
     * @param allowMissingFiles
     */
    public void setAllowMissingFiles(boolean allowMissingFiles) {
        this.allowMissingFiles = allowMissingFiles;
    }


    /**
     * Gets the autoUpdatePackage value for this DeployOptions.
     * 
     * @return autoUpdatePackage
     */
    public boolean isAutoUpdatePackage() {
        return autoUpdatePackage;
    }


    /**
     * Sets the autoUpdatePackage value for this DeployOptions.
     * 
     * @param autoUpdatePackage
     */
    public void setAutoUpdatePackage(boolean autoUpdatePackage) {
        this.autoUpdatePackage = autoUpdatePackage;
    }


    /**
     * Gets the checkOnly value for this DeployOptions.
     * 
     * @return checkOnly
     */
    public boolean isCheckOnly() {
        return checkOnly;
    }


    /**
     * Sets the checkOnly value for this DeployOptions.
     * 
     * @param checkOnly
     */
    public void setCheckOnly(boolean checkOnly) {
        this.checkOnly = checkOnly;
    }


    /**
     * Gets the performRetrieve value for this DeployOptions.
     * 
     * @return performRetrieve
     */
    public boolean isPerformRetrieve() {
        return performRetrieve;
    }


    /**
     * Sets the performRetrieve value for this DeployOptions.
     * 
     * @param performRetrieve
     */
    public void setPerformRetrieve(boolean performRetrieve) {
        this.performRetrieve = performRetrieve;
    }


    /**
     * Gets the rollbackOnError value for this DeployOptions.
     * 
     * @return rollbackOnError
     */
    public boolean isRollbackOnError() {
        return rollbackOnError;
    }


    /**
     * Sets the rollbackOnError value for this DeployOptions.
     * 
     * @param rollbackOnError
     */
    public void setRollbackOnError(boolean rollbackOnError) {
        this.rollbackOnError = rollbackOnError;
    }


    /**
     * Gets the runAllTests value for this DeployOptions.
     * 
     * @return runAllTests
     */
    public boolean isRunAllTests() {
        return runAllTests;
    }


    /**
     * Sets the runAllTests value for this DeployOptions.
     * 
     * @param runAllTests
     */
    public void setRunAllTests(boolean runAllTests) {
        this.runAllTests = runAllTests;
    }


    /**
     * Gets the runTests value for this DeployOptions.
     * 
     * @return runTests
     */
    public java.lang.String[] getRunTests() {
        return runTests;
    }


    /**
     * Sets the runTests value for this DeployOptions.
     * 
     * @param runTests
     */
    public void setRunTests(java.lang.String[] runTests) {
        this.runTests = runTests;
    }

    public java.lang.String getRunTests(int i) {
        return this.runTests[i];
    }

    public void setRunTests(int i, java.lang.String _value) {
        this.runTests[i] = _value;
    }


    /**
     * Gets the singlePackage value for this DeployOptions.
     * 
     * @return singlePackage
     */
    public boolean isSinglePackage() {
        return singlePackage;
    }


    /**
     * Sets the singlePackage value for this DeployOptions.
     * 
     * @param singlePackage
     */
    public void setSinglePackage(boolean singlePackage) {
        this.singlePackage = singlePackage;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DeployOptions)) return false;
        DeployOptions other = (DeployOptions) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.allowMissingFiles == other.isAllowMissingFiles() &&
            this.autoUpdatePackage == other.isAutoUpdatePackage() &&
            this.checkOnly == other.isCheckOnly() &&
            this.performRetrieve == other.isPerformRetrieve() &&
            this.rollbackOnError == other.isRollbackOnError() &&
            this.runAllTests == other.isRunAllTests() &&
            ((this.runTests==null && other.getRunTests()==null) || 
             (this.runTests!=null &&
              java.util.Arrays.equals(this.runTests, other.getRunTests()))) &&
            this.singlePackage == other.isSinglePackage();
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
        _hashCode += (isAllowMissingFiles() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isAutoUpdatePackage() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isCheckOnly() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isPerformRetrieve() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isRollbackOnError() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isRunAllTests() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getRunTests() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getRunTests());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getRunTests(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        _hashCode += (isSinglePackage() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DeployOptions.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "DeployOptions"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("allowMissingFiles");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "allowMissingFiles"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("autoUpdatePackage");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "autoUpdatePackage"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("checkOnly");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "checkOnly"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("performRetrieve");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "performRetrieve"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("rollbackOnError");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "rollbackOnError"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("runAllTests");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "runAllTests"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("runTests");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "runTests"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("singlePackage");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "singlePackage"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
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
