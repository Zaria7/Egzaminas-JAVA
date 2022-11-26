package com.example.BaigiamasisDarbas.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.HashMap;
import java.util.List;

@Entity
@Table(name = "skiepijimoIstaigos")
public class SkiepijimoIstaiga {
    @Id
    private long id;
    private String itaigosPavadinimas;
    private String miestas;
    private String gydytojas;

    public SkiepijimoIstaiga() {}

    public SkiepijimoIstaiga(long id, String itaigosPavadinimas, String miestas, String gydytojas) {
        this.id = id;
        this.itaigosPavadinimas = itaigosPavadinimas;
        this.miestas = miestas;
        this.gydytojas = gydytojas;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getItaigosPavadinimas() {
        return itaigosPavadinimas;
    }

    public void setItaigosPavadinimas(String itaigosPavadinimas) {
        this.itaigosPavadinimas = itaigosPavadinimas;
    }

    public String getMiestas() {
        return miestas;
    }

    public void setMiestas(String miestas) {
        this.miestas = miestas;
    }

    public String getGydytojas() {
        return gydytojas;
    }

    public void setGydytojas(String gydytojas) {
        this.gydytojas = gydytojas;
    }

    @Override
    public String toString() {
        return "SkiepijimoIstaiga{" +
                "id=" + id +
                ", itaigosPavadinimas='" + itaigosPavadinimas + '\'' +
                ", miestas='" + miestas + '\'' +
                ", gydytojas='" + gydytojas + '\'' +
                '}';
    }
}
