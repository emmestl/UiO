#include <string.h>
#include <stdio.h>
#include <stdlib.h>


int main(int argc, char** argv){

  printf ("Hello %s, your are %s years old\n", argv[1], argv[2]);

  FILE* f;
  f = fopen(argv[3], "w");
  char* str;
  int size = strlen("Hello ") + strlen(argv[1]) + strlen(", you are ") + strlen(argv[2]) + strlen(" years old");
  str = malloc(size +1);
  
  if(str != NULL){
      str[size] = '\0';
      printf("%s\n", str);
      strcat(str, "Hello ");
      printf("%s\n", str);
      strcat(str, argv[1]);
      printf("%s\n", str);
      strcat (str, ", you are ");
      printf("%s\n", str);
      strcat(str, argv[2]);
      printf("%s\n", str);
      strcat(str, " years old");
      printf("%s\n", str);
    }

    fwrite(str, 1, strlen(str), f);

}
