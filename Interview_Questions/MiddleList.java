package LongestPrefixSamples;

import java.util.ArrayList;

public class MiddleList {
    int val;
    MiddleList next;
    MiddleList(){};
    MiddleList(int val){
        this.val = val;
    }

    MiddleList(int val,MiddleList next){
        this.val = val;
        this.next = next;
    }
    public static MiddleList middleNode(MiddleList head){

        int length = 0;
        ArrayList<MiddleList> array = new ArrayList<>();
        while(head !=null){
            array.add(head);
            head = head.next;
            length++;
        }
        return array.get(length/2);
    }


}
