/**
 * Language.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package old.com.sforce.soap._2006._04.metadata;

public class Language implements java.io.Serializable {
    private java.lang.String _value_;
    private static java.util.HashMap _table_ = new java.util.HashMap();

    // Constructor
    protected Language(java.lang.String value) {
        _value_ = value;
        _table_.put(_value_,this);
    }

    public static final java.lang.String _en_US = "en_US";
    public static final java.lang.String _de = "de";
    public static final java.lang.String _es = "es";
    public static final java.lang.String _fr = "fr";
    public static final java.lang.String _it = "it";
    public static final java.lang.String _ja = "ja";
    public static final java.lang.String _sv = "sv";
    public static final java.lang.String _ko = "ko";
    public static final java.lang.String _zh_TW = "zh_TW";
    public static final java.lang.String _zh_CN = "zh_CN";
    public static final java.lang.String _pt_BR = "pt_BR";
    public static final java.lang.String _nl_NL = "nl_NL";
    public static final java.lang.String _da = "da";
    public static final java.lang.String _hu = "hu";
    public static final java.lang.String _th = "th";
    public static final java.lang.String _fi = "fi";
    public static final java.lang.String _pl = "pl";
    public static final java.lang.String _ru = "ru";
    public static final java.lang.String _cs = "cs";
    public static final java.lang.String _tr = "tr";
    public static final java.lang.String _ja_JP = "ja_JP";
    public static final Language en_US = new Language(_en_US);
    public static final Language de = new Language(_de);
    public static final Language es = new Language(_es);
    public static final Language fr = new Language(_fr);
    public static final Language it = new Language(_it);
    public static final Language ja = new Language(_ja);
    public static final Language sv = new Language(_sv);
    public static final Language ko = new Language(_ko);
    public static final Language zh_TW = new Language(_zh_TW);
    public static final Language zh_CN = new Language(_zh_CN);
    public static final Language pt_BR = new Language(_pt_BR);
    public static final Language nl_NL = new Language(_nl_NL);
    public static final Language da = new Language(_da);
    public static final Language hu = new Language(_hu);
    public static final Language th = new Language(_th);
    public static final Language fi = new Language(_fi);
    public static final Language pl = new Language(_pl);
    public static final Language ru = new Language(_ru);
    public static final Language cs = new Language(_cs);
    public static final Language tr = new Language(_tr);
    public static final Language ja_JP = new Language(_ja_JP);
    public java.lang.String getValue() { return _value_;}
    public static Language fromValue(java.lang.String value)
          throws java.lang.IllegalArgumentException {
        Language enumeration = (Language)
            _table_.get(value);
        if (enumeration==null) throw new java.lang.IllegalArgumentException();
        return enumeration;
    }
    public static Language fromString(java.lang.String value)
          throws java.lang.IllegalArgumentException {
        return fromValue(value);
    }
    public boolean equals(java.lang.Object obj) {return (obj == this);}
    public int hashCode() { return toString().hashCode();}
    public java.lang.String toString() { return _value_;}
    public java.lang.Object readResolve() throws java.io.ObjectStreamException { return fromValue(_value_);}
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new org.apache.axis.encoding.ser.EnumSerializer(
            _javaType, _xmlType);
    }
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new org.apache.axis.encoding.ser.EnumDeserializer(
            _javaType, _xmlType);
    }
    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Language.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "Language"));
    }
    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

}
