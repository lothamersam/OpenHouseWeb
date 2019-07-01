package com.openhouse.services;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.openhouse.beans.StaffMemberTO;

public class ImageService {

    public String uploadImage(File image, StaffMemberTO staffMember) throws IOException {
        Cloudinary cloudinary = new Cloudinary(System.getenv("CLOUDINARY_URL"));

        Map result = cloudinary.uploader().upload(image, ObjectUtils.emptyMap());

        staffMember.setImagePath((String) result.get("url"));
        staffMember.setImagePublicId((String) result.get("public_id"));

        return staffMember;
    }

    public void deleteImage(String publicId) throws IOException {
        Cloudinary cloudinary = new Cloudinary(System.getenv("CLOUDINARY_URL"));

        cloudinary.uploader().destroy(publicId, ObjectUtils.emptyMap());
    }
}