package com.seizetheday.library.data.models

import com.seizetheday.library.network.dataagent.RetrofitDataAgent

class CategoryModel {
    companion object {
        private var objInstance: CategoryModel? = null

        fun getInstance(): CategoryModel {
            if (objInstance == null) {
                objInstance = CategoryModel()
            }
            val obj = objInstance
            return obj!!
        }
    }

    //load Retrofit DataAgent
    fun loadCategory() {
        RetrofitDataAgent.getObjInstance().loadCategory()
    }
}