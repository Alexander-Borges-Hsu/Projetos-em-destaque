<?php
    include('../../vendor/autoload.php');
 
    use APP\persistence\ConnectionFactory;
    $conn = ConnectionFactory::getConnection();

    $controllerOption = $_REQUEST['r'] ?? 'home';
    $controllerAction = $_REQUEST['m'] ?? 'index';
    $controllerKey = $_REQUEST['k'] ?? '';
    
    if($controllerKey ==  1){
        sleep ($controllerAction);
        echo "A solicitação demorou {$controllerAction} segundos";
    }

    //Recepção do formulário via Fetch
    if ($controllerKey == 2) {
        // Configurando cabeçalho de resposta como JSON
        header('Content-Type: application/json');
    
        $classname = "APP\\models\\cadastrarUser";    
        $a = new $classname($conn);
        $response = $a->cadastrar($_POST);
        
        // Retornando a resposta em JSON
        echo json_encode($response);
        
    }
    
    
?>