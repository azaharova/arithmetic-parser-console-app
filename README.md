# test-task-console
A repository for Java console application that performs the following tasks:
1. Opens the console and waits for user input.
2. Accepts an arithmetic expression with variables, for example, "(12 + x) * 23 + y"
3. An arithmetic expression with variables can be formed from the following components: 
a. A positive number, dimension no more than 16 bits.
b. Four arithmetic binary operations: '+', '-', '/', '*'
c. Brackets: '(' , ')'
d. Identifiers of variables, consisting of latin letters and numbers, starting with a letter
4. According to the given expression, forms an AST tree (https://en.wikipedia.org/wiki/Abstract_syntax_tree).
5. Waits for the user to enter the values of variables.
6. Counts and displays the result.

## Usage

* Run the application on Windows: .\gradlew run --console=plain

* Run the application on Linux: ./gradlew run --console=plain


