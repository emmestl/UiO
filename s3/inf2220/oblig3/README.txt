1. Tar utgangspunkt i koden presantert i på forelesnings-foilene og teorien bake paperet til Boyer-Moore. Det som er hovedsaklig verdt å påpeke er metoden shift(), her har jeg lagt til at den skjekker om hvis badCharShift[c] == 1, altså at c forekommer i needelen, så sjekker jeg at den finnes andre steder i needelen enn den posisjonen den er satt på nå. Hvis den er det så shifter jeg helt til de to matcher. Gjør at jeg ikke må slå opp så mange ganger.

   Når dette er sagt tar den som sagt ugangspunkt i Boyer-Moore sin algoritme hvor den sjekker siste karakter, helt til den finner en mismatch, så shifter den så mye som vil være mulig. For så å sjekke på nytt. Når den finner en match legges det inn i en Arraylist bestående av matcher. 


2. Kompilerer med "javac *.java"
3. Kjør ved "java AssignmentThree <needle.txt> <haystack.txt>"

4. Antar at filen som skal leses inn kan lagres på en enorm String. Antar at linjeshift telles som en karakter.

5. Nei, ikke utenom den nevnt over i #1

6. Alt ser ut til å funke som det skal

7. Credit til Boyer-Moore sitt paper utgitt Oktober 1977 i "Communications of the ACM" Volume 20 nr 10. Og noe credit til forelesningsfoilene til inf2220 om String-search 2015.




Testcases:
Ved kjøring av:
    java AssignmentThree nHolmes.txt scarlet.txt

    finner 94 forekomster av Holmes. Er også dette grep finner. 


Ved kjøring av:
    java AssignmentThree nWinnie.txt winnie.txt

    finner 5 forekomster av Robin. Er også dette grep finner. 

Ved kjøring
    java AssignmentThree nBlank.txt Blank.txt

    finner 4 forekomster av i__  som gir "isa, isa, i p, in ". Sjekker vi filen selv ser vi at dette stemmer.

        
