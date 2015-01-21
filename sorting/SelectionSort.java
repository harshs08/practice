import java.io.*;
import java.util.*;

@SuppressWarnings({"rawtypes","unchecked"})
public class SelectionSort{

	// public static void sort(Comparable[] a){

	// }

	public static boolean less(Comparable v, Comparable w){
		return v.compareTo(w) < 0;
	}

	public static void exch(Comparable[] a, int i, int j){
		Comparable t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

	public static void show(Comparable[] a){
		for (int i=0; i<a.length; i++) 
			System.out.print(a[i] + " ");
		System.out.println();
	}

	public static boolean isSorted(Comparable[] a){
		for (int i=1; i<a.length; i++) {
			if(less(a[i],a[i-1]))
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		int t;
		t = Integer.parseInt(in.nextLine());
		String[] a = new String[t];

		for (int i=0; i<t; i++) {
			a[i] = in.nextLine();
		}

		//sort(a);
		assert isSorted(a);
		show(a);

		
	}
}