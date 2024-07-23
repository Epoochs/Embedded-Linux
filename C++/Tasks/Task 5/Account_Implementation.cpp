#include <iostream>
#include <ctime>
#include "Account_Implementation.h"

/* Constructors and Destructors */
Account::Account(void) : m_amount(0), m_accountIndex(0), m_noOfDeposits(0), m_noOfWithdrawals(0)
{
    m_accountIndex = m_noOfAccounts++;
}

Account::Account(int intitial_deposite) : m_amount(0), m_accountIndex(0), m_noOfDeposits(0), m_noOfWithdrawals(0)
{
    m_amount += intitial_deposite;
    m_totalAmount += intitial_deposite;

    m_noOfDeposits++;
    m_totalNbDeposits++;
}

Account::~Account()
{
    std::cout << "\nFinish" << std::endl;
}

/* Setters */
void Account::makeDeposite(int deposite)
{
    m_noOfDeposits++;
    m_totalNbDeposits++;

    m_amount += deposite;
    m_totalAmount += deposite;
}

void Account::makeWithdrawal(int withdrawal)
{
    m_noOfWithdrawals++;
    m_totalNbWithdrawals++;

    m_amount -= withdrawal;
    m_totalAmount -= withdrawal;
}

/* Private Getters */

void Account::displayStatus(void) const
{
    m_displayTimeStamp();
    std::cout << "Total number of this account: " << m_accountIndex << std::endl;
    std::cout << "Total number of deposites for this account: " << m_noOfDeposits << std::endl;
    std::cout << "Total amount of withdrawals for this account: " << m_noOfWithdrawals << std::endl;
}

int Account::checkAmount() const
{
    return this->m_amount;
}

/* Shared Getters */

void Account::m_displayTimeStamp()
{
    std::time_t curr_time;
    curr_time = time(NULL);

    char *tm = ctime(&curr_time);
    std::cout << tm << std::endl;
}

int Account::getNoOfAccounts()
{
    return m_noOfAccounts;
}

int Account::getTotalAmount(void)
{
    return m_totalAmount;
}

int Account::getNbDeposites(void)
{
    return m_totalNbDeposits;
}

int Account::getNbWithdrawals(void)
{
    return m_totalNbWithdrawals;
}

void Account::DisplayAccountInfos(void)
{
    m_displayTimeStamp();
    std::cout << "Total number of accounts: " << m_noOfAccounts << std::endl;
    std::cout << "Total number of deposites: " << m_totalNbDeposits << std::endl;
    std::cout << "Total amount of withdrawals : " << m_totalNbWithdrawals << std::endl;
    std::cout << "Total amount of all accounts: " << m_noOfAccounts << std::endl;
}

int Account::m_noOfAccounts = 0;
int Account::m_totalAmount = 0;
int Account::m_totalNbDeposits = 0;
int Account::m_totalNbWithdrawals = 0;