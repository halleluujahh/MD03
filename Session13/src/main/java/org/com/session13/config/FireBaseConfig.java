package org.com.session13.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@Configuration
public class FireBaseConfig {
    private final String serviceAccountKeyPath = "D:\\PT-HN\\MD3-JavaBeFunda\\Session13\\src\\main\\webapp\\resources\\firebase.json";

    @Bean
    public Storage storage() throws IOException {
        InputStream serviceAccount = new FileInputStream(serviceAccountKeyPath);
        return (Storage) StorageOptions.newBuilder().setCredentials(GoogleCredentials.fromStream(serviceAccount)).build().getService();
    }
}
