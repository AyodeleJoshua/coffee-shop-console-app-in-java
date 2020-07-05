package machine;
import java.util.Scanner;

public class CoffeeMachine {
    static Scanner scanner = new Scanner(System.in);

    //main starts here
    public static void main(String[] args) {

        String action;

        //buy, fill, take, remaining, exit

        do {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            action = scanner.next();
            if(action.equals("buy") || action.equals("take") || action.equals("remaining") || action.equals("fill")) {

                CoffeeMachine myCoffeeMachine = new CoffeeMachine(action);
            }
        } while (!action.equals("exit"));
    } //main ends here

    private static int water = 400;
    private static int milk = 540;
    private static int coffeeBeans = 120;
    private static int disposableCup = 9;
    private static int money = 550;

    CoffeeMachine(String action) {

        switch (action) {
            case "buy":
                System.out.println();
                System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
                String option = scanner.next();
                this.buy(option);
                break;
            case "fill":
                System.out.println();
                System.out.println("Write how many ml of water do you want to add:");
                int waterToAdd = scanner.nextInt();
                System.out.println("Write how many ml of milk do you want to add:");
                int milkToAdd = scanner.nextInt();
                System.out.println("Write how many grams of coffee beans do you want to add:");
                int coffeeBeansToAdd = scanner.nextInt();
                System.out.println("Write how many disposable cups of coffee do you want to add:");
                int disposableCupsToAdd = scanner.nextInt();
                fill(waterToAdd, milkToAdd, coffeeBeansToAdd, disposableCupsToAdd);
                break;
            case "take":
                System.out.println();
                take();
                System.out.println();
                break;
            case "remaining":
                System.out.println();
                    System.out.println("The coffee machine has:");
                    System.out.println(getWater() + " of water");
                    System.out.println(getMilk() + " of milk");
                    System.out.println(getCoffeeBeans() + " of coffee beans");
                    System.out.println(getDisposableCup() + " of disposable cups");
                    if (money == 0) {
                        System.out.println(money + " of money");
                    } else {
                        System.out.println("$" + money + " of money");
                    }
                    System.out.println();
                break;

        }

    }

    public void setWater(int water) {
        this.water = water;
    }

    public int getWater() {
        return water;
    }

    public void setMilk(int milk) {
        this.milk = milk;
    }

    public int getMilk() {
        return milk;
    }

    public void setCoffeeBeans(int coffeeBeans) {
        this.coffeeBeans = coffeeBeans;
    }

    public int getCoffeeBeans() {
        return coffeeBeans;
    }

    public void setDisposableCup(int disposableCup) {
        this.disposableCup = disposableCup;
    }

    public int getDisposableCup() {
        return disposableCup;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public void buy(String option) {

        if (option.equals("1")) {

            int waterPerCup = 250;
            int coffeeBeansPerCup = 16;

            if (getWater() - waterPerCup < 0) {
                System.out.println("Sorry, not enough water!");
            } else if (getCoffeeBeans() - coffeeBeansPerCup < 0) {
                System.out.println("Sorry, not enough coffee beans!");
            } else {
                System.out.println("I have enough resources, making you a coffee!");
                setWater(getWater() - waterPerCup);
                setCoffeeBeans(getCoffeeBeans() - coffeeBeansPerCup);
                setDisposableCup(getDisposableCup() - 1);
            }

        } else if (option.equals("2")) {

            int waterPerCup = 350;
            int milkPerCup = 75;
            int coffeeBeansPerCup = 20;

            if (getWater() - waterPerCup < 0) {
                System.out.println("Sorry, not enough water!");

            } else if (getCoffeeBeans() - coffeeBeansPerCup < 0) {
                System.out.println("Sorry, not enough coffee beans!");

            } else if (getMilk() - milkPerCup < 0) {
                System.out.println("Sorry, not enough milk!");

            } else {
                System.out.println("I have enough resources, making you a coffee!");
                setWater(getWater() - waterPerCup);
                setCoffeeBeans(getCoffeeBeans() - coffeeBeansPerCup);
                setMilk(getMilk() - milkPerCup);
                setDisposableCup(getDisposableCup() - 1);
            }

        } else if (option.equals("3")) {

            int waterPerCup = 200;
            int milkPerCup = 100;
            int coffeeBeansPerCup = 12;

            if (getWater() - waterPerCup < 0) {
                System.out.println("Sorry, not enough water!");

            } else if (getCoffeeBeans() - coffeeBeansPerCup < 0) {
                System.out.println("Sorry, not enough coffee beans!");

            } else if (getMilk() - milkPerCup < 0) {
                System.out.println("Sorry, not enough milk!");


            } else {
                System.out.println("I have enough resources, making you a coffee!");
                setWater(getWater() - waterPerCup);
                setCoffeeBeans(getCoffeeBeans() - coffeeBeansPerCup);
                setMilk(getMilk() - milkPerCup);
                setDisposableCup(getDisposableCup() - 1);
            }

        } else if (option.equals("back")) {

        } else {

        }
    }

    public void fill(int waterToAdd, int milkToAdd, int coffeeBeansToAdd, int disposableCupsToAdd) {
        setWater(getWater() + waterToAdd);
        setMilk(getMilk() + milkToAdd);
        setCoffeeBeans(getCoffeeBeans() + coffeeBeansToAdd);
        setDisposableCup(getDisposableCup() + disposableCupsToAdd);
    }

    public void take() {
        System.out.println("I gave you $" + getMoney());
        setMoney(0);
    }
}