package problems;

public class FloorBinarySearchImpl implements Floor {

    @Override
    public Integer floor(Integer[] array, Integer x) {
        return floor(array, x, 0, array.length - 1);
    }

    private Integer floor(Integer[] array, Integer x, int ini, int fim) {
        int middle = (ini + fim) / 2;
        Integer result;
        if (ini > fim) {
            if (fim < 0) {
                result = null;
            } else {
                result = array[fim];
            }
        } else if (array[middle].equals(x)) {
            result = x;
        } else if (x < array[middle]) {
            result = floor(array, x, ini, middle - 1);
        } else {
            result = floor(array, x, middle + 1, fim);
        }
        return result;
    }
}