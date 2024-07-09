#include <iostream>
using namespace std;

int main()
{
    int time = 0;
    cout << "Enter the time in seconds: ";
    cin >> time;

    int time_H = 0;
    int time_M = 0;
    int time_S = 0;

    while (time != 0)
    {
        if ((time / 3600) != 0)
        {
            time_H = time / 3600;
            time = time % 3600;
        }
        else if ((time / 60) != 0)
        {
            time_M = time / 60;
            time = time % 60;
        }
        else
        {
            time_S = time;
            time = 0;
        }
    }

    cout << "H:M:S -> " << time_H << ":" << time_M << ":" << time_S;
}