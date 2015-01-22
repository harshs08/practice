import java.io.*;
import java.util.*;

@SuppressWarnings({"rawtypes","unchecked"})
public class BubbleSort{

	public static void sort(Comparable[] a){
		int N = a.length;
		boolean flag = false;
		for (int i=1; i<N; i++) {
			//System.out.println("i= " + i);
			for (int j=0; j<N-i; j++) {
				//System.out.println("j= " + j);
				if (less(a[j+1], a[j])) {
					exch(a, j+1, j);
					flag = true;
				}
			}
			if(!flag)
				break;
		}
	}

	private static boolean less(Comparable v, Comparable w){
		return v.compareTo(w) < 0;
	}

	private static void exch(Comparable[] a, int i, int j){
		Comparable t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

	private static void show(Comparable[] a){
		for (int i=0; i<a.length; i++)
			System.out.print(a[i] + " ");
		System.out.println();
	}

	private static boolean isSorted(Comparable[] a) {
		for (int i = 1; i < a.length; i++)
				if (less(a[i], a[i-1])) return false;
		return true;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t;
		t = Integer.parseInt(in.nextLine());

		//need to keep changing based on the data type to input 
		String[] a = new String[t];

		for (int i=0; i<t; i++) {
			a[i] = in.nextLine();
		}

		sort(a);
		assert isSorted(a);
		show(a);

		
	}
}