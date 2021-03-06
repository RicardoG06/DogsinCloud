package com.example.dogscloud.activities.client.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.dogscloud.R

import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.example.dogscloud.activities.Fragments.cerrarsesion.CerrarSesionFragment
import com.example.dogscloud.activities.Fragments.contactanos.ContactanosFragment
import com.example.dogscloud.activities.Fragments.eliminarcuenta.EliminarCuentaFragment
import com.example.dogscloud.activities.Fragments.mascotas.MisMascotasFragment
import com.example.dogscloud.activities.Fragments.menu.InicioFragment
import com.example.dogscloud.activities.Fragments.mispedidos.MisPedidosFragment
import com.example.dogscloud.activities.Fragments.misservicios.MisServiciosFragment
import com.example.dogscloud.activities.Fragments.seunpaseador.PaseadorFragment
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var toogle: ActionBarDrawerToggle
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navView: NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        drawerLayout = findViewById(R.id.drawerLayout)
        navView = findViewById(R.id.navView)

        toogle = ActionBarDrawerToggle(this, drawerLayout, R.string.open_drawer, R.string.close_drawer)
        drawerLayout.addDrawerListener(toogle)
        toogle.syncState()

        supportActionBar?.title = "Dog's in Cloud"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        navView.setNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.nav_inicio -> {
                    supportFragmentManager.beginTransaction().apply {
                        replace(R.id.fragmentContainerView, InicioFragment())
                        commit()
                    }
                }
                R.id.nav_mis_mascotas -> {
                    supportFragmentManager.beginTransaction().apply {
                        replace(R.id.fragmentContainerView, MisMascotasFragment())
                        commit()
                    }
                }
                R.id.nav_mis_pedidos -> {
                    supportFragmentManager.beginTransaction().apply {
                        replace(R.id.fragmentContainerView, MisPedidosFragment())
                        commit()
                    }
                }
                R.id.nav_mis_servicios -> {
                    supportFragmentManager.beginTransaction().apply {
                        replace(R.id.fragmentContainerView, MisServiciosFragment())
                        commit()
                    }
                }
                R.id.nav_paseador -> {
                    supportFragmentManager.beginTransaction().apply {
                        replace(R.id.fragmentContainerView, PaseadorFragment())
                        commit()
                    }
                }
                R.id.nav_contactanos -> {
                    supportFragmentManager.beginTransaction().apply {
                        replace(R.id.fragmentContainerView, ContactanosFragment())
                        commit()
                    }
                }
                R.id.nav_eliminar_cuenta -> {
                    supportFragmentManager.beginTransaction().apply {
                        replace(R.id.fragmentContainerView, EliminarCuentaFragment())
                        commit()
                    }
                }
                R.id.nav_cerrar_sesion -> {
                    supportFragmentManager.beginTransaction().apply {
                        replace(R.id.fragmentContainerView, CerrarSesionFragment())
                        commit()
                    }
                }
            }
            drawerLayout.closeDrawer(GravityCompat.START)

            true
        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toogle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}