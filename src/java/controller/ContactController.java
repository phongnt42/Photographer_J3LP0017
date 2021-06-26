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
 * 2021/06/25      <1.0>              PhongNTHE140289      Fix comment 
 */
package controller;

import dao.ContactDAO;
import dao.GalleryDAO;
import dao.impl.ContactDAOImpl;
import dao.impl.GalleryDAOImpl;
import entity.Contact;
import entity.Gallery;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This class contains doGet method to handle HTTP GET request from client. This
 * class uses getContact method to get photographer's contact information from
 * ContactDAOImpl object; getTopGalleries method to get top 3 gallery from
 * GalleryDAOImpl object. Then send these data to Contact.jsp page. If there is
 * any error occurs, send error message to Error.jsp page.
 *
 * @author PhongFPT
 */
public class ContactController extends HttpServlet {

    /**
     * This method uses getContact method to get photographer's contact
     * information from ContactDAOImpl object; getTopGalleries method to get top
     * 3 gallery from GalleryDAOImpl object. Then send these data to Contact.jsp
     * page. If there is any error occurs, send error message to Error.jsp page.
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request stores attributes: accessView, contact, topGalleries then
     * send these data to Contact.jsp page. It is a
     * <code>javax.servlet.http.HttpServletRequest</code>object.
     *
     * @param response assists a servlet to send a response of HTTP request to
     * client's web browser. It is a
     * <code>javax.servlet.http.HttpServletResponse</code>object.
     *
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            // get photographer's contact
            ContactDAO contactDAO = new ContactDAOImpl();
            Contact contact = contactDAO.getContact();
            request.setAttribute("contact", contact);
            // get top 3 galleries
            GalleryDAO galleryDAO = new GalleryDAOImpl();
            List<Gallery> topGalleries = galleryDAO.getTopGalleries(3);
            request.setAttribute("topGalleries", topGalleries);
            request.getRequestDispatcher("Contact.jsp").forward(request, response);
        } catch (Exception ex) {
            request.setAttribute("error", ex);
            request.getRequestDispatcher("Error.jsp").forward(request, response);
            Logger.getLogger(GalleryController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
