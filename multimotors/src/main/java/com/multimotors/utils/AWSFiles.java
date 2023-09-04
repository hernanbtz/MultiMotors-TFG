package com.multimotors.utils;

import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.GetObjectRequest;
import software.amazon.awssdk.services.s3.model.GetObjectResponse;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;
import software.amazon.awssdk.core.ResponseInputStream;
import software.amazon.awssdk.core.exception.SdkException;

import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.s3.model.PutObjectResponse;
import software.amazon.awssdk.services.s3.model.S3Exception;

/**
 * @author Fabian
 * @author Sergio
 */
public class AWSFiles {
    
    private final Region region;
    private final String bucketName;
    private final S3Client s3Client;
    private final String accessKeyId;
    private final String secretAccessKey;
    
    public AWSFiles() {
    
        this.region = Region.EU_NORTH_1;
        this.bucketName = "multimotors-images";
        this.accessKeyId = "AKIA6KR5QVINH4R4QWUH";
        this.secretAccessKey = "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";
        
        AwsBasicCredentials credentials = AwsBasicCredentials.create(accessKeyId, secretAccessKey);
        s3Client = S3Client.builder()
                .region(region)
                .credentialsProvider(StaticCredentialsProvider.create(credentials))
                .build();
    }
    
    public void uploadImage(String filePath, String objectKey){
        try {
            PutObjectRequest putObjectRequest = PutObjectRequest.builder()
                    .bucket(bucketName)
                    .key(objectKey)
                    .build();

            PutObjectResponse putObjectResponse = s3Client.putObject(putObjectRequest, Paths.get(filePath));
            
            int statusCode = putObjectResponse.sdkHttpResponse().statusCode();
            
            if (statusCode == 200) {
                System.out.println("Imagen subida correctamente a Amazon S3");
            } else {
                System.err.println("Error al subir la imagen a Amazon S3. Código de estado: " + statusCode);
            }
        } catch (S3Exception e) {
            System.err.println("Error al subir la imagen a Amazon S3: " + e.getMessage());
        }
    }
    
    public List<BufferedImage> downloadImages( List<String> objectKeys){
                
        List<BufferedImage> downloadedImages = new ArrayList<>();
        
        try {            
            List<CompletableFuture<Void>> downloadFutures = objectKeys.stream()
                .map(objectKey -> CompletableFuture.runAsync(() -> {
                    BufferedImage image = downloadImage(objectKey);
                    if (image != null) {
                        synchronized (downloadedImages) {
                            downloadedImages.add(image);
                        }
                    }
                }))
                .collect(Collectors.toList());

            CompletableFuture.allOf(downloadFutures.toArray(new CompletableFuture[0])).get();
            
            System.out.println("Todas las imágenes se descargaron exitosamente desde Amazon S3");
            
            return downloadedImages;
            
        } catch (InterruptedException | ExecutionException e) {
            System.err.println("Error al descargar las imágenes desde Amazon S3: " + e.getMessage());
            return null;
        }
    }
    
    private BufferedImage downloadImage(String objectKey) {
        try {
            GetObjectRequest getObjectRequest = GetObjectRequest.builder()
                    .bucket(bucketName)
                    .key(objectKey)
                    .build();

            ResponseInputStream<GetObjectResponse> getObjectResponse = s3Client.getObject(getObjectRequest);
            
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = getObjectResponse.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }

            byte[] imageBytes = outputStream.toByteArray();
            ByteArrayInputStream inputStream = new ByteArrayInputStream(imageBytes);
            
            return  ImageIO.read(inputStream);
            
        } catch (S3Exception | IOException e) {
            System.err.println("Error al descargar la imagen " + objectKey + " desde Amazon S3: " + e.getMessage());
            return null;
        }
    }
    
    public boolean downloadExcel(String objectKey, String downloadPath) {
        try {            
            GetObjectRequest getObjectRequest = GetObjectRequest.builder()
                    .bucket(bucketName)
                    .key(objectKey)
                    .build();

            ResponseInputStream<GetObjectResponse> getObjectResponse = s3Client.getObject(getObjectRequest);

            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = getObjectResponse.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }

            byte[] excelBytes = outputStream.toByteArray();

            File excelFile = new File(downloadPath);
            try (FileOutputStream fileOutputStream = new FileOutputStream(excelFile)) {
                fileOutputStream.write(excelBytes);
            }
            return true;
            
        } catch (SdkException | IOException e) {
            System.err.println("Error al descargar el archivo " + objectKey + " desde Amazon S3: " + e.getMessage());
        }
        return false;
    }
    
    public byte[] downloadPDF(String objectKey) {
        try {            
            GetObjectRequest getObjectRequest = GetObjectRequest.builder()
                    .bucket(bucketName)
                    .key(objectKey)
                    .build();

            ResponseInputStream<GetObjectResponse> getObjectResponse = s3Client.getObject(getObjectRequest);         
            
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = getObjectResponse.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
            return outputStream.toByteArray();
                     
        } catch (SdkException | IOException e) {
            System.err.println("Error al descargar el archivo " + objectKey + " desde Amazon S3: " + e.getMessage());
            return null;
        }
    }
}