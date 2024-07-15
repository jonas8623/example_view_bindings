package com.example.aulaviewbindings

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.view.MenuProvider
import com.example.aulaviewbindings.databinding.ActivityToolbarActionbarBinding

class ToolbarActionbarActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityToolbarActionbarBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initToolbar()
//        supportActionBar?.hide()

//        initMenu()
    }

    private fun initToolbar() {
        binding.newActivity.setOnClickListener {
            startActivity(Intent(this, FormularioActivity::class.java))
        }
        binding.includeToolbar.materialToolbarMain.title = "YouTube"
        binding.includeToolbar.materialToolbarMain.setTitleTextColor(ContextCompat.getColor(this, R.color.white))
        binding.includeToolbar.materialToolbarMain.subtitle = "Detalhes"
        binding.includeToolbar.materialToolbarMain.inflateMenu(R.menu.menu_pricipal)
        binding.includeToolbar.materialToolbarMain.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.item_adicionar -> {
                    showToastMessage(message = "Adicionado")
                    true
                }
                R.id.item_configuracao -> {
                    showToastMessage(message = "Configurado")
                    true
                }
                R.id.item_pesquisar -> {
                    showToastMessage(message = "Pesquisar")
                    true
                }
                R.id.item_sair -> {
                    showToastMessage(message = "Sair")
                    true
                }
                else -> {
                    true
                }
            }
        }
//        setSupportActionBar(binding.materialToolbarMain)
    }

    private fun initMenu() {
        addMenuProvider(
            object : MenuProvider {
                override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                    menuInflater.inflate(R.menu.menu_pricipal, menu)
                }

                override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                    when (menuItem.itemId) {
                        R.id.item_adicionar -> showToastMessage(message = "Adicionado")
                        R.id.item_configuracao -> showToastMessage(message = "Configurado")
                        R.id.item_pesquisar -> showToastMessage(message = "Pesquisar")
                        R.id.item_sair -> showToastMessage(message = "Sair")
                    }
                    return true
                }
            }
        )
    }

//    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//        menuInflater.inflate(R.menu.menu_pricipal, menu)
//        return true
//    }
//
//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        when (item.itemId) {
//            R.id.item_adicionar -> showToastMessage(message = "Adicionado")
//            R.id.item_configuracao -> showToastMessage(message = "Configurado")
//            R.id.item_pesquisar -> showToastMessage(message = "Pesquisar")
//            R.id.item_sair -> showToastMessage(message = "Sair")
//        }
//        return true
//    }

    private fun showToastMessage(message: String) =
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
}