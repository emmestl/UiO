#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>

int ordTeller(char ord[], FILE *f){
  int size = strlen(ord);
  int ant = 0;
  char c;
  int equal = 1;
  int j = 0;
  printf("%s\n", ord);
  printf("%d\n", size);

  while(((c = fgetc(f)) !=  EOF)){

    int i = 0;
    if(!isgraph(c)) continue;

    for(i = 0; (i < size); i++){
      if(c != ord[i]){
        break;
      }
      if(i == (size-1)){
        ant++;
      }
      if ((c = fgetc(f)) == EOF){
        break;
      }
    }
  }
  return ant;
}


int main(void){
  FILE *f = fopen("oppgave4.c", "r");
  if(!f){
    printf("File not found\n");
    return 1;
  }

  char ord[3] = {'i','f','\0'};
  printf("%d\n", ordTeller(ord, f));
  fclose(f);

  return 0;
}
