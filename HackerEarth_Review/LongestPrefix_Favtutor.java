package LongestPrefixSamples;

public class LongestPrefix_Favtutor {

    public static String longestCommonPrefix(String[] strs){

        String ans = "";
        int n = strs.length;

        int min = Integer.MAX_VALUE;

        for(int i = 0; i < n; i++){

            int len = strs[i].length();
            min = Math.min(min,len);
        }

        for(int i = 0; i < min; i++){
            //Get the character at the position i of the string
            char x1 = strs[0].charAt(i);
            boolean possible = true;

            for(int j = 1; j < n; j++){

                if(strs[j].charAt(i) != x1) {
                    possible = false;
                    break;
                }
            }

            if(possible){
                ans+=x1;
            }
            else {
                break;
            }
        }
        return  ans;
    }

    public static void main(String[] args) {

        String[] array = {"Hell", "Hells","Hellio"};
       System.out.println(longestCommonPrefix(array));
    }
}
