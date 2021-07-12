/**
 * Copyright(C) 2021,  PhongNTHE140289.
 * J3LP0017
 * Photographer
 *
 * Record of change:
 * DATE            Version            AUTHOR               DESCRIPTION
 * 2021/06/18      <1.0>              PhongNTHE140289      Implemetation
 * 2021/06/19      <1.0>              PhongNTHE140289      Evaluation
 * 2021/06/20      <1.0>              PhongNTHE140289      Fix bug
 * 2021/06/21      <1.0>              PhongNTHE140289      Review 
 */
package listener;

import dao.NumberOfViewDAO;
import dao.impl.NumberOfViewDAOImpl;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * This class contains methods to receive notification when a session is created
 * or destroyed. This class use sessionCreated method to increase number of
 * website's view and get number of website's view from NumberOfViewDAOImpl object.
 *
 * @author PhongFPT
 */
public class SessionListener implements HttpSessionListener {

    /**
     * This method is invoked when session object is created. This method uses
     * increaseWebsiteView method from NumberOfViewDAOImpl object to increase website's view;
     * getWebsiteView method from NumberOfViewDAOImpl object to get website's view,
     * then uses session to store website's view.
     * 
     *
     * @param se It is a <code>javax.servlet.http.HttpSessionEvent</code>
     * object.
     */
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        try {
            NumberOfViewDAO numberOfViewDAO = new NumberOfViewDAOImpl();
            numberOfViewDAO.increaseWebsiteView();
            String numberOfView = String.format("%06d", numberOfViewDAO.getWebsiteView());
            HttpSession session = se.getSession();
            session.setAttribute("websiteView", numberOfView.toCharArray());
        } catch (Exception ex) {
            Logger.getLogger(SessionListener.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is invoked when session is invalidated.
     *
     * @param se It is a <code>javax.servlet.http.HttpSessionEvent</code>
     * object.
     */
    @Override
    public void sessionDestroyed(HttpSessionEvent se) {

    }
}
