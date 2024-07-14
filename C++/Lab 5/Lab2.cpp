#include <iostream>
#include <string>

/* Using stringView */

std::string hayStack_fun(std::string source, std::string needle, std::string rep)
{
    int inc = 0;
    std::string newSource = source;

    for (size_t i = 0; i < newSource.length(); i++)
    {
        size_t found = newSource.find(needle, i += inc);
        if (found != std::string::npos)
        {
            newSource.replace(found, needle.length(), rep);
            inc = needle.length();
        }
        else
        {
            inc = 0;
        }
    }

    std::string str = "The haystack: " + source + ", " + "The needle: " + needle + ", The replacement: " + rep + "." + "\n" + "The replacement txt: " + newSource + ".";

    return str;
}

int main()
{
    std::cout << hayStack_fun("Ahmed Fathy Salem", "Fathy", "Sherif");
}