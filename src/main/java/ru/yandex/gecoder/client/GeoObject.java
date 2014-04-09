package ru.yandex.gecoder.client;

/**
 * @author Dmitry Andreev <a href="mailto:AndreevDm@gmail.com"/>
 * @date 10.04.2014
 */
public class GeoObject {
    private String name;
    private String kind;
    private String text;
    private String precision;
    private String address;
    private String country;
    private String countryCode;
    private String administrativeArea;
    private String subAdministrativeArea;
    private String locality;
    private String thoroughfare;
    private String premise;

    private GeoPoint point;
    private GeoPoint lowerCorner;
    private GeoPoint upperCorner;

    public GeoObject() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getPrecision() {
        return precision;
    }

    public void setPrecision(String precision) {
        this.precision = precision;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getAdministrativeArea() {
        return administrativeArea;
    }

    public void setAdministrativeArea(String administrativeArea) {
        this.administrativeArea = administrativeArea;
    }

    public String getSubAdministrativeArea() {
        return subAdministrativeArea;
    }

    public void setSubAdministrativeArea(String subAdministrativeArea) {
        this.subAdministrativeArea = subAdministrativeArea;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getThoroughfare() {
        return thoroughfare;
    }

    public void setThoroughfare(String thoroughfare) {
        this.thoroughfare = thoroughfare;
    }

    public String getPremise() {
        return premise;
    }

    public void setPremise(String premise) {
        this.premise = premise;
    }

    public GeoPoint getPoint() {
        return point;
    }

    public void setPoint(GeoPoint point) {
        this.point = point;
    }

    public GeoPoint getLowerCorner() {
        return lowerCorner;
    }

    public void setLowerCorner(GeoPoint lowerCorner) {
        this.lowerCorner = lowerCorner;
    }

    public GeoPoint getUpperCorner() {
        return upperCorner;
    }

    public void setUpperCorner(GeoPoint upperCorner) {
        this.upperCorner = upperCorner;
    }
}
