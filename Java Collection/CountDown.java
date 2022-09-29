package Collection;

import java.util.*;

public class CountDown {
  
	public static void main(String[] args) throws InterruptedException {
		
		int time = Integer.parseInt(args[0]);
		Queue<Integer> queue = new LinkedList<Integer>();
		
		for(int i = time; i >= 0; i--) {
			queue.add(i);
		}
		
		while(!queue.isEmpty()) {
			//Removing the element from the queue from the top to the last
			System.out.print(queue.poll());
			Thread.sleep(1000);
		}
	}
}
