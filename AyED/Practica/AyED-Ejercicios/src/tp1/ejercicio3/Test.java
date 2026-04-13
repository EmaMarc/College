package tp1.ejercicio3;


public class Test {
    public static void main(String[] args) {
        Estudiante est1 = new Estudiante("Jhon", "Snow", "1A", "Nieves@gmail.com","Winterfell");
        Estudiante est2 = new Estudiante("Arya", "Stark", "2b", "Needle@gmail.com","Winterfell");

        Estudiante[] estudiantes = new Estudiante[2];
        estudiantes[0] = est1;
        estudiantes[1] = est2;

        Profesor prof1 = new Profesor("Tyrion", "Lannister", "TinyScar@gmail.com","Economics","Casterly Rock");
        Profesor prof2 = new Profesor("Jamie", "Lannister", "TheHand@gmail.com","Swords","Casterly Rock");
        Profesor prof3 = new Profesor("Cersi", "Lannister", "Consorte@gmail.com","Politics","Kingslanding");
        Profesor[] profesores = new Profesor[3];
        profesores[0] = prof1;
        profesores[1] = prof2;
        profesores[2] = prof3;

        System.out.println("=== Estudiantes ===");
        for(int i = 0; i < estudiantes.length; i++){
            System.out.println(estudiantes[i].tusDatos());
        }

        System.out.println("=== Profesores ===");
        for(int i = 0; i < profesores.length; i++){
            System.out.println(profesores[i].tusDatos());
        }
    }
}
