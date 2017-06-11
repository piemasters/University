I have found that when running the code within Netbeans, computers running a 64bit version of Java can encounter a 'NumberFormatException'.
For some reason when splitting an array, in Netbeans it creates an addtional blank item at the start of the array, which is not normal behaviour.
This will not occur when the project is built and the JAR is run. The JAR attached should run correctly.

If this problem in encountered when running the program inside of Netbeans, uncomment line 29 in 'SharedMethods.java' and it will resolve the issue.
Warning: this will break any resulting JAR file.
The line is: 'strArray = Arrays.copyOfRange(strArray, 1, strArray.length);'

