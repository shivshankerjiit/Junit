package mockito.api;

import java.util.Arrays;
import java.util.List;

public class TodoServiceStub implements TodoService{
    @Override
    public List<String> getTodos(String user) {
        List<String> todos = null;
        if(user.equals("dummy")){
            todos = Arrays.asList("spring overview","spring security","dance overview");
        }
        if(user.equals("arts")){
            todos = Arrays.asList("music overview","dance overview");
        }
        return todos;
    }

    @Override
    public void deleteTodos(String todo) {

    }
}
