/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projetsujet2;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author gargo
 */
public class Connexion {
    private static Connection con;
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver OK");
			con = DriverManager.getConnection("jdbc:mysql://@localhost:3306/jeusujet2", "root", "fluffy");
			System.out.println("connected");
			}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static Connection getConnection() {
		return con;
	}
}
