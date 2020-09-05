package mockito;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class SpyMockingTest {

    @Test
    public void mocking(){
        List<String> list = mock(List.class);
        assertEquals(0, list.size());
        assertEquals(null, list.get(0));
        list.add("test1");
        list.add("test2");
        assertEquals(0,list.size());
        when(list.size()).thenReturn(5);
        assertEquals(5,list.size());
    }

    @Test
    public void spying(){
        List<String> spyList = spy(ArrayList.class);
        assertEquals(0, spyList.size());
        //assertEquals(null, spyList.get(0)); -> will throw error
        spyList.add("test1");
        spyList.add("test2");
        assertEquals(2,spyList.size());
        when(spyList.size()).thenReturn(5);
        assertEquals(5,spyList.size());
    }
}
