package ru.javacourse.spring.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Author: Georgy Gobozov
 * Date: 10.04.13
 */
@Controller
@RequestMapping(value = "/first")
public class MyController {


    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String sayHello(ModelMap model) {
        model.addAttribute("message", "Spring 3 MVC Hello World");
        return "hello";
    }

    @RequestMapping(value = "/bye" ,method = RequestMethod.GET)
     public String sayBye(ModelMap model, HttpServletRequest request, HttpSession session) {
        model.addAttribute("message", "Spring 3 MVC bye-bye!");
        return "bye";
    }

    @RequestMapping(value = {"/spring/hello2", "/spring/hello3"} ,method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView sayHello2(ModelMap model) {
        model.addAttribute("message", "Spring 3 MVC Hello World 2");
        return new ModelAndView("hello", model);
    }

}
