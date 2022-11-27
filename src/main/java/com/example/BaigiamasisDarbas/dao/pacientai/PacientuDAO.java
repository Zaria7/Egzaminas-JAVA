package com.example.BaigiamasisDarbas.dao.pacientai;

import com.example.BaigiamasisDarbas.dto.Pacientas;
import com.example.BaigiamasisDarbas.dto.Vakcina;

import java.util.List;
import java.util.Optional;

public interface PacientuDAO {
    String sukurtiPacienta(Pacientas pacientas);
    Pacientas issaugotiPacienta(Pacientas pacientas);
    Pacientas gautiPacientaPagalId(long id);
    List<Pacientas> gautiVisusPacientus();
    List<Optional<Vakcina>> kokiasVakcinasGavoPacientas(Long id); //paciento id gauna 3 vakcinas ir datas
    void istringiPacienta(long id);

}
