<?php
namespace APP\persistence;

class ConnectionFactory
{

    private static $db_name = "bdestudos";
    private static $db_host = "127.0.0.1";
    private static $db_port = "3306";
    private static $db_username = "root";
    private static $db_password = "";
    private static $conn = null;

    static function getConnection()
    {
        $connectionString = "mysql:host=" . self::$db_host . ";dbname=" . self::$db_name . ";dbport=" . self::$db_port;

        if (self::$conn == null) {
            self::$conn = new \PDO($connectionString, self::$db_username, self::$db_password);
            self::$conn->setAttribute(\PDO::ATTR_ERRMODE, \PDO::ERRMODE_EXCEPTION);
        }

        return self::$conn;


    }

}

?>