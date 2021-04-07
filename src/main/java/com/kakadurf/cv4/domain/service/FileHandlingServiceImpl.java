package com.kakadurf.cv4.domain.service;

import com.kakadurf.cv4.domain.datasource.FileSource;
import com.kakadurf.cv4.domain.entities.FileEntity;
import com.kakadurf.cv4.domain.entities.RowFileData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.Optional;
import java.util.UUID;

import static java.util.Objects.requireNonNull;

@Service
public class FileHandlingServiceImpl implements FileHandlingService{
    @Value("${project_meta.path}")
    private String path;
    @Autowired
    private FileSource filesRepository;
    @Override
    public void saveFile(RowFileData multipartFile) {
        String name = getNewFilename(requireNonNull(multipartFile.getName()));
        FileEntity info = FileEntity.builder()
                .size(multipartFile.getSize())
                .type(multipartFile.getContentType())
                .name(name)
                .path(path + File.separator + name)
                .oldName(multipartFile.getName())
                .build();
        filesRepository.save(info);
        System.out.println(new File("/files").getAbsoluteFile());
        File file = new File(path + File.separator + name);
        multipartFile.transfer(file);
    }
    private String getNewFilename(String originalFilename) {
        String[] strings = originalFilename.split("\\.");
        return UUID.randomUUID().toString() + "." + strings[strings.length - 1];
    }
    @Override
    public FileEntity getFile(String fileName) {
        Optional<FileEntity> fileInfo = filesRepository.getFileEntityByOldName(fileName);
        if (fileInfo.isPresent()) {
           return  fileInfo.get();
            /*if (fileInfo1.getOwner().getId().equals(userId) | fileInfo1.getReceiver().getId().equals(userId)) {
                return new String[]{path + File.separator + fileName, fileInfo1.getType(), fileInfo1.getOriginalFileName()};
            } else {
                throw new IllegalAccessException("Вы не имеете доступа к данным файлам");
            }*/
        } else {
            throw new IllegalArgumentException("Файл не найден");
        }
    }


}