package ru.yandex.gecoder.client;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author Dmitry Andreev <a href="mailto:AndreevDm@yandex-team.ru"/>
 * @date 09.04.2014
 */
public class XmlResponseParser {
    private SAXParser parser;

    public XmlResponseParser() {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            parser = factory.newSAXParser();
        } catch (ParserConfigurationException | SAXException e) {
            throw new RuntimeException(e);
        }
    }

    public GeocoderResponse parse(InputStream inputStream) throws IOException {
        YaGeocoderHandler handler = new YaGeocoderHandler();
        try {
            parser.parse(inputStream, handler);
        } catch (Exception e) {
            throw new IOException("Failed to parse geocoder result: " + e.toString(), e);
        }
        return handler.getResult();
    }

    private static class YaGeocoderHandler extends DefaultHandler {

        private StringBuilder stringBuilder = new StringBuilder();

        private GeocoderResponse response = new GeocoderResponse();
        private GeoObject geoObject = null;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            switch (qName) {
                case "GeoObject":
                    geoObject = new GeoObject();
                    break;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            switch (qName) {
                case "request":
                    response.setRequest(getString());
                    break;
                case "found":
                    response.setFound(getInt());
                    break;
                case "results":
                    response.setResults(getInt());
                    break;
                case "GeoObject":
                    response.addGeoObject(geoObject);
                    geoObject = null;
                    break;
                case "kind":
                    geoObject.setKind(getString());
                    break;
                case "text":
                    geoObject.setText(getString());
                    break;
                case "precision":
                    geoObject.setPrecision(getString());
                    break;
                case "AddressLine":
                    geoObject.setAddress(getString());
                    break;
                case "CountryNameCode":
                    geoObject.setCountryCode(getString());
                    break;
                case "CountryName":
                    geoObject.setCountry(getString());
                    break;
                case "AdministrativeAreaName":
                    geoObject.setAdministrativeArea(getString());
                    break;
                case "SubAdministrativeAreaName":
                    geoObject.setSubAdministrativeArea(getString());
                    break;
                case "LocalityName":
                case "locality": //people
                    geoObject.setLocality(getString());
                    break;
                case "ThoroughfareName":
                case "thoroughfare": //people
                    geoObject.setThoroughfare(getString());
                    break;
                case "PremiseNumber":
                case "premiseNumber": //people
                    geoObject.setPremise(getString());
                    break;
                case "name":
                    geoObject.setName(getString());
                    break;
                case "lowerCorner":
                    if (geoObject != null){
                        geoObject.setLowerCorner(getGeoPoint());
                    }
                    break;
                case "upperCorner":
                    if (geoObject != null){
                        geoObject.setUpperCorner(getGeoPoint());
                    }
                    break;
                case "pos":
                    geoObject.setPoint(getGeoPoint());
                    break;
            }
            stringBuilder.setLength(0);
        }

        private String getString() {
            return stringBuilder.toString().trim();
        }

        private int getInt() {
            return Integer.parseInt(getString());
        }

        private GeoPoint getGeoPoint() {
            return  GeoPoint.parse(getString());
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            stringBuilder.append(ch, start, length);
        }

        public GeocoderResponse getResult() {
            return response;
        }

    }


}
