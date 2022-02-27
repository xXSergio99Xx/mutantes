package com.mutantes.proyecto.repository;

import java.util.List;
import java.util.Optional;

import com.mutantes.proyecto.model.Stats;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class StatsRepositoryTest {
    
    @Autowired
    private StatsRepository statsRepository;

    @Test
    public void whenFindById(){
        Stats stats = Stats.builder()
                            .id(1l)
                            .resultType("MUTANT")
                            .build();

        statsRepository.save(stats);

        List<Stats> found = statsRepository.findByResultType(stats.getResultType());

        Assertions.assertThat(found.size()).isEqualTo(1);
    }
}
