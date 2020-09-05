package mockito.api;

import java.util.List;

public interface TodoService {
    public List<String> getTodos(String user);
    public void deleteTodos(String todo);
}
