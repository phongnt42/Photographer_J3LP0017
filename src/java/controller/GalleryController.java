/**
 * Copyright(C) 2021,  PhongNTHE140289.
 * J3LP0017 Photographer
 *
 * Record of change:
 * DATE            Version            AUTHOR               DESCRIPTION
 * 2021/06/18      <1.0>            PhongNTHE140289        Implementation 
 * 2021/06/19      <1.0>            PhongNTHE140289        Evaluation 
 * 2021/06/20      <1.0>            PhongNTHE140289        Fix bug
 * 2021/06/21      <1.0>            PhongNTHE140289        Review 
 * 2021/06/25      <1.0>            PhongNTHE140289        Fix comment
 */
package controller;

import dao.ContactDAO;
import dao.GalleryDAO;
import dao.ImageDAO;
import dao.impl.ContactDAOImpl;
import dao.impl.GalleryDAOImpl;
import dao.impl.ImageDAOImpl;
import entity.Contact;
import entity.Gallery;
import entity.Image;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This class contains <code>doGet</code> method to handle the HTTP
 * <code>GET</code> method. This class uses <code>GalleryDAOImpl</code> object
 * to get a gallery's information based on its ID and to get top 3 galleries;
 * <code>ImageDAOImpl</code> object to get list of images based on galleryID;
 * <code>ContactDAOImpl</code> object to get information of social sharing
 * pages. Then send these data to Gallery.jsp page. If there is any error
 * occurs, send error message to Error.jsp page.
 *
 * @author PhongFPT
 */
public class GalleryController extends HttpServlet {

    private final static int PAGE_NUMBER = 1;
    private final static int PAGE_SIZE = 8;

    /**
     * This method uses <code>GalleryDAOImpl</code> object to get a gallery's
     * information based on its ID and to get top 3 galleries;
     * <code>ImageDAOImpl</code> object to get list of images based on
     * galleryID; <code>ContactDAOImpl</code> object to get information of
     * social sharing pages. Then send these data to Gallery.jsp page. If there
     * is any error occurs, send error message to Error.jsp page. Handles the
     * HTTP <code>GET</code> method.
     *
     * @param request stores attributes: socialSharingPage, topGalleries, gallery,
     * currentPage, listImages, totalImagePage then send these data to
     * Gallery.jsp page. It is a
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
            // get social sharing page information
            ContactDAO contactDAO = new ContactDAOImpl();            
            Contact socialSharingPage = contactDAO.getSocialSharingPageInfo();
            request.setAttribute("socialSharingPage", socialSharingPage);
            // get top 3 galleries
            GalleryDAO galleryDAO = new GalleryDAOImpl();
            List<Gallery> topGalleries = galleryDAO.getTopGalleries(3);
            request.setAttribute("topGalleries", topGalleries);
            String raw_galleryID = request.getParameter("galleryID");
            int galleryID = Integer.parseInt(raw_galleryID);
            // get gallery by ID
            Gallery gallery = galleryDAO.getGalleryByID(galleryID);
            request.setAttribute("gallery", gallery);
            // get current image page number
            int pageNumber = request.getParameter("pageNumber") == null ? PAGE_NUMBER : Integer.parseInt(request.getParameter("pageNumber"));
            request.setAttribute("currentPage", pageNumber);
            // get list of images with pagination method
            ImageDAO imageDAO = new ImageDAOImpl();
            List<Image> listImages = imageDAO.listImages(galleryID, pageNumber, PAGE_SIZE);
            request.setAttribute("listImages", listImages);
            // total image page
            int totalImagePage = imageDAO.getTotalImagePage(galleryID, PAGE_SIZE);
            request.setAttribute("totalImagePage", totalImagePage);
            request.getRequestDispatcher("Gallery.jsp").forward(request, response);
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
