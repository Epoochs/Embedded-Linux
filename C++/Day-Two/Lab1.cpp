#include <iostream>
#include <string>
#include <algorithm>
#include <math.h>

namespace MathFunctions
{
    void print(double val)
    {
        std::cout << "the square root of the value is: " << sqrt(val);
    }
}

namespace StringFunctions
{
    void print(std::string str, char c)
    {
        switch (c)
        {
        case 'U':
        case 'u':
            std::transform(str.begin(), str.end(), str.begin(), ::toupper);
            std::cout << str;
            break;
        case 'L':
        case 'l':
            std::transform(str.begin(), str.end(), str.begin(), ::tolower);
            std::cout << str;
        default:
            break;
        }
    }
}

namespace ArrayFunctions
{
    void print(int *val, int size)
    {
        for (int i = 0; i < size / 2; i++)
        {
            int temp = val[i];
            val[i] = val[size - i - 1];
            val[size - i - 1] = temp;
        }

        for (size_t i = 0; i < size; i++)
        {
            std::cout << val[i] << " ";
        }
    }
}
int main()
{
    std::cout << "Array Function" << std::endl;
    int arr[4]{1, 2, 3, 4};
    ArrayFunctions::print(arr, 4);

    std::cout << "\nString Function" << std::endl;
    std::string str = "Ahmed";
    StringFunctions::print(str, 'u');
    std::cout << std::endl;
    StringFunctions::print(str, 'l');

    std::cout << "\nMath Function" << std::endl;
    MathFunctions::print(9);
}