package LongestPrefixSamples;

public class ReadArray {

    public static void SumPredefinedValue(char[] arr, int start, int end){
        int in = start;
        int n = end;
        int[] sum = new int[arr.length];
        for(int i = start; i < arr.length; i ++){

            for(int j = start; j < end; j++){ sum[j] = arr[j] + arr[j+ 1];
            }
        }
    }
    public static int MaxValue(int[] str) {

        int result = 0;
        for (int i = 0; i < str.length; i++) {

            for (int j = 0; j < str.length - 1; j++) {
                if (str[i] > str[j]) {
                    result = str[i];
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {

        int[] arr = new int[]{34,67,90,123,567};

    int val=    MaxValue(arr);
        System.out.println(val);
//        char[] array = new char[]{
//                'a', 'b', 'c', 'd', 'f', 'g', 'h'
//        };
//        int sum = 0;
//        //Assuming that the sum is 400 due to predefined variables that have reduced the sum
//
//        for (int i = 0; i < array.length; i++) {
//            sum = array[i] + array[i + 1];
//
//            if (sum> 200) {
//
//                System.out.println("The substring with value greater than 400 is : " + array[i] + array[i + 1]);
//            }
//            System.out.println(sum);
//        }
//
//    }
    }
}