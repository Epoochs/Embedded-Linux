#include <iostream>
#include <thread>
#include <chrono>
#include <atomic>


void beeb(bool Enter,int delay)
{
    while(Enter)
    {
        std::this_thread::sleep_for(std::chrono::seconds(delay));
        if(Enter)
        {
            std::cout << "Beeb\n" << "\a" << std::flush;
        }
    }

}

int main()
{
    bool Enter(true);
    int delay_seconds = 3;

    std::thread beeb_thread(beeb,Enter, delay_seconds);


    std::cout << "Press Enter to stop beebing..." << std::endl;
    std::cin.get();


    running = false;
    beeb_thread.join();

    return 0;
}