package sorting.linearSorting;

import sorting.AbstractSorting;

import java.util.Arrays;

/**
 * Classe que implementa a estratégia de Counting Sort vista em sala. Procure
 * evitar desperdicio de memoria alocando o array de contadores com o tamanho
 * sendo o máximo inteiro presente no array a ser ordenado.
 * <p>
 * Voce pode assumir que o maior inteiro armazenado não chega a 100.
 */
public class CountingSort extends AbstractSorting<Integer> {

    @Override
    public void sort(Integer[] array, int leftIndex, int rightIndex) {
        if (array != null && array.length != 0 && leftIndex < rightIndex && leftIndex >= 0 && rightIndex < array.length) {
            int maior = array[leftIndex];
            for (int i = leftIndex; i <= rightIndex; i++) {
                if (array[i] > maior) {
                    maior = array[i];
                }
            }

            Integer[] arrayAux = new Integer[maior + 1];

            Arrays.fill(arrayAux, 0);

            for (int i = 0; i <= rightIndex; i++) {
                arrayAux[array[i]]++;
            }

            for (int i = 1; i < arrayAux.length; i++) {
                arrayAux[i] += arrayAux[i - 1];
            }

            Integer[] arrayOrd = new Integer[array.length];

            for (int i = rightIndex; i >= 0; i--) {
                arrayOrd[arrayAux[array[i]] - 1] = array[i];
                arrayAux[array[i]] --;
            }

            for (int i = 0; i < array.length; i++) {
                array[i] = arrayOrd[i];
            }
        }
    }
}