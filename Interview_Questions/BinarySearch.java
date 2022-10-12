package LongestPrefixSamples;

public class BinarySearch {

    public static int Binarysearch(int[] arr, int beg, int end, int val) {

        //Using binarySearch we perform divide and conquer w\
        //where we divide the array into two equal parts each time and search the sorted list
        int mid;
        int pos = -1;
        if (end >= beg)
        {
             mid = (end + beg)/2;

            if(arr[mid] == val){
              return mid +1;
            }
            else if (arr[mid] < val) {
                return Binarysearch(arr,mid +1, end, val);
            }

            else {
                return Binarysearch(arr,beg, mid -1, val);
            }

            }
        return -1;
        }

        public static void main(String[] args){
        int[] str = new int[]{
                1,4,7,8,90,23,44,49,55,69
        };
       int val = 23;
       int n = str.length;

       int result = Binarysearch(str,0, n -1,val);

       if(result == -1){
           System.out.println("Element is not found in the list");
       }

       else {
           System.out.println("The element is found at position" + " "+ result);
       }
        }

    }
