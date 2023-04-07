package com.awesomenews.checkus.data


import android.util.Log
import com.awesomenews.checkus.models.InfoModel
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase


class GettingData {
    init {
        useDataBase()
    }

    private fun useDataBase() {
        val db = Firebase.firestore
        val useDatabase = db.collection("1")

        useDatabase.get().addOnSuccessListener {
//            val infoModel = it.documents.map {
//                val image = it.getString("image")?:""
//                val date_added = it.getString("date_added")?:""
//                val title = it.getString("title")?:""
//                val text = it.getString("text")?:""
//                InfoModel(image, date_added, title, text)
//            }

            if (it != null) {
                Log.e("COP", "DocumentSnapshot data: ${it.documents}")
            } else {
                Log.e("COP", "No such document")
            }
        }
            .addOnFailureListener {
                Log.e("COP", "get failed with", it)
            }
    }
}

