
package com.openhouse.factory;

import com.openhouse.daos.StaffDao;

public final class DaoFactory {

    public static final StaffDao getStaffDao() {
        return STAFF_DAO_WRAPPER.staffDao;
    } 

    private static final class STAFF_DAO_WRAPPER {
        private static StaffDao staffDao = new StaffDao();
    }
}