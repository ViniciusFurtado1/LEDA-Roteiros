package sorting.linearSorting;

import sorting.AbstractSorting;

import java.util.Arrays;

/**
 * Classe que implementa do Counting Sort vista em sala. Desta vez este
 * algoritmo deve satisfazer os seguitnes requisitos:
 * - Alocar o tamanho minimo possivel para o array de contadores (C)
 * - Ser capaz de ordenar arrays contendo numeros negativos
 */
public class ExtendedCountingSort extends AbstractSorting<Integer> {

    @Override
    public void sort(Integer[] array, int leftIndex, int rightIndex) {
        if (array != null && array.length != 0 && leftIndex < rightIndex && leftIndex >= 0 && rightIndex < array.length) {
            int maior = array[leftIndex];
            for (int i = leftIndex; i <= rightIndex; i++) {
                if (array[i] > maior) {
                    maior = array[i];
                }
            }
            int menor = array[leftIndex];
            for (int i = leftIndex; i <= rightIndex; i++) {
                if (array[i] < menor) {
                    menor = array[i];
                }
            }

            Integer[] arrayAux = new Integer[maior - menor + 1];

            Arrays.fill(arrayAux, 0);

            for (int i = leftIndex; i <= rightIndex; i++) {
                arrayAux[array[i] - menor]++;
            }

            for (int i = 1; i < arrayAux.length; i++) {
                arrayAux[i] += arrayAux[i - 1];
            }

            Integer[] arrayOrd = new Integer[array.length];

            for (int i = rightIndex; i >= leftIndex; i--) {
                arrayOrd[arrayAux[array[i] - menor] - 1] = array[i];
                arrayAux[array[i] - menor]--;
            }

            for (int i = leftIndex; i <= rightIndex; i++) {
                array[i] = arrayOrd[i - leftIndex];
            }
        }
    }
}