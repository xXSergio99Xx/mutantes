package com.mutantes.proyecto.service.impl;

import static org.mockito.ArgumentMatchers.anyString;

import com.mutantes.proyecto.dto.http.StatsResponse;
import com.mutantes.proyecto.model.Stats;
import com.mutantes.proyecto.repository.StatsRepository;
import com.mutantes.proyecto.service.MutantService;

import org.aspectj.lang.annotation.Before;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MutantServiceTest {

    @Mock
    private StatsRepository statsRepository;

    private MutantService mutantService;

    Stats stats = Stats.builder()
            .id(1l)
            .resultType("HUMAN")
            .build();

    Stats stats2 = Stats.builder()
            .id(2l)
            .resultType("MUTANT")
            .build();

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        mutantService = new MutantServiceImpl(statsRepository);

    }

    @Test
    public void isMutantTest() {
        String[] dna = { "GTATG", "AAAGC", "ATGTC", "AGAGC", "ATTTC" };
        Mockito.when(statsRepository.save(stats)).thenReturn(stats);
        boolean response = mutantService.isMutant(dna);
        Assertions.assertThat(response).isTrue();
    }

    @Test
    public void statsTest() {

        StatsResponse statsResponse = StatsResponse.builder()
                .countHumanDna(1l)
                .countMutantDna(1l)
                .ratio(1d)
                .build();

        Mockito.when(statsRepository.countByResultType(Mockito.anyString())).thenReturn(1l);
        StatsResponse statsResponseTest = mutantService.stats();
        Assertions.assertThat(statsResponse.getRatio()).isEqualTo(statsResponseTest.getRatio());

    }

    @Test
    public void validateDataTest() {
        String[] dna = { "GTATG", "AAAGC", "ATGTC", "AGAGC", "ATTTC" };
        String response = mutantService.validateData(dna);
        Assertions.assertThat(response).isEqualTo(null);
    }
}
