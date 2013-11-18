package com.dynastymasra.spring.controller;

import com.dynastymasra.spring.domain.Mahasiswa;
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
@RequestMapping("mahasiswa")
public class MahasiswaController {

    protected static Logger logger = Logger.getLogger("controller");

    @Autowired
    private MahasiswaService  mahasiswaService;

    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public String form(ModelMap modelMap) {
        logger.debug("Request form mahasiswa");

        Mahasiswa  mahasiswa = new Mahasiswa();
        modelMap.addAttribute("mahasiswa", mahasiswa);
        modelMap.addAttribute("mahasiswaUrl", "/mahasiswa");

        return "mahasiswa-form-tile";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String create(@ModelAttribute("mahasiswa") Mahasiswa mahasiswa, ModelMap modelMap){
        logger.debug("Request create mahasiswa");

        mahasiswaService.save(mahasiswa);
        modelMap.addAttribute("mahasiswa", mahasiswa);

        return "mahasiswa-data-tile";
    }

    @RequestMapping(method = RequestMethod.GET)
    public String findAll(ModelMap modelMap) throws SQLException {
        logger.debug("Request list mahasiswa");

        List<Mahasiswa> mahasiswaList = mahasiswaService.findAll();
        modelMap.addAttribute("mahasiswaList", mahasiswaList);

        return "mahasiswa-list-tile";
    }

    @RequestMapping(value = "/form", params = "id", method = RequestMethod.GET)
    public String form(@RequestParam("id") Integer id, ModelMap modelMap) throws SQLException {
        logger.debug("Request form mahasiswa");

        Mahasiswa mahasiswa = mahasiswaService.findById(id);
        modelMap.addAttribute("mahasiswa", mahasiswa);
        modelMap.addAttribute("mahasiswaUrl", "/mahasiswa?id=" + id);

        return "mahasiswa-form-tile";
    }

    @RequestMapping(params = {"id"}, method = RequestMethod.POST)
    public String update(@RequestParam("id") Integer id, @ModelAttribute("mahasiswa") Mahasiswa mahasiswa, ModelMap modelMap) throws SQLException {
        logger.debug("Request update mahasiswa");

        mahasiswaService.update(id, mahasiswa);
        modelMap.addAttribute("mahasiswa", mahasiswa);

        return "mahasiswa-data-tile";
    }

    @RequestMapping(params = {"id"}, method = RequestMethod.GET)
    public String findById(@RequestParam("id") Integer id, ModelMap modelMap) throws SQLException {
        logger.debug("Request find mahasiswa");

        Mahasiswa mahasiswa = mahasiswaService.findById(id);
        modelMap.addAttribute("mahasiswa", mahasiswa);

        return "mahasiswa-data-tile";
    }

    @RequestMapping(value = "delete", params = {"id"}, method = RequestMethod.GET)
    public String delete(@RequestParam("id") Integer id, ModelMap modelMap) throws SQLException {
        logger.debug("Request delete mahasiswa");

        mahasiswaService.delete(id);

        return "redirect:/mahasiswa";
    }
}
