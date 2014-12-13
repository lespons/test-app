package by.test.controller.rest.file;

import by.test.dto.File;
import by.test.service.file.IFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collection;

/**
 * Created by lespons on 11.12.14.
 */

@RequestMapping(value = "/rest/file/")
@Controller
public class FileRestController {

    @Autowired
    private IFileService fileService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public
    @ResponseBody
    Collection<File> listByParent(@RequestParam(value = "id") String id) {
        return fileService.listByParent(id);
    }
}
