package com.skhugh.gson

import com.google.common.base.CaseFormat

@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
annotation class RuntimeFieldName(val source: CaseFormat = CaseFormat.LOWER_CAMEL, val json: CaseFormat)
