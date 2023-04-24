package com.example.tdgjsn

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

private lateinit var adapter : TgAd
private lateinit var recycleView : RecyclerView
private lateinit var imagesArrayList : ArrayList<TablaGeneral>
private lateinit var db: FirebaseFirestore

/**
 * A simple [Fragment] subclass.
 * Use the [TabGeneral.newInstance] factory method to
 * create an instance of this fragment.
 */
class TabGeneral : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

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
        var v = inflater.inflate(R.layout.fragment_tab_general, container, false)



        val layoutManager = LinearLayoutManager(context)
        recycleView = v.findViewById(R.id.recTg)
        recycleView.layoutManager = layoutManager

        recycleView.setHasFixedSize(true)

        imagesArrayList = arrayListOf()
        adapter =  TgAd(context, imagesArrayList)
        recycleView.adapter = adapter
        eventChangeListener()

        return v
    }

    private fun eventChangeListener() {
        db = FirebaseFirestore.getInstance()
        db.collection("Tgen").addSnapshotListener(object : EventListener<QuerySnapshot> {
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
                        imagesArrayList.add(dc.document.toObject(TablaGeneral::class.java))

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
         * @return A new instance of fragment TabGeneral.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            TabGeneral().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}