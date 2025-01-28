<?php
namespace APP\models;

class cadastrarUser
{
    private $pdo;

    public function __construct(\PDO $pdo)
    {
        $this->pdo = $pdo;
    }

    public function cadastrar($colunas)
    {
        // Validando o método HTTP
        if ($_SERVER['REQUEST_METHOD'] === 'POST') {
            // Capturando os dados do formulário via $_POST
            $name = $_POST['name'] ?? '';
            $password = $_POST['password'] ?? '';
            $email = $_POST['email'] ?? '';

            // Verificando se os dados obrigatórios foram enviados
            if (!empty($name) && !empty($password) && !empty($email)) {
                //Aqui o formulário é tratado e enviado para o banco de dados

                $stmt = $this->pdo->prepare("SELECT * FROM users WHERE username = :nome_usuario");
                $stmt->bindParam(':nome_usuario', $name);
                $stmt->execute();

                if ($stmt->rowCount() > 0) {
                    $response = [
                        'status' => 'error',
                        'message' => 'O nome de usuário já existe.',
                    ];

                } else {
                    $defaultId = 0;
                    // Lógica de inserção no banco de dados
                    $senha = password_hash($password, PASSWORD_DEFAULT);
                    $stmt = $this->pdo->prepare("INSERT INTO users (id, username, password, email) VALUES (:idUsuario, :nome_usuario, :senha, :email)");
                    $stmt->bindParam(':idUsuario', $defaultId);
                    $stmt->bindParam(':nome_usuario', $name);
                    $stmt->bindParam(':senha', $senha);
                    $stmt->bindParam(':email', $email);
                    $stmt->execute();
                    //Aqui deve retornar alguma mensagem de cadastro sucesso
                    // Resposta de sucesso
                $response = [
                    'status' => 'success',
                    'message' => 'Formulário recebido com sucesso!',
                    'data' => [
                        'name' => $name,
                        'email' => $email,
                    ],
                ];
                }

                
            } else {
                // Resposta de erro: Dados obrigatórios faltando
                $response = [
                    'status' => 'error',
                    'message' => 'Por favor, preencha todos os campos obrigatórios.',
                    'name' => $name,
                    'email' => $email,
                    'senha' => $password,
                ];
            }
        } else {
            // Resposta de erro: Método não permitido
            http_response_code(405);
            $response = [
                'status' => 'error',
                'message' => 'Método HTTP não permitido.',
            ];
        }
        return $response;
    }
}