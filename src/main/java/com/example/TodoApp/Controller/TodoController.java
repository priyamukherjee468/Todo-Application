package com.example.TodoApp.Controller;

import com.example.TodoApp.Model.Todo;
import com.example.TodoApp.Service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoController {
    public TodoController() {

    }
    @Autowired
    TodoService todoService;
    @GetMapping("todos")
    public List<Todo> getAllTodos(){
        return todoService.getAllTodos();
    }
    @GetMapping("todos/done")
    public List<Todo> getDoneTodos()
    {
        return todoService.getDoneTodos();

    }
    @GetMapping("todos/undone")
    public List<Todo> getUnDoneTodos()
    {
        return todoService.getUnDoneTodos();

    }
    @GetMapping("todos/{todoId}")
    public Todo getTodoById(@PathVariable Integer todoId){
        return todoService.getTodoById(todoId);
    }
    @PostMapping("todos")
    public String addTodo(@RequestBody Todo todo){
        return todoService.addTodo(todo);
    }
    @PutMapping("todo/{todoId}/{status}")
    public String updateStatusbyId(@PathVariable Integer todoId,@PathVariable boolean status){
        return todoService.updateStatusbyId(todoId,status);
    }
    @DeleteMapping("todo/{todoId}")
    public String removeTodo(@PathVariable Integer todoId){
        return todoService.removeTodo(todoId);
    }
}
