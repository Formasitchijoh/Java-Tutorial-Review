package LongestPrefixSamples;

public class Pangram {

    //Using an array to convert the String into an array of characters

    char[] array;
    public boolean Pangram(String sentence) {
        // We iterate over 'sentence' for 26 times, one for each letter 'currChar'.
        for (int i = 0; i < 26; ++i) {
            char currChar = (char)('a' + i);

            // If 'sentence' doesn't contain currChar, it is not a pangram.
            if (sentence.indexOf(currChar) == -1)
                return false;
        }

        // If we manage to find all 26 letters, it is a pangram.
        return true;
    }
    public static void main(String[] args){
        Pangram pan = new Pangram();
                String sentence = "abchuhvwgxyzen";

               System.out.print( pan.Pangram(sentence));
    }
}
