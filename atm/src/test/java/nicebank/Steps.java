package nicebank;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class Steps {

    class Account{
        private Money balance = new Money();

        public void deposit (Money amount) {
            balance = balance.add(amount);
        }

        public Money getBalance(){
            return balance;
        }
    }

    @Given("^I have deposited \\$(\\d+)\\.(\\d+) in my account$")
    public void i_have_deposited_$_in_my_account(int dollars, int cents) throws Throwable {
        Account myAccount = new Account();
        Money amount = new Money(dollars, cents);
        myAccount.deposit(amount);

        Assert.assertEquals("Incorrect account balance - ", amount, myAccount.getBalance());
    }


    @When("^I request \\$(\\d+)$")
    public void i_request_$(int arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^\\$(\\d+) should be dispensed$")
    public void $_should_be_dispensed(int arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

}
