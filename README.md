##Prefix

Expects files with one prefix expression per line. 
Will print answers as they are evaluated. Only works for *, +, and /, operators. 
Only works for expressions where the evaluation result will always be an integer >= 0.


[Judiciously used the example provided here.](https://www.geeksforgeeks.org/evaluation-prefix-expressions/)



###Quickstart
```bash
./gradlew build
java -jar build/libs/prefix-1.0-SNAPSHOT.jar src/test/resources/mockfile
```