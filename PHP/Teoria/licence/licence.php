<?php
require('cliente_class.php');

switch($_SERVER['REQUEST_METHOD']) {
  case 'POST':
    echo ProcessPost();
    break;
  case 'GET':
    echo ProcessGet();
    break;
  default: // 'DELETE', 'PUT', etc
    echo BadRequest();
}

function ProcessPost() {
  // No recibo token pero sí recibo el nombre del cliente y el mail
  // Si existe el cliente (entonces tiene una licencia, vigente o vencida)
  //   Si tiene licencia vigente
  //     devuelvo msj de requerimiento erróneo
  //   si no (tiene licencia vencida)
  //     devuelvo mensaje de error informando cómo renovar la licencia
  // si no
  //   registro cliente
  //   valido mail ??
  //   le devuelvo un token con nuevo código
  if (($name = $_POST['nombre']) !== null && ($mail = $_POST['mail']) !== null &&
      ($key = $_POST['key']) !== null && $key === "7D15B2CF9D226B95B40D7D9585218F3D") {
    $cliente = Client::withName($name, $mail);
    if ($cliente->Exists()) {
      if ($cliente->LicenciaVigente()) {
        $result = $cliente->GenerarToken(); // array('error' => "$name tiene una licencia vigente.");
      }
      else {
        $result = array('error' => "$name no tiene licencia o está vencida.");
      }
    }
    else {
      try {
        $result = $cliente->Registrar(); // devuelve el primer token para el cliente nuevo
      }
      catch (Exception $e) {
        $result = array('error' => "Problemas al intentar registrar al usuario. Intentar nuevamente ($e->getMessage()).");
      }
    }
    header("HTTP/1.1 200 OK");
  }
  else {
    $result = array('error' => "Se esperaba recibir los parámetros 'nombre', 'mail' y la clave correcta.");
    header("HTTP/1.1 400 Bad Request");
  }
  return json_encode($result, JSON_UNESCAPED_UNICODE);
}

function ProcessGet() {
  // Recibo token
  // Si es valido y tiene licencia
  //   le devuelvo un nuevo token con una expiracion de un mes a partir del instante actual
  // si no
  //   devuelvo mensaje de error informando cuál es el problema
  $result = '';

  // $log = fopen("log.txt", "w");

  if (($jwt = $_SERVER['HTTP_JWT']) !== null &&
      ($key = $_SERVER['HTTP_KEY']) !== null &&
      $key === "7D15B2CF9D226B95B40D7D9585218F3D") {
    try {
      $cliente = Client::withToken($jwt, $log);

      $log && fwrite($log, "Cliente: " . $cliente->getJson() . PHP_EOL);

      if ($cliente->LicenciaVigente()) {
        if ($cliente->CodigoOK()) {
          $result = $cliente->Actualizar($log);
        }
        else {
          $result = array("error" => "El código enviado por $cliente->nombre es incorrecto.");
        }
      }
      else {
        $result = array("error" => "$cliente->nombre no tiene licencia o está vencida.");
      }
    }
    catch (Exception $e) {
      $result = array("error" => $e->getMessage());
    }
    header("HTTP/1.1 200 OK");
  }
  else {
    $result = array('error' => 'Se esperaba recibir un token.');
    header("HTTP/1.1 400 Bad Request");
  }

  $log && fwrite($log, "Result: " . json_encode($result) . PHP_EOL);

  $log && fclose($log);

  return json_encode($result, JSON_UNESCAPED_UNICODE);
}

function BadRequest() {
  $result = array('error' => 'Requerimiento mal hecho.');
  header("HTTP/1.1 400 Bad Request");
  return json_encode($result, JSON_UNESCAPED_UNICODE);
}

?>