#include <stdio.h>

int main() {
    short a, b, sum;

    a = 20000;  b = 20000;  sum = a+b;
    if(sum - a != b){
      printf("short overflow \n");
      return 1;
    }
    printf("%d + %d = %d\n", a, b, sum);
    return 0;
}
