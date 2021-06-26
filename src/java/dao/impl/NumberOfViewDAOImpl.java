/**
 * Copyright(C) 2021,  PhongNTHE140289.
 * J3LP0017
 * Photographer
 *
 * Record of change:
 * DATE            Version            AUTHOR               DESCRIPTION
 * 2021/06/18      <1.0>              PhongNTHE140289      Implementation
 * 2021/06/19      <1.0>              PhongNTHE140289      Evaluation
 * 2021/06/20      <1.0>              PhongNTHE140289      Fix bug
 * 2021/06/21      <1.0>              PhongNTHE140289      Review 
 */
package dao.impl;

import context.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.naming.NamingException;
import dao.NumberOfViewDAO;

/**
 * This class contains methods that implemented from NumberOfViewDAO to increase
 * website view, get website view from database. These methods will throw
 * <code>java.lang.Exception</code> object if there is any error occurs.
 *
 * @author PhongFPT
 */
public class NumberOfViewDAOImpl extends DBContext implements NumberOfViewDAO {

    /**
     * A parameterless constructor to initialize NumberOfViewDAOImpl object.
     * @throws NamingException 
     */
    public NumberOfViewDAOImpl() throws NamingException {
    }

    /**
     * A method to increase number of website view.
     *
     * @return number of affected rows after update in database.
     * @throws Exception
     */
    @Override
    public int increaseWebsiteView() throws Exception {
        Connection con = null;
        PreparedStatement ps = null;
        int rowAffected = -1;
        try {
            con = getConnection();
            String sqlQuery = "update AccessView set TotalView = TotalView + 1 where id = 1";
            ps = con.prepareStatement(sqlQuery);
            rowAffected = ps.executeUpdate();
        } catch (Exception ex) {
            throw ex;
        } finally {
            closePreparedStatement(ps);
            closeConnection(con);
        }

        return rowAffected;
    }

    /**
     * A method to get number of visitors to a website.
     *
     * @return number of website view. It is an int number.
     * @throws Exception
     */
    @Override
    public int getWebsiteView() throws Exception {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int accessView = -1;
        try {
            con = getConnection();
            String sqlQuery = "select TotalView from AccessView where id = 1";
            ps = con.prepareStatement(sqlQuery);
            rs = ps.executeQuery();
            while (rs.next()) {
                accessView = rs.getInt("TotalView");
            }

        } catch (Exception ex) {
            throw ex;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(ps);
            closeConnection(con);
        }

        return accessView;
    }

}
