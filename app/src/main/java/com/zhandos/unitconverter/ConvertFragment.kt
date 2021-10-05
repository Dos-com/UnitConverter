package com.zhandos.unitconverter

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.text.isDigitsOnly
import androidx.fragment.app.Fragment

private const val UNIT_TYPE = "unit type"
private const val TAG = "ConvertFragment"

class ConvertFragment: Fragment(), AdapterView.OnItemSelectedListener {
    private var unitType:String =""
    private var value: Int = 0
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


        spinnerUnit2.onItemSelectedListener = this

        unitConvertEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

                if (s?.isDigitsOnly() == true && !s?.isNullOrBlank()){
                    value = s.toString().toInt()
                    convert()
                }
                else{
                    resultConvert.text = "0"
                }
            }

            override fun afterTextChanged(s: Editable?) {

            }

        })

        return view
    }

    private fun convert(){
        when(unitType){
            UnitListFragment.unitList[0] -> {
                resultConvert.text = Distance.convert(value,listTypes[spinnerUnit1.selectedItemPosition], listTypes[spinnerUnit2.selectedItemPosition])
                // val unitList = listOf("Distance","Weight","Time","Temperature","Currency", "Number systems BIN/OCT/DEC/HEX")
            }
            UnitListFragment.unitList[1] -> {
                resultConvert.text = Weight.convert(value,listTypes[spinnerUnit1.selectedItemPosition], listTypes[spinnerUnit2.selectedItemPosition])
            }
            UnitListFragment.unitList[2] -> {
                resultConvert.text = Time.convert(value,listTypes[spinnerUnit1.selectedItemPosition], listTypes[spinnerUnit2.selectedItemPosition])
            }
            UnitListFragment.unitList[3] -> {
                resultConvert.text = Temperature.convert(value,listTypes[spinnerUnit1.selectedItemPosition], listTypes[spinnerUnit2.selectedItemPosition]).toString()
            }
            UnitListFragment.unitList[4] -> {
                resultConvert.text = NumberSystems.convert(value.toString(),listTypes[spinnerUnit1.selectedItemPosition], listTypes[spinnerUnit2.selectedItemPosition])
            }
        }
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

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        Log.d("TAG", "onItemSelected: ${listTypes[position]}")
        convert()
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        Log.d("TAG", "onItemSelected: ")
    }
}