/*
 * Copyright (C) 2026 Slate. All Rights Reserved.
 * * PROPRIETARY AND CONFIDENTIAL.
 * This software is the sole property of Slate. Unauthorized copying, 
 * distribution, or use of this file is strictly prohibited.
 */

package dev.patrickgold.florisboard.app

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun FlorisAppMainLayout(
    modifier: Modifier,
    isImeSetUp: Boolean,
    navController: androidx.navigation.NavHostController,
    previewFieldController: dev.patrickgold.florisboard.lib.compose.PreviewFieldController,
) {
    Surface(
        modifier = modifier,
        color = MaterialTheme.colorScheme.background,
    ) {
        FlorisAppNavHost(
            modifier = Modifier,
            navController = navController,
            startDestination = if (isImeSetUp) Routes.Settings.Home::class else Routes.Setup.Screen::class,
        )
        dev.patrickgold.florisboard.lib.compose.PreviewKeyboardField(previewFieldController)
    }
}
