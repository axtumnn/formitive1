package za.ac.iie.myformative1

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.util.Log
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Getting references to UI elements
        val inputTime = findViewById<EditText>(R.id.edtText)
        val btnSuggest = findViewById<Button>(R.id.btnsuggest)
        val btnReset = findViewById<Button>(R.id.btnReset)
        val textResult = findViewById<TextView>(R.id.txtResult)

        // Set up click listener for the Suggest button
        btnSuggest.setOnClickListener {
            // Get user input, trim spaces, convert to lowercase, and normalize spaces
            val timeOfDay = inputTime.text.toString().trim().lowercase()

            // Get the corresponding meal suggestion
            val suggestion = getMealSuggestion(timeOfDay)


            if (suggestion != null) {
                // If a valid meal suggestion is found, display it
                textResult.text = "Suggested Meal: $suggestion"
                Log.d("MealSuggestion", "User entered: $timeOfDay, Suggestion: $suggestion")
                // If input is invalid, show a Toast message and log the error

            } else {
                Toast.makeText(this, "Invalid time of day. Try Morning, Mid-morning, Afternoon, Mid-afternoon, Dinner, or After Dinner Snack.", Toast.LENGTH_LONG).show()
                Log.e("MealSuggestion", "Invalid input: $timeOfDay")
            }
        }
        // Set up click listener for the Reset button
        btnReset.setOnClickListener {
            // Clear the input field and reset the result text
            inputTime.text.clear()
            textResult.text = ""
            Log.d("MealSuggestion", "Reset button clicked")
        }
    }
    // Function to return meal suggestions based on the time of day
    private fun getMealSuggestion(timeOfDay: String): String? {
        // Using a map to store meal suggestions for different times of the day
        when (timeOfDay) {
            "morning" -> {
                return "Eggs"
            }
            "mid-morning" -> {
                return "Fruit"
            }
            "afternoon" -> {
                return "Sandwich"
            }
            "mid-afternoon" -> {
                return "Cake"
            }
            "dinner" -> {
                return "Pasta"
            }
            "after dinner snack" -> {
                return "Ice cream"
            }
            else -> {
                return null





                ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
                    val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
                    v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
                    insets
                }
            }
        }
    }
  }


