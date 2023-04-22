package com.example.blocodenotas2

import android.content.Context
import android.content.SharedPreferences

class PreferenciaAnotacoes(private val context: Context) {

    private val CHAVE = "nome"
    private val ARQUIVO = "anotacao.preferencias"
    private val preferences: SharedPreferences = context.getSharedPreferences(ARQUIVO, 0)
    private val editor: SharedPreferences.Editor = preferences.edit()

    fun salvarAnotacao(anotacao: String?) {
        editor.putString(CHAVE, anotacao)
        editor.commit()
    }

    fun recuperarAnotacao(): String? {
        return preferences.getString(CHAVE, "")
    }

}