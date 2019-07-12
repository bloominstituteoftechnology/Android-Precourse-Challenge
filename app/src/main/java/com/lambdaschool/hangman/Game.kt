package com.lambdaschool.hangman

import java.util.*
import kotlin.collections.HashSet

/**
 *
 * Steps to complete the Android challenge are listed inline below
 */

class Game(dictionaryOfWords: List<String>) {
    // Student note: We'll learn about the HashSet later on in the Android course. For now, you can think of a HashSet
    // like an ArrayList of unique values. ArrayList lets you add multiple identical values, but a HashSet does not.
    private var guessedCharacters = HashSet<Char>()
    private var numberOfLives = 8
    private var words = dictionaryOfWords
    private var wordToGuess: String = ""

    fun initializeGame() {
        // select a random word from our array of words
        wordToGuess = words[Random().nextInt(words.size)]
        numberOfLives = 8
        guessedCharacters.clear()
    }

    fun makeGuess(guess: Char) : Pair<String, Boolean> {
        // Step 1:
        // -------
        // turn the following steps into Kotlin:
        //
        // 1. add the player's guess to the list of guessedCharacters
        // 2. if the wordToGuess does not contain their guess && the number of lives is > 0, then decrement
        // the number of lives remaining (they lost one life)
        // 3. return a Kotlin `Pair<String, Boolean>` for the player's masked word and whether or not they've won
        // A masked word is like l_mbd_ - it shows the missing letters from the player's guesses

        var maskedWord = ""

        wordToGuess.forEach { c ->
            maskedWord += isCorrectGuess(c) + " "
        }

        return Pair(maskedWord, hasWon())
    }

    fun getRemainingLives() : Int {
        return numberOfLives
    }

    fun getUsedLetters() : HashSet<Char> {
        // Step 2:
        // -------
        // return the HashSet of guessed characters
    }

    fun getWordToGuess() : String {
        // Step 3:
        // -------
        // return the word to be guessed that was set during the `initializeGame()` method
    }

    fun isGameOver() : Boolean {
        // Step 4:
        // -------
        // return a boolean that's true if the player has 0 lives remaining, otherwise
        // false
    }

    private fun isCorrectGuess(c: Char): Char {
        // Step 5:
        // -------
        // turn the following pseudocode into Kotlin:
        //
        // if the list of guessed characters contains c (ie: the guess is correct)
        //   return c
        // else
        //    return '_'
    }

    private fun hasWon() : Boolean {
        var complete = true
        wordToGuess.forEach { c ->
            if (!guessedCharacters.contains(c)) {
                complete = false
            }
        }

        return complete
    }
}