package com.rsosor.todolist.controller;

import com.rsosor.todolist.model.entity.TodoItem;
import com.rsosor.todolist.repository.base.IBaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/todo")
public class TodoRestController {

    @Autowired
    private IBaseRepository repository;

    @GetMapping("/all")
    public @ResponseBody Iterable<TodoItem> getAll() {
        Iterable<TodoItem> todoItems = repository.findAll();
        return repository.findAll();
    }

    @PostMapping("/add")
    public @ResponseBody Result addItem(@RequestParam String name, @RequestParam String category) {
        TodoItem item = new TodoItem(category, name);
        TodoItem saved = repository.save(item);
        return new Result("Added", saved);
    }

    @PostMapping("/update")
    public @ResponseBody Result updateItem(@RequestParam Integer id, @RequestParam String name,
                                           @RequestParam String category, @RequestParam boolean isComplete) {
        TodoItem item = new TodoItem(category, name);
        item.setId(id);
        item.setComplete(isComplete);
        TodoItem saved = repository.save(item);
        return new Result("Updated", saved);
    }

    class Result {

        private String status;

        private TodoItem item;

        public Result() {
            status = "";
            item = null;
        }

        public Result(String status, TodoItem item) {
            this.status = status;
            this.item = item;
        }

        public TodoItem getItem() {
            return item;
        }

        public void setItem(TodoItem item) {
            this.item = item;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }
    }
}
