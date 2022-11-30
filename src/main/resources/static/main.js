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
        vakcinuDuomenysZali = duomenys;
        return duomenys;
    })
    .then(duomenys => {
        atkurtiVakcinuLentele(duomenys);
        return duomenys;
    })
    .then(duomenys => {
        const unikalusPavadinimai = new Set();
        let visiPavadinimai = duomenys.map(x => x.pavadinimas).forEach(x => {
            unikalusPavadinimai.add(x);
        });
        sudetiPavadinimusIOpcijas(unikalusPavadinimai, vakcinos);
    });

//gauti istaigas
fetch(linkasIstaigoms, {
    mode: "cors"
})
    .then(response => response.json())
    .then(duomenys => {
        istaiguDuomenysZali = duomenys;
        return duomenys;
    })
    .then(duomenys => {
        atkurtiIstaiguLentele(duomenys);
        return duomenys;
    })
    .then(duomenys => {
        const unikalusPavadinimai = new Set();
        let visiPavadinimai = duomenys.map(x => x.itaigosPavadinimas).forEach(x => {
            unikalusPavadinimai.add(x);
        });
        sudetiPavadinimusIOpcijas(unikalusPavadinimai, istaigos);
    });

//guti pacientus
fetch(linkasPacientams, {
    mode: "cors"
})
    .then(response => response.json())
    .then(duomenys => {
        pacientuDuomenysZali = duomenys;
        return duomenys;
    })
    .then(duomenys => {
        atkurtiPacientuLentele(duomenys);
        return duomenys;
    });



const atkurtiVakcinuLentele = (duomenys) => {
    vakcinuLentele.innerHTML = "";
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
    };
};

const atkurtiIstaiguLentele = (duomenys) => {
    istaiguLentele.innerHTML = "";
    for (const element of duomenys) {
        const naujaEile = document.createElement('tr');
        const stulpelisId = document.createElement('td');
        const stulpelisPavadinimas = document.createElement('td');
        const stulpelisMiestas = document.createElement('td');
        const stulpelisGydytojas = document.createElement('td');

        stulpelisId.textContent = element.id;
        stulpelisPavadinimas.textContent = element.itaigosPavadinimas;
        stulpelisMiestas.textContent = element.miestas;
        stulpelisGydytojas.textContent = element.gydytojas;

        naujaEile.append(stulpelisId, stulpelisPavadinimas, stulpelisMiestas, stulpelisGydytojas);
        istaiguLentele.append(naujaEile);
    }
};

const atkurtiPacientuLentele = (duomenys) => {
    pacientuLentele.innerHTML = "";
    for (const element of duomenys) {
        const naujaEile = document.createElement('tr');
        const stulpelisId = document.createElement('td');
        const stulpelisVardas = document.createElement('td');
        const stulpelisPavarde = document.createElement('td');
        const stulpelisAmzius = document.createElement('td');
        const stulpelisPirmosDozesId = document.createElement('td');
        const stulpelisAntrosDozesId = document.createElement('td');
        const stulpelisTreciosDozesId = document.createElement('td');

        stulpelisId.textContent = element.id;
        stulpelisVardas.textContent = element.vardas;
        stulpelisPavarde.textContent = element.pavarde;
        stulpelisAmzius.textContent = element.amzius;
        stulpelisPirmosDozesId.textContent = element.pirmaDoze;
        stulpelisAntrosDozesId.textContent = element.antraDoze;
        stulpelisTreciosDozesId.textContent = element.treciaDoze;

        naujaEile.append(stulpelisId, stulpelisVardas, stulpelisPavarde, stulpelisAmzius, stulpelisPirmosDozesId, stulpelisAntrosDozesId, stulpelisTreciosDozesId);
        pacientuLentele.append(naujaEile);
    }
};

function start(){
    vakcinos.addEventListener("change", pasirinktaVakcina, false);
    istaigos.addEventListener("change", pasirinktaIstaiga, false);
}

function pasirinktaVakcina(){
    //option is selected
    atkurtiVakcinuLentele(vakcinuDuomenysZali.filter(x => x.pavadinimas === vakcinos.value));
    if (vakcinos.value === "all") {
        atkurtiVakcinuLentele(vakcinuDuomenysZali);
    }
}

function pasirinktaIstaiga(){
    atkurtiIstaiguLentele(istaiguDuomenysZali.filter(x => x.itaigosPavadinimas === istaigos.value));
    if (istaigos.value === "all") {
        atkurtiIstaiguLentele(istaiguDuomenysZali);
    }
}

// const vakcinos = document.querySelector("#vakcinosSelectorius");
// const istaigos = document.querySelector("#istaiguSelectorius");

function sudetiPavadinimusIOpcijas(pavadinimai, array) {
    for (const pavadinimas of pavadinimai) {
        const opcija = document.createElement('option');
        opcija.value = pavadinimas;
        opcija.textContent = pavadinimas;
        array.append(opcija);
    }
}
    

window.addEventListener("load", start, false);

TESThomeBATONAS.addEventListener('click', (e) => {
    console.log("Mygtukos su namuku testas");
});