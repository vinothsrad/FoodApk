package com.example.swiggyapp.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.swiggyapp.ApiInterface
import com.example.swiggyapp.R
import com.example.swiggyapp.adapter.MyAdapter
import com.example.swiggyapp.response.productResponseItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.collections.ArrayList

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var searchView: SearchView
    private var userList= ArrayList<productResponseItem>()
    lateinit var rvMain: RecyclerView
    lateinit var myAdapter: MyAdapter
    var BASE_URL= "https://api.npoint.io/"

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
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HomeFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        rvMain=view.findViewById(R.id.recycler_view)
        rvMain.layoutManager= LinearLayoutManager(context)
        searchView = view.findViewById(R.id.searchView)
        rvMain.setHasFixedSize(true)
        myAdapter= MyAdapter(requireContext(),userList)
        rvMain.adapter = myAdapter
        getAllData()




    }


    private fun getAllData() {
        var retrofit= Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiInterface::class.java)

        var retroData= retrofit.getDate()
        retroData.enqueue(object: Callback<List<productResponseItem>> {
            override fun onResponse(
                call: Call<List<productResponseItem>>,
                response: Response<List<productResponseItem>>
            ) {
                var data=response.body()!!
                myAdapter= MyAdapter(context!!,data)
                rvMain.adapter=myAdapter

                Log.d("data",data.toString())
            }

            override fun onFailure(call: Call<List<productResponseItem>>, t: Throwable) {

            }
        })
    }



}



