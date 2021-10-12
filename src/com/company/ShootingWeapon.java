package com.company;

public class ShootingWeapon extends Weapon {
    private int ammo;

    public ShootingWeapon(String itemName, String itemDescription, int weaponDamage, int ammo) {
        super(itemName, itemDescription, weaponDamage);
        this.ammo = ammo;
    }

    public int getAmmo() {
        return ammo;
    }

    public void setAmmo(int ammo) {
        this.ammo = ammo;
    }
}
