#include <iostream>

int binary_search(int arr[], int low, int high, int key);

int main()
{
	int arr[5]{1, 6, 9, 10, 89};

	std::cout << binary_search(arr, 0, 4, 10) << std::endl;

	return 0;
}

int binary_search(int arr[], int low, int high, int key)
{
	while (low <= high)
	{
		int med = (low + high) / 2;

		if (arr[med] == key)
			return med;

		else if (arr[med] < key)
			low = med + 1;

		else
			high = med - 1;
	}
	return -1;
}
