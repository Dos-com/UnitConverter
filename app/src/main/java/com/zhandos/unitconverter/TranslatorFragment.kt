package com.zhandos.unitconverter

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textview.MaterialTextView
import com.google.firebase.ml.common.modeldownload.FirebaseModelDownloadConditions
import com.google.firebase.ml.naturallanguage.FirebaseNaturalLanguage
import com.google.firebase.ml.naturallanguage.translate.FirebaseTranslateLanguage
import com.google.firebase.ml.naturallanguage.translate.FirebaseTranslatorOptions

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
private const val TAG = "TranslatorFragment"

private const val REQUEST_CHOOSE_CURRENT_LANG = "ChooseCurrentLanguage"
private const val REQUEST_CHOOSE_TARGET_LANG = "ChooseTargetLanguage"


class TranslatorFragment : Fragment() {
    private var languagesNameArray1 = arrayOf("")
    private var languagesNameArray2 = arrayOf("")
    private var sourceLangCode = -1
    private var targetLangCode = -1
    private var langList = arrayListOf<String>()
    private lateinit var currentLangSelectorButton: MaterialButton
    private lateinit var targetLangSelectorButton: MaterialButton
    private lateinit var sourceTextEditText: TextInputEditText
    private lateinit var switchLangButton: MaterialButton
    private lateinit var toTranslateButton: MaterialButton
    private lateinit var translatedTextTextView: MaterialTextView




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        FirebaseTranslateLanguage.getAllLanguages().forEach { langCode->
            langList = resources.getStringArray(R.array.languages_name_list).toCollection(ArrayList<String>())
        }

    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_translator, container, false)
        (requireActivity() as AppCompatActivity).supportActionBar?.title = getString(R.string.translator)



        currentLangSelectorButton = view.findViewById(R.id.currentLangButton)
        targetLangSelectorButton = view.findViewById(R.id.targetLangButton)
        sourceTextEditText = view.findViewById(R.id.sourceTextEditText)
        switchLangButton = view.findViewById(R.id.switchLangButton)
        toTranslateButton = view.findViewById(R.id.toTranslateButton)
        translatedTextTextView = view.findViewById(R.id.translatedTextTextView)



        currentLangSelectorButton.setOnClickListener {
            ChooseLanguageFragment.newInstance(sourceLangCode,langList, REQUEST_CHOOSE_CURRENT_LANG).apply {
                show(this@TranslatorFragment.childFragmentManager, REQUEST_CHOOSE_CURRENT_LANG)
            }
        }

        targetLangSelectorButton.setOnClickListener {
            ChooseLanguageFragment.newInstance(targetLangCode,langList, REQUEST_CHOOSE_TARGET_LANG).apply {
                show(this@TranslatorFragment.childFragmentManager, REQUEST_CHOOSE_TARGET_LANG)
            }
        }


        childFragmentManager.setFragmentResultListener(REQUEST_CHOOSE_CURRENT_LANG, this){ key, bundle ->
            var result = ChooseLanguageFragment.getResult(bundle)

            sourceLangCode = result
            setSelectorText()
        }
        childFragmentManager.setFragmentResultListener(REQUEST_CHOOSE_TARGET_LANG, this){ key, bundle ->
            var result = ChooseLanguageFragment.getResult(bundle)

            targetLangCode = result
            setSelectorText()
        }


        switchLangButton.setOnClickListener {
            if (sourceLangCode>-1 && targetLangCode>-1){
                val temp = sourceLangCode
                sourceLangCode = targetLangCode
                targetLangCode = temp

                setSelectorText()
            }

        }

        Log.d(TAG, "translateText: ${FirebaseTranslateLanguage.getAllLanguages().size}")
        toTranslateButton.setOnClickListener {
            if (sourceLangCode == -1){
                Toast.makeText(requireContext(), R.string.please_select_source_lang, Toast.LENGTH_SHORT).show()
            }
            else if (targetLangCode == -1){
                Toast.makeText(requireContext(), R.string.please_select_target_lang, Toast.LENGTH_SHORT).show()
            }
            else if (sourceTextEditText.text.toString().isNullOrEmpty()){
                Toast.makeText(requireContext(), R.string.please_enter_text, Toast.LENGTH_SHORT).show()
            }
            else{
                translateText()
            }
        }


        return view
    }

    private fun setSelectorText(){
        if (sourceLangCode>-1){
            currentLangSelectorButton.text = langList[sourceLangCode]
        }
        if (targetLangCode>-1){
            targetLangSelectorButton.text = langList[targetLangCode]
        }
    }

    private fun translateText(){
        val text = sourceTextEditText.text.toString()
        translatedTextTextView.setText(R.string.downloading_modal_progress)



        val options = FirebaseTranslatorOptions.Builder()
            .setSourceLanguage(getLanguageCode(sourceLangCode))
            .setTargetLanguage(getLanguageCode(targetLangCode))
            .build()

        val translator = FirebaseNaturalLanguage.getInstance().getTranslator(options)

        val conditions = FirebaseModelDownloadConditions.Builder().build()

        translator.downloadModelIfNeeded(conditions).addOnSuccessListener {
            translatedTextTextView.setText(R.string.translate_progress)
            translator.translate(text).addOnSuccessListener { translatedText ->
                translatedTextTextView.text = translatedText
            }
                .addOnFailureListener {
                    Toast.makeText(requireContext(),getString(R.string.fail_to_translate,it.message), Toast.LENGTH_SHORT).show()
                }
        }.addOnFailureListener {
            Toast.makeText(requireContext(),getString(R.string.fail_to_download_modal,it.message), Toast.LENGTH_SHORT).show()
        }
    }


    private fun getLanguageCode(pos:Int): Int{
        when(pos){
            0-> return FirebaseTranslateLanguage.AF
            1-> return FirebaseTranslateLanguage.SQ
            2-> return FirebaseTranslateLanguage.AR
            3-> return FirebaseTranslateLanguage.BE
            4-> return FirebaseTranslateLanguage.BN
            5-> return FirebaseTranslateLanguage.BG
            6-> return FirebaseTranslateLanguage.CA
            7-> return FirebaseTranslateLanguage.ZH
            8-> return FirebaseTranslateLanguage.HR
            9-> return FirebaseTranslateLanguage.CS
            10-> return FirebaseTranslateLanguage.DA
            11-> return FirebaseTranslateLanguage.NL
            12-> return FirebaseTranslateLanguage.EN
            13-> return FirebaseTranslateLanguage.EO
            14-> return FirebaseTranslateLanguage.ET
            15-> return FirebaseTranslateLanguage.FI
            16-> return FirebaseTranslateLanguage.FR
            17-> return FirebaseTranslateLanguage.GL
            18-> return FirebaseTranslateLanguage.KA
            19-> return FirebaseTranslateLanguage.DE
            20-> return FirebaseTranslateLanguage.EL
            21-> return FirebaseTranslateLanguage.GU
            22-> return FirebaseTranslateLanguage.HT
            23-> return FirebaseTranslateLanguage.HE
            24-> return FirebaseTranslateLanguage.HI
            25-> return FirebaseTranslateLanguage.HU
            26-> return FirebaseTranslateLanguage.IS
            27-> return FirebaseTranslateLanguage.ID
            28-> return FirebaseTranslateLanguage.GA
            29-> return FirebaseTranslateLanguage.IT
            30-> return FirebaseTranslateLanguage.JA
            31-> return FirebaseTranslateLanguage.KN
            32-> return FirebaseTranslateLanguage.KO
            33-> return FirebaseTranslateLanguage.LV
            34-> return FirebaseTranslateLanguage.LT
            35-> return FirebaseTranslateLanguage.MK
            36-> return FirebaseTranslateLanguage.MS
            37-> return FirebaseTranslateLanguage.MT
            38-> return FirebaseTranslateLanguage.MR
            39-> return FirebaseTranslateLanguage.NO
            40-> return FirebaseTranslateLanguage.FA
            41-> return FirebaseTranslateLanguage.PL
            42-> return FirebaseTranslateLanguage.PT
            43-> return FirebaseTranslateLanguage.RO
            44-> return FirebaseTranslateLanguage.RU
            45-> return FirebaseTranslateLanguage.SK
            46-> return FirebaseTranslateLanguage.SL
            47-> return FirebaseTranslateLanguage.ES
            48-> return FirebaseTranslateLanguage.SW
            49-> return FirebaseTranslateLanguage.SV
            50-> return FirebaseTranslateLanguage.TL
            51-> return FirebaseTranslateLanguage.TA
            52-> return FirebaseTranslateLanguage.TE
            53-> return FirebaseTranslateLanguage.TH
            54-> return FirebaseTranslateLanguage.TR
            55-> return FirebaseTranslateLanguage.UK
            56-> return FirebaseTranslateLanguage.UR
            57-> return FirebaseTranslateLanguage.VI
            58-> return FirebaseTranslateLanguage.CY
        }

        return -1
    }


    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            TranslatorFragment()
    }
}