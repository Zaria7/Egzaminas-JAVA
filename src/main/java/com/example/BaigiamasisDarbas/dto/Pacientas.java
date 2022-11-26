package com.example.BaigiamasisDarbas.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pacientai")
public class Pacientas {
    @Id
    private long id;
    private String vardas;
    private String pavarde;
    private int amzius;
    private Long istaigosId;
    private Long pirmaDoze;
    private Long antraDoze;
    private Long treciaDoze;
    private String komplikacijos;

    public Pacientas() {}

    public Pacientas(long id, String vardas, String pavarde, int amzius, Long istaigosId, Long pirmaDoze, Long antraDoze, Long treciaDoze, String komplikacijos) {
        this.id = id;
        this.vardas = vardas;
        this.pavarde = pavarde;
        this.amzius = amzius;
        this.istaigosId = istaigosId;
        this.pirmaDoze = pirmaDoze;
        this.antraDoze = antraDoze;
        this.treciaDoze = treciaDoze;
        this.komplikacijos = komplikacijos;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getVardas() {
        return vardas;
    }

    public void setVardas(String vardas) {
        this.vardas = vardas;
    }

    public String getPavarde() {
        return pavarde;
    }

    public void setPavarde(String pavarde) {
        this.pavarde = pavarde;
    }

    public int getAmzius() {
        return amzius;
    }

    public void setAmzius(int amzius) {
        this.amzius = amzius;
    }

    public Long getIstaigosId() {
        return istaigosId;
    }

    public void setIstaigosId(Long istaigosId) {
        this.istaigosId = istaigosId;
    }

    public Long getPirmaDoze() {
        return pirmaDoze;
    }

    public void setPirmaDoze(Long pirmaDoze) {
        this.pirmaDoze = pirmaDoze;
    }

    public Long getAntraDoze() {
        return antraDoze;
    }

    public void setAntraDoze(Long antraDoze) {
        this.antraDoze = antraDoze;
    }

    public Long getTreciaDoze() {
        return treciaDoze;
    }

    public void setTreciaDoze(Long treciaDoze) {
        this.treciaDoze = treciaDoze;
    }

    public String getKomplikacijos() {
        return komplikacijos;
    }

    public void setKomplikacijos(String komplikacijos) {
        this.komplikacijos = komplikacijos;
    }

    @Override
    public String toString() {
        return "Pacientas{" +
                "id=" + id +
                ", vardas='" + vardas + '\'' +
                ", pavarde='" + pavarde + '\'' +
                ", amzius=" + amzius +
                ", istaigosId=" + istaigosId +
                ", pirmaDoze=" + pirmaDoze +
                ", antraDoze=" + antraDoze +
                ", treciaDoze=" + treciaDoze +
                ", komplikacijos='" + komplikacijos + '\'' +
                '}';
    }
}
