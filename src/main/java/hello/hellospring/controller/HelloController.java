package hello.hellospring.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @GetMapping("hello")
    public String hello(Model model){

        model.addAttribute("data","하이하이");
        return "hello";
    }
    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloapi(@RequestParam(value = "name",required = false) String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;

    }
    static class Hello{
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    @GetMapping("hellomvc")
    @ResponseBody
    public String hellomvc(@RequestParam(value = "name",required = false) String name){
        //model.addAttribute("name",name);
        return "hello "+name;
    }
}
