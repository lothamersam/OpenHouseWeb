
package com.openhouse.factory;

import com.openhouse.daos.AuditionDao;
import com.openhouse.daos.BasicPageDao;
import com.openhouse.daos.DateDao;
import com.openhouse.daos.StaffDao;

public final class DaoFactory {

    public static final StaffDao getStaffDao() {
        return STAFF_DAO_WRAPPER.staffDao;
    } 
    
    public static final AuditionDao getAuditionDao() {
        return AUDITION_DAO_WRAPPER.auditionDao;
    } 

    public static final BasicPageDao getPageDao() {
        return PAGE_DAO_WRAPPER.pageDao;
    } 
    
    public static final DateDao getDateDao() {
        return DATE_DAO_WRAPPER.dateDao;
    } 

    private static final class DATE_DAO_WRAPPER {
        private static DateDao dateDao = new DateDao();
    }

    private static final class PAGE_DAO_WRAPPER {
        private static BasicPageDao pageDao = new BasicPageDao();
    }
    
    private static final class AUDITION_DAO_WRAPPER {
        private static AuditionDao auditionDao = new AuditionDao();
    }

    private static final class STAFF_DAO_WRAPPER {
        private static StaffDao staffDao = new StaffDao();
    }
}