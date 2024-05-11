
package com.mycompany.grafoibaguebogota;

public class GrafoIbagueBogota {
    
  

    
    public static void main(String[] args) {
 
      
        int[][] adyacente = {
    {-1, 5, -1, 1},
    {-1, -1, 2, -1},
    {-1, -1, -1, -1},
    {-1, -1, -1, -1}
};
        Dijsktra dijkstra = new Dijsktra((int) Math.sqrt(adyacente.length), adyacente);
        dijkstra.mostrarMatriz();

        System.out.println("La solución más corta tomando como nodo inicial el Nodo 1 es:");
        int nodo = 1;
        for (int i : dijkstra.arrDistancias) {
            System.out.println("Distancia mínima a nodo " + nodo + " es: " + i);
            nodo++;
        }
        System.out.println();
    
  
    }
}
