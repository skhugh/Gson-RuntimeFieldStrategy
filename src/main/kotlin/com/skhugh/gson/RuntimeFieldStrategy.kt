package com.skhugh.gson

import com.google.gson.FieldNamingStrategy
import java.lang.reflect.Field

class RuntimeFieldStrategy : FieldNamingStrategy {

    override fun translateName(f: Field): String =
        f.declaringClass.getAnnotation(RuntimeFieldName::class.java)?.run {
            source.to(json, f.name)
        } ?: f.name
}
