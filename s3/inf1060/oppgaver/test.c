#include <stdio.h>

int main(void)
{
  int a = 6;
  int b = 5;
  printf("a = %d\n" , a);
  int c = a+b;
  int d = a & ~b;
  printf("a = %d \n b= %d \n", a, b);
  printf("c:(a+b) = %d \n d(a++ & tilde b) = %d \n", c 
	 , d);
}
