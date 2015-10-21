#include <stdio.h>
#include <stdlib.h>

char* tulloc(size_t size){
  char* p;
  char* front;
  int count = 0;
  int i = 0;
  
  p = malloc(sizeof(size*4+1));
  front = p;
  
  while ((p != NULL) && (i < size*4)){
    if( count == 4){
      count = 0;
    }

    if (count == 0){
      *p = 't';
    }
    else if(count == 1){
      *p = 'u';
    }
    else{
      *p = 'l';
    }

    ++count;
    ++p;
    ++i;
  }

  p = 0;
  return front; 
}

int main(void){
  char* p = tulloc(5);
  printf("%s\n", p);
  return 0;
}
