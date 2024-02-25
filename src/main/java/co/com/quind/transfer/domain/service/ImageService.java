package co.com.quind.transfer.domain.service;

import jakarta.annotation.Resource;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.core.io.UrlResource;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

public class ImageService {

    private static final String UPLOAD_DIR = "uploads";
    public boolean saveImage(String fileName, MultipartFile multipartFile){

            Path routeFile = Paths.get(System.getProperty("user.dir"), UPLOAD_DIR, fileName+".png");
            try (InputStream inputStream = multipartFile.getInputStream()) {
                Files.copy(inputStream, routeFile, StandardCopyOption.REPLACE_EXISTING);
                return true;
            } catch (IOException e) {
                e.printStackTrace();
                return false;
           }
    }

    public UrlResource getImage(String idImg){
        Path routeFile = Paths.get(System.getProperty("user.dir"), UPLOAD_DIR, idImg+".png");
        UrlResource recurso =null;
        try {
            recurso = new UrlResource(routeFile.toUri());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        return recurso;
    }
}
