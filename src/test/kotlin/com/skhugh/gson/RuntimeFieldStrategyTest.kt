package com.skhugh.gson

import com.google.common.truth.Truth.assertThat
import com.google.gson.GsonBuilder
import com.skhugh.gson.data.LowerUnderData
import com.skhugh.gson.data.UpperCamelData
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class RuntimeFieldStrategyTest {
    private val lowerUnderJson = "{\n" +
            "    \"_id\": \"5c90decddacd4060f53a58e0\",\n" +
            "    \"index\": 0,\n" +
            "    \"guid\": \"0a80e0d9-6ca8-4825-9393-1e19bc7c7e73\",\n" +
            "    \"is_active\": false,\n" +
            "    \"balance\": \"\$2,780.77\",\n" +
            "    \"picture\": \"http://placehold.it/32x32\",\n" +
            "    \"age\": 24,\n" +
            "    \"eye_color\": \"blue\",\n" +
            "    \"name\": {\n" +
            "      \"first\": \"Black\",\n" +
            "      \"last\": \"Fuentes\"\n" +
            "    },\n" +
            "    \"company\": \"GEOFARM\"\n" +
            "}"

    private val upperCamelJson = "{\n" +
            "    \"_id\": \"5c90decddacd4060f53a58e0\",\n" +
            "    \"Index\": 0,\n" +
            "    \"Guid\": \"0a80e0d9-6ca8-4825-9393-1e19bc7c7e73\",\n" +
            "    \"IsActive\": false,\n" +
            "    \"Balance\": \"\$2,780.77\",\n" +
            "    \"Picture\": \"http://placehold.it/32x32\",\n" +
            "    \"Age\": 24,\n" +
            "    \"EyeColor\": \"blue\",\n" +
            "    \"Name\": {\n" +
            "      \"First\": \"Black\",\n" +
            "      \"Last\": \"Fuentes\"\n" +
            "    },\n" +
            "    \"Company\": \"GEOFARM\"\n" +
            "}"

    private val gson = GsonBuilder().setFieldNamingStrategy(RuntimeFieldStrategy()).create()
    private lateinit var lowerUnderData: LowerUnderData
    private lateinit var upperCamelData: UpperCamelData

    @Before
    fun setUp() {
        lowerUnderData = gson.fromJson(lowerUnderJson, LowerUnderData::class.java) ?: error("should not be null")
        upperCamelData = gson.fromJson(upperCamelJson, UpperCamelData::class.java) ?: error("should not be null")
    }

    @Test
    fun testRuntimeFieldStrategy() {
        with(lowerUnderData) {
            assertThat(id).isEqualTo("5c90decddacd4060f53a58e0")
            assertThat(index).isEqualTo(0)
            assertThat(eyeColor).isEqualTo("blue")
        }

        with(upperCamelData) {
            assertThat(id).isEqualTo("5c90decddacd4060f53a58e0")
            assertThat(index).isEqualTo(0)
            assertThat(eyeColor).isEqualTo("blue")
        }
    }
}
