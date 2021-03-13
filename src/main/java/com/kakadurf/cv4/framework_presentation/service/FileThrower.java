package com.kakadurf.cv4.framework_presentation.service;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
@Component
public class FileThrower {
    public void writeToResponse(String path, String type, HttpServletResponse httpServletResponse) {
        try (InputStream inputStream = new FileInputStream(new File(path))) {
            httpServletResponse.setContentType(type);
            //httpServletResponse.setHeader("Content-Disposition", "attachment; filename=\" " + arguments[2] + "\"");
            IOUtils.copy(inputStream, httpServletResponse.getOutputStream());
            httpServletResponse.getOutputStream().flush();
            httpServletResponse.getOutputStream().close();
        } catch (IOException e) {
            throw new IllegalStateException("Something went wrong while delivering file");
        }
    }
}
