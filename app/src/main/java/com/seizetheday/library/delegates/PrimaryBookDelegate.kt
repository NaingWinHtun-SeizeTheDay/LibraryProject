package com.seizetheday.library.delegates

import com.seizetheday.library.data.vos.PrimaryBookVO

interface PrimaryBookDelegate {
    fun onTapPrimaryBookImage(bookVO: PrimaryBookVO)
    fun onTapPrimaryBookMark(bookVO: PrimaryBookVO)
    fun onTapPrimaryBookRead(bookVO: PrimaryBookVO)
    fun onTapPrimaryBook(bookVO: PrimaryBookVO)
}