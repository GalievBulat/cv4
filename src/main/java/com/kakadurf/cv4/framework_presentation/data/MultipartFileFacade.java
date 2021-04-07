package com.kakadurf.cv4.framework_presentation.data;

import com.kakadurf.cv4.domain.entities.RowFileData;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

public class MultipartFileFacade implements RowFileData {
    private MultipartFile multipartFile;
    public MultipartFileFacade(MultipartFile file){
        multipartFile = file;
    }
    @Override
    public String getName() {
        return multipartFile.getOriginalFilename();
    }
    @Override
    public long getSize() {
        return multipartFile.getSize();
    }
    @Override
    public String getContentType() {
        return multipartFile.getContentType();
    }
    @Override
    public void transfer(File file){
        try {
            multipartFile.transferTo(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
