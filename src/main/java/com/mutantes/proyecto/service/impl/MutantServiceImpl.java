package com.mutantes.proyecto.service.impl;


import com.mutantes.proyecto.service.MutantService;
import com.mutantes.proyecto.dto.http.StatsResponse;
import com.mutantes.proyecto.helper.Utils;
import com.mutantes.proyecto.model.Stats;
import com.mutantes.proyecto.repository.StatsRepository;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MutantServiceImpl implements MutantService{

    private final StatsRepository statsRepository;

    @Override
    public boolean isMutant(String[] dna) {
        
        // char[][] matrix = {
        //     {'G', 'H', 'A', 'T', 'G'},
        //     {'X', 'A', 'X', 'G', 'C'},
        //     {'X', 'L', 'G', 'O', 'C'},
        //     {'X', 'G', 'X', 'G', 'C'},
        //     {'X', 'O', 'O', 'L', 'C'}
        // };

        char[][] matrix = Utils.convertStringToChar(dna);

        Utils.previewMatrix(matrix);

        String[] searchSequences = {"AAAA", "GGGG", "CCCC", "TTTT"};

        int accumulateSequences = 0;

        for (String searchSequence : searchSequences) {
            boolean found = Utils.search(searchSequence, matrix);
            System.out.println(found);
            // boolean isWordFound = searchWord(searchSequence, matrix);

            if (found) {
                accumulateSequences++;
                System.out.printf("Found sequence %s \n", searchSequence);
            } else {
                System.out.printf("Not Found sequence %s \n", searchSequence);
            }
        }

        if(accumulateSequences >= 3){
            Stats stats = Stats.builder().resultType("MUTANT").build();
            statsRepository.save(stats);
            return true;
        } else {
            Stats stats = Stats.builder().resultType("HUMAN").build();
            statsRepository.save(stats);
            return false;
        }
    }

    @Override
    public StatsResponse stats() {
        
        Long countHuman     = statsRepository.countByResultType("HUMAN");
        Long countMutant    = statsRepository.countByResultType("MUTANT");

        double ratio        = countMutant.doubleValue()/(countHuman.doubleValue() != 0 ? countHuman : 1l);

        StatsResponse statsResponse = StatsResponse.builder()
                                                    .countHumanDna(countHuman)
                                                    .countMutantDna(countMutant)
                                                    .ratio(ratio)
                                                    .build();

        return statsResponse;
    }

    @Override
    public String validateData(String[] dna) {
        String message = null;
        try {
            int row     = dna.length;

            if(row > 0){
                int column  = dna[0].length();
                for (String string : dna) {
                    if(string.length() == column){
                        if(string.matches("^[aAtTcCgG]+$")){
                            message = null;
                        } else {
                            message = "Only letters 'A, C, T, G' are allowed";
                            break;
                        }
                    } else {
                        message = "Column size does not match";
                        break;
                    }
                }
            } else {
                message = "No data found";
            }
        } catch (Exception e) {
            message = e.getMessage();
        }
        return message;
    }
}
