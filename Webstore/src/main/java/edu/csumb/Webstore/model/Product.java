//This is your model. This file should only contain getters and setters, along with the variables your struct uses.
//DONT FORGET THE CONSTRUCTOR! Getters and setters must be setup to match the name exactly
//or else you will have many errors.
package edu.csumb.Webstore.model;

import org.springframework.data.annotation.Id;

import io.swagger.annotations.ApiModelProperty;


public class Product
{
    @Id
    @ApiModelProperty(required = false, hidden = true)
    String id;

    String name;
    String description;
    String imageURL;
    Double price;
    Integer stock;
    
    public Product(String name, String description, String imageURL, Double price, Integer stock){
        this.name = name;
        this.description = description;
        this.imageURL = imageURL;
        this.price = price;
        this.stock = stock;
    }
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }
    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * @return the id
     */
    public String getId() {
        return id;
    }
    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }
    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }
    /**
     * @return the imageURL
     */
    public String getImageURL() {
        return imageURL;
    }
    /**
     * @param imageURL the imageURL to set
     */
    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
    /**
     * @return the price
     */
    public Double getPrice() {
        return price;
    }
    /**
     * @param price the price to set
     */
    public void setPrice(Double price) {
        this.price = price;
    }
    /**
     * @return the stock
     */
    public Integer getStock() {
        return stock;
    }
    /**
     * @param stock the stock to set
     */
    public void setStock(Integer stock) {
        this.stock = stock;
    }
}