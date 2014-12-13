package by.test.controller;

import by.test.service.file.IFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * Created by lespons on 11.12.14.
 */
@Controller
public class MainController {

    @Autowired
    IFileService folderService;

    @RequestMapping(value = "/")
    public String process() {
        return "index";
    }
}
