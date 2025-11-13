package ro.pub.cs.systems.eim.myapplication10

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class PracticalTest01Var04MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_practical_test01_var04_main)

        val nameEditText = findViewById<EditText>(R.id.name_edit_text)
        val groupEditText = findViewById<EditText>(R.id.group_edit_text)
        val nameCheckBox = findViewById<CheckBox>(R.id.name_checkbox)
        val groupCheckBox = findViewById<CheckBox>(R.id.group_checkbox)
        val displayButton = findViewById<Button>(R.id.display_button)
        val resultTextView = findViewById<TextView>(R.id.result_text_view)

        nameEditText.isEnabled = nameCheckBox.isChecked
        groupEditText.isEnabled = groupCheckBox.isChecked

        nameCheckBox.setOnCheckedChangeListener { _, isChecked ->
            nameEditText.isEnabled = isChecked
        }

        groupCheckBox.setOnCheckedChangeListener { _, isChecked ->
            groupEditText.isEnabled = isChecked
        }

        displayButton.setOnClickListener {
            if ((nameCheckBox.isChecked && nameEditText.text.toString().isEmpty()) || (groupCheckBox.isChecked && groupEditText.text.toString().isEmpty())) {
                Toast.makeText(this, "Fields cannot be empty", Toast.LENGTH_SHORT).show()
            } else {
                val result = StringBuilder()
                if (nameCheckBox.isChecked) {
                    result.append(nameEditText.text.toString()).append(" ")
                }
                if (groupCheckBox.isChecked) {
                    result.append(groupEditText.text.toString())
                }
                resultTextView.text = result.toString().trim()
            }
        }


    }
}
