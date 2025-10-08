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
                if (i != j) {
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
        //TODO

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
