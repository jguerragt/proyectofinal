package com.example.tdgjsn

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.google.firebase.database.*
import com.google.firebase.firestore.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


/**
 * A simple [Fragment] subclass.
 * Use the [GruposF.newInstance] factory method to
 * create an instance of this fragment.
 */
class GruposF : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var recyclerView: RecyclerView
    private lateinit var databaseReference: DatabaseReference


    private lateinit var adapter : ImageAd
    private lateinit var recycleView : RecyclerView
    private lateinit var imagesArrayList : ArrayList<Grupos>



    private lateinit var db: FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }








    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var v = inflater.inflate(R.layout.fragment_grupos, container, false)



        val layoutManager = LinearLayoutManager(context)
        recycleView = v.findViewById(R.id.recGp)
        recycleView.layoutManager = layoutManager

        recycleView.setHasFixedSize(true)

        imagesArrayList = arrayListOf()
        adapter =  ImageAd(context, imagesArrayList)
        recycleView.adapter = adapter
        eventChangeListener()

        return v
    }

    private fun eventChangeListener() {
        db = FirebaseFirestore.getInstance()
        db.collection("Grupos").addSnapshotListener(object : EventListener<QuerySnapshot> {
            override fun onEvent(
                value: QuerySnapshot?,
                error: FirebaseFirestoreException?
            ) {
                if(error != null){
                    Log.e("ERRORRRR", error.message.toString())
                    return
                }
                for (dc : DocumentChange in value?.documentChanges!!){
                    if(dc.type == DocumentChange.Type.ADDED){
                        imagesArrayList.add(dc.document.toObject(Grupos::class.java))

                    }
                }

                adapter.notifyDataSetChanged()
            }
        })



/*
        recyclerView = v.findViewById(R.id.recimg)
        recyclerView.layoutManager = LinearLayoutManager(context)
        listImages = arrayListOf()
        databaseReference = FirebaseFirestore.getInstance().collection("Grupos").get()
        databaseReference.addValueEventListener(object : ValueEventListener{

            override fun onDataChange (snapshot:DataSnapshot){
                if(snapshot.exists()){
                    for (dataSnapshot in snapshot.children){
                        val list = dataSnapshot.getValue(ImageDataClass::class.java)
                        listImages.add(list!!)
                    }
                    recyclerView.adapter =ImageAdapter(listImages, this@GruposF)
                }
            }

            override fun onCancelled(error: DatabaseError) {


            }

        })
*/



    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment GruposF.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            GruposF().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}