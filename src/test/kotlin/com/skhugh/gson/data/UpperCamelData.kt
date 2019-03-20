package com.skhugh.gson.data

import com.google.common.base.CaseFormat
import com.google.gson.annotations.SerializedName
import com.skhugh.gson.RuntimeFieldName

@RuntimeFieldName(json = CaseFormat.UPPER_CAMEL)
data class UpperCamelData(
    @SerializedName("_id") val id: String?,
    val index: Int?,
    val guid: String?,
    val isActive: Boolean?,
    val balance: String?,
    val picture: String?,
    val age: Int?,
    val eyeColor: String?,
    val name: Name?,
    val company: String?
) {

    @RuntimeFieldName(json = CaseFormat.UPPER_CAMEL)
    data class Name(
        val first: String?,
        val last: String?
    )
}
