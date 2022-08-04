package by.yancheuski.testapp

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import by.yancheuski.testapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val emailValidator = EmailValidator()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            emailEditText.addTextChangedListener(emailValidator)
            saveButton.setOnClickListener {
                if (emailValidator.isValid) {
                    Toast.makeText(this@MainActivity,
                        getString(R.string.valid_email),
                        Toast.LENGTH_SHORT).show()
                } else {
                    val errorEmail = getString(R.string.invalid_email)
                    emailEditText.error = errorEmail
                    Toast.makeText(this@MainActivity, errorEmail, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}