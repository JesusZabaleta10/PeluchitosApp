package com.example.peluchitosapp.ui.main

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.peluchitosapp.*

private val TAB_TITLES = arrayOf(
    R.string.tab_text_1,
    R.string.tab_text_2,
    R.string.tab_text_3,
    R.string.tab_text_4
)


class SectionsPagerAdapter(private val context: Context, fm: FragmentManager) : FragmentPagerAdapter(fm) {

    fun getUserData(peluchito: ArrayList<Peluchito>){
        this.peluchito = peluchito
    }

    private var peluchito: ArrayList<Peluchito> = ArrayList()

    override fun getItem(position: Int): Fragment {
        when (position){
            0-> return AgregarFragment()
            1-> return BuscarFragment.newInstance(peluchito)
            2-> return EliminarFragment()
            else -> return InventarioFragment.newInstance(peluchito)
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return context.resources.getString(TAB_TITLES[position])
    }

    override fun getCount(): Int {
        return 4
    }
}