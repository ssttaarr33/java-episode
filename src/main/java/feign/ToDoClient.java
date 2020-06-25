package feign;

import java.util.List;

import model.Todo;

public interface ToDoClient {

    @RequestLine("GET")
    List<Todo> getTodo();
}
