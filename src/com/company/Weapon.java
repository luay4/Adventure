package com.company;

public class Weapon extends Item {
    private int weaponDamage;
    private int ammo = -1;

    public Weapon(String itemName, String itemDescription, int weaponDamage) {
        super(itemName, itemDescription);
        this.weaponDamage = weaponDamage;
    }

    public Weapon(String itemName, String itemDescription, int weaponDamage, int ammo) {
        super(itemName, itemDescription);
        this.weaponDamage = weaponDamage;
        this.ammo = ammo;
    }

    public int getWeaponDamage() {
        return weaponDamage;
    }

    public void setWeaponDamage(int weaponDamage) {
        this.weaponDamage = weaponDamage;
    }

    public int getAmmo() {
        return ammo;
    }

    public void setAmmo(int ammo) {
        this.ammo = ammo;
    }
}
