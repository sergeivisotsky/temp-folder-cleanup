package org.sergei.cleanup.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.File;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * @author Sergei Visotsky
 */
@Component
public class CleanupService {

    @Value("${file.tmp.folder}")
    private String filePath;

    @Scheduled(fixedDelay = 18_000_000)
    public void cleanFolder() {
        File fileFolder = new File(filePath);
        fileFolder.mkdir();

        File[] listFiles = fileFolder.listFiles();
        if (listFiles != null) {
            for (File file : listFiles) {
                if (LocalDateTime.now().minusDays(1)
                        .isAfter(LocalDateTime.from(new Date(file.lastModified()).toInstant().atZone(ZoneId.systemDefault())))) {
                    file.delete();
                }
            }
        }
    }
}
