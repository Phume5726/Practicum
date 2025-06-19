//ST10491210
//Phumelela Langelihle Mathe
package vcmsa.ci.practicum

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetailedActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detailed)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }//code starts here
        val song = intent.getStringArrayExtra("song")
        val artist = intent.getStringArrayExtra("artist")
        val rating = intent.getIntArrayExtra("rating")
        val comments = intent.getStringArrayExtra("comments")

        val tvDetails = findViewById<TextView>(R.id.tvDetails)
        val tvAverageRating = findViewById<TextView>(R.id.tvAverageRating)
        val btnDetails = findViewById<Button>(R.id.btnDetails)
        val btnCalcAvg = findViewById<Button>(R.id.btnCalcAvg)
        val btnBack = findViewById<Button>(R.id.btnBack)

        btnDetails.setOnClickListener {
            var details = "Playlist songs: \n\n"
            for (i in song!!.indices){
                details += """
                    song: ${song[i]}
                    artist: ${artist!![i]}
                    rating: ${rating!![i]}
                    comments: ${comments!![i]}
                    
                    """.trimIndent()
            }
            tvDetails.text = details

        }
        btnCalcAvg.setOnClickListener {
            if (rating!!.isNotEmpty()){
              var sum = 0
              for (rating in rating){
                  sum += rating
              }
              val average = sum.toDouble() / rating.size
              tvAverageRating.text = "Average rating: %.2f".format(average)
                }
            else {
                tvAverageRating.text = "No ratings yet"
            }
        }
            btnBack.setOnClickListener {
                finish()

            }
        }

    }