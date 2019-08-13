package com.seizetheday.library.events

import com.seizetheday.library.data.vos.SearchBookVO

class SearchBookDataEvent {
    class SuccessGetSearchBookEvent(val loadSearchBook: MutableList<SearchBookVO>?)
    class EmptySearchBookEvent(val errorMsg: String? = "Empty body response")
}