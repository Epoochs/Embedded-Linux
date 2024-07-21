#include <iostream>
#include <time.h>
#include <cstdlib>

class vertex
{
private:
    int x;
    int y;

public:
    void set_x(int x)
    {
        this->x = x;
    }
    int get_x()
    {
        return x;
    }

    void set_y(int y)
    {
        this->y = y;
    }
    int get_y()
    {
        return y;
    }
};

int main()
{
    srand(time(0));
    vertex v;

    for (size_t i = 0; i < 5; i++)
    {
        v.set_x((rand() % 201) - 100);
        v.set_y((rand() % 201) - 100);
        std::cout << v.get_x() << " " << v.get_y() << std::endl;
    }
}