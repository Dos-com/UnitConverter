package com.zhandos.unitconverter

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AccelerateInterpolator
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [AnimalTranslatorFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AnimalTranslatorFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var animalRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_animal_translator, container, false)
        (requireActivity() as AppCompatActivity).supportActionBar?.title = getString(R.string.animals_translator)


        animalRecyclerView = view.findViewById(R.id.animalTranslatorRecyclerView)
        animalRecyclerView.layoutManager = GridLayoutManager(context, 2)

        val animalArray = resources.getStringArray(R.array.animals_array)
        animalRecyclerView.adapter = AnimalTranslatorAdapter(animalArray)


        return view
    }


    private inner class AnimalTranslatorHolder(view: View) : RecyclerView.ViewHolder(view){
        private val animalShapeableImageView: ShapeableImageView =itemView.findViewById(R.id.animalListItem)
        private var animalName:String = ""

        init {
            animalShapeableImageView.setOnClickListener {
                startEffect()

                val bundle = bundleOf("animalName" to animalName)

                getView()?.let { it1 -> Navigation.findNavController(it1).navigate(R.id.action_animalTranslatorFragment_to_animalFragment, bundle) }

            }
        }

        fun bind(src:Int, animalName:String){
            this.animalName = animalName
            animalShapeableImageView.setImageResource(src)
        }
        private fun startEffect(){
            val yStart = animalShapeableImageView.top.toFloat()
            val yEnd = animalShapeableImageView.top.toFloat() + 20


            val heightStartAnimator =ObjectAnimator.ofFloat(animalShapeableImageView , "y", yStart, yEnd).setDuration(100)
            val heightEndAnimator =ObjectAnimator.ofFloat(animalShapeableImageView , "y", yEnd, yStart).setDuration(100)

            heightStartAnimator.interpolator = AccelerateInterpolator()
            heightEndAnimator.interpolator = AccelerateInterpolator()
            val animatorSet =AnimatorSet()

            animatorSet.play(heightStartAnimator)
                .after(heightEndAnimator)

            animatorSet.start()
        }
    }

    private inner class AnimalTranslatorAdapter(private val animalList: Array<String>) : RecyclerView.Adapter<AnimalTranslatorHolder>(){
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimalTranslatorHolder {
            val view =layoutInflater.inflate(R.layout.animal_list_item_view, parent, false)

            return AnimalTranslatorHolder(view)
        }

        override fun onBindViewHolder(holder: AnimalTranslatorHolder, position: Int) {
            when(position){
                0 -> holder.bind(R.drawable.accentor, animalList[0])
                1 -> holder.bind(R.drawable.bear, animalList[1])
                2 -> holder.bind(R.drawable.blackbird, animalList[2])
                3 -> holder.bind(R.drawable.cat, animalList[3])
                4 -> holder.bind(R.drawable.chicken, animalList[4])
                5 -> holder.bind(R.drawable.cobra, animalList[5])
                6 -> holder.bind(R.drawable.cow, animalList[6])
                7 -> holder.bind(R.drawable.crocodile, animalList[7])
                8 -> holder.bind(R.drawable.crow, animalList[8])
                9 -> holder.bind(R.drawable.dog, animalList[9])
                10 -> holder.bind(R.drawable.dolphin, animalList[10])
                11 -> holder.bind(R.drawable.elephant, animalList[11])
                12 -> holder.bind(R.drawable.frog, animalList[12])
                13 -> holder.bind(R.drawable.horse, animalList[13])
                14 -> holder.bind(R.drawable.lion, animalList[14])
                15 -> holder.bind(R.drawable.monkey, animalList[15])
                16 -> holder.bind(R.drawable.owl, animalList[16])
                17 -> holder.bind(R.drawable.pig, animalList[17])
                18 -> holder.bind(R.drawable.sheep, animalList[18])
                19 -> holder.bind(R.drawable.sparrow, animalList[19])
                20 -> holder.bind(R.drawable.tiger, animalList[20])
            }
        }

        override fun getItemCount() = animalList.size

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment AnimalTranslatorFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            AnimalTranslatorFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}