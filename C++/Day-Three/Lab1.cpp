#include <iostream>

enum class ErrorCode
{
    Bad_Request = 400,
    NOT_FOUND = 404,
    SERVER_ERROR = 500,
    GATEWAY_TIMEOUT = 504,
};

void printError(ErrorCode er)
{
    switch(er)
    {
    case ErrorCode::Bad_Request:
    std::cout << "Bad Reques";
    break;

    case ErrorCode::NOT_FOUND:
    std::cout << "NOT FOUND";
    break;

    case ErrorCode::SERVER_ERROR:
    std::cout << "SERVER ERROR";
    break;

    case ErrorCode::GATEWAY_TIMEOUT:
    std::cout << "GATEWAY TIMEOUT";
    break;
    }
}

int main()
{
    printError(ErrorCode::Bad_Request);
}