#include <iostream>
#include <thread>
#include <mutex>
#include <vector>
#include <numeric>

std::mutex mtx;
std::vector<int>shared_fib;

int fib(int n) 
{ 
    if (n <= 1) 
        return n;

    return fib(n - 1) + fib(n - 2); 
}

void fibo_thread(int index)
{
    std::lock_guard<std::mutex> lock(mtx);
    int res = fib(index);
    shared_fib.push_back(res);
}

void print_thread()
{
    std::lock_guard<std::mutex> lock(mtx);
    for (int i : shared_fib)
    {
        std::cout << i << " ";
    }
    std::cout << std::endl;
    int final_res = std::accumulate(shared_fib.begin(), shared_fib.end(), 0);
    
    std::cout <<  final_res << std::endl;
}

int main()
{
    std::thread t1(fibo_thread,4);
    std::thread t2(fibo_thread,9);
    std::thread t3(fibo_thread,14);
    std::thread t4(fibo_thread,17);

    t1.join();
    t2.join();
    t3.join();
    t4.join();

    std::thread print(print_thread);
    print.join();

    return 0;
}