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

import entity.Image;
import java.util.List;

/**
 *
 * This class defines methods to get list of images, total of image page from
 * database. These methods will throw <code>java.lang.Exception</code> object if
 * there is any error occurs.
 *
 * @author PhongFPT
 */
public interface ImageDAO {

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
    List<Image> listImages(int galleryID, int pageNumber, int pageSize) throws Exception;

    /**
     * Calculating total of Image's page by galleryID.
     *
     * @param galleryID the ID of gallery. It is an int number.
     * @param pageSize number of images in page. It is an int number.
     * @return an int number of total page.
     * @throws Exception
     */
    public int getTotalImagePage(int galleryID, int pageSize) throws Exception;
}
