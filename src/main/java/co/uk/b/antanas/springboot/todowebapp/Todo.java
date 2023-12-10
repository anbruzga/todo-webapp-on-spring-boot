package co.uk.b.antanas.springboot.todowebapp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

// Database(MySQL or ...)
// Static List of todos => Database (H2, MySQL)


@Entity
public class Todo {

    @Id
    @GeneratedValue
    private int id;

    private String username;

    @Size(min=3, max=255, message="Description length has to be between 3 and 255 characters")
    private String description;
    private LocalDate targetDate;
    private boolean done;


    public Todo(int id, String username, String description, LocalDate targetDate, boolean done) {
        this.id = id;
        this.username = username;
        this.description = description;
        this.targetDate = targetDate;
        this.done = done;
    }

    public Todo() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(LocalDate targetDate) {
        this.targetDate = targetDate;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Todo todo)) return false;

        return id == todo.id;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", description='" + description + '\'' +
                ", targetDate=" + targetDate +
                ", done=" + done +
                '}';
    }

    public void updateFieldsFrom(Todo source) {
        if (source.getDescription() != null) {
            this.setDescription(source.getDescription());
        }
        if (source.getUsername() != null) {
            this.setUsername(source.getUsername());
        }


        if (source.getTargetDate() != null) {
            this.setTargetDate(source.getTargetDate());
        }

        this.setDone(source.isDone());
    }

}
