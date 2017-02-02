## dblp-parser
A simple library to parse DBLP data.

Simply extend the DblpElementProcessor and include the necessary logic for your operations in the process Method.
This Library provides POJOs for all relevant elements:
+ Article
+ Incollection
+ Proceedings
+ Inproceedings
+ Book
+ Website

#### Install
To install the library you need a local maven repository and a current version of gradle.
Steps

1. Checkout of dblp-parser to local repository
2. navigate to the project folder
3. execute the install task of gradle, e.g. at the console with ```gradle install```
4. finished
5. Include it in your project, e.g. with gradle: 
   ```compile group: 'org.dblp', name: 'dblp-parser', version: '0.1.0'```
