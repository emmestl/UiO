#include <stdio.h>

#define LOWER 0
#define UPPER 100
#define STEP 10

main(void){

  float celcius;
  float fahr;

  /* prints out table for celcius vaues 0 -> 100 with 10 in step*/

  int lower;
  int upper;
  int step;

  celcius = LOWER;

  printf ("%10s %10s \n", "Celcius", "Fahr"); 
  
  while (celcius <= UPPER){

    fahr = (9.0/5.0)*celcius + 32;
    printf ("%10.0f %10.1f \n", celcius, fahr);

    celcius += STEP;
  }
}
