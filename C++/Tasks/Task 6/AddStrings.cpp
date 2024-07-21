#include <iostream>
#include <string>
#include <math.h>

class Solution
{
public:
    std::string addStrings(std::string num1, std::string num2)
    {
        int carry = 0;
        std::string result = "";
        int i = 0, j = 0;

        int sum = 0;

        std::reverse(num1.begin(), num1.end());
        std::reverse(num2.begin(), num2.end());

        while (i < num1.size() && j < num2.size())
        {
            sum = int(num1[i] - '0') + int(num2[j] - '0') + carry;
            carry = sum / 10;

            result.push_back(sum % 10 + '0');
            i++;
            j++;
        }
        while (i < num1.size())
        {
            sum = int(num1[i] - '0') + carry;
            carry = sum / 10;
            result.push_back(sum % 10 + '0');
            i++;
        }
        while (j < num2.size())
        {
            sum = int(num2[j] - '0') + carry;
            carry = sum / 10;
            result.push_back(sum % 10 + '0');
            j++;
        }
        while (carry)
        {
            result.push_back(char(carry) + '0');
            carry--;
        }
        std::reverse(result.begin(), result.end());
        return result;
    }
};

int main()
{
    Solution s;
    std::string num1 = "11";
    std::string num2 = "123";
    std::cout << s.addStrings(num1, num2) << std::endl;
}