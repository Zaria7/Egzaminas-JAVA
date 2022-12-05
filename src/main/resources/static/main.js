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

const komplikacijos0 = document.querySelector('#komplikacijos0');
const komplikacijos1 = document.querySelector('#komplikacijos1');
const komplikacijos2 = document.querySelector('#komplikacijos2');
const komplikacijos3 = document.querySelector('#komplikacijos3');
const komplikacijos4 = document.querySelector('#komplikacijos4');

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
        atvaizduotiKomplikacijas(duomenys);
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

const atvaizduotiKomplikacijas = duomenys => {
    let kompl0rez = 0;
    let kompl1rez = 0;
    let kompl2rez = 0;
    let kompl3rez = 0;
    let kompl4rez = 0;
    let totalCount = Object.keys(duomenys).length;
    

    duomenys.forEach(x => {
        if (x.komplikacijos.toLowerCase() === 'nera') {
            kompl0rez++;
        } else if (x.komplikacijos.toLowerCase() === 'nezymi') {
            kompl1rez++;
        } else if (x.komplikacijos.toLowerCase() === 'vidutine') {
            kompl2rez++;               
        } else if (x.komplikacijos.toLowerCase() === 'hospitalizacija') {
            kompl3rez++;               
        } else if (x.komplikacijos.toLowerCase() === 'mirtis') {
            kompl4rez++;               
        }
    })

    komplikacijos0.textContent = Math.round((kompl0rez / totalCount) * 100);
    komplikacijos1.textContent = Math.round((kompl1rez / totalCount) * 100);
    komplikacijos2.textContent = Math.round((kompl2rez / totalCount) * 100);
    komplikacijos3.textContent = Math.round((kompl3rez / totalCount) * 100);
    komplikacijos4.textContent = Math.round((kompl4rez / totalCount) * 100);
};

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
    atvaizduotiKomplikacijas(vakcinuDuomenysZali.filter(x => x.pavadinimas === vakcinos.value));
    if (vakcinos.value === "all") {
        atkurtiVakcinuLentele(vakcinuDuomenysZali);
        atvaizduotiKomplikacijas(vakcinuDuomenysZali);
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