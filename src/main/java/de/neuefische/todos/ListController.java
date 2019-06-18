package de.neuefische.todos;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lists")
public class ListController {

    private ListService listService;
    private ToDoService todoService;

    public ListController(ListService listService, ToDoService todoService) {
        this.listService = listService;
        this.todoService = todoService;
    }

    @GetMapping("/{id}/todos")
    public List<ToDo> getToDoList(@PathVariable String id) {
        return this.todoService.findByList(id);
    }

    @PostMapping
    public void addList(@RequestBody String title) {
        this.listService.addList(title);
    }

    @GetMapping
    public List<TodoList> getList() {
        return this.listService.getList();
    }


}
