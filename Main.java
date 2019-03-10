/********************************************************
 *
 *  Project :  Guessing game Gui javaFx
 *  File    :  Main
 *  Name    :  Ryan Vreeke
 *  Date    :  <3/9/2019(3/12/19)>
 *
 *  Description : (Narrative desciption, not code)
 *
 *    1) What is the purpose of the code; what problem does the code solve.
 *    		the point of this software is to make a game using a GUI where a random number 1 -25 is picked an the user needs to guess what that number 
 *    		is in 5 tries or less. after every guess the game will tell you if you are to high ofr to low
 *
 *    2) Main extends Application
 *
 *    3) What algorithms, techniques, etc. are used in implementing the data structures.
 *    		used JavaFx and exception handling 
 *
 *    4) What methods are implemented (optional).
 *
 *  Changes :  <3/9/2019>
 *
 ********************************************************/

package com.guess.slcc;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application
{
	/****************************************************
	 * Method     : start
	 *
	 * Purpose    : this method creates the initial GUI
	 *
	 * Parameters : stage primaryStage  - takes a stage object to use for the GUI

	 * Returns    : This method does not return a value.
	 *
	 ****************************************************/
	@Override
	public void start(Stage primaryStage) 
	{
		try 
		{
			Parent root = FXMLLoader.load(getClass().getResource("GuessGui.fxml"));//loads the fxml file to buld the gui
			
			
			primaryStage.setTitle("Guessing Game");//sets title
			primaryStage.setScene(new Scene(root));//adds the fxml file to the scene
			primaryStage.show();//shows the scene
			
			
		} catch(Exception e) //catches exceptions
		{
			e.printStackTrace();
		}
	}
	/****************************************************
	 * Method     : newStage
	 *
	 * Purpose    : the only purpose of this method is to create the about
	 * 				window at a later time. does it in the same way the start method does
	 *
	 * Parameters : stage secondStage  - takes a stage object to use for the GUI

	 * Returns    : This method does not return a value.
	 *
	 ****************************************************/
	
	public static void main(String[] args) 
	{
		launch(args);//launches 
	}
}
