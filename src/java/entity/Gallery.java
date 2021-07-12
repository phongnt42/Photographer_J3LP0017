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
 * This class defines a Gallery object. It contains constructor to initialize
 * object; getter to get object attribute and setter to set object attribute.
 *
 * @author Nguyen The Phong
 */
public class Gallery {

    private int id;
    private String name;     
    private String mainImage;
    private String description;   
    
    /**
     *  Parameterless constructor for initializing Image object.
     *
     */
    public Gallery() {
    }
    
    /**
     * A parameterized constructor to initialize Gallery object
     * 
     * @param id the id of a gallery. It is an int number.
     * @param name the name of a gallery. It is a <code>java.lang.String</code> object
     * @param mainImage the main image of an gallery. It is a <code>java.lang.String</code> object
     * @param description the description of an gallery. It is a <code>java.lang.String</code> object
     */
    public Gallery(int id, String name, String mainImage, String description) {
        this.id = id;
        this.name = name;
        this.mainImage = mainImage;
        this.description = description;
    }   

    /**
     * A method returns gallery's ID.
     * @return the ID of gallery. It is an int number.
     */
    public int getId() {
        return id;
    }
    
    /**
     * A method to set gallery's ID.
     * @param id the ID of gallery. It is an int number.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * A method returns gallery's name.
     * @return the name of gallery. It is a <code>java.lang.String</code> object.
     */
    public String getName() {
        return name;
    }

    /**
     * A method to set gallery's name.
     * @param name the name of gallery. It is a <code>java.lang.String</code> object.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * A method returns gallery's main image.
     * @return the main image of gallery. It is a <code>java.lang.String</code> object.
     */
    public String getMainImage() {
        return mainImage;
    }

    /**
     * A method to set gallery's main image.
     * @param mainImage the main image of gallery. It is a <code>java.lang.String</code> object.
     */
    public void setMainImage(String mainImage) {
        this.mainImage = mainImage;
    }

    /**
     * A method returns gallery's description.
     * @return the description of gallery. It is a <code>java.lang.String</code> object.
     */
    public String getDescription() {
        return description;
    }

    /**
     * A method to set gallery's description.
     * @param description the description of gallery. It is a <code>java.lang.String</code> object.
     */
    public void setDescription(String description) {
        this.description = description;
    }
}
