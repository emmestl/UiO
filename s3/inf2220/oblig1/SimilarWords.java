class SimilarWords {

    char[] alphabeth = "abcdefghijklmnopqestuvwxyz".toCharArray();
    //swaps two letters in a word
    public String[] similarOne(String word){
        char[] word_array = word.toCharArray();
        char[] tmp;
        String[] words = new String[word_array.length-1];
        for(int i = 0; i < word_array.length - 1; i++){
            tmp = word_array.clone();
            words[i] = swap(i, i+1, tmp);
        }
        return words;
    }

    //replaces one letter in the word with another
    public String[][] similarTwo(String word){
        char[] word_array = word.toCharArray();
        String[][] words = new String[word_array.length][alphabeth.length];
        char[] temp;

        for (int i = 0; i< word_array.length; i++){
            for (int j = 0; j< alphabeth.length; j++){
                temp = word_array.clone();
                temp[i] = alphabeth[j];
                words[i][j] = temp.toString();
            }
        }
        return words;
    }

    //removes one letter in the word
    public String[] similarThree(String word){
        char[] word_array = word. toCharArray();
        String[] words = new String[word_array.length];
        char[] temp;

        for (int i = 0; i< word_array.length -1;  i++){
            temp = word_array.clone();
            words[i] = removeLetter(temp, i);
        }

        return words;

    }

    //adds one letter
    public String[][] similarFour(String word){
        String[][] words = new String[word.length() + 1][alphabeth.length];
        String temp;

        for (int i = 0; i< word.length() +1; i++){
            for (int j = 0; j< alphabeth.length; j++){
                temp = word +"" ;
                words[i][j] = addLetter(temp, i, alphabeth[j]);
            }
        }
        return words;
    }



    public String swap(int a, int b, char[] word){
        char tmp = word[a];
        word[a] = word[b];
        word[b] = tmp;
        return new String(word);
    }


    public String removeLetter(char[] word, int nr ){
        char[] newWord = new char[word.length -1];
        int count = 0;

        for (int i = 0; i < newWord.length; i++){
            if (i != nr){
                newWord[count++] = word[i];
            }
        }

        return newWord.toString();
    }

    public String addLetter(String word, int nr, char letter){
	if (nr == 0){
	    return letter + word;
	}

	return (word.substring(0, nr) + letter + word.substring(nr, word.length()));
    }

}
