import java.io.*;
import java.util.*;

@SuppressWarnings({"rawtypes","unchecked"})
public class QuickSort {

	public static int partition(Comparable[] a, int start, int end){
		Comparable pivot = a[end];

		int partitionIndex = start;

		for (int i=0; i<end; i++ ) {
			if (less(a[i],pivot)) {
				exch(a, i, partitionIndex);
				partitionIndex++;
			}
		}
		exch(a, partitionIndex, end);
		return partitionIndex;
	}

	public static void quickSort(Comparable[] a, int start, int end){
 
		if (start<end) {
			int partitionIndex = partition(a, start, end);
			quickSort(a, start, partitionIndex-1);
			quickSort(a, partitionIndex+1, end);
		}
	}

	public static void sort(Comparable[] a){
		int first = 0;
		int last = a.length - 1;
		quickSort(a, first, last);
	}

	public static boolean less(Comparable v, Comparable w){
		return v.compareTo(w) < 0;
	}

	public static void exch(Comparable[] a, int i, int j){
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
		int t = Integer.parseInt(in.nextLine());

		Integer[] a = new Integer[t];
		for (int i=0; i<t ; i++)
			a[i] = in.nextInt();

		sort(a);
		assert isSorted(a);
		show(a);	}

	
}
