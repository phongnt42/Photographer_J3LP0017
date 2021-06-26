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

import entity.Contact;

/**
 * This class defines method to get photographer's contact information from
 * database. This method will throws <code>java.lang.Exception</code> object if
 * there is any error occurs.
 *
 * @author PhongFPT
 */
public interface ContactDAO {

    /**
     * A method to get photographer's contact information from database.
     *
     * @return <code>entity.Contact</code> object.
     * @throws Exception
     */
    public Contact getContact() throws Exception;
}
