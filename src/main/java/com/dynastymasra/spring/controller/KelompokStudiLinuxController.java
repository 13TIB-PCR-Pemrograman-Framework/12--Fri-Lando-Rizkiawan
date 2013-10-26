package com.dynastymasra.spring.controller;

import com.dynastymasra.spring.domain.KelompokStudiLinux;
import com.dynastymasra.spring.service.KelompokStudiLinuxService;
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
@RequestMapping("ksl")
public class KelompokStudiLinuxController {

    protected static Logger logger = Logger.getLogger("controller");

    @Autowired
    private KelompokStudiLinuxService kelompokStudiLinuxService;

    @Autowired
    private MahasiswaService mahasiswaService;

    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public String form(ModelMap modelMap) {
        logger.debug("Request form linux");

        KelompokStudiLinux kelompokStudiLinux = new KelompokStudiLinux();
        modelMap.addAttribute("linux", kelompokStudiLinux);
        modelMap.addAttribute("linuxUrl", "/ksl");
        modelMap.addAttribute("mahasiswaList", mahasiswaService.findAll());
        modelMap.addAttribute("menuLinuxClass", "active");

        return "linux-form-tile";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String create(@ModelAttribute("linux") KelompokStudiLinux kelompokStudiLinux, ModelMap modelMap) throws SQLException {
        logger.debug("Request create linux");

        kelompokStudiLinuxService.save(kelompokStudiLinux);
        modelMap.addAttribute("linux", kelompokStudiLinuxService.findById(kelompokStudiLinux.getId()));
        modelMap.addAttribute("menuLinuxClass", "active");

        return "linux-data-tile";
    }

    @RequestMapping(value = "form", params = "id", method = RequestMethod.GET)
    public String form(@RequestParam("id") Integer id, ModelMap modelMap) throws SQLException {
        logger.debug("Request form linux");

        KelompokStudiLinux kelompokStudiLinux = kelompokStudiLinuxService.findById(id);
        modelMap.addAttribute("linux", kelompokStudiLinux);
        modelMap.addAttribute("linuxUrl", "/ksl?id=" + id);
        modelMap.addAttribute("mahasiswaList", mahasiswaService.findAll());
        modelMap.addAttribute("menuLinuxClass", "active");

        return "linux-form-tile";
    }

    @RequestMapping(params = "id", method = RequestMethod.POST)
    public String update(@RequestParam("id") Integer id, @ModelAttribute("linux") KelompokStudiLinux kelompokStudiLinux, ModelMap modelMap) throws SQLException {
        logger.debug("Request linux update");

        kelompokStudiLinuxService.update(id, kelompokStudiLinux);
        modelMap.addAttribute("linux", kelompokStudiLinuxService.findById(kelompokStudiLinux.getId()));
        modelMap.addAttribute("menuLinuxClass", "active");

        return "linux-data-tile";
    }

    @RequestMapping(method = RequestMethod.GET)
    public String findAll(ModelMap modelMap) {
        logger.debug("Request show linux study club");

        List<KelompokStudiLinux> kelompokStudiLinuxList = kelompokStudiLinuxService.findAll();
        modelMap.addAttribute("linuxList", kelompokStudiLinuxList);
        modelMap.addAttribute("menuLinuxClass", "active");

        return "linux-list-tile";
    }

    @RequestMapping(params = {"id"}, method = RequestMethod.GET)
    public String findById(@RequestParam("id") Integer id, ModelMap modelMap) throws SQLException {
        logger.debug("Request find by id linux study club");

        KelompokStudiLinux kelompokStudiLinux = kelompokStudiLinuxService.findById(id);
        modelMap.addAttribute("linux", kelompokStudiLinux);
        modelMap.addAttribute("menuLinuxClass", "active");

        return "linux-data-tile";
    }

    @RequestMapping(value = "delete", params = {"id"}, method = RequestMethod.GET)
    public String delete(@RequestParam("id") Integer id, ModelMap modelMap) throws SQLException{
        logger.debug("Request delete linux study club");

        kelompokStudiLinuxService.delete(id);

        return "redirect:/ksl";
    }
}

