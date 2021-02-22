package sorting.divideAndConquer.quicksort3;

import sorting.AbstractSorting;
import util.Util;

import java.util.Arrays;

/**
 * A classe QuickSortMedianOfThree representa uma variação do QuickSort que
 * funciona de forma ligeiramente diferente. Relembre que quando o pivô
 * escolhido divide o array aproximadamente na metade, o QuickSort tem um
 * desempenho perto do ótimo. Para aproximar a entrada do caso ótimo, diversas
 * abordagens podem ser utilizadas. Uma delas é usar a mediana de 3 para achar o
 * pivô. Essa técnica consiste no seguinte:
 * 1. Comparar o elemento mais a esquerda, o central e o mais a direita do intervalo.
 * 2. Ordenar os elementos, tal que: A[left] < A[center] < A[right].
 * 3. Adotar o A[center] como pivô.
 * 4. Colocar o pivô na penúltima posição A[right-1].
 * 5. Aplicar o particionamento considerando o vetor menor, de A[left+1] até A[right-1].
 * 6. Aplicar o algoritmo na particao a esquerda e na particao a direita do pivô.
 */
public class QuickSortMedianOfThree<T extends Comparable<T>> extends
        AbstractSorting<T> {

    public void sort(T[] array, int leftIndex, int rightIndex) {
        if (array != null && leftIndex >= 0 && rightIndex >= 0 && leftIndex <= rightIndex) {
            if (leftIndex < rightIndex) {
                int pivot = partition(array, leftIndex, rightIndex);
                sort(array, leftIndex, pivot - 1);
                sort(array, pivot + 1, rightIndex);
            }
        }
    }

    private int partition(T[] array, int leftIndex, int rightIndex) {
        int pivot_median = pickPivotIndex(array, leftIndex, rightIndex);
        Util.swap(array, leftIndex, pivot_median);

        T pivot = array[leftIndex];
        int i = leftIndex;

        for (int j = leftIndex + 1; j <= rightIndex; j++) {
            if (array[j].compareTo(pivot) <= 0) {
                i++;
                Util.swap(array, i, j);
            }
        }
        Util.swap(array, leftIndex, i);
        return i;
    }

    public int pickPivotIndex(T[] values, int left, int right) {
        int mid = (left + right) / 2;

        T[] sorted = (T[]) new Comparable[]{values[left], values[mid], values[right]};
        Arrays.sort(sorted);

        if (sorted[1] == values[left]) return left;
        else if (sorted[1] == values[mid]) return mid;
        else return right;
    }
}