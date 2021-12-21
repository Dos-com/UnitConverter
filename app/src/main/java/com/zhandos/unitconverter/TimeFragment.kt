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
import com.zhandos.unitconverter.Units.Time
import com.zhandos.unitconverter.Units.Weight

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [TimeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class TimeFragment : Fragment(), AdapterView.OnItemSelectedListener {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var timeSpinner: Spinner
    private lateinit var timeValueET: EditText
    private lateinit var timeSecTV:TextView
    private lateinit var timeMinuteTV:TextView
    private lateinit var timeHoursTV:TextView
    private lateinit var timeDayTV:TextView
    private lateinit var timeWeekTV:TextView
    private lateinit var timeMonthTV:TextView
    private lateinit var timeYearTV:TextView
    private lateinit var timeCenturyTV:TextView

    private var nmArray:Array<String> = Array(10){""}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }

        nmArray = resources.getStringArray(R.array.time_units)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_time, container, false)


        timeSpinner = view.findViewById(R.id.spinner_time)
        timeValueET = view.findViewById(R.id.time_value)

        timeSecTV = view.findViewById(R.id.time_sec)
        timeMinuteTV = view.findViewById(R.id.time_minute)
        timeHoursTV = view.findViewById(R.id.time_hours)
        timeDayTV = view.findViewById(R.id.time_day)
        timeWeekTV = view.findViewById(R.id.time_week)
        timeMonthTV = view.findViewById(R.id.time_month)
        timeYearTV = view.findViewById(R.id.time_year)
        timeCenturyTV = view.findViewById(R.id.time_century)



        val spinnerAdapter =  ArrayAdapter<String>(requireContext(), android.R.layout.simple_spinner_item, nmArray)

        timeSpinner.adapter = spinnerAdapter

        val valueWatcher = object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                convert(timeSpinner.selectedItemPosition)
            }

            override fun afterTextChanged(s: Editable?) {
            }
        }

        timeValueET.addTextChangedListener(valueWatcher)
        timeSpinner.onItemSelectedListener = this

        return view
    }

    fun convert(position:Int){
        if (timeValueET.text.toString().isDigitsOnly() && !timeValueET.text.isNullOrBlank()){
            timeSecTV.text = Time.convert(timeValueET.text.toString().toInt(),nmArray[position],nmArray[0])
            timeMinuteTV.text = Time.convert(timeValueET.text.toString().toInt(),nmArray[position],nmArray[1])
            timeHoursTV.text = Time.convert(timeValueET.text.toString().toInt(),nmArray[position],nmArray[2])
            timeDayTV.text = Time.convert(timeValueET.text.toString().toInt(),nmArray[position],nmArray[3])
            timeWeekTV.text = Time.convert(timeValueET.text.toString().toInt(),nmArray[position],nmArray[4])
            timeMonthTV.text = Time.convert(timeValueET.text.toString().toInt(),nmArray[position],nmArray[5])
            timeYearTV.text = Time.convert(timeValueET.text.toString().toInt(),nmArray[position],nmArray[6])
            timeCenturyTV.text = Time.convert(timeValueET.text.toString().toInt(),nmArray[position],nmArray[7])
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment TimeFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            TimeFragment().apply {
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