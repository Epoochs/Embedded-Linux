#include <iostream>
#include <math.h>
using namespace std;

struct Name
{
    char first[20];
    char Middle[20];
    char last[20];
};

struct Date_Birth
{
    int day;
    int month;
    int year;
};

struct Employee
{
    Name name;
    Date_Birth date;
};

int main()
{
    Employee emp;
    cout << "Enter the first name: ";
    cin.getline(emp.name.first, 20);
    cout << "Enter the middle name: ";
    cin.getline(emp.name.Middle, 20);
    cout << "Enter the last name: ";
    cin.getline(emp.name.last, 20);

    cout << "Enter the day of birth: ";
    cin >> emp.date.day >> emp.date.month >> emp.date.year;

    cout << "Employee Data: \n"
         << "Name:" << emp.name.first << " " << emp.name.Middle << " " << emp.name.last << endl;
    cout << "Date of Birth: " << emp.date.day << "/" << emp.date.month << "/" << emp.date.year;
}