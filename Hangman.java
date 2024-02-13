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
	
	
	public static void main(String[] args) {
		// Initializing array of words (string)
		String[] wordList = { "PANCAKE", "UMBRELLA", "MUSICAL", "SAXOPHONE", "GIRAFFE", "UNIVERSE" };
		
		// Selecting a word using a random number
		int selectedIndex = (int) (Math.random()*(wordList.length));
		String selectedWord = wordList[selectedIndex].toUpperCase();
		System.out.println(selectedWord);
		
		
		// Creating a display word that is shown 
		String dash = "-";
		String displayWord = dash.repeat(selectedWord.length());
		//System.out.println(displayWord);
		
		// Initializing number of guesses
		int guesses = 8;
		
		// Print welcome message
		System.out.println("Welcome to Hangman!");
		
		//String letterToCheck = new String("a");
		// Prompt user to input letter
		Scanner scanner = new Scanner(System.in);
		
		
		while ( guesses > 0 ){ 
			
			// Print display word and number of guesses
			System.out.println("The word now looks like this: " + displayWord);
						
			// Check if user has only one guess, otherwise print number of guesses
			if ( guesses == 1 )
				System.out.println("You only have one guess left.");
			else
				System.out.println("You have " + guesses + " guesses left.");

			// Prompt the user to enter a string
	        System.out.print("Your guess: ");
	        String inputLetter = scanner.nextLine();
	       
			
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
				guesses = guesses - 1;
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
			System.out.print("That guess is correct.");
			System.out.print("You guessed the word: " + displayWord);
			
		}
		// else, display defeat message:
		else {
			System.out.print("You're completely hung.");
			System.out.print("The word was: " + selectedWord);
			
		}
					

	}

}
