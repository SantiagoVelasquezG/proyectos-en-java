
import java.util.Scanner;



public class MainBulceFor {
    private static int numero;
    public static void main(String[] args) {
        int contador = 0;
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("----bienvenido a prueba for----");
            System.out.println("1. pedir y contar ");
            System.out.println("2. contador ");
            System.out.println("3. contador 2 en desde 200 hasta 250");
            System.out.println("4. contador nuevo año");
            System.out.println("5. imprimir hasta que la palabra sea salir ");
            System.out.println("6. salir");

            System.out.print("Elige una opción: ");
            contador = sc.nextInt();
            sc.nextLine();

            switch (contador) {
                case 1:
                    pedirYContar();
                    break;
                case 2:
                    contador();
                    break;
                case 3:
                    conatdor2En2();
                    break;
                case 4:
                    NewYear();
                    break;
                case 5:
                    MostrarHastaSalir();
                    break;
                case 6:
                    System.out.println("Saliendo");
                    return;
                default:
                    System.out.println("No existe esa opción.");
            }
        }
    }

    public static void pedirYContar() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese número límite:");
        numero = sc.nextInt();

        for (int i = 0; i < numero; i++) {
            System.out.println(i+1);
        }

    }
    public static void contador (){
        for (int contador = 0; contador < 10; contador++) {
            System.out.println("Estoy en la vuelta " + (contador + 1));
        }

    }
    private static void conatdor2En2 (){
        // Contador de 200 a 250 de 2 en 2
        for (int i = 200; i <= 250; i = i + 2) {
            System.out.println("Vuelta " + i);
        }
    }
    public static  void NewYear (){
        System.out.println("cuenta nuevo año");

        for (int cuenta = 10; cuenta>=1; cuenta = cuenta - 1){

            System.out.println("el año se acaba en "+ cuenta);
        }
    }
public  static void MostrarHastaSalir (){
    boolean palabra = true;
    String respuesta;
    Scanner sc = new Scanner(System.in);
    while (palabra == true){
        System.out.println(" muestro las palabras hasta que quieras salir ");
        respuesta = sc.nextLine();
        System.out.println(respuesta);
        if( respuesta.equalsIgnoreCase("salir")){
            palabra =false;
            System.out.println("saliste ");
        }
    }
}
    }






