package de.neuefische.todos;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ListService {

    private TodoListRepository todoListRepository;

    public ListService(TodoListRepository todoListRepository) {
        this.todoListRepository = todoListRepository;
    }

    public void addList(String title) {
        TodoList list = new TodoList(title);
        this.todoListRepository.save(list);
    }

    public List<TodoList> getList() {
        return this.todoListRepository.findAll();
    }


    public TodoList findListById(String id) {
        return this.todoListRepository.findById(id)
                .orElseThrow(ModelNotFoundException::new);
    }

    public void saveTodoList(TodoList list){
        this.todoListRepository.save(list);
    }

}

