package machine;

import java.util.Scanner;

public class CoffeeMachine {
    private static int water = 400;
    private static int milk = 540;
    private static int coffee = 120;
    private static int cups = 9;
    private static int money = 550;
    private static boolean turnOff = false;


    public static void main(String[] args) {
        do {
            newAction();
        } while (!turnOff);
    }

    private static void newAction(){
        System.out.println("Write action (buy, fill, take, remaining, exit): ");
        Scanner scanner = new Scanner(System.in);
        String action = scanner.next();
        switch (action) {
            case "buy":
                buy();
                break;
            case "fill":
                fill();
                break;
            case "take":
                take();
                break;
            case "exit":
                turnOff = true;
                break;
            case "remaining":
                printLeftover();
                break;
            default:
                System.out.println("Choose other action");
                break;
        }
    }

    private static void printLeftover(){
        System.out.println("The coffee machine has:");
        System.out.println(water + " of water");
        System.out.println(milk + " of milk");
        System.out.println(coffee + " of coffee beans");
        System.out.println(cups + " of disposable cups");
        System.out.println(money + " of money");
    }

    private static void take() {
        System.out.println("I gave you " + money);
        money = 0;
    }

    private static void buy(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
        String position = scanner.next();
        switch (position) {
            case "1":
                makeEspresso();
                break;
            case "2":
                makeLatte();
                break;
            case "3":
                makeCapuccino();
                break;
            case "back":
                break;
            default:
                System.out.println("Sorry!");
        }
    }
    private static void fill(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write how many ml of water do you want to add: ");
        water += scanner.nextInt();
        System.out.println("Write how many ml of milk do you want to add: ");
        milk += scanner.nextInt();
        System.out.println("Write how many grams of coffee beans do you want to add: ");
        coffee += scanner.nextInt();
        System.out.println("Write how many disposable cups of coffee do you want to add: ");
        cups += scanner.nextInt();
    }

    private static void makeCapuccino() {
        if (checkCapuccinoResources()){
            water -= 200;
            milk -= 100;
            coffee -= 12;
            cups -= 1;
            money += 6;
        }
    }

    private static void makeLatte() {
        if (checkLatteResources()){
            water -= 350;
            milk -= 75;
            coffee -= 20;
            cups -= 1;
            money += 7;
        }
    }

    private static void makeEspresso() {
        if (checkEspressoResources()){
            water -= 250;
            coffee -= 16;
            cups -= 1;
            money += 4;
        }
    }

    private static boolean checkCapuccinoResources(){
        if (water < 200){
            System.out.println("Sorry, not enough water!");
            return false;
        } else if (milk < 100){
            System.out.println("Sorry, not enough milk!");
            return false;
        } else if (coffee < 12) {
            System.out.println("Sorry, not enough coffee!");
            return false;
        } else if (cups < 1){
            System.out.println("Sorry, not enough cups!");
            return false;
        } else {
            System.out.println("I have enough resources, making you a coffee!");
            return true;
        }
    }

    private static boolean checkLatteResources(){
        if (water < 350){
            System.out.println("Sorry, not enough water!");
            return false;
        } else if (milk < 75){
            System.out.println("Sorry, not enough milk!");
            return false;
        } else if (coffee < 20) {
            System.out.println("Sorry, not enough coffee!");
            return false;
        } else if (cups < 1){
            System.out.println("Sorry, not enough cups!");
            return false;
        } else {
            System.out.println("I have enough resources, making you a coffee!");
            return true;
        }
    }

    private static boolean checkEspressoResources(){
        if (water < 250){
            System.out.println("Sorry, not enough water!");
            return false;
        } else if (coffee < 16) {
            System.out.println("Sorry, not enough coffee!");
            return false;
        } else if (cups < 1){
            System.out.println("Sorry, not enough cups!");
            return false;
        } else {
            System.out.println("I have enough resources, making you a coffee!");
            return true;
        }
    }
}

enum State {
    
}
