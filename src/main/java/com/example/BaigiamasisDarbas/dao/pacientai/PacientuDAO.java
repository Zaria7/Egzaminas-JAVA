package com.example.BaigiamasisDarbas.dao.pacientai;

import com.example.BaigiamasisDarbas.dto.Pacientas;
import com.example.BaigiamasisDarbas.dto.Vakcina;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface PacientuDAO {
    String sukurtiPacienta(Pacientas pacientas);
    Pacientas issaugotiPacienta(Pacientas pacientas);
    Optional<Pacientas> gautiPacientaPagalId(long id);
    List<Pacientas> gautiVisusPacientus();
    void istringiPacienta(long id);

}
