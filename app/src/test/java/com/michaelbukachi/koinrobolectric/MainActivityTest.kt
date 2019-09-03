package com.michaelbukachi.koinrobolectric

import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.ApplicationProvider
import com.agoda.kakao.screen.Screen.Companion.onScreen
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.dsl.module
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(application = KoinTestApp::class, sdk = [28])
class MainActivityTest {

    lateinit var app: KoinTestApp

    @Before
    fun setup() {
        app = ApplicationProvider.getApplicationContext()
    }

    @Test
    fun testServiceStatus_isFetched() {
        val modules = module {
            single<SomeService> { GoodService() }
        }

        app.loadModules(modules) {
            // Start mocking from here
            ActivityScenario.launch(MainActivity::class.java)
            onScreen<MainScreen> {
                status {
                    hasText("This is a good service")
                }
            }
        }
    }
}