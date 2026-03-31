package za.ac.iie.flicker

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class EveningPage : AppCompatActivity() {
    //original comment on the code is on the afternoonPage as I did that one first
    //the code is the same
    private val eveningMessages = arrayOf(
        "Send a good morning text to someone",
        "Share a photo of your breakfast",
        "Compliment a friend online",
        "React to a friend’s post with a fun emoji",
        "Ask someone how they slept"
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_evening_page)

        val textView = findViewById<TextView>(R.id.eveningMessage)

        val randomMessage = eveningMessages.random()

        val returnButton = findViewById<Button>(R.id.eveningbutton)
        returnButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
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