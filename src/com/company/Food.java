package com.company;

public class Food extends Item {
    private int healing;
    private boolean isPoisonous;

    public Food(String itemName, String itemDescription, int healing, boolean isPoisonous) {
        super(itemName, itemDescription);
        this.healing = healing;
        this.isPoisonous = isPoisonous;
    }

    public int getHealing() {
        return healing;
    }

    public void setHealing(int healing) {
        this.healing = healing;
    }

    public boolean isPoisonous() {
        return isPoisonous;
    }

    public void setPoisonous(boolean poisonous) {
        isPoisonous = poisonous;
    }
}
