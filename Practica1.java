package practica1;

import java.util.*;

public class Practica1 {

    //EJERCICIO 1
    public static Set<Integer> multiplos(Iterator<Integer> it) {
        List<Integer> numeros = new ArrayList<>();
        //Guardamos los numeros en una lista, ignorando los ceros
        while (it.hasNext()) {
            int n = it.next();
            if (n != 0) {
                numeros.add(n);
            }
        }

        Set<Integer> resultado = new HashSet<>();
        for (int i = 0; i < numeros.size(); i++) {
            int a = numeros.get(i);
            for (int j = 0; j < numeros.size(); j++) {
                if (i != j) { //Compruebo si NO es el mismo indice, ya que comparar el mismo numero consigo mismo seria siempre 0
                    int b = numeros.get(j);
                    if (a % b == 0) {
                        resultado.add(a);
                        break;
                    }
                }
            }
        }
        return resultado;
    }

    //EJERCICIO2
    public static void separate(Set<Integer> cuadrados, Set<Integer> noCuadrados) {
        Set<Integer> union = new HashSet<>(cuadrados);
        union.addAll(noCuadrados);  //Uno ambos Set en 1 solo para poder iterarlo luego

        Set<Integer> nCuadrados = new HashSet<>();
        for (Integer n : union) {
            nCuadrados.add(n * n);  //Guardo n^n en el nuevo set
        }

        cuadrados.retainAll(nCuadrados);    //
        noCuadrados.removeAll(nCuadrados);

    }

    //EJERCICIO 3
    public static <T> Collection<Set<T>> divideInSets(Iterator<T> it) {
        //TODO
        return null;
    }

    //EJERCICIO 4
    public static <T> Collection<Set<T>> coverageSet2(Set<T> u, ArrayList<Set<T>> col) {
        //TODO
        return null;
    }


}
