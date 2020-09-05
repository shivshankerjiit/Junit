package mockito.business;

import mockito.api.TodoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class TodoInjectMockTest {

    @InjectMocks
    TodoBusinessImpl todoBusiness;
    //TodoBusinessImpl todoBusiness = new TodoBusinessImpl();
    //@RunWith(MockitoJUnitRunner.class)-@InjectMocks -> will create object and inject dependencies with @Mock

    @Mock
    TodoService todoService;

    /*@Before
    public void beforeTest(){
        todoBusiness.setTodoService(todoService);
    }*/

    @Test
    public void test(){
        List<String> allTodos = Arrays.asList("Learn spring MVC","Learn spring", "Learn to Dance");
        given(todoService.getTodos("dummy")).willReturn(allTodos);
        List<String> todoSpring = todoBusiness.retriveTodoRelatedToSpring("dummy");
        assertThat(todoSpring.size(), is(2));
    }
}
