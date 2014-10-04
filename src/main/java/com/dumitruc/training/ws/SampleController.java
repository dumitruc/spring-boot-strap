package com.dumitruc.training.ws;

/**
 * User: dumitruc
 * Date: 03/10/14
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@Controller
@EnableAutoConfiguration
@ImportResource("classpath*:/cucumber.xml")
public class SampleController {

    @Autowired
    Person dima;

    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ResponseBody
    String postHome(@RequestBody String name) {
        System.out.println(name+" posted something!");

        dima.setName(name);
        System.out.println("WS dima = " + dima);
        return String.format("Hello %s!",name);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    String getHome(@RequestBody String name) {
        System.out.println(name+" got something!");

        return String.format("Hello %s!",name);
    }


}