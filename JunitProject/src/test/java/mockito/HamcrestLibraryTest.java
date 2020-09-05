package mockito;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class HamcrestLibraryTest {
    @Test
    public void test(){
        List<Integer> nums = Arrays.asList(1,2,3,4,5);
        assertThat(nums.size(), is(5));
        assertThat(nums, hasSize(5));
        assertThat(nums, hasItems(1,5));
        assertThat(nums, everyItem(greaterThan(0)));
        assertThat(nums, everyItem(lessThanOrEqualTo(10)));

        //assertThat("", is(emptyString()));
        //assertThat(null,is(emptyOrNullString()));
        //assertThat("   abc x",equalToCompressingWhiteSpace("abcx"));

        Map<String,String> map = new HashMap<>();
        map.put("k","v");
        assertThat(map, hasKey("k"));
        assertThat(map, hasValue("v"));
        assertThat(new HashMap<String,String>(),anEmptyMap());

        Integer[] arr = {1,2,3,4,5};
        assertThat(arr,arrayWithSize(5));
       // assertThat(arr, arrayContaining(1,2));
       // assertThat(arr, arrayContainingInAnyOrder(5,3));

    }
}
