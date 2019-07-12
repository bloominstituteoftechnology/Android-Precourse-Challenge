package com.lambdaschool.hangman

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

/**
 *
 * Student note: You should not have to edit this file at all, although you're encouraged
 * to grok it and try to understand what's happening
 *
 */

class MainActivity : AppCompatActivity() {
    lateinit var game: Game

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        game = Game(arrayListOf("lambda", "school", "android", "precourse", "hyrule", "triforce"))
        initializeGameUI()
    }

    private fun initializeGameUI() {
        game.initializeGame()
        // Initialize the guessed letters and remaining lives to empty strings, since we
        // just started the app
        word.text = getString(R.string.word, "")
        guesses.text = getString(R.string.guessed_letters, "")
        lives.text = getString(R.string.remaining_lives, game.getRemainingLives().toString())
    }

    // Clear the current letter when the input field is tapped
    fun handleLetterClicked(view: View) {
        letter.text.clear()
    }

    // Handle the guess button being clicked
    fun handleGuessClicked(view: View) {
        if(letter.text.isNullOrEmpty())
            return

        val (maskedWord, won) = game.makeGuess(letter.text.toString().single())
        word.text = getString(R.string.word, maskedWord)

        // If the game was won, display a message notifying the user, and let them try again
        if(won) {
            val snackbar = Snackbar.make(view, R.string.winner_message, Snackbar.LENGTH_INDEFINITE)
            snackbar.setAction(R.string.try_again) {
                initializeGameUI()
            }
            snackbar.show()
        } else {
            // Otherwise, if the user hasn't won, update the UI with their latest guess
            lives.text = getString(R.string.remaining_lives, game.getRemainingLives().toString())
            guesses.text = getString(R.string.guessed_letters, game.getUsedLetters().toString())

            // If the user lost, notify them with a Snackbar and let them retry
            if(game.isGameOver()) {
                val snackbar = Snackbar.make(view, getString(R.string.loser_message, game.getWordToGuess()), Snackbar.LENGTH_INDEFINITE)
                snackbar.setAction(R.string.retry) {
                    initializeGameUI()
                }
                snackbar.show()
            }
        }
    }
}
