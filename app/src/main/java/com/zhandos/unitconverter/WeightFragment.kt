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
import com.zhandos.unitconverter.Units.Weight
import kotlin.math.log

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [WeightFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class WeightFragment : Fragment(), AdapterView.OnItemSelectedListener {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var weightSpinner: Spinner
    private lateinit var weight_mlgramsTV :TextView
    private lateinit var weight_gramsTV :TextView
    private lateinit var weight_kilogramsTV :TextView
    private lateinit var weight_centnerTV :TextView
    private lateinit var weight_tonTV :TextView
    private lateinit var weight_valueET :EditText


    private var nmArray:Array<String> = Array(10){""}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }

        nmArray = resources.getStringArray(R.array.weight_units)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_weight, container, false)


        weightSpinner = view.findViewById(R.id.spinner_weight)
        weight_mlgramsTV = view.findViewById(R.id.weight_mlgrams)
        weight_gramsTV = view.findViewById(R.id.weight_grams)
        weight_kilogramsTV = view.findViewById(R.id.weight_kilograms)
        weight_centnerTV = view.findViewById(R.id.weight_centner)
        weight_tonTV = view.findViewById(R.id.weight_ton)
        weight_valueET = view.findViewById(R.id.weight_value)


        val spinnerAdapter =  ArrayAdapter<String>(requireContext(), android.R.layout.simple_spinner_item, nmArray)

        weightSpinner.adapter = spinnerAdapter


        weightSpinner.onItemSelectedListener = this


        val valueWatcher = object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                convert(weightSpinner.selectedItemPosition)
            }

            override fun afterTextChanged(s: Editable?) {
            }
        }

        weight_valueET.addTextChangedListener(valueWatcher)

        return view
    }

    fun convert(position:Int){
        if (weight_valueET.text.toString().isDigitsOnly() && !weight_valueET.text.isNullOrBlank()){
            weight_mlgramsTV.text = Weight.convert(weight_valueET.text.toString().toInt(),nmArray[position],nmArray[0])
            weight_gramsTV.text = Weight.convert(weight_valueET.text.toString().toInt(),nmArray[position],nmArray[1])
            weight_kilogramsTV.text = Weight.convert(weight_valueET.text.toString().toInt(),nmArray[position],nmArray[2])
            weight_centnerTV.text = Weight.convert(weight_valueET.text.toString().toInt(),nmArray[position],nmArray[3])
            weight_tonTV.text = Weight.convert(weight_valueET.text.toString().toInt(),nmArray[position],nmArray[4])
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment WeightFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            WeightFragment().apply {
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