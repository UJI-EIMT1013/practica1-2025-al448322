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
        Set<Integer> todos = new HashSet<>(cuadrados);
        Set<Integer> nuevoCuadrados = new HashSet<>();
        Set<Integer> noNuevoCuadrados = new HashSet<>();
        todos.addAll(noCuadrados);  //Uno ambos Set en 1 solo para poder iterarlo luego
        Iterator<Integer> it = todos.iterator();
        boolean esCuadrado = false;
        while (it.hasNext()) {
            int elemento = it.next();
            if (elemento == 1) {
                if (cuadrados.contains(elemento) && noCuadrados.contains(elemento)) {
                    nuevoCuadrados.add(elemento);
                } else {
                    noNuevoCuadrados.add(elemento);
                }
            } else {
                Iterator<Integer> it2 = todos.iterator();
                while (it2.hasNext()) {
                    int elementoNuevo = it2.next();
                    if (elementoNuevo * elementoNuevo == elemento) {
                        esCuadrado = true;
                        break;
                    }
                }
                if (esCuadrado) {
                    nuevoCuadrados.add(elemento);
                } else {
                    noNuevoCuadrados.add(elemento);
                }

            }
        }

        cuadrados.clear();
        cuadrados.addAll(nuevoCuadrados);
        noCuadrados.clear();
        noCuadrados.addAll(noNuevoCuadrados);

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
