package mk.ukim.finki.mpip

import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ImplicitActivity : AppCompatActivity() {
    private lateinit var textimplicit: TextView
    @SuppressLint("QueryPermissionsNeeded")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_implicit)
        textimplicit = findViewById(R.id.textimplicit)
        val intent = Intent(Intent.ACTION_MAIN).apply {
            addCategory(Intent.CATEGORY_LAUNCHER)
        }

        val activities = packageManager.queryIntentActivities(intent, PackageManager.MATCH_ALL)

        val activityNames = activities.joinToString(separator = "\n") { resolveInfo ->
            resolveInfo.activityInfo.name
        }

        textimplicit.text = activityNames
    }

}