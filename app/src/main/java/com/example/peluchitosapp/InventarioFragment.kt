package com.example.peluchitosapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_inventario.view.*

class InventarioFragment : Fragment(){

    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_inventario, container, false)

        var peluche = arguments?.getParcelableArrayList<Peluchito>(ARG_PARAM)!!

        recyclerView  = view.findViewById(R.id.recycler) as RecyclerView
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(view.context, RecyclerView.VERTICAL,false)

        val pelucheAdapter = PeluchitoAdapter(peluche,view.context)
        recyclerView.adapter = pelucheAdapter

        return view
    }

    companion object{
        private val ARG_PARAM = "MyObject"

        fun newInstance(peluchito: ArrayList<Peluchito>):InventarioFragment{
            val inventarioFragment = InventarioFragment()
            val args = Bundle()
            args.putParcelableArrayList(ARG_PARAM,peluchito)
            inventarioFragment.arguments = args
            return inventarioFragment
        }
    }
}