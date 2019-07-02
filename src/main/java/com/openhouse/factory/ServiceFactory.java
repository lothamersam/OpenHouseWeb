
package com.openhouse.factory;

import com.openhouse.services.EmailService;
import com.openhouse.services.ImageService;
import com.openhouse.services.ParameterService;

public final class ServiceFactory {

    public static final EmailService getEmailService() {
        return EMAIL_SERVICE_WRAPPER.emailService;
    } 

    public static final ParameterService getParameterService() {
        return PARAMETER_SERVICE_WRAPPER.parameterService;
    }

    public static final ImageService getImageService() {
        return IMAGE_SERVICE_WRAPPER.imageService;
    }

    private static final class IMAGE_SERVICE_WRAPPER {
        private static ImageService imageService = new ImageService();
    }

    private static final class EMAIL_SERVICE_WRAPPER {
        private static EmailService emailService = new EmailService();
    }

    private static final class PARAMETER_SERVICE_WRAPPER {
        private static ParameterService parameterService = new ParameterService();
    }
}