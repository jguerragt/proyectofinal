package com.example.tdgjsn

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.viewpager2.widget.ViewPager2
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.animation.ChartAnimator

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeF.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeF : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var iv1:ImageView;
    private lateinit var iv2:ImageView;
    private lateinit var iv3:ImageView;
    private lateinit var viewPager2: ViewPager2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)

        }



    }

    fun changeColor(){
        when (viewPager2.currentItem){
            0->{
                iv1.setBackgroundColor(requireContext().applicationContext.resources.getColor(R.color.active))
                iv2.setBackgroundColor(requireContext().applicationContext.resources.getColor(R.color.grey))
                iv3.setBackgroundColor(requireContext().applicationContext.resources.getColor(R.color.grey))
            }
            1->{
                iv1.setBackgroundColor(requireContext().applicationContext.resources.getColor(R.color.grey))
                iv2.setBackgroundColor(requireContext().applicationContext.resources.getColor(R.color.active))
                iv3.setBackgroundColor(requireContext().applicationContext.resources.getColor(R.color.grey))
            }
            2->{
                iv1.setBackgroundColor(requireContext().applicationContext.resources.getColor(R.color.grey))
                iv2.setBackgroundColor(requireContext().applicationContext.resources.getColor(R.color.grey))
                iv3.setBackgroundColor(requireContext().applicationContext.resources.getColor(R.color.active))
            }

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        var v = inflater.inflate(R.layout.fragment_home, container, false)

        viewPager2=v.findViewById(R.id.viewP)
        iv1 = v.findViewById(R.id.iv1)
        iv2 = v.findViewById(R.id.iv2)
        iv3 = v.findViewById(R.id.iv3)


        val images = listOf(R.drawable.destacado,R.drawable.gol,R.drawable.jugadorj)
        val adapter = ViewPagerAdapter(images)
        viewPager2.adapter=adapter

        viewPager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                changeColor()
                super.onPageScrolled(position, positionOffset, positionOffsetPixels)
            }

            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
            }

            override fun onPageScrollStateChanged(state: Int) {
                super.onPageScrollStateChanged(state)
                changeColor()
            }

        })


        return v

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HomeF.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeF().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}