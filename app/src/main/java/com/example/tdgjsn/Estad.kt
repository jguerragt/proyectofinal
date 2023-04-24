package com.example.tdgjsn

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.*
import com.github.mikephil.charting.utils.ColorTemplate

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Estad.newInstance] factory method to
 * create an instance of this fragment.
 */
class Estad : Fragment() {
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
        // Inflate the layout for this fragment
        var v = inflater.inflate(R.layout.fragment_estad, container, false)
        val f1: BarChart
        val f2: PieChart
        f1 = v.findViewById(R.id.barChart)
        f2 = v.findViewById(R.id.pieChart)

        setBar(f1, f2)

        return v
    }

    fun setBar(f11:BarChart, f22:PieChart){

        val barList= ArrayList<BarEntry>()

        val barDataSet : BarDataSet
        val barData: BarData

        val pieChart = ArrayList<PieEntry>()
        val pieDataSet: PieDataSet
        val pieData: PieData

        barList.add(BarEntry(1f, 5f))
        barList.add(BarEntry(2f, 7f))
        barList.add(BarEntry(3f, 8f))



        pieChart.add(PieEntry(10f, "Grupo 1"))
        pieChart.add(PieEntry(10f,"Grupos 2"))
        pieChart.add(PieEntry(30f,"Grupo 3"))
        pieChart.add(PieEntry(15f,"Grupo 4"))
        pieChart.add(PieEntry(30f,"Grupo 5"))

        val xAxisLabel: ArrayList<String> = ArrayList()
        xAxisLabel.add("Sun")
        xAxisLabel.add("Mon")
        xAxisLabel.add("Tue")




        barDataSet = BarDataSet (barList,"PRUEBA")


        barData = BarData(barDataSet)

        f11.data = barData

        barDataSet.setColors (ColorTemplate.JOYFUL_COLORS, 250)
        f11.animateY(4000);
        barDataSet.valueTextColor = Color.BLACK
        barDataSet.valueTextSize = 15f

        pieDataSet = PieDataSet(pieChart, "% GOLES EN LIGA")
        pieData = PieData(pieDataSet)
        f22.data = pieData
        pieDataSet.setColors(ColorTemplate.COLORFUL_COLORS, 200)
        pieDataSet.valueTextColor = Color.BLACK
        f22.animateXY(2000, 2000)









    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Estad.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Estad().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}