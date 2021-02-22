package sorting.divideAndConquer.hybridMergesort;

import sorting.AbstractSorting;
import util.Util;

/**
 * A classe HybridMergeSort representa a implementação de uma variação do
 * MergeSort que pode fazer uso do InsertionSort (um algoritmo híbrido) da
 * seguinte forma: o MergeSort é aplicado a entradas maiores a um determinado
 * limite. Caso a entrada tenha tamanho menor ou igual ao limite o algoritmo usa
 * o InsertionSort.
 * <p>
 * A implementação híbrida deve considerar os seguintes detalhes:
 * - Ter contadores das quantidades de MergeSorts e InsertionSorts aplicados, de forma
 * que essa informação possa ser capturada pelo teste.
 * - A cada chamado do método de sort(T[] array) esses contadores são resetados. E a cada chamada
 * interna de um merge ou insertion, os contadores MERGESORT_APPLICATIONS e
 * INSERTIONSORT_APPLICATIONS são incrementados.
 * - O InsertionSort utilizado no algoritmo híbrido deve ser in-place.
 */
public class HybridMergeSort<T extends Comparable<T>> extends
        AbstractSorting<T> {

    /**
     * For inputs with size less or equal to this value, the insertionsort
     * algorithm will be used instead of the mergesort.
     */
    public static final int SIZE_LIMIT = 4;

    protected static int MERGESORT_APPLICATIONS = 0;
    protected static int INSERTIONSORT_APPLICATIONS = 0;

    @Override
    public void sort(T[] array, int leftIndex, int rightIndex) {
        if (array != null && leftIndex >= 0 && rightIndex >= 0 && leftIndex < rightIndex) {
            INSERTIONSORT_APPLICATIONS = 0;
            MERGESORT_APPLICATIONS = 0;
            if (array.length <= SIZE_LIMIT) {
                insertionSort(array, leftIndex, rightIndex);
                INSERTIONSORT_APPLICATIONS++;
            } else {
                int middleIndex = (leftIndex + rightIndex) / 2;
                sort(array, leftIndex, middleIndex);
                sort(array, middleIndex + 1, rightIndex);
                merge(array, leftIndex, middleIndex, rightIndex);
                MERGESORT_APPLICATIONS++;
            }
        }
    }

    private void insertionSort(T[] array, int leftIndex, int rightIndex) {
        for (int i = leftIndex + 1; i <= rightIndex; i++) {
            int j = i;
            while ((j > 0) && (array[j - 1].compareTo(array[j]) > 0)) {
                Util.swap(array, j, j - 1);
                j--;
            }
        }
    }

    public void merge(T[] array, int leftIndex, int middleIndex, int rightIndex) {
        T[] helper = (T[]) new Comparable[rightIndex + 1];
        for (int i = leftIndex; i <= rightIndex; i++) {
            helper[i] = array[i];
        }

        int i = leftIndex;
        int j = middleIndex + 1;
        int k = leftIndex;

        while (i <= middleIndex && j <= rightIndex) {
            if (helper[i].compareTo(helper[j]) < 0) {
                array[k] = helper[i++];
            } else {
                array[k] = helper[j++];
            }
            k++;
        }

        while (i <= middleIndex) {
            array[k++] = helper[i++];
        }

        while (j <= rightIndex) {
            array[k++] = helper[j++];
        }
    }
}
