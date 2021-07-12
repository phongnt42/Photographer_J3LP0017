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
package entity;

/**
 * This class defines an Image object. It contains constructor to initialize
 * object; getter to get object attribute and setter to set object attribute.
 *
 * @author Nguyen The Phong
 */
public class Image {

    private int id;
    private String imageUrl;
    private int galeryID;

    /**
     *  Parameterless constructor for initializing Image object.
     *
     */
    public Image() {
    }

    /**
     * A parameterized constructor to initialize Image object
     * 
     * @param id the id of an image. It is an int number.
     * @param imageUrl the URL of an image. It is a <code>java.lang.String</code> object
     * @param galeryId the id of a gallery. It is an int number.
     */
    public Image(int id, String imageUrl, int galeryId) {
        this.id = id;
        this.imageUrl = imageUrl;
        this.galeryID = galeryId;
    }

    /**
     * A method returns image's ID.
     * @return the ID of image. It is an int number.
     */
    public int getId() {
        return id;
    }

    /**
     * A method to set image's ID.
     * @param id the ID of image. It is an int number.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * A method returns image's URL.
     * @return the URL of an image. It is a <code>java.lang.String</code> object.
     */
    public String getImageUrl() {
        return imageUrl;
    }

    /**
     * A method to set image's URL.
     * @param imageUrl the URL of an image. It is a <code>java.lang.String</code> object
     */
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    /**
     * A method returns gallery's ID.
     * @return the ID of gallery. It is an int number.
     */
    public int getGaleryID() {
        return galeryID;
    }

    /**
     * A method to set gallery's ID.
     * @param galeryID the ID of gallery. It is an int number.
     */
    public void setGaleryID(int galeryID) {
        this.galeryID = galeryID;
    }   
    
}
