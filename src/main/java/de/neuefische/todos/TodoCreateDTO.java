package de.neuefische.todos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class TodoCreateDTO {

    @CustomValidationInterface
    private String title;

    @NotNull
    private String listId;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getListId() {
        return listId;
    }

    public void setListId(String listId) {
        this.listId = listId;
    }
}
