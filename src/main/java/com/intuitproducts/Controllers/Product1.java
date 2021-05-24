package com.intuitproducts.Controllers;

import com.intuitproducts.Service.Product1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.websocket.server.PathParam;
import javax.xml.transform.OutputKeys;
import java.net.URI;
import java.util.List;

    @RestController
    @RequestMapping("/ob1")
    public class Product1
    {
        public static final String SERVICE_ID = "service1";
        @Autowired
        Product1Service service;


        @PostMapping("/subscribe")
        public ResponseEntity<OutputKeys> create(@PathParam("tenantid") String tenantid) throws RecordNotFoundException
        {
            RestTemplate restTemplate = new RestTemplate();
            URI uri = new URI.create("http://localhost:8080/subscription");
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.setContentType(MediaType.APPLICATION_JSON);
            httpHeaders.set("tenantid",tenantid);
            httpHeaders.set("serviceid",SERVICE_ID);
            HttpEntity<String> httpEntity = new HttpEntity<>(httpHeaders);
            return restTemplate.exchange(URI uri, HttpMethod.GET, httpEntity, String.class);
        }
        @PostMapping("/updation")
        public ResponseEntity<OutputKeys> create(@PathParam("tenantid") String tenantid) throws RecordNotFoundException
        {
            RestTemplate restTemplate = new RestTemplate();
            URI uri = new URI.create("http://localhost:8080/updatesubscription");
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.setContentType(MediaType.APPLICATION_JSON);
            httpHeaders.set("tenantid",tenantid);
            httpHeaders.set("serviceid",SERVICE_ID);
            HttpEntity<String> httpEntity = new HttpEntity<>(httpHeaders);
            return restTemplate.exchange(URI uri, HttpMethod.GET, httpEntity, String.class);
        }

        @PostMapping("/validationserive")
        public ResponseEntity<OutputKeys> create(@PathParam("tenantid") String tenantid) throws RecordNotFoundException
        {
            RestTemplate restTemplate = new RestTemplate();
            URI uri = new URI.create("http://localhost:8080//validation/");
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.setContentType(MediaType.APPLICATION_JSON);
            httpHeaders.set("tenantid",tenantid);
            httpHeaders.set("serviceid",SERVICE_ID);
            HttpEntity<String> httpEntity = new HttpEntity<>(httpHeaders);
            return restTemplate.exchange(URI uri, HttpMethod.GET, httpEntity, String.class);
        }
    }

