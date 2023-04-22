package com.example.blocodenotas2

import android.Manifest
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.core.app.ActivityCompat
import com.example.blocodenotas2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val preferencias = PreferenciaAnotacoes(applicationContext)
        val botaoAcao = binding.fab

        botaoAcao.setOnClickListener {

            val anotacao = binding.editContainer.editAnotacoes.text.toString()

            if(anotacao == "") {
                Toast.makeText(this, "Digite alguma coisa...", Toast.LENGTH_SHORT).show()

            }else {
                preferencias.salvarAnotacao(anotacao)
                Toast.makeText(this, "Anotação salva com sucesso!", Toast.LENGTH_SHORT).show()

            }

        }

        val anotacaoRecuperado = preferencias.recuperarAnotacao()

        if (anotacaoRecuperado != "") {
            binding.editContainer.editAnotacoes.setText(anotacaoRecuperado)
        }
    }

}