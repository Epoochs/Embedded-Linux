#include <iostream>
#include <initializer_list>

template <typename T>
class Vector_t
{
private:
    int *arr = nullptr;
    int size;
    int current_size;
    int array_end;

public:
    Vector_t() : size(1)
    {
        arr = new T[size]{0};
    }

    Vector_t(int s) : size(s)
    {
        arr = new T[size]{0};
    }

    Vector_t(int s, T val) : size(s)
    {
        arr = new T[size];
        for (int i = 0; i < size; i++)
        {
            arr[i] = val;
        }
    }

    Vector_t(int s, std::initializer_list<T> il) : size(s)
    {
        arr = new T[size];
        int i = 0;
        for (auto it : il)
        {
            arr[i++] = it;
        }
    }

    void push_back(T value)
    {
        static int index = 0;
        if (index >= size)
        {
            current_size = size * 2;
            int *arr_new = new T[current_size]{0};

            for (size_t i = 0; i < size; i++)
            {
                arr_new[i] = arr[i];
            }
            arr = arr_new;
            size = current_size;
        }

        arr[index++] = value;
        array_end = index - 1;
    }

    void pop_back()
    {
        arr[array_end] = 0;
        array_end--;
    }

    void remove_at(int index)
    {
        arr[index] = 0;

        for (size_t j = index; j < array_end + 1; j++)
        {
            arr[j] = arr[j + 1];
        }
        array_end--;
    }

    void print()
    {
        for (size_t i = 0; i < array_end + 1; i++)
        {
            printf("%d ", arr[i]);
        }
    }

    void array_size()
    {
        std::cout << "\nThe size of the vector is: " << current_size << std::endl;
    }
};

int main()
{
    Vector_t<int> v(2);
    v.push_back(1);
    v.push_back(2);
    v.push_back(5);

    v.print();
    v.array_size();

    std::cout << std::endl;

    v.pop_back();
    v.print();
    v.array_size();

    std::cout << std::endl;

    v.remove_at(0);
    v.print();
    v.array_size();
}
