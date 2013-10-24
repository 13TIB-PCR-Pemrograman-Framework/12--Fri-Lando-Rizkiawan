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

    @RequestMapping(value = "idc", method = RequestMethod.GET)
    public String database(ModelMap modelMap) {
        logger.debug("Request show informatic database club");
        return "idc-tile";
    }

    @RequestMapping(value = "wsc", method = RequestMethod.GET)
    public String web(ModelMap modelMap) {
        logger.debug("Request show informatic database club");
        return "web-tile";
    }

    @RequestMapping(value = "lsc", method = RequestMethod.GET)
    public String linux(ModelMap modelMap) {
        logger.debug("Request show informatic database club");
        return "linux-tile";
    }

    @RequestMapping(value = "msc", method = RequestMethod.GET)
    public String mulmed(ModelMap modelMap) {
        logger.debug("Request show informatic database club");
        return "mulmed-tile";
    }

    @RequestMapping(value = "update", method = RequestMethod.GET)
    public String update(ModelMap modelMap) {
        logger.debug("Received request to show update");
        return "update-tile";
    }
}
