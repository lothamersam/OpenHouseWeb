
package com.openhouse.factory;

import com.openhouse.services.EmailService;
import com.openhouse.services.ImageService;
import com.openhouse.services.ParameterService;

public final class ServiceFactory {
    private ServiceFactory() {
        throw new UnsupportedOperationException("Do not instantiate");
    }

    public static EmailService getEmailService() {
        return EmailServiceWrapper.emailService;
    } 

    public static ParameterService getParameterService() {
        return ParameterServiceWrapper.parameterService;
    }

    public static ImageService getImageService() {
        return ImageServiceWrapper.imageService;
    }

    private static final class ImageServiceWrapper {
        private static ImageService imageService = new ImageService();
    }

    private static final class EmailServiceWrapper {
        private static EmailService emailService = new EmailService();
    }

    private static final class ParameterServiceWrapper {
        private static ParameterService parameterService = new ParameterService();
    }
}