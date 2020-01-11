package de.telran.blog.controller;

import org.springframework.boot.autoconfigure.web.ErrorProperties;
import org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class ErrorrHandlerController extends BasicErrorController {

    @GetMapping("/error")
    public String customError() {
        return "The link you followed may be broken, or the page may have been removed.";
    }
    @Override
    public String getErrorPath() {
        return "/error";
    }

    public ErrorrHandlerController(ErrorAttributes errorAttributes) {
        super(errorAttributes, new ErrorProperties());
    }

    /**/
    @RequestMapping(produces = "text/html")
    @Override
    public ModelAndView errorHtml(HttpServletRequest request, HttpServletResponse response) {
        HttpStatus status = getStatus(request);
        System.out.println("Get status: " + status);
        if (status == HttpStatus.NOT_FOUND) {
            return new ModelAndView("forward:/index.html");
        } else {
            return super.errorHtml(request, response);

        }
    }
}
