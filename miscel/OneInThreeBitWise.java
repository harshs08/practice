public class OneInThreeBitWise{
	
	public static int findOneInstancs(int[] array){
		int ones = 0;
		int twos = 0;
		int not_threes = 0;
		int x = 0; 

		for(int i=0;i<array.length;i++){
			x = array[i];
			twos |= ones & x;
			ones ^= x;
			not_threes = ~(ones & twos);
			twos &= not_threes;   
			ones &= not_threes;
		}
		return ones;
	}

	public static void main(String[] args) {
		int[] array = {2,2,2,4};

		int res = findOneInstancs(array);
		System.out.println("Single Integer: "+ res);
	}
}