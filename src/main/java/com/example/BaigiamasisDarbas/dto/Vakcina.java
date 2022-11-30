package com.example.BaigiamasisDarbas.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "vakcinos")
public class Vakcina {
    @Id
    private Long id;
    private Long istaigosKuriojeSuleitaId;
    private String pavadinimas;
    private LocalDate pagaminimoData;
    private String kilmesSalis;
    private Komplikacijos komplikacijos;

    public Vakcina() {}

    public Vakcina(Long id, Long istaigosKuriojeSuleitaId, String  pavadinimas, LocalDate pagaminimoData, String kilmesSalis, Komplikacijos komplikacijos) {
        this.id = id;
        this.istaigosKuriojeSuleitaId = istaigosKuriojeSuleitaId;
        this.pavadinimas = pavadinimas;
        this.pagaminimoData = pagaminimoData;
        this.kilmesSalis = kilmesSalis;
        this.komplikacijos = komplikacijos;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIstaigosKuriojeSuleitaId() {
        return istaigosKuriojeSuleitaId;
    }

    public void setIstaigosKuriojeSuleitaId(Long istaigosKuriojeSuleitaId) {
        this.istaigosKuriojeSuleitaId = istaigosKuriojeSuleitaId;
    }

    public String  getPavadinimas() {
        return pavadinimas;
    }

    public void setPavadinimas(String  pavadinimas) {
        this.pavadinimas = pavadinimas;
    }

    public LocalDate getPagaminimoData() {
        return pagaminimoData;
    }

    public void setPagaminimoData(LocalDate pagaminimoData) {
        this.pagaminimoData = pagaminimoData;
    }

    public String getKilmesSalis() {
        return kilmesSalis;
    }

    public void setKilmesSalis(String kilmesSalis) {
        this.kilmesSalis = kilmesSalis;
    }

    public Komplikacijos getKomplikacijos() {
        return komplikacijos;
    }

    public void setKomplikacijos(Komplikacijos komplikacijos) {
        this.komplikacijos = komplikacijos;
    }
}
