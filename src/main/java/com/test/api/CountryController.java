package com.test.api;

import com.test.model.CountryEntity;
import com.test.parser.twekCounty.CountyParser;
import com.test.service.country.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class CountryController {

    @Autowired
    private CountryService objService;

    @RequestMapping(
            value = "/api/country",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<CountryEntity>> getAllCountry(){

        Collection<CountryEntity> teams = objService.findAll();

        return new ResponseEntity<Collection<CountryEntity>>(teams, HttpStatus.OK);
    }

    @RequestMapping(
            value = "/api/country/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CountryEntity> getCountryById(@PathVariable("id") Long id){

        CountryEntity objEntity = objService.findOne(id);
        if ( objEntity == null ){
            return new ResponseEntity<CountryEntity>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<CountryEntity>(objEntity,HttpStatus.OK);
    }

    @RequestMapping(
            value = "/api/country/",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CountryEntity> createCountry(@RequestBody CountryEntity objEntity){

        CountryEntity savedCountryEntity = objService.create(objEntity);
        return new ResponseEntity<CountryEntity>(savedCountryEntity, HttpStatus.CREATED);
    }

    @RequestMapping (
            value = "/api/country/{id}",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CountryEntity> updateCountry(@PathVariable("id") Long id, @RequestBody CountryEntity objEntity){

        CountryEntity updatedCountryEntity = objService.update(objEntity);
        if(updatedCountryEntity == null) {
            return new ResponseEntity<CountryEntity>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<CountryEntity>(HttpStatus.OK);
    }

    @RequestMapping(
            value = "api/country/{id}",
            method = RequestMethod.DELETE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CountryEntity> deleteCountry(
            @PathVariable("id") Long id, @RequestBody CountryEntity objEntity){

        objService.delete(id);

        return new ResponseEntity<CountryEntity>(HttpStatus.NO_CONTENT);
    }
    @RequestMapping(
            value = "/api/country/ini_db",
            method = RequestMethod.POST)
    public ResponseEntity<Collection<CountryEntity>> createCountryDbFromParser(){

        CountyParser countyParser = new CountyParser(
                "https://en.wikipedia.org/wiki/ISO_3166-1","https://ru.wikipedia.org/wiki/ISO_3166-1"
        );

        Collection<CountryEntity> savedCountryEntity = objService.createEntityWithParser(countyParser.getData());

        return new ResponseEntity<Collection<CountryEntity>>(savedCountryEntity, HttpStatus.CREATED);
    }


}
