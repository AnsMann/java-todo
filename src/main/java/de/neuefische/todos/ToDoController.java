package de.neuefische.todos;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/todos")
public class ToDoController {

    private ToDoService todoService;
    private ListService listService;

    public ToDoController(ToDoService todoService, ListService listService) {
        this.todoService = todoService;
        this.listService = listService;
    }

    @GetMapping
    public List<ToDo> getTodos() {
        return this.todoService.getAllTodos();
    }

    @PostMapping
    public void createTodo(@Valid @RequestBody TodoCreateDTO dto) {
        this.todoService.addTodoToList(dto.getTitle(), dto.getListId());
    }

    @GetMapping("/{id}")
    public ToDo getTodo(@PathVariable String id) {
        return this.todoService.getTodo(id);
    }

    @DeleteMapping("/{id}")
    public void deleteTodo(@PathVariable String id) {
        this.todoService.deleteTodo(id);
    }

    @PutMapping("/{id}")
    public void editTodoName(@PathVariable String id, @RequestBody String title) {
        this.todoService.editTodoName(id, title);
    }

}
