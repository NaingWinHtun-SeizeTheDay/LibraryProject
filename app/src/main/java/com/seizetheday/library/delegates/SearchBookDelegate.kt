package com.seizetheday.library.delegates

import com.seizetheday.library.data.vos.SearchBookVO

interface SearchBookDelegate {
    fun onTapSearchBook(searchBook: SearchBookVO)
}