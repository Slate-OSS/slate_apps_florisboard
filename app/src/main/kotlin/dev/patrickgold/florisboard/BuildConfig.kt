/*
 * Copyright (C) 2026 Slate. All Rights Reserved.
 * PROPRIETARY AND CONFIDENTIAL.
 */

package dev.patrickgold.florisboard

/**
 * Manual BuildConfig for AOSP build.
 * Soong does not generate this automatically for android_app.
 */
object BuildConfig {
    const val APPLICATION_ID = "dev.patrickgold.florisboard"
    const val DEBUG = false
    const val VERSION_NAME = "0.4.0-aosp"
    const val VERSION_CODE = 36
    const val BUILD_TYPE = "release"
    const val FLAVOR = ""
    const val FLADDONS_STORE_URL = "fladdons.patrickgold.dev"
    const val FLADDONS_API_VERSION = "v~draft2"
    const val BUILD_COMMIT_HASH = "aosp-baklava"
}
