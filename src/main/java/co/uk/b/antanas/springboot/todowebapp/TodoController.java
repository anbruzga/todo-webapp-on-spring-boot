package co.uk.b.antanas.springboot.todowebapp;

import co.uk.b.antanas.springboot.todowebapp.security.UserContext;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Controller
@SessionAttributes("name")
public class TodoController {

    private final TodoService todoService;
    private final UserContext userContext;

    @Autowired
    public TodoController(TodoService todoService, UserContext userContext) {
        this.todoService = todoService;
        this.userContext = userContext;
    }


    // /list-todos
    @RequestMapping("list-todos")
    public String listAllTodos(ModelMap model) {
        String user = getUserName();
        List<Todo> todos = todoService.findByUser(user);
        model.addAttribute("todos", todos);
        return "listTodos";
    }

    private String getUserName() {
        return userContext.getLoggedInUsername();
    }

    @RequestMapping(value="add-todo", method = RequestMethod.GET)
    public String showNewTodoPage(ModelMap model) {
        String user = getUserName();
        Todo todo = new Todo(0, user, "", LocalDate.now().plusYears(1), false);
        model.put("todo", todo);
        return "todo";
    }

    @RequestMapping(value="add-todo", method = RequestMethod.POST)
    public String addNewTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
        if (result.hasErrors()){
            return "todo";
        }

        String user = getUserName();
        todoService.addTodo(user, todo.getDescription() , todo.getTargetDate(), false);
        return "redirect:list-todos";
    }

    @RequestMapping(value="delete-todo")
    public String deleteToDo(@RequestParam int id) {
        todoService.deleteTodo(id);
        return "redirect:list-todos";
    }

    @RequestMapping(value="update-todo", method = RequestMethod.GET)
    public String showUpdateTodoPage(ModelMap model, @RequestParam int id) {
        Optional<Todo> todo = todoService.findById(id);
        if(todo.isPresent()) {
            model.put("todo", todo.get());
            return "todo";
        } else {
            throw new IllegalStateException("todo shouldn't be null when we are editing it!");
        }
    }

    @RequestMapping(value="update-todo", method = RequestMethod.POST)
    public String updateTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
        if (result.hasErrors()){
            return "todo";
        }

        System.out.println(todo.toString());
        todoService.updateTodo(todo);
        return "redirect:list-todos";
    }


}
