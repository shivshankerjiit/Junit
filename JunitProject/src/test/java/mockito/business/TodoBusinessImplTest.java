package mockito.business;

import mockito.api.TodoService;
import mockito.api.TodoServiceStub;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class TodoBusinessImplTest {
    @Test
    public void retriveTodoRelatedToSpring_dummy(){
        TodoService todoService = new TodoServiceStub();
        TodoBusinessImpl todoBusiness = new TodoBusinessImpl(todoService);

        List<String> todosSpring = todoBusiness.retriveTodoRelatedToSpring("dummy");
        assertEquals(2,todosSpring.size());
    }
    @Test
    public void retriveTodoRelatedToSpring_arts(){
        TodoService todoService = new TodoServiceStub();
        TodoBusinessImpl todoBusiness = new TodoBusinessImpl(todoService);

        List<String> todoSpring = todoBusiness.retriveTodoRelatedToSpring("arts");
        assertEquals(0,todoSpring.size());
    }
}
