package com.kakadurf.cv4.framework_presentation.controller;

import com.kakadurf.cv4.domain.db_interface.FileManager;
import com.kakadurf.cv4.domain.entities.FileEntity;
import com.kakadurf.cv4.domain.service.FileHandlingService;
import com.kakadurf.cv4.framework_presentation.data.MultipartFileFacade;
import com.kakadurf.cv4.framework_presentation.service.FileThrower;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

@Controller
public class FileManagingController {
    @Autowired
    FileHandlingService fileHandlingService;
    @Autowired
    FileThrower fileThrower;
    @PostMapping("/profile")
    public String saveFile(@RequestParam("file") MultipartFile file){
        fileHandlingService.saveFile(new MultipartFileFacade(file));
        return "redirect:/profile";
    }
    @GetMapping("/file/{fileName}")
    @ResponseBody
    public void saveFile(@PathVariable("fileName") String fileName, HttpServletResponse response){
        FileEntity fileEntity;
        try {
            fileEntity = fileHandlingService.getFile(fileName);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        fileThrower.writeToResponse(fileEntity.getPath(), fileEntity.getType(), response);
    }
}
