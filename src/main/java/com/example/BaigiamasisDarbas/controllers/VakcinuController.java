package com.example.BaigiamasisDarbas.controllers;

import com.example.BaigiamasisDarbas.dao.vakcinos.VakcinuRepozitorija;
import com.example.BaigiamasisDarbas.dto.Vakcina;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class VakcinuController {
    private VakcinuRepozitorija vakcinuRepozitorija;

    public VakcinuController(@Autowired VakcinuRepozitorija vakcinuRepozitorija) {
        this.vakcinuRepozitorija = vakcinuRepozitorija;
    }

    @PostMapping("/api/vakcinos")
    public Optional<Vakcina> sukurtiVakcina(@RequestBody Vakcina vakcina) {
        vakcinuRepozitorija.sukurtiVakcina(vakcina);
        return vakcinuRepozitorija.gautiVakcinaPagalId(vakcina.getId());
    }

    @GetMapping("/api/vakcinos")
    public List<Vakcina> gautiVakcinas() { return vakcinuRepozitorija.gautiVisasVakcinas();}

    @GetMapping("/api/vakcinos/{id}")
    public Optional<Vakcina> gautiVakcinaPagalId(@RequestParam Long id) {
        return vakcinuRepozitorija.gautiVakcinaPagalId(id);
    }

    @DeleteMapping("/api/vakcinos/{id}")
    public void istringiVakcinaPgalaId(@RequestParam Long id) {
        vakcinuRepozitorija.istringiVakcina(id);
    }

    @PutMapping("/api/vakcinos/{id}")
    public Optional<Vakcina> atnaujintiVakcina (
            @RequestParam Long id,
            @RequestBody Vakcina naujaVakcinosInfo
    ) {
        var nauinamasIrasas = vakcinuRepozitorija.gautiVakcinaPagalId(id)
                .orElseThrow(() -> new RuntimeException("Nera tokios vakcinos su id: " + id));
        nauinamasIrasas.setId(id);
        nauinamasIrasas.setIstaigosKuriojeSuleitaId(naujaVakcinosInfo.getIstaigosKuriojeSuleitaId());
        nauinamasIrasas.setPavadinimas(naujaVakcinosInfo.getPavadinimas());
        nauinamasIrasas.setPagaminimoData(naujaVakcinosInfo.getPagaminimoData());
        nauinamasIrasas.setKilmesSalis(naujaVakcinosInfo.getKilmesSalis());
        nauinamasIrasas.setKomplikacijos(naujaVakcinosInfo.getKomplikacijos());

        return vakcinuRepozitorija.gautiVakcinaPagalId(id);
    }
}
