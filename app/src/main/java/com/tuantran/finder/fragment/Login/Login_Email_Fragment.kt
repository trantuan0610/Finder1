package com.tuantran.finder.fragment.Login

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.tuantran.finder.MainActivity
import com.tuantran.finder.R
import kotlinx.android.synthetic.main.fragment_login_email.*


class Login_Email_Fragment : Fragment() {

    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment

            firebaseAuth = FirebaseAuth.getInstance()
            if(firebaseAuth.currentUser !=null){
            val intent = Intent(this@Login_Email_Fragment.requireContext(),MainActivity::class.java)
            startActivity(intent)
        }

        return inflater.inflate(R.layout.fragment_login_email, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mLogin.setOnClickListener {
            val email = edtEmail.text.toString()
            val pass = edtPass.text.toString()

            if (email.isNotEmpty() && pass.isNotEmpty() ) {


                            firebaseAuth.signInWithEmailAndPassword(email, pass).addOnCompleteListener {
                                if (it.isSuccessful) {
                                    val intent = Intent(
                                        this@Login_Email_Fragment.requireContext(),
                                        MainActivity::class.java
                                    )
                                    startActivity(intent)
                                } else {
                                    firebaseAuth.createUserWithEmailAndPassword(email, pass)
                                        .addOnCompleteListener {
                                            if (it.isSuccessful) {

                                                val intent = Intent(this.requireContext(), MainActivity::class.java)
                                                startActivity(intent)
                                            } else {
                                                Toast.makeText(
                                                    this.requireContext(),
                                                    it.exception.toString(),
                                                    Toast.LENGTH_SHORT
                                                )
                                                    .show()
                                            }
                                        }
                                }
                            }
                        }
                    }




            }
}





//            if (email.isNotEmpty() && pass.isNotEmpty() ) {
//                firebaseAuth.signInWithEmailAndPassword(email, pass).addOnCompleteListener {
//                    if (it.isSuccessful) {
//                        val intent = Intent(
//                            this@Login_Email_Fragment.requireContext(),
//                            MainActivity::class.java
//                        )
//                        startActivity(intent)
//                    } else {
//                        Toast.makeText(
//                            this.requireContext(),
//                            it.exception.toString(),
//                            Toast.LENGTH_SHORT
//                        ).show()
//                    }
//                }
//            } else {
//                firebaseAuth.createUserWithEmailAndPassword(email, pass)
//                    .addOnCompleteListener {
//                        if (it.isSuccessful) {
//
//                            val intent = Intent(this.requireContext(), MainActivity::class.java)
//                            startActivity(intent)
//                        } else {
//                            Toast.makeText(
//                                this.requireContext(),
//                                it.exception.toString(),
//                                Toast.LENGTH_SHORT
//                            )
//                                .show()
//                        }
//                    }
//            }


