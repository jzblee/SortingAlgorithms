

/**
 * Several sorting algorithms, such as quicksort, have more complex
 * subprocesses which are best indicated with multiple classes of
 * indicators. For example, one class of indicators could be used
 * to represent the pivot in quicksort. Indicators may be represented
 * with differing colors or shapes.
 * 
 * @author Jason Lee
 */

public class Indicator {
	
	public static final int CLASS_0_INDICATOR = 0;
	public static final int CLASS_1_INDICATOR = 1;
	public static final int CLASS_2_INDICATOR = 2;
	
	int[] indArr = new int[2];
	
	public Indicator(int index, int classID) {
		indArr[0] = index;
		indArr[1] = classID;
	}
	
}
