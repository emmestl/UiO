#include <stdio.h>
#include <string.h>


int main(void){

  char c;
  int line = 0;
  int nice = 0;
  int bad = 0;
  char past = '\n';
  char vowels[] = {'a','e','i','o','u', '\0'};
  int vowels_nr = 0;
  int equal = 0;
  char* bad_combo[] = {"ab", "cd", "pq", "xy"};
  int len = 4; //bad_combo length
  
  while((c= fgetc(stdin)) != EOF){
    if(c == '\n'){ //new string line
      line ++;
      //printf("%d\tequal %d\tvouwels %d\n", line, equal, vowels_nr);
      if(bad == 0 && vowels_nr >= 3 && equal >= 1){
	//printf("%d\tequal %d\tvouwels %d\n", line, equal, vowels_nr);
	nice++;
      }
      bad = 0;
      equal = 0;
      vowels_nr = 0;
      past = c;
      continue;
    }
    if(bad){
      continue;
    }
    if(past != '\n'){
      if(past == c){
	equal++;
      }
      else{
	for(int i = 0; i < len; i ++){
	  if(past == bad_combo[i][0] && c == bad_combo[i][1]){
	    bad = 1; //we have a bad word
	    continue;
	  }
	}
      }
    }

    for(unsigned int i = 0; i < strlen(vowels); i ++){
      if(c == vowels[i]){
	vowels_nr++;
      }
    }
    past = c;
  }


  printf("good words: %d\n", nice);
}
