package com.lambdaschool.hangman

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

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

    fun handleLetterClicked(view: View) {
        letter.text.clear()
    }

    fun handleGuessClicked(view: View) {
        if(letter.text.isNullOrEmpty())
            return

        val (maskedWord, won) = game.makeGuess(letter.text.toString().single())
        word.text = getString(R.string.word, maskedWord)

        if(won) {
            Snackbar.make(view, R.string.winner_message, Snackbar.LENGTH_INDEFINITE).show()
        } else {
            lives.text = getString(R.string.remaining_lives, game.getRemainingLives().toString())
            guesses.text = getString(R.string.guessed_letters, game.getUsedLetters().toString())

            if(game.isGameOver()) {
                val snackbar = Snackbar.make(view, getString(R.string.loser_message, game.getWordToGuess()), Snackbar.LENGTH_INDEFINITE)
                snackbar.setAction("RETRY") {
                    initializeGameUI()
                }
                snackbar.show()
            }
        }
    }
}
