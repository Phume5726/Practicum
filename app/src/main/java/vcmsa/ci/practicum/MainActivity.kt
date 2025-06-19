//ST10491210
//Phumelela Langelihle Mathe
package vcmsa.ci.practicum

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private val song = arrayOf("Song A", "Song B", "Song C", "Song D")
    private val artist = arrayOf("Artist A", "Artist B", "Artist C", "Artist D")
    private val rating = intArrayOf(4, 1, 2, 3)
    private val comments = arrayOf("Rap", "Dance song", "Best love song", "Memories")

    private lateinit var btnExit: Button
    private lateinit var btnNext: Button
    private lateinit var btnAdd: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        btnExit = findViewById<Button>(R.id.btnExit)
        btnNext = findViewById<Button>(R.id.btnNext)
        btnAdd = findViewById<Button>(R.id.btnAdd)


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
                val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
                insets
        }  btnExit.setOnClickListener {
                finish()
           }
        btnNext.setOnClickListener {
            val intent = Intent(this@MainActivity, DetailedActivity::class.java)

            intent.putExtra("song", song)
            intent.putExtra("artist", artist)
            intent.putExtra("rating", rating)
            intent.putExtra("comments", comments)
            startActivity(intent)
        }
        btnAdd.setOnClickListener {
            Toast.makeText(this, "Your song has been added to your playlist", Toast.LENGTH_SHORT).show()
        }

    }

}