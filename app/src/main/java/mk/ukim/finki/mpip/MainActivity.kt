package mk.ukim.finki.mpip

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var resultLauncher: ActivityResultLauncher<Intent>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
       val textView:TextView = findViewById(R.id.textviews)
        val buttonEx:Button = findViewById(R.id.startExplicit)
        val buttonIm:Button = findViewById(R.id.startImplicit)


        resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == RESULT_OK) {
                val data: Intent? = result.data
                val message = data?.getStringExtra("result_message")
                textView.text = message
                print("Result message: $message")
            }
        }

        buttonEx.setOnClickListener(
            {
                val intent = Intent(this,ExplicitActivity:: class.java)
            resultLauncher.launch(intent)
        })
        buttonIm.setOnClickListener{
            val intent = Intent("mk.ukim.finki.mpip.IMPLICIT_ACTION")
            startActivity(intent)
        }

        }
}