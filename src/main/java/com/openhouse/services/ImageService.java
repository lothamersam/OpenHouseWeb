package com.openhouse.services;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import com.cloudinary.Cloudinary;
import com.cloudinary.Transformation;
import com.cloudinary.utils.ObjectUtils;
import com.openhouse.beans.StaffMemberTO;

public class ImageService {

    @SuppressWarnings("rawtypes")
	public StaffMemberTO uploadImage(final File image, StaffMemberTO staffMember) throws IOException {
        if (staffMember != null) {
            if (image != null) {
                final Cloudinary cloudinary = new Cloudinary(System.getenv("CLOUDINARY_URL"));

                final Map result = cloudinary.uploader().upload(image, ObjectUtils.asMap(
                    "transformation", new Transformation().width(400).gravity("face").crop("fill").aspectRatio("1:1")
                ));

                staffMember.setImagePath((String) result.get("url"));
                staffMember.setImagePublicId((String) result.get("public_id"));
            } else {
                if (staffMember.getImagePath() == null) {
                    staffMember.setImagePath("/static/img/blank.png");
                    staffMember.setImagePublicId("blank");
                }
            }
        } else {
            staffMember = new StaffMemberTO();
        }

        return staffMember;
    }

    public void deleteImage(String publicId) throws IOException {
        if (publicId != null && !"blank".equals(publicId)){
            Cloudinary cloudinary = new Cloudinary(System.getenv("CLOUDINARY_URL"));
            
            cloudinary.uploader().destroy(publicId, ObjectUtils.emptyMap());
        }
    }
}