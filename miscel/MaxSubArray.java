public class MaxSubArray{
	public static int maxSubArray(int[] arr){
		int current_index = 0;
		int current_sum = 0;
		int best_sum = 0;
		int start_index = 0;
		int end_index = 0;
		int val = 0;

		for(int i=0; i< arr.length; i++){
			val = current_sum + arr[i];
			if (val > 0){
				if (current_sum == 0)
					current_index = i;
				current_sum = val;
			}
			else{
				current_sum = 0;
			}

			if (current_sum > best_sum){
				best_sum = current_sum;
				start_index = current_index;
				end_index = i;
			}
		}

		System.out.println("Maximum SubSum Array: ");

		for (int i = start_index; i<=end_index ; i++) {
			System.out.print(arr[i] +" ");
		}
		System.out.println();
		return best_sum;

	}

	public static void main(String[] args) {
		int array[] = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
		int result = maxSubArray(array);
		System.out.println("Largest Sum: " + result);
	}
}