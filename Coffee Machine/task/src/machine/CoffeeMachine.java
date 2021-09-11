package machine;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CoffeeMachine {
    static final int[] ingredients = new int[5];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ingredients[0] = 400;
        ingredients[1] = 540;
        ingredients[2] = 120;
        ingredients[3] = 9;
        ingredients[4] = 550;

        getAction(ingredients, scanner);

//        ingredientCalculator(scanner, ingredients);
//        System.out.println("Starting to make a coffee\n" +
//                "Grinding coffee beans\n" +
//                "Boiling water\n" +
//                "Mixing boiled water with crushed coffee beans\n" +
//                "Pouring coffee into the cup\n" +
//                "Pouring some milk into the cup\n" +
//                "Coffee is ready!");
    }

    public static void showState(int[] ingredients) {
        System.out.println();
        System.out.println("The coffee machine has:");
        System.out.println(ingredients[0] + " ml of water");
        System.out.println(ingredients[1] + " ml of milk");
        System.out.println(ingredients[2] + " g of coffee beans");
        System.out.println(ingredients[3] + " disposable cups");
        System.out.println("$" + ingredients[4] + " of money");
    }

    public static void getAction(int[] ingredients, Scanner scanner) {
        boolean askAgain = true;
        while (askAgain) {
            System.out.println();
            System.out.println("Write action (buy, fill, take, remaining, exit): ");
            String action = scanner.nextLine();
            switch (action) {
                case "buy":
                    buy(ingredients, scanner);
                    break;
                case "fill":
                    fill(ingredients, scanner);
                    break;
                case "take":
                    take(ingredients, scanner);
                    break;
                case "remaining":
                    showState(ingredients);
                    break;
                case "exit":
                    askAgain = false;
            }
        }
    }

    public static void buy(int[] ingredients, Scanner scanner) {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
        String coffeeType = scanner.nextLine();
        if (coffeeType.equalsIgnoreCase("back")) {
            return;
        } else {
            switch (Integer.parseInt(coffeeType)) {
                case 1: {
                    if (ingredients[0] - 250 >= 0
                            && ingredients[2] - 16 >= 0
                            && ingredients[3] - 1 >= 0) {
                        System.out.println("I have enough resources, making you a coffee!");
                        ingredients[0] = ingredients[0] - 250;
                        ingredients[2] = ingredients[2] - 16;
                        ingredients[3] = ingredients[3] - 1;
                        ingredients[4] += 4;
                    } else {
                        if (ingredients[0] - 250 < 0) {
                            System.out.println("Sorry, not enough water!");
                        } else if (ingredients[2] - 16 < 0) {
                            System.out.println("Sorry, not enough milk!");
                        } else if (ingredients[3] - 1 < 0) {
                            System.out.println("Sorry, not enough disposable cups!");
                        }
                    }
                    break;
                }
                case 2: {
                    if (ingredients[0] - 350 >= 0
                            && ingredients[1] - 75 >= 0
                            && ingredients[2] - 20 >= 0
                            && ingredients[3] - 1 >= 0) {
                        System.out.println("I have enough resources, making you a coffee!");
                        ingredients[0] = ingredients[0] - 350;
                        ingredients[1] = ingredients[1] - 75;
                        ingredients[2] = ingredients[2] - 20;
                        ingredients[3] = ingredients[3] - 1;
                        ingredients[4] += 7;
                    } else {
                        if (ingredients[0] - 350 < 0) {
                            System.out.println("Sorry, not enough water!");
                        } else if (ingredients[1] - 75 < 0) {
                            System.out.println("Sorry, not enough milk!");
                        } else if (ingredients[2] - 20 < 0) {
                            System.out.println("Sorry, not enough coffee beans!");
                        } else if (ingredients[3] - 1 < 0) {
                            System.out.println("Sorry, not enough disposable cups!");
                        }
                    }
                    break;
                }
                case 3: {
                    if (ingredients[0] - 200 >= 0
                            && ingredients[1] - 100 >= 0
                            && ingredients[2] - 12 >= 0
                            && ingredients[3] - 1 >= 0) {
                        System.out.println("I have enough resources, making you a coffee!");
                        ingredients[0] = ingredients[0] - 200;
                        ingredients[1] = ingredients[1] - 100;
                        ingredients[2] = ingredients[2] - 12;
                        ingredients[3] = ingredients[3] - 1;
                        ingredients[4] += 6;
                    } else {
                        if (ingredients[0] - 200 < 0) {
                            System.out.println("Sorry, not enough water!");
                        } else if (ingredients[1] - 100 < 0) {
                            System.out.println("Sorry, not enough milk!");
                        } else if (ingredients[2] - 12 < 0) {
                            System.out.println("Sorry, not enough coffee beans!");
                        } else if (ingredients[3] - 1 < 0) {
                            System.out.println("Sorry, not enough disposable cups!");
                        }
                    }
                    break;
                }
            }
        }

    }

    public static void fill(int[] ingredients, Scanner scanner) {
        boolean askAgain = false;
        do {
            try {
                System.out.println("Write how many ml of water you want to add: ");
                ingredients[0] += scanner.nextInt();
                System.out.println("Write how many ml of milk you want to add: ");
                ingredients[1] += scanner.nextInt();
                System.out.println("Write how many grams of coffee beans you want to add: ");
                ingredients[2] += scanner.nextInt();
                System.out.println("Write how many disposable cups of coffee you want to add: ");
                ingredients[3] += scanner.nextInt();
                askAgain = false;
            } catch (InputMismatchException e) {
                System.out.println("Please, enter the correct amount");
                askAgain = true;
            }
        } while (askAgain);
    }

    public static void take(int[] ingredients, Scanner scanner) {
        System.out.println("I gave you " + "$" + ingredients[4]);
        ingredients[4] = 0;
    }

//    public static void ingredientCalculator(Scanner scanner, int[] ingredients) {
//        int numberOfCupsCanMake = 0;
//        while (ingredients[0] - 200 >= 0 && ingredients[1] - 50 >= 0 && ingredients[2] - 15 >= 0) {
//            ingredients[0] = ingredients[0] - 200;
//            ingredients[1] = ingredients[1] - 50;
//            ingredients[2] = ingredients[2] - 15;
//            numberOfCupsCanMake++;
//        }
//        System.out.println("Write how many cups of coffee you will need: ");
//        int numberOfCups = scanner.nextInt();
//        if (numberOfCups == numberOfCupsCanMake) {
//            System.out.println("Yes, I can make that amount of coffee");
//        } else if (numberOfCups < numberOfCupsCanMake) {
//            int reminder = numberOfCupsCanMake - numberOfCups;
//            System.out.println("Yes, I can make that amount of coffee (and even " + reminder + " more than that)");
//        } else {
//            System.out.println("No, I can make only " + numberOfCupsCanMake + " cup(s) of coffee");
//        }
//        System.out.println("For " + numberOfCups + " cups of coffee you will need: ");
//        System.out.println(numberOfCups * 200 + " ml of water");
//        System.out.println(numberOfCups * 50 + " ml of milk");
//        System.out.println(numberOfCups * 15 + " g of coffee beans");
//    }

//    public static int[] requestIngredients(Scanner scanner) {
//        int[] ingredients = new int[3];
//        try {
//            System.out.println("Write how many ml of water the coffee machine has: ");
//            ingredients[0] = scanner.nextInt();
//            System.out.println("Write how many ml of milk the coffee machine has: ");
//            ingredients[1] = scanner.nextInt();
//            System.out.println("Write how many grams of coffee beans the coffee machine has: ");
//            ingredients[2] = scanner.nextInt();
//        } catch (InputMismatchException inputMismatchException) {
//            System.out.println("Enter the correct amount in numbers, please");
//        }
//        return ingredients;
//    }
}
