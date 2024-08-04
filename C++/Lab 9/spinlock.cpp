#include <iostream>
#include <thread>
#include <mutex>
#include <atomic>


int shared_variable = 1;
class Spinlock
{
public:
    Spinlock() : m_lock(ATOMIC_FLAG_INIT) {}
    ~Spinlock() {}
    void lock()
    {
        while(m_lock.test_and_set(std::memory_order_acquire))
        {
            // Spin until lock is available
        }
    }
    void unlock()
    {
        m_lock.clear(std::memory_order_release);   
    }

private:
    std::atomic_flag m_lock;
};

Spinlock spinlock;

void divide()
{
    spinlock.lock();
    shared_variable /= 2;
    std::cout << "Divided: " << shared_variable << std::endl;
    spinlock.unlock();
}

void mul()
{
    spinlock.lock();
    shared_variable *= 2;
    std::cout << "Multiplied: " << shared_variable << std::endl;
    spinlock.unlock();
}

int main()
{
    std::thread t1(mul);
    std::thread t2(divide);


    t1.join();
    t2.join();

    return 0;
}