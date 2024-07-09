#include <iostream>
#include <stdlib.h>
#include <algorithm>
using namespace std;


int* Func(int** arr_2d, int arr_size, int* row_size, int (*func)(int* x, int sub_size))
{
    int* ret_array = (int*)malloc(sizeof(int) * arr_size);

    for (size_t i = 0; i < arr_size; i++)
    {
        ret_array[i] = func(*arr_2d, row_size[i]);
    }
    return ret_array;
}

int array_sum(int* x, int sub_size)
{
    int sum = 0;
    for (size_t i = 0; i < sub_size; i++)
    {
        sum += x[i];
    }

    return sum;
}

int main()
{
  
}
