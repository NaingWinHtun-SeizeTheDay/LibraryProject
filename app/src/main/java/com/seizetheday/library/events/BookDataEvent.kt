package com.seizetheday.library.events

import com.seizetheday.library.data.vos.BookVO

class BookDataEvent {
    class SuccessGetBookEvent(val loadBook: List<BookVO>?)
    class EmptyBookLoadEvent(val errorMsg: String? = "Empty body response")
}