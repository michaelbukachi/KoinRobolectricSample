package com.michaelbukachi.koinrobolectric

interface SomeService {

    fun fetchSomething(): String
}

class GoodService : SomeService {
    override fun fetchSomething(): String = "This is a good service"
}