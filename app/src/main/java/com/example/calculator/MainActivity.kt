package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnOne.setOnClickListener {
            apply("1", true)
        }

        btnTwo.setOnClickListener {
            apply("2", true)
        }

        btnThree.setOnClickListener {
            apply("3", true)
        }

        btnFour.setOnClickListener {
            apply("4", true)
        }

        btnFive.setOnClickListener {
            apply("5", true)
        }

        btnSix.setOnClickListener {
            apply("6", true)
        }

        btnSeven.setOnClickListener {
            apply("7", true)
        }

        btnEight.setOnClickListener {
            apply("8", true)
        }

        btnNine.setOnClickListener {
            apply("9", true)
        }

        btnZero.setOnClickListener {
            apply("0", true)
        }

        btnPlus.setOnClickListener {
            apply("+", true)
        }

        btnMinus.setOnClickListener {
            apply("-", true)
        }

        btnMul.setOnClickListener {
            apply("*", true)
        }

        btnDivide.setOnClickListener {
            apply("/", true)
        }

        btnPercentage.setOnClickListener {
            apply("%", true)
        }

        btnDot.setOnClickListener {
            if (textViewExpression.text != ".")
            apply(".", true)
        }

        btnClear.setOnClickListener {
            textViewExpression.text = ""
            textViewResult.text = ""
        }

        btnEquals.setOnClickListener {
            try {
                val expression = ExpressionBuilder(textViewExpression.text.toString()).build()
                val result = expression.evaluate()
                val longResult = result.toLong()

                if(result == longResult.toDouble())
                    textViewResult.text = longResult.toString()
                else
                    textViewResult.text = result.toString()

            }catch (e:Exception){

            }
        }

        btnBack.setOnClickListener {
            val text = textViewExpression.text.toString()
            if(text.isNotEmpty()) {
                textViewExpression.text = text.drop(1)
            }

            textViewResult.text = ""
        }
    }

    fun apply(string: String, canClear: Boolean) {

        if(textViewResult.text.isNotEmpty()){
            textViewExpression.text = ""
        }
        if (canClear) {
            textViewResult.text = ""
            textViewExpression.append(string)
        } else {
            textViewExpression.append(textViewResult.text)
            textViewExpression.append(string)
            textViewResult.text = ""
        }
    }
}