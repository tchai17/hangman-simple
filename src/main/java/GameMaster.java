
class GameMaster {
	static int guesses;
	static String selectedWord;
	private static String[] wordList = { "PANCAKE", "UMBRELLA", "MUSICAL", "SAXOPHONE", "GIRAFFE", "UNIVERSE" };
	static boolean correctGuess = false;
	private static String[] selectedWordInLetterArray;
	
	static void checkNumberOfGuesses() {
		// Check if user has only one guess, otherwise print number of guesses
		if ( guesses == 1 ) 
			System.out.println("You only have one guess left.");
		else if ( isGuessZero() ) {
			System.out.println("You're completely hung.");
			System.out.println("You lose.");
			System.out.println("The word was: " + selectedWord);
		}
		else
			System.out.println("You have " + guesses + " guesses left.");
	}
	
	// Setter for guesses
		static void setGuesses(int guess_set) {
			guesses = guess_set;
		}
	
	static boolean isGuessZero() {
		if ( guesses == 0 ) return true;
		else return false;
	}
	
	// Converts selectedWord into an array of letters
	static void convertWordIntoLetterArray() {
		selectedWordInLetterArray = selectedWord.split("");
	}
	
	// Chooses word randomly from array
	static String wordSelector() {		
		// Selecting a word using a random number
		int selectedIndex = (int) (Math.random() * (wordList.length));
		String selectedWord = wordList[selectedIndex];
		return selectedWord;
	}
	
	// Method to replace letter in string with target index
	static String replaceLetter(String inputString, String inputLetter, int index) {
		return inputString.substring(0, index) + inputLetter + inputString.substring(index + 1);
	}

	// Method to check if letter exists in selected word, then amend display word
	static String letterCheck(String displayWord, String letterToCheck) {
		correctGuess = false;
		// If letterToCheck is found in selectedWord, replace dash in displayWord
		for (int i = 0; i < selectedWordInLetterArray.length; i++) {
			if (letterToCheck.equals(selectedWordInLetterArray[i])) {
				displayWord = replaceLetter(displayWord, letterToCheck, i);
				correctGuess = true;
			}
		}
		return displayWord;
	}
	
	static boolean checkIfLetterCorrect() {
		if ( correctGuess ) return true;
		else {
			guesses--;
			return false;
		}
	}
	
	static boolean checkIfWordIsGuessed(String displayWord) {
		if (displayWord.contains("-") == false) return true;
		else									return false;
	}
	
	static String initializeGame() {
		selectedWord = wordSelector();
		convertWordIntoLetterArray();
		String displayWord = "-".repeat(selectedWord.length());
		return displayWord;
	}
	
}
