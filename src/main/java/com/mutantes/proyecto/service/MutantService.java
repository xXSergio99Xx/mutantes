package com.mutantes.proyecto.service;

import com.mutantes.proyecto.dto.http.StatsResponse;

public interface MutantService {
    
    public boolean isMutant(String[] dna);

    public StatsResponse stats();
}
