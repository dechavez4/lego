/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

/**
 *
 * @author Renz
 */
public class Orders {

    private int orderID;
    private int width;
    private int length;
    private int height;
    private String bandType;
    private String email;
    private boolean isShipped;

    public Orders(int width, int length, int height, String bandType, String email) {
        this.width = width;
        this.length = length;
        this.height = height;
        this.bandType = bandType;
        this.email = email;
        this.isShipped = isShipped;
    }

    public int getOrderID() {
        return orderID;
    }

    public int getWidth() {
        return width;
    }

    public int getLength() {
        return length;
    }

    public int getHeight() {
        return height;
    }

    public String getBandType() {
        return bandType;
    }

    public String getEmail() {
        return email;
    }

    public boolean isIsShipped() {
        return isShipped;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setBandType(String bandType) {
        this.bandType = bandType;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setIsShipped(boolean isShipped) {
        this.isShipped = isShipped;
    }

    @Override
    public String toString() {
        return "Orders{" + "orderID=" + orderID + ", width=" + width + ", length=" + length + ", height=" + height + ", bandType=" + bandType + ", email=" + email + ", isShipped=" + isShipped + '}';
    }

    
}
