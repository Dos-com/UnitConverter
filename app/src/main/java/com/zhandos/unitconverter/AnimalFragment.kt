package com.zhandos.unitconverter

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textview.MaterialTextView
import kotlin.random.Random

class AnimalFragment: Fragment() {
    private lateinit var animalNameMaterialTextView: MaterialTextView
    private lateinit var animalTextInputEditText: TextInputEditText
    private lateinit var animalTranslateMaterialButton: MaterialButton
    private var animalName:String = ""


    private lateinit var animalSounds: AnimalSounds

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            animalName = it.getString("animalName").toString()
        }

        val animalsArray = resources.getStringArray(R.array.animals_array)
        animalSounds = AnimalSounds(requireActivity().assets, animalName,animalsArray)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.animal_fragment, container, false)


        animalNameMaterialTextView = view.findViewById(R.id.animalName)
        animalNameMaterialTextView.text = animalName


        animalTextInputEditText = view.findViewById(R.id.sourceTextEditText)
        animalTranslateMaterialButton = view.findViewById(R.id.toTranslateButton)





        animalTranslateMaterialButton.setOnClickListener {
            val text = animalTextInputEditText.text
            if (!text.isNullOrEmpty()){
                val soundsList = mutableListOf<Sound>()
                when {
                    text.length<10 -> {
                        animalSounds.sound.forEach {
                            val name = it.name.split("_")
                            if (name[1].equals("5")){
                                soundsList.add(it)
                            }
                        }
                    }
                    text.length<30 -> {
                        animalSounds.sound.forEach {
                            val name = it.name.split("_")
                            if (name[1].equals("10")){
                                soundsList.add(it)
                            }
                        }
                    }
                    text.length<60 -> {
                        animalSounds.sound.forEach {
                            val name = it.name.split("_")
                            if (name[1].equals("15")){
                                soundsList.add(it)
                            }
                        }


                    }
                    text.length<900 -> {
                        animalSounds.sound.forEach {
                            val name = it.name.split("_")
                            if (name[1].equals("20")){
                                soundsList.add(it)
                            }
                        }

                    }
                    text.length<120 -> {
                        animalSounds.sound.forEach {
                            val name = it.name.split("_")
                            if (name[1].equals("25")){
                                soundsList.add(it)
                            }
                        }

                    }
                    else -> {
                        animalSounds.sound.forEach {
                            val name = it.name.split("_")
                            if (name[1].equals("30")){
                                soundsList.add(it)
                            }
                        }

                    }
                }



                animalSounds.play(soundsList[Random.nextInt(0,soundsList.size)])
            }
            else{
                Toast.makeText(context,R.string.please_enter_text, Toast.LENGTH_SHORT).show()
            }
        }



        activity?.onBackPressedDispatcher?.addCallback(viewLifecycleOwner, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                Navigation.findNavController(view).navigate(R.id.action_animalFragment_to_animalTranslatorFragment2)
            }
        })

        return view
    }


    override fun onDestroy() {
        super.onDestroy()
        animalSounds.release()
    }



}