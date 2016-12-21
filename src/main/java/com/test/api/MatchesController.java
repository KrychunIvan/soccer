package com.test.api;

import com.test.model.MatchesEntity;
import com.test.service.matches.MatchesService;
import com.test.service.matches.dto.MatchesWithDecodedTeamNames;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
public class MatchesController {

    @Autowired
    private MatchesService matchesService;

    @RequestMapping(
            value = "/api/matches",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<MatchesEntity>> getMatches(){

        Collection<MatchesEntity> matches = matchesService.findAll();

        return new ResponseEntity<Collection<MatchesEntity>>(matches, HttpStatus.OK);
    }
    @RequestMapping(
            value = "/api/matches/",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<MatchesWithDecodedTeamNames>> getMatchesTN(){

        List<MatchesWithDecodedTeamNames> matches = matchesService.findAlls();

        return new ResponseEntity<List<MatchesWithDecodedTeamNames>>(matches, HttpStatus.OK);
    }

    @RequestMapping(
            value = "/api/matches/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MatchesEntity> getGreeting(@PathVariable("id") Long id){

        MatchesEntity matchesEntity = matchesService.findOne(id);
        if ( matchesEntity == null ){
            return new ResponseEntity<MatchesEntity>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<MatchesEntity>(matchesEntity,HttpStatus.OK);
    }

    @RequestMapping(
            value = "/api/matches/",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MatchesEntity> createGreeting(@RequestBody MatchesEntity matchesEntity){

        MatchesEntity savedMatchesEntity = matchesService.create(matchesEntity);
        return new ResponseEntity<MatchesEntity>(savedMatchesEntity, HttpStatus.CREATED);
    }

    @RequestMapping (
            value = "/api/matches/{id}",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MatchesEntity> updateGreeting(@RequestBody MatchesEntity matchesEntity){

        MatchesEntity updatedMatchesEntity = matchesService.update(matchesEntity);
        if(updatedMatchesEntity == null) {
            return new ResponseEntity<MatchesEntity>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<MatchesEntity>(HttpStatus.OK);
    }

    @RequestMapping(
            value = "api/matches/{id}",
            method = RequestMethod.DELETE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MatchesEntity> deleteGreeting(
            @PathVariable("id") Long id, @RequestBody MatchesEntity matchesEntity){

        matchesService.delete(id);

        return new ResponseEntity<MatchesEntity>(HttpStatus.NO_CONTENT);
    }

}
