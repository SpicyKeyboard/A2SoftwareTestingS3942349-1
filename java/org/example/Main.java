package org.example;

public class Main {
    //set username and password,
    //  change these to unique variables to get the sign in function to work, otherwise the website has a bug
    //  that will cause the register to not work at all if the user and pass are already in use
    static String username = "diffuser";
    static String password = "diffpass";

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public static void main(String[] args) throws InterruptedException {

        //first scenario
        SignUpAndSignIn signup = new SignUpAndSignIn();
        signup.SignUpAndSignIn(username, password);
        signup.getDriver().close();

        //second scenario
        AddAndRemoveItem add = new AddAndRemoveItem();
        add.AddAndRemoveItem(username, password);
        add.getDriver().close();

        //third scenario
        SearchProducts search = new SearchProducts();
        search.SearchProducts(username, password);
        search.getDriver().close();
    }
}