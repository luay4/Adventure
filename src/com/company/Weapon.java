package com.company;

public abstract class Weapon extends Item {
    private int weaponDamage;

    public Weapon(String itemName, String itemDescription, int weaponDamage) {
        super(itemName, itemDescription);
        this.weaponDamage = weaponDamage;
    }

    public int getWeaponDamage() {
        return weaponDamage;
    }
}
