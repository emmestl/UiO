#include <stdio.h>
#include <string.h>


int main(void){

  char c;
  char past;
  int nice = 0;
  char word[20]; //this is max
  int count = 0;
  int match = 0;
  int sep = 0;

  while((c= fgetc(stdin)) != EOF){
    if(c == '\n'){ //new string line
      if(sep >= 1 && match >= 1){
	nice++;
      }
      match = 0;
      sep = 0;
      count = 0;
      memset(word, 0, 20);
      continue;
    }

    word[count++] = c;
    word[count] = '\0';


    if(count >= 3 & c == word[count - 3]){
      sep ++;
    }

    if(count <4 || match >= 1){
      continue;
    }
    past = word[count -2];

    /*dont need to check the last two, have those allready + one for c represented as the + 1*/
    for(int i  = 0; i < count-3; i ++){
      if(word[i] == past && word[i+1] == c){
	match ++;
	continue;
      }
    }
  }

  printf("good words: %d\n", nice);
}
