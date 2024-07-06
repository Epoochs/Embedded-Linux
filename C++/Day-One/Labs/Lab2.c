#include <iostream>
#include <stdlib.h>
#include <algorithm>
using namespace std;

struct vector_t
{

    int* arr = nullptr;
    int size;
    int new_size;

    void init()
    {
        arr = (int*)malloc(sizeof(int) * size);
    }

    void add(int value)
    {
        static int index = 0;
        if (index >= size)
        {
            new_size = size * 2;
            int* arr_new = (int*)malloc(sizeof(int) * new_size);

            for (size_t i = 0; i < size; i++)
            {
                arr_new[i] = arr[i];
            }
            arr = arr_new;
            size = new_size;
        }

        arr[index++] = value;
        new_size = index;
    }

    void remove(int value)
    {
        for (size_t i = 0; i < new_size; i++)
        {
            if (value == arr[i])
            {
                for (size_t j = i; j < new_size - 1; j++)
                {
                    arr[j] = arr[j + 1];
                }
                new_size--;
                return;
            }
        }
        printf("Value is not here!");
    }

    void print()
    {
        for (size_t i = 0; i < new_size; i++)
        {
            printf("%d ", arr[i]);
        }
    }
};

int main()
{
    int* arr = nullptr;

    vector_t v{ arr,2 };

    v.init();

    v.add(5);
    v.add(6);
    v.add(30);
    v.add(50);
    v.add(621);

    v.print();

    printf("\n size is: %d\n", v.new_size);

    v.remove(30);
    v.print();
    printf("\n size is: %d", v.new_size);

    
}
