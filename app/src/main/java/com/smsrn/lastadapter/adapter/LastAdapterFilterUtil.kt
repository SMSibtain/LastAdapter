package com.smsrn.lastadapter.adapter

/**
 * Generic RecyclerView Adapter Filter
 *
 * @author: Sibtain Raza
 */
object LastAdapterFilterUtil {
    fun <T> filterResult(item: T, charString: String): Boolean {
        when (item) {
            /*is JobsVisitResponse -> {
                if (item.accountPostcode.toString().contains(charString, ignoreCase = true))
                    return true
                return false
            }*/
        }
        return true
    }
}