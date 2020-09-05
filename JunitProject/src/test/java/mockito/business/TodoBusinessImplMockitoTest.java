package mockito.business;

import mockito.api.TodoService;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.*;

//org.junit.Assert
//org.mockito.BODMockito
//org.mockito.Mockito
//org.hamcrest.Matchers
//org.hamcrest.CoreMatchers
public class TodoBusinessImplMockitoTest {
    @Test
    public void retriveTodoRelatedToSpring_dummy(){
        TodoService todoService = mock(TodoService.class);
        List<String> allTodos = Arrays.asList("Learn spring MVC",
                "Learn spring", "Learn to Dance");
        when(todoService.getTodos("Ranga")).thenReturn(allTodos);

        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoService);
        List<String> todos = todoBusinessImpl
                .retriveTodoRelatedToSpring("Ranga");
        assertEquals(2, todos.size());
    }
    @Test
    public void retriveTodoRelatedToSpring_arts(){
        TodoService todoService = mock(TodoService.class);
        List<String> allTodos = Arrays.asList();
        when(todoService.getTodos("arts")).thenReturn(allTodos);
        //mockito acts as good mocks
        // that is mockito returns default value for those methods not defined and not throw exception,
        // like in this case of we don't define todoService.getTodos() also, we get empty list.
        // NOT NEEDED : when(todoService.getTodos("arts")).thenReturn(allTodos);

        TodoBusinessImpl todoBusiness = new TodoBusinessImpl(todoService);
        List<String> todoSpring = todoBusiness.retriveTodoRelatedToSpring("arts");
        assertEquals(0,todoSpring.size());
    }
    @Test
    public void retriveTodoRelatedToSpring_dummyBDD(){
        //GIVEN
        TodoService todoService = mock(TodoService.class);
        List<String> allTodos = Arrays.asList("Learn spring MVC","Learn spring");
        //change in syntax when-thenReturn --> given-willReturn
        // when(todoService.getTodos("dummy")).thenReturn(allTodos);
        given(todoService.getTodos("dummy")).willReturn(allTodos);

        //WHEN
        TodoBusinessImpl todoBusiness = new TodoBusinessImpl(todoService);
        List<String> todoSpring = todoBusiness.retriveTodoRelatedToSpring("dummy");

        //THEN
        //assertEquals(2,todoSpring.size());
        assertThat(todoSpring.size(), is(2));
    }
    @Test
    public void testDeleteTodoRelatedToSpring(){
        TodoService todoServiceMock = mock(TodoService.class);
        List<String> allTodos = Arrays.asList("Learn spring MVC","Learn spring", "Learn to Dance");
        //GIVEN
        given(todoServiceMock.getTodos("dummy")).willReturn(allTodos);
        TodoBusinessImpl todoBusiness = new TodoBusinessImpl(todoServiceMock);
        //WHEN
        todoBusiness.deleteTodoRelatedToSpring("dummy");
        //THEN
        verify(todoServiceMock).deleteTodos("Learn to Dance");
        verify(todoServiceMock, never()).deleteTodos("Learn spring MVC");
        verify(todoServiceMock, times(1)).deleteTodos("Learn to Dance");
        verify(todoServiceMock, atLeastOnce()).deleteTodos("Learn to Dance");
        verify(todoServiceMock, atLeast(1)).deleteTodos("Learn to Dance");
        verify(todoServiceMock, atMost(1)).deleteTodos("Learn to Dance");
        // THEN SYNTAX alternative to veryfy() in BDD
        then(todoServiceMock).should().deleteTodos("Learn to Dance");
        then(todoServiceMock).should(times(1)).deleteTodos("Learn to Dance");
        then(todoServiceMock).should(never()).deleteTodos("Learn spring MVC");
    }
    @Test
    public void testDeleteTodoRelatedToSpring_argumentCaptor(){
        List<String> allTodos = Arrays.asList("Learn spring MVC","Learn spring", "Learn to Dance");
        TodoService todoService = mock(TodoService.class);
        TodoBusinessImpl todoBusiness = new TodoBusinessImpl(todoService);
        //Declare Argument Captor
        ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);
        //GIVEN
        given(todoService.getTodos("dummy")).willReturn(allTodos);
        //WHEN
        todoBusiness.deleteTodoRelatedToSpring("dummy");
        //THEN
        then(todoService).should().deleteTodos(argumentCaptor.capture());
        assertThat(argumentCaptor.getValue(), is("Learn to Dance"));
    }
    @Test
    public void testDeleteTodoRelatedToSpring_argumentCaptor_multipleValues(){
        List<String> allTodos = Arrays.asList("Learn Music","Learn spring", "Learn to Dance");
        TodoService todoService = mock(TodoService.class);
        TodoBusinessImpl todoBusiness = new TodoBusinessImpl(todoService);
        ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);
        //GIVEN
        given(todoService.getTodos("dummy")).willReturn(allTodos);
        //WHEN
        todoBusiness.deleteTodoRelatedToSpring("dummy");
        //THEN
        then(todoService).should(times(2)).deleteTodos(argumentCaptor.capture());
        assertThat(argumentCaptor.getAllValues().size(), is(2) );
        assertThat(argumentCaptor.getAllValues().get(0), is("Learn Music") );
        assertThat(argumentCaptor.getAllValues().get(1), is("Learn to Dance") );
    }


}
