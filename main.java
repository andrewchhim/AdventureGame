import java.util.Random;
import java.util.Scanner;

public class Game {

    public static void main(String[] args) {

    //system objects
        Scanner in = new Scanner(System.in);
        Random rand = new Random();

        //Game variables
        String[] enemies = {"Oscars Will Smith", "Chris breezy", "Sienna Mae", "Jake Paul"};
        int maxEnemyHP = 75;
        int EnemyAttackDamage = 20;

        //Players Variables
        int Health = 100; //the standard max health player starts with
        int AttackDamage = 40; // attack damage of player
        int numHealthPotions = 3; //How many health potions player begins with
        int HealthPotionsHealAmount = 30;
        int HealthPotionDropChance = 25; //percent

        boolean running = true;

        System.out.println("Welcome to the dungeon");

        GAME:
        while(running) {

            System.out.println("-------------------------------------------");

            int EnemyHealth = rand.nextInt(Health);
            String enemy = enemies[rand.nextInt(enemies.length)];
            System.out.println("\t# " + enemy + " has appeared! #\n" );

            while(EnemyHealth > 0){
                System.out.println("\tYour Health: " + Health);
                System.out.println("\t" + enemy + "'s Health:" + EnemyHealth);
                System.out.println("\n\tChoose an action.");
                System.out.println("\t1. Attack");
                System.out.println("\t2. Drink Health Potion");
                System.out.println("\t3. Leave");

                String input = in.nextLine();
                if(input.equals("1")){
                int DamageDealt = rand.nextInt(AttackDamage);
                int DamageTaken = rand.nextInt(EnemyAttackDamage);

                EnemyHealth -= DamageDealt;
                Health -= DamageTaken;

                System.out.println("\tYou strike the" + enemy + "for" + DamageDealt);
                System.out.println("\tYou have sustained" + DamageTaken + "in combat");

                if(Health < 1) {
                    System.out.println("/tYou have died.");
                    break;
                }

                }
                else if(input.equals("2")){

                if(numHealthPotions > 0) {
                    Health += HealthPotionsHealAmount;
                    numHealthPotions--;
                    System.out.println("\t> you drink a health potion, you have gained" + HealthPotionsHealAmount + "."
                                        + "\n\t> You now have " + Health + "HP."
                                        + "\n\t> You now have " + numHealthPotions + "Health potions left\n");
                }
                else {
                    System.out.println("\t> You have no health potions left.");
                }

                }
                else if(input.equals("3")){

                    System.out.println("\tYou run away from " + enemy + "!");
                    continue GAME;

                }
                else {
                    System.out.println("Invalid command. Type '1', '2', or '3'.");
                }
            }

            if(Health < 1) {
                System.out.println("You limp out of The Dunegeon, a saddening site.");
                break;
            }

            System.out.println("-----------------------------------------");
            System.out.println("  #  " + enemy + "was defeated!  #  ");
            System.out.println("  #  You have " + Health + "Health left  #");
            if(rand.nextInt(100) > HealthPotionDropChance) {
                numHealthPotions++;
                System.out.println("#  The enemy dropped a health potion!  #");
                System.out.println("#  you now have " + numHealthPotions + "in your inventory.  #");

            }

            System.out.println("-----------------------------------------");
            System.out.println("Select an action.");
            System.out.println("1. Continue fighting.");
            System.out.println("2. Leave The Dungeon.");

            String input = in.nextLine();

             while(!input.equals("1") && !input.equals("2")) {
                 System.out.println("Invalid command. Type '1' or '2'. ");
                 input = in.nextLine();
             }

             if(input.equals("1")) {
                 System.out.println("You continue on...");
             }
             else if(input.equals("2")) {
                 System.out.println("You follow the light out of the dungeon into open air...");
                 break;
             }
        }

        System.out.println("###################");
        System.out.println("Thanks for playing!");
        System.out.println("###################");

    }
