package ar.edu.unlp.info.oo1.ejercicio13;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InversorTest {
    private Inversor inversor;

    // Para parsear "25/07/25" -> LocalDate
    private static final DateTimeFormatter DMY_2DIGITS = DateTimeFormatter.ofPattern("dd/MM/yy");

    @BeforeEach
    void setUp(){
        inversor = new Inversor();
    }

    @Test
    void testAgregarAccion(){
        //guardo lo que tenia antes de empezar
        double total0 = inversor.valorTotal();

        //agrego
        Accion accion = new Accion("OpenAi",10.0,5);//50
        inversor.agregarInversion(accion);

        //pregunto si lo que tenia antes + 50, es igual a lo que agregue
        assertEquals(total0 + 50, inversor.valorTotal());
    }

    @Test
    void testQuitarAccion(){
        //creo y agrego la accion que voy a quitar
        Accion accion = new Accion("OpenAi",10.0,5);
        inversor.agregarInversion(accion);

        //elimino
        inversor.quitarInversion(accion);



        //que assert deberia hacer para comparar que se elimino
    }

    @Test
    void testAgregarPlazoFijo(){
        //me toma la fecha como string
        PlazoFijo pf = new PlazoFijo(LocalDate.now(),10.0,0.10);
        inversor.agregarInversion(pf);
        //assert?
    }

    @Test
    void testQuitarPlazoFijo(){
        //me toma la fecha como string
        PlazoFijo pf = new PlazoFijo(LocalDate.now(),10.0,0.10);
        inversor.quitarInversion(pf);
        //assert??
    }

    @Test
    void testValorTotal(){
        Accion accion = new Accion("OpenAi",10.0,1);
        Accion accion2 = new Accion("OpenAi",20.0,1);
        assertEquals(30,inversor.valorTotal());
    }
}
