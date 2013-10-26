package com.dynastymasra.spring.controller;

import com.dynastymasra.spring.domain.KelompokStudiMultimedia;
import com.dynastymasra.spring.service.KelompokStudiMultimediaService;
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
@RequestMapping("ksm")
public class KelompokStudiMultimediaController {

    protected static Logger logger = Logger.getLogger("controller");

    @Autowired
    private KelompokStudiMultimediaService kelompokStudiMultimediaService;

    @Autowired
    private MahasiswaService mahasiswaService;

    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public String form(ModelMap modelMap) {
        logger.debug("Request form mulmed");

        KelompokStudiMultimedia kelompokStudiMultimedia = new KelompokStudiMultimedia();
        modelMap.addAttribute("mulmed", kelompokStudiMultimedia);
        modelMap.addAttribute("mulmedUrl", "/ksm");
        modelMap.addAttribute("mahasiswaList", mahasiswaService.findAll());
        modelMap.addAttribute("menuMulmedClass", "active");

        return "mulmed-form-tile";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String create(@ModelAttribute("mulmed") KelompokStudiMultimedia kelompokStudiMultimedia, ModelMap modelMap) throws SQLException {
        logger.debug("Request create mulmed");

        kelompokStudiMultimediaService.save(kelompokStudiMultimedia);
        modelMap.addAttribute("mulmed", kelompokStudiMultimediaService.findById(kelompokStudiMultimedia.getId()));
        modelMap.addAttribute("menuMulmedClass", "active");

        return "mulmed-data-tile";
    }

    @RequestMapping(value = "form", params = "id", method = RequestMethod.GET)
    public String form(@RequestParam("id") Integer id, ModelMap modelMap) throws SQLException {
        logger.debug("Request form mulmed");

        KelompokStudiMultimedia kelompokStudiMultimedia = kelompokStudiMultimediaService.findById(id);
        modelMap.addAttribute("mulmed", kelompokStudiMultimedia);
        modelMap.addAttribute("mulmedUrl", "/ksm?id=" + id);
        modelMap.addAttribute("mahasiswaList", mahasiswaService.findAll());
        modelMap.addAttribute("menuMulmedClass", "active");

        return "mulmed-form-tile";
    }

    @RequestMapping(params = "id", method = RequestMethod.POST)
    public String update(@RequestParam("id") Integer id, @ModelAttribute("mulmed") KelompokStudiMultimedia kelompokStudiMultimedia, ModelMap modelMap) throws SQLException {
        logger.debug("Request mulmed update");

        kelompokStudiMultimediaService.update(id, kelompokStudiMultimedia);
        modelMap.addAttribute("mulmed", kelompokStudiMultimediaService.findById(kelompokStudiMultimedia.getId()));
        modelMap.addAttribute("menuMulmedClass", "active");

        return "mulmed-data-tile";
    }

    @RequestMapping(method = RequestMethod.GET)
    public String findAll(ModelMap modelMap) {
        logger.debug("Request show multimedia study club");

        List<KelompokStudiMultimedia> kelompokStudiMultimediaList = kelompokStudiMultimediaService.findAll();
        modelMap.addAttribute("mulmedList", kelompokStudiMultimediaList);
        modelMap.addAttribute("menuMulmedClass", "active");

        return "mulmed-list-tile";
    }

    @RequestMapping(params = {"id"}, method = RequestMethod.GET)
    public String findById(@RequestParam("id") Integer id, ModelMap modelMap) throws SQLException {
        logger.debug("Request find by id multimedia study club");

        KelompokStudiMultimedia kelompokStudiMultimedia = kelompokStudiMultimediaService.findById(id);
        modelMap.addAttribute("mulmed", kelompokStudiMultimedia);
        modelMap.addAttribute("menuMulmedClass", "active");

        return "mulmed-data-tile";
    }

    @RequestMapping(value = "delete", params = {"id"}, method = RequestMethod.GET)
    public String delete(@RequestParam("id") Integer id, ModelMap modelMap) throws SQLException{
        logger.debug("Request delete multimedia study club");

        kelompokStudiMultimediaService.delete(id);

        return "redirect:/ksm";
    }
}
