package com.example.peluchitosapp

import android.os.Bundle
import android.widget.Toast
import com.google.android.material.tabs.TabLayout
import androidx.viewpager.widget.ViewPager
import androidx.appcompat.app.AppCompatActivity
import com.example.peluchitosapp.ui.main.SectionsPagerAdapter
import kotlinx.android.synthetic.main.fragment_agregar.*

class MainActivity : AppCompatActivity(),Comunicador{

    private lateinit var peluche : Peluchito
    var peluchito : ArrayList<Peluchito> = ArrayList()
    private lateinit var sectionsPagerAdapter: SectionsPagerAdapter

    override fun enviarDatos(id: String, nombre: String, cantidad: String, precio: String) {
        peluche = Peluchito(id,nombre,cantidad,precio)
        peluchito.add(peluche)
        sectionsPagerAdapter.getUserData(peluchito)
    }

    override fun enviarNombreEliminar(nombreEliminar: String) {
        for (i in peluchito) {
            if (i.nombre == nombreEliminar) {
                Toast.makeText(this, "Se ha eliminado el peluche '$nombreEliminar'", Toast.LENGTH_SHORT).show()
                peluchito.remove(i)
                break
            }else{
                Toast.makeText(this, "No hay peluche con ese nombre", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)
        val viewPager: ViewPager = findViewById(R.id.view_pager)
        viewPager.adapter = sectionsPagerAdapter
        val tabs: TabLayout = findViewById(R.id.tabs)
        tabs.setupWithViewPager(viewPager)
    }
}