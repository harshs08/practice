import java.io.*;
import java.util.*;

@SuppressWarnings({"rawtypes","unchecked"})
public class MergeSort{

	public static void merge(Comparable[] left, Comparable[] right, Comparable[] a){
		int leftLen = left.length;
		int rightLen = right.length;
		int i, j, k;
		i = j = k = 0;

		while(i<leftLen && j<rightLen){
			if(less(left[i],right[j])){
				a[k] = left[i];
				i++;
				k++;
			}
			else{
				a[k] = right[j];
				j++;
				k++;
			}
		}
		while(i<leftLen){
			a[k] = left[i];
			i++;
			k++;
		}
		while(j<rightLen){
			a[k] = right[j];
			j++;
			k++;
		}
	}

	public static void sort(Comparable[] a){
		int len = a.length;
		if (len < 2) return;
		int mid = len/2;
		Comparable[] left = new Comparable[mid];
		Comparable[] right = new Comparable[len-mid];
		int i = 0;
		for (i=0; i<mid ; i++) {
			left[i] = a[i];
		}
		for (i=mid; i<len-i ; i++) {
			right[i-len] = a[i];
		}
		sort(left);
		sort(right);
		merge(left, right, a);

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

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int t;
		t = Integer.parseInt(in.nextLine());

		Integer[] a = new Integer[t];
		for (int i=0; i<t; i++) {
			a[i] = in.nextInt();
		}

		sort(a);
		assert isSorted(a);
		show(a);
	}
}