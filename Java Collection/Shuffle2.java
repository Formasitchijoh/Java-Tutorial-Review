package Collection;

import java.util.*;

public class Shuffle2 {
   
	public static <E> void swap(List<E> list, int i, int j) {
		
		E tmp = list.get(i);
		list.set(i, list.get(j));
		list.set(j, tmp);
	}
	
	public static void shuffle(List<?> list, Random rnd) {
		for(int i = list.size(); i > 1; i--) {
			swap(list,i-1,rnd.nextInt(i));
		}
	}
	
	//Driver method
	
	public static void main(String[] args) {
	
		List<String> list = new ArrayList<String>();
		
		for(String s : args)
			list.add(s);
	shuffle(list , new Random());
		System.out.println(list);
	}
}
