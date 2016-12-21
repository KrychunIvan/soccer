package com.test.api;

import com.test.model.TeamsEntity;
import com.test.service.teams.TeamsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class TeamsController {

    @Autowired
    private TeamsService teamsService;

    @RequestMapping(
            value = "/api/teams",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<TeamsEntity>> getGreeting(){

        Collection<TeamsEntity> teams = teamsService.findAll();

        return new ResponseEntity<Collection<TeamsEntity>>(teams, HttpStatus.OK);
    }

    @RequestMapping(
            value = "/api/teams/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TeamsEntity> getGreeting(@PathVariable("id") Long id){

        TeamsEntity teamsEntity = teamsService.findOne(id);
        if ( teamsEntity == null ){
            return new ResponseEntity<TeamsEntity>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<TeamsEntity>(teamsEntity,HttpStatus.OK);
    }

    @RequestMapping(
            value = "/api/teams/",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TeamsEntity> createGreeting(@RequestBody TeamsEntity teamsEntity){

        TeamsEntity savedTeamsEntity = teamsService.create(teamsEntity);
        return new ResponseEntity<TeamsEntity>(savedTeamsEntity, HttpStatus.CREATED);
    }

    @RequestMapping (
            value = "/api/teams/{id}",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TeamsEntity> updateGreeting(@RequestBody TeamsEntity teamsEntity){

        TeamsEntity updatedTeamsEntity = teamsService.update(teamsEntity);
        if(updatedTeamsEntity == null) {
            return new ResponseEntity<TeamsEntity>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<TeamsEntity>(HttpStatus.OK);
    }

    @RequestMapping(
            value = "api/teams/{id}",
            method = RequestMethod.DELETE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TeamsEntity> deleteGreeting(
            @PathVariable("id") Long id, @RequestBody TeamsEntity teamsEntity){

        teamsService.delete(id);

        return new ResponseEntity<TeamsEntity>(HttpStatus.NO_CONTENT);
    }

}
