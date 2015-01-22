import java.io.*;
import java.util.*;

@SuppressWarnings({"rawtypes","unchecked"})
public class BubbleSort{

	public static void sort(Comparable[] a){
		int N = a.length;
		boolean flag = false;
		for (int i=0; i<N; i++) {
			for (int j=0; j<N-i; j++) {
				if (less(a[j+1], a[j])) {
					exch(a, j+1, j);
					flag = true;
				}
			}
			if(flag)
				break;
		}
	}

	public static void sort2(Comparable[] a){
		for (int i = 1; i < a.length; i++) {
			Comparable val = a[i];
			int j = i;
			while (j > 0 && less(val,a[j - 1])) {
				exch(a, j, j-1);
				j--;
			}
			a[j] = val;
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
		Integer[] a = new Integer[t];

		for (int i=0; i<t; i++) {
			a[i] = in.nextInt();
		}

		//sort(a);
		sort2(a);
		assert isSorted(a);
		show(a);

		
	}
}