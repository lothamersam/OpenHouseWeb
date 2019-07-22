
package com.openhouse.factory;

import com.openhouse.daos.AboutDao;
import com.openhouse.daos.AuditionDao;
import com.openhouse.daos.BasicPageDao;
import com.openhouse.daos.StaffDao;

public final class DaoFactory {

    public static final StaffDao getStaffDao() {
        return STAFF_DAO_WRAPPER.staffDao;
    } 
    
    public static final AboutDao getAboutDao() {
        return ABOUT_DAO_WRAPPER.aboutDao;
    } 

    public static final AuditionDao getAuditionDao() {
        return AUDITION_DAO_WRAPPER.auditionDao;
    } 

    public static final BasicPageDao getPageDao() {
        return PAGE_DAO_WRAPPER.pageDao;
    } 

    private static final class PAGE_DAO_WRAPPER {
        private static BasicPageDao pageDao = new BasicPageDao();
    }
    
    private static final class AUDITION_DAO_WRAPPER {
        private static AuditionDao auditionDao = new AuditionDao();
    }
    
    private static final class ABOUT_DAO_WRAPPER {
        private static AboutDao aboutDao = new AboutDao();
    }

    private static final class STAFF_DAO_WRAPPER {
        private static StaffDao staffDao = new StaffDao();
    }
}