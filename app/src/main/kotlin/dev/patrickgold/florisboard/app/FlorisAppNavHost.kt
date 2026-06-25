/*
 * Copyright (C) 2026 Slate. All Rights Reserved.
 * PROPRIETARY AND CONFIDENTIAL.
 */

package dev.patrickgold.florisboard.app

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleOut
import androidx.compose.animation.slideIn
import androidx.compose.animation.slideOut
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.TransformOrigin
import androidx.compose.ui.unit.IntOffset
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navDeepLink
import androidx.navigation.toRoute
import dev.patrickgold.florisboard.app.devtools.*
import dev.patrickgold.florisboard.app.ext.*
import dev.patrickgold.florisboard.app.settings.*
import dev.patrickgold.florisboard.app.settings.about.*
import dev.patrickgold.florisboard.app.settings.advanced.*
import dev.patrickgold.florisboard.app.settings.clipboard.ClipboardScreen
import dev.patrickgold.florisboard.app.settings.dictionary.DictionaryScreen
import dev.patrickgold.florisboard.app.settings.dictionary.UserDictionaryScreen
import dev.patrickgold.florisboard.app.settings.gestures.GesturesScreen
import dev.patrickgold.florisboard.app.settings.keyboard.InputFeedbackScreen
import dev.patrickgold.florisboard.app.settings.keyboard.KeyboardScreen
import dev.patrickgold.florisboard.app.settings.localization.*
import dev.patrickgold.florisboard.app.settings.media.MediaScreen
import dev.patrickgold.florisboard.app.settings.smartbar.SmartbarScreen
import dev.patrickgold.florisboard.app.settings.theme.*
import dev.patrickgold.florisboard.app.settings.typing.TypingScreen
import dev.patrickgold.florisboard.app.setup.SetupScreen
import kotlin.reflect.KClass

@Composable
fun FlorisAppNavHost(
    modifier: Modifier,
    navController: NavHostController,
    startDestination: KClass<*>,
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination,
        enterTransition = {
            slideIn { IntOffset(it.width, 0) } + fadeIn()
        },
        exitTransition = {
            slideOut { IntOffset(-it.width, 0) } + fadeOut()
        },
        popEnterTransition = { EnterTransition.None },
        popExitTransition = {
            scaleOut(
                targetScale = 0.85F,
                transformOrigin = TransformOrigin(pivotFractionX = 0.8f, pivotFractionY = 0.5f)
            ) + fadeOut(spring(stiffness = Spring.StiffnessMedium))
        },
    ) {
        composable<Routes.Setup.Screen>(
            typeMap = emptyMap(),
            deepLinks = emptyList(),
            enterTransition = null,
            exitTransition = null,
            popEnterTransition = null,
            popExitTransition = null,
            sizeTransform = null,
            content = { SetupScreen() },
        )

        composableWithDeepLink(Routes.Settings.Home::class) { HomeScreen() }

        composableWithDeepLink(Routes.Settings.Localization::class) { LocalizationScreen() }
        composableWithDeepLink(Routes.Settings.SelectLocale::class) { SelectLocaleScreen() }
        composableWithDeepLink(Routes.Settings.LanguagePackManager::class) { navBackStack ->
            val payload = navBackStack.toRoute<Routes.Settings.LanguagePackManager>()
            LanguagePackManagerScreen(payload.action)
        }
        composableWithDeepLink(Routes.Settings.SubtypeAdd::class) { SubtypeEditorScreen(null) }
        composableWithDeepLink(Routes.Settings.SubtypeEdit::class) { navBackStack ->
            val payload = navBackStack.toRoute<Routes.Settings.SubtypeEdit>()
            SubtypeEditorScreen(payload.id)
        }

        composableWithDeepLink(Routes.Settings.Theme::class) { ThemeScreen() }
        composableWithDeepLink(Routes.Settings.ThemeManager::class) { navBackStack ->
            val payload = navBackStack.toRoute<Routes.Settings.ThemeManager>()
            ThemeManagerScreen(payload.action)
        }

        composableWithDeepLink(Routes.Settings.Keyboard::class) { KeyboardScreen() }
        composableWithDeepLink(Routes.Settings.InputFeedback::class) { InputFeedbackScreen() }

        composableWithDeepLink(Routes.Settings.Smartbar::class) { SmartbarScreen() }

        composableWithDeepLink(Routes.Settings.Typing::class) { TypingScreen() }

        composableWithDeepLink(Routes.Settings.Dictionary::class) { DictionaryScreen() }
        composableWithDeepLink(Routes.Settings.UserDictionary::class) { navBackStack ->
            val payload = navBackStack.toRoute<Routes.Settings.UserDictionary>()
            UserDictionaryScreen(payload.type)
        }

        composableWithDeepLink(Routes.Settings.Gestures::class) { GesturesScreen() }

        composableWithDeepLink(Routes.Settings.Clipboard::class) { ClipboardScreen() }

        composableWithDeepLink(Routes.Settings.Media::class) { MediaScreen() }

        composableWithDeepLink(Routes.Settings.Other::class) { OtherScreen() }
        composableWithDeepLink(Routes.Settings.PhysicalKeyboard::class) { PhysicalKeyboardScreen() }
        composableWithDeepLink(Routes.Settings.Backup::class) { BackupScreen() }
        composableWithDeepLink(Routes.Settings.Restore::class) { RestoreScreen() }

        composableWithDeepLink(Routes.Settings.About::class) { AboutScreen() }
        composableWithDeepLink(Routes.Settings.ProjectLicense::class) { ProjectLicenseScreen() }
        composableWithDeepLink(Routes.Settings.ThirdPartyLicenses::class) { ThirdPartyLicensesScreen() }

        composableWithDeepLink(Routes.Devtools.Home::class) { DevtoolsScreen() }
        composableWithDeepLink(Routes.Devtools.AndroidLocales::class) { AndroidLocalesScreen() }
        composableWithDeepLink(Routes.Devtools.AndroidSettings::class) { navBackStack ->
            val payload = navBackStack.toRoute<Routes.Devtools.AndroidSettings>()
            AndroidSettingsScreen(payload.name)
        }
        composableWithDeepLink(Routes.Devtools.ExportDebugLog::class) { ExportDebugLogScreen() }

        composableWithDeepLink(Routes.Ext.Home::class) { ExtensionHomeScreen() }
        composableWithDeepLink(Routes.Ext.List::class) { navBackStack ->
            val payload = navBackStack.toRoute<Routes.Ext.List>()
            val showUpdate = payload.showUpdate != null && payload.showUpdate
            ExtensionListScreen(payload.type, showUpdate)
        }
        composableWithDeepLink(Routes.Ext.Edit::class) { navBackStack ->
            val payload = navBackStack.toRoute<Routes.Ext.Edit>()
            val extensionId = payload.id
            val serialType = payload.serialType
            ExtensionEditScreen(
                id = extensionId,
                createSerialType = serialType.takeIf { !it.isNullOrBlank() },
            )
        }
        composableWithDeepLink(Routes.Ext.Export::class) { navBackStack ->
            val payload = navBackStack.toRoute<Routes.Ext.Export>()
            val extensionId = payload.id
            ExtensionExportScreen(id = extensionId)
        }
        composableWithDeepLink(Routes.Ext.Import::class) { navBackStack ->
            val payload = navBackStack.toRoute<Routes.Ext.Import>()
            val uuid = payload.uuid
            ExtensionImportScreen(payload.type, uuid)
        }
        composableWithDeepLink(Routes.Ext.View::class) { navBackStack ->
            val payload = navBackStack.toRoute<Routes.Ext.View>()
            val extensionId = payload.id
            ExtensionViewScreen(id = extensionId)
        }
        composableWithDeepLink(Routes.Ext.CheckUpdates::class) {
            CheckUpdatesScreen()
        }
    }
}

inline fun <reified T : Any> NavGraphBuilder.composableWithDeepLink(
    kClass: KClass<T>,
    noinline content: @Composable (AnimatedContentScope.(NavBackStackEntry) -> Unit),
) {
    val deeplink = requireNotNull(kClass.annotations.firstOrNull { it is Deeplink } as? Deeplink) {
        "faulty class: $kClass with annotations ${kClass.annotations}"
    }
    composable<T>(
        typeMap = emptyMap(),
        deepLinks = listOf(navDeepLink<T>(basePath = "ui://florisboard/${deeplink.path}")),
        enterTransition = null,
        exitTransition = null,
        popEnterTransition = null,
        popExitTransition = null,
        sizeTransform = null,
        content = content,
    )
}
