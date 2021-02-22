package problems;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class FloorBinarySearchImplTest {

    private FloorBinarySearchImpl binarySearch;
    private Integer[] array;

    @BeforeEach
    public void setUp() {
        this.binarySearch = new FloorBinarySearchImpl();
        this.array = new Integer[]{4, 6, 8, 10};
    }

    @Test
    public void test1() {
        assertEquals(4, (int) binarySearch.floor(array, 5));
    }

    @Test
    public void test2() {
        assertEquals(6, (int) binarySearch.floor(array, 7));
    }

    @Test
    public void test3() {
        assertEquals(8, (int) binarySearch.floor(array, 9));
    }

    @Test
    public void test4() {
        assertEquals(10, (int) binarySearch.floor(array, 11));
    }

    @Test
    public void test5() {
        assertEquals(4, (int) binarySearch.floor(array, 4));
    }

    @Test
    public void test6() {
        assertEquals(6, (int) binarySearch.floor(array, 6));
    }

    @Test
    public void test7() {
        assertEquals(8, (int) binarySearch.floor(array, 8));
    }

    @Test
    public void test8() {
        assertEquals(10, (int) binarySearch.floor(array, 10));
    }
}