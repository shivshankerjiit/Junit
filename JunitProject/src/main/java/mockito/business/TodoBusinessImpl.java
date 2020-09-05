package mockito.business;

import mockito.api.TodoService;

import java.util.ArrayList;
import java.util.List;

//SUT - TodoBusinessImpl
//dependency - TodoService
public class TodoBusinessImpl {
    private TodoService todoService;

    public TodoBusinessImpl(TodoService todoService) {
        this.todoService = todoService;
    }
    public TodoBusinessImpl(){}

    public void setTodoService(TodoService todoService){
        this.todoService = todoService;
    }

    public List<String> retriveTodoRelatedToSpring(String user){
        List<String> springTodos = new ArrayList<>();
        List<String> todos = todoService.getTodos(user);
        for(String todo : todos){
            if(todo.contains("spring")){
                springTodos.add(todo);
            }
        }
        return springTodos;
    }

    public void deleteTodoRelatedToSpring(String user){
        List<String> springTodos = new ArrayList<>();
        List<String> todos = todoService.getTodos(user);
        for(String todo : todos){
            if(!todo.contains("spring")){
                todoService.deleteTodos(todo);
            }
        }
    }
}
