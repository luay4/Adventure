package com.company;

public class Enemy {
    private int enemyHealth;
    private int enemyDamage;
    private String enemyName;
    private String enemyDescription;
    private Room currentRoom;

    public Enemy(int health, int damage, String name, String description, Room currentRoom) {
        this.enemyHealth = health;
        this.enemyDamage = damage;
        this.enemyName = name;
        this.enemyDescription = description;
        this.currentRoom = currentRoom;
    }

    public int getEnemyDamage() {
        return enemyDamage;
    }

    public int getEnemyHealth() {
        return enemyHealth;
    }

    public String getEnemyName() {
        return enemyName;
    }

    public String getEnemyDescription() {
        return enemyDescription;
    }

    public void dealDamageToEnemy(int weaponDamage) {
        this.enemyHealth = enemyHealth - weaponDamage;

    }

}
