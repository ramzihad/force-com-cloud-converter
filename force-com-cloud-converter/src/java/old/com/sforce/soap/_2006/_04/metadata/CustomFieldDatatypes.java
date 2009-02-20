/**
 * CustomFieldDatatypes.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package old.com.sforce.soap._2006._04.metadata;

public class CustomFieldDatatypes implements java.io.Serializable {
    private java.lang.String _value_;
    private static java.util.HashMap _table_ = new java.util.HashMap();

    // Constructor
    protected CustomFieldDatatypes(java.lang.String value) {
        _value_ = value;
        _table_.put(_value_,this);
    }

    public static final java.lang.String _text = "text";
    public static final java.lang.String _date = "date";
    public static final java.lang.String _currency = "currency";
    public static final java.lang.String _percent = "percent";
    public static final java.lang.String _number = "number";
    public static final java.lang.String _picklist = "picklist";
    public static final java.lang.String _phone = "phone";
    public static final java.lang.String _url = "url";
    public static final java.lang.String _textarea = "textarea";
    public static final java.lang.String _email = "email";
    public static final java.lang.String _datetime = "datetime";
    public static final java.lang.String _foreignKey = "foreignKey";
    public static final java.lang.String _checkbox = "checkbox";
    public static final java.lang.String _multipicklist = "multipicklist";
    public static final java.lang.String _autonumber = "autonumber";
    public static final java.lang.String _longtextarea = "longtextarea";
    public static final java.lang.String _formula = "formula";
    public static final java.lang.String _sfdcencryptedtext = "sfdcencryptedtext";
    public static final java.lang.String _encryptedtext = "encryptedtext";
    public static final java.lang.String _summary = "summary";
    public static final java.lang.String _time = "time";
    public static final CustomFieldDatatypes text = new CustomFieldDatatypes(_text);
    public static final CustomFieldDatatypes date = new CustomFieldDatatypes(_date);
    public static final CustomFieldDatatypes currency = new CustomFieldDatatypes(_currency);
    public static final CustomFieldDatatypes percent = new CustomFieldDatatypes(_percent);
    public static final CustomFieldDatatypes number = new CustomFieldDatatypes(_number);
    public static final CustomFieldDatatypes picklist = new CustomFieldDatatypes(_picklist);
    public static final CustomFieldDatatypes phone = new CustomFieldDatatypes(_phone);
    public static final CustomFieldDatatypes url = new CustomFieldDatatypes(_url);
    public static final CustomFieldDatatypes textarea = new CustomFieldDatatypes(_textarea);
    public static final CustomFieldDatatypes email = new CustomFieldDatatypes(_email);
    public static final CustomFieldDatatypes datetime = new CustomFieldDatatypes(_datetime);
    public static final CustomFieldDatatypes foreignKey = new CustomFieldDatatypes(_foreignKey);
    public static final CustomFieldDatatypes checkbox = new CustomFieldDatatypes(_checkbox);
    public static final CustomFieldDatatypes multipicklist = new CustomFieldDatatypes(_multipicklist);
    public static final CustomFieldDatatypes autonumber = new CustomFieldDatatypes(_autonumber);
    public static final CustomFieldDatatypes longtextarea = new CustomFieldDatatypes(_longtextarea);
    public static final CustomFieldDatatypes formula = new CustomFieldDatatypes(_formula);
    public static final CustomFieldDatatypes sfdcencryptedtext = new CustomFieldDatatypes(_sfdcencryptedtext);
    public static final CustomFieldDatatypes encryptedtext = new CustomFieldDatatypes(_encryptedtext);
    public static final CustomFieldDatatypes summary = new CustomFieldDatatypes(_summary);
    public static final CustomFieldDatatypes time = new CustomFieldDatatypes(_time);
    public java.lang.String getValue() { return _value_;}
    public static CustomFieldDatatypes fromValue(java.lang.String value)
          throws java.lang.IllegalArgumentException {
        CustomFieldDatatypes enumeration = (CustomFieldDatatypes)
            _table_.get(value);
        if (enumeration==null) throw new java.lang.IllegalArgumentException();
        return enumeration;
    }
    public static CustomFieldDatatypes fromString(java.lang.String value)
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
        new org.apache.axis.description.TypeDesc(CustomFieldDatatypes.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://soap.sforce.com/2006/04/metadata", "CustomFieldDatatypes"));
    }
    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

}
