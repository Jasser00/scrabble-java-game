/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projetsujet2;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.DefaultListModel;
/**
 *
 * @author gargo
 */
public class Traitementbd {
    
    	public  DefaultListModel<String> getdict() throws SQLException{
		DefaultListModel<String> dict = new DefaultListModel<>();
		String getstring = "Select* FROM dictionnaire";
                Statement stGetUser = Connexion.getConnection().createStatement();
                ResultSet result;
                result = stGetUser.executeQuery(getstring);
                while (result.next()) {
                        dict.addElement(result.getString(1));
			}
		return dict;
                }
        
        public void save(String mot) throws SQLException {
            
		String strInsert = "INSERT INTO dictionnaire VALUES('"+mot+"');";
		Statement stAddUser = Connexion.getConnection().createStatement();
		stAddUser.executeUpdate(strInsert);
            
	}
        
	public void delete(String mot) throws SQLException {
            
		String delete = "DELETE FROM dictionnaire WHERE MOT_PROPOSE='"+mot+"'";
		Statement stDelUser = Connexion.getConnection().createStatement();
		stDelUser.executeUpdate(delete);  
            
        }
        
        public void update(String mot,String nmot) throws SQLException {
            
		String update = "UPDATE dictionnaire SET MOT_PROPOSE='"+nmot+"' WHERE MOT_PROPOSE= '"+mot+"'";
		Statement stUpUser = Connexion.getConnection().createStatement();
		stUpUser.executeUpdate(update);
            
	}
        
        
       public static boolean verif(String mot) throws SQLException {
		boolean m = false;
		String getstring = "Select* FROM dictionnaire";
		Statement stGetUser = Connexion.getConnection().createStatement();
		ResultSet result = stGetUser.executeQuery(getstring);
		while (result.next()) {
                    if (result.getString(1).equals(mot))
                        m = true;
                }
                return m;
	}
        
}