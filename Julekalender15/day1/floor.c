#include <stdio.h>


int main(void)
{
  int floor = 0;
  int possition = 0;
  char c;
  
  while((c=fgetc(stdin))!= EOF){
    if(c == '('){
      possition++;
      floor++;
    }
    else if (c == ')'){
      possition++;
      floor--;
    }
    //check if basement
    if(floor == -1){
      printf("basement at position: %d\n", possition);
    }
  }

  printf("floor nr: %d\n", floor);
  return 1;
}
