/********************************************************
 *
 *  Project :  Guessing game Gui javaFx
 *  File    :  GuessController
 *  Name    :  Ryan Vreeke
 *  Date    :  <3/9/2019(3/12/19)>
 *
 *  Description : (Narrative desciption, not code)
 *
 *    1) What is the purpose of the code; what problem does the code solve.
 *    		this code is the controller for the GUI. in this code it initializes the variables that get used as well as looks from an action, in this case a button press
 *    		when the button is pressed it checks if the number that is in the txtInput field is correct.
 *
 *    2) Main extends Application
 *
 *    3) What algorithms, techniques, etc. are used in implementing the data structures.
 *    		progress bars as well as initialize method
 *
 *    4) What methods are implemented (optional).
 *
 *  Changes :  <3/9/2019>
 *
 ********************************************************/

package com.guess.slcc;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class GuessController implements Initializable 
{
	private int myGuess, numberToGuess, count;

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private Button btnGuess;

	@FXML
	private TextField txtInput;

	@FXML
	private TextArea txtAreaOut;
	
    @FXML
    private ProgressBar prgGuess;
    /****************************************************
	 * Method     : guessAction
	 *
	 * Purpose    : this method checks for the btnGuess to be pressed
	 * 				it then gets user input and sends it to check
	 *
	 * Parameters : ActionEvent event

	 * Returns    : This method does not return a value.
	 *
	 ****************************************************/
	@FXML
	void guessAction(ActionEvent event)
	{
		try 
		{
		// get a number from the user
			myGuess = Integer.parseInt(txtInput.getText());
			if(myGuess > 25 || myGuess < 1)//if myGuess is out of range throw exception
			{
				throw new OutOfRangeException();
			}
		}catch(OutOfRangeException e)
		{	
			e.printStackTrace();//print stack trace
			JOptionPane.showMessageDialog(null, e);// show JOption message box with error message
		}
		check();//checks if correct and shows in txtAreaOut
		
		count++;//adds to count
		prgGuess.setProgress((double) count / 5);//sets progress on progress bar to + 20% 

	}

	@FXML
	void initialize() 
	{
		assert btnGuess != null : "fx:id=\"btnGuess\" was not injected: check your FXML file 'GuessGui.fxml'.";
		assert txtInput != null : "fx:id=\"txtInput\" was not injected: check your FXML file 'GuessGui.fxml'.";
		assert txtAreaOut != null : "fx:id=\"txtAreaOut\" was not injected: check your FXML file 'GuessGui.fxml'.";

	}
	/****************************************************
	 * Method     : initialize
	 *
	 * Purpose    : this method is done first without needing to be called.
	 * 				in this i set numberToGuess to a random number and show the starting message\
	 * 				doing it this way allows the message to stay on the screen until the button is pressed.
	 * 
	 * Parameters : URL
	 * 				ResourceBundle

	 * Returns    : This method does not return a value.
	 *
	 ****************************************************/

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) 
	{

		Random random = new Random();//creates new random
		numberToGuess = random.nextInt(24) + 1;//sets numberToGuess to a random number between 1 and 25

		txtAreaOut.setText(String.format("\n\n\n\t\t\t\t%s%n\t\t\t\t%s%n\t\t\t\t%s%n\t\t\t\t%s",
				"Welcome to Guess-My-Number", "A GAME of CHANCE and SKILL!", "You have 5 guesses - Good luck!",
				"Enter a number between 1 and 25: "));//shows starting message in the txtAreaOut box
		
	
	}
	/****************************************************
	 * Method     : check
	 *
	 * Purpose    : this method is called to check if the myGuess and numberToGuess is the same, if it is
	 * 				it will show a message if it's not than it will show a message as well
	 *
	 * Parameters : none

	 * Returns    : This method does not return a value.
	 *
	 ****************************************************/
	private void check ()
	{
		// good or bad guess??
				if (myGuess < numberToGuess) 
				{
					
					// guess too low
					txtAreaOut.setText(String.format("\nYour guess [ %d ] was too low...\n Try Again!", myGuess));
				} else if (myGuess > numberToGuess)
					// guess too high
					txtAreaOut.setText(String.format("\nYour guess [ %d ] was too high...\n Try Again!", myGuess));
				else 
				{
					// good guess
					txtAreaOut.setText(String.format("\nCongratulations!\nYou guessed [ %d ] in %d %s", numberToGuess, count,
							(count > 1) ? "tries." : "try."));
				} // end else
				
				if (count > 5) 
				{
					// exceeded guesses allowed
					txtAreaOut.setText(String.format("Sorry, Game Over!\nYou had your %d tries.\n", count - 1));
				} // end i
	}
}
