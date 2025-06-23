package Practica1.Ejercicio3;

import java.util.ArrayList;
import java.util.List;

public class MainEj3 {
    public static void main(String[] args) {

        List<Estudiante> ArrayEstudiantes = new ArrayList<>();
        Estudiante Estudiante1 = new Estudiante("Emma", "Marc","Emma.Marc@Gmail.com","Mañana","13 y 72");
        Estudiante Estudiante2 = new Estudiante("Sara","TeExtraño","Sarita@Gmail.com","Mañana","Gorina");
        ArrayEstudiantes.add(Estudiante1);
        ArrayEstudiantes.add(Estudiante2);
        List<Profesor> ArrayProfesores = new ArrayList<>();
        Profesor Profesor1 = new Profesor("Pedro","Picapiedra","PedritoPica@Gmail.com","Picapiedrismo I y II", "Ciencias Antiguas");
        Profesor Profesor2 = new Profesor("Timmy","Turner","TimmyMagico@Gmail.com","Deseos Responsable I,II y III","Filosofia");
        Profesor Profesor3 = new Profesor("Phineas","Flynn","PhineasFlynn@Gmail.com","Ingenieria y Construccion", "Ingenieria");
        ArrayProfesores.add(Profesor1);
        ArrayProfesores.add(Profesor2);
        ArrayProfesores.add(Profesor3);
        System.out.println("Estudiantes:");
        for (Estudiante e : ArrayEstudiantes){
            System.out.println(e.tusDatos());
        }
        System.out.println("------------------------------------------------------------------");
        for (Profesor p : ArrayProfesores){
            System.out.println(p.tusDatos());
        }
    }
}