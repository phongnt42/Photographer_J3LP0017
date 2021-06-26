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
import dao.ImageDAO;
import entity.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;

/**
 * This class contains methods that implemented from ImageDAO to get list of
 * images, total of image page from database. These methods will throw an object
 * of <code>java.lang.Exception</code> class if there is any error occurs.
 *
 * @author PhongFPT
 */
public class ImageDAOImpl extends DBContext implements ImageDAO {

    /**
     * A parameterless constructor to initialize ImageDAOImpl object.
     * @throws NamingException 
     */
    public ImageDAOImpl() throws NamingException {
    }

    /**
     * A method to get list of images from database by galleryID, processes
     * pagination method.
     *
     * @param galleryID the ID of gallery. It is an int number.
     * @param pageNumber page number .It is an int number.
     * @param pageSize number of images in page. It is an int number.
     * @return a list of <code>entity.Image</code> objects. It is a
     * <code>java.util.List</code>.
     * @throws Exception
     */
    @Override
    public List<Image> listImages(int galleryID, int pageNumber, int pageSize) throws Exception {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Image> images = null;

        int offset = (pageNumber - 1) * pageSize;
        try {
            images = new ArrayList<>();
            con = getConnection();
            String sqlQuery = "SELECT * FROM [Image]"
                    + " WHERE [galleryID] = ? "
                    + " ORDER BY ID"
                    + " OFFSET ? ROWS"
                    + " FETCH NEXT ? ROWS ONLY";
            ps = con.prepareStatement(sqlQuery);
            ps.setInt(1, galleryID);
            ps.setInt(2, offset);
            ps.setInt(3, pageSize);
            rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("ID");
                String url = getImagePath() + rs.getString("Url");
                images.add(new Image(id, url, galleryID));
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(ps);
            closeConnection(con);
        }

        return images;
    }

    /**
     * Calculating total of Image's page by galleryID.
     *
     * @param galleryID the ID of gallery. It is an int number.
     * @param pageSize number of images in page. It is an int number.
     * @return an int number of total page.
     * @throws Exception
     */
    @Override
    public int getTotalImagePage(int galleryID, int pageSize) throws Exception {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int totalPage = 0;
        try {
            con = getConnection();
            String sqlQuery = "select count(id) from [Image] where [galleryID] = ?";
            ps = con.prepareStatement(sqlQuery);
            ps.setInt(1, galleryID);
            rs = ps.executeQuery();
            while (rs.next()) {
                int totalRecord = rs.getInt(1);
                totalPage = (totalRecord + pageSize - 1) / pageSize;
            }

        } catch (Exception ex) {
            throw ex;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(ps);
            closeConnection(con);
        }

        return totalPage;
    }

}
