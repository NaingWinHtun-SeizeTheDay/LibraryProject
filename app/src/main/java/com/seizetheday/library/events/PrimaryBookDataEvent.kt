package com.seizetheday.library.events

import com.seizetheday.library.data.vos.PrimaryBookVO

class PrimaryBookDataEvent {
    class SuccessGetPrimaryBookEvent(val loadPrimaryBook: List<PrimaryBookVO>?)
    class EmptyPrimaryBookEvent(val errorMsg: String? = "Empty body response")
}