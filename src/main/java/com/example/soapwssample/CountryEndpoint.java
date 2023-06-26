package com.example.soapwssample;

import com.zypherscript.soap_ws.GetCountryRequest;
import com.zypherscript.soap_ws.GetCountryResponse;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class CountryEndpoint {

  private static final String NAMESPACE_URI = "http://zypherscript.com/soap-ws";

  private final CountryRepository countryRepository;

  public CountryEndpoint(CountryRepository countryRepository) {
    this.countryRepository = countryRepository;
  }

  @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCountryRequest")
  @ResponsePayload
  public GetCountryResponse getCountry(@RequestPayload GetCountryRequest request) {
    GetCountryResponse response = new GetCountryResponse();
    response.setCountry(countryRepository.findCountry(request.getName()));

    return response;
  }
}
