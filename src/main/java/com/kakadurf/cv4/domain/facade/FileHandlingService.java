package com.kakadurf.cv4.domain.facade;

import com.kakadurf.cv4.data.db.FileManager;
import com.kakadurf.cv4.domain.FileEntity;
import org.apache.tomcat.jni.FileInfo;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Service
public class FileHandlingService{
    private FileManager filesRepository;
    private String path;
    private String serverAddress;

    /*public FileServiceImpl(String filePath, String serverAddress, FilesRepository filesRepository) {
        this.serverAddress = serverAddress;
        this.path = filePath;
        this.filesRepository = filesRepository;
    }*/

    public void saveFile(MultipartFile multipartFile) {
        String name = getNewFilename(Objects.requireNonNull(multipartFile.getOriginalFilename()));
        FileEntity info = FileEntity.builder()
                .size(multipartFile.getSize())
                .type(multipartFile.getContentType())
                .name(name).build();
                //.url(serverAddress + name).build();
        File file = new File(path + File.separator + name);
        try {
            multipartFile.transferTo(file);
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
        filesRepository.save(info);
        //return FileDto.builder().originalName(info.getOriginalFileName()).size(info.getSize()).url(info.getUrl()).build();
    }

    private String getNewFilename(String originalFilename) {
        String[] strings = originalFilename.split("\\.");
        return UUID.randomUUID().toString() + "." + strings[strings.length - 1];
    }

 /*   public String[] getFile(String fileName, Long userId) throws IllegalAccessException {
        //Optional<FileInfo> fileInfo = filesRepository.(fileName);
       *//* if (fileInfo.isPresent()) {
            FileInfo fileInfo1 = fileInfo.get();
            if (fileInfo1.getOwner().getId().equals(userId) | fileInfo1.getReceiver().getId().equals(userId)) {
                return new String[]{path + File.separator + fileName, fileInfo1.getType(), fileInfo1.getOriginalFileName()};
            } else {
                throw new IllegalAccessException("Вы не имеете доступа к данным файлам");
            }
        } else {
            throw new IllegalArgumentException("Файл не найден");
        }*//*
    }*/

    /*public void writeToResponse(String[] arguments, HttpServletResponse httpServletResponse) {
        try (InputStream inputStream = new FileInputStream(new File(arguments[0]));) {
            httpServletResponse.setContentType(arguments[1]);
            httpServletResponse.setHeader("Content-Disposition", "attachment; filename=\" " + arguments[2] + "\"");
            IOUtils.copy(inputStream, httpServletResponse.getOutputStream());
            httpServletResponse.getOutputStream().flush();
            httpServletResponse.getOutputStream().close();
        } catch (IOException e) {
            throw new IllegalStateException("Something went wrong while delivering file");
        }
    }*/
}