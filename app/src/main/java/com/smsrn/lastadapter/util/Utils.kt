package com.smsrn.lastadapter.util

import com.smsrn.lastadapter.model.GeneralFilterItem
import com.smsrn.lastadapter.model.GeneralItem

object Utils {
    fun getStringList(): ArrayList<String> {
        val stringList: ArrayList<String> = ArrayList()
        for (i in 1..10) {
            stringList.add("Text Label $i")
        }
        return stringList
    }

    fun getGeneralItemList(): ArrayList<GeneralItem> {
        val generalItemList: ArrayList<GeneralItem> = ArrayList()
        for (i in 1..10) {
            val generalItem = GeneralItem()
            generalItem.firstValue = "Text Label $i"
            generalItem.secondValue = "Button $i"
            generalItemList.add(generalItem)
        }
        return generalItemList
    }

    fun getGeneralFilterItemList(): ArrayList<GeneralFilterItem> {
        val generalItemList: ArrayList<GeneralFilterItem> = ArrayList()
        for (i in 1..10) {
            val generalItem = GeneralFilterItem()
            generalItem.firstValue = "First Text Label $i"
            generalItem.secondValue = "Second Text Label $i"
            generalItem.thirdValue = "Button $i"
            generalItemList.add(generalItem)
        }
        return generalItemList
    }
}