package com.example.TodoApp.Repository;

import com.example.TodoApp.Model.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TodoRepo {
    @Autowired
    private List<Todo> myTodos;

    public List<Todo> getmyTodos() {
        return myTodos;
    }

    public void add(Todo myTodo) {
        myTodos.add(myTodo);

    }

    public void delete(Todo myTodo) {
        myTodos.remove(myTodo);
    }
}
