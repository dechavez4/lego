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

    private String email;
    private String password;
    private boolean admin;

    public User(String email, boolean admin) {
        this.email = email;
        this.admin = admin;
    }

    
    public String getEmail() {
        return email;
    }
    
    public boolean getAdmin(){
        return admin;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
    
    @Override
    public String toString() {
        return "User{" + "email=" + email + ", password=" + password + ", admin=" + admin + '}';
    }
}
