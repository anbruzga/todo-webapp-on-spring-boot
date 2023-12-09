package co.uk.b.antanas.springboot.todowebapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.time.LocalDate;
import java.util.List;

@Controller
@SessionAttributes("name")
public class TodoController {

    private final TodoService todoService;


    @Autowired
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    // /list-todos
    @RequestMapping("list-todos")
    public String listAllTodos(ModelMap modelMap) {
        List<Todo> todos = todoService.findByUser("tony");
        modelMap.addAttribute("todos", todos);
        return "listTodos";
    }

    @RequestMapping(value="add-todo", method = RequestMethod.GET)
    public String showNewTodoPage() {
        return "todo";
    }


    /*
        public String addNewTodo(ModelMap model, @RequestParam String username,
                             @RequestParam String description,
                             @RequestParam LocalDate targetDate,
                             @RequestParam boolean done) {
     */
    @RequestMapping(value="add-todo", method = RequestMethod.POST)
    public String addNewTodo(ModelMap model, @RequestParam String description) {
        String userName = (String) model.get("name");
        todoService.addTodo(userName, description, LocalDate.now().plusYears(1), false);
        return "redirect:list-todos";
    }
}
