package com.rsosor.todolist.service.impl;

import com.rsosor.todolist.model.entity.TodoItem;
import com.rsosor.todolist.service.ITodoService;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

public class TodoService implements ITodoService {

    @Valid
    private List<TodoItem> todoItems = new ArrayList<>();

    public TodoService() {}

    public TodoService(Iterable<TodoItem> items) {
        items.forEach(todoItems:: add);
    }

    public TodoService(List<TodoItem> todoItems) {
        this.todoItems = todoItems;
    }

    @Override
    public List<TodoItem> getTodoList() {
        return todoItems;
    }

    @Override
    public void setTodoList(List<TodoItem> todoItems) {
        this.todoItems = todoItems;
    }
}
