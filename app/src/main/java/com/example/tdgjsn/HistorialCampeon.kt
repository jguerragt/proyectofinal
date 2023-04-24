package com.example.tdgjsn

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.*
import com.google.firebase.firestore.model.DatabaseId
import javax.annotation.Nullable


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"





class HistorialCampeon : Fragment() {



    private var param1: String? = null
    private var param2: String? = null


    private lateinit var adapter : MyAdapter
    private lateinit var recycleView : RecyclerView
    private lateinit var champArrayList : ArrayList<Champs>
    lateinit var db : FirebaseFirestore




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
        var v = inflater.inflate(R.layout.fragment_historial_campeon, container, false)

        val layoutManager = LinearLayoutManager(context)
        recycleView = v.findViewById(R.id.recyclerView)
        recycleView.layoutManager = layoutManager

        recycleView.setHasFixedSize(true)

        champArrayList = arrayListOf()
        adapter = MyAdapter(context, champArrayList)
        recycleView.adapter = adapter
        eventChangeListener()

        return v
    }

    private fun eventChangeListener() {
        db = FirebaseFirestore.getInstance()
        db.collection("Champs").
                addSnapshotListener(object : EventListener<QuerySnapshot>{
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
                                champArrayList.add(dc.document.toObject(Champs::class.java))

                            }
                        }

                        adapter.notifyDataSetChanged()
                    }
                })







    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HistorialCampeon.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HistorialCampeon().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}