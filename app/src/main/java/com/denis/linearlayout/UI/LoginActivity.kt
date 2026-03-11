package com.denis.linearlayout.UI


import android.content.Intent
import android.os.Bundle
import android.view.View

import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.denis.linearlayout.Utils.AppConstants
import com.denis.linearlayout.R
import com.denis.linearlayout.Business.UserBusiness
import com.denis.linearlayout.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity(), View.OnClickListener {


    //Cria uma classe para fazer o binding
    private lateinit var binding: ActivityLoginBinding
    private val userBusiness = UserBusiness()

    // Ela vai a ligação da LoginActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        //Instanciar
        binding = ActivityLoginBinding.inflate(layoutInflater)

        setContentView(binding.root)

        // Identificamos dos elementos

        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left + binding.main.paddingStart,
                systemBars.top,
                systemBars.right + binding.main.paddingEnd,
                systemBars.bottom)
            insets
        }

        // binding.edittextEmail.text.toString()
        // binding.edittextPassword.text.toString()

        //Listen
        binding.buttonLogin.setOnClickListener(this)
        binding.buttonCadastro.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        if (v.id == R.id.button_login){
            val email = binding.edittextEmail.text.toString()
            val password = binding.edittextPassword.text.toString()
            //validação de dados
            /*
            evento e conceito ou conceito generico de um evento e como atribuir um evento para nosso login
            vimos maneiras diferente de responder e saber a diferença sobre elas
             */

            if (userBusiness.checkCredentials(email, password)) {
                //Logica de validação)

                val bundle = Bundle()
                bundle.putString(AppConstants.Companion.EMAIL_KEY, email)
                bundle.putString("password", password)

                val intent = Intent(this, HomeActivity::class.java)

                intent.putExtras(bundle)
                startActivity(intent)

            }else {
                // optional context applicationContext
                Toast.makeText(this, "Informe os dados!", Toast.LENGTH_SHORT).show()
                //Toast.makeText(this, R.string.data_validation, Toast.LENGTH_SHORT).show()
               // val str: String = getString(R.string.data_validation)
            }
        } else if (v.id == R.id.button_cadastro){
            //trato o cadastro

        }
    }


}