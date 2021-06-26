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
import dao.GalleryDAO;
import entity.Gallery;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;

/**
 * This class contains methods that implemented from GalleryDAO to get list
 * of images, total of image page from database. These methods will throw an
 * object of <code>java.lang.Exception</code> class if there is any error occurs.
 *
 * @author PhongFPT
 */
public class GalleryDAOImpl extends DBContext implements GalleryDAO {

    /**
     * A parameterless constructor to initialize GalleryDAOImpl object.
     * @throws NamingException 
     */
    public GalleryDAOImpl() throws NamingException {
    }

    /**
     * A method to get gallery information by its ID from database
     *
     * @param galleryID the ID of a gallery. It is an int number.
     * @return <code>entity.Gallery</code> object.
     * @throws Exception
     */
    @Override
    public Gallery getGalleryByID(int galleryID) throws Exception {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Gallery gallery = null;
        try {
            con = getConnection();
            String sqlQuery = "select * from [Gallery] where id = ?";
            ps = con.prepareStatement(sqlQuery);
            ps.setInt(1, galleryID);
            rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("ID");
                String name = rs.getString("Name");
                String mainImage = getImagePath() + rs.getString("MainImage");
                String description = rs.getString("Description");
                gallery = new Gallery(id, name, mainImage, description);
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(ps);
            closeConnection(con);
        }
        return gallery;
    }

    /**
     * A method to get top gallery from database.
     *
     * @param numberGalleries Number of top galleries .It is an int number.
     * @return a list of <code>entity.Gallery</code> objects. It is a
     * <code>java.util.List</code>.
     * @throws Exception
     */
    @Override
    public List<Gallery> getTopGalleries(int numberGalleries) throws Exception {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Gallery> galleries = null;

        try {
            galleries = new ArrayList<>();
            con = getConnection();
            String sqlQuery = "SELECT TOP (?) * "
                    + "FROM [gallery]";
            ps = con.prepareStatement(sqlQuery);
            ps.setInt(1, numberGalleries);
            rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("ID");
                String name = rs.getString("Name");
                String mainImage = rs.getString("MainImage");
                String description = rs.getString("Description");
                galleries.add(new Gallery(id, name, mainImage, description));
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(ps);
            closeConnection(con);
        }
        return galleries;
    }

    /**
     *
     * A method to get list of galleries from database, processes pagination
     * method.
     *
     * @param pageNumber page number .It is an int number.
     * @param pageSize number of galleries in page. It is an int number.
     * @return a list of <code>entity.Gallery</code> objects. It is a
     * <code>java.util.List</code>.
     * @throws Exception
     */
    @Override
    public List<Gallery> listGalleries(int pageNumber, int pageSize) throws Exception {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Gallery> galleries = null;

        int offset = (pageNumber - 1) * pageSize;
        try {
            galleries = new ArrayList<>();
            con = getConnection();
            String sqlQuery = "SELECT * FROM [Gallery]"
                    + " ORDER BY ID"
                    + " OFFSET ? ROWS"
                    + " FETCH NEXT ? ROWS ONLY";
            ps = con.prepareStatement(sqlQuery);
            ps.setInt(1, offset);
            ps.setInt(2, pageSize);
            rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("ID");
                String name = rs.getString("Name");
                String mainImage = getImagePath() + rs.getString("MainImage");
                String description = rs.getString("Description");
                galleries.add(new Gallery(id, name, mainImage, description));
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(ps);
            closeConnection(con);
        }

        return galleries;
    }

    /**
     * Calculating total of Gallery's page.
     *
     * @param pageSize number of galleries in page. It is an int number.
     * @return an int number of total page.
     * @throws Exception
     */
    @Override
    public int getTotalGalleryPage(int pageSize) throws Exception {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int totalPage = 0;
        try {
            con = getConnection();
            String sqlQuery = "select count(id) from [Gallery]";
            ps = con.prepareStatement(sqlQuery);
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
