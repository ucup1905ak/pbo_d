/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gd11_2_d_13000;

/**
 *
 * @author Farelino Alexander Kim
 * 240713000
 * D
 */
import java.util.UUID;

public class Session {
    private static Session sessionInstance = null;
    
    private String username;
    private String token;
    
    private Session(String username) {
        this.username = username;
        this.token = UUID.randomUUID().toString();
    }
    
    public static Session getInstance(String username) {
        System.out.println("Creating Session ...");
        if(Session.sessionInstance == null) {
            Session.sessionInstance = new Session(username);
            System.out.println("[!] Session Created Successfully");
        } else {
            System.out.println("[!] Session Already Created");
        }
        System.out.println("Username : " + Session.sessionInstance.username);
        System.out.println("Token : " + Session.sessionInstance.token);
        return Session.sessionInstance;
    }
}
