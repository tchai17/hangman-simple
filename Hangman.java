// This Hangman game initializes 

import java.util.ArrayList;
import java.util.Scanner;

public class Hangman {

	// Method to replace letter in string with target index
	public static String replaceLetter(String inputString, String inputLetter, int index) {
	    return inputString.substring(0, index) + inputLetter + inputString.substring(index+1);
	}
	
	// Method to check if letter exists in selected word, then amend display word 
	public static String letterCheck( String displayWord, String selectedWord, String letterToCheck ) {
		
		// Split the selected word into array of letters
		String[] selectedWordArray = selectedWord.split("");
		for ( int i=0; i < selectedWordArray.length; i++){
			if ( letterToCheck.equals(selectedWordArray[i]) ){
				displayWord = replaceLetter(displayWord, letterToCheck, i);
			}
		}
		return displayWord;
	}
	
	
	// Method for checking user input
	public static String getInputLetter(Scanner scanner) {
		System.out.print("Your guess: ");
        String inputLetter = scanner.nextLine().toUpperCase();
        if (inputLetter.matches("[A-Z]+")) {
            return inputLetter;
        } else {
        	// If input is not a letter, then throw exception
            System.out.println("Invalid input. Please enter a single letter.");
            throw new IllegalArgumentException("Non-alphabet input");
        }
	}
	
	public static void main(String[] args) {
		// Initializing array of words (string)
		String[] wordList = { "PANCAKE", "UMBRELLA", "MUSICAL", "SAXOPHONE", "GIRAFFE", "UNIVERSE" };
		
		// Selecting a word using a random number
		int selectedIndex = (int) (Math.random()*(wordList.length));
		String selectedWord = wordList[selectedIndex];
		
		
		// Creating a display word that is shown 
		String displayWord = "-".repeat(selectedWord.length());
		
		// Initializing number of guesses
		int guesses = 8;
		
		// Print welcome message
		System.out.println("Welcome to Hangman!");
		
		// Prompt user to input letter
		Scanner scanner = new Scanner(System.in);
		
		// Initialize ArrayList to store past guesses
		ArrayList<String> pastGuesses = new ArrayList<String>();
		
		while ( guesses > 0 ){ 
			
			// Print display word and number of guesses
			System.out.println("The word now looks like this: " + displayWord);
						
			// Check if user has only one guess, otherwise print number of guesses
			if ( guesses == 1 )
				System.out.println("You only have one guess left.");
			else
				System.out.println("You have " + guesses + " guesses left.");
			
			// Get user input and pass it through error-checking
			String inputLetter = getInputLetter(scanner);
	        
	        // If input contains more than one character, use first character
	        if ( inputLetter.length() > 1) 
	        	inputLetter = inputLetter.substring(0, 1);
	        	       
			// Check if guess is repeated from before, else add to list of past guesses
	        if ( pastGuesses.contains(inputLetter)) {
	        	System.out.println("You have previously guessed " + inputLetter + ", please try again.");
	        	continue;
	        }
	        else {
	        	pastGuesses.add(inputLetter);
	        }
	        
			// Use letterCheck method to loop through letters
			String newDisplayWord = letterCheck(displayWord, selectedWord, inputLetter);
		
			// Check if display word has changed
			if (displayWord.equals(newDisplayWord) == false) {
				// If display word changed, then save new display word
				System.out.println("That guess is correct.");
				displayWord = newDisplayWord;
			}
			else {
				// If display word did not change, deduct guesses
				guesses--;
				System.out.println("There are no " + inputLetter + "'s in the word.");
			}
			
			// If display word has no more dashes (fully guessed), break
			if ( displayWord.contains("-") == false) {
				break;
			}
		}
		// Close the Scanner object to release system resources
        scanner.close();
		
		// If word has no more dashes, means word is guessed, then show victory messages
		if ( displayWord.contains("-") == false) {
			System.out.println("You guessed the word: " + displayWord);
			System.out.println("You win.");
		}
		// else, display defeat message:
		else {
			System.out.print("You're completely hung.");
			System.out.print("The word was: " + selectedWord);
			
		}
	}
}
