package com.example.gastodeviagem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnCalculate.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        val id = view?.id
        if (id === R.id.btnCalculate) {
            calculate()
        }
    }

    private fun calculate() {
        if (validateFields()) {
            val distance = editDistance.text.toString().toFloat()
            val price = editPrice.text.toString().toFloat()
            val autonomy = editAutonomy.text.toString().toFloat()

            val totalValue = (distance * price) / autonomy
            textTotalValue.text = "R$ ${"%.2f".format(totalValue)}"
        } else {
            Toast.makeText(this, getString(R.string.preencha_todos_campos), Toast.LENGTH_LONG)
        }
    }

    private fun validateFields(): Boolean {
        var isValid = true

        if (editDistance.text.toString() == "" || editPrice.text.toString() == "" ||
                editAutonomy.text.toString() == "") {
            isValid = false
        }

        return isValid
    }
}
