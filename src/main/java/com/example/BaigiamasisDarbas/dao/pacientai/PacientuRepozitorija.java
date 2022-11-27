package com.example.BaigiamasisDarbas.dao.pacientai;

import com.example.BaigiamasisDarbas.dao.vakcinos.VakcinuJpa;
import com.example.BaigiamasisDarbas.dto.Pacientas;
import com.example.BaigiamasisDarbas.dto.Vakcina;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
public class PacientuRepozitorija implements PacientuDAO{
    private final PacientuJpa pacientuJpa;
    private final VakcinuJpa vakcinuJpa;

    public PacientuRepozitorija(
            @Autowired PacientuJpa pacientuJpa,
            @Autowired VakcinuJpa vakcinuJpa
    ) {
        this.pacientuJpa = pacientuJpa;
        this.vakcinuJpa = vakcinuJpa;
    }

    @Override
    public String sukurtiPacienta(Pacientas pacientas) {
        var naujasId = pacientas.getId();
        boolean ifExists = gautiVisusPacientus()
                .stream()
                .mapToLong(Pacientas::getId)
                .anyMatch(id -> naujasId == id);
        if (ifExists) {
            return "Toks įrašas jau yea";
        } else {
            pacientuJpa.save(pacientas);
            return "Pacientas sėkmingai sukurtas";
        }
    }

    @Override
    public Pacientas issaugotiPacienta(Pacientas pacientas) {
        return pacientuJpa.save(pacientas);
    }

    @Override
    public Optional<Pacientas> gautiPacientaPagalId(long id) {
        return pacientuJpa.findById(id);
    }

    @Override
    public List<Pacientas> gautiVisusPacientus() {
        return pacientuJpa.findAll();
    }

    @Override
    public void istringiPacienta(long id) {
        pacientuJpa.deleteById(id);
    }
}
