public class ArbolBinario {
    private Nodo raiz;

    public ArbolBinario() {
        this.raiz = null;
    }

    // Método para agregar nodos
    public void agregar(int valor) {
        raiz = agregarRecursivo(raiz, valor);
    }

    private Nodo agregarRecursivo(Nodo nodo, int valor) {
        if (nodo == null) {
            return new Nodo(valor);
        }
        if (valor < nodo.valor) {
            nodo.izquierda = agregarRecursivo(nodo.izquierda, valor);
        } else if (valor > nodo.valor) {
            nodo.derecha = agregarRecursivo(nodo.derecha, valor);
        }
        return nodo;
    }
    

    // Recorrido PreOrden
    public void recorridoPreOrden() {
        recorridoPreOrdenRecursivo(raiz);
    }

    private void recorridoPreOrdenRecursivo(Nodo nodo) {
        if (nodo != null) {
            System.out.print(nodo.valor + " ");
            recorridoPreOrdenRecursivo(nodo.izquierda);
            recorridoPreOrdenRecursivo(nodo.derecha);
        }
    }

    // Recorrido InOrden
    public void recorridoInOrden() {
        recorridoInOrdenRecursivo(raiz);
    }

    private void recorridoInOrdenRecursivo(Nodo nodo) {
        if (nodo != null) {
            recorridoInOrdenRecursivo(nodo.izquierda);
            System.out.print(nodo.valor + " ");
            recorridoInOrdenRecursivo(nodo.derecha);
        }
    }

    // Recorrido PostOrden
    public void recorridoPostOrden() {
        recorridoPostOrdenRecursivo(raiz);
    }

    private void recorridoPostOrdenRecursivo(Nodo nodo) {
        if (nodo != null) {
            recorridoPostOrdenRecursivo(nodo.izquierda);
            recorridoPostOrdenRecursivo(nodo.derecha);
            System.out.print(nodo.valor + " ");
        }
    }

    // Buscar un nodo
    public boolean buscar(int valor) {
        return buscarRecursivo(raiz, valor);
    }

    private boolean buscarRecursivo(Nodo nodo, int valor) {
        if (nodo == null) {
            return false;
        }
        if (nodo.valor == valor) {
            return true;
        }
        return valor < nodo.valor ? buscarRecursivo(nodo.izquierda, valor) : buscarRecursivo(nodo.derecha, valor);
    }

    // Calcular altura del árbol
    public int altura() {
        return calcularAltura(raiz);
    }

    private int calcularAltura(Nodo nodo) {
        if (nodo == null) {
            return -1; // Altura de un árbol vacío
        }
        int alturaIzquierda = calcularAltura(nodo.izquierda);
        int alturaDerecha = calcularAltura(nodo.derecha);
        return Math.max(alturaIzquierda, alturaDerecha) + 1;
    }

    // Contar nodos hoja
    public int contarNodosHoja() {
        return contarHojasRecursivo(raiz);
    }

    private int contarHojasRecursivo(Nodo nodo) {
        if (nodo == null) {
            return 0;
        }
        if (nodo.izquierda == null && nodo.derecha == null) {
            return 1;
        }
        return contarHojasRecursivo(nodo.izquierda) + contarHojasRecursivo(nodo.derecha);
    }

    // Borrar un nodo
    public void borrar(int valor) {
        raiz = borrarRecursivo(raiz, valor);
    }

    private Nodo borrarRecursivo(Nodo nodo, int valor) {
        if (nodo == null) {
            return null;
        }
        if (valor < nodo.valor) {
            nodo.izquierda = borrarRecursivo(nodo.izquierda, valor);
        } else if (valor > nodo.valor) {
            nodo.derecha = borrarRecursivo(nodo.derecha, valor);
        } else {
            // Nodo encontrado
            if (nodo.izquierda == null) {
                return nodo.derecha;
            } else if (nodo.derecha == null) {
                return nodo.izquierda;
            }
            // Nodo con dos hijos
            nodo.valor = encontrarMinimo(nodo.derecha);
            nodo.derecha = borrarRecursivo(nodo.derecha, nodo.valor);
        }
        return nodo;
    }

    private int encontrarMinimo(Nodo nodo) {
        return nodo.izquierda == null ? nodo.valor : encontrarMinimo(nodo.izquierda);
    }

    // Vaciar el árbol
    public void vaciar() {
        raiz = null;
    }
}
