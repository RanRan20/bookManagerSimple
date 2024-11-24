/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package login;

/**
 *
 * @author ranxl
 */
public class user {
    private String username;
    private String password;
    
    
    public user(String username, String password){
        this.username = username;
        this.password = password;
        
    }
    
     public boolean validate(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }
     
}