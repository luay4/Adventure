package com.company;

import java.util.Scanner;

public class Adventure {

    private static final Map map = new Map();

    public static void main(String[] args) {

        Room currentRoom = map.getCurrentRoom();
        Player player = new Player(currentRoom);


        System.out.println("Welcome to this adventure game\n");

        System.out.println("You are now in " + player.getCurrentRoom().getRoomName() + "\n " + player.getCurrentRoom().getRoomDescription());
        System.out.println("Which direction do you want to go to?: ");
        while (true) {
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
                System.out.println("Controls:\n Type 'look' to get the description of the current room" +
                        "\n Type any direction (north, east, south and west) to move to another room" +
                        "\n Type 'exit' to quit the game");
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