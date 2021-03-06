package com.kakadurf.cv4.framework.controller.servlet;

import com.kakadurf.cv4.domain.entities.FileEntity;
import com.kakadurf.cv4.domain.service.interfaces.FileHandlingService;
import com.kakadurf.cv4.framework.service.FileThrower;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.security.PermitAll;
import javax.servlet.http.HttpServletResponse;
@PermitAll
@Controller
public class FileManagingController {
    @Autowired
    FileHandlingService fileHandlingService;
    @Autowired
    FileThrower fileThrower;
    /*@PostMapping("/save_file")
    public String saveFile(@RequestParam("file") MultipartFile file){
        //file.getResource()
        fileHandlingService.saveFile(new MultipartFileFacade(file));
        return "redirect:/profile";
    }*/
    //TODO(rest)
    @GetMapping("/file/{fileName}")
    @ResponseBody
    public void getFile(@PathVariable("fileName") String fileName, HttpServletResponse response){
        FileEntity fileEntity;
        try {
            fileEntity = fileHandlingService.getFileByName(fileName);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        fileThrower.writeToResponse(fileEntity.getPath(), fileEntity.getType(), response);
    }
}
