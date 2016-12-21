package com.test.api;

import com.test.model.LeaguesEntity;
import com.test.service.leagues.LeaguesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class LeaguesController {

    @Autowired
    private LeaguesService leaguesService;

    @RequestMapping(
            value = "/api/leagues",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<LeaguesEntity>> getGreeting(){

        Collection<LeaguesEntity> leagues = leaguesService.findAll();

        return new ResponseEntity<Collection<LeaguesEntity>>(leagues, HttpStatus.OK);
    }

    @RequestMapping(
            value = "/api/leagues/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<LeaguesEntity> getGreeting(@PathVariable("id") Long id){

        LeaguesEntity leaguesEntity = leaguesService.findOne(id);
        if ( leaguesEntity == null ){
            return new ResponseEntity<LeaguesEntity>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<LeaguesEntity>(leaguesEntity,HttpStatus.OK);
    }

    @RequestMapping(
            value = "/api/leagues/",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<LeaguesEntity> createGreeting(@RequestBody LeaguesEntity leaguesEntity){

        LeaguesEntity savedLeaguesEntity = leaguesService.create(leaguesEntity);
        return new ResponseEntity<LeaguesEntity>(savedLeaguesEntity, HttpStatus.CREATED);
    }

    @RequestMapping (
            value = "/api/leagues/{id}",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<LeaguesEntity> updateGreeting(@RequestBody LeaguesEntity leaguesEntity){

        LeaguesEntity updatedLeaguesEntity = leaguesService.update(leaguesEntity);
        if(updatedLeaguesEntity == null) {
            return new ResponseEntity<LeaguesEntity>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<LeaguesEntity>(HttpStatus.OK);
    }

    @RequestMapping(
            value = "api/leagues/{id}",
            method = RequestMethod.DELETE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<LeaguesEntity> deleteGreeting(
            @PathVariable("id") Long id, @RequestBody LeaguesEntity leaguesEntity){

        leaguesService.delete(id);

        return new ResponseEntity<LeaguesEntity>(HttpStatus.NO_CONTENT);
    }

}
