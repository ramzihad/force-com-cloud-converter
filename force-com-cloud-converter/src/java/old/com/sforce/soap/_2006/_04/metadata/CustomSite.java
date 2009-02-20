/**
 * CustomSite.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package old.com.sforce.soap._2006._04.metadata;

public class CustomSite  extends com.sforce.soap._2006._04.metadata.Metadata  implements java.io.Serializable {
    private boolean active;

    private java.lang.String authorizationRequiredPage;

    private java.lang.String bandwidthExceededPage;

    private java.lang.String changePasswordPage;

    private java.lang.String customWebAddress;

    private java.lang.String description;

    private java.lang.String fileNotFoundPage;

    private java.lang.String genericErrorPage;

    private java.lang.String guestProfile;

    private java.lang.String inMaintenancePage;

    private java.lang.String inactiveIndexPage;

    private java.lang.String indexPage;

    private java.lang.String masterLabel;

    private java.lang.String portal;

    private boolean requireInsecurePortalAccess;

    private java.lang.String robotsTxtPage;

    private java.lang.String siteAdmin;

    private java.lang.String siteTemplate;

    private java.lang.String subdomain;

    private java.lang.String urlPathPrefix;

    public CustomSite() {
    }

    public CustomSite(
           java.lang.String fullName,
           boolean active,
           java.lang.String authorizationRequiredPage,
           java.lang.String bandwidthExceededPage,
           java.lang.String changePasswordPage,
           java.lang.String customWebAddress,
           java.lang.String description,
           java.lang.String fileNotFoundPage,
           java.lang.String genericErrorPage,
           java.lang.String guestProfile,
           java.lang.String inMaintenancePage,
           java.lang.String inactiveIndexPage,
           java.lang.String indexPage,
           java.lang.String masterLabel,
           java.lang.String portal,
           boolean requireInsecurePortalAccess,
           java.lang.String robotsTxtPage,
           java.lang.String siteAdmin,
           java.lang.String siteTemplate,
           java.lang.String subdomain,
           java.lang.String urlPathPrefix) {
        super(
            fullName);
        this.active = active;
        this.authorizationRequiredPage = authorizationRequiredPage;
        this.bandwidthExceededPage = bandwidthExceededPage;
        this.changePasswordPage = changePasswordPage;
        this.customWebAddress = customWebAddress;
        this.description = description;
        this.fileNotFoundPage = fileNotFoundPage;
        this.genericErrorPage = genericErrorPage;
        this.guestProfile = guestProfile;
        this.inMaintenancePage = inMaintenancePage;
        this.inactiveIndexPage = inactiveIndexPage;
        this.indexPage = indexPage;
        this.masterLabel = masterLabel;
        this.portal = portal;
        this.requireInsecurePortalAccess = requireInsecurePortalAccess;
        this.robotsTxtPage = robotsTxtPage;
        this.siteAdmin = siteAdmin;
        this.siteTemplate = siteTemplate;
        this.subdomain = subdomain;
        this.urlPathPrefix = urlPathPrefix;
    }


    /**
     * Gets the active value for this CustomSite.
     * 
     * @return active
     */
    public boolean isActive() {
        return active;
    }


    /**
     * Sets the active value for this CustomSite.
     * 
     * @param active
     */
    public void setActive(boolean active) {
        this.active = active;
    }


    /**
     * Gets the authorizationRequiredPage value for this CustomSite.
     * 
     * @return authorizationRequiredPage
     */
    public java.lang.String getAuthorizationRequiredPage() {
        return authorizationRequiredPage;
    }


    /**
     * Sets the authorizationRequiredPage value for this CustomSite.
     * 
     * @param authorizationRequiredPage
     */
    public void setAuthorizationRequiredPage(java.lang.String authorizationRequiredPage) {
        this.authorizationRequiredPage = authorizationRequiredPage;
    }


    /**
     * Gets the bandwidthExceededPage value for this CustomSite.
     * 
     * @return bandwidthExceededPage
     */
    public java.lang.String getBandwidthExceededPage() {
        return bandwidthExceededPage;
    }


    /**
     * Sets the bandwidthExceededPage value for this CustomSite.
     * 
     * @param bandwidthExceededPage
     */
    public void setBandwidthExceededPage(java.lang.String bandwidthExceededPage) {
        this.bandwidthExceededPage = bandwidthExceededPage;
    }


    /**
     * Gets the changePasswordPage value for this CustomSite.
     * 
     * @return changePasswordPage
     */
    public java.lang.String getChangePasswordPage() {
        return changePasswordPage;
    }


    /**
     * Sets the changePasswordPage value for this CustomSite.
     * 
     * @param changePasswordPage
     */
    public void setChangePasswordPage(java.lang.String changePasswordPage) {
        this.changePasswordPage = changePasswordPage;
    }


    /**
     * Gets the customWebAddress value for this CustomSite.
     * 
     * @return customWebAddress
     */
    public java.lang.String getCustomWebAddress() {
        return customWebAddress;
    }


    /**
     * Sets the customWebAddress value for this CustomSite.
     * 
     * @param customWebAddress
     */
    public void setCustomWebAddress(java.lang.String customWebAddress) {
        this.customWebAddress = customWebAddress;
    }


    /**
     * Gets the description value for this CustomSite.
     * 
     * @return description
     */
    public java.lang.String getDescription() {
        return description;
    }


    /**
     * Sets the description value for this CustomSite.
     * 
     * @param description
     */
    public void setDescription(java.lang.String description) {
        this.description = description;
    }


    /**
     * Gets the fileNotFoundPage value for this CustomSite.
     * 
     * @return fileNotFoundPage
     */
    public java.lang.String getFileNotFoundPage() {
        return fileNotFoundPage;
    }


    /**
     * Sets the fileNotFoundPage value for this CustomSite.
     * 
     * @param fileNotFoundPage
     */
    public void setFileNotFoundPage(java.lang.String fileNotFoundPage) {
        this.fileNotFoundPage = fileNotFoundPage;
    }


    /**
     * Gets the genericErrorPage value for this CustomSite.
     * 
     * @return genericErrorPage
     */
    public java.lang.String getGenericErrorPage() {
        return genericErrorPage;
    }


    /**
     * Sets the genericErrorPage value for this CustomSite.
     * 
     * @param genericErrorPage
     */
    public void setGenericErrorPage(java.lang.String genericErrorPage) {
        this.genericErrorPage = genericErrorPage;
    }


    /**
     * Gets the guestProfile value for this CustomSite.
     * 
     * @return guestProfile
     */
    public java.lang.String getGuestProfile() {
        return guestProfile;
    }


    /**
     * Sets the guestProfile value for this CustomSite.
     * 
     * @param guestProfile
     */
    public void setGuestProfile(java.lang.String guestProfile) {
        this.guestProfile = guestProfile;
    }


    /**
     * Gets the inMaintenancePage value for this CustomSite.
     * 
     * @return inMaintenancePage
     */
    public java.lang.String getInMaintenancePage() {
        return inMaintenancePage;
    }


    /**
     * Sets the inMaintenancePage value for this CustomSite.
     * 
     * @param inMaintenancePage
     */
    public void setInMaintenancePage(java.lang.String inMaintenancePage) {
        this.inMaintenancePage = inMaintenancePage;
    }


    /**
     * Gets the inactiveIndexPage value for this CustomSite.
     * 
     * @return inactiveIndexPage
     */
    public java.lang.String getInactiveIndexPage() {
        return inactiveIndexPage;
    }


    /**
     * Sets the inactiveIndexPage value for this CustomSite.
     * 
     * @param inactiveIndexPage
     */
    public void setInactiveIndexPage(java.lang.String inactiveIndexPage) {
        this.inactiveIndexPage = inactiveIndexPage;
    }


    /**
     * Gets the indexPage value for this CustomSite.
     * 
     * @return indexPage
     */
    public java.lang.String getIndexPage() {
        return indexPage;
    }


    /**
     * Sets the indexPage value for this CustomSite.
     * 
     * @param indexPage
     */
    public void setIndexPage(java.lang.String indexPage) {
        this.indexPage = indexPage;
    }


    /**
     * Gets the masterLabel value for this CustomSite.
     * 
     * @return masterLabel
     */
    public java.lang.String getMasterLabel() {
        return masterLabel;
    }


    /**
     * Sets the masterLabel value for this CustomSite.
     * 
     * @param masterLabel
     */
    public void setMasterLabel(java.lang.String masterLabel) {
        this.masterLabel = masterLabel;
    }


    /**
     * Gets the portal value for this CustomSite.
     * 
     * @return portal
     */
    public java.lang.String getPortal() {
        return portal;
    }


    /**
     * Sets the portal value for this CustomSite.
     * 
     * @param portal
     */
    public void setPortal(java.lang.String portal) {
        this.portal = portal;
    }


    /**
     * Gets the requireInsecurePortalAccess value for this CustomSite.
     * 
     * @return requireInsecurePortalAccess
     */
    public boolean isRequireInsecurePortalAccess() {
        return requireInsecurePortalAccess;
    }


    /**
     * Sets the requireInsecurePortalAccess value for this CustomSite.
     * 
     * @param requireInsecurePortalAccess
     */
    public void setRequireInsecurePortalAccess(boolean requireInsecurePortalAccess) {
        this.requireInsecurePortalAccess = requireInsecurePortalAccess;
    }


    /**
     * Gets the robotsTxtPage value for this CustomSite.
     * 
     * @return robotsTxtPage
     */
    public java.lang.String getRobotsTxtPage() {
        return robotsTxtPage;
    }


    /**
     * Sets the robotsTxtPage value for this CustomSite.
     * 
     * @param robotsTxtPage
     */
    public void setRobotsTxtPage(java.lang.String robotsTxtPage) {
        this.robotsTxtPage = robotsTxtPage;
    }


    /**
     * Gets the siteAdmin value for this CustomSite.
     * 
     * @return siteAdmin
     */
    public java.lang.String getSiteAdmin() {
        return siteAdmin;
    }


    /**
     * Sets the siteAdmin value for this CustomSite.
     * 
     * @param siteAdmin
     */
    public void setSiteAdmin(java.lang.String siteAdmin) {
        this.siteAdmin = siteAdmin;
    }


    /**
     * Gets the siteTemplate value for this CustomSite.
     * 
     * @return siteTemplate
     */
    public java.lang.String getSiteTemplate() {
        return siteTemplate;
    }


    /**
     * Sets the siteTemplate value for this CustomSite.
     * 
     * @param siteTemplate
     */
    public void setSiteTemplate(java.lang.String siteTemplate) {
        this.siteTemplate = siteTemplate;
    }


    /**
     * Gets the subdomain value for this CustomSite.
     * 
     * @return subdomain
     */
    public java.lang.String getSubdomain() {
        return subdomain;
    }


    /**
     * Sets the subdomain value for this CustomSite.
     * 
     * @param subdomain
     */
    public void setSubdomain(java.lang.String subdomain) {
        this.subdomain = subdomain;
    }


    /**
     * Gets the urlPathPrefix value for this CustomSite.
     * 
     * @return urlPathPrefix
     */
    public java.lang.String getUrlPathPrefix() {
        return urlPathPrefix;
    }


    /**
     * Sets the urlPathPrefix value for this CustomSite.
     * 
     * @param urlPathPrefix
     */
    public void setUrlPathPrefix(java.lang.String urlPathPrefix) {
        this.urlPathPrefix = urlPathPrefix;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CustomSite)) return false;
        CustomSite other = (CustomSite) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            this.active == other.isActive() &&
            ((this.authorizationRequiredPage==null && other.getAuthorizationRequiredPage()==null) || 
             (this.authorizationRequiredPage!=null &&
              this.authorizationRequiredPage.equals(other.getAuthorizationRequiredPage()))) &&
            ((this.bandwidthExceededPage==null && other.getBandwidthExceededPage()==null) || 
             (this.bandwidthExceededPage!=null &&
              this.bandwidthExceededPage.equals(other.getBandwidthExceededPage()))) &&
            ((this.changePasswordPage==null && other.getChangePasswordPage()==null) || 
             (this.changePasswordPage!=null &&
              this.changePasswordPage.equals(other.getChangePasswordPage()))) &&
            ((this.customWebAddress==null && other.getCustomWebAddress()==null) || 
             (this.customWebAddress!=null &&
              this.customWebAddress.equals(other.getCustomWebAddress()))) &&
            ((this.description==null && other.getDescription()==null) || 
             (this.description!=null &&
              this.description.equals(other.getDescription()))) &&
            ((this.fileNotFoundPage==null && other.getFileNotFoundPage()==null) || 
             (this.fileNotFoundPage!=null &&
              this.fileNotFoundPage.equals(other.getFileNotFoundPage()))) &&
            ((this.genericErrorPage==null && other.getGenericErrorPage()==null) || 
             (this.genericErrorPage!=null &&
              this.genericErrorPage.equals(other.getGenericErrorPage()))) &&
            ((this.guestProfile==null && other.getGuestProfile()==null) || 
             (this.guestProfile!=null &&
              this.guestProfile.equals(other.getGuestProfile()))) &&
            ((this.inMaintenancePage==null && other.getInMaintenancePage()==null) || 
             (this.inMaintenancePage!=null &&
              this.inMaintenancePage.equals(other.getInMaintenancePage()))) &&
            ((this.inactiveIndexPage==null && other.getInactiveIndexPage()==null) || 
             (this.inactiveIndexPage!=null &&
              this.inactiveIndexPage.equals(other.getInactiveIndexPage()))) &&
            ((this.indexPage==null && other.getIndexPage()==null) || 
             (this.indexPage!=null &&
              this.indexPage.equals(other.getIndexPage()))) &&
            ((this.masterLabel==null && other.getMasterLabel()==null) || 
             (this.masterLabel!=null &&
              this.masterLabel.equals(other.getMasterLabel()))) &&
            ((this.portal==null && other.getPortal()==null) || 
             (this.portal!=null &&
              this.portal.equals(other.getPortal()))) &&
            this.requireInsecurePortalAccess == other.isRequireInsecurePortalAccess() &&
            ((this.robotsTxtPage==null && other.getRobotsTxtPage()==null) || 
             (this.robotsTxtPage!=null &&
              this.robotsTxtPage.equals(other.getRobotsTxtPage()))) &&
            ((this.siteAdmin==null && other.getSiteAdmin()==null) || 
             (this.siteAdmin!=null &&
              this.siteAdmin.equals(other.getSiteAdmin()))) &&
            ((this.siteTemplate==null && other.getSiteTemplate()==null) || 
             (this.siteTemplate!=null &&
              this.siteTemplate.equals(other.getSiteTemplate()))) &&
            ((this.subdomain==null && other.getSubdomain()==null) || 
             (this.subdomain!=null &&
              this.subdomain.equals(other.getSubdomain()))) &&
            ((this.urlPathPrefix==null && other.getUrlPathPrefix()==null) || 
             (this.urlPathPrefix!=null &&
              this.urlPathPrefix.equals(other.getUrlPathPrefix())));
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
        _hashCode += (isActive() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getAuthorizationRequiredPage() != null) {
            _hashCode += getAuthorizationRequiredPage().hashCode();
        }
        if (getBandwidthExceededPage() != null) {
            _hashCode += getBandwidthExceededPage().hashCode();
        }
        if (getChangePasswordPage() != null) {
            _hashCode += getChangePasswordPage().hashCode();
        }
        if (getCustomWebAddress() != null) {
            _hashCode += getCustomWebAddress().hashCode();
        }
        if (getDescription() != null) {
            _hashCode += getDescription().hashCode();
        }
        if (getFileNotFoundPage() != null) {
            _hashCode += getFileNotFoundPage().hashCode();
        }
        if (getGenericErrorPage() != null) {
            _hashCode += getGenericErrorPage().hashCode();
        }
        if (getGuestProfile() != null) {
            _hashCode += getGuestProfile().hashCode();
        }
        if (getInMaintenancePage() != null) {
            _hashCode += getInMaintenancePage().hashCode();
        }
        if (getInactiveIndexPage() != null) {
            _hashCode += getInactiveIndexPage().hashCode();
        }
        if (getIndexPage() != null) {
            _hashCode += getIndexPage().hashCode();
        }
        if (getMasterLabel() != null) {
            _hashCode += getMasterLabel().hashCode();
        }
        if (getPortal() != null) {
            _hashCode += getPortal().hashCode();
        }
        _hashCode += (isRequireInsecurePortalAccess() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getRobotsTxtPage() != null) {
            _hashCode += getRobotsTxtPage().hashCode();
        }
        if (getSiteAdmin() != null) {
            _hashCode += getSiteAdmin().hashCode();
        }
        if (getSiteTemplate() != null) {
            _hashCode += getSiteTemplate().hashCode();
        }
        if (getSubdomain() != null) {
            _hashCode += getSubdomain().hashCode();
        }
        if (getUrlPathPrefix() != null) {
            _hashCode += getUrlPathPrefix().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CustomSite.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "CustomSite"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("active");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "active"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("authorizationRequiredPage");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "authorizationRequiredPage"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bandwidthExceededPage");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "bandwidthExceededPage"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("changePasswordPage");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "changePasswordPage"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("customWebAddress");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "customWebAddress"));
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
        elemField.setFieldName("fileNotFoundPage");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "fileNotFoundPage"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("genericErrorPage");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "genericErrorPage"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("guestProfile");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "guestProfile"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("inMaintenancePage");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "inMaintenancePage"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("inactiveIndexPage");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "inactiveIndexPage"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("indexPage");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "indexPage"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("masterLabel");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "masterLabel"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("portal");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "portal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("requireInsecurePortalAccess");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "requireInsecurePortalAccess"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("robotsTxtPage");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "robotsTxtPage"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("siteAdmin");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "siteAdmin"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("siteTemplate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "siteTemplate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("subdomain");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "subdomain"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("urlPathPrefix");
        elemField.setXmlName(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "urlPathPrefix"));
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
