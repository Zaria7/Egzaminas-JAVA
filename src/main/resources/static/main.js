let linkasVakcinoms = 'http://localhost:8080/api/vakcinos';
let linkasIstaigoms = 'http://localhost:8080/api/istaigos';
let linkasPacientams = 'http://localhost:8080/api/pacientai';

let vakcinuDuomenysZali;
let istaiguDuomenysZali;
let pacientuDuomenysZali;

const vakcinuLentele = document.querySelector('#vakcinuLentele tbody');
const istaiguLentele = document.querySelector('#istaiguLentele tbody');
const pacientuLentele = document.querySelector('#pacientuLentele tbody');

const vakcinos = document.querySelector("#vakcinosSelectorius");
const istaigos = document.querySelector("#istaiguSelectorius");
const testTekstas = document.querySelector("#testTekstas");
const istaiguTekstas = document.querySelector("#istaiguTekstas");
const TESThomeBATONAS = document.querySelector("#home-btn");

// gauti vakcinas
fetch(linkasVakcinoms, {
    mode: "cors"
})
    .then(response => response.json())
    .then(duomenys => {
        console.log("Visos vakcinos");
        console.table(duomenys);
        vakcinuDuomenysZali = duomenys;
        return duomenys;
    })
    .then(duomenys => {
        atkurtiVakcinuLentele(duomenys);
        return duomenys;
    })
    .then(duomenys => {
        let pavadinimai = duomenys.map(x => x.pavadinimas);
        console.table(pavadinimai);
    });

//gauti istaigas
fetch(linkasIstaigoms, {
    mode: "cors"
})
    .then(response => response.json())
    .then(duomenys => {
        console.log("Visos istaigos");
        console.table(duomenys);
        istaiguDuomenysZali = duomenys;
        return duomenys;
    });

//guti pacientus
fetch(linkasPacientams, {
    mode: "cors"
})
    .then(response => response.json())
    .then(duomenys => {
        console.log('Visi pacientai');
        console.table(duomenys);
        pacientuDuomenysZali = duomenys;
        return duomenys;
    });



const atkurtiVakcinuLentele = (duomenys) => {
    for (const element of duomenys) {
        const naujaEile = document.createElement('tr');
        const stulpelisId = document.createElement('td');
        const stulpelisPavadinimas = document.createElement('td');
        const stulpelisData = document.createElement('td');
        const stulpelisSalis = document.createElement('td');
        const stulpelisKomplokacijos = document.createElement('td');
        const stulpelisIstaigosId = document.createElement('td');

        stulpelisId.textContent = element.id;
        stulpelisPavadinimas.textContent = element.pavadinimas;
        stulpelisData.textContent = element.pagaminimoData;
        stulpelisSalis.textContent = element.kilmesSalis;
        stulpelisKomplokacijos.textContent = element.komplikacijos;
        stulpelisIstaigosId.textContent = element.istaigosKuriojeSuleitaId;


        naujaEile.append(stulpelisId, stulpelisPavadinimas, stulpelisData, stulpelisSalis, stulpelisKomplokacijos, stulpelisIstaigosId);
        vakcinuLentele.append(naujaEile);
    }
}

function start(){
    vakcinos.addEventListener("change", addActivityItem, false);
    istaigos.addEventListener("change", addActivityItem1, false);
}

function addActivityItem(){
    //option is selected
    // alert(vakcinos.value);
}

function addActivityItem1(){
    //option is selected
    // alert(istaigos.value);
}

// const vakcinos = document.querySelector("#vakcinosSelectorius");
// const istaigos = document.querySelector("#istaiguSelectorius");

function sudetiPavadinimusIOpcijas(pavadinimai) {
    for (const pavadinimas of pavadinimai) {
        
    }
}
    

window.addEventListener("load", start, false);

TESThomeBATONAS.addEventListener('click', (e) => {
    console.log("Mygtukos su namuku testas");
});