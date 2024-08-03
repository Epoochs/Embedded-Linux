#include <iostream>
#include <vector>
#include <thread>
#include <mutex>
#include <condition_variable>

// Shared data structure
struct SharedData {
    std::vector<int> fib{0, 0, 0, 0}; // to store Fibonacci numbers
    int count = 0;                    // to count how many Fibonacci numbers have been calculated
    std::mutex mtx;                   // to protect shared data
    std::condition_variable cv;       // to notify the print thread
} data;

// Function to calculate Fibonacci number
int fibonacci(int n) {
    if (n <= 1) return n;
    return fibonacci(n - 1) + fibonacci(n - 2);
}

// Thread function to calculate Fibonacci number and store in shared memory
void calculate_fibonacci(int index, int fib_index) {
    int result = fibonacci(fib_index);

    std::lock_guard<std::mutex> lock(data.mtx);
    data.fib[index] = result;
    data.count++;
    if (data.count == 4) {
        data.cv.notify_one();
    }
}

// Thread function to print results and calculate the sum
void print_results() {
    std::unique_lock<std::mutex> lock(data.mtx);
    data.cv.wait(lock, [] { return data.count == 4; });

    int sum = 0;
    for (int i = 0; i < 4; i++) {
        std::cout << "Fibonacci number at index " << (i + 1) * 5 << ": " << data.fib[i] << std::endl;
        sum += data.fib[i];
    }
    std::cout << "Sum of Fibonacci numbers: " << sum << std::endl;
}

int main() {
    std::vector<std::thread> threads;
    int indices[4] = {4, 9, 14, 17};

    for (int i = 0; i < 4; i++) {
        threads.emplace_back(calculate_fibonacci, i, indices[i]);
    }

    std::thread print_thread(print_results);

    for (auto& th : threads) {
        th.join();
    }
    print_thread.join();

    return 0;
}
