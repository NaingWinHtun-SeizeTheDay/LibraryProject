package com.seizetheday.library.data.models

import com.seizetheday.library.data.vos.PrimaryBookVO
import com.seizetheday.library.events.PrimaryBookDataEvent
import com.seizetheday.library.network.dataagent.RetrofitDataAgent
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

class PrimaryBookModel {

    //for book repository
    private var mBookVOMap: MutableMap<Int, PrimaryBookVO> = HashMap()

    companion object {
        private var objInstance: PrimaryBookModel? = null

        fun getObjInstance(): PrimaryBookModel {

            if (objInstance == null) {
                objInstance = PrimaryBookModel()
            }
            val obj = objInstance
            return obj!!
        }
    }

    fun loadPrimaryBook() {
        RetrofitDataAgent.getObjInstance().loadPrimaryBook()
    }

    init {
        EventBus.getDefault().register(this)
    }

    //load specific book by id
    fun getBookById(bookId: Int): PrimaryBookVO? {
        return mBookVOMap[bookId]
    }

    //for data repository
    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    fun onSuccessGetPrimaryBook(successGetPrimaryBook: PrimaryBookDataEvent.SuccessGetPrimaryBookEvent) {
        for (book in successGetPrimaryBook.loadPrimaryBook!!) {
            mBookVOMap[book.id] = book
        }
    }
}