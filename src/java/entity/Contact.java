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
package entity;

/**
 * This class defines a Contact object. It contains constructor to initialize
 * object; getter to get object attribute and setter to set object attribute.
 *
 * @author Nguyen The Phong
 */
public class Contact {   
    private String aboutMe;
    private String contactImage;
    private String address;
    private String city;
    private String country;
    private String telephone;
    private String email; 
    private String mapLocationUrl;    
    private String facebookUrl;
    private String twitterUrl;
    private String googleUrl;
    private String iconFacebook;
    private String iconTwitter;
    private String iconGoogle;

    /**
     *  Parameterless constructor for initializing Contact object.
     *
     */
    public Contact() {
    }

    /**
     * A parameterized constructor to initialize Contact object
     * 
     * @param aboutMe a short introduction about the photographer. It is a <code>java.lang.String</code> object.
     * @param contactImage the image of the photographer. It is a <code>java.lang.String</code> object.
     * @param address the address of the photographer. It is a <code>java.lang.String</code> object.
     * @param city the city of the photographer. It is a <code>java.lang.String</code> object.
     * @param country the country of the photographer. It is a <code>java.lang.String</code> object.
     * @param telephone the telephone of the photographer. It is a <code>java.lang.String</code> object.
     * @param email the email of the photographer. It is a <code>java.lang.String</code> object.
     * @param mapLocationUrl the map location URL of the photographer. It is a <code>java.lang.String</code> object.
     * @param facebookUrl the facebook URL. It is a <code>java.lang.String</code> object.
     * @param twitterUrl the twitter URL. It is a <code>java.lang.String</code> object.
     * @param googleUrl the google URL. It is a <code>java.lang.String</code> object.
     * @param iconFacebook facebook's icon image It is a <code>java.lang.String</code> object.
     * @param iconTwitter twitter's icon image. It is a <code>java.lang.String</code> object.
     * @param iconGoogle google's icon image. It is a <code>java.lang.String</code> object. 
     */
    public Contact(String aboutMe, String contactImage, String address, String city, String country, String telephone, String email, String mapLocationUrl, String facebookUrl, String twitterUrl, String googleUrl, String iconFacebook, String iconTwitter, String iconGoogle) {
        this.aboutMe = aboutMe;
        this.contactImage = contactImage;
        this.address = address;
        this.city = city;
        this.country = country;
        this.telephone = telephone;
        this.email = email;
        this.mapLocationUrl = mapLocationUrl;
        this.facebookUrl = facebookUrl;
        this.twitterUrl = twitterUrl;
        this.googleUrl = googleUrl;
        this.iconFacebook = iconFacebook;
        this.iconTwitter = iconTwitter;
        this.iconGoogle = iconGoogle;
    }

    /**
     * A method returns a introduction of photographer.
     * @return A photographer's introduction. It is a <code>java.lang.String</code>.
     */
    public String getAboutMe() {
        return aboutMe;
    }
    
    /**
     * A method to set an introduction of photographer.
     * @param aboutMe A photographer's introduction.  It is a <code>java.lang.String</code>.
     */
    public void setAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
    }

    /**
     * A method returns photographer's contact image.
     * @return A photographer's contact image. It is a <code>java.lang.String</code>.
     */
    public String getContactImage() {
        return contactImage;
    }
    
    /**
     * A method to set photographer's contact image.
     * @param contactImage A photographer's contact image. It is a <code>java.lang.String</code>.
     */
    public void setContactImage(String contactImage) {
        this.contactImage = contactImage;
    }
    
    /**
     * A method returns photographer's address.
     * @return A photographer's address. It is a <code>java.lang.String</code>.
     */
    public String getAddress() {
        return address;
    }

    /**
     * A method to set photographer's address.
     * @param address A photographer's address. It is a <code>java.lang.String</code>.
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * A method returns photographer's city.
     * @return A photographer's city. It is a <code>java.lang.String</code>.
     */
    public String getCity() {
        return city;
    }

    /**
     * A method to set photographer's city.
     * @param city A photographer's city. It is a <code>java.lang.String</code>.
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * A method returns photographer's country.
     * @return A photographer's country. It is a <code>java.lang.String</code>.
     */
    public String getCountry() {
        return country;
    }

    /**
     * A method to set photographer's country.
     * @param country A photographer's country. It is a <code>java.lang.String</code>.
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * A method returns photographer's telephone number.
     * @return A photographer's telephone number. It is a <code>java.lang.String</code>.
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * A method to set photographer's telephone number.
     * @param telephone A photographer's telephone number. It is a <code>java.lang.String</code>.
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    /**
     * A method returns photographer's email.
     * @return A photographer's email. It is a <code>java.lang.String</code>.
     */
    public String getEmail() {
        return email;
    }

    /**
     * A method to set photographer's email.
     * @param email A photographer's email. It is a <code>java.lang.String</code>.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * A method returns photographer's map location.
     * @return A photographer's map location. It is a <code>java.lang.String</code>.
     */
    public String getMapLocationUrl() {
        return mapLocationUrl;
    }

    /**
     * A method to set photographer's map location.
     * @param mapLocationUrl A photographer's map location. It is a <code>java.lang.String</code>.
     */
    public void setMapLocationUrl(String mapLocationUrl) {
        this.mapLocationUrl = mapLocationUrl;
    }

    /**
     * A method returns Facebook's URL.
     * @return A facebook's URL. It is a <code>java.lang.String</code>.
     */
    public String getFacebookUrl() {
        return facebookUrl;
    }

    /**
     * A method to set Facebook's URL.
     * @param facebookUrl A facebook's URL. It is a <code>java.lang.String</code>.
     */
    public void setFacebookUrl(String facebookUrl) {
        this.facebookUrl = facebookUrl;
    }

    /**
     * A method returns Twitter's URL.
     * @return A twitter's URL. It is a <code>java.lang.String</code>.
     */
    public String getTwitterUrl() {
        return twitterUrl;
    }

    /**
     * A method to set Twitter's URL.
     * @param twitterUrl A twitter's URL. It is a <code>java.lang.String</code>.
     */
    public void setTwitterUrl(String twitterUrl) {
        this.twitterUrl = twitterUrl;
    }

    /**
     * A method returns Google's URL.
     * @return A google's URL. It is a <code>java.lang.String</code>.
     */
    public String getGoogleUrl() {
        return googleUrl;
    }

    /**
     * A method to set Google's URL.
     * @param googleUrl A google's URL. It is a <code>java.lang.String</code>.
     */
    public void setGoogleUrl(String googleUrl) {
        this.googleUrl = googleUrl;
    }

    /**
     * A method returns Facebook's image icon.
     * @return A Facebook's image icon. It is a <code>java.lang.String</code>.
     */
    public String getIconFacebook() {
        return iconFacebook;
    }

    /**
     * A method to set Facebook's image icon.
     * @param iconFacebook A Facebook's image icon. It is a <code>java.lang.String</code>.
     */
    public void setIconFacebook(String iconFacebook) {
        this.iconFacebook = iconFacebook;
    }

    /**
     * A method returns Twitter's image icon.
     * @return A Twitter's image icon. It is a <code>java.lang.String</code>.
     */
    public String getIconTwitter() {
        return iconTwitter;
    }

    /**
     * A method to set Twitter's image icon.
     * @param iconTwitter A Twitter's image icon. It is a <code>java.lang.String</code>.
     */
    public void setIconTwitter(String iconTwitter) {
        this.iconTwitter = iconTwitter;
    }

    /**
     * A method returns Google's image icon.
     * @return A Google's image icon. It is a <code>java.lang.String</code>.
     */
    public String getIconGoogle() {
        return iconGoogle;
    }

    /**
     * A method to set Google's image icon.
     * @param iconGoogle A Google's image icon. It is a <code>java.lang.String</code>.
     */
    public void setIconGoogle(String iconGoogle) {
        this.iconGoogle = iconGoogle;
    }    
}
