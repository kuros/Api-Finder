package test.controller;

import java.util.Date;
import java.util.List;

/**
 * Created by kumarro on 30/12/16.
 */
public class ComplexRequestBody {
    private Integer intValue;
    private Long longValue;
    private double doubleValue;
    private String stringValue;
    private ComplexNestedClass nestedClass;
    private List<String> strings;
    private Date date;

    public Integer getIntValue() {
        return intValue;
    }

    public void setIntValue(final Integer intValue) {
        this.intValue = intValue;
    }

    public Long getLongValue() {
        return longValue;
    }

    public void setLongValue(final Long longValue) {
        this.longValue = longValue;
    }

    public double getDoubleValue() {
        return doubleValue;
    }

    public void setDoubleValue(final double doubleValue) {
        this.doubleValue = doubleValue;
    }

    public String getStringValue() {
        return stringValue;
    }

    public void setStringValue(final String stringValue) {
        this.stringValue = stringValue;
    }

    public ComplexNestedClass getNestedClass() {
        return nestedClass;
    }

    public void setNestedClass(final ComplexNestedClass nestedClass) {
        this.nestedClass = nestedClass;
    }

    public List<String> getStrings() {
        return strings;
    }

    public void setStrings(final List<String> strings) {
        this.strings = strings;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(final Date date) {
        this.date = date;
    }

    public static class ComplexNestedClass {
        private String nestedAttribute;
        private ComplexNestedClass nestedClass;

        public String getNestedAttribute() {
            return nestedAttribute;
        }

        public void setNestedAttribute(final String nestedAttribute) {
            this.nestedAttribute = nestedAttribute;
        }

        public ComplexNestedClass getNestedClass() {
            return nestedClass;
        }

        public void setNestedClass(final ComplexNestedClass nestedClass) {
            this.nestedClass = nestedClass;
        }
    }
}
