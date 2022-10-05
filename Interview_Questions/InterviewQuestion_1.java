
package javaapplication4;

import java.util.Arrays;


public class JavaApplication4 {

    
    public static boolean isUniqueChars(String str){
        
        boolean[] char_set = new boolean[256];
        
        for(int i = 0; i < str.length(); i++){
            int val = str.charAt(i);
            System.out.println(val);
            if(char_set[val])return false;
            char_set[val] = true;
        }
        return true;
    }
    public static void main(String[] args) {
     if(isUniqueChars("helo"))
           System.out.println("True");
       
    }
    
}
