import java.sql.Date;
import java.sql.PreparedStatement;


import java.sql.PreparedStatement;
import java.sql.SQLException;


/**
 * Created by Administrator on 2017/4/13 0013.
 */
public class PreparedStatementWrapper {
    private String billId;

    public String getOrgan() {
        return organ;
    }

    public String getArea() {
        return area;
    }

    private String organ;
    private String area;
    private Date acceptDate;
    public PreparedStatement getStatement() {
        return statement;
    }

    public String getBillId() {
        return billId;
    }

    public Date getAcceptDate() {
        return acceptDate;
    }

    private PreparedStatement statement;
    public PreparedStatementWrapper(PreparedStatement preparedStatement){
        statement = preparedStatement;
    }

    public void setString(int i,String str) throws SQLException {
        statement.setString(i,str);
        if(i==1){
            billId = str;
        }
        if(i==4)organ = str;
        if(i==5)area = str;
    }

    public void setDate(int i ,Date date) throws SQLException {
        statement.setDate(i,date);
        if(i ==2) acceptDate = date;
    }

    public void setDouble(int i ,double x) throws SQLException {
        statement.setDouble(i,x);
    }

    public void setInt(int i, int i1) throws SQLException {
        statement.setInt(i,i1);
    }
}
