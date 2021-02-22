package sorting.divideAndConquer;

import sorting.AbstractSorting;

/**
 * Merge sort is based on the divide-and-conquer paradigm. The algorithm
 * consists of recursively dividing the unsorted list in the middle, sorting
 * each sublist, and then merging them into one single sorted list. Notice that
 * if the list has length == 1, it is already sorted.
 */
public class MergeSort<T extends Comparable<T>> extends AbstractSorting<T> {

    @Override
    public void sort(T[] array, int leftIndex, int rightIndex) {
        if (array != null && leftIndex >= 0 && rightIndex >= 0 && leftIndex <= rightIndex) {
            if (leftIndex < rightIndex) {
                int middleIndex = (leftIndex + rightIndex) / 2;
                sort(array, leftIndex, middleIndex);
                sort(array, middleIndex + 1, rightIndex);
                merge(array, leftIndex, middleIndex, rightIndex);
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