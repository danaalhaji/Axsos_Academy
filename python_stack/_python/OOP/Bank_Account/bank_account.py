class BankAccount:
    def __init__ (self, int_rate, balance):
        self.InitialRate = int_rate #define the interset rate
        self.bank_balance = balance # define tha bank account balance
    # method to deposite money in the bank account
    def deposit (self, amount):
        self.bank_balance += amount
        return self
    #  method to withdraw money from bank account
    def withdraw (self, amount):
        self.bank_balance -= amount
        return self
    # print the balance
    def display_account_info(self):
        print ("the current bank amount is", self.bank_balance)
    # method to calculate the interset rate and added to the bank account
    def yield_interest(self):
        if (self.bank_balance > 0):
            self.bank_balance = self.bank_balance + (self.bank_balance*self.InitialRate)
        return self
#########################################################################################################################
################################ create two bank accounts ###########################################################

bankAccount1 = BankAccount(.05, 2000)
bankAccount2 = BankAccount(.05, 2500)

# add money and withdrow from the first bank account
bankAccount1.deposit(300).deposit(550).deposit(800).withdraw(200).display_account_info()
# add money and withdrow from the second bank account
bankAccount2.deposit(550).deposit(800).withdraw(200).withdraw(20).withdraw(50).display_account_info()
