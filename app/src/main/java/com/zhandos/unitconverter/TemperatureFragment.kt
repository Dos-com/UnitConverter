package com.zhandos.unitconverter

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.text.isDigitsOnly
import com.zhandos.unitconverter.Units.Temperature
import com.zhandos.unitconverter.Units.Weight

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [TemperatureFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class TemperatureFragment : Fragment(), AdapterView.OnItemSelectedListener {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var tempSpinner: Spinner
    private lateinit var tempValueEd: EditText
    private lateinit var tempCelsiusTV:TextView
    private lateinit var tempKelvinTV:TextView
    private lateinit var tempFahrenheitTV:TextView

    private var nmArray:Array<String> = Array(10){""}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
        nmArray = resources.getStringArray(R.array.temp_units)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_temperature, container, false)


        tempSpinner = view.findViewById(R.id.spinner_temperature)
        tempValueEd = view.findViewById(R.id.temp_value)
        tempCelsiusTV = view.findViewById(R.id.temp_Celsius)
        tempKelvinTV = view.findViewById(R.id.temp_Kelvin)
        tempFahrenheitTV = view.findViewById(R.id.temp_Fahrenheit)


        val spinnerAdapter =  ArrayAdapter<String>(requireContext(), android.R.layout.simple_spinner_item, nmArray)

        tempSpinner.adapter = spinnerAdapter

        val valueWatcher = object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                convert(tempSpinner.selectedItemPosition)
            }

            override fun afterTextChanged(s: Editable?) {
            }
        }

        tempSpinner.onItemSelectedListener = this
        tempValueEd.addTextChangedListener(valueWatcher)

        return view
    }
    fun convert(position:Int){
        if (tempValueEd.text.toString().isDigitsOnly() && !tempValueEd.text.isNullOrBlank()){

            tempFahrenheitTV.text = Temperature.convert(tempValueEd.text.toString().toInt(),nmArray[position],nmArray[0]).toString() + " F"
            tempCelsiusTV.text = Temperature.convert(tempValueEd.text.toString().toInt(),nmArray[position],nmArray[1]).toString() + " C"
            tempKelvinTV.text = Temperature.convert(tempValueEd.text.toString().toInt(),nmArray[position],nmArray[2]).toString() + " K"
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment TemperatureFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            TemperatureFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        convert(position)
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        TODO("Not yet implemented")
    }
}