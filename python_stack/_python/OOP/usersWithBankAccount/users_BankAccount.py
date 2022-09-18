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

##########################################################################################################################
	# declare a class and give it name User
class User:
    def __init__(self,name,email):
        self.name = name
        self.email = "email"
        self.account = BankAccount(.05,0)
    def make_withdrawal(self, amount):
        self.account.withdraw(amount)
        return self
        
    def display_user_balance(self):
        print(self.name,self.account_balance)
        self.account.display_account_info()
        return self

    def deposit(self, amount):
        self.account.deposit(amount)
        return self
#########################################################################################################################
dana = User ("dana", "dana.alhaji95@gmail.com")
dana.account['account1'].deposit(2000)
dana.account['account1'].display_account_info()
dana.account.update({'account2': (.05,200)})
dana.account['account2'].display_account_info()
