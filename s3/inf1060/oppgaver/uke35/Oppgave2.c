#include <stdio.h>
#include <string.h>

char strgetc(char s[], int pos);

int main(void)
{
  char s[20];
  printf ("Write something \n");
  scanf("%s" ,s);

  printf("%c \n", strgetc(s, 5));
}


char strgetc(char s[], int pos)
{
  char *p = s;
  if (strlen(p) <= pos){
    printf("character does not exist \n");
    return 0;
  }
  
  return (char) s[pos];
}

