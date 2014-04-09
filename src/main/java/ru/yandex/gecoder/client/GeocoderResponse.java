package ru.yandex.gecoder.client;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Dmitry Andreev <a href="mailto:AndreevDm@gmail.com"/>
 * @date 09.04.2014
 */
public class GeocoderResponse {
    private List<GeoObject> geoObjects = new ArrayList<GeoObject>();
    private String request;
    private int found;
    private int results;

    public GeocoderResponse() {
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public void setFound(int found) {
        this.found = found;
    }

    public void addGeoObject(GeoObject geoObject){
        geoObjects.add(geoObject);
    }

    public List<GeoObject> getGeoObjects() {
        return geoObjects;
    }

    public String getRequest() {
        return request;
    }

    public int getFound() {
        return found;
    }
    
    public int getResults() {
        return results;
    }

    public void setResults(int results) {
        this.results = results;
    }
}
