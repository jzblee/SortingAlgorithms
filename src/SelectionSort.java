

public class SelectionSort extends ComparisonSort {
	
	int currentMinIndex, searchIndex;
	
	public SelectionSort(RandomArray a) {
		super(a);
	}

	public void normSort() {
		for (index = 0; index < lastIndex; index++) {
			currentMinIndex = index;
			for (searchIndex = index + 1; searchIndex <= lastIndex; searchIndex++) {
				if (array[currentMinIndex] > array[searchIndex]) {
					currentMinIndex = searchIndex;
				}
			}
			if (index != currentMinIndex) {
				switchIndex(index, currentMinIndex);
			}
		}
		done = true;
	}

	public void stepSort(int i) {
		while (i > 0) {
			if (index < lastIndex) {
				if (searchIndex <= lastIndex){
					if (array[currentMinIndex] > array[searchIndex]) {
						currentMinIndex = searchIndex;
					}
					searchIndex++;
				}
				else {
					if (index != currentMinIndex) {
						switchIndex(index, currentMinIndex);
					}
					index++;
					currentMinIndex = searchIndex = index;
				}
			}
			else {
				done = true;
				break;
			}
			i--;
		}
	}
}
