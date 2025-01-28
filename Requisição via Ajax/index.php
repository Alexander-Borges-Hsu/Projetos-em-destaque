<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ajax tela 1</title>
</head>
<body>
    <main>
        <form method="post" id="formCadastro">
            <label for="name">Digite seu nome:</label><input type="text" name="name" id="name">
            <label for="password">Digite sua senha:</label><input type="password" name="password" id="password">
            <label for="email">Digite seu email:</label><input type="email" name="email" id="email">
            <button type="submit" id="submit">Enviar</button>
            <div id="resposta"></div>

        </form>
        
    </main>
    
    <script src="./src/views/JavaScript/JSindex.js"></script>
</body>
</html>