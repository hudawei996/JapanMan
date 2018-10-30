package com.fungo.japan.app

import com.fungo.baselib.app.BaseApplication

/**
 * @author Pinger
 * @since 2018/10/30 20:31
 */
class JapanApplication : BaseApplication() {

    override fun initSDK() {
    }


    override fun getCurrentEnvModel(): Int {
        return 0
    }


    override fun isCanPrintLog(): Boolean = true

    override fun isCanSwitchEnv(): Boolean = true
}