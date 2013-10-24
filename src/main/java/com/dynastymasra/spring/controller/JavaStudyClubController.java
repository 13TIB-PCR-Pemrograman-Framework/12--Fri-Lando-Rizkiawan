package com.dynastymasra.spring.controller;

import com.dynastymasra.spring.domain.JavaStudyClub;
import com.dynastymasra.spring.service.JavaStudyClubService;
import com.dynastymasra.spring.service.MahasiswaService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.SQLException;
import java.util.List;

/**
 * Author   : Dynastymasra
 * Name     : Dimas Ragil T
 * Email    : dynastymasra@gmail.com
 * LinkedIn : http://www.linkedin.com/in/dynastymasra
 * Blogspot : dynastymasra.wordpress.com | dynastymasra.blogspot.com
 */

@Controller
@RequestMapping("jsc")
public class JavaStudyClubController {

    protected static Logger logger = Logger.getLogger("controller");

    @Autowired
    private JavaStudyClubService javaStudyClubService;

    @Autowired
    private MahasiswaService mahasiswaService;

    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public String form(ModelMap modelMap) {
        logger.debug("Request form java");

        JavaStudyClub javaStudyClub = new JavaStudyClub();
        modelMap.addAttribute("java", javaStudyClub);
        modelMap.addAttribute("javaUrl", "/jsc");
        modelMap.addAttribute("mahasiswaList", mahasiswaService.findAll());
        modelMap.addAttribute("menuJavaClass", "active");

        return "java-form-tile";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String create(@ModelAttribute("java") JavaStudyClub javaStudyClub, ModelMap modelMap) throws SQLException {
        logger.debug("Request create java");

        javaStudyClubService.save(javaStudyClub);
        modelMap.addAttribute("java", javaStudyClubService.findById(javaStudyClub.getId()));
        modelMap.addAttribute("menuJavaClass", "active");

        return "java-data-tile";
    }

    @RequestMapping(value = "form", params = "id", method = RequestMethod.GET)
    public String form(@RequestParam("id") Integer id, ModelMap modelMap) throws SQLException {
        logger.debug("Request form java");

        JavaStudyClub javaStudyClub = javaStudyClubService.findById(id);
        modelMap.addAttribute("java", javaStudyClub);
        modelMap.addAttribute("javaUrl", "/jsc?id=" + id);
        modelMap.addAttribute("mahasiswaList", mahasiswaService.findAll());
        modelMap.addAttribute("menuJavaClass", "active");

        return "java-form-tile";
    }

    @RequestMapping(params = "id", method = RequestMethod.POST)
    public String update(@RequestParam("id") Integer id, @ModelAttribute("java") JavaStudyClub javaStudyClub, ModelMap modelMap) throws SQLException {
        logger.debug("Request java update");

        javaStudyClubService.update(id, javaStudyClub);
        modelMap.addAttribute("java", javaStudyClubService.findById(javaStudyClub.getId()));
        modelMap.addAttribute("menuJavaClass", "active");

        return "java-data-tile";
    }

    @RequestMapping(method = RequestMethod.GET)
    public String findAll(ModelMap modelMap) {
        logger.debug("Request show java study club");

        List<JavaStudyClub> javaStudyClubList = javaStudyClubService.findAll();
        modelMap.addAttribute("javaList", javaStudyClubList);
        modelMap.addAttribute("menuJavaClass", "active");

        return "java-list-tile";
    }

    @RequestMapping(params = {"id"}, method = RequestMethod.GET)
    public String findById(@RequestParam("id") Integer id, ModelMap modelMap) throws SQLException {
        logger.debug("Request find by id java study club");

        JavaStudyClub javaStudyClub = javaStudyClubService.findById(id);
        modelMap.addAttribute("java", javaStudyClub);
        modelMap.addAttribute("menuClassJava", "active");

        return "java-data-tile";
    }

    @RequestMapping(value = "delete", params = {"id"}, method = RequestMethod.GET)
    public String delete(@RequestParam("id") Integer id, ModelMap modelMap) throws SQLException{
        logger.debug("Request delete java study club");

        javaStudyClubService.delete(id);

        return "redirect:/jsc";
    }
}
