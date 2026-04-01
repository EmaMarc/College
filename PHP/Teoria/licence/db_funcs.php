<?php

include('db_login.php');

function ConnectDB() {
    global $db;
    $result = new mysqli($db['hostname'], $db['username'], $db['password'], $db['database']);
    if ($result->connect_errno) {
        throw new Exception($result->connect_error, $result->connect_errno);
    }
    return $result;
}

function SelectClient($col, $val) {
    try {
        $mysqli = ConnectDB();

        $sql = "SELECT * FROM cliente WHERE $col = '$val'";
        if (!$resultado = $mysqli->query($sql)) {
            throw new Exception($mysqli->error, $mysqli->errno);
        }
        // no puede haber más de 1 porque tanto el 'id' como el 'nombre' son únicos
        if ($resultado->num_rows === 0) {
            throw new Exception("No existe el cliente de $col " . $val . ".", 10001);
        }
        return $resultado->fetch_assoc();
    }
    finally {
        $mysqli->close();
    }
}

function SelectByName($name) {
    return SelectClient("nombre", $name);
}

function SelectById($id) {
    return SelectClient("id", $id);
}

function InsertClient($nombre, $codigo, $mail, $registracion, $expiracionLicencia) {
    try {
        $mysqli = ConnectDB();

        $sql = "INSERT INTO cliente (nombre, codigo, mail, expiracionLicencia, registracion) VALUES ('$nombre', '$codigo', '$mail', '$expiracionLicencia', $registracion)";
        if (!$mysqli->query($sql)) {
            throw new Exception($mysqli->error, $mysqli->errno);
        }
        return $mysqli->insert_id;
    }
    finally {
        $mysqli->close();
    }
}

function UpdateCodigo($id, $codigo, $codigoAnterior) {
    try {
        $mysqli = ConnectDB();

        $sql = "UPDATE cliente SET codigo = '$codigo', codigoAnterior = '$codigoAnterior' WHERE id = $id";
        if (!$mysqli->query($sql)) {
            throw new Exception($mysqli->error, $mysqli->errno);
        }
    }
    finally {
        $mysqli->close();
    }
}

?>