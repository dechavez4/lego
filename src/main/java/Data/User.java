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
public class User {

    private String username;
    private String email;
    private String password;
    private Orders cart;

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public Orders getCart() {
        return cart;
    }

    public void setCart(Orders cart) {
        this.cart = cart;
    }

    @Override
    public String toString() {
        return "User{" + "username=" + username + ", email=" + email + ", password=" + password + ", cart=" + cart + '}';
    }

}
