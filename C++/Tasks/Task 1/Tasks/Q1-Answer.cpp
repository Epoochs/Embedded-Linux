#include <iostream>
using namespace std;

int main()
{
    int in = 0;
    int sum = 0;
    cout << "Please Enter Number: ";
    cin >> in;

    while (in != 0)
    {
        sum += in;
        cout << "\nPlease Enter another Number: ";
        cin >> in;
    }

    cout << "The result is: " << sum;
}
