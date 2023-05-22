package programmers;

import java.util.HashMap;

public class practice {

	public static void main(String[] args) {
		HashMap<Integer, Integer> x = new HashMap<Integer,Integer>();
	    HashMap<Integer, Integer> y = new HashMap<Integer,Integer>();

	    x.put(0, 1);
	    x.put(1, 2);
	    y.put(0, 8);
	    y.put(1, 6);
		int n = (Math.abs(x.get(0)-x.get(1))+Math.abs(y.get(0)-y.get(1)));
		
		System.out.println(n);
	}
	

}
