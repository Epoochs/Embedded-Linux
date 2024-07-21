#include <iostream>
#include <math.h>

class Calculator
{
private:
    int n1;
    int n2;
    char op;

    int add(int a, int b)
    {
        return a + b;
    }

    int sub(int a, int b)
    {
        return a - b;
    }

    int mul(int a, int b)
    {
        return a * b;
    }

    int sqrti(int a)
    {
        return sqrt(a);
    }

public:
    void set_operation(int a, int b, char oper)
    {
        switch (oper)
        {
        case '+':
            std::cout << "The sum of the two number is: " << add(a, b) << std::endl;
            break;

        case '-':
            std::cout << "The sub of the two numbers is: " << sub(a, b) << std::endl;
            break;

        case '*':
            std::cout << "The multiplication of the two numbers is: " << mul(a, b) << std::endl;
            break;

        case 'S':
        case 's':
            std::cout << "The square root of the number is: " << sqrti(a) << std::endl;
            break;

        default:
            std::cout << "Invalid operation";
            break;
        }
    }
};

int main()
{
    Calculator c;
    c.set_operation(10, 20, '+');
    c.set_operation(10, 20, '-');
    c.set_operation(10, 20, '*');
    c.set_operation(10, 20, 'S');
}