package co.uk.b.antanas.springboot.todowebapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

    private final TodoRepository todoRepository;

    @Autowired
    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<Todo> findByUser(String username) {
        return todoRepository.findByUsername(username);
    }

    public void addTodo(String username, String description, LocalDate targetDate, boolean done) {
        if (username == null || description == null || targetDate == null) {
            throw new IllegalArgumentException("Todo properties must not be null");
        }
        Todo todo = new Todo(username, description, targetDate, done);
        todoRepository.save(todo);
    }

    @Transactional
    public void deleteTodo(Integer id) {
        if (!todoRepository.existsById(id)) {
            throw new IllegalArgumentException("Todo with id " + id + " does not exist");
        }
        todoRepository.deleteById(id);
    }

    public Optional<Todo> findById(Integer id) {
        return todoRepository.findById(id);
    }

    @Transactional
    public void updateTodo(Todo todo) {
        Todo existingTodo = todoRepository.findById(todo.getId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid todo ID: " + todo.getId()));
        existingTodo.updateFieldsFrom(todo);// Updating fields from the provided todo
        todoRepository.save(existingTodo); // This will update the existing todo
    }
}