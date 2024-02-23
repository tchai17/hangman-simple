// This Hangman game randomly chooses a word from a list of pre-set words. 
// User is expected to input a single letter, which the program will verify if the letter is present in the chosen word.
// If the letter is present, the user can continue guessing, otherwise the user is penalized.
// The game ends when the user guesses all letters of the word successively (win), or if the user runs out of guesses (lose)
// @author timothy.chai

public class Hangman {

	public static void main(String[] args) {
		// Initializing hangman game and creating a hidden version of selected word
		String displayWord = GameMaster.initializeGame();

		// Print welcome message
		System.out.println("Welcome to Hangman!");

		// Prompt user to input letter
		LetterInputClass letterInput = new LetterInputClass();

		// Set number of guesses to 8
		GameMaster.setGuesses(8);

		while (GameMaster.guesses > 0) {

			// Print display word and number of guesses
			System.out.println("The word now looks like this: " + displayWord);

			// Check if user has only one guess, otherwise print number of guesses
			GameMaster.checkNumberOfGuesses();

			// Get user input and pass it through error-checking
			String inputLetter = letterInput.getInputLetter();

			// Use letterCheck method to loop through letters
			String newDisplayWord = GameMaster.letterCheck(displayWord, inputLetter);

			if (GameMaster.checkIfLetterCorrect()) {
				System.out.println("That guess is correct.");
				displayWord = newDisplayWord;
			} else {
				System.out.println("There are no " + inputLetter + "'s in the word.");
			}

			// If display word has no more dashes (fully guessed), break
			if (GameMaster.checkIfWordIsGuessed(displayWord)) {
				break;
			}
		}

		if (GameMaster.checkIfWordIsGuessed(displayWord)) {
			System.out.println("You guessed the word: " + displayWord);
			System.out.println("You win.");
		}

		// else, display defeat message:
		else
			GameMaster.checkNumberOfGuesses();

	}
}
