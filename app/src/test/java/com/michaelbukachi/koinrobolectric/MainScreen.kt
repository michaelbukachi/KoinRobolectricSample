package com.michaelbukachi.koinrobolectric

import com.agoda.kakao.screen.Screen
import com.agoda.kakao.text.KTextView

class MainScreen : Screen<MainScreen>() {
    val status = KTextView { withId(R.id.service_status) }
}