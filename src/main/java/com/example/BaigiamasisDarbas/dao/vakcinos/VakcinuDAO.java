package com.example.BaigiamasisDarbas.dao.vakcinos;

import com.example.BaigiamasisDarbas.dto.Vakcina;

import java.util.List;
import java.util.Optional;

public interface VakcinuDAO {
    Vakcina issaugotiVakcina(Vakcina atnaujinamaVakcina);
    String sukurtiVakcina(Vakcina vakcina);
    Optional<Vakcina> gautiVakcinaPagalId(long id);
    List<Vakcina> gautiVisasVakcinas();
    void istringiVakcina(long id);

}
