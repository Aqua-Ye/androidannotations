package org.androidannotations.gradle.activity

import android.app.Activity
import android.widget.TextView
import com.tmtron.greenannotations.EventBusGreenRobot
import org.androidannotations.annotations.*
import org.androidannotations.annotations.res.StringRes
import org.androidannotations.gradle.R
import org.greenrobot.eventbus.EventBus
import java.util.*

@EActivity(R.layout.main)
open class HelloAndroidActivity : Activity() {

    @StringRes
    protected lateinit var hello: String

    @ViewById
    protected lateinit var helloTextView: TextView

    @Extra
    @JvmField
    protected final var myIntExtra: Int = 0

    @EventBusGreenRobot
    lateinit var bus: EventBus

    @AfterViews
    protected fun afterViews() {
        computeDateBackground()
    }

    @Background
    protected open fun computeDateBackground() {
        val now = Date()
        val helloMessage = String.format(hello, now.toString())

        updateHelloTextView(helloMessage)
    }

    @UiThread
    protected open fun updateHelloTextView(helloMessage: String) {
        helloTextView.text = helloMessage
    }
}
