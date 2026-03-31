package za.ac.iie.flicker

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class AfternoonPage : AppCompatActivity() {
    //making an array for all the text displays we want for our app
    private val afternoonMessages = arrayOf(
        "Message a colleague to check in",
        "Share a funny meme with a friend",
        "Comment on someone’s story or post",
        "Invite a friend for a quick coffee",
        "Send a how’s your day going? text"
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_afternoon_page)

        val textView = findViewById<TextView>(R.id.afternoonMessage)
        //I want a random message each time so we pick a random message from the array
        //then we display it to the user
        val randomMessage = afternoonMessages.random()
        //making a return button so clicking the back button on any device is not needed
        val returnButton = findViewById<Button>(R.id.afternoonbutton)
        returnButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
            //because the data inputted has to be gone when the user clicks the return button
            //we create a new main page every time but because of that there
            // is a long delay in returning
            //I had to ask AI how to code an animation so it doesn't look so terrible
            overridePendingTransition(android.R.anim.slide_in_left,
                android.R.anim.slide_out_right)
        }
        textView.text = randomMessage
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}