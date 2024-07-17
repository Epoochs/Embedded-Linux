#include <iostream>
#include <vector>

std::vector<std::vector<int>> Transpose(std::vector<std::vector<int>> V_2d)
{
    int rows = V_2d.size();
    int cols = V_2d[0].size();

    /* Initializing a new vector with the size of rows (the col size of the old one) and cols (the row size of the old one) and giving zeroz for the rows as a default value */
    std::vector<std::vector<int>> newMatrix(cols);

    for (const auto &i : V_2d)
    {
        for (size_t j = 0; j < i.size(); j++)
        {
            newMatrix[j].push_back(i[j]);
        }
    }

    return newMatrix;
}

int main()
{
    std::vector<std::vector<int>> matrix{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    std::vector<std::vector<int>> transposed = Transpose(matrix);

    for (const auto &i : transposed)
    {
        for (const auto &val : i)
        {
            std::cout << val << " ";
        }
        std::cout << std::endl;
    }
}