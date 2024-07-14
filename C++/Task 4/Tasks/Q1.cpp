#include <iostream>
#include <time.h>
#include <cstdlib>

struct vertex
{
    int x;
    int y;
};

int main()
{
    srand(time(0));
    vertex v;

    for (size_t i = 0; i < 5; i++)
    {
        v.x = (rand() % 201) - 100;
        v.y = (rand() % 201) - 100;
        std::cout << v.x << " " << v.y << std::endl;
    }
}