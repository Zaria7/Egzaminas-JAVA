package com.example.BaigiamasisDarbas.controllers;

import com.example.BaigiamasisDarbas.dao.istaigos.IstaiguRepozitorija;
import com.example.BaigiamasisDarbas.dto.SkiepijimoIstaiga;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class IstaiguController {
    private IstaiguRepozitorija istaiguRepozitorija;

    public IstaiguController(@Autowired IstaiguRepozitorija istaiguRepozitorija) {
        this.istaiguRepozitorija = istaiguRepozitorija;
    }

    @PostMapping("/api/istaigos")
    public Optional<SkiepijimoIstaiga> sukurtiIstaiga(@RequestBody SkiepijimoIstaiga istaiga) {
        istaiguRepozitorija.sukurtiSkiepijimoIstaiga(istaiga);
        return istaiguRepozitorija.gautiSkiepijimoIstaigaPagalId(istaiga.getId());
    }

    @GetMapping("/api/istaigos")
    public List<SkiepijimoIstaiga> gautiIstaigas() {
        return istaiguRepozitorija.gautiVisasSkiepijimoIstaigas();
    }

    @GetMapping("/api/istaigos/{id}")
    public Optional<SkiepijimoIstaiga> gautiIstaigaPagalId(@PathVariable Long id) {
        return istaiguRepozitorija.gautiSkiepijimoIstaigaPagalId(id);
    }

    @DeleteMapping("/api/istaigos")
    public void istrintiIstaiga(@RequestParam Long id) {
        istaiguRepozitorija.istringiSkiepijimoIstaiga(id);
    }

    @PutMapping("/api/istaigos/{id}")
    public Optional<SkiepijimoIstaiga> atnaujintiIstaiga(
            @RequestParam Long id,
            @RequestBody SkiepijimoIstaiga naujaIstaigosInfo
    ) {
        var naujinamasIrasas = istaiguRepozitorija.gautiSkiepijimoIstaigaPagalId(id)
                .orElseThrow(() -> new RuntimeException("Nera tokios imones su id: " + id));
        naujinamasIrasas.setId(id);
        naujinamasIrasas.setItaigosPavadinimas(naujaIstaigosInfo.getItaigosPavadinimas());
        naujinamasIrasas.setMiestas(naujaIstaigosInfo.getMiestas());
        naujinamasIrasas.setGydytojas(naujaIstaigosInfo.getGydytojas());
        return istaiguRepozitorija.gautiSkiepijimoIstaigaPagalId(id);
    }
}
