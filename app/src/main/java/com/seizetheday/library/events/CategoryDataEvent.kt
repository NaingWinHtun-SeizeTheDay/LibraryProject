package com.seizetheday.library.events

import com.seizetheday.library.data.vos.CategoryVO

class CategoryDataEvent {
    class SuccessGetCategoryEvent(val loadCategory: List<CategoryVO>?)

    class EmptyDataLoadEvent(val errorMsg: String? = "Empty body response")
}