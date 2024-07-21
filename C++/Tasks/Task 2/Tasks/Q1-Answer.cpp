#include <iostream>
#include <string>

class Car
{
private:
    int model;
    int year;
    std::string comapany;

public:
    void set_model(int m);
    int get_model();

    void set_year(int y);
    int get_year();

    void set_company(std::string c);
    std::string get_company();
};

void Car::set_model(int m)
{
    model = m;
}

int Car::get_model()
{
    return model;
}

void Car::set_year(int y)
{
    year = y;
}

int Car::get_year()
{
    return year;
}

void Car::set_company(std::string cm)
{
    comapany = cm;
}

std::string Car::get_company()
{
    return comapany;
}

int main()
{
    Car car1;
    car1.set_model(2010);
    car1.set_year(2010);
    car1.set_company("BMW");

    std::cout << "Car model: " << car1.get_model() << std::endl
              << "Car year: " << car1.get_year() << std::endl
              << "Car company: " << car1.get_company() << std::endl;
}