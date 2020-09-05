import org.junit.Test;
import org.omg.CORBA.StringHolder;

import java.util.Arrays;

import static org.junit.Assert.*;

public class SpringHelperTest {
    SpringHelper helper = new SpringHelper();
    @Test
    public void test(){
        //fail("Not yet implemented");
        String expected = "";
        String actual = helper.truncateAInFirst2Position("AA");
        assertEquals(expected,actual);
    }
    @Test
    public void testArray(){
        int[] expected = {1,2,3};
        int[] actual = {1,2,3};
        assertArrayEquals(expected,actual);
    }
    @Test(expected = NullPointerException.class)
    public void testException(){
        int[] arr = null;
        Arrays.sort(arr);
    }
    @Test(timeout = 100)
    public void testPerformance(){
        int arr[] = {1,2,3};
        for(int i=0 ; i<1000000; i++){
            arr[0] = i;
            Arrays.sort(arr);
        }
    }
    @Test
    public void testTruncateAInFirst2Position_aInFirst2Pos(){
        assertEquals("BC",helper.truncateAInFirst2Position("AABC"));
    }
    @Test
    public void testTruncateAInFirst2Position_aNotInFirst2Pos(){
        assertEquals("BCDE",helper.truncateAInFirst2Position("BCDE"));
    }
    @Test
    public void testAreFirst2CharSameAsLast2_basicCond(){
        assertTrue(helper.areFirst2CharSameAsLast2("AAbAA"));
    }
}
