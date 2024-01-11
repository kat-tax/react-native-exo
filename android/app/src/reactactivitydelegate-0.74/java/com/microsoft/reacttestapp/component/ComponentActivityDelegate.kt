package com.microsoft.reacttestapp.component

import android.os.Bundle
import com.facebook.react.ReactActivity
import com.facebook.react.ReactActivityDelegate
import com.facebook.react.ReactRootView
import com.microsoft.reacttestapp.BuildConfig

class ComponentActivityDelegate(
    activity: ReactActivity,
    mainComponentName: String?
) : ReactActivityDelegate(activity, mainComponentName) {
    override fun getLaunchOptions(): Bundle? {
        return plainActivity.intent.extras?.getBundle(
            ComponentActivity.COMPONENT_INITIAL_PROPERTIES
        )
    }

    override fun isFabricEnabled(): Boolean = BuildConfig.ReactTestApp_useFabric

    override fun createRootView(): ReactRootView =
        ReactRootView(context).apply { setIsFabric(BuildConfig.ReactTestApp_useFabric) }

    override fun createRootView(bundle: Bundle?): ReactRootView =
        ReactRootView(context).apply { setIsFabric(BuildConfig.ReactTestApp_useFabric) }
}
