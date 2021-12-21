package com.zhandos.unitconverter

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.text.isDigitsOnly
import com.zhandos.unitconverter.Units.NumberSystems
import com.zhandos.unitconverter.Units.Temperature

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [NumberSystemFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class NumberSystemFragment : Fragment(), AdapterView.OnItemSelectedListener {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var numberSystemSpinner: Spinner
    private lateinit var numberSystemValueET: EditText
    private lateinit var hexTV:TextView
    private lateinit var octTV:TextView
    private lateinit var decTV:TextView
    private lateinit var binTV:TextView

    private var nmArray:Array<String> = Array(10){""}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }

        nmArray = resources.getStringArray(R.array.number_system_units)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_number_system, container, false)

        val nmArray = resources.getStringArray(R.array.number_system_units)

        numberSystemSpinner = view.findViewById(R.id.spinner_number_system)
        numberSystemValueET = view.findViewById(R.id.numberSystemValue)
        hexTV = view.findViewById(R.id.nm_hex)
        octTV = view.findViewById(R.id.nm_oct)
        decTV = view.findViewById(R.id.nm_dec)
        binTV = view.findViewById(R.id.nm_bin)


        val spinnerAdapter =  ArrayAdapter<String>(requireContext(), android.R.layout.simple_spinner_item, nmArray)

        numberSystemSpinner.adapter = spinnerAdapter

        val valueWatcher = object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                convert(numberSystemSpinner.selectedItemPosition)
            }

            override fun afterTextChanged(s: Editable?) {
            }
        }

        numberSystemSpinner.onItemSelectedListener = this
        numberSystemValueET.addTextChangedListener(valueWatcher)

        return view
    }

    fun convert(position:Int){
        if (numberSystemValueET.text.toString().isDigitsOnly() && !numberSystemValueET.text.isNullOrBlank()){

            hexTV.text = NumberSystems.convert(numberSystemValueET.text.toString(),nmArray[position],nmArray[0]).toString()
            octTV.text = NumberSystems.convert(numberSystemValueET.text.toString(),nmArray[position],nmArray[1]).toString()
            binTV.text = NumberSystems.convert(numberSystemValueET.text.toString(),nmArray[position],nmArray[2]).toString()
            decTV.text = NumberSystems.convert(numberSystemValueET.text.toString(),nmArray[position],nmArray[3]).toString()
        }
    }
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment NumberSystemFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            NumberSystemFragment().apply {
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