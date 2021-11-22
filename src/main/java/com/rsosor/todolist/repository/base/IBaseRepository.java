package com.rsosor.todolist.repository.base;

import com.rsosor.todolist.model.entity.TodoItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBaseRepository extends JpaRepository<TodoItem, Integer> {

}
