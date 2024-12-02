// Base RPG Character Interface
interface RPGCharacter {
    void showStats();
    void levelUp();
    void attack();
    void calSpeed();
    void equipItem(Equipment equipment);
}

// Equipment Class
class Equipment {
    private String name;
    private double baseValue;
    private double weight;
    private int level = 1;

    public Equipment(String name, double baseValue, double weight) {
        this.name = name;
        this.baseValue = baseValue;
        this.weight = weight;
    }

    public double calEffect() {
        return baseValue * (1 + 0.1 * level);
    }

    public double calRunPenalty() {
        return weight * (0.1 + 0.03 * level);
    }

    public void levelUp() {
        level++;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + " (Level " + level + ", Effect: " + calEffect() + ")";
    }
}

// Warrior Class
class Warrior implements RPGCharacter {
    private String name;
    private int level = 1;
    private double maxHP = 100;
    private double baseRunSpeed = 20;
    private Equipment equipment;

    public Warrior(String name) {
        this.name = name;
    }

    @Override
    public void showStats() {
        System.out.println("Warrior: " + name);
        System.out.println("Level: " + level);
        System.out.println("Max HP: " + maxHP);
        System.out.println("Run Speed: " + calRunSpeed());
        System.out.println("Equipment: " + (equipment != null ? equipment : "None"));
    }

    @Override
    public void levelUp() {
        level++;
        maxHP += 10;
        System.out.println(name + " leveled up to " + level);
    }

    @Override
    public void attack() {
        double damage = equipment != null ? equipment.calEffect() : 10;
        System.out.println(name + " attacks for " + damage + " damage!");
    }

    @Override
    public void calSpeed() {
        System.out.println("Run Speed: " + calRunSpeed());
    }

    private double calRunSpeed() {
        double penalty = equipment != null ? equipment.calRunPenalty() : 0;
        return baseRunSpeed - penalty;
    }

    @Override
    public void equipItem(Equipment equipment) {
        this.equipment = equipment;
        System.out.println(name + " equipped " + equipment.getName());
    }
}

// Archer Class
class Archer implements RPGCharacter {
    private String name;
    private int level = 1;
    private double maxHP = 90;
    private double baseRunSpeed = 25;
    private Equipment equipment;

    public Archer(String name) {
        this.name = name;
    }

    @Override
    public void showStats() {
        System.out.println("Archer: " + name);
        System.out.println("Level: " + level);
        System.out.println("Max HP: " + maxHP);
        System.out.println("Run Speed: " + calRunSpeed());
        System.out.println("Equipment: " + (equipment != null ? equipment : "None"));
    }

    @Override
    public void levelUp() {
        level++;
        maxHP += 8;
        System.out.println(name + " leveled up to " + level);
    }

    @Override
    public void attack() {
        double damage = equipment != null ? equipment.calEffect() : 5;
        System.out.println(name + " attacks with " + (equipment != null ? equipment.getName() : "bare hands") + " for " + damage + " damage!");
    }

    @Override
    public void calSpeed() {
        System.out.println("Run Speed: " + calRunSpeed());
    }

    private double calRunSpeed() {
        double penalty = equipment != null ? equipment.calRunPenalty() : 0;
        return baseRunSpeed - penalty;
    }

    @Override
    public void equipItem(Equipment equipment) {
        this.equipment = equipment;
        System.out.println(name + " equipped " + equipment.getName());
    }
}
