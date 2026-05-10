package com.phegondev.phegnhotel.service;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.phegondev.phegnhotel.exception.OurException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@Service
public class CloudinaryService {

    private final Cloudinary cloudinary;

    public CloudinaryService(
            @Value("${cloudinary.cloud_name}") String cloudName,
            @Value("${cloudinary.api_key}") String apiKey,
            @Value("${cloudinary.api_secret}") String apiSecret) {
        this.cloudinary = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", cloudName,
                "api_key", apiKey,
                "api_secret", apiSecret));
    }

    public String saveImageToCloudinary(MultipartFile photo) {
        try {
            Map uploadResult = cloudinary.uploader().upload(photo.getBytes(), ObjectUtils.emptyMap());
            return uploadResult.get("secure_url").toString();
        } catch (Exception e) {
            e.printStackTrace();
            throw new OurException("Unable to upload image to Cloudinary: " + e.getMessage());
        }
    }
}
