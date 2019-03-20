/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;


/**
 *
 * @author Jakob, Vincent, Renz, Simon.
 */
public class Admin extends User{
    
    private boolean admin;

    public Admin(boolean admin, String username, String password, String email) {
        super(username, password, email);
        this.admin = admin;
    }
   
    
}
