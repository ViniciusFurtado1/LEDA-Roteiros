package orderStatistic;

import org.junit.jupiter.api.*;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class KLargestOrderStatisticsImplTest {
    private KLargestOrderStatisticsImpl<Integer> orderStatistic;
    private Integer[] array1;
    private Integer[] array2;

    @BeforeEach
    public void setUp() {
        this.orderStatistic = new KLargestOrderStatisticsImpl<>();
        this.array1 = new Integer[]{4, 6, 8, 10};
        this.array2 = new Integer[]{};
    }

    @Test
    public void test1() {
        assertEquals(Arrays.toString(new Integer[]{10}), Arrays.toString(orderStatistic.getKLargest(array1, 1)));
    }

    @Test
    public void test2() {
        assertEquals(Arrays.toString(new Integer[]{10, 8}), Arrays.toString(orderStatistic.getKLargest(array1, 2)));
    }

    @Test
    public void test3() {
        assertEquals(Arrays.toString(new Integer[]{10, 8, 6}), Arrays.toString(orderStatistic.getKLargest(array1, 3)));
    }

    @Test
    public void test4() {
        assertEquals(Arrays.toString(new Integer[]{10, 8, 6, 4}), Arrays.toString(orderStatistic.getKLargest(array1, 4)));
    }

    @Test
    public void test5() {
        assertNull(orderStatistic.getKLargest(array1, 5));
    }

    @Test
    public void test6() {
        assertNull(orderStatistic.getKLargest(array2, 1));
    }
}