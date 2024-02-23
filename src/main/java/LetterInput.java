import java.util.ArrayList;
import java.util.Scanner;

class LetterInputClass {
	// Attributes
	private static ArrayList<String> pastGuesses;
	private static Scanner scanner;
	
	// Constructor
	public LetterInputClass() {
		scanner = new Scanner(System.in);
		pastGuesses = new ArrayList<String>();
	}
	
	private boolean isRepeatGuess(String inputLetter) {
		while ( true ) {
			// Check if guess is repeated from before, else add to list of past guesses
	        if ( pastGuesses.contains(inputLetter)) {
	        	System.out.println("You have previously guessed " + inputLetter + ", please try again.");
	        	return true;
	        }
	        else {
	        	pastGuesses.add(inputLetter);
	        	return false;
	        }
		}
	}
	
	// Method for checking user input
	public String getInputLetter() {
		String inputLetter;
        while ( true ) {
        	System.out.print("Your guess: ");
            inputLetter = scanner.nextLine().toUpperCase();
        	if ( inputLetter.matches("[A-Z]+") && inputLetter.length() == 1) {
        		if ( isRepeatGuess(inputLetter) ) {
        			continue;
        		}
        		else {
        			pastGuesses.add(inputLetter);
        			break;
        		}
	        } 
        	else {
	        	// If input is not a letter, then throw exception
	            System.out.println("Invalid input. Please enter a single letter.");
	        }
	        
        }
        
        return inputLetter;
	}
	
	
	
}
