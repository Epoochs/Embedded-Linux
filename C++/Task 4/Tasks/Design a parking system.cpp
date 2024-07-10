#include <stdio.h>

/* Not Optimized */

class ParkingSystem
{
private:
    int big_s;
    int med_s;
    int small_s;

public:
    ParkingSystem(int big, int medium, int small) : big_s(big), med_s(medium), small_s(small)
    {
    }

    bool addCar(int carType)
    {

        if (carType == 1 && big_s != 0)
        {
            big_s--;
        }
        else if (carType == 2 && med_s != 0)
        {
            med_s--;
        }
        else if (carType == 3 && small_s != 0)
        {
            small_s--;
        }
        else
        {
            return false;
        }
        return true;
    }
};

/* Optimized */
/*
class ParkingSystem
{
private:
    int slots[4];

public:
    ParkingSystem(int big, int medium, int small)
    {
        slots[1] = big;
        slots[2] = medium;
        slots[3] = small;
    }

    bool addCar(int carType)
    {

        if (slots[carType] > 0)
        {
            slots[carType]--;
            return true;
        }
        return false;
    }
};
*/

int main()
{
    /**
     * Your ParkingSystem object will be instantiated and called as such:
     * ParkingSystem* obj = new ParkingSystem(big, medium, small);
     * bool param_1 = obj->addCar(carType);
     */
}