#include <iostream>
#include <string>
#include <algorithm>
#include <math.h>

/* Dynamic Allocation */

namespace DynamicAlloc
{
    int **create2DArray(int size)
    {
        int **Array2D = new int *[size];
    }

    void delete2DArray(int **arr, int size)
    {
        for (size_t i = 0; i < size; i++)
        {
            delete[] arr[i];
        }
        delete[] arr;
    }
} // namespace DynamicAlloc

int main()
{
    int **arr;
    arr = DynamicAlloc::create2DArray(5);
    DynamicAlloc::delete2DArray(arr, 5);
}