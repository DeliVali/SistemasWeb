var bLogeo = document.getElementById('signin');
bLogeo.addEventListener('click', function () {
    var e = document.getElementById('email').value;
    var p = document.getElementById('password').value;
    const parametros = new URLSearchParams();
    parametros.append('PrmEmail', e);
    parametros.append('PrmPassword', p);
    // axios.get('http://localhost/hola?'+parametros)
    //     .then(function (response) {
    //         console.log(response)
    //         console.log('contenido: ' + response.data)
    //         console.log('estatus: ' + response.status)
    //         document.getElementById('titulo').innerHTML = response.data
    //     })
    //     .catch(function (error) {
    //         console.log(error)
    //     })
    //Se hace la peticion de POST enviando parametros como parte de la url
    /*axios.post('http://localhost/adios?'+parametros)
        .then(function (response) {
            console.log(response)
            console.log('contenido: ' + response.data)
            console.log('estatus: ' + response.status)
            document.getElementById('titulo').innerHTML = response.data
        })
        .catch(function (error) {
            console.log(error)
        })*/



//Se hace la peticion post enviando los parametros como json
    axios.post('http://localhost/adiosJson?',{
    PrmEmail:e,
    PrmPassword :p

})
        .then(function (response) {
            console.log(response)
            console.log('contenido: ' + response.data)
            console.log('estatus: ' + response.status)
            document.getElementById('titulo').innerHTML = response.data
        })
        .catch(function (error) {
            console.log(error)
        })

// //Se hace la peticion post enviando los parametros como json
// axios.post('http://localhost/adios?',parametros)
//         .then(function (response) {
//             console.log(response)
//             console.log('contenido: ' + response.data)
//             console.log('estatus: ' + response.status)
//             document.getElementById('titulo').innerHTML = response.data
//         })
//         .catch(function (error) {
//             console.log(error)
//         })

})