package com.example.BaigiamasisDarbas.controllers;

import com.example.BaigiamasisDarbas.dao.istaigos.IstaiguReopzitorija;
import com.example.BaigiamasisDarbas.dto.SkiepijimoIstaiga;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class IstaiguController {
    private IstaiguReopzitorija istaiguReopzitorija;

    public IstaiguController(@Autowired IstaiguReopzitorija istaiguReopzitorija) {
        this.istaiguReopzitorija = istaiguReopzitorija;
    }

    @PostMapping("/api/istaigos")
    public Optional<SkiepijimoIstaiga> sukurtiIstaiga(@RequestBody SkiepijimoIstaiga istaiga) {
        istaiguReopzitorija.sukurtiSkiepijimoIstaiga(istaiga);
        return istaiguReopzitorija.gautiSkiepijimoIstaigaPagalId(istaiga.getId());
    }

    @GetMapping("/api/istaigos")
    public List<SkiepijimoIstaiga> gautiIstaigas() {
        return istaiguReopzitorija.gautiVisasSkiepijimoIstaigas();
    }

    @GetMapping("/api/istaigos/{id}")
    public Optional<SkiepijimoIstaiga> gautiIstaigaPagalId(@PathVariable Long id) {
        return istaiguReopzitorija.gautiSkiepijimoIstaigaPagalId(id);
    }

    @DeleteMapping("/api/istaigos")
    public void istrintiIstaiga(@RequestParam Long id) {
        istaiguReopzitorija.istringiSkiepijimoIstaiga(id);
    }

    @PutMapping("/api/istaigos/{id}")
    public Optional<SkiepijimoIstaiga> atnaujintiIstaiga(
            @RequestParam Long id,
            @RequestBody SkiepijimoIstaiga naujaIstaigosInfo
    ) {
        var naujinamasIrasas = istaiguReopzitorija.gautiSkiepijimoIstaigaPagalId(id)
                .orElseThrow(() -> new RuntimeException("Nera tokios imones su id: " + id));
        naujinamasIrasas.setId(id);
        naujinamasIrasas.setItaigosPavadinimas(naujaIstaigosInfo.getItaigosPavadinimas());
        naujinamasIrasas.setMiestas(naujaIstaigosInfo.getMiestas());
        naujinamasIrasas.setGydytojas(naujaIstaigosInfo.getGydytojas());
        return istaiguReopzitorija.gautiSkiepijimoIstaigaPagalId(id);
    }
}
