package com.kakadurf.cv4.domain.entities;

import java.io.File;

public interface RowFileData {
    long getSize();

    String getName();

    String getContentType();

    void transfer(File file);
}
