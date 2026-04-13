package ar.edu.unlp.info.oo1.patronesDeDiseño.ejercicio1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BibliotecaTest {

    private Biblioteca biblioteca;
    private String nl;

    @BeforeEach
    void setUp() {
        biblioteca = new Biblioteca();
        nl = System.lineSeparator();
    }

    @Test
    void testExportarSociosVacio() {
        assertEquals("[]", biblioteca.exportarSocios());
    }

    @Test
    void testExportarSocios() {
        biblioteca.agregarSocio(new Socio("Arya Stark", "needle@stark.com", "5234-5"));
        biblioteca.agregarSocio(new Socio("Tyrion Lannister", "tyrion@thelannisters.com", "2345-2"));

        String esperado = "[" + nl
                + "\t{" + nl
                + "\t\t\"nombre\": \"Arya Stark\"," + nl
                + "\t\t\"email\": \"needle@stark.com\"," + nl
                + "\t\t\"legajo\": \"5234-5\"" + nl
                + "\t}," + nl
                + "\t{" + nl
                + "\t\t\"nombre\": \"Tyrion Lannister\"," + nl
                + "\t\t\"email\": \"tyrion@thelannisters.com\"," + nl
                + "\t\t\"legajo\": \"2345-2\"" + nl
                + "\t}" + nl
                + "]";

        assertEquals(esperado, biblioteca.exportarSocios());
    }

    @Test
    void testUsaExporterConfigurado() {
        biblioteca.setExporter(new Exporter() {
            @Override
            public String exportar(List<Socio> socios) {
                return "EXPORTACION PERSONALIZADA";
            }
        });
        //está comprobando que:
        // 👉 Biblioteca NO hace el JSON por sí misma
        // 👉 sino que usa el objeto exporter que tenga configurado
        assertEquals("EXPORTACION PERSONALIZADA", biblioteca.exportarSocios());
    }

    @Test
    void testUsaJSONSimpleAdapter(){
        biblioteca.setExporter(new JSONSimpleAdapter());

        //testeo contenido
        biblioteca.agregarSocio(new Socio("Arya Stark", "needle@stark.com", "5234-5"));

        String resultado = biblioteca.exportarSocios();

        // verifico que el JSON contiene los datos correctos
        assertTrue(resultado.contains("Arya Stark"));
        assertTrue(resultado.contains("needle@stark.com"));
        assertTrue(resultado.contains("5234-5"));

    }
}