package com.example.movies.ui
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movies.R
import kotlinx.android.synthetic.main.fragment_basic.view.*

class BasicFragment : Fragment() {

    companion object {
        const val FRAGMENT_TITLE = "fragment_title"
        const val FRAGMENT_IMAGE = "fragment_image"

        fun newInstance(titleFragment: String, images: ArrayList<String>) : BasicFragment {
            return BasicFragment().apply {
                val bundle = Bundle()
                bundle.putString(FRAGMENT_TITLE, titleFragment)
                bundle.putStringArrayList(FRAGMENT_IMAGE, images)
                arguments = bundle
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_basic, container, false)

        val titleFragment = arguments?.getString(FRAGMENT_TITLE)
        val images= arguments?.getStringArrayList(FRAGMENT_IMAGE) ?: ArrayList<String>()

        view.fragmentTitle.text = titleFragment

        val adapter = ItemListAdapter()
        adapter.items = images
        view.recyclerView.apply {
            this.adapter = adapter
            this.layoutManager = LinearLayoutManager(view.context, LinearLayoutManager.HORIZONTAL, false)
        }

        return view
    }


}