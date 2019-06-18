package de.neuefische.todos;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document
public class TodoList {
    @Id
    private String id;
    private String title;
    @DBRef
    private List<ToDo> todos = new ArrayList<>();

    public TodoList(String title) {
        this.title = title;
    }

    public List<ToDo> getTodos() {
        return this.todos;
    }

    public ToDo addTodo(String title) {
        ToDo newTodo = new ToDo(title);
        this.todos.add(newTodo);
        return newTodo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public void setTodos(List<ToDo> todos) {
        this.todos = todos;
    }
}
