import java.io.FileWriter;
import java.io.IOException;
/**
 * Lab1 - A simple RPG program that lets the player:
 * - Enter modifiers for three attributes
 * - Save those attributes to a file
 * - Roll a d20 using one of the attributes
 * - Compare the roll against a random challenge
 */

public class Lab1 {
    /**
     * Rolls a 20-sided die and adds the modifier.
     * @param modifier the value to add to the die roll
     * @return the final result of the roll
     */
    int rollDice(int modifier) {
        int d20 = (int) (Math.random() * 20 + 1); // random number between 1 and 20
        return d20 + modifier;
    }

    /**
     * Generates a random challenge value between 1 and 20.
     * @return the challenge number
     */
    int CD(){
        return (int) (Math.random() * 20 + 1);
    }

    /**
     * Main function that runs the RPG program.
     * It collects attribute modifiers, saves them to a file,
     * lets the user roll a die, and compares the result to a challenge.
     */
    void main(){
        // Welcome message
        IO.println("""
                Hello Player, this code will show three stats for your character.\s
                Add your modifier to sum your D20 roll!\s
                """);

        // Arrays to store attribute values and names
        int[] attributes = new int[3];
        String[] names = {"Strength","Dexterity","Constitution"};
        IO.println("Type the modifier value of the attribute you want to add: (0 to 5)");

        // Loop to collect user input for each attribute
        for(int i=0; i<3; i++){
            IO.println(names[i]+ ": ");
            try{
                attributes[i] = Integer.parseInt(IO.readln()); // read user input
            } catch(Exception e){
                IO.println("Error: something went wrong"); // handle invalid input
                i--; // repeat the current attribute
            }
        }

        // Try to save the attributes to a file
        try{
            FileWriter sheet = new FileWriter("sheet.txt");
            for (int i=0; i<3; i++){
                sheet.write(names[i]+": "+attributes[i]+"\n");
            }
            sheet.close();
            IO.println("Your player sheet was salved in the file 'sheet.txt' \n");
        } catch(IOException e){
            IO.println("Error: something went wrong");
        }

        // Show attribute options for rolling
        for(int i=0; i<3; i++){
            IO.println(i+" - " + names[i]);
        }

        int choice = 0;
        boolean valid = false;

        // Loop to get a valid attribute choice from the user
        while (!valid) {
            try {
                choice = Integer.parseInt(IO.readln("Choose the attribute to roll the dice (0 a 2): "));
                valid = true; // if the input was good, exit loop
            } catch (NumberFormatException e) {
                IO.println("Error: please enter a number");
            }
        }

        // If the choice is valid, roll the dice and compare to challenge
        if (choice >= 0 && choice < 3){
            int modifier = (attributes[choice]); // get selected modifier
            int result = rollDice(modifier); // roll the dice
            IO.println("Your "+names[choice]+" modifier is "+modifier);
            IO.println("You rolled "+ result + "!!");

            int challenge = CD(); //generate the challenge
            IO.println("\nThe challenge to your roll is "+challenge);

            // Compare result to challenge
            if (result>=challenge){
                IO.println("You win!");
            }else{
                IO.println("You lost!");
            }
        } else{
            IO.println("Invalid choice");
        }

        }

}
