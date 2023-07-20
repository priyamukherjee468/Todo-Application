package com.example.TodoApp.Service;

import com.example.TodoApp.Model.Todo;
import com.example.TodoApp.Repository.TodoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {
    @Autowired
    TodoRepo todoRepo;

    public List<Todo> getAllTodos() {
        return todoRepo.getmyTodos();
    }

    public List<Todo> getDoneTodos() {
        List<Todo> doneTodos = new ArrayList<>();
        for (Todo myTodo : todoRepo.getmyTodos()) {
            if (myTodo.isTodoDoneStatus()) {
                doneTodos.add(myTodo);
            }
        }
        return doneTodos;
    }

    public List<Todo> getUnDoneTodos() {
        List<Todo> undoneTodos = new ArrayList<>();
        for (Todo myTodo : todoRepo.getmyTodos()) {
            if (myTodo.isTodoDoneStatus()) {
                undoneTodos.add(myTodo);
            }
        }
        return undoneTodos;
    }

    public String addTodo(Todo myTodo) {
        todoRepo.add(myTodo);
        return "Todo added!";
    }

    public Todo getTodoById(Integer todoId) {
        for (Todo todo : todoRepo.getmyTodos()) {
            if (todo.getTodoId().equals(todoId)) {
                return todo;

            }
        }

        throw new IllegalStateException("id not found");
    }

    public String updateStatusbyId(Integer todoId, boolean status) {
        for (Todo myTodo : todoRepo.getmyTodos()) {
            if (myTodo.getTodoId().equals(todoId)) {
                myTodo.setTodoDoneStatus(status);
                return "todo updated for todo ID:" + todoId;
            }
        }
        return "todo Id not found.";
    }

    public String removeTodo(Integer todoId) {
        for (Todo myTodo : todoRepo.getmyTodos()) {
            if (myTodo.getTodoId().equals(todoId)) {
                todoRepo.delete(myTodo);
                return "todo removed for todo ID:" + todoId;
            }
        }
        return "todo Id not exist.";
    }
}
