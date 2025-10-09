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
        Collection<Set<T>> res = new ArrayList<>();
        while (it.hasNext()) {
            T elemento = it.next();
            boolean colocado = false;

            for (Set<T> conjunto : res) {
                if (!conjunto.contains(elemento)) { //Si el conjunto iterado de res No contiene el elemento del Iterador (es decir de la Collection que pasa por argumento), lo añado ha dicho conjunto
                    conjunto.add(elemento);
                    colocado = true;
                    break;  //Aqui ya he añadido x elemento al conjunto
                }
            }

            if (!colocado) {    //Si el elemento no se ha podido añadir (porque esta repetido por ejemplo), se crea un nuevo HashSet donde se añade dicho elemento, y se añade dicho HashSet a res
                Set<T> aux = new HashSet<>();
                aux.add(elemento);
                res.add(aux);
            }

        }

        return res;
    }

    //EJERCICIO 4
    public static <T> Collection<Set<T>> coverageSet2(Set<T> u, ArrayList<Set<T>> col) {
        Collection<Set<T>> res = new HashSet<>();
        for (int i = 0; i < col.size(); i++) {
            Set<T> conjunto1 = col.get(i);

            if (!u.equals(conjunto1)) {     //Si el contenido de u NO es igual al del conjunto1 de col
                for (int j = i + 1; j < col.size(); j++) {      //Inicio con el siguiente
                    Set<T> conjunto2 = col.get(j);

                    if (!u.equals(conjunto2)) {     //Si el contenido de u NO es igual al del conjunto2 de col
                        Set<T> union = new HashSet<>(conjunto1);
                        union.addAll(conjunto2);    //Uno ambos conjuntos

                        if (union.equals(u)) {  //Si union es igual a u, añado a res el conjunto1 y conjunto2
                            res.add(conjunto1);
                            res.add(conjunto2);
                            return res;
                        }
                    }
                }
            }
        }

        return res;
    }


}
