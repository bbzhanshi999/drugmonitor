package com.simlink.common.utils;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Administrator on 2016/9/19 0019.
 */
public class BooleanTypeHandler implements TypeHandler {

    /* (non-Javadoc)
     * @see org.apache.ibatis.type.TypeHandler#getResult(java.sql.ResultSet, java.lang.String)
     */

    public Object getResult(ResultSet arg0, String arg1) throws SQLException {
        String str = arg0.getString(arg1);
        Boolean rt = Boolean.FALSE;
        if (str.equalsIgnoreCase("1")){
            rt = Boolean.TRUE;
        }
        return rt;
    }

    public Object getResult(ResultSet resultSet, int i) throws SQLException {
        return null;
    }

    /* (non-Javadoc)
     * @see org.apache.ibatis.type.TypeHandler#getResult(java.sql.CallableStatement, int)
     */

    public Object getResult(CallableStatement arg0, int arg1)
            throws SQLException {
        Boolean b = arg0.getBoolean(arg1);
        return b == true ? "1" : "0";
    }

    /* (non-Javadoc)
     * @see org.apache.ibatis.type.TypeHandler#setParameter(java.sql.PreparedStatement, int, java.lang.Object, org.apache.ibatis.type.JdbcType)
     */
    public void setParameter(PreparedStatement arg0, int arg1, Object arg2,
                             JdbcType arg3) throws SQLException {
        Boolean b = (Boolean) arg2;
        String value = (Boolean) b == true ? "1" : "0";
        arg0.setString(arg1, value);
    }
}
