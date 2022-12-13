package LongestPrefixSamples;

public class GreatestWealth {
    public static  int maximumWealth(int[][] accounts) {

        int GreatestWealth = 0;

        for(int[] customer : accounts){
            int wealth = 0;
            for(int bank : customer){

                wealth += bank;
            }

            GreatestWealth = Math.max(GreatestWealth,wealth);
        }

        return GreatestWealth;
    }

    public static void main(String[] args){

        int[][] array = {{1,2,3,4}, {4,5,26,0}, {4 ,5, 3, 2}};

       System.out.println( maximumWealth(array));
}
}
