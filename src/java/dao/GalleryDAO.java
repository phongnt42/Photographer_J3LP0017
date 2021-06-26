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
package dao;

import entity.Gallery;
import java.util.List;

/**
 *
 * This class defines methods to get gallery information, get top galleries, get
 * list of galleries, get number of gallery from database. These methods will throw 
 * <code>java.lang.Exception</code> object if there is any error occurs.
 *
 * @author PhongFPT
 */
public interface GalleryDAO {

    /**
     * A method to get gallery information by its ID from database
     *
     * @param galleryID the ID of a gallery. It is an int number.
     * @return <code>entity.Gallery</code> object.
     * @throws Exception
     */
    public Gallery getGalleryByID(int galleryID) throws Exception;

    /**
     * A method to get top gallery from database.
     *
     * @param numberGalleries Number of top galleries .It is an int number.
     * @return a list of <code>entity.Gallery</code> objects. It is a
     * <code>java.util.List</code>.
     * @throws Exception
     */
    public List<Gallery> getTopGalleries(int numberGalleries) throws Exception;

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
    public List<Gallery> listGalleries(int pageNumber, int pageSize) throws Exception;

    /**
     * Calculating total of Gallery's page.
     *
     * @param pageSize number of galleries in page. It is an int number.
     * @return an int number of total page.
     * @throws Exception
     */
    public int getTotalGalleryPage(int pageSize) throws Exception;
}
