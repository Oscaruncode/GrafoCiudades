
package com.mycompany.grafoibaguebogota;

public class GrafoIbagueBogota {
    
    private int[][] adyacente; //Matriz Adyacente:  matriz que representa la matriz de adyacencia del grafo.
    private int rango = 0;
    private int trango = 0;
    private int [] arrNodos; //arreglo que contiene los nodos del grafo
    private int [] arrDistancias; // Arreglo que almacenará las distancias más cortas desde el nodo de origen hasta cada uno de los otros nodos.

    //Convertir el siguiente metodo en constructor para incializar la matriz.
    public void Dijkstra(int paramRango, int[][] paramArreglo) {
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
    
    public void DijkstraAplicacionAlgoritmo() {
    int minValor = Integer.MAX_VALUE;
    int minNodo = 0;

    for (int i = 0; i < rango; i++) {
        if (arrNodos[i] == -1) {
            continue;
        }
        if (arrDistancias[i] > 0 && arrDistancias[i] < minValor) {
            minValor = arrDistancias[i];
            minNodo = i;
        }
    }

    arrNodos[minNodo] = -1;

    for (int i = 0; i < rango; i++) {
        if (adyacente[minNodo][i] < 0) {
            continue;
        }
        if (arrDistancias[i] < 0) {
            arrDistancias[i] = minValor + adyacente[minNodo][i];
            continue;
        }
        if ((arrDistancias[minNodo] + adyacente[minNodo][i]) < arrDistancias[i]) {
            arrDistancias[i] = minValor + adyacente[minNodo][i];
        }
    }
}

    public static void main(String[] args) {
 
       

        
        
    }
}
