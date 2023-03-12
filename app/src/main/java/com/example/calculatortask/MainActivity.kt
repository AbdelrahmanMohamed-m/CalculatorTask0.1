package com.example.calculatortask

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import com.example.calculatortask.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        clearButton()
        convertListeners()
    }

    private fun clearButton() {
        binding.ClearBtn.setOnClickListener {
            clearEditTexts()
        }
    }

    private fun clearEditTexts() {
        binding.apply {
            DecimalEditText.setText("")
            OctalEditText.setText("")
            HexaDecimalEditText.setText("")
            BinaryEditText.setText("")
        }
    }

    private fun convertListeners() {

        binding.DecimalEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (binding.DecimalEditText.text.isEmpty()) {
                    return
                } else
                    if (binding.DecimalEditText.hasFocus()) {
                        decimalConversion()
                    }
            }

            override fun afterTextChanged(s: Editable?) {

            }

        })
        binding.BinaryEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (binding.BinaryEditText.text.isEmpty()) {
                    return
                } else
                    if (binding.BinaryEditText.hasFocus()) {
                        binaryConversion()
                    }
            }

            override fun afterTextChanged(s: Editable?) {

            }

        })
        binding.OctalEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (binding.OctalEditText.text.isEmpty()) {
                    return
                } else
                    if (binding.OctalEditText.hasFocus()) {
                        octalConversion()
                    }
            }

            override fun afterTextChanged(s: Editable?) {
            }
        })
        binding.HexaDecimalEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (binding.HexaDecimalEditText.text.isEmpty()) {
                    return
                } else
                    if (binding.HexaDecimalEditText.hasFocus()) {
                        hexaDecimalConverstion()
                    }
            }

            override fun afterTextChanged(s: Editable?) {
            }
        })
    }

    private fun hexaDecimalConverstion() {
        val hexadecimalEditTextValueToDecimal =
            binding.HexaDecimalEditText.text.toString().toLong(16)
        binding.DecimalEditText.setText(hexadecimalEditTextValueToDecimal.toString())
        binding.BinaryEditText.setText(convertDecimalToBinary(hexadecimalEditTextValueToDecimal))
        binding.OctalEditText.setText(convertDecimalToOctal(hexadecimalEditTextValueToDecimal))

    }

    private fun decimalConversion() {
        val decimalEditTextValue = binding.DecimalEditText.text.toString().toLong()
        binding.BinaryEditText.setText(convertDecimalToBinary(decimalEditTextValue))
        binding.OctalEditText.setText(convertDecimalToOctal(decimalEditTextValue))
        binding.HexaDecimalEditText.setText(convertDecimalToHexaDecimal(decimalEditTextValue))
    }

    private fun binaryConversion() {
        val changedDecimalValue = binding.BinaryEditText.text.toString().toLong(2)
        binding.DecimalEditText.setText(changedDecimalValue.toString())
        binding.OctalEditText.setText(convertDecimalToOctal(changedDecimalValue))
        binding.HexaDecimalEditText.setText(convertDecimalToHexaDecimal(changedDecimalValue))
    }

    private fun octalConversion() {
        val octalEditTextValue = binding.OctalEditText.text.toString().toLong(8)
        binding.BinaryEditText.setText(convertDecimalToBinary(octalEditTextValue))
        binding.DecimalEditText.setText(octalEditTextValue.toString())
        binding.HexaDecimalEditText.setText(convertDecimalToHexaDecimal(octalEditTextValue))

    }

    private fun convertDecimalToHexaDecimal(decimalNumber: Long) = decimalNumber.toString(16)
    private fun convertDecimalToBinary(decimalNumber: Long) = decimalNumber.toString(2)
    private fun convertDecimalToOctal(decimalNumber: Long) = decimalNumber.toString(8)
}
















