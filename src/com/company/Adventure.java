package com.company;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Adventure {

    private static final Map map = new Map();

    public static void main(String[] args) {

        Room currentRoom = map.getCurrentRoom();
        Player player = new Player(currentRoom);

        boolean goOn = true;

        System.out.println("Welcome to the spooky forest game >:D\n");

        System.out.println("You are now in " + player.getCurrentRoom().getRoomName() + "\n " + player.getCurrentRoom().getRoomDescription());
        System.out.println("Which direction do you want to go to?: ");
        while (goOn) {
            Scanner in = new Scanner(System.in);
            String input = in.nextLine().toLowerCase();

            /*switch (input) {
                case "go north", "north", "n":
                    player.goNorth();
                    break;
                case "go south", "south", "s":
                    player.goSouth();
                    break;
                case "go east", "east", "e":
                    player.goEast();
                    break;
                case "go west", "west", "w":
                    player.goWest();
                    break;
                case "look", "l":
                    player.look();
                    break;
                case "help", "h":
                    player.help();
                    break;
                case "exit":
                    System.out.println("Thanks for playing!");
                    goOn = false;
                    break;
                case "inventory", "i":
                    System.out.println(player.printInventory());
                    break;
            }*/

            if (input.equals("go north") || input.equals("north") || input.equals("n")) {
                player.goNorth();
            }

            else if (input.equals("go south") || input.equals("south") || input.equals("s")) {
                player.goSouth();
            }

            else if (input.equals("go east") || input.equals("east") || input.equals("e")) {
                player.goEast();
            }

            else if (input.equals("go west") || input.equals("west") || input.equals("w")) {
                player.goWest();
            }
            else if (input.equals("look") || input.equals("l")) {
                player.look();
            } else if (input.equals("help") || (input.equals("h"))) {
                player.help();
            } else if (input.equals("exit") || input.equals("ex")) {
                System.out.println("Thanks for playing");
                break;
            } else if (input.equals("inventory") || input.equals("i")) {
                System.out.println(player.printInventory());
            } else if (input.startsWith("take")) {
                if (input.contains(" ")) {
                    String itemName = input.substring(input.indexOf(" ") + 1);
                    player.take(itemName);
                }
            } else if (input.startsWith("drop")) {
                if (input.contains(" ")) {
                    String itemName = input.substring(input.indexOf(" ") + 1);
                    player.drop(itemName);
                }
            } else if (input.startsWith("eat")) {
                if (input.contains(" ")) {
                    String itemName = input.substring(input.indexOf(" ") + 1);
                    player.eat(itemName);
                }
            } else if (input.startsWith("equip")) {
                if (input.contains(" ")) {
                    String itemName = input.substring(input.indexOf(" ") + 1);
                    player.equip(itemName);
                }
            } else if (input.startsWith("attack")) {
                if (input.contains(" ")) {
                    String itemName = input.substring(input.indexOf(" ") + 1);
                    player.attack(itemName);
                }
            } else {
                System.out.println("Cannot do that, try something else");
            }

        }
    }
}