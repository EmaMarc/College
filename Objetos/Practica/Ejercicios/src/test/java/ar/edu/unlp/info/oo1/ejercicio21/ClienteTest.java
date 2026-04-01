package ar.edu.unlp.info.oo1.ejercicio21;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ClienteTest {
    private Cliente personaFisica;
    private Cliente clienteCorporativo;

    @BeforeEach
    void setUp(){
        Cliente PersonaFisica = new PersonaFisica("Mauro","Fake123","1234321");
        Cliente ClienteCorporativo = new PersonaFisica("AstroTech","Fake1233123","20-1234321-6");
    }

    @Test
    void testAgregarEnvio(){

        Envio EnvioLocal = new EnvioLocal(personaFisica,"Fake123Origen","Fake321Destino",2.1,false);
        personaFisica.agregarEnvio(EnvioLocal);
        // Verificás que la lista del cliente tenga el envío
        assertEquals(1, personaFisica.getEnvios().size());

        // Verificás que el envío tenga el cliente correcto
        assertEquals(personaFisica, EnvioLocal.getCliente());
    }

    @Test
    void TestMontoAPagarSinDescuento(){
        Envio envioLocal1 = new EnvioLocal(clienteCorporativo,"Fake123Origen","Fake321Destino",2.1,false);
        Envio envioLocal2 = new EnvioLocal(clienteCorporativo,"Fake123Origen","Fake321Destino",2.1,false);
        clienteCorporativo.agregarEnvio(envioLocal1);
        clienteCorporativo.agregarEnvio(envioLocal2);
        //2envios * 1000
        LocalDate hoy = LocalDate.now();
        LocalDate inicio = hoy.minusDays(1);
        LocalDate fin = hoy.plusDays(1);
        assertEquals(2000,clienteCorporativo.montoAPagar(inicio,fin));
    }

    @Test
    void TestMontoAPagarConDescuento(){
        Envio envioLocal1 = new EnvioLocal(personaFisica,"Fake123Origen","Fake321Destino",2.1,false);
        Envio envioLocal2 = new EnvioLocal(personaFisica,"Fake123Origen","Fake321Destino",2.1,false);
        personaFisica.agregarEnvio(envioLocal1);
        personaFisica.agregarEnvio(envioLocal2);

        LocalDate hoy = LocalDate.now();
        LocalDate inicio = hoy.minusDays(1);
        LocalDate fin = hoy.plusDays(1);
        //2envios * 1000 * 0.90 = 1800
        assertEquals(1800,personaFisica.montoAPagar(inicio, fin));
    }

}
