package mockito;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ListTest {
    @Test
    public void testListSize(){
        List list = mock(List.class);
        when(list.size()).thenReturn(2);
        assertEquals(2,list.size());
        assertEquals(2,list.size());
    }
    @Test
    public void testListSize_multipleValues(){
        List list = mock(List.class);
        when(list.size()).thenReturn(2).thenReturn(3);
        assertEquals(2,list.size());
        assertEquals(3,list.size());
    }
    @Test
    public void testListSize_goodMock(){
        List list = mock(List.class);
        assertEquals(0,list.size());
    }
    @Test(expected=RuntimeException.class)
    public void testList_exception(){
        List list = mock(List.class);
        when(list.get(anyInt())).thenThrow(new RuntimeException("Exception thrown for get"));
        list.get(0);
    }
    @Test
    public void testListGet(){
        List list = mock(List.class);
        when(list.get(0)).thenReturn("text");
        assertEquals("text",list.get(0));
        assertEquals(null,list.get(1)); //Good Mock
    }
    @Test
    public void testListSize_BDD(){
        //GIVEN
        List list = mock(List.class);
        given(list.size()).willReturn(2);
        //WHEN
        int size = list.size();
        //THEN
        assertThat(size, is(2));
    }
}
