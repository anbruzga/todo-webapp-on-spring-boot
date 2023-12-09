package co.uk.b.antanas.springboot.todowebapp;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TodoService {

    private static List<Todo> todos = new ArrayList<>();
    static {
        todos.add(new Todo(1, "tony", "Learn Spring", LocalDate.now().plusWeeks(12), false));
        todos.add(new Todo(2, "tony", "Learn AWS", LocalDate.now().plusWeeks(14), false));
        todos.add(new Todo(3, "tony", "Learn React", LocalDate.now().plusWeeks(18), false));
        todos.add(new Todo(4, "Marta", "Learn Full Stack Development", LocalDate.now().plusWeeks(11), false));
        todos.add(new Todo(5, "tony", "Learn Full Stack Development", LocalDate.now().plusWeeks(11), false));

    }


    public List<Todo> findByUser(String username) {
        return todos.stream().filter(todo -> todo.getUsername().equalsIgnoreCase(username)).toList();
    }
}
