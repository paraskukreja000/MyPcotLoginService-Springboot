# MyPcotLoginService-Springboot ->
The system works like a UPI system for online payments where the same email address can be used for multiple accounts.

# Features ->
  It allows users to register and log in using their email address and password.
  A user can add a bank account once they have logged in.
  Users can view all bank accounts linked to their email addresses.
  Money can be deposited and withdrawn using their account number.
  A user can also delete their bank account to remove it.

# Payloads ->
  * Register ->
      - url -> "/register"
      - body -> { "email":"abc@g.com", "password":"abc", "name":"test", "gender":"Male"}
  * Login ->
      url -> "/login"
      body -> {"email":"abc@g.com", "password":"abc" }

  * To get all account link to a email ->
      url -> "/allAccounts"
      body -> {"email":"abc@g.com"}
      
  * To get details of a account by account number ->
      url -> "/accountByAccno"
      body ->{"email":"abc@g.com", "accno":123}
      
  * To add a bank account ->
      url -> "/addAcc"
      body -> {"email":"abc@g.com", "accno":123, "name":"TestName", "balance":1200}

  * To deposit and withdraw money by account number->
      url -> 
            deposit -> "/deposit"
            withdraw -> "/withdraw"
      body -> {"email":"abc@g.com", "accno":123, "currency":1234}

  * To update name in a bank account ->
      url -> "/updateName"
      body -> {"email":"abc@g.com", "accno":123, "name":"TestName"}

  * To remove a bank account ->
      url -> "/delete/{accno}"
      param -> /123
