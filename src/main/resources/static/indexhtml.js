document.addEventListener("DOMContentLoaded", function() {
    // Tu código aquí
    console.log("CARGO")
    cargarDentistas();
    cargarServicios()

    const button = document.getElementById('btnCrearcita');

// Agregar un evento onclick al botón
    button.addEventListener('click', function(event) {
        event.preventDefault()
        guardarCita();
    });

});


async function guardarCita(){

    let nombreDentist = document.getElementById('selectDentist').value
    let nombreServicio = document.getElementById('selectServicio').value

    let datosCita = {};

    datosCita.den_clave = await extraerIdDentista(nombreDentist);
    datosCita.pac_clave = 1;
    datosCita.fecha = document.getElementById('txtDate').value
    datosCita.observaciones = document.getElementById('txtExtras').value
    datosCita.hora = document.getElementById('txtTime').value
    datosCita.pendiente = 1;
    datosCita.servicio = await extraerIdServicio(nombreServicio);


    try {
        const rawResponse = await fetch('saveCita/cita', {
            method: 'POST',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(datosCita)
        });

        alert("La cita se ah creado con exito")

    }catch (error){
        console.log("El error fue"+error);
    }


}
async function extraerIdDentista(nombreDentist){


    console.log("el nombre del dentista es: "+nombreDentist)

    const rawResponse = await fetch('saveCita/'+nombreDentist, {
        method: 'GET',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
    });

    const dentistas = await rawResponse.json();

    console.log("El id del dentista es: "+dentistas)
    return dentistas.valueOf();

}
async function extraerIdServicio(nombreServicio){

    const rawResponse = await fetch('saveCita/extraIdServ/'+nombreServicio, {
        method: 'GET',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
    });

    const servicio = await rawResponse.json();

    console.log("El id del servicio es: "+servicio)
    return servicio.valueOf();

}
async function cargarDentistas(){
    const rawResponse = await fetch('getDentistas', {
        method: 'GET',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
    });
    const dentistas = await rawResponse.json();

    let select = document.getElementById('selectDentist');

    for (let dentista of dentistas){

        const option = document.createElement('option')

        option.text = dentista.nombre+' '+dentista.app+' '+dentista.apm;

        select.appendChild(option);

    }

}
async function cargarServicios(){
    const rawResponse = await fetch('getServicios', {
        method: 'GET',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
    });
    const Servicios = await rawResponse.json();

    let select = document.getElementById('selectServicio');

    for (let servicio of Servicios){

        const option = document.createElement('option')

        option.text = servicio.servicio;

        select.appendChild(option);

    }

}