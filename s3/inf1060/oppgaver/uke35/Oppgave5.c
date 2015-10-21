#include <stdio.h>

int ishex(unsigned char c);
int hexval(unsigned char c);

int main()
{
  hexval(getchar());
  return 0;
}



int ishex(unsigned char c)
{

  if((((c - '0') < 10) && ((c - '0') > 0))|| (((c- 'A') < 10) && ((c - 'A') > 0))|| (((c - 'a') < 10) && ((c - 'a') > 0))){
    printf("%c is hex \n", c);
    return 1;
  }

  printf("%c is not hex \n", c);
  return 0;

}


int hexval(unsigned char c)
{
  int a = c;
  if (ishex(a) == 0){
    return 0;
  }
  
  if ((c - '0' <10)){
    c  = c - '0';
  }
  else if (c - 'A' < 10){
    c = c -'A' + 10 ;
  }
  else{
    c = c  - 'a' + 10;
  }
  
  printf("%d \n", c);
}
