package com.example.BaigiamasisDarbas.dao.vakcinos;

import com.example.BaigiamasisDarbas.dto.Vakcina;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface VakcinuDAO {
    Vakcina issaugotiVakcina(Vakcina atnaujinamaVakcina);
    String sukurtiVakcina(Vakcina vakcina);
    Optional<Vakcina> gautiVakcinaPagalId(long id);
    List<Vakcina> gautiVisasVakcinas();
    void istringiVakcina(long id);

}
