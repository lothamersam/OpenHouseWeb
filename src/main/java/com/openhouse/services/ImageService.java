package com.openhouse.services;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

public class ImageService {

    public String uploadImage(File image) throws IOException {
        Cloudinary cloudinary = new Cloudinary(System.getenv("CLOUDINARY_URL"));

        Map result = cloudinary.uploader().upload(image, ObjectUtils.emptyMap());

        return (String) result.get("url");
    }
}