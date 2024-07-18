#include <iostream>
#include <string>
#include <iomanip>
#include <fstream>
#include <algorithm>

int main()
{
    std::fstream file;
    file.open("Files.txt", std::ios::in | std::ios::out);
    if (!file)
    {
        std::cerr << "File could not be opened" << std::endl;
    }

    file.trunc;

    file << std::setw(49) << std::setfill('-') << "" << std::endl;
    file << "|" << std::setw(7) << std::setfill(' ') << std::right << "Sum" << std::setw(5) << std::right;
    file << "|" << std::setw(7) << std::setfill(' ') << std::right << "Avg" << std::setw(5) << std::right;
    file << "|" << std::setw(7) << std::setfill(' ') << std::right << "Min" << std::setw(5) << std::right;
    file << "|" << std::setw(7) << std::setfill(' ') << std::right << "Max" << std::setw(5) << std::right;
    file << "|" << std::endl;
    file << std::setw(49) << std::setfill('-') << "" << std::endl;

    std::fstream file2;
    file2.open("input.txt", std::ios::in);
    int x[4];
    int i = 0;
    int sum = 0;

    while (file2 >> x[i])
    {
        sum += x[i];
        i++;
    }

    file << "|" << std::setw(7) << std::setfill(' ') << std::right << sum << std::setw(5) << std::right;
    file << "|" << std::setw(7) << std::setfill(' ') << std::right << std::setprecision(2) << std::fixed << (sum / double(i)) << std::setw(5) << std::right;
    file << "|" << std::setw(7) << std::setfill(' ') << std::right << *std::min_element(x, x + sizeof(x) / sizeof(x[0])) << std::setw(5) << std::right;
    file << "|" << std::setw(7) << std::setfill(' ') << std::right << *std::max_element(x, x + sizeof(x) / sizeof(x[0])) << std::setw(5) << std::right;
    file << "|" << std::endl;
    file << std::setw(49) << std::setfill('-') << "" << std::endl;
}