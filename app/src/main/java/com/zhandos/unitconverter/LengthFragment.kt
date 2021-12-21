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
import com.zhandos.unitconverter.Units.Length
import com.zhandos.unitconverter.Units.Temperature

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [LengthFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LengthFragment : Fragment(), AdapterView.OnItemSelectedListener {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private var nmArray:Array<String> = Array(10){""}

    private lateinit var lengthSpinner: Spinner
    private lateinit var lengthValueET:EditText
    private lateinit var inchTV: TextView
    private lateinit var ftTV: TextView
    private lateinit var ydTV: TextView
    private lateinit var meterTV: TextView
    private lateinit var dmTV: TextView
    private lateinit var cmTV: TextView
    private lateinit var mmTV: TextView
    private lateinit var umTV: TextView
    private lateinit var kmTV: TextView
    private lateinit var mileTV: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
        nmArray = resources.getStringArray(R.array.length_units)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_length, container, false)
        lengthSpinner = view.findViewById(R.id.spinner_length)

        lengthValueET = view.findViewById(R.id.length_value)
        inchTV = view.findViewById(R.id.length_inch)
        ftTV = view.findViewById(R.id.length_ft)
        ydTV = view.findViewById(R.id.length_yd)
        meterTV = view.findViewById(R.id.length_meter)
        dmTV = view.findViewById(R.id.length_dm)
        cmTV = view.findViewById(R.id.length_cm)
        mmTV = view.findViewById(R.id.length_mm)
        umTV = view.findViewById(R.id.length_um)
        kmTV = view.findViewById(R.id.length_km)
        mileTV = view.findViewById(R.id.length_mile)


        val spinnerAdapter =  ArrayAdapter<String>(requireContext(), android.R.layout.simple_spinner_item, nmArray)


        lengthSpinner.adapter = spinnerAdapter

        val valueWatcher = object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                convert(lengthSpinner.selectedItemPosition)
            }

            override fun afterTextChanged(s: Editable?) {
            }
        }

        lengthSpinner.onItemSelectedListener = this
        lengthValueET.addTextChangedListener(valueWatcher)
        return view
    }

    fun convert(position:Int){
        if (lengthValueET.text.toString().isDigitsOnly() && !lengthValueET.text.isNullOrBlank()){

            inchTV.text = Length.convert(lengthValueET.text.toString().toInt(),nmArray[position],nmArray[0])
            ftTV.text = Length.convert(lengthValueET.text.toString().toInt(),nmArray[position],nmArray[1])
            ydTV.text = Length.convert(lengthValueET.text.toString().toInt(),nmArray[position],nmArray[2])
            meterTV.text = Length.convert(lengthValueET.text.toString().toInt(),nmArray[position],nmArray[3])
            dmTV.text = Length.convert(lengthValueET.text.toString().toInt(),nmArray[position],nmArray[4])
            cmTV.text = Length.convert(lengthValueET.text.toString().toInt(),nmArray[position],nmArray[5])
            mmTV.text = Length.convert(lengthValueET.text.toString().toInt(),nmArray[position],nmArray[6])
            umTV.text = Length.convert(lengthValueET.text.toString().toInt(),nmArray[position],nmArray[7])
            kmTV.text = Length.convert(lengthValueET.text.toString().toInt(),nmArray[position],nmArray[8])
            mileTV.text = Length.convert(lengthValueET.text.toString().toInt(),nmArray[position],nmArray[9])
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment LengthFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            LengthFragment().apply {
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