package com.dynastymasra.spring.controller;

import com.dynastymasra.spring.domain.InformaticDatabaseClub;
import com.dynastymasra.spring.service.InformaticDatabaseClubService;
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
@RequestMapping("idc")
public class InformaticDatabaseClubController {

    protected static Logger logger = Logger.getLogger("controller");

    @Autowired
    private InformaticDatabaseClubService informaticDatabaseClubService;

    @Autowired
    private MahasiswaService mahasiswaService;

    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public String form(ModelMap modelMap) {
        logger.debug("Request form database");

        InformaticDatabaseClub informaticDatabaseClub = new InformaticDatabaseClub();
        modelMap.addAttribute("database", informaticDatabaseClub);
        modelMap.addAttribute("databaseUrl", "/idc");
        modelMap.addAttribute("mahasiswaList", mahasiswaService.findAll());
        modelMap.addAttribute("menuDatabaseClass", "active");

        return "database-form-tile";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String create(@ModelAttribute("database") InformaticDatabaseClub informaticDatabaseClub, ModelMap modelMap) throws SQLException {
        logger.debug("Request create database");

        informaticDatabaseClubService.save(informaticDatabaseClub);
        modelMap.addAttribute("database", informaticDatabaseClubService.findById(informaticDatabaseClub.getId()));
        modelMap.addAttribute("menuDatabaseClass", "active");

        return "database-data-tile";
    }

    @RequestMapping(value = "form", params = "id", method = RequestMethod.GET)
    public String form(@RequestParam("id") Integer id, ModelMap modelMap) throws SQLException {
        logger.debug("Request form database");

        InformaticDatabaseClub informaticDatabaseClub = informaticDatabaseClubService.findById(id);
        modelMap.addAttribute("database", informaticDatabaseClub);
        modelMap.addAttribute("databaseUrl", "/idc?id=" + id);
        modelMap.addAttribute("mahasiswaList", mahasiswaService.findAll());
        modelMap.addAttribute("menuDatabaseClass", "active");

        return "database-form-tile";
    }

    @RequestMapping(params = "id", method = RequestMethod.POST)
    public String update(@RequestParam("id") Integer id, @ModelAttribute("database") InformaticDatabaseClub informaticDatabaseClub, ModelMap modelMap) throws SQLException {
        logger.debug("Request database update");

        informaticDatabaseClubService.update(id, informaticDatabaseClub);
        modelMap.addAttribute("database", informaticDatabaseClubService.findById(informaticDatabaseClub.getId()));
        modelMap.addAttribute("menuDatabaseClass", "active");

        return "database-data-tile";
    }

    @RequestMapping(method = RequestMethod.GET)
    public String findAll(ModelMap modelMap) {
        logger.debug("Request show Informastic database club");

        List<InformaticDatabaseClub> informaticDatabaseClubs = informaticDatabaseClubService.findAll();
        modelMap.addAttribute("databaseList", informaticDatabaseClubs);
        modelMap.addAttribute("menuDatabaseClass", "active");

        return "database-list-tile";
    }

    @RequestMapping(params = {"id"}, method = RequestMethod.GET)
    public String findById(@RequestParam("id") Integer id, ModelMap modelMap) throws SQLException {
        logger.debug("Request find by id informatic database club");

        InformaticDatabaseClub informaticDatabaseClub = informaticDatabaseClubService.findById(id);
        modelMap.addAttribute("database", informaticDatabaseClub);
        modelMap.addAttribute("menuDatabaseJava", "active");

        return "database-data-tile";
    }

    @RequestMapping(value = "delete", params = {"id"}, method = RequestMethod.GET)
    public String delete(@RequestParam("id") Integer id, ModelMap modelMap) throws SQLException{
        logger.debug("Request delete informatic database club");

        informaticDatabaseClubService.delete(id);

        return "redirect:/idc";
    }
}
