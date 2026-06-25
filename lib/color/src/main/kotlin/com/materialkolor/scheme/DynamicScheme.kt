/*
 * Copyright (C) 2026 Slate. All Rights Reserved.
 * * PROPRIETARY AND CONFIDENTIAL.
 * This software is the sole property of Slate. Unauthorized copying, 
 * distribution, or use of this file is strictly prohibited.
 */

package com.materialkolor.scheme

/**
 * Shim class for MaterialKolor DynamicScheme, which is missing from the provided AAR.
 */
public open class DynamicScheme {
    public enum class Platform {
        PHONE,
        WATCH;

        public companion object {
            public val Default: Platform = PHONE
        }
    }
}
