import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("------bienvenido al estacionamiento------");
        String placa="";
        int servicio,cont1=0,cont2=0, cont3=0;
        double totalDia = 0;
        System.out.println("ingrese la placa del veiculo, si quiere salir  escriba fin");
        placa= sc.nextLine();
while (!placa.equalsIgnoreCase("fin")){
    System.out.println("ingresa el tipo de servicio");
    System.out.println("1--> por hora");
    System.out.println("2--> por media jornada (5 horas)");
    System.out.println("3--> por jorndad completa (10 horas)");
    sc  =new Scanner(System.in);
    servicio= sc.nextInt();

    switch (servicio) {
        case 1:
            totalDia += pagoHora(sc);
            cont1++;
            break;
        case 2:
            totalDia += pagoMedia();
            cont2++;
            break;
        case 3:
            totalDia += pagoCompleta();
            cont3++;
            break;
        default:
            System.out.println("No existe esa opción.");
    }
    sc.nextLine();
    System.out.println("ingrese la placa del veiculo, si quiere salir  escriba fin");
    placa= sc.nextLine();
}
        System.out.println("Total por hora: " + cont1);
        System.out.println("Total media jornada: " + cont2);
        System.out.println("Total jornada completa: " + cont3);
        System.out.println("Total recaudado: $" + totalDia + " USD");

    }

    public static double pagoHora(Scanner sc) {
        int horas;
        System.out.println("Ingrese la cantidad de horas que estuvo:");
        horas = sc.nextInt();
        double total = horas * 3.0;
        System.out.println("Total a pagar: $" + total + " USD");
        return total;
    }

    public static double pagoMedia() {
        double total = 15 - (15 * 0.05);
        System.out.println("Su pago es de $15, pero con el descuento del 5% es: $" + total + " USD");
        return total;
    }

    public static double pagoCompleta() {
        double total = 30 - (30 * 0.10);
        System.out.println("Su pago es de $30, pero con el descuento del 10% es: $" + total + " USD");
        return total;
    }
}