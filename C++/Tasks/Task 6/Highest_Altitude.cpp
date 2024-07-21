#include <iostream>
#include <vector>
#include <algorithm>

class Solution
{
public:
    int largestAltitude(std::vector<int> &gain)
    {
        int sum = 0;
        std::vector<int> alt;
        alt.push_back(0);

        for (const auto i : gain)
        {
            sum += i;
            alt.push_back(sum);
        }
        int max = *std::max_element(alt.begin(), alt.end());

        return max;
    }
};

int main()
{
    std::vector<int> gain = {5,
                             1,
                             5,
                             0};
    Solution s;
    std::cout << s.largestAltitude(gain) << std::endl;
}