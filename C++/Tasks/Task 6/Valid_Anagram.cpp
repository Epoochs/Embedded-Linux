#include <iostream>
#include <string>
#include <algorithm>

class Solution
{
public:
    bool isAnagram(std::string s, std::string t)
    {
        std::sort(s.begin(), s.end());
        std::sort(t.begin(), t.end());
        return s == t;
    }
};

int main()
{
    Solution s;
    std::string s1 = "anagram";
    std::string s2 = "nagaram";
    std::cout << s.isAnagram(s1, s2) << std::endl;
    return 0;
}