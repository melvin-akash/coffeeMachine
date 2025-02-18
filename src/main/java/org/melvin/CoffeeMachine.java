package org.melvin;

import java.util.*;

public class CoffeeMachine {

    private static boolean machine = false;

    private int water = 400;
    private int milk = 540;
    private int coffeeBeans = 120;
    private int disposableCups = 9;
    private int money = 550;
    final static Scanner sc = new Scanner(System.in);
    int noOfCoffeeMade;

    public CoffeeMachine() {
        this.noOfCoffeeMade = 0;
        machine = true;
    }

    public static void main(String[] args) {

        CoffeeMachine machineObj =new CoffeeMachine();
        while(machine) {
            machineObj.cofeeMachineActions();
        }

    }

    private void cofeeMachineActions() {

        System.out.println("\nWrite action (buy, fill, clean, take, remaining, exit): ");
        String action = sc.nextLine();
        action = action.trim();

        switch (action){
            case "buy":
                if(noOfCoffeeMade != 0 && noOfCoffeeMade % 10 == 0){
                    System.out.println("I need cleaning!");
                    break;
                }
                buyAction();
                break;
            case "fill":
                fillAction();
                break;
            case "clean":
                cleanAction();
                break;
            case "take":
                takeAction();
                break;
            case "remaining":
                coffeeMachineHoldings();
                break;
            case "exit":
                machine = false;
                break;
            default:
                System.out.println("Invalid option");

        }
    }

    private void cleanAction() {
        System.out.println("I have been cleaned!");
        this.noOfCoffeeMade = 0;
    }

    private void takeAction() {
        int presentMoney = this.money;
        System.out.printf("I gave you $%d\n" ,presentMoney);
        this.money = 0;
    }

    private void fillAction() {
        System.out.println("Write how many ml of water you want to add: ");
        int fillWater = sc.nextInt();
        System.out.println("Write how many ml of milk you want to add: ");
        int fillMilk = sc.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add: ");
        int fillCoffeeBeans = sc.nextInt();
        System.out.println("Write how many disposable cups you want to add: ");
        int fillCups = sc.nextInt();

        this.water += fillWater;
        this.milk += fillMilk;
        this.coffeeBeans += fillCoffeeBeans;
        this.disposableCups += fillCups;

    }

    private void buyAction() {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        String option = sc.nextLine();
        int count = 0;  // used for debugging and can be used later
        count = switch (option){
            case "1" ->
                    makeEspresso(checkIngredients(1));
            case "2" ->
                    makelatte(checkIngredients(2));
            case "3" ->
                    makeCappuccino(checkIngredients(3));
            case "back" ->
                    -1; // returning -1 for back

            default -> throw new IllegalStateException("Unexpected value: " + option);
        };
        //incrementing if 1 coffee is made
        if(count == 1){
            this.noOfCoffeeMade++;
        }

        if(count == -1){
            cofeeMachineActions();
        }

    }

    private boolean checkIngredients(int option) {

        //espresso
        if(option == 1){
            if(!(water >=250)){
                System.out.println("Sorry, not enough water!");
                return false;
            }
//            if(!(milk >= 0)){
//                System.out.println("Sorry, not enough milk!");
//                return false;
//            }
            if(!(coffeeBeans >= 16)){
                System.out.println("Sorry, not enough coffee beans!");
                return false;
            }
            if(!(disposableCups >=1)){
                System.out.println("Sorry, not enough disposable cups!");
                return false;
            }

            return true;
        }

        //latte
        if(option == 2){
            if(!(water >= 350)){
                System.out.println("Sorry, not enough water!");
                return false;
            }
            if(!(milk >= 75)){
                System.out.println("Sorry, not enough milk!");
                return false;
            }
            if(!(coffeeBeans >= 20)){
                System.out.println("Sorry, not enough coffee beans!");
                return false;
            }
            if(!(disposableCups >=1)){
                System.out.println("Sorry, not enough disposable cups!");
                return false;
            }

            return true;
        }

        //cappucino
        if(option == 3){

            if(!(water >= 200)){
                System.out.println("Sorry, not enough water!");
                return false;
            }
            if(!(milk >= 100)){
                System.out.println("Sorry, not enough milk!");
                return false;
            }
            if(!(coffeeBeans >= 12)){
                System.out.println("Sorry, not enough coffee beans!");
                return false;
            }
            if(!(disposableCups >=1)){
                System.out.println("Sorry, not enough disposable cups!");
                return false;
            }

            return true;
        }

        return false;
    }

    private int makeCappuccino(boolean make) {
        int count = 0;
        if (!make){
            return -1;
        }
        System.out.println("I have enough resources, making you a coffee!");
        if(checkIngredients(3)){
            count++;

            money += 6;
            water -= 200;
            milk -= 100;
            coffeeBeans -= 12;
            disposableCups--;
        }
        return count;
    }

    private int makelatte(boolean make) {
        int count = 0;
        if (!make){
            return -1;
        }
        System.out.println("I have enough resources, making you a coffee!");
        if(checkIngredients(2)){
            count++;

            money += 7;
            water -= 350;
            milk -= 75;
            coffeeBeans -= 20;
            disposableCups--;
        }
        return count;
    }

    private int makeEspresso(boolean make) {
        int count = 0;
        if (!make){
            return -1;
        }
        System.out.println("I have enough resources, making you a coffee!");
        if(checkIngredients(1)){
            count++;

            money += 4;
            water -= 250;
            milk -= 0;
            coffeeBeans -= 16;
            disposableCups--;
        }
        return count;

    }

    private void coffeeMachineHoldings() {
        System.out.println("The coffee machine has:");
        System.out.printf("%d ml of water\n" , water);
        System.out.printf("%d ml of milk\n" , milk);
        System.out.printf("%d g of coffee beans\n" , coffeeBeans);
        System.out.printf("%d disposable cups\n" , disposableCups);
        System.out.printf("$%d of money\n" , money);
    }
    /*

    private int noOfCoffeePossible(int waterQuantity, int milkQuatity, int coffeeBeansQuantity) {
        int count = 0;
        while(waterQuantity >= 0 && milkQuatity >= 0 && coffeeBeansQuantity >= 0){
            waterQuantity -= waterForOneCup;
            milkQuatity -= milkForOneCup;
            coffeeBeansQuantity -= beansForOneCup;

            if(waterQuantity >=0 && milkQuatity >=0 && coffeeBeansQuantity >=0 ){
                count++;
            }
        }
        return count;
    }
    */

}