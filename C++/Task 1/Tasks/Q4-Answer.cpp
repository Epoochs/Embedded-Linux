#include <iostream>
#include <math.h>
using namespace std;

int main()
{
    int pop_c = 0;
    cout << "enter the population of the current residents: ";
    cin >> pop_c;

    int pop_f = 0;
    cout << "enter the future population: ";
    cin >> pop_f;

    cout << "The years needed to reach this population is:  " << ((log(pop_f) / log(pop_c)) / log(1 + (6.5 / 100)));
}