package de.neuefische.todos;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class ToDo {
    @Id
    private String id;
    private String title;
    private boolean done;

    public ToDo(String title) {
        this.title = title;
        this.done = false;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isDone() {
        return done;
    }

    public void toggle() {
        this.done = !this.done;
    }

}
