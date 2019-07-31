package com.seizetheday.library.data.models

import com.seizetheday.library.network.dataagent.RetrofitDataAgent

class PrimaryBookModel {

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
}