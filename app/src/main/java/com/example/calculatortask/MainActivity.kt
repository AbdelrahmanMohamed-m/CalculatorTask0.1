package com.example.calculatortask

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doOnTextChanged
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
            DecimalEditText.text.clear()
            OctalEditText.text.clear()
            HexaDecimalEditText.text.clear()
            BinaryEditText.text.clear()
        }
    }

    private fun convertListeners() {

        binding.DecimalEditText.doOnTextChanged { text, _, _, _ ->

            if (text != null && text.isBlank() && binding.DecimalEditText.hasFocus()) {
                clearEditTexts()
            } else
                if (binding.DecimalEditText.hasFocus() && text != null && text.isNotBlank()) {
                    decimalConversion()
                }
        }


        binding.BinaryEditText.doOnTextChanged { text, _, _, _ ->
            if (text != null && text.isBlank() && binding.BinaryEditText.hasFocus()) {
                clearEditTexts()
            } else
                if (binding.BinaryEditText.hasFocus() && text != null && text.isNotBlank()) {
                    binaryConversion()
                }
        }


        binding.OctalEditText.doOnTextChanged { text, _, _, _ ->
            if (text != null && text.isBlank() && binding.OctalEditText.hasFocus()) {
                clearEditTexts()
            } else
                if (binding.OctalEditText.hasFocus() && text != null && text.isNotBlank()) {
                    octalConversion()
                }
        }
        binding.HexaDecimalEditText.doOnTextChanged { text, _, _, _ ->
            if (text != null && text.isBlank() && binding.HexaDecimalEditText.hasFocus()) {
                clearEditTexts()
            } else if (binding.HexaDecimalEditText.hasFocus() && text != null && text.isNotBlank()) {
                hexaDecimalConverstion()
            }
        }

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
















