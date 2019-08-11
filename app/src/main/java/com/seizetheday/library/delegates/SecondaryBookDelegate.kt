package com.seizetheday.library.delegates

import com.seizetheday.library.data.vos.BookVO

interface SecondaryBookDelegate {
    fun onTapSecondaryBookMark(book: BookVO)
    fun onTapSecondaryBookRead(book: BookVO)
    fun onTapSecondaryBookImage(book: BookVO)
    fun onTapSecondaryBook(book: BookVO)
}