package com.seizetheday.library.fragments

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.seizetheday.library.R
import com.seizetheday.library.activities.BookDetailActivity
import com.seizetheday.library.activities.LoginActivity
import com.seizetheday.library.adapters.BookAdapter
import com.seizetheday.library.data.models.BookModel
import com.seizetheday.library.data.models.PrimaryBookModel
import com.seizetheday.library.data.vos.BookVO
import com.seizetheday.library.data.vos.PrimaryBookVO
import com.seizetheday.library.delegates.PrimaryBookDelegate
import com.seizetheday.library.delegates.SecondaryBookDelegate
import com.seizetheday.library.events.BookDataEvent
import com.seizetheday.library.events.PrimaryBookDataEvent
import kotlinx.android.synthetic.main.fragment_home.*
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

class HomeFragment : Fragment(), PrimaryBookDelegate, SecondaryBookDelegate {

    private lateinit var adapter: BookAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rv_book_list.layoutManager = LinearLayoutManager(context)
        adapter = BookAdapter(this, this)
        rv_book_list.adapter = adapter

        srlHome.isRefreshing = true
        //load Secondary Books
        BookModel.getObjInstance().loadBooks()
        //load Primary Books
        PrimaryBookModel.getObjInstance().loadPrimaryBook()

        srlHome.setOnRefreshListener {
            BookModel.getObjInstance().loadBooks()
            PrimaryBookModel.getObjInstance().loadPrimaryBook()
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

    //from primary delegate
    //book cover image
    override fun onTapPrimaryBookImage(book: PrimaryBookVO) {
        Toast.makeText(context, "Click Image", Toast.LENGTH_SHORT).show()
    }

    //book mark
    override fun onTapPrimaryBookMark(book: PrimaryBookVO) {
        Toast.makeText(context, "Click Book Mark", Toast.LENGTH_SHORT).show()
    }

    //book download
    override fun onTapPrimaryBookDownload(book: PrimaryBookVO) {
        startActivity(Intent(context, LoginActivity::class.java))
    }

    //share button
    override fun onTapPrimaryBookShare(book: PrimaryBookVO) {
        startActivity(Intent().apply {
            action = Intent.ACTION_SEND
            type = "text/plain"
            putExtra(Intent.EXTRA_TEXT, "Component link will be here.")
        })
    }

    //whole book item
    override fun onTapPrimaryBook(book: PrimaryBookVO) {

        val intent = Intent(context, BookDetailActivity::class.java)
        intent.putExtra("bookId", book.bookId.toInt())
        startActivity(intent)

    }

    //from secondary delegate
    //book mark
    override fun onTapSecondaryBookMark(book: BookVO) {
        Toast.makeText(context, "Click Secondary book mark", Toast.LENGTH_SHORT).show()
    }

    //read button
    override fun onTapSecondaryBookRead(book: BookVO) {
        Toast.makeText(context, "Click secondary book read", Toast.LENGTH_SHORT).show()
    }

    //share button
    override fun onTapSecondaryBookShare(book: BookVO) {
        startActivity(Intent().apply {
            action = Intent.ACTION_SEND
            type = "text/plain"
            putExtra(Intent.EXTRA_TEXT, "Component link will be here.")
        })
    }

    //book cover image
    override fun onTapSecondaryBookImage(book: BookVO) {
        Toast.makeText(context, "Click secondary book image", Toast.LENGTH_SHORT).show()
    }

    //whole book item
    override fun onTapSecondaryBook(book: BookVO) {
        val intent = Intent(context, BookDetailActivity::class.java)
        intent.putExtra("bookId", book.id)
        startActivity(intent)
    }

    //success get primary book
    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onLoadPrimaryBookData(successGetBookEvent: PrimaryBookDataEvent.SuccessGetPrimaryBookEvent) {
        adapter.setPrimaryBookData(successGetBookEvent.loadPrimaryBook!!)

        //stop swipe refresh layout
        srlHome.isRefreshing = false

        //empty view
        home_empty_view.visibility = View.GONE
    }

    //failure get primary book
    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onFailureLoadPrimaryBookData(failureGetBookEvent: PrimaryBookDataEvent.EmptyPrimaryBookEvent) {

        //stop swipe refresh layout
        srlHome.isRefreshing = false

        //home empty view
        //tv_home_error_message.text = failureGetBookEvent.errorMsg
        //home_empty_view.visibility = View.VISIBLE
    }

    //success get secondary book
    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onLoadBookData(successGetBookEvent: BookDataEvent.SuccessGetBookEvent) {
        adapter.setSecondaryBookData(successGetBookEvent.loadBook!!)

        //stop swipe refresh layout
        srlHome.isRefreshing = false

        //empty view
        home_empty_view.visibility = View.GONE
    }

    //failure get secondary book
    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onFailureLoadBookData(failureGetBookEvent: BookDataEvent.EmptyBookLoadEvent) {

        //stop swipe refresh layout
        srlHome.isRefreshing = false

        //home empty view
        tv_home_error_message.text = failureGetBookEvent.errorMsg
        home_empty_view.visibility = View.VISIBLE
    }
}