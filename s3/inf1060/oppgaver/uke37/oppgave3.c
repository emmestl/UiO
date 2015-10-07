#include <stdio.h>
int main(void){
  short arr[] = {2, 1, -1, 10, 22, 21};
  int arrlen = 6;
  int i;
  short* p = arr;
  
  for(i = 0; i <arrlen; i ++){
    printf("[%d]: %d\n", i, *p);
    ++p;
  }
}
