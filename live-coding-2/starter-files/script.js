
const API_ENDPOINT = 'https://yesno.wtf/api';

// Función para hacer una solicitud al API y mostrar la respuesta
function fetchAnswer() {
    // Seleccionar el valor del input
    const question = document.getElementById('input').value.trim();

    // Verificar si la pregunta está vacía
    if (!question) {
        // Mostrar un mensaje de error si la pregunta está vacía
        document.getElementById('error').innerText = 'Please enter a question.';
        return; // Salir de la función si no hay pregunta
    }

    // Limpiar cualquier mensaje de error anterior
    document.getElementById('error').innerText = '';

    // Realizar la solicitud al API
    fetch(API_ENDPOINT)
        .then(response => {
            // Verificar si la solicitud fue exitosa
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            // Convertir la respuesta a formato JSON
            return response.json();
        })
        .then(data => {
            // Mostrar la respuesta en el div con id "answer"
            document.getElementById('answer').innerText = data.answer;
        })
        .catch(error => {
            // Manejar cualquier error de red u otros errores
            console.error('There was a problem with the fetch operation:', error);
            // Mostrar un mensaje de error al usuario
            document.getElementById('answer').innerText = 'Sorry, there was an error. Please try again later.';
        });

    // Limpiar la pregunta y la respuesta después de 5 segundos
    setTimeout(() => {
        document.getElementById('input').value = ''; // Limpiar el input
        document.getElementById('answer').innerText = ''; // Limpiar la respuesta
    }, 5000);
}

// Función para manejar el evento de presionar Enter en el input
function handleKeyEnter(event) {
    if (event.key === 'Enter') {
        fetchAnswer();
    }
}

// Agregar un eventListener al botón para llamar a fetchAnswer cuando se haga clic
document.getElementById('button').addEventListener('click', fetchAnswer);
