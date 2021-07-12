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
package context;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * A class named DBContext. This class defines methods to connect with database
 * and close connection.
 *
 * @author PhongFPT
 */
public class DBContext {

    private final InitialContext initial;
    private final Context context;
    private final String image;
    private final String serverName;
    private final String dbName;
    private final String userName;
    private final String password;
    private final String portNumber;

    /**
     * Parameterless constructor for initializing DBContext object.
     *
     * @throws NamingException
     */
    public DBContext() throws NamingException {
        initial = new InitialContext();
        Object obj = initial.lookup("java:comp/env");
        context = (Context) obj;
        serverName = context.lookup("serverName").toString();
        dbName = context.lookup("dbName").toString();
        portNumber = context.lookup("portNumber").toString();
        image = context.lookup("image").toString();
        userName = context.lookup("username").toString();
        password = context.lookup("password").toString();
    }

    /**
     * Return a connection object to connect to database
     *
     * @return <code>java.sql.Connection</code> object.
     * @throws Exception
     */
    public Connection getConnection() throws Exception {
        String url = "jdbc:sqlserver://" + serverName + ":" + portNumber + ";databaseName=" + dbName;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        return DriverManager.getConnection(url, userName, password);
    }

    /**
     * Close connection
     *
     * @param con. It is a <code>java.sql.Connection</code> object.
     * @throws SQLException
     */
    public void closeConnection(Connection con) throws SQLException {
        if (con != null && !con.isClosed()) {
            con.close();
        }
    }

    /**
     * Close PreparedStatement
     *
     * @param ps. It is a <code>java.sql.PreparedStatement</code> object.
     * @throws SQLException
     */
    public void closePreparedStatement(PreparedStatement ps) throws SQLException {
        if (ps != null && !ps.isClosed()) {
            ps.close();
        }
    }

    /**
     * Close ResultSet
     *
     * @param rs. It is a <code>java.sql.ResultSet</code> object.
     * @throws SQLException
     */
    public void closeResultSet(ResultSet rs) throws SQLException {
        if (rs != null && !rs.isClosed()) {
            rs.close();
        }
    }

    /**
     * Return a path to image package
     *
     * @return a string represent a path to image package .It is a
     * <code>java.lang.String</code>.
     */
    public String getImagePath() {
        return image;
    }
}
