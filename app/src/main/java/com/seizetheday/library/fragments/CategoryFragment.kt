package com.seizetheday.library.fragments

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.seizetheday.library.R
import com.seizetheday.library.adapters.CategoryAdapter
import com.seizetheday.library.data.models.CategoryModel
import com.seizetheday.library.delegates.CategoryDelegate
import com.seizetheday.library.events.CategoryDataEvent
import kotlinx.android.synthetic.main.fragment_category.*
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

class CategoryFragment : Fragment(), CategoryDelegate {

    private lateinit var mCategoryAdapter: CategoryAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_category, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //add recycler view into adapter
        rv_book_category.layoutManager = LinearLayoutManager(context)
        mCategoryAdapter = CategoryAdapter(this)
        rv_book_category.adapter = mCategoryAdapter

        srl_Category.isRefreshing = true
        CategoryModel.getInstance().loadCategory()

        srl_Category.setOnRefreshListener {
            CategoryModel.getInstance().loadCategory()
        }
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        EventBus.getDefault().register(this)
    }

    override fun onDetach() {
        super.onDetach()
        EventBus.getDefault().unregister(this)
    }

    //from delegate
    override fun onTapCategory() {
        Toast.makeText(context, "Tap", Toast.LENGTH_SHORT).show()
    }

    //success load category data
    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onLoadCategoryData(categoryEvent: CategoryDataEvent.SuccessGetCategoryEvent) {

        mCategoryAdapter.setCategoryData(categoryEvent.loadCategory!!)

        //swipe refresh layout
        srl_Category.isRefreshing = false
        //empty view
        category_empty_view.visibility = View.GONE
    }

    //failure category load data
    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onFailureLoadCategoryData(categoryEvent: CategoryDataEvent.EmptyDataLoadEvent) {

        srl_Category.isRefreshing = false

        //empty view
        tv_category_error_message.text = categoryEvent.errorMsg
        category_empty_view.visibility = View.VISIBLE
    }

}