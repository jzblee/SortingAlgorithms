

/**
 * Standard bubble sort algorithm.
 * 
 * @author Jason Lee
 */

public class BubbleSort extends ComparisonSort {
	
	boolean keepGoing = true;
	
	public BubbleSort(RandomArray a) {
		super(a);
	}
	
	public void normSort() {
		while (keepGoing) {
			keepGoing = false;
			for (index = 0; index < lastIndex; index++) {
				if (array[index] > array[index + 1]) {
					keepGoing = true;
					switchIndex(index, index + 1);
				}
			}
			lastIndex--;
		}
		done = true;
	}
	
	public void stepSort(int i) {
		while (i > 0) {
			if (index < lastIndex) {
				if (array[index] > array[index + 1]) {
					switchIndex(index, index + 1);
					keepGoing = true;
				}
				index++;
			}
			else {
				if (keepGoing) {
					keepGoing = false;
					index = 0;
					lastIndex--;
				}
				else {
					done = true;
					break;
				}
			}
			i--;
		}
	}	
}
