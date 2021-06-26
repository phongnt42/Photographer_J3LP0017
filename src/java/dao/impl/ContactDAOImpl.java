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
import dao.ContactDAO;
import entity.Contact;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.naming.NamingException;

/**
 * This class contains method that implemented from ContactDAO. This method gets
 * photographer's contact information from database and throws
 * <code>java.lang.Exception</code> object if there is any error occurs.
 *
 * @author PhongFPT
 */
public class ContactDAOImpl extends DBContext implements ContactDAO {

    /**
     * A parameterless constructor to initialize ContactDAOImpl object.
     * 
     * @throws NamingException 
     */
    public ContactDAOImpl() throws NamingException {
    }

    /**
     * A method to get photographer's contact information from
     * database.
     *
     * @return <code>entity.Contact</code> object.
     * @throws Exception
     */
    @Override
    public Contact getContact() throws Exception {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Contact contact = null;
        try {
            con = getConnection();
            String sqlQuery = "select TOP(1) * from [contact]";
            ps = con.prepareStatement(sqlQuery);
            rs = ps.executeQuery();
            while (rs.next()) {
                contact = new Contact();
                contact.setAboutMe(rs.getString("AboutMe"));
                contact.setContactImage(getImagePath() + rs.getString("ContactImage"));
                contact.setAddress(rs.getString("Address"));
                contact.setCity(rs.getString("City"));
                contact.setCountry(rs.getString("Country"));
                contact.setTelephone(rs.getString("Telephone"));
                contact.setEmail(rs.getString("Email"));
                contact.setMapLocationUrl(rs.getString("MapLocationUrl"));
                contact.setFacebookUrl(rs.getString("FacebookUrl"));
                contact.setTwitterUrl(rs.getString("TwitterUrl"));
                contact.setGoogleUrl(rs.getString("GoogleUrl"));
                contact.setIconFacebook(getImagePath() + rs.getString("IconFacebook"));
                contact.setIconTwitter(getImagePath() + rs.getString("IconTwitter"));
                contact.setIconGoogle(getImagePath() + rs.getString("IconGoogle"));
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(ps);
            closeConnection(con);
        }
        return contact;
    }

}
