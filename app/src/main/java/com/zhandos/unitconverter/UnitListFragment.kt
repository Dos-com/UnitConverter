package com.zhandos.unitconverter

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class UnitListFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private var callbacks: Callbacks? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_unit_list, container, false)

        recyclerView = view.findViewById(R.id.recycler_view)

        recyclerView.layoutManager = GridLayoutManager(context,2)
        recyclerView.adapter = UnitListAdapter()

        return view
    }

    companion object {
        val unitList = listOf("Distance","Weight","Time","Temperature","Currency", "Number systems BIN/OCT/DEC/HEX")
        fun newInstance() = UnitListFragment()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        callbacks = context as Callbacks?
    }

    override fun onDetach() {
        super.onDetach()
        callbacks = null
    }



    private inner class UnitListHolder(view: View) : RecyclerView.ViewHolder(view), View.OnClickListener{
        private val unitButton: Button = itemView.findViewById(R.id.unit_button)
        private var title = ""

        fun bind(title: String){
            unitButton.text = title
            unitButton.setOnClickListener(this)

            this.title = title
        }

        override fun onClick(v: View?) {
            Log.d("TAG", "onClick: ")
            if (title.isNotBlank()){
                Log.d("TAG", "onUnitSelected: ")
                callbacks?.onUnitSelected(title)
            }
        }
    }

    private inner class UnitListAdapter(): RecyclerView.Adapter<UnitListHolder>(){
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UnitListHolder {
            val view = layoutInflater.inflate(R.layout.unit_list_holder,parent,false)


            return UnitListHolder(view)
        }

        override fun onBindViewHolder(holder: UnitListHolder, position: Int) {
            holder.bind(unitList[position])
        }

        override fun getItemCount(): Int = unitList.size

    }


    interface Callbacks{
        fun onUnitSelected(unit: String)
    }
}