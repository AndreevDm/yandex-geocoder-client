package ru.yandex.gecoder.client;

/**
 * @author Dmitry Andreev <a href="mailto:AndreevDm@gmail.com"/>
 * @date 10.04.2014
 */
public class GeoPoint {

    private final double lon;
    private final double lat;

    public GeoPoint(double lon, double lat) {
        this.lon = lon;
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public double getLat() {
        return lat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GeoPoint geoPoint = (GeoPoint) o;

        if (Double.compare(geoPoint.lat, lat) != 0) return false;
        if (Double.compare(geoPoint.lon, lon) != 0) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(lon);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(lat);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "GeoPoint{" +
            "lon=" + lon +
            ", lat=" + lat +
            '}';
    }

    public static GeoPoint parse(String string) {
        String[] splits = string.split(" ");
        return new GeoPoint(Double.parseDouble(splits[0]), Double.parseDouble(splits[1]));
    }
}
