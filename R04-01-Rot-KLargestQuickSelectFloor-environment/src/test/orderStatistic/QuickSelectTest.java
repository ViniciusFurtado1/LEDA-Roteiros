package orderStatistic;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class QuickSelectTest {
    private QuickSelect<Integer> quickSelect;
    private Integer[] array1;
    private Integer[] array2;

    @BeforeEach
    void setUp() {
        this.quickSelect = new QuickSelect<>();
        this.array1 = new Integer[]{4, 6, 8, 10};
        this.array2 = new Integer[]{};
    }

    @Test
    public void test1() {
        assertEquals(4, quickSelect.quickSelect(array1, 1));
    }

    @Test
    public void test2() {
        assertEquals(6, quickSelect.quickSelect(array1, 2));
    }

    @Test
    public void test3() {
        assertEquals(8, quickSelect.quickSelect(array1, 3));
    }

    @Test
    public void test4() {
        assertEquals(10, quickSelect.quickSelect(array1, 4));
    }

    @Test
    public void test5() {
        assertNull(quickSelect.quickSelect(array1, 5));
    }

    @Test
    public void test6() {
        assertNull(quickSelect.quickSelect(array2, 1));
    }
}