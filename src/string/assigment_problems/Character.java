package string.assigment_problems;

public class Character {

    private int health;
    private final int maxHealth;

    public Character(int maxHealth) {
        if (maxHealth <= 0) {
            throw new IllegalArgumentException(
                "Maximum health must be positive."
            );
        }

        this.maxHealth = maxHealth;
        this.health = maxHealth;
    }

    public void takeDamage(int amount) {
        if (amount <= 0) {
            return;
        }

        health -= amount;

        if (health < 0) {
            health = 0;
        }
    }

    public void heal(int amount) {
        if (amount <= 0) {
            return;
        }

        health += amount;

        if (health > maxHealth) {
            health = maxHealth;
        }
    }

    public int getHealth() {
        return health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }
}