#include <stdio.h>

int main()
{
  printf("Inches: ");
  int c = getchar() - '0';
  int times;
  int rest;
  printf("%d \n", c);
  while(c != 0){
    times = (c) / 12;
    rest = (c) % 12;

    printf("\n%d inches is %d foot an %d inches  \n", c, times, rest);
    c = getchar();
    c = c - '0';
  }
  printf("\n");

  return 0;
}

/*maa fikse denne, hvordan lagre en int som bestaar av flere tall? lese inn?*/
int getc(){

  while((c != EOF) && (c != '\n')){
    
  }
}

