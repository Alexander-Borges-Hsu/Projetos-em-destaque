document.getElementById('formCadastro').addEventListener('submit', async (e) => {
    e.preventDefault();

    const formData = new FormData(e.target);

    try {
        // Enviando a requisição ao servidor
        const response = await fetch('./src/controller/appController.php?k=2', {
            method: 'POST',
            body: formData
        });

        // Capturando o texto bruto da resposta do servidor
        const responseText = await response.text(); 
        console.log('Resposta do servidor:', responseText); // Exibe a resposta para inspeção

        if (response.ok) {
            // Se o servidor retornou uma resposta, tente convertê-la em JSON
            if (responseText) {
                const data = JSON.parse(responseText);
                const respostaDiv = document.getElementById('resposta');
                respostaDiv.style.color = data.status === 'success' ? 'green' : 'red';
                respostaDiv.textContent = data.message;

            } else {
                console.error('Erro: Resposta vazia do servidor.');
            }
        } else {
            console.error('Erro no servidor.', response.statusText);
        }
    } catch (error) {
        console.error('Erro na requisição:', error);
    }
});
