package com.dynastymasra.spring.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Author   : Dynastymasra
 * Name     : Dimas Ragil T
 * Email    : dynastymasra@gmail.com
 * LinkedIn : http://www.linkedin.com/in/dynastymasra
 * Blogspot : dynastymasra.wordpress.com | dynastymasra.blogspot.com
 */

@Controller
@RequestMapping("/")
public class MainController {
    protected static Logger logger = Logger.getLogger("controller");

    @RequestMapping(method = RequestMethod.GET)
    public String home(ModelMap modelMap) {
        logger.debug("Request show home page");
        return "home-tile";
    }
}
