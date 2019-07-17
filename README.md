# Android Precourse Challenge
In order to remove even more barriers for those that want to participate in Lambda School, we've created the Lambda Challenge. Based on our data, we are confident that if you can complete the Lambda Challenge, we can help you learn to code, and get a job as an Android developer.

If the questions in here are too difficult then you can begin working through our precourse work which covers the fundamentals [here](apply.lambdaschool.com).
You should also complete an application for our full Android course if you have not already done so. Apply [here](apply.lambdaschool.com).
## Prerequisites
In order to complete this challenge you will need a basic understanding of the following concepts:

Intro to Android
* create a project in Android Studio
* prepare a basic testing environment
* edit the user interface using XML
* understand basic application interaction
* use print statements to debug programs
* make code changes that update the application

Intro to Kotlin
* write code in an interactive coding environment
* output text for applications without a graphical user interface
* comment source code to allow others to better understand it
* understand and explain the role of primitive data types
* use Strings and String interpolation

Kotlin Operators and Expressions
* use assignment, relational and arithmetic operators
* use operator shortcuts
* understand logical operators
* understand Kotlin null-safety
* use the Elvis operator

Conditionals and Loops
* use if and else statements to control the flow of code
* use a when statement to make a selection
* use a while loop to run code until a condition is met
* use a for loop to perform a task a specific number of times

Methods
* write and call simple methods
* return a value from a method
* write methods that accept and use parameters
* learn to overload methods so that they be declared with many parameter combinations
* accept input from the user without a graphical user interface

Collections
* understand what an array is and how to create one
* access and manipulate data in an array
* iterate through and array with a loop
* understand the difference between arrays and lists
* create a list and manipulate its data
* understand and store data in key-value pairs

Basic Activity layouts
* know what a layout is and how to use it
* understand the difference between views and view groups
* use views and view groups to arrange a layout

Class Basics
* understand an explain the difference between classes and objects
* understand what class members are
* understand and use constructors
* define and use encapsulation

## The Challenge
Download the starter Android project [here](https://github.com/LambdaSchool/Android-Precourse-Challenge/archive/master.zip). You'll need to decompress the zip file and open the unzipped folder in Android Studio.

You'll be writing the necessary code to complete a simple [Hangman game](https://en.wikipedia.org/wiki/Hangman_(game)). The file you'll be editing is `Game.kt`, and you'll need to complete the following steps:

**Note: The project will not build or run until you complete the following steps**
1. First, you'll need to write is the `makeGuess(c: Char) : Pair<String, Boolean>` method. This method will allow the user to make a guess with a single `Character`, and will return two values (a `Pair`) that represent the masked or incomplete word (ie: `l_mbd_`) and a Boolean (true/false) for whether or not they have won. Some of the code for this method has been written for you -- you'll learn more about the Kotlin-specific data types like `Pair` and `Triple` later in the course.
2. Complete the method that returns the list of guessed letters - `getUsedLetters() : HashSet<Char>`
3. Write the method that returns the word to be guessed - `getWordToGuess() : String`
4. Write the method that determines if the game is over or not - `isGameOver() : Boolean`
5. Complete the private method for determining if a guess is correct, and returns either the correct guessed letter, or an underscore - `isCorrectGuess(c: Char): Char`
6. Once steps 1-5 are complete, run and test your game. If everything works correctly, you're done! Otherwise, debug and fix any issues you encounter.

The code in Game.kt is also commented with detailed instructions. You should not have to worry about editing the Android `MainActivity.kt` file or any of the layout or resource files, all of your work should happen in the Game.kt code, although you're encouraged to read and grok the `MainActivity` code too. **Note: Do not worry about making the code work with device rotation; we'll work on that throughout the regular Android course.**

**To allow testing to work, be sure to make all members of the `Game` class are public (default in Kotlin) unless otherwise specified.**  

**Please be sure to read all of the instructions.**  

## Finishing Up
When you've finished, **zip up your work folder** and send it in an email to [justin@lambdaschool.com](mailto:justin@lambdaschool.com)

## Resources
[Lambda's Intro to Android Curriculum](https://learn.lambdaschool.com/and-pre/sprint/recxcgsftw66rq9io) - Curriculum material, including videos for Lambda's Intro to Android course. Covers everything you need to know for this challenge.
[The Java Programming Language Guide](https://docs.oracle.com/javase/7/docs/api/) - Has many pages on specific topics such as Strings, collections, methods, etc. The menu on the left will help you navigate to what you might need.
[Google's Android Developer Resource](https://developer.android.com/docs/) - Has many of the same things that the Java documentation has, in addition to Android Specific classes and details.
