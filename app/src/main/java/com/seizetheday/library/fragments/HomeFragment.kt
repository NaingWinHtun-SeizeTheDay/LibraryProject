package com.seizetheday.library.fragments

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
import com.seizetheday.library.delegates.PrimaryBookDelegate
import com.seizetheday.library.delegates.SecondaryBookDelegate
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment(), PrimaryBookDelegate, SecondaryBookDelegate {
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
        val adapter = BookAdapter(this, this)
        rv_book_list.adapter = adapter

    }

    //from primary delegate
    //book cover image
    override fun onTapPrimaryBookImage() {
        Toast.makeText(context, "Click Image", Toast.LENGTH_SHORT).show()
    }

    //book mark
    override fun onTapPrimaryBookMark() {
        Toast.makeText(context, "Click Book Mark", Toast.LENGTH_SHORT).show()
    }

    //book download
    override fun onTapPrimaryBookDownload() {
        startActivity(Intent(context, LoginActivity::class.java))
    }

    //share button
    override fun onTapPrimaryBookShare() {
        startActivity(Intent().apply {
            action = Intent.ACTION_SEND
            type = "text/plain"
            putExtra(Intent.EXTRA_TEXT, "Component link will be here.")
        })
    }

    //whole book item
    override fun onTapPrimaryBook() {
        startActivity(Intent(context, BookDetailActivity::class.java))
    }

    //from secondary delegate
    //book mark
    override fun onTapSecondaryBookMark() {
        Toast.makeText(context, "Click Secondary book mark", Toast.LENGTH_SHORT).show()
    }

    //read button
    override fun onTapSecondaryBookRead() {
        Toast.makeText(context, "Click secondary book read", Toast.LENGTH_SHORT).show()
    }

    //share button
    override fun onTapSecondaryBookShare() {
        startActivity(Intent().apply {
            action = Intent.ACTION_SEND
            type = "text/plain"
            putExtra(Intent.EXTRA_TEXT, "Component link will be here.")
        })
    }

    //book cover image
    override fun onTapSecondaryBookImage() {
        Toast.makeText(context, "Click secondary book image", Toast.LENGTH_SHORT).show()
    }

    //whole book item
    override fun onTapSecondaryBook() {
        startActivity(Intent(context, BookDetailActivity::class.java))
    }

}