package nicebank;

public class Money {

    private int dollars;
    private int cents;

    public Money(){
        this.dollars = 0;
        this.cents = 0;
    }

    public Money(int dollars, int cents){
        this.dollars = dollars;
        this.cents = cents;
    }

    public int dollars(){
        return this.dollars;
    }

    public int cents(){
        return this.cents;
    }

    public Money add(Money amount){
        int newDollars = amount.dollars() + this.dollars;
        int newCents = amount.cents() + this.cents;

        if(newCents >= 100){
            newDollars++;
            newCents -= 100;
        }

        return new Money(newDollars, newCents);
    }

    public Money minus(Money amount){
        int newDollars = amount.dollars() - this.dollars;
        int newCents = amount.cents() - this.cents;

        if(newCents < 0){
            newDollars--;
            newCents += 100;
        }

        return new Money(newDollars, newCents);
    }

    @Override
    public String toString(){
        return String.format("$%01d.%02d", this.dollars(), this.cents());
    }

    @Override
    public boolean equals(Object other){
        boolean equals = false;

        if(other instanceof Money){
            Money otherMoney = (Money) other;
            return otherMoney.dollars() == this.dollars &&
                    otherMoney.cents() == this.cents;
        }

        return equals;
    }
}
