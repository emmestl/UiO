#include <stdio.h>

main(){

  long count;
  int c;
  
  while ((c= getchar()) != EOF && count != 10){
    if (c == '\n' || c == '\t' || c == ' '){
      count ++;
    }
  }

  printf ("%ld \n" , count);
}
