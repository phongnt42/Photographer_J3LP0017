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

/**
 * This class defines methods to increase website view, get website view from
 * database. These methods will throw <code>java.lang.Exception</code> object if
 * there is any error occurs.
 *
 * @author PhongFPT
 */
public interface NumberOfViewDAO {

    /**
     * A method to increase number of website view.
     *
     * @return number of affected rows after update in database.
     * @throws Exception
     */
    public int increaseWebsiteView() throws Exception;

    /**
     * A method to get number of visitors to a website.
     *
     * @return number of website view. It is an int number.
     * @throws Exception
     */
    public int getWebsiteView() throws Exception;
}
