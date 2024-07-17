#include <iostream>
#include <vector>
#include <time.h>

class Battleship
{
public:
    Battleship(int maxGuesses) : m_maxGuesses(maxGuesses)
    {
        board.resize(5 + 1, std::vector<bool>(5, false));
        loc_x = rand() % 6;
        loc_y = rand() % 6;
        board[loc_x][loc_y] = true;
        guesses = 0;
        win = 0;
    }

    bool guess(int x, int y)
    {
        if (board[y][x])
        {

            guesses++;
            std::cout << "You sunk my battleship!\n";
            std::cout << "you guessed after " << guesses << " guesses" << std::endl;
            win = 1;
            return true;
        }
        else
        {
            guesses++;
            std::cout << "Magatsh feha y zaky!, you have only " << (m_maxGuesses - guesses) << " guesses w t5sr" << std::endl;
            return false;
        }
    }

    int get_guesses() const
    {
        return guesses;
    }

    bool gameOver() const
    {
        return (guesses >= m_maxGuesses) || win;
    }

private:
    int m_maxGuesses;
    int guesses;
    int loc_x;
    int loc_y;
    int win;
    std::vector<std::vector<bool>> board;
};

int main()
{
    srand(time(NULL));
    std::cout << "Enter the Max. guesses: ";
    int guesses;
    std::cin >> guesses;

    Battleship game(guesses);

    int x, y;
    while (!game.gameOver())
    {
        std::cout << "Enter the x and y coordinates: ";
        std::cin >> x >> y;
        game.guess(x, y);
    }
    if (game.get_guesses() >= guesses)
        std::cout << "You lost!\n";
}