/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mycompany.ws.soap.client;

/**
 *
 * @author Branko
 */
public class MeteoWSClient {

    private static java.util.List<org.mycompany.ws.soap.client.Address> getAllAddress() {
        org.mycompany.ws.soap.client.GeoMeteoWS_Service service = new org.mycompany.ws.soap.client.GeoMeteoWS_Service();
        org.mycompany.ws.soap.client.GeoMeteoWS port = service.getGeoMeteoWSPort();
        return port.getAllAddress();
    }

    private static java.util.List<org.mycompany.ws.soap.client.WeatherData> getAllMeteodataForAddress(java.lang.String address) {
        org.mycompany.ws.soap.client.GeoMeteoWS_Service service = new org.mycompany.ws.soap.client.GeoMeteoWS_Service();
        org.mycompany.ws.soap.client.GeoMeteoWS port = service.getGeoMeteoWSPort();
        return port.getAllMeteodataForAddress(address);
    }

    private static java.util.List<org.mycompany.ws.soap.client.WeatherData> getAllMeteodataForAddressInInterval(java.lang.String address, java.lang.String from, java.lang.String to) {
        org.mycompany.ws.soap.client.GeoMeteoWS_Service service = new org.mycompany.ws.soap.client.GeoMeteoWS_Service();
        org.mycompany.ws.soap.client.GeoMeteoWS port = service.getGeoMeteoWSPort();
        return port.getAllMeteodataForAddressInInterval(address, from, to);
    }

    private static WeatherData getLastMeteodataForAddress(java.lang.String address) {
        org.mycompany.ws.soap.client.GeoMeteoWS_Service service = new org.mycompany.ws.soap.client.GeoMeteoWS_Service();
        org.mycompany.ws.soap.client.GeoMeteoWS port = service.getGeoMeteoWSPort();
        return port.getLastMeteodataForAddress(address);
    }

    private static java.util.List<org.mycompany.ws.soap.client.WeatherData> getLastNMeteodataForAddress(java.lang.String address, int n) {
        org.mycompany.ws.soap.client.GeoMeteoWS_Service service = new org.mycompany.ws.soap.client.GeoMeteoWS_Service();
        org.mycompany.ws.soap.client.GeoMeteoWS port = service.getGeoMeteoWSPort();
        return port.getLastNMeteodataForAddress(address, n);
    }
    
}
