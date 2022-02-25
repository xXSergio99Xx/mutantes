package com.mutantes.proyecto.service.impl;


import com.mutantes.proyecto.service.MutantService;
import com.mutantes.proyecto.helper.Utils;

import org.springframework.stereotype.Service;

@Service
public class MutantServiceImpl implements MutantService{

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
                System.out.printf("[ PASS ] The character sequence %s has been found in the matrix.\n", searchSequence);
            } else {
                System.out.printf("[ FAIL ] The character sequence %s was not found in the matrix.\n", searchSequence);
            }
        }

        if(accumulateSequences >= 3){
            System.out.println("Mutant");
            return true;
        } else {
            System.out.println("Human"); 
            return false;
        }
    }
}
