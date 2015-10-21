class SimilarWords {

    private BinarySearchTree posibleWords;
    private char[] alphabeth = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    
    //swaps two letters in a word
    private void similarOne(String word){
        char[] word_array = word.toCharArray();
        char[] tmp;
        
        for(int i = 0; i < word_array.length - 1; i++){
            tmp = word_array.clone();
	    posibleWords.insert(swap(i, i+1, tmp));
	}
    }

    //replaces one letter in the word with another
    private void similarTwo(String word){
        char[] word_array = word.toCharArray();
	char[] temp;

        for (int i = 0; i< word_array.length; i++){
            for (int j = 0; j< alphabeth.length; j++){
                temp = word_array.clone();
                temp[i] = alphabeth[j];
		String newWord = new String(temp);
		if (!newWord.equals(word)){
		    posibleWords.insert(newWord);
		}
            }
        }
    }

    //removes one letter in the word
    private void similarThree(String word){
        char[] word_array = word. toCharArray();
        char[] temp;

        for (int i = 0; i< word_array.length -1;  i++){
            temp = word_array.clone();
            posibleWords.insert(removeLetter(temp, i)); 
        }
    }

    //adds one letter
    private void similarFour(String word){
        String temp;

        for (int i = 0; i< word.length() +1; i++){
            for (int j = 0; j< alphabeth.length; j++){
                temp = word +"" ;
                posibleWords.insert(addLetter(temp, i, alphabeth[j]));
            }
        }
    }



    private String swap(int a, int b, char[] word){
        char tmp = word[a];
        word[a] = word[b ];
        word[b] = tmp;

        return new String(word);
    }


    private String removeLetter(char[] word, int nr ){
        char[] newWord = new char[word.length -1];
        int count = 0;

        for (int i = 0; i < word.length; i++){
            if (i != nr){
                newWord[count++] = word[i];
            }
        }
        return new String(newWord);
    }

    private String addLetter(String word, int nr, char letter){
	if (nr == 0){
	    return letter + word;
	}
	else if (nr == word.length()){
	    return word + letter;
	}
	
	return (word.substring(0, nr) + letter + word.substring(nr, word.length()));
    }


    public BinarySearchTree findSimilar(String word){
	word = word.toLowerCase();

	//can be optimalized, threads?
	//as not to get duplicates, and fastert to search
	posibleWords  = new BinarySearchTree(word);

	similarOne(word);
	similarTwo(word);
	similarThree(word);
	similarFour(word);

	return posibleWords;
    }
}
