
class GameMaster {
	static int guesses;
	static String selectedWord;
	private static String[] wordList = { "PANCAKE", "UMBRELLA", "MUSICAL", "SAXOPHONE", "GIRAFFE", "UNIVERSE",
			"abruptly", "absurd", "abyss", "affix", "askew", "avenue", "awkward", "axiom", "azure", "bagpipes",
			"bandwagon", "banjo", "bayou", "beekeeper", "bikini", "blitz", "blizzard", "boggle", "bookworm", "boxcar",
			"boxful", "buckaroo", "buffalo", "buffoon", "buxom", "buzzard", "buzzing", "buzzwords", "caliph", "cobweb",
			"cockiness", "croquet", "crypt", "curacao", "cycle", "daiquiri", "dirndl", "disavow", "dizzying", "duplex",
			"dwarves", "embezzle", "equip", "espionage", "euouae", "exodus", "faking", "fishhook", "fixable", "fjord",
			"flapjack", "flopping", "fluffiness", "flyby", "foxglove", "frazzled", "frizzled", "fuchsia", "funny",
			"gabby", "galaxy", "galvanize", "gazebo", "giaour", "gizmo", "glowworm", "glyph", "gnarly", "gnostic",
			"gossip", "grogginess", "haiku", "haphazard", "hyphen", "iatrogenic", "icebox", "injury", "ivory", "ivy",
			"jackpot", "jaundice", "jawbreaker", "jaywalk", "jazziest", "jazzy", "jelly", "jigsaw", "jinx", "jiujitsu",
			"jockey", "jogging", "joking", "jovial", "joyful", "juicy", "jukebox", "jumbo", "kayak", "kazoo", "keyhole",
			"khaki", "kilobyte", "kiosk", "kitsch", "kiwifruit", "klutz", "knapsack", "larynx", "lengths", "lucky",
			"luxury", "lymph", "marquis", "matrix", "megahertz", "microwave", "mnemonic", "mystify", "naphtha",
			"nightclub", "nowadays", "numbskull", "nymph", "onyx", "ovary", "oxidize", "oxygen", "pajama", "peekaboo",
			"phlegm", "pixel", "pizazz", "pneumonia", "polka", "pshaw", "psyche", "puppy", "puzzling", "quartz",
			"queue", "quips", "quixotic", "quiz", "quizzes", "quorum", "razzmatazz", "rhubarb", "rhythm", "rickshaw",
			"schnapps", "scratch", "shiv", "snazzy", "sphinx", "spritz", "squawk", "staff", "strength", "strengths",
			"stretch", "stronghold", "stymied", "subway", "swivel", "syndrome", "thriftless", "thumbscrew", "topaz",
			"transcript", "transgress", "transplant", "triphthong", "twelfth", "twelfths", "unknown", "unworthy",
			"unzip", "uptown", "vaporize", "vixen", "vodka", "voodoo", "vortex", "voyeurism", "walkway", "waltz",
			"wave", "wavy", "waxy", "wellspring", "wheezy", "whiskey", "whizzing", "whomever", "wimpy", "witchcraft",
			"wizard", "woozy", "wristwatch", "wyvern", "xylophone", "yachtsman", "yippee", "yoked", "youthful", "yummy",
			"zephyr", "zigzag", "zigzagging", "zilch", "zipper", "zodiac", "zombie" };

	static boolean correctGuess = false;
	private static String[] selectedWordInLetterArray;

	static void checkNumberOfGuesses() {
		// Check if user has only one guess, otherwise print number of guesses
		if (guesses == 1)
			System.out.println("You only have one guess left.");
		else if (guesses == 0) {
			System.out.println("You're completely hung.");
			System.out.println("You lose.");
			System.out.println("The word was: " + selectedWord);
		} else
			System.out.println("You have " + guesses + " guesses left.");
	}

	// Setter for guesses
	static void setGuesses(int guess_set) {
		guesses = guess_set;
	}

	// Converts selectedWord into an array of letters
	static void convertWordIntoLetterArray() {
		selectedWordInLetterArray = selectedWord.split("");
	}

	// Chooses word randomly from array
	static String wordSelector() {
		// Selecting a word using a random number
		int selectedIndex = (int) (Math.random() * (wordList.length));
		String selectedWord = wordList[selectedIndex].toUpperCase();
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
		if (correctGuess)
			return true;
		else {
			guesses--;
			return false;
		}
	}

	static boolean checkIfWordIsGuessed(String displayWord) {
		if (displayWord.contains("-") == false)
			return true;
		else
			return false;
	}

	static String initializeGame() {
		selectedWord = wordSelector();
		convertWordIntoLetterArray();
		String displayWord = "-".repeat(selectedWord.length());
		return displayWord;
	}

}
