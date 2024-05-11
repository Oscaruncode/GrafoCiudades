
package com.mycompany.grafoibaguebogota;

public class Dijsktra {
     private int[][] adyacente; //Matriz Adyacente:  matriz que representa la matriz de adyacencia del grafo.
    private int rango = 0;
    private int trango = 0;
    private int [] arrNodos; //arreglo que contiene los nodos del grafo
    private int [] arrDistancias; // Arreglo que almacenará las distancias más cortas desde el nodo de origen hasta cada uno de los otros nodos.

    
    public Dijsktra(int paramRango, int[][] paramArreglo) {
        //paramRango: El número de nodos en el grafo. - paramArreglo: Matriz que representa la matriz de adyacencia del grafo
      
        //Funcionalidad: Después de inicializar la matriz de adyacencia, se inicializan los nodos en el arreglo arrNodos y las distancias en el arreglo arrDistancias. Inicialmente, todas las distancias se establecen en las distancias desde el primer nodo (índice 0) a cada uno de los otros nodos.
        //En el arreglo arrNodos, se establece el índice de cada nodo para que coincida con su posición en el arreglo.
        //En el arreglo arrDistancias, se establecen las distancias desde el nodo 0 a cada uno de los otros nodos según los valores en la primera fila de la matriz de adyacencia.
       
        adyacente = new int[paramRango][paramRango];
        arrNodos = new int[paramRango];
        arrDistancias = new int[paramRango];
        rango = paramRango;

        for (int i = 0; i < rango; i++) {
            for (int j = 0; j < rango; j++) {
                adyacente[i][j] = paramArreglo[i][j];
            }
        }

        for (int i = 0; i < rango; i++) {
            arrNodos[i] = i;
        }
        arrNodos[0] = -1;

        for (int i = 1; i < rango; i++) {
            arrDistancias[i] = adyacente[0][i];
        }
    }
    
    public void DijkstraAplicacionAlgoritmo() { // implementa el algoritmo de Dijkstra para calcular las distancias más cortas desde un nodo de origen a todos los demás nodos en un grafo ponderado dirigido
  //El algoritmo selecciona repetidamente el nodo con la distancia más corta no visitada, actualiza las distancias a sus nodos adyacentes y marca el nodo seleccionado como visitado hasta que todos los nodos hayan sido visitados.
   // Inicialización de variables para almacenar el valor mínimo y el nodo asociado
    int minValor = Integer.MAX_VALUE; // Inicializamos el mínimo valor con el máximo valor posible de un entero
    int minNodo = 0; // Inicializamos el nodo asociado al mínimo valor como 0

    // Bucle para encontrar el nodo con la distancia mínima
    for (int i = 0; i < rango; i++) { // Iteramos sobre todos los nodos
        // Si el nodo ya ha sido seleccionado como el más cercano, lo omitimos
        if (arrNodos[i] == -1) { 
            continue;
        }
        // Si la distancia actual es mayor que 0 y menor que el mínimo valor, actualizamos el mínimo valor y el nodo asociado
        if (arrDistancias[i] > 0 && arrDistancias[i] < minValor) {
            minValor = arrDistancias[i];
            minNodo = i;
        }
    }

    // Marcamos el nodo seleccionado como ya visitado
    arrNodos[minNodo] = -1;

    // Bucle para actualizar las distancias a los nodos adyacentes al nodo seleccionado
    for (int i = 0; i < rango; i++) { // Iteramos sobre todos los nodos
        // Si el nodo no es adyacente o ya ha sido visitado, lo omitimos
        if (adyacente[minNodo][i] < 0) {
            continue;
        }
        // Si la distancia al nodo adyacente es negativa, la actualizamos
        if (arrDistancias[i] < 0) {
            arrDistancias[i] = minValor + adyacente[minNodo][i];
            continue;
        }
        // Si la distancia actual más la distancia al nodo adyacente es menor que la distancia almacenada, actualizamos la distancia almacenada
        if ((arrDistancias[minNodo] + adyacente[minNodo][i]) < arrDistancias[i]) {
            arrDistancias[i] = minValor + adyacente[minNodo][i];
        }
    }
}
    
    public void mostrarMatriz() {
    for (trango = 1; trango < rango; trango++) {
        DijkstraAplicacionAlgoritmo();
        System.out.println("Iteración No." + trango);
        System.out.println("Matriz de distancias: ");
        for (int i = 0; i < rango; i++) {
            System.out.print(arrDistancias[i] + " ");
        }
        System.out.println();
        System.out.println();
    }
}
}



/*Explicacion del codigo:
Constructor:

El constructor inicializa la matriz de adyacencia, los arreglos de nodos y distancias, y establece las distancias iniciales desde el nodo de origen a los demás nodos.

Método DijkstraAplicacionAlgoritmo():

Este método implementa el algoritmo de Dijkstra para calcular las distancias más cortas desde un nodo de origen a todos los demás nodos en un grafo ponderado dirigido.

Método mostrarMatriz():

Este método muestra la matriz de distancias después de cada iteración del algoritmo de Dijkstra.*/