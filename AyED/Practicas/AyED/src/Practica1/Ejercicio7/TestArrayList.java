package Practica1.Ejercicio7;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestArrayList {
    private List<Estudiante> misEstudiantes;
    private List<Estudiante> misEstudiantesCopia;

    public TestArrayList() {
    }

    public void Generar(){
        Scanner teclado = new Scanner(System.in);
        int opcion = -1;

        while(opcion != 0){
            System.out.println("Seleccione una opcion:");
            System.out.println("1. Generar lista con 3 estudiantes.");
            System.out.println("2. Generar nueva lista copiando la primera lista");
            System.out.println("3. Imprimir contenido de las listas.");
            System.out.println("4. Modificar datos de estudiantes.");
            System.out.println("0. Para finalizar");
            opcion = teclado.nextInt();
            switch (opcion){
                case 1:
                    GenerarLista();
                    break;
                case 2:
                    CopiarLista();
                    break;
                case 3:
                    ImprimirListas();
                    break;
                case 4:
                    ModificarEstudiantes();
                    break;
            }
        }

    }


    private List<Estudiante> GenerarLista() {
        List<Estudiante> Estudiantes = new ArrayList<>();
        Estudiante Estudiante7 = new Estudiante("Emma", "Marc","Emma.Marc@Gmail.com","Mañana","13 y 72");
        Estudiante Estudiante8 = new Estudiante("Sara","TeExtraño","Sarita@Gmail.com","Mañana","Gorina");
        Estudiante Estudiante9 = new Estudiante("Esperanza","hxpe","hxpe@Gmail.com","Mañana","Corrientes");
        Estudiantes.add(Estudiante7);
        Estudiantes.add(Estudiante8);
        Estudiantes.add(Estudiante9);
        this.misEstudiantes = Estudiantes;
        return Estudiantes;
    }

    private void CopiarLista() {
        this.misEstudiantesCopia = this.misEstudiantes;
    }

    private void ModificarEstudiantes() {
        this.misEstudiantes.get(1).setApellido("YaNoTeExtraño");
        this.misEstudiantes.get(2).setApellido("DameUnaOportunidad");
    }

    private void ImprimirListas() {
        System.out.println("Lista original");
        misEstudiantes.forEach(System.out::println);
        System.out.println("----------------------------------");
        System.out.println("Lista copia");
        misEstudiantesCopia.forEach(System.out::println);

    }
}
