#include <iostream>

template <typename T, typename T>
class pair
{
private:
    T first;
    T second;

public:
    pair() : first(0), second(0) {}
    pair(T first, T second) : first(first), second(second) {}

    void set_first(T f)
    {
        first = f;
    }
    void set_second(T s)
    {
        second = s;
    }

    void set_pairs(T f, T s)
    {
        first = f;
        second = s;
    }

    T get_first()
    {
        return first;
    }

    T get_second()
    {
        return second;
    }

    void print()
    {
        std::cout << "First: " << first << " Second: " << second << std::endl;
    }

    void swap()
    {
        T temp = first;
        first = second;
        second = temp;
    }
};

int main()
{
    pair<int, int> p1;
    p1.set_pairs(1, 2);
    p1.print();

    p1.swap();
    p1.print();

    std::cout << "The first is: " << p1.get_first() << " The second is: " << p1.get_second() << std::endl;
}