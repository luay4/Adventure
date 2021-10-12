package com.company;

import java.util.ArrayList;

public class Player {
    private ArrayList<Item> inventory = new ArrayList<>();
    private Room currentRoom;
    private int health = 50;
    private Weapon currentWeapon;

    public Player(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }

    public void take(String item) {
        Item itemFound = findItem(item);
        if (itemFound != null) {
            inventory.add(itemFound);
            currentRoom.itemList.remove(itemFound);
            System.out.println(itemFound + " has been added to the inventory");
        } else {
            System.out.println("Could not find item");
        }
    }

    public void drop(String item) {
        Item itemFound = findItemInventory(item);
        if (itemFound != null) {
            currentRoom.itemList.add(itemFound);
            inventory.remove(itemFound);
            System.out.println(itemFound + " has been dropped");
        } else {
            System.out.println("Could not find item in inventory");
        }
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    public Item findItem(String itemName) {
        for (int i = 0; i < currentRoom.itemList.size(); i++) {
            Item requestedItem = currentRoom.itemList.get(i);
            if (requestedItem.getItemName().equals(itemName)) {
                return requestedItem;
            }
        }
        return null;
    }

    public Item findItemInventory(String itemName) {
        for (int i = 0; i < inventory.size(); i++) {
            Item requestedItem = inventory.get(i);
            if (requestedItem.getItemName().equals(itemName)) {
                return requestedItem;
            }
        }
        return null;
    }

    public Enemy findEnemy(String enemyName) {
        for (int i = 0; i < currentRoom.enemyList.size(); i++) {
            Enemy requestedEnemy = currentRoom.enemyList.get(i);
            if (requestedEnemy.getEnemyName().equals(enemyName)) {
                return requestedEnemy;
            }
        }
        return null;
    }

    public void goNorth() {
        if (currentRoom.getNorth() == null) {
            System.out.println("you cannot go there");
        } else {
            System.out.println("Going north\n");
            setCurrentRoom(currentRoom.getNorth());
            System.out.println(currentRoom.getRoomName());
            System.out.println(currentRoom.getRoomDescription());
        }
    }

    public void goEast() {
        if (currentRoom.getEast() == null) {
            System.out.println("you cannot go there");
        } else {
            System.out.println("Going east\n");
            setCurrentRoom(currentRoom.getEast());
            System.out.println(currentRoom.getRoomName());
            System.out.println(currentRoom.getRoomDescription());
        }
    }

    public void goSouth() {
        if (currentRoom.getSouth() == null) {
            System.out.println("you cannot go there");
        } else {
            System.out.println("Going south\n");
            setCurrentRoom(currentRoom.getSouth());
            System.out.println(currentRoom.getRoomName());
            System.out.println(currentRoom.getRoomDescription());
        }
    }

    public void goWest() {
        if (currentRoom.getWest() == null) {
            System.out.println("you cannot go there");
        } else {
            System.out.println("Going west\n");
            setCurrentRoom(currentRoom.getWest());
            System.out.println(currentRoom.getRoomName());
            System.out.println(currentRoom.getRoomDescription());
        }
    }

    public String printInventory() {
        String inventoryString = "Inventory:\n";
        for (int i = 0; i < inventory.size(); i++) {
            inventoryString += inventory.get(i).getItemName()+ "\n";

        }
        return inventoryString;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public Weapon getCurrentWeapon() {
        return currentWeapon;
    }

    public void setCurrentWeapon(Weapon currentWeapon) {
        this.currentWeapon = currentWeapon;
    }

    public void eat(String foodName) {
        Item requestedFood = findItemInventory(foodName);
        if (requestedFood == null) {
            System.out.println("Could not find the food you are looking for");
        }
        else if (requestedFood instanceof Food) {
            if (((Food) requestedFood).isPoisonous()) {
                health -= ((Food) requestedFood).getHealing();
                inventory.remove(requestedFood);
                System.out.println("The " + requestedFood.getItemName() + " was poisonous! " +
                        "You just lost " + ((Food) requestedFood).getHealing() + " health!");
            } else {
                health += ((Food) requestedFood).getHealing();
                inventory.remove(requestedFood);
                System.out.println("Eating the " + requestedFood.getItemName() + " healed "
                        + ((Food) requestedFood).getHealing() + " health!");
            }
        } else {
            System.out.println(requestedFood.getItemName() + " is not food");
        }
    }

    public void equip(String weaponName) {
        Item requestedWeapon = findItemInventory(weaponName);
        if (requestedWeapon == null) {
            System.out.println("Could not find weapon in inventory");
        }
        else if (requestedWeapon instanceof Weapon) {
            currentWeapon = (Weapon) requestedWeapon;
            System.out.println(requestedWeapon.getItemName() + " has been equipped");
        }
        else {
            System.out.println(requestedWeapon.getItemName() + " is not a weapon");
        }
    }

    public void attack(String enemy) {
        Enemy enemyNPC = findEnemy(enemy);
        if (enemyNPC == null) {
            System.out.println("There are no enemies of that kind in this room");
        } else {
            if (currentWeapon == null) {
                System.out.println("Cannot attack without a weapon equipped");
            } else if (currentWeapon.getAmmo() > 0) {
                System.out.println("You fire your weapon");
                currentWeapon.setAmmo(currentWeapon.getAmmo() - 1);
            } else if (currentWeapon.getAmmo() == 0) {
                System.out.println("You are out of ammo");
            }
            else {
                System.out.println("You attack with your weapon");
                enemyNPC.dealDamageToEnemy(getCurrentWeapon().getWeaponDamage());
                System.out.print("Enemy hp: ");
                System.out.println(enemyNPC.getEnemyHealth());
                if (enemyNPC.getEnemyHealth() <= 0) {
                    System.out.println("You killed the enemy!");
                    currentRoom.itemList.add(enemyNPC.getEnemyWeapon());
                    currentRoom.enemyList.remove(enemyNPC);
                } else {
                    System.out.println("The enemy attacks");
                    enemyAttacks(enemyNPC.getEnemyWeapon().getWeaponDamage());
                    System.out.print("Your hp: ");
                    System.out.println(health);
                    if (health <= 0) {
                        System.out.println("You died!");
                    }
                }
            }
        }
    }

    public void enemyAttacks(int enemyDamage) {
        health = health - enemyDamage;
    }

    public void look() {
        System.out.println(currentRoom.getRoomDescription());
        System.out.println("Current health: " + health);
        if (health >= 40) {
            System.out.println("You are at good health");
        } else if (health >= 30) {
            System.out.println("You are a little wounded");
        } else if (health >= 20) {
            System.out.println("You health is low, try eating some food");
        } else if (health >= 10) {
            System.out.println("You health is very low, avoid enemies");
        } else {
            System.out.println("You are at critical health, try not to die");
        }
        if (currentWeapon != null) {
            if (currentWeapon.getAmmo() != -1) {
                System.out.println("Equipped weapon: " + currentWeapon.getItemName()
                        + "  weapon damage: " + currentWeapon.getWeaponDamage() + "  ammo: " +
                        currentWeapon.getAmmo());
            } else {
                System.out.println("Equipped weapon: " + currentWeapon.getItemName()
                        + "  weapon damage: " + currentWeapon.getWeaponDamage());
            }
        }
    }

    public void help() {
        System.out.println("Controls:\n Type 'look' to get the description of the current room with its items and weapon and health status" +
                "\n Type any direction (north, east, south and west) to move to another room" +
                "\n Type on of these commands followed with the item that you want to interact with:\n" +
                "'take', 'drop', 'eat' and 'equip'\n" +
                " Type 'attack' followed by the name of the enemy in order to attack\n" +
                " Type 'exit' to quit the game");
    }
}
