/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projetsujet2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import javax.swing.DefaultListModel;

/**
 *
 * @author gargo
 */
public class TraitementJeu {
    private static HashMap <Character,Integer> mapRandom= new HashMap<Character,Integer>(); 
    private static HashMap <Character,Integer> mapSubmit= new HashMap<Character,Integer>(); 
    private static Set <Character> submitSet = new  HashSet<Character>();
    private static boolean result = true; 
    
    private static DefaultListModel<String> combb = new DefaultListModel<String>();
    private static DefaultListModel<String> mot = new DefaultListModel<String>();
    
    public static void addchar(String n){
        combb.addElement(n);
    }
    
    public static String getmot(){
        String m = "";
        for (int i=0;i<combb.size();i++){
            m=m+combb.get(i);
        }
        return m;
    }
    
    public static String getmott(ArrayList<Character> s){
        String m = "";
        for (int i=0;i<s.size();i++){
            m=m+s.get(i);
        }
        return m;
    }
    
    public static void emptyArray(){
        combb.clear();
    }
    
    public static DefaultListModel<String> getarray(){
        mot.addElement(getmot());
        return mot;
    }
    
    public static char randomChar() {
        Random r = new Random();
        return (char)(r.nextInt(26) + 'A');
    }
    
//function calculating the number of occurrence of a character
    static int occurence(String submitString, char ch) {
        int count=0;
        for(int i=0; i<submitString.length(); i++){
            if(submitString.charAt(i) ==ch)
            count++;
        }  
        return count; 
    }
    

	public boolean verifrand(String submitString,ArrayList<Character> randomList) {
		
// remplissage de la liste random 
    
	for (Character ch = 'A'; ch <= 'Z'; ++ch) 
			  mapRandom.put(ch, 0); 
	
	for(char x: randomList) {
	Integer y =mapRandom.get(x); 
	mapRandom.replace(x,y+1) ; 	
	}
	
	// prepare submitSet
     for (int i=0; i<submitString.length();i++) {
    	submitSet.add(submitString.charAt(i)); 
     }
	
     for (char ch: submitSet) {
    	
     }
	
	//prepare the submitHashMap
	for (char ch : submitSet) {
		 mapSubmit.put(ch, occurence(submitString,ch)); 
	}
	
	// iterate the submitMap and check occurrence 
	for(Map.Entry m : mapSubmit.entrySet()) {
		if ((int)mapRandom.get(m.getKey()) <(int)m.getValue()) {
			result= false; 
			break; 
		}
		else 
			continue; 
	}
	
	

return result;
}
	
}

