import java.util.Scanner;

public class Main {

    static class Cita {
        String documento;
        String nombre;
        int edad;
        double valorPago;
        String horaCita;
        String sexo;

        public Cita(String documento, String nombre, int edad, double valorPago, String horaCita, String sexo) {
            this.documento = documento;
            this.nombre = nombre;
            this.edad = edad;
            this.valorPago = valorPago;
            this.horaCita = horaCita;
            this.sexo = sexo;
        }
    }

    static class AgendaCitas {
        private static Cita[] citas = new Cita[100]; // Arreglo para almacenar las citas
        private static int contador = 0; // Contador de citas

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int opcion;

            do {
                System.out.println("1. Registrar cita");
                System.out.println("2. Modificar cita");
                System.out.println("3. Consultar cita");
                System.out.println("4. Eliminar cita");
                System.out.println("5. Imprimir agenda");
                System.out.println("6. Salir");
                System.out.print("Seleccione una opción: ");
                opcion = scanner.nextInt();
                scanner.nextLine(); // Limpiar el buffer

                switch (opcion) {
                    case 1:
                        registrarCita(scanner);
                        break;
                    case 2:
                        modificarCita(scanner);
                        break;
                    case 3:
                        consultarCita(scanner);
                        break;
                    case 4:
                        eliminarCita(scanner);
                        break;
                    case 5:
                        imprimirAgenda();
                        break;
                    case 6:
                        System.out.println("Saliendo del programa.");
                        break;
                    default:
                        System.out.println("Opción no válida.");
                }
            } while (opcion != 6);
            scanner.close();
        }

        private static void registrarCita(Scanner scanner) {
            System.out.print("Número del documento de identidad: ");
            String documento = scanner.nextLine();
            System.out.print("Nombre del usuario: ");
            String nombre = scanner.nextLine();
            System.out.print("Edad: ");
            int edad = scanner.nextInt();
            System.out.print("Valor del pago: ");
            double valorPago = scanner.nextDouble();
            System.out.print("Hora de la cita (formato 24h, ejemplo: 14:30): ");
            String horaCita = scanner.next();
            scanner.nextLine(); // Limpiar buffer
            System.out.print("Sexo (M para masculino, F para femenino): ");
            String sexo = scanner.nextLine().toUpperCase();

            citas[contador++] = new Cita(documento, nombre, edad, valorPago, horaCita, sexo);
            System.out.println("Cita registrada con éxito.");
        }

        private static void modificarCita(Scanner scanner) {
            System.out.print("Número del documento de identidad de la cita a modificar: ");
            String documento = scanner.nextLine();
            for (int i = 0; i < contador; i++) {
                if (citas[i].documento.equals(documento)) {
                    System.out.print("Nuevo nombre: ");
                    citas[i].nombre = scanner.nextLine();
                    System.out.print("Nueva edad: ");
                    citas[i].edad = scanner.nextInt();
                    System.out.print("Nuevo valor de pago: ");
                    citas[i].valorPago = scanner.nextDouble();
                    System.out.print("Nueva hora de la cita: ");
                    citas[i].horaCita = scanner.next();
                    scanner.nextLine(); // Limpiar buffer
                    System.out.print("Nuevo sexo (M para masculino, F para femenino): ");
                    citas[i].sexo = scanner.nextLine().toUpperCase();
                    System.out.println("Cita modificada con éxito.");
                    return;
                }
            }
            System.out.println("Cita no encontrada.");
        }

        private static void consultarCita(Scanner scanner) {
            System.out.print("Número del documento de identidad: ");
            String documento = scanner.nextLine();
            for (Cita cita : citas) {
                if (cita != null && cita.documento.equals(documento)) {
                    System.out.println("Cita encontrada: " + cita.nombre + ", Edad: " + cita.edad +
                            ", Valor: " + cita.valorPago + ", Hora: " + cita.horaCita + ", Sexo: " + cita.sexo);
                    return;
                }
            }
            System.out.println("Cita no encontrada.");
        }

        private static void eliminarCita(Scanner scanner) {
            System.out.print("Número del documento de identidad de la cita a eliminar: ");
            String documento = scanner.nextLine();
            for (int i = 0; i < contador; i++) {
                if (citas[i].documento.equals(documento)) {
                    for (int j = i; j < contador - 1; j++) {
                        citas[j] = citas[j + 1]; // Desplazar las citas
                    }
                    citas[--contador] = null;
                    System.out.println("Cita eliminada con éxito.");
                    return;
                }
            }
            System.out.println("Cita no encontrada.");
        }

        private static void imprimirAgenda() {
            if (contador == 0) {
                System.out.println("No hay citas registradas.");
                return;
            }

            // Ordenar las citas usando el método de burbuja (Bubble Sort)
            for (int i = 0; i < contador - 1; i++) {
                for (int j = 0; j < contador - i - 1; j++) {
                    if (citas[j].horaCita.compareTo(citas[j + 1].horaCita) > 0) {
                        // Intercambiar citas[j] con citas[j + 1]
                        Cita temp = citas[j];
                        citas[j] = citas[j + 1];
                        citas[j + 1] = temp;
                    }
                }
            }

            System.out.println("Agenda de citas:");
            int menores = 0;
            int terceraEdad = 0;
            int hombres = 0;
            int mujeres = 0;

            for (int i = 0; i < contador; i++) {
                if (citas[i] != null) {
                    System.out.println("Documento: " + citas[i].documento +
                            ", Nombre: " + citas[i].nombre +
                            ", Edad: " + citas[i].edad +
                            ", Valor: " + citas[i].valorPago +
                            ", Hora: " + citas[i].horaCita +
                            ", Sexo: " + citas[i].sexo);

                    // Contar estadísticas
                    if (citas[i].edad < 18) {
                        menores++;
                    } else if (citas[i].edad >= 65) {
                        terceraEdad++;
                    }

                    // Contar hombres y mujeres basado en el sexo ingresado
                    if (citas[i].sexo.equals("M")) {
                        hombres++;
                    } else if (citas[i].sexo.equals("F")) {
                        mujeres++;
                    }
                }
            }

            System.out.println("Total de pacientes menores de edad: " + menores);
            System.out.println("Total de pacientes de la tercera edad: " + terceraEdad);
            System.out.println("Total de hombres: " + hombres);
            System.out.println("Total de mujeres: " + mujeres);
        }
    }
}
