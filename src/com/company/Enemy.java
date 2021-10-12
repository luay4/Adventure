package com.company;

import java.util.ArrayList;

public class Enemy {
    private int enemyHealth;
    private String enemyName;
    private String enemyDescription;
    ArrayList<Item> enemyItems = new ArrayList<>();
    private Weapon enemyWeapon;

    public Enemy(int health, String name, String description, Weapon enemyWeapon) {
        this.enemyHealth = health;
        this.enemyName = name;
        this.enemyDescription = description;
        this.enemyWeapon = enemyWeapon;
    }

    public Weapon getEnemyWeapon() {
        return enemyWeapon;
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
