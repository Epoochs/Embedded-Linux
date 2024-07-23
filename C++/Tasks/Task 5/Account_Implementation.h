#ifndef _ACCOUNT_H_
#define _ACCOUNT_H_

class Account
{
private:
    static int m_noOfAccounts;
    static int m_totalAmount;
    static int m_totalNbDeposits;
    static int m_totalNbWithdrawals;

    // To use time functions --> #include <ctime>
    static void m_displayTimeStamp(void); // Displays the current timestamp (Will be used in static void displayTimeStamp())

    Account(void);

    int m_accountIndex;
    int m_amount;
    int m_noOfDeposits;
    int m_noOfWithdrawals;

public:
    using acc = Account;

    static int getNoOfAccounts(void);
    static int getTotalAmount(void);
    static int getNbDeposites(void);
    static int getNbWithdrawals(void);
    static void DisplayAccountInfos(void);

    Account(int intitial_deposite);
    ~Account();

    void makeDeposite(int deposite);
    void makeWithdrawal(int withdrawal);
    int checkAmount() const;
    void displayStatus(void) const;
};

Account::Account(/* args */)
{
}

Account::~Account()
{
}

#endif /* _ACCOUNT_H_ */