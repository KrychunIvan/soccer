package com.test.parser.dto;


public class CountryFromWiki {

    private String name;
    private String alpha2;
    private String country_code;
    private String flag;

    public CountryFromWiki(String name, String alpha2, String country_code, String flag) {
        this.name = name;
        this.alpha2 = alpha2;
        this.country_code = country_code;
        this.flag = flag;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlpha2() {
        return alpha2;
    }

    public void setAlpha2(String alpha2) {
        this.alpha2 = alpha2;
    }

    public String getCountry_code() {
        return country_code;
    }

    public void setCountry_code(String country_code) {
        this.country_code = country_code;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CountryFromWiki that = (CountryFromWiki) o;

        if (!name.equals(that.name)) return false;
        if (!alpha2.equals(that.alpha2)) return false;
        if (!country_code.equals(that.country_code)) return false;
        return flag != null ? flag.equals(that.flag) : that.flag == null;

    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + alpha2.hashCode();
        result = 31 * result + country_code.hashCode();
        result = 31 * result + (flag != null ? flag.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", alpha2='" + alpha2 + '\'' +
                ", country_code='" + country_code + '\'' +
                ", flag='" + flag + '\'' +
                '}';
    }
}
