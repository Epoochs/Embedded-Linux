#include <iostream>
#include <string>
#include <algorithm>
#include <math.h>

namespace ArrayPair
{
    std::pair<int, int> *createArray(int size)
    {
        std::pair<int, int> *arrayPair_ptr = new std::pair<int, int>[size];
        return arrayPair_ptr;
    }

    void setPair(int index, int first, int second, std::pair<int, int> *arr)
    {
        arr[index].first = first;
        arr[index].second = second;
    }

    std::pair<int, int> getPair(int index, std::pair<int, int> *arr)
    {
        return arr[index];
    }

    void print(std::pair<int, int> *arr, int size)
    {
        for (size_t i = 0; i < size; i++)
        {
            std::cout << arr[i].first << " " << arr[i].second << std::endl;
        }
    }

    void deleteArray(std::pair<int, int> *arr, int size)
    {
        delete[] arr;
    }
} // namespace ArrayPair

int main()
{
    std::pair<int, int> *arr = ArrayPair::createArray(5);
    ArrayPair::setPair(0, 1, 2, arr);
    ArrayPair::setPair(1, 3, 4, arr);
    ArrayPair::setPair(2, 5, 6, arr);
    ArrayPair::setPair(3, 7, 8, arr);
    ArrayPair::setPair(4, 9, 10, arr);

    ArrayPair::print(arr, 5);
    ArrayPair::deleteArray(arr, 5);
}