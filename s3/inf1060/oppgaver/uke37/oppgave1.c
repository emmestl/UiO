#include <stdio.h>

void sum(int a, int b, int* result){
  *result = a + b;

  printf("%d\n", *result);
  return;

}

int main(void){

  int a = 1;
  int b = 2;
  int result;
  
  sum(a, b, &result); 

  return 0;
}
