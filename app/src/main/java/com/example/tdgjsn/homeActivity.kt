package com.example.tdgjsn

import android.content.res.Configuration
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.navigation.NavigationView
import kotlin.system.exitProcess

class homeActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var drawer: DrawerLayout
    private lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)


        val toolbar: Toolbar = findViewById(R.id.toolbar_main)
        setSupportActionBar(toolbar)

        drawer = findViewById(R.id.drawer_layout)

        toggle = ActionBarDrawerToggle(
            this, drawer, toolbar, R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        drawer.addDrawerListener(toggle)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)

        val navigationView: NavigationView = findViewById(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener(this)

        /*val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frameLayout,HomeF())
        fragmentTransaction.commit()
        drawer.closeDrawer(GravityCompat.START)
        setTitle(title)*/

        supportFragmentManager.beginTransaction().replace(R.id.frame_layout, HomeF())
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).commit()
    }



    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        item.isChecked = true
        when(item.itemId){

            /*supportFragmentManager.beginTransaction().replace(androidx.fragment.R.id.fragment_container_view_tag, Calendar()).commit()*/
            R.id.nav_item_one -> supportFragmentManager.beginTransaction().replace(R.id.frame_layout, HomeF())
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).commit()
            R.id.nav_item_two -> supportFragmentManager.beginTransaction().replace(R.id.frame_layout, Calendar())
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).commit()
            R.id.nav_item_three -> supportFragmentManager.beginTransaction().replace(R.id.frame_layout, GruposF())
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).commit()
            R.id.nav_item_four -> supportFragmentManager.beginTransaction().replace(R.id.frame_layout, TabGeneral())
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).commit()
            R.id.nav_item_five -> supportFragmentManager.beginTransaction().replace(R.id.frame_layout, HistorialCampeon())
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).commit()
            R.id.nav_item_six -> supportFragmentManager.beginTransaction().replace(R.id.frame_layout, Estad())
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).commit()
           /* R.id.nav_item_seven -> supportFragmentManager.beginTransaction().replace(R.id.frame_layout, CompartirF())
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).commit()*/
            R.id.nav_item_eight -> supportFragmentManager.beginTransaction().replace(R.id.frame_layout, SalirF())
                .setTransition(exitProcess(0)).commit()
            /*
            R.id.nav_item_two -> replaceFragment(Calendar(),item.title.toString())
            R.id.nav_item_one -> Toast.makeText(this, "INICIO", Toast.LENGTH_SHORT).show()
            R.id.nav_item_two -> Toast.makeText(this, "CALENDARIO", Toast.LENGTH_SHORT).show()
            R.id.nav_item_three -> Toast.makeText(this, "GRUPOS", Toast.LENGTH_SHORT).show()
            R.id.nav_item_four -> Toast.makeText(this, "TABLA GENERAL", Toast.LENGTH_SHORT).show()
            R.id.nav_item_five -> Toast.makeText(this, "HISTORIAL DE CAMPEONATOS", Toast.LENGTH_SHORT).show()
            R.id.nav_item_six -> Toast.makeText(this, "REGLAMENTO", Toast.LENGTH_SHORT).show()
            R.id.nav_item_seven -> Toast.makeText(this, "COMPARTIR", Toast.LENGTH_SHORT).show()
            R.id.nav_item_eight -> Toast.makeText(this, "SALIR", Toast.LENGTH_SHORT).show()*/

        }

        drawer.closeDrawer(GravityCompat.START)
        return true

    }



    private fun replaceFragment(fragment: Fragment, title : String){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frameLayout,fragment)
        fragmentTransaction.commit()
        drawer.closeDrawer(GravityCompat.START)
        setTitle(title)

    }


    override fun onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START)
        }else{
            super.onBackPressed()
        }



    }


    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        toggle.syncState()
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        toggle.onConfigurationChanged(newConfig)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (toggle.onOptionsItemSelected(item)){
            return true
        }


        return super.onOptionsItemSelected(item)
    }
}