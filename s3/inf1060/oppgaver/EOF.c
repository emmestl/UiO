#include <stdio.h>

main(void){

  int c = getchar();
  putchar(c);
  printf("\n %d \n", EOF);
  int d;

  
  d = getchar();
  printf("%d \n", (getchar()!= EOF));
}
