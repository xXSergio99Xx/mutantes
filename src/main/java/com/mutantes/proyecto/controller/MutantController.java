package com.mutantes.proyecto.controller;

import com.mutantes.proyecto.dto.http.DnaRequest;
import com.mutantes.proyecto.dto.http.StatsResponse;
import com.mutantes.proyecto.service.MutantService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin()
public class MutantController {

    @Autowired
    private MutantService mutantService;
    
    @PostMapping("/mutant")
    public ResponseEntity<?> validateMutant(@RequestBody DnaRequest dna){
        try {
            String message = mutantService.validateData(dna.getDna());
            if(message == null){
                if(mutantService.isMutant(dna.getDna())){
                    return new ResponseEntity<>("Mutant", HttpStatus.OK);
                } else {
                    return new ResponseEntity<>(HttpStatus.FORBIDDEN);
                }
            } else {
                return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/stats")
    public ResponseEntity<?> stats(){
        try {
            StatsResponse statsResponse = mutantService.stats();
            if(statsResponse != null){
                return new ResponseEntity<>(statsResponse, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.FORBIDDEN);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
