package com.example.BaigiamasisDarbas.dao.istaigos;

import com.example.BaigiamasisDarbas.dto.Pacientas;
import com.example.BaigiamasisDarbas.dto.SkiepijimoIstaiga;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IstaiguJpa extends JpaRepository<SkiepijimoIstaiga, Long> {

    @Query( value = """
            SELECT * FROM pacientai 
            LEFT JOIN skiepijimo_staigos
            ON skiepinimo_istaigos.""",
            nativeQuery = true)
    List<Pacientas> gautiPacientusPagalIstaiga(long istaigosId);
}
