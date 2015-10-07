#include <stdio.h>
#include <string.h>

#define STREQ(s1, s2) (strcmp(s1, s2) != 0)


int main()
{
  printf("%d \n", STREQ("acb", "abc"));
  return 0;
}
