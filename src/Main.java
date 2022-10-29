/**
 * Maman 11, question 1.
 * Mor Simha, 206029993.
 */

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        GuessNumber game = new GuessNumber();
        String response;

        boolean keepPlay = true;

        while (keepPlay) { //This while loop will run until user chose to stop playing.
            boolean rightGuess = false, validGame = true;

            game.generateNum();
            response =  JOptionPane.showInputDialog(null, "Welcome to Cows & Bulls!\nGuess your number please:" ,"Cows & Bulls Attempt #" +(game.getCount()+1),JOptionPane.INFORMATION_MESSAGE);

            while (!rightGuess) { //This while loop will run until the right number was guessed.
                game.addNewGuess(response);
                String valid = game.checkValidity();
                if (response == null || !valid.equals("")) { // Enter only for no response or error message.
                    JOptionPane.showMessageDialog(null, valid + "Exiting current game. Thanks for playing!", "Cows & Bulls - Error", JOptionPane.ERROR_MESSAGE);
                    rightGuess = true; // To exit current while
                    validGame = false;
                }
                else {
                    String msg = game.compareGuess();
                    if (msg.equals("success"))
                        rightGuess = true;
                    else // Getting the next guess
                        response = JOptionPane.showInputDialog(null, msg + "\nGuess your next number please:", "Cows & Bulls Attempt #" +(game.getCount()+2) , JOptionPane.QUESTION_MESSAGE);
                }
                game.addCount();

            }
            if (validGame) { // Only when the user succeeded.
                String msg = "Good job! you guessed the number " + game.getNum() + " correctly!\nNumber of Attempts: "+ game.getCount();
                JOptionPane.showMessageDialog(null, msg ,"Cows & Bulls",JOptionPane.INFORMATION_MESSAGE);
            }
            int answer = JOptionPane.showConfirmDialog(null, "Do you want to play again?", "Cows & Bulls", JOptionPane.YES_NO_OPTION);
            if (answer == JOptionPane.YES_OPTION)
                game.resetGame();
            else {
                JOptionPane.showMessageDialog(null, "Goodbye!","Cows & Bulls",JOptionPane.INFORMATION_MESSAGE);
                keepPlay = false;
            }
        }
    }
}
