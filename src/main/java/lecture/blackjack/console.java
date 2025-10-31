package lecture.blackjack;

public class console {
    public static int promptForDollarAmount(String message){

        while (true){
            try{
                var response = IO.readln(message);
                var val = Integer.parseInt(response);

                if (val > 0){
                    return val;
                }

            } catch(NumberFormatException e){
                IO.println("Please enter an integer:");
            }
        }
    }
}
