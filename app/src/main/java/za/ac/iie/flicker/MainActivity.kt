package za.ac.iie.flicker

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Thread.sleep(3000)
        installSplashScreen()
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val editText = findViewById<EditText>(R.id.editTextText)
        //code for the button to bring us to the following pages
        val sparkButton = findViewById<Button>(R.id.sparkButton)
        sparkButton.setOnClickListener {
            //helps with consistency in case someone types something "wrong" and breaks the app
            val input = editText.text.toString().trim().lowercase()

            //creating a when statement for what page the button will take the user to
            //adding multiple options as not everyone uses midday/evening
            when (input) {
                "morning", "early" -> startActivity(
                    Intent(
                        this,
                        MorningPage::class.java
                    )
                )

                "afternoon", "noon", "midday" -> startActivity(
                    Intent(
                        this,
                        AfternoonPage::class.java
                    )
                )

                "evening", "late", "night" -> startActivity(
                    Intent(
                        this,
                        EveningPage::class.java
                    )
                )
                //adding user error handling plus an added hint for what text is acceptable
                else -> {
                    Toast.makeText(
                        this, "Invalid input",
                        Toast.LENGTH_SHORT
                    ).show()
                    //I couldn't find a tutorial for this so I just asked AI for help :>
                    Handler(Looper.getMainLooper()).postDelayed({
                        Toast.makeText(this, "Try typing morning or evening", Toast.LENGTH_LONG)
                            .show()
                    }, 2000)
                }
            }
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}