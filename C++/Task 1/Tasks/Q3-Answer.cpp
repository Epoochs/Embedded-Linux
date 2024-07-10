#include <iostream>
#include <math.h>
using namespace std;

int *decToBin(int decNum);
int binToDec(int binNum);

int main()
{
    cout << "Select your convertor (1- D->B OR 2- B->D): ";
    int choice;
    cin >> choice;

    switch (choice)
    {
    case 1:
    {
        cout << "Enter your decimal number: ";
        int decNum;
        cin >> decNum;
        cout << "Your binary number is: ";
        int *binNum = decToBin(decNum);
        for (int i = 0; i < 32; i++)
        {
            cout << binNum[32 - 1 - i] << " ";
        }
        cout << endl;
    }
    break;
    case 2:
    {
        cout << "Enter your binary number: ";
        int binNum;
        cin >> binNum;
        cout << "Your decimal number is: " << binToDec(binNum) << endl;
    }
    break;
    default:
        cout << "Invalid choice! Try again." << endl;
        break;
    }
}

int *decToBin(int decNum)
{
    int *bin = (int *)calloc(64, sizeof(int));
    int i = 0;
    while (decNum > 0)
    {
        bin[i] = decNum & 1;
        decNum >>= 1;
        i++;
    }
    return bin;
}

int binToDec(int binNum)
{
    int decNum = 0;
    int i = 0;

    while (binNum != 0)
    {
        decNum += (binNum % 10) * pow(2, i);
        binNum /= 10;
        i++;
    }
    return decNum;
}