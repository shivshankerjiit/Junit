import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ParameterizedTest {
    String input;
    String expectedValue;

    SpringHelper helper = new SpringHelper();

    public ParameterizedTest(String input, String expectedValue){
        this.input = input;
        this.expectedValue = expectedValue;
    }

    @Parameterized.Parameters
    public static Collection<String[]> testCondition(){
        String[][] expectedoutComes = {
                { "AA",""},
                { "ABC","BC"},
                { "AABC", "BC"},
                { "BCDE", "BCDE"}
        };
        return Arrays.asList(expectedoutComes);
    }

    @Test
    public void testTruncateAInFirst2Position(){
        assertEquals(expectedValue, helper.truncateAInFirst2Position(input));
    }

}
