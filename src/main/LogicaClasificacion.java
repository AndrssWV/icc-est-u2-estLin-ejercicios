package main;

import java.util.*;

public class LogicaClasificacion {

    /**
     * Invierte una cadena de texto utilizando una pila (Stack).
     *
     * @param texto Cadena original a invertir.
     * @return Cadena invertida.
     *
     *         Ejemplo:
     *         Entrada: "Hola Mundo"
     *         Salida: "odnuM aloH"
     */
    public String invertirCadena(String texto) {
        Stack<Character> arr = new Stack<>();
        for (char c : texto.toCharArray()) arr.push(c);
        String s = "";
        while (!arr.isEmpty()) s += arr.pop();
        return s;
    }

    /**
     * Verifica si los símbolos de paréntesis, corchetes y llaves están bien
     * balanceados.
     *
     * @param expresion Cadena con símbolos.
     * @return true si está balanceada, false en caso contrario.
     *
     *         Ejemplo:
     *         Entrada: "{[()]}"
     *         Salida: true
     */
    public boolean validarSimbolos(String expresion) {
        Stack<Character> arr = new Stack<>();
        for (char c : expresion.toCharArray()) {
            if (c=='[' || c=='{' || c=='(') arr.push(c);
            else if ((c==']' && arr.pop()!='[') || (c=='}' && arr.pop()!='{') || (c==')' && arr.pop()!='(')) return false;
        }
        return arr.isEmpty();
    }

    /**
     * Ordena una pila de enteros en orden ascendente usando otra pila auxiliar.
     *
     * @return Lista ordenada.
     *
     *         Ejemplo:
     *         Entrada: [3, 1, 4, 2]
     *         Salida: [1, 2, 3, 4]
     */
    public List<Integer> ordenarPila(Stack<Integer> pila) {
        Stack<Integer> aux = new Stack<>();
        while (!pila.isEmpty()) {
            int temp = pila.pop();
            while (!aux.isEmpty() && aux.peek() < temp) pila.push(aux.pop());
            aux.push(temp);
        }
        while (!aux.isEmpty()) pila.push(aux.pop());
        return new ArrayList<>(pila);
    }

    /**
     * Clasifica una lista de enteros separando pares e impares.
     * Usa LinkedList para mantener el orden de inserción.
     *
     * @return Lista con pares primero, luego impares.
     *
     *         Ejemplo:
     *         Entrada: [1, 2, 3, 4, 5, 6]
     *         Salida: [2, 4, 6, 1, 3, 5]
     */
    public List<Integer> clasificarPorParidad(LinkedList<Integer> original) {
        List<Integer> r = new ArrayList<>();
        List<Integer> p = new ArrayList<>();
        List<Integer> ip = new ArrayList<>();
        for (int i : original) {
            if (i % 2 == 0) p.add(i);
            else ip.add(i);
        }
        r.addAll(p);
        r.addAll(ip);
        return r;
    }
}
