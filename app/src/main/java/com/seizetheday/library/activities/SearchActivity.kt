package com.seizetheday.library.activities

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.View
import android.widget.SearchView
import com.seizetheday.library.R
import com.seizetheday.library.adapters.SearchAdapter
import com.seizetheday.library.data.models.SearchBookModel
import com.seizetheday.library.data.vos.SearchBookVO
import com.seizetheday.library.delegates.SearchBookDelegate
import com.seizetheday.library.events.SearchBookDataEvent
import kotlinx.android.synthetic.main.activity_search.*
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

class SearchActivity : AppCompatActivity(), SearchBookDelegate {

    var searchBooks: MutableList<SearchBookVO> = ArrayList()
    var books: MutableList<SearchBookVO> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)
        setSupportActionBar(search_toolbar)

        SearchBookModel.getObjInstance().loadSearchBook()

        rv_search.layoutManager = LinearLayoutManager(this)

        rv_search.adapter = SearchAdapter(searchBooks, this)

    }

    override fun onTapSearchBook(searchBook: SearchBookVO) {
        val intent = Intent(this, BookDetailActivity::class.java)
        intent.putExtra("bookId", searchBook.id)
        startActivity(intent)
    }

    override fun onStart() {
        EventBus.getDefault().register(this)
        super.onStart()
    }

    override fun onStop() {
        EventBus.getDefault().unregister(this)
        super.onStop()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.menu, menu)

        val searchItem = menu?.findItem(R.id.action_search)

        if (searchItem != null) {

            val searchView = searchItem.actionView as SearchView
            searchView.maxWidth = Int.MAX_VALUE
            searchView.queryHint = "Search your books"

            searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String?): Boolean {
                    return true
                }

                override fun onQueryTextChange(newText: String?): Boolean {
                    if (newText!!.isNotEmpty()) {
                        searchBooks.clear()
                        val search = newText.toLowerCase()
                        books.forEach {
                            if (it.bookName.toLowerCase().contains(search)) {
                                searchBooks.add(it)
                            }
                        }

                        if (searchBooks.size == 0) {
                            rl_empty_search.visibility = View.VISIBLE
                        } else {
                            rl_empty_search.visibility = View.GONE
                        }

                        rl_search.visibility = View.GONE
                        rv_search.adapter?.notifyDataSetChanged()
                    } else {
                        searchBooks.clear()
                        rl_empty_search.visibility = View.GONE
                        rl_search.visibility = View.VISIBLE
                        rv_search.adapter?.notifyDataSetChanged()
                    }

                    return true
                }
            })
        }

        return super.onCreateOptionsMenu(menu)
    }

    //success get search book
    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onLoadSearchBookData(successGetSearchEvent: SearchBookDataEvent.SuccessGetSearchBookEvent) {
        books.addAll(successGetSearchEvent.loadSearchBook!!)
        searchBooks.addAll(searchBooks)
    }
}
