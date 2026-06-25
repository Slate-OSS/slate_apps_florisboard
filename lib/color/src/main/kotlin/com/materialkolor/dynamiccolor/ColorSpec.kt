/*
 * Copyright (C) 2026 Slate. All Rights Reserved.
 * * PROPRIETARY AND CONFIDENTIAL.
 * This software is the sole property of Slate. Unauthorized copying, 
 * distribution, or use of this file is strictly prohibited.
 */

package com.materialkolor.dynamiccolor

/**
 * Shim interface for MaterialKolor ColorSpec, which is missing from the provided AAR.
 */
public interface ColorSpec {
    public enum class SpecVersion {
        SPEC_2021,
        SPEC_2025;

        public companion object {
            public val Default: SpecVersion = SPEC_2021
        }
    }
}
