package com.awesomenews.checkus.data


import android.util.Log
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase


object GettingData {
    //    82gD6xxvPgPDifhDK3Uy   work
    init {
        Log.e("COP", "init" )
        initDataBase()
//        save()
    }

//    fun save(){
//        val db = Firebase.firestore
//        db.collection("test").add("test").addOnSuccessListener {
//
//        }
//
//    }    }

    fun initDataBase() {
        val dataBase =
            Firebase.firestore.collection("types")
        dataBase.get().addOnSuccessListener {
            for (news in it ) {
                Log.d("COP", "DocumentSnapshot data: ${it}")
            }
        }
    }
}


//    val newsModelListener = object : ValueEventListener{
//        override fun onDataChange(snapshot: DataSnapshot) {
//            val newsModel = snapshot.getValue<CategoryNewsModel>()
//        }
//
//        override fun onCancelled(error: DatabaseError) {
//            Log.w("COP", "loadCategoryNewsModel", error.toException() )
//        }
//
//    }


//    fun getData() {
//        dataBase = FirebaseFirestore.getInstance()
//        dataBase.collection("news")
//            .addSnapshotListener(object : EventListener<QuerySnapshot> {
//                @SuppressLint("NotifyDataSetChanged")
//                override fun onEvent(value: QuerySnapshot?, error: FirebaseFirestoreException?) {
//                    if (error != null) {
//                        Log.e("COP", error.message.toString())
//                        return
//                    }
//                    for (dc: DocumentChange in value?.documentChanges!!) {
//                        if (dc.type == DocumentChange.Type.ADDED) {
//                            categoryNewsModel.add(dc.document.toObject(CategoryNewsModel::class.java))
//                        }
//                    }
//                }
//            })
//    }
