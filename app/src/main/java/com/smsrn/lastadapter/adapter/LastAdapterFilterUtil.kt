package com.smsrn.lastadapter.adapter

import com.smsrn.lastadapter.model.GeneralFilterItem

/**
 * Generic RecyclerView Adapter Filter
 *
 * @author: Sibtain Raza
 */
object LastAdapterFilterUtil {
    fun <T> filterResult(item: T, charString: String): Boolean {
        when (item) {
            is GeneralFilterItem -> {
                if (item.firstValue.contains(charString, ignoreCase = true) ||
                    item.secondValue.contains(charString, ignoreCase = true))
                    return true
                return false
            }
        }
        return true
    }
}