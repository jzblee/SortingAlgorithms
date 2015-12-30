

/**
 * Generates arrays of size n which contain all integers from 1 to n
 * inclusive. The arrays are intended to be sorted in ascending order.
 * 
 * @author Jason Lee
 */

public class RandomArray {
	
	/**
	 * The sequence of integers is randomized. Normal generation.
	 */
	public static final int GENTYPE_RANDOM = 0;
	/**
	 * The sequence of integers is generated in descending order.
	 * Sorting algorithms should require the most time possible
	 * to process these arrays.
	 */
	public static final int GENTYPE_WORST_CASE = 1;
	/**
	 * The sequence of integers is generated in ascending order.
	 * Sorting algorithms should require the least time possible
	 * to process these arrays.
	 */
	public static final int GENTYPE_BEST_CASE = 2;
	
	int[] array;
	int length;
	
	public RandomArray(int length, int genType) {
		this.length = length;
		genArray(genType);
	}
	
	public void genArray(int genType) {
		array = new int[length];
		switch (genType) {
			case GENTYPE_RANDOM:
				boolean assigned;
				for(int i = 1; i <= length; i++) {
					assigned = false;
					while (!assigned) {
						int newIndex = (int)(Math.random() * length);
						if(array[newIndex] == 0) {
							array[newIndex] = i;
							assigned = true;
						}
					}
				}
				break;
			case GENTYPE_WORST_CASE:
				for(int i = length; i >= 1; i--) {
					array[length - i] = i;
				}
				break;
			case GENTYPE_BEST_CASE:
				for(int i = 0; i < length; i++) {
					array[i] = i + 1;
				}
				break;
		}
	}
	public int[] getArray() {
		return array;
	}
}
