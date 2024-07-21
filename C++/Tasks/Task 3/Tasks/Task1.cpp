#include <iostream>
#include <typeinfo>

class VPointerArray
{
private:
    void **v_pArray;
    int v_nSize;

public:
    VPointerArray(int nSize)
    {
        v_nSize = nSize;
        v_pArray = new void *[nSize];
    }

    void set_value_at(int index, void *val)
    {
        v_pArray[index] = val;
    }

    int get_ArraySize()
    {
        return v_nSize;
    }

    void *get_val(int index)
    {
        return v_pArray[index];
    }

    const char *get_type(int index)
    {
        return typeid(*v_pArray[index]).name();
    }

    void print()
    {
        for (size_t i = 0; i < v_nSize; i++)
        {
            if (*get_type(i) == 'i')
            {
                std::cout << "Int: " << *(int *)get_val(i) << std::endl;
            }
            else if (*get_type(i) == 'd')
            {
                std::cout << "Double: " << *(double *)get_val(i) << std::endl;
            }
            else
            {
                std::cout << "Char: " << *(char *)get_val(i) << std::endl;
            }
        }
    }

    ~VPointerArray()
    {
        delete[] v_pArray;
    }
};

int main()
{
    int x = 5;
    char y = 'A';
    double z = 3.14;

    /* initializing the object */
    VPointerArray vpa(3);
    /* Setting the values at indices */
    vpa.set_value_at(0, &x);
    vpa.set_value_at(1, &y);
    vpa.set_value_at(2, &z);

    /* Printing the values */
    vpa.print();
}