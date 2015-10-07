#include <stdio.h>
#include <string.h>
//print ut hello world

int a;

int main(int length, char* msg[])
{

  if(msg[1] == 0){
    printf("No valid argument \n");
    return 1;
  }

  char *pt = msg[1]; 
  printf("%c \n", *pt);
  
  if(strlen(pt) == 1){
    a = (int) *pt -'0';
    printf("%d \n %d \n " , a, *pt);
  }
  printf("%s \n", msg[1]);

  return 0;
}
