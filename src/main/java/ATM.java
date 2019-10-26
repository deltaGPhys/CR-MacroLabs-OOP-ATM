import java.io.IOException;
import java.util.ArrayList;

public class ATM {

    private User currentUser;
    // 0: ID 1: Last Name 2: First Name 3: cardNum 4: PW
    private DB userDB;

    // 0: credit/debit 1: accountID 2: amount (signed) 3: timeStamp 4: description
    private DB transactionDB;

    // 0: accountID 1: ownerID 2: balance 3: type 4: risk/interest/null (type-dependent)
    private DB accountDB;

    public ATM(String userDBName, String accountDBName, String transactionDBName) {
        this.currentUser = null;
        try {
            this.userDB = new DB(userDBName, 5);
            this.transactionDB = new DB(transactionDBName, 5);
            this.accountDB = new DB(accountDBName, 5);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public User getCurrentUser() {
        return this.currentUser;
    }

    public DB getUserDB() {
        return this.userDB;
    }

    public DB getTransactionDB() {
        return this.transactionDB;
    }

    public DB getAccountDB() {
        return this.accountDB;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    public User authenticate(int cardNumber, String password) {
        return new User();
    }

    //find user info by id (helper for constructor)
    public String [] getUserInfoByID (Integer ID) {
        int rowNumOfUser = this.userDB.findPartialRow(new String[] {ID.toString()}, new int[] {0});
        return this.userDB.readRow(rowNumOfUser);
    }

    //find user info by card number (helper for constructor)
    public String [] getUserInfoByCardNum (Integer cardNum) {
        int rowNumOfUser = this.userDB.findPartialRow(new String[] {cardNum.toString()}, new int[] {3});
        return this.userDB.readRow(rowNumOfUser);
    }

    public void logOut (User currentUser) {

    }

    // log in user
    public void getUser() {
        // find user in DB

        // check PW

        // instantiate user

    }

    // add new user - called by getUser()
    public User newUser() {
        return null;
    }

    //find accounts by owner id (to then be used by constructor)
//    public ArrayList<String[]> getAccountInfoByUser (User user) {
//        int [] recordRowNums;
//        recordRowNums = this.accountDB.findPartialRowMultiple(new String[] {user.ID.toString()}, new int[] {1});
//
//        ArrayList<String[]> accountsInfo = new ArrayList<>();
//        for (int rowNum : recordRowNums) {
//            accountsInfo.add(this.accountDB.readRow(rowNum));
//        }
//
//        return accountsInfo;
//    }

    // load database info from disk
    public void loadDBs() {
//        // find accounts, create instances
//        ArrayList<String[]> accountsInfo = getAccountInfoByUser(this.currentUser);
//        ArrayList<Account> accounts = new ArrayList<>();
//        for (String[] acctInfo : accountsInfo) {
//            accounts.add(new Account(...));
//        }
//        //
    }

    // deal with the user's choices
    public void userMenu() {

    }

    // log out user
    public void logOut() {
        saveDBs();
        this.currentUser = null;
    }

    // save DBs to disk
    public void saveDBs() {
//        // write the pending transaction queue
//        for (Transaction transaction : this.currentUser.pendingTransactions) {
//            transactionDB.addRow(transaction.toStringArray());
//        }
//        // write the accounts
//        int row;
//        for (Account account : this.currentUser.accounts) {
//            // find account row, replace it
//            row =
//            this.accountDB.replaceRow(accountDB.findPartialRow(), account.toString());
//
//        }
    }

    public void serviceLoop() {

        // authenticate a user (or die trying)
        // only returns null if the magic secret exit code is called
        getUser();
        if (this.currentUser == null) { return; }

        loadDBs();

        userMenu();

        logOut();

        serviceLoop();
    }
}