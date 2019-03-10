/********************************************************
 *
 *  Project :  Guessing game Gui javaFx
 *  File    :  OutOfRangeException
 *  Name    :  Ryan Vreeke
 *  Date    :  <3/9/2019(3/12/19)>
 *
 *  Description : (Narrative desciption, not code)
 *
 *    1) What is the purpose of the code; what problem does the code solve.
 *    		this is a custom exception that is used when the numbers entered are not in the correct range
 *
 *    2) extends the Exception class 
 *
 *    3) What algorithms, techniques, etc. are used in implementing the data structures.
 *    		custom exception 
 *
 *    4) What methods are implemented (optional).
 *
 *  Changes :  <3/9/2019>
 *
 ********************************************************/
package com.guess.slcc;

public class OutOfRangeException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/****************************************************
	 * Method     : toString
	 *
	 * Purpose    : returns an error message that is both custom and inherited from the exception class
	 *
	 * Parameters : none

	 * Returns    : this method returns a string.
	 *
	 ****************************************************/
	public String toString() 
	{
		return String.format("%s\n\t%s", super.toString(), "The Number Entered was not between 1 and 25 please try again");//sends error string
	}

}
