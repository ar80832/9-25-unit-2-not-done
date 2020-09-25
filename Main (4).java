public class Main{
    
     public static void main(String[] args) {
        // TODO Auto-generated method stub
        Warrior c1 = new Warrior("Jim");
        Healer c2 = new Healer("BillyJoe");
        
        c2.attack(40, 90);
    }
}

public class Warrior {
    //declare instance variables
    private String name;
    private int level;
    private int maxHealth;
    private int health;
    private int attack;
    private int defense;
    private int magicAttack;
    private int magicDefense;
    private int agility;
    private int wisdom;
    private int exp;
    
        //constructor is for creating level 1 characters
        public Warrior(String n) {
            name = n;
            level = 1;
            maxHealth = 20;
            health = maxHealth;
            attack = 10;
            defense = 8;
            magicAttack = 0;
            magicDefense = 4;
            agility = 7;
            wisdom = 2;
            exp = 0;
        }
         //constructor for creating higher level characters
        public Warrior(String n, int lev) {
            name = n;
            level = lev;
            maxHealth = 20*lev;
            health = maxHealth;
            attack = 10*lev;
            defense = 8*lev;
            magicAttack = 0*lev;
            magicDefense = 4*lev;
            agility = 7*lev;
            wisdom = 2*lev;
            exp = 0;
        }
        public void levelUp() {
            level++;
            maxHealth+= 20;
            health += 20; 
            attack += 10; 
            defense += 8; 
            magicDefense += 4; 
            agility += 7; 
            wisdom += 2; 
        }
        public void expGain (int expGain) {
            if(expGain > 1000)
                expGain = 1000;
            exp += expGain;
            if(exp >= 1000) {
                levelUp();
                exp -= 1000;
            }
        }
        public String toString() {
            String str = "";
            str += "Name: " + name + "\n";
            str += "Level " + level + " Warrior" + "\n";
            str += "Current EXP: " + exp + "\n";
            str += health + "/" + maxHealth + " Health\n";
            str += "Attack: " + attack + "  Defense: " + defense + "\n";
		    str += "Magic Attack: " + magicAttack + "  Magic Defense: " + magicDefense + "\n";
		    str += "Agility: " + agility + "  Wisdom: " + wisdom + "\n\n";
		    return str;
            
        }
        public int attack(int targetDef, int targetAgi) {
            double probability = (double)agility/targetAgi;
            if(hit)
                return calcDamage(targetDef);
            else
                return 0;
        }
       
       
        private boolean hitCheck(int targetAgi) {
            if(Math.random() < probability) {
                System.out.print("Hit!");
                return true;
            }
            else {
                System.out.print("Miss");
                return false; 
            }
        }
        
        
        private int calcDamage(int targetDef) {
            int damage = (int)(1.36*attack*Math.pow(2.72, -(double)targetDef/attack) + 0.5);
            System.out.print(damage + "Damage");
            return damage;
        }
        
        
        
        
        
}



public class Healer {
    //declare instance variables
    private String name;
    private int level;
    private int maxHealth;
    private int health;
    private int attack;
    private int defense;
    private int magicAttack;
    private int magicDefense;
    private int agility;
    private int wisdom;
    private int exp;
    
        //constructor is for creating level 1 characters
        public Healer(String n) {
            name = n;
            level = 1;
            maxHealth = 16;
            health = maxHealth;
            attack = 4;
            defense = 6;
            magicAttack = 5;
            magicDefense = 10;
            agility = 3;
            wisdom = 12;
            exp = 0;
        }
         //constructor for creating higher level characters
        public Healer(String n, int lev) {
            name = n;
            level = lev;
            maxHealth = 16*lev;
            health = maxHealth;
            attack = 4*lev;
            defense = 6*lev;
            magicAttack = 5*lev;
            magicDefense = 10*lev;
            agility = 3*lev;
            wisdom = 12*lev;
            exp = 0;
        }
        public void levelUp() {
            level++;
            maxHealth+= 16;
            health += 16; 
            attack += 4; 
            defense += 6; 
            magicAttack += 5;
            magicDefense += 10; 
            agility += 3; 
            wisdom += 12; 
        }
        public String toString() {
            String str = "";
            str += "Name: " + name + "\n";
            str += "Level " + level + " Healer" + "\n";
            str += "Current EXP: " + exp + "\n";
            str += health + "/" + maxHealth + " Health\n";
            str += "Attack: " + attack + "  Defense: " + defense + "\n";
		    str += "Magic Attack: " + magicAttack + "  Magic Defense: " + magicDefense + "\n";
		    str += "Agility: " + agility + "  Wisdom: " + wisdom + "\n\n";
		    return str;
            
        }
        
        public int attack(int targetDef, int targetAgi) {
            double probability = (double)agility/targetAgi;
            if(hit)
                return calcDamage(targetDef);
            else
                return 0;
        }
       
       
        private boolean hitCheck(int targetAgi) {
            if(Math.random() < probability) {
                System.out.print("Hit!");
                return true;
            }
            else {
                System.out.print("Miss");
                return false; 
            }
        }
        
        
        private int calcDamage(int targetDef) {
            int damage = (int)(1.36*attack*Math.pow(2.72, -(double)targetDef/attack) + 0.5);
            System.out.print(damage + "Damage");
            return damage;
        }
        
        public int heal(int targetHealth, int targetMax) {
            int heal = wisdom;
            if(heal > targetMax - targetHealth)
                heal = targetMax - targetHealth;
            System.out.println("Heal: " + heal);
        }
        
        
        
        

}