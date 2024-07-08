#include <iostream>

class pair
{
private:
    int first;
    int second;

public:
    pair() : first(0), second(0) {}
    pair(int first, int second) : first(first), second(second) {}

    void set_first(int f)
    {
        first = f;
    }
    void set_second(int s)
    {
        second = s;
    }

    void set_pairs(int f, int s)
    {
        first = f;
        second = s;
    }

    int get_first()
    {
        return first;
    }

    int get_second()
    {
        return second;
    }

    void print()
    {
        std::cout << "First: " << first << " Second: " << second << std::endl;
    }

    void swap()
    {
        int temp = first;
        first = second;
        second = temp;
    }
};

int main()
{
    pair p1;
    p1.set_pairs(1, 2);
    p1.print();

    p1.swap();
    p1.print();

    std::cout << "The first is: " << p1.get_first() << " The second is: " << p1.get_second() << std::endl;
}