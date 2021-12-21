package com.zhandos.unitconverter

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.DialogFragment


private const val ARG_LANG = "ARG_LANG"
private const val ARG_REQUEST_CODE = "ARG_REQUEST_CODE"
private const val ARG_LANG_ARRAY = "ARG_LANG_ARRAY"
private const val RESULT_SELECTED_LANG = "RESULT_SELECTED_LANG"

class ChooseLanguageFragment: DialogFragment() {
    private lateinit var languageListView:ListView
    private lateinit var langArray: ArrayList<String>
    companion object{
        fun newInstance(langPosition: Int, langArray: ArrayList<String>, requestCode: String): ChooseLanguageFragment {
            val args = Bundle().apply {
                putInt(ARG_LANG, langPosition)
                putStringArrayList(ARG_LANG_ARRAY, langArray)
                putString(ARG_REQUEST_CODE, requestCode)
            }

            val fragment = ChooseLanguageFragment()
            fragment.arguments = args
            return fragment
        }

        fun getResult(bundle: Bundle) = bundle.getInt(RESULT_SELECTED_LANG)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        langArray = arguments?.getStringArrayList(ARG_LANG_ARRAY) as ArrayList<String>
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.languages_list_view, container, false)


        languageListView = view.findViewById(R.id.languagesListView)
        languageListView.adapter = ArrayAdapter<String>(requireActivity(),R.layout.lang_list_item, langArray)
        this.dialog?.setTitle(R.string.choose_lang)

        val selectedItemPosition = arguments?.getInt(ARG_LANG)
        if (selectedItemPosition != null) {
            languageListView.setSelection(selectedItemPosition)
        }

        languageListView.setOnItemClickListener { adapterView, view, position, l ->

            val result = Bundle().apply {
                putInt(RESULT_SELECTED_LANG, position)
            }
            val requestCode = arguments?.getString(ARG_REQUEST_CODE)
            if (requestCode != null){
                parentFragmentManager.setFragmentResult(requestCode, result)
            }


            this.dismiss()
        }

        return view
    }


}