package com.rsosor.todolist.controller;

import com.rsosor.todolist.model.entity.TodoItem;
import com.rsosor.todolist.repository.base.IBaseRepository;
import com.rsosor.todolist.service.ITodoService;
import com.rsosor.todolist.service.impl.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TodoAppController {

    @Autowired
    private IBaseRepository repository;

    @GetMapping("/")
    public String index(Model model) {
        Iterable<TodoItem> todoItems = repository.findAll();
        model.addAttribute("items", new TodoService(todoItems));
        model.addAttribute("newitem", new TodoItem());
        return "index";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute TodoItem requestItem) {
        TodoItem item = new TodoItem(requestItem.getCategory(), requestItem.getName());
        repository.save(item);
        return "redirect:/";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute TodoService requestItems) {
        for (TodoItem requestItem : requestItems.getTodoList()) {
            TodoItem item = new TodoItem(requestItem.getCategory(), requestItem.getName());
            item.setComplete(requestItem.isComplete());
            item.setId(requestItem.getId());
            repository.save(item);
        }
        return "redirect:/";
    }
}
