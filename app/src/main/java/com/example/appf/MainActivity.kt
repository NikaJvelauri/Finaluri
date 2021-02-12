package com.example.appf

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthRecentLoginRequiredException
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase


class MainActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var Firestore: FirebaseFirestore
    private lateinit var rcNotes: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        auth = FirebaseAuth.getInstance()
        rcNotes = findViewById(R.id.RVnote)

        //val store = Firebase.firestore
        //val notesCollectionQuery = store.collection("Notes")
        //val options = FirestoreRecyclerOptions.Builder<Notes>().setLifecycleOwner(this).setQuery(notesCollectionQuery, Notes::class.java).build()
        //val adapter = FirestoreRecyclerOptions<>
        //rcNotes.adapter = adapter
        //rcNotes.layoutManager = LinearLayoutManager(this)








    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.note_menu, menu)
        return true
        //return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.Bbutton){
            auth.signOut()
            val intent = Intent(this, RegisterActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
            finish()
        }
        return super.onOptionsItemSelected(item)
    }
}


//ნიკა ჯველაური
//დემეტრე კახაბრიშვილი