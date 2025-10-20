package ar.edu.unlp.info.oo1.ejercicio14;

import ar.edu.unlp.info.oo1.ejercicio7.Circulo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ReporteDeConstruccionTest {
    private ReporteDeConstruccion reporte;
    private Pieza cilindro;
    private Pieza esfera;
    private Pieza prisma;

    @BeforeEach
    void setUp(){
        reporte = new ReporteDeConstruccion();

        cilindro = new Cilindro("Hierro", "Blanco", 5, 10);
        reporte.AgregarPieza(cilindro);

        esfera = new Esfera("Oro", "Dorado", 10);
        reporte.AgregarPieza(esfera);

        prisma = new PrismaRectangular("Cobre", "Marron", 10, 8, 5);
        reporte.AgregarPieza(prisma);
    }
    
    @Test
    void testVolumenDeMaterial(){
        // Cilindro (Hierro): V = π * 5^2 * 10 = 250π ≈ 785.3981634
        assertEquals(250 * Math.PI, reporte.VolumenDeMaterial("Hierro"), 1e-6);

        // Esfera (Oro): V = (4/3)π * 10^3 = (4000/3)π ≈ 4188.7902048
        assertEquals((4000.0/3.0) * Math.PI, reporte.VolumenDeMaterial("Oro"), 1e-6);

        // Prisma (Cobre): V = 10*8*5 = 400
        assertEquals(400.0, reporte.VolumenDeMaterial("Cobre"), 1e-6);

        // Sin coincidencias → 0
        assertEquals(0.0, reporte.VolumenDeMaterial("Plata"), 1e-9);
    }

    @Test
    void testSuperficieDeColor(){
        // Cilindro (Blanco): S = 2πrh + 2πr^2 = 150π ≈ 471.2388980
        assertEquals(150 * Math.PI, reporte.SuperficieDeColor("Blanco"), 1e-6);

        // Esfera (Dorado): S = 4πr^2 = 400π ≈ 1256.6370614
        assertEquals(400 * Math.PI, reporte.SuperficieDeColor("Dorado"), 1e-6);

        // Prisma (Marron): S = 2(ab + ah + bh) = 2(80+50+40) = 340
        assertEquals(340.0, reporte.SuperficieDeColor("Marron"), 1e-6);

        // Sin coincidencias → 0
        assertEquals(0.0, reporte.SuperficieDeColor("Azul"), 1e-9);
    }
}
