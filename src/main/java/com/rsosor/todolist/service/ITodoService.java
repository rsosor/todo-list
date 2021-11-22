package com.rsosor.todolist.service;

import com.rsosor.todolist.model.entity.TodoItem;

import java.util.List;

public interface ITodoService {

    List<TodoItem> getTodoList();

    void setTodoList(List<TodoItem> todoItems);
}
