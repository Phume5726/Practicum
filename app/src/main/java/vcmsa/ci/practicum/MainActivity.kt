//ST10491210
//Phumelela Langelihle Mathe
package vcmsa.ci.practicum

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private val song = arrayOf("Song A", "Song B", "Song C", "Song D")
    private val artist = arrayOf("Artist A", "Artist B", "Artist C", "Artist D")
    private val rating = intArrayOf(4, 1, 2, 3)
    private val comments = arrayOf("Rap", "Dance song", "Best love song", "Memories")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }//code starts here

    var btnExit = findViewById<Button>(R.id.btnExit)
    var btnNext = findViewById<Button>(R.id.btnNext)
    var btnAdd = findViewById<Button>(R.id.btnAdd)

    btnExit.setOnClickListener {
        finish()
    }


}