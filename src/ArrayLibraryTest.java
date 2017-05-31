import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayLibraryTest {

    private ArrayLibrary arrayLib = new ArrayLibrary();

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    /*Max Value*/
    @Test
    void ShouldReturnMaximumValueForNonEmptyArray() {
        assertEquals(10.5f, arrayLib.Max(new float[]{1.2f, 2.5f, 5.5f, 10.1f, 10.5f}));
    }

    @Test
    void ShouldReturnFloatMaximumForEmptyArray() {
        assertEquals(Float.MAX_VALUE, arrayLib.Max(new float[]{}));
    }

    @Test
    void ShouldReturnFloatMaximumForNullArray() {
        assertEquals(Float.MAX_VALUE, arrayLib.Max(null));
    }
    /*Max Value*/

    /*Min Value*/
    @Test
    void ShouldReturnMinimumValueForNonEmptyArray() {
        assertEquals(1.2f, arrayLib.Min(new float[]{1.2f, 2.5f, 5.5f, 10.1f, 10.5f}));
    }

    @Test
    void ShouldReturnFloatMinValueForEmptyArray() {
        assertEquals(Float.MIN_VALUE, arrayLib.Min(new float[]{}));
    }

    @Test
    void ShouldReturnFloatMinValueForNullArray() {
        assertEquals(Float.MIN_VALUE, arrayLib.Min(null));
    }
    /*Min Value*/

    /* Avg */
    @Test
    void ShouldReturnAverageForNonEmptyArray() {
        assertEquals(2f, arrayLib.Average(new float[]{2f, 2f, 2f, 2f, 2f}));
        assertEquals(5f, arrayLib.Average(new float[]{2f, 3f, 4f, 5f, 6f, 7f, 8f}));
    }

    @Test
    void ShouldReturnFloatMinValueForEmptyAverageArray() {
        assertEquals(Float.MIN_VALUE, arrayLib.Min(new float[]{}));
    }

    @Test
    void ShouldReturnFloatMinValueForNullAverageArray() {
        assertEquals(Float.MIN_VALUE, arrayLib.Min(null));
    }
    /* Avg */

    /* Std Devi */
    @Test
    void ShouldReturnDeviationForNonEmptyArray() {
        //calculations using http://www.calculator.net/standard-deviation-calculator.html
        //error 0.81649658092773

        float calculated = arrayLib.StandardDeviation(new float[]{1f, 4f, 7f, 10f, 13f, 16f});
        float expected = 5.6124860801609f;
        float error = 0.81649658092773f;
        float exptectedMinusError = expected - error;
        float exptectedPlusError = expected + error;

        assertTrue(calculated >= exptectedMinusError && calculated <= exptectedPlusError);
    }

    @Test
    void ShouldReturnFloatMinValueForEmptyDeviationArray() {
        assertEquals(Float.MIN_VALUE, arrayLib.Min(new float[]{}));
    }

    @Test
    void ShouldReturnFloatMinValueForNullDeviationArray() {
        assertEquals(Float.MIN_VALUE, arrayLib.Min(null));
    }
    /* Std Devi */

    /* Size */
    @Test
    void SizeShouldBeTenForTenElementList() {
        assertEquals(10, arrayLib.Size(new float[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1}));
    }

    @Test
    void SizeShouldBeZeroForEmptyList() {
        assertEquals(0.0f, arrayLib.Size(new float[]{}));
    }

    @Test
    void SizeShouldBe0ForNullList() {
        assertEquals(0.0f, arrayLib.Size(null));
    }
    /* Size */

    /* Reverse */
    @Test
    void ShouldReturnRevertedArray() {
        Float[] reversed = (Float[]) arrayLib.Reverse(new Float[]{1f, 2f, 3f});
        assertTrue(java.util.Arrays.equals(new Float[]{3f, 2f, 1f}, reversed));
    }

    @Test
    void ShouldReturnNullForEmptyArray() {
        assertEquals(null, arrayLib.Reverse(new Float[]{}));
    }

    @Test
    void ShouldReturnNullForNullArray() {
        assertEquals(null, arrayLib.Reverse(null));
    }
    /* Reverse */

    /* Sorting */
    @Test
    void ShouldReturSortedArray() {
        int[] sortedAsc = (int[]) arrayLib.Sort(new int[]{3, 2, 1});
        assertTrue(java.util.Arrays.equals(new int[]{1, 2, 3}, sortedAsc));

        int[] sortedDesc = (int[]) arrayLib.Sort(new int[]{1, 2, 3}, "desc");
        assertTrue(java.util.Arrays.equals(new int[]{3, 2, 1}, sortedDesc));

        double[] doubleSortedAsc = (double[]) arrayLib.Sort(new double[]{3, 2, 1});
        assertTrue(java.util.Arrays.equals(new int[]{1, 2, 3}, sortedAsc));

        float[] floatedSortedDesc = (float[]) arrayLib.Sort(new float[]{1f, 2f, 3f}, "desc");
        assertTrue(java.util.Arrays.equals(new float[]{3f, 2f, 1f}, floatedSortedDesc));

        short[] shortSortedDesc = (short[]) arrayLib.Sort(new short[]{1, 2, 3}, "desc");
        assertTrue(java.util.Arrays.equals(new short[]{3, 2, 1}, shortSortedDesc));

        float[] floatedSortedAsc = (float[]) arrayLib.Sort(new float[]{3f, 2f, 1f});
        assertTrue(java.util.Arrays.equals(new float[]{1f, 2f, 3f}, floatedSortedAsc));

        short[] shortSortedAsc = (short[]) arrayLib.Sort(new short[]{3, 2, 1});
        assertTrue(java.util.Arrays.equals(new short[]{1, 2, 3}, shortSortedAsc));

        Float[] floatSortedAsc = (Float[]) arrayLib.Sort(new Float[]{3f, 2f, 1f});
        assertTrue(java.util.Arrays.equals(new Float[]{1f, 2f, 3f}, floatSortedAsc));

        Float[] floatSortedDesc = (Float[]) arrayLib.Sort(new Float[]{1f, 2f, 3f}, "desc");
        assertTrue(java.util.Arrays.equals(new Float[]{3f, 2f, 1f}, floatSortedDesc));
    }

    @Test
    void ShouldReturnNullForEmptySortedArray() {
        assertEquals(null, arrayLib.Sort(new int[]{}));
    }

    @Test
    void ShouldReturnNullForNullSortedArray() {
        assertEquals(null, arrayLib.Sort((Float[]) null));
    }
    /* Sorting */

}