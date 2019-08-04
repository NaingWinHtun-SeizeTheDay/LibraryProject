package com.seizetheday.library.data.models

import com.seizetheday.library.data.vos.BookVO
import com.seizetheday.library.events.BookDataEvent
import com.seizetheday.library.network.dataagent.RetrofitDataAgent
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

class BookModel {

    //for book repository
    private var mBookVOMap: MutableMap<Int, BookVO> = HashMap()

    companion object {
        private var objInstance: BookModel? = null

        fun getObjInstance(): BookModel {
            if (objInstance == null) {
                objInstance = BookModel()
            }
            val obj = objInstance
            return obj!!
        }
    }

    //load book from DataAgent
    fun loadBooks() {
        RetrofitDataAgent.getObjInstance().loadSecondaryBook()
    }

    init {
        EventBus.getDefault().register(this)
    }

    //load specific book by id
    fun getBookById(bookId: Int): BookVO? {
        return mBookVOMap[bookId]
    }

    //for data repository
    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    fun onSuccessGetBook(successGetBook: BookDataEvent.SuccessGetBookEvent) {
        for (book in successGetBook.loadBook!!) {
            mBookVOMap[book.id] = book
        }
    }
}