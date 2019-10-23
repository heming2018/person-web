package cn.heming.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author heming
 * @date 2019-07-01 00:35
 * @description TODO
 */
@Controller
@RequestMapping("")
public class HomeController {

    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    @RequestMapping("")
    public String index() {
        return "home";
    }

}