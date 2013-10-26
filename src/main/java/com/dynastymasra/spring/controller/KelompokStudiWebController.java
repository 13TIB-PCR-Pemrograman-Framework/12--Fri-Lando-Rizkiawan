package com.dynastymasra.spring.controller;

import com.dynastymasra.spring.domain.KelompokStudiWeb;
import com.dynastymasra.spring.service.KelompokStudiWebService;
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
@RequestMapping("ksw")
public class KelompokStudiWebController {

    protected static Logger logger = Logger.getLogger("controller");

    @Autowired
    private KelompokStudiWebService kelompokStudiWebService;

    @Autowired
    private MahasiswaService mahasiswaService;

    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public String form(ModelMap modelMap) {
        logger.debug("Request form web");

        KelompokStudiWeb kelompokStudiWeb = new KelompokStudiWeb();
        modelMap.addAttribute("web", kelompokStudiWeb);
        modelMap.addAttribute("webUrl", "/ksw");
        modelMap.addAttribute("mahasiswaList", mahasiswaService.findAll());
        modelMap.addAttribute("menuWebClass", "active");

        return "web-form-tile";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String create(@ModelAttribute("web") KelompokStudiWeb kelompokStudiWeb, ModelMap modelMap) throws SQLException {
        logger.debug("Request create web");

        kelompokStudiWebService.save(kelompokStudiWeb);
        modelMap.addAttribute("web", kelompokStudiWebService.findById(kelompokStudiWeb.getId()));
        modelMap.addAttribute("menuWebClass", "active");

        return "web-data-tile";
    }

    @RequestMapping(value = "form", params = "id", method = RequestMethod.GET)
    public String form(@RequestParam("id") Integer id, ModelMap modelMap) throws SQLException {
        logger.debug("Request form web");

        KelompokStudiWeb kelompokStudiWeb = kelompokStudiWebService.findById(id);
        modelMap.addAttribute("web", kelompokStudiWeb);
        modelMap.addAttribute("webUrl", "/ksw?id=" + id);
        modelMap.addAttribute("mahasiswaList", mahasiswaService.findAll());
        modelMap.addAttribute("menuWebClass", "active");

        return  "web-form-tile";
    }

    @RequestMapping(params = "id", method = RequestMethod.POST)
    public String update(@RequestParam("id") Integer id, @ModelAttribute("web") KelompokStudiWeb kelompokStudiWeb, ModelMap modelMap) throws SQLException {
        logger.debug("Request web update");

        kelompokStudiWebService.update(id, kelompokStudiWeb);
        modelMap.addAttribute("web", kelompokStudiWebService.findById(kelompokStudiWeb.getId()));
        modelMap.addAttribute("menuWebClass", "active");

        return "web-data-tile";
    }

    @RequestMapping(method = RequestMethod.GET)
    public String findAll(ModelMap modelMap) {
        logger.debug("Request show kelompok studi web");

        List<KelompokStudiWeb> kelompokStudiWebList = kelompokStudiWebService.findAll();
        modelMap.addAttribute("webList", kelompokStudiWebList);
        modelMap.addAttribute("menuWebClass", "active");

        return "web-list-tile";
    }

    @RequestMapping(params = {"id"}, method = RequestMethod.GET)
    public String findById(@RequestParam("id") Integer id, ModelMap modelMap) throws SQLException {
        logger.debug("Request find by id kelompok studi web");

        KelompokStudiWeb kelompokStudiWeb = kelompokStudiWebService.findById(id);
        modelMap.addAttribute("web", kelompokStudiWeb);
        modelMap.addAttribute("menuWebClass", "active");

        return "web-data-tile";
    }

    @RequestMapping(value = "delete", params = {"id"}, method = RequestMethod.GET)
    public String delete(@RequestParam("id") Integer id, ModelMap modelMap) throws SQLException {
        logger.debug("Request delete kelompok studi web");

        kelompokStudiWebService.delete(id);

        return  "redirect:/ksw";
    }
}
