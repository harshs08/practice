import java.util.Scanner;
import java.util.Arrays;
public class CoinChangeDP{

	public static int minChange(int[] coins, int value){
		int[] min = new int[value+1];
		Arrays.fill(min, Integer.MAX_VALUE);
		min[0] = 0;
		for (int i=1; i<=value; i++ ) {
			for (int j = 0; j<coins.length ; j++) {
				if(coins[j]<= i){
					if(min[i-coins[j]]+1 < min[i]){
						min[i] = min[i-coins[j]]+1;
					}
				}
			}
		}
		return min[value];
	}
	public static void main(String... args){
		int value, r;
		int[] coins = new int[]{1,3,5};
		Scanner in = new Scanner(System.in);
		value = in.nextInt();
		r = minChange(coins, value);
		System.out.println("Minimum Number of coins: "+r);
	}
}