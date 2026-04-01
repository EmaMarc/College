package ar.edu.unlp.info.oo1.ejercicio21;

import org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EnvioTest {
    private Cliente personaFisica;
    private Cliente clienteCorporativo;

    @BeforeEach
    void setUp(){
        personaFisica = new PersonaFisica("Mauro","Fake123","1234321");
        clienteCorporativo = new ClienteCorporativo("AstroTech","Fake666","20-1234321-6");
    }

    @Test
    void TestEnvioLocal(){
        Envio LocalNoRapido = new EnvioLocal(clienteCorporativo,"Fake123Origen","Fake321Destino",2.1,false);
        assertEquals(1000, LocalNoRapido.costo());

        Envio LocalRapido = new EnvioLocal(clienteCorporativo,"Fake123Origen","Fake321Destino",2.1,true);
        assertEquals(1500, LocalRapido.costo());
    }

    @Test
    void TestEnvioInterurbano(){
        Envio Urbano100 = new EnvioInterurbano(clienteCorporativo,"Fake123", "Real321",1.0, 10.0);
        //$20 * 1Gr a menos de 100 km
        assertEquals(20,Urbano100.costo());

        Envio Urbano500 = new EnvioInterurbano(clienteCorporativo,"Fake123", "Real321",1.0, 200.0);
        //$25 * 1Gr a mas de 100 km
        assertEquals(25,Urbano500.costo());

        Envio Urbano1000 = new EnvioInterurbano(clienteCorporativo,"Fake123", "Real321",1.0, 1000.0);
        //$30 * 1Gr a mas de 500 km
        assertEquals(30,Urbano1000.costo());
    }

    @Test
    void TestEnvioInternacional(){
        Envio InternacionalNoRapido = new EnvioInternacional(clienteCorporativo,"Fake123Origen","Fake321Destino",1,false);
        //$5000 + $10 * 1gr = $5010
        assertEquals(5010,InternacionalNoRapido.costo());

        Envio InternacionalNoRapido1000gr = new EnvioInternacional(clienteCorporativo,"Fake123Origen","Fake321Destino",1000,false);
        //$5000 + $12 * 1000gr = $5000 + $12000 = $17000
        assertEquals(17000, InternacionalNoRapido1000gr.costo());

        Envio InternacionalRapido = new EnvioInternacional(clienteCorporativo,"Fake123Origen","Fake321Destino",1,true);
        //$5000 + $10 * 1gr + $800 = $5810
        assertEquals(5810,InternacionalRapido.costo());
    }


}
