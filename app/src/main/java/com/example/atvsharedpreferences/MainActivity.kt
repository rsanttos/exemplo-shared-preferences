package com.example.atvsharedpreferences

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        loadInformacoes()

        btnSalvar.setOnClickListener {
            val nome = edtNome.text
            val email = edtEmail.text
            val informacoes = getSharedPreferences(NOME_FILE, 0)
            val edit = informacoes.edit()
            edit.putString(KEY_NOME, nome.toString())
            edit.putString(KEY_EMAIL, email.toString())
            edit.commit()
        }

        btnCarregar.setOnClickListener {
            loadInformacoes()
        }
    }

    fun loadInformacoes(){
        val informacoes = getSharedPreferences(NOME_FILE, 0)
        if(informacoes.contains(KEY_NOME) && informacoes.contains(KEY_EMAIL)){
            var str = "${informacoes.getString(KEY_NOME, null)}\n${informacoes.getString(KEY_EMAIL, null)}"
            tvInfos.text = str
        }
    }

    companion object {
        val NOME_FILE = "informacoes"
        val KEY_NOME = "nome"
        val KEY_EMAIL = "email"
    }
}
