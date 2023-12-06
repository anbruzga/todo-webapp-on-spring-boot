package co.uk.b.antanas.springboot.todowebapp.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SayHelloController {

    //"say-hello" => "Hello! What are you learning today?"

    @RequestMapping("say-hello")
    @ResponseBody
    public String sayHello() {
        return "Hello! What are you learning today?";
    }

    @RequestMapping("say-hello-html")
    @ResponseBody
    public String sayHelloHtml() {
        String html = """
                <!DOCTYPE html>
                <html lang="en">
                  <head>
                    <meta charset="UTF-8">
                    <meta name="viewport" content="width=device-width, initial-scale=1.0">
                    <meta http-equiv="X-UA-Compatible" content="ie=edge">
                    <title>My Hello App</title>
                    <link rel="stylesheet" href="./style.css">
                    <link rel="icon" href="./favicon.ico" type="image/x-icon">
                  </head>
                  <body>
                    <main>
                        <h1>Welcome to My Website</h1> \s
                    </main>
                	<script src="index.js"></script>
                  </body>
                </html>
                """;

        return html;
    }


    // /say-hello-jsp => sayHello.jsp
    // src/main/webapp/WEB-INF/jsp/sayHello.jsp
    @RequestMapping("say-hello-jsp")
    public String sayHelloJsp() {
        return "sayHello";
    }
}
