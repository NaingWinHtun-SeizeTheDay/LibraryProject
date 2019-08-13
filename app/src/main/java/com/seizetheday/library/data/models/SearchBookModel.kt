package com.seizetheday.library.data.models

import com.seizetheday.library.data.vos.SearchBookVO
import com.seizetheday.library.events.PrimaryBookDataEvent
import com.seizetheday.library.events.SearchBookDataEvent
import com.seizetheday.library.network.dataagent.RetrofitDataAgent
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

class SearchBookModel {

    //for book repository
    private var mBookVOMap: MutableMap<Int, SearchBookVO> = HashMap()

    companion object {
        private var objInstance: SearchBookModel? = null

        fun getObjInstance(): SearchBookModel {

            if (objInstance == null) {
                objInstance = SearchBookModel()
            }
            val obj = objInstance
            return obj!!
        }
    }

    fun loadSearchBook() {
        RetrofitDataAgent.getObjInstance().loadSearchBook()
    }

    init {
        EventBus.getDefault().register(this)
    }

    //load specific book by id
    fun getBookById(bookId: Int): SearchBookVO? {
        return mBookVOMap[bookId]
    }

    //for data repository
    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    fun onSuccessGetPrimaryBook(successGetSearchBook: SearchBookDataEvent.SuccessGetSearchBookEvent) {
        for (book in successGetSearchBook.loadSearchBook!!) {
            mBookVOMap[book.id] = book
        }
    }
}