#include <iostream>
#include <string>

int main()
{
    std::string txt = "The cycle of the life is a cycle of cycles.";
    int inc = 0;
    int count = 0;

    for (size_t i = 0; i < txt.length(); i++)
    {
        size_t found = txt.find("cycle", i += inc);
        if (found != std::string::npos)
        {
            count++;
            txt.replace(found, 5, "circle");
            txt.insert(found, "great ");

            if (count == 2)
            {
                txt.insert(found, "never-ending ");
            }

            inc = 5;
        }
        else
        {
            inc = 0;
        }
    }

    std::cout << txt << std::endl;
}