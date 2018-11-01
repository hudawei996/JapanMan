package com.fungo.japan.app

import com.fungo.baselib.app.BaseApplication
import com.fungo.imagego.glide.GlideImageStrategy
import com.fungo.imagego.strategy.ImageGoEngine

/**
 * @author Pinger
 * @since 2018/10/30 20:31
 */
class JapanApplication : BaseApplication() {

    override fun initSDK() {
        ImageGoEngine.setImageStrategy(GlideImageStrategy())
    }


    override fun getCurrentEnvModel(): Int {
            return 3
    }


    override fun isCanPrintLog(): Boolean = true

    override fun isCanSwitchEnv(): Boolean = true
}