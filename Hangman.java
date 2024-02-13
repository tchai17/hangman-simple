
public class Hangman {

	// Method to replace letter in string with target index
	public String replaceLetter(String inputString, String inputLetter, int index) {
	    return inputString.substring(0, index) + inputLetter + inputString.substring(index+1);
	}
	
	// Method to check if letter exists in selected word, then amend display word 
	public String letterCheck( String displayWord, String selectedWord, String letterToCheck ) {
		
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
				String[] wordList = { ... };
				
				// Selecting a word using a random number
				int selectedIndex = Math.random()*(wordList.length);
				String selectedWord = wordList[selectedIndex];
				
				// Creating a displayword that is shown 
				String dash = "-";
				String displayWord = dash.repeat(selectedWord.length);
				
				// Initializing number of guesses
				int guesses = 8;
				
				// Print welcome message
				system.out.println("Welcome to Hangman!");
				
				
				while ( guesses > 0 ){ 
					
					// Print displayword and number of guesses
					system.out.println("The word now looks like this: " + displayword);
					if ( guesses == 1 )
					system.out.println("You only have one guess left.");
					else
					system.out.println("You have " + guesses + " guesses left.");
					// Use letterCheck method to loop through letters
					String newDisplayWord = letterCheck(displayWord, selectedWord, letterToCheck)
				
					// Check if displayword has changed
					if (displayWord.equals(newDisplayWord))
					// If display word changed, then save new display word
					displayWord = newDisplayWord
					// If display word did not change, deduct guesses
					guesses--;
					
					// If display word has no more dashes (fully guessed), break
					
				}
					
					// If word has no more dashes, display victory messages
					
					// else, display defeat message:

	}

}
