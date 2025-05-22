import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArbolBinario arbol = new ArbolBinario();
        int opcion;

        do {
            System.out.println("Menú:");
            System.out.println("1. Agregar nodo");
            System.out.println("2. Recorrido PreOrden");
            System.out.println("3. Recorrido InOrden");
            System.out.println("4. Recorrido PostOrden");
            System.out.println("5. Buscar nodo");
            System.out.println("6. Mostrar altura del árbol");
            System.out.println("7. Contar nodos hoja");
            System.out.println("8. Borrar nodo");
            System.out.println("9. Vaciar árbol");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el valor del nodo: ");
                    int valor = scanner.nextInt();
                    arbol.agregar(valor);
                    break;
                case 2:
                    System.out.println("Recorrido PreOrden:");
                    arbol.recorridoPreOrden();
                    System.out.println();
                    break;
                case 3:
                    System.out.println("Recorrido InOrden:");
                    arbol.recorridoInOrden();
                    System.out.println();
                    break;
                case 4:
                    System.out.println("Recorrido PostOrden:");
                    arbol.recorridoPostOrden();
                    System.out.println();
                    break;
                case 5:
                    System.out.print("Ingrese el valor a buscar: ");
                    int buscarValor = scanner.nextInt();
                    System.out.println("El nodo " + (arbol.buscar(buscarValor) ? "existe" : "no existe") + " en el árbol.");
                    break;
                case 6:
                    System.out.println("Altura del árbol: " + arbol.altura());
                    break;
                case 7:
                    System.out.println("Nodos hoja: " + arbol.contarNodosHoja());
                    break;
                case 8:
                    System.out.print("Ingrese el valor del nodo a borrar: ");
                    int borrarValor = scanner.nextInt();
                    arbol.borrar(borrarValor);
                    break;
                case 9:
                    arbol.vaciar();
                    System.out.println("Árbol vaciado.");
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 0);

        scanner.close();
    }
}
