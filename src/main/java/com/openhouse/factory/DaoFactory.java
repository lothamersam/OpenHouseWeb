
package com.openhouse.factory;

import com.openhouse.daos.AuditionDao;
import com.openhouse.daos.BasicPageDao;
import com.openhouse.daos.DateDao;
import com.openhouse.daos.StaffDao;
import com.openhouse.daos.UserDao;

public final class DaoFactory {

    public static final StaffDao getStaffDao() {
        return StaffDaoWrapper.staffDao;
    } 
    
    public static final AuditionDao getAuditionDao() {
        return AuditionDaoWrapper.auditionDao;
    } 

    public static final BasicPageDao getPageDao() {
        return PageDaoWrapper.pageDao;
    } 
    
    public static final DateDao getDateDao() {
        return DateDaoWrapper.dateDao;
    } 
    
    public static final UserDao getUserDao() {
        return UserDaoWrapper.userDao;
    } 

    private DaoFactory() {
        throw new UnsupportedOperationException("Do not instantiate!");
    }

    private static final class UserDaoWrapper {
        private static UserDao userDao = new UserDao();
    }

    private static final class DateDaoWrapper {
        private static DateDao dateDao = new DateDao();
    }

    private static final class PageDaoWrapper {
        private static BasicPageDao pageDao = new BasicPageDao();
    }
    
    private static final class AuditionDaoWrapper {
        private static AuditionDao auditionDao = new AuditionDao();
    }

    private static final class StaffDaoWrapper {
        private static StaffDao staffDao = new StaffDao();
    }
}