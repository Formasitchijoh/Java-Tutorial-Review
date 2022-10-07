/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interview;

/**
 *
 * @author Prudence
 */
public class Reversing_C_Type_String {

    
    public static void Split(String str){
     
       char[] cArray = str.toCharArray();
         for(int i = cArray.length-1; i >= 0; i--){
            
            System.out.println(cArray[i]);
        }
    }
    public static void main(String[] args) {
        
      Split("Hello");
    
    }
    
}
