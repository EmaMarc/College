<?php

require_once('db_funcs.php');
require('./bootstrap.php');
use \Firebase\JWT\JWT;

class Client {
    private $id;
    private $nombre;
    // private $usos;
    private $codigo;
    private $codigoAnterior;
    private $mail;
    private $registracion;
    private $expiracionLicencia;

    private $receivedToken;

    // const CANT_USOS = 30;

    public function getJson() {
        return json_encode(array('id' => $this->id,
                                 'nombre' => $this->nombre,
                                 // 'usos' => $this->usos,
                                 'codigo' => $this->codigo,
                                 'codigoAnterior' => $this->codigoAnterior,
                                 'mail' => $this->mail,
                                 'registracion' => $this->registracion,
                                 'expiracionLicencia' => $this->expiracionLicencia,
                                 'receivedToken' => $this->receivedToken), JSON_UNESCAPED_UNICODE);
    }

    public function __get($name) {
        switch ($name) {
            case 'expiracionLicencia':
                $result = $this->expiracionLicencia;
                break;
            case 'nombre':
                $result = $this->nombre;
                break;
            default:
                $result = null;
        }
        return $result;
    }

    public function __isset($name) {
        if ($name = 'expiracionLicencia') {
            
        }
        switch ($name) {
            case 'expiracionLicencia':
                $result = isset($this->expiracionLicencia);
                break;
            case 'nombre':
                $result = isset($this->nombre);
                break;
            default:
                $result = false;
        }
        return $result;
    }

    public static function withName($name, $mail) {
        $instance = new self();
        $instance->nombre = $name;
        $instance->mail = $mail;
        try {
            $registro = SelectByName($instance->nombre);
            $instance->id = $registro['id'];
            // $instance->usos = $registro['usos'];
            $instance->codigo = $registro['codigo'];
            $instance->codigoAnterior = $registro['codigoAnterior'];
            $instance->expiracionLicencia = $registro['expiracionLicencia'];
            $instance->registracion = $registro['registracion'];
        }
        catch (Exception $e) { }

        return $instance;
    }

    public static function withToken($jwt, $log = null) {
        // si todo bien, devuelve un objeto Client; si no un msj de error
        $publicKey = file_get_contents('mykey.pub');

        $log && fwrite($log, "JWT recibido: " . $jwt . PHP_EOL);

        $token = JWT::decode($jwt, $publicKey, ['RS256']);

        $log && fwrite($log, "Token recibido decodificado: " . json_encode($token, JSON_UNESCAPED_UNICODE) . PHP_EOL);

        try {
            $registro = SelectById($token->data->id);

            $log && fwrite($log, "Registro leido de BD: " . json_encode($registro, JSON_UNESCAPED_UNICODE) . PHP_EOL);

            $instance = new self();
            // asigno valores de atributos tomados de la BD
            foreach($registro as $clave => $valor) {
                $instance->{$clave} = $valor;
            }
            // asigno token recibido
            $instance->receivedToken = $token;

            return $instance;
        }
        catch (Exception $e) {
            throw $e;
        }
    }

    public function Exists() {
        return isset($this->id);
    }

    private function GenerarCodigo() {
        return strtoupper(md5(time()));
    }

    public function Registrar() {
        // $this->usos = self::CANT_USOS;
        $this->codigo = $this->GenerarCodigo();
        $this->registracion = time();
        $this->expiracionLicencia = date('Y-m-d', $this->registracion);
        $this->id = InsertClient($this->nombre, /* $this->usos, */ $this->codigo, $this->mail, $this->registracion, $this->expiracionLicencia);
        return $this->GenerarToken();
    }

    public function Actualizar($log = null) {
        if ($this->receivedToken->jti == $this->codigo) {
            $this->codigoAnterior = $this->codigo;
        }
        $this->codigo = $this->GenerarCodigo();

        $log && fwrite($log, "Nuevo código: " . json_encode($this->codigo, JSON_UNESCAPED_UNICODE) . PHP_EOL);

        UpdateCodigo($this->id, $this->codigo, $this->codigoAnterior);
        return $this->GenerarToken();
    }

    public function LicenciaVigente() {
        return isset($this->expiracionLicencia) && $this->expiracionLicencia >= date('Y-m-d');
    }

    public function CodigoOK() {
        return isset($this->receivedToken) && isset($this->receivedToken->jti) &&
               ($this->receivedToken->jti == $this->codigo || 
               $this->receivedToken->jti == $this->codigoAnterior);
    }

    public function GenerarToken() {
        $privateKey = file_get_contents('mykey.pem');
        $time = time();
        $token = array(
            "iat" => $time,
            "jti" => $this->codigo,
            "iss" => $this->nombre,
            'data' => [ // información del usuario
                'id' => $this->id,
                'nombre' => $this->nombre,
                // 'usos' => $this->usos,
                'mail' => $this->mail,
                'expiracionLicencia' => $this->expiracionLicencia
            ]
        );
        $jwt = JWT::encode($token, $privateKey, 'RS256');
        return $jwt;
    }
}

?>