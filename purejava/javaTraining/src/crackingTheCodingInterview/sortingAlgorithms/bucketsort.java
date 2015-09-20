public static void quickSort(int[] arr, int low, int high) {
	int i = low;
	int j = high;
	int pivot = j;

	while (i < j) {
		while (arr[pivot] < arr[j] && i <= j) {
			j--;
		}
		while (arr[i] < array[pivot] && i <= j) {
			i++;
		}
		if (i < j) {
			swap(arr, i, j);
		}
	}

	// should be true
	if (i == j) {
		swap(arr, pivot, i);
		pivot = i;
	}

	quickSort(arr, low, pivot - 1);
	quickSort(arr, pivot + 1, high);

}