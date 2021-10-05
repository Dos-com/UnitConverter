package com.zhandos.unitconverter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.fragment.app.Fragment

private const val UNIT_TYPE = "unit type"

class ConvertFragment: Fragment() {
    private var unitType:String =""
    private var listTypes = listOf<String>()
    private lateinit var unitConvertEditText: EditText
    private lateinit var spinnerUnit1: Spinner
    private lateinit var spinnerUnit2: Spinner
    private lateinit var resultConvert: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        unitType = arguments?.getString(UNIT_TYPE).toString()

        val list = UnitListFragment.unitList
        when (unitType) {
            list[0] -> {
                // Distance
                listTypes = Distance.types
            }
            list[1] -> {
                // Weight
                listTypes = Weight.types
            }
            list[2] -> {
                // Time
                listTypes = Time.types
            }
            list[3] -> {
                // Temperature
                listTypes = Temperature.types
            }
            list[4] -> {
                // Currency
                listTypes = Distance.types
            }
            list[5] -> {
                // Number systems BIN/OCT/DEC/HEX
                listTypes = NumberSystems.types
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.convert_fragment, container, false)


        unitConvertEditText = view.findViewById(R.id.unit_convert)
        resultConvert = view.findViewById(R.id.unit_converted)
        spinnerUnit1 = view.findViewById(R.id.unit_type_1)
        spinnerUnit2 = view.findViewById(R.id.unit_type_2)

        val adapter = activity?.let { ArrayAdapter(it,android.R.layout.simple_spinner_dropdown_item,listTypes) }
        adapter?.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerUnit1.adapter = adapter
        spinnerUnit2.adapter = adapter

        return view
    }

    companion object{
        fun newInstance(unit: String): ConvertFragment{
            val arg =Bundle().apply {
                putString(UNIT_TYPE, unit)
            }
            return ConvertFragment().apply {
                arguments = arg
            }
        }
    }
}