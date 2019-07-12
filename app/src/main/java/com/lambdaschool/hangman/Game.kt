package com.lambdaschool.hangman

import java.util.*
import kotlin.collections.HashSet

class Game(dictionaryOfWords: List<String>) {
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
        guessedCharacters.add(guess.toLowerCase())

        if(!wordToGuess.contains(guess, true) && numberOfLives > 0) {
            numberOfLives--
        }

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
        return guessedCharacters
    }

    fun getWordToGuess() : String {
        return wordToGuess
    }

    fun isGameOver() : Boolean {
        return numberOfLives == 0
    }

    private fun isCorrectGuess(c: Char): Char {
        return when (guessedCharacters.contains(c.toLowerCase())) {
            true -> c
            false -> '_'
        }
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