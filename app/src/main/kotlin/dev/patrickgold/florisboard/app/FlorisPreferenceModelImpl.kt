package dev.patrickgold.florisboard.app

import dev.patrickgold.jetpref.datastore.model.PreferenceData
import dev.patrickgold.jetpref.datastore.model.PreferenceModel

class FlorisPreferenceModelImpl : FlorisPreferenceModel() {
    override val declaredPreferenceEntries: Map<PreferenceModel.TypedKey, PreferenceData<*>> by lazy {
        val entries = mutableListOf<PreferenceData<*>>()
        
        // Clipboard
        entries.add(this.clipboard.useInternalClipboard)
        entries.add(this.clipboard.syncToFloris)
        entries.add(this.clipboard.syncToSystem)
        entries.add(this.clipboard.suggestionEnabled)
        entries.add(this.clipboard.suggestionTimeout)
        entries.add(this.clipboard.historyEnabled)
        entries.add(this.clipboard.historyNumGridColumnsPortrait)
        entries.add(this.clipboard.historyNumGridColumnsLandscape)
        entries.add(this.clipboard.historyAutoCleanOldEnabled)
        entries.add(this.clipboard.historyAutoCleanOldAfter)
        entries.add(this.clipboard.historyAutoCleanSensitiveEnabled)
        entries.add(this.clipboard.historyAutoCleanSensitiveAfter)
        entries.add(this.clipboard.historySizeLimitEnabled)
        entries.add(this.clipboard.historySizeLimit)
        entries.add(this.clipboard.historyHideOnPaste)
        entries.add(this.clipboard.historyHideOnNextTextField)
        entries.add(this.clipboard.clearPrimaryClipAffectsHistoryIfUnpinned)

        // Correction
        entries.add(this.correction.autoCapitalization)
        entries.add(this.correction.autoSpacePunctuation)
        entries.add(this.correction.doubleSpacePeriod)
        entries.add(this.correction.rememberCapsLockState)

        // Devtools
        entries.add(this.devtools.enabled)
        entries.add(this.devtools.showPrimaryClip)
        entries.add(this.devtools.showInputStateOverlay)
        entries.add(this.devtools.showSpellingOverlay)
        entries.add(this.devtools.showInlineAutofillOverlay)
        entries.add(this.devtools.showKeyTouchBoundaries)
        entries.add(this.devtools.showDragAndDropHelpers)
        entries.add(this.devtools.showWindowResizeHandleBoundaries)

        // Dictionary
        entries.add(this.dictionary.enableSystemUserDictionary)
        entries.add(this.dictionary.enableFlorisUserDictionary)

        // Emoji
        entries.add(this.emoji.preferredSkinTone)
        entries.add(this.emoji.preferredHairStyle)
        entries.add(this.emoji.historyEnabled)
        entries.add(this.emoji.historyPinnedUpdateStrategy)
        entries.add(this.emoji.historyPinnedMaxSize)
        entries.add(this.emoji.historyRecentUpdateStrategy)
        entries.add(this.emoji.historyRecentMaxSize)
        entries.add(this.emoji.suggestionEnabled)
        entries.add(this.emoji.suggestionType)
        entries.add(this.emoji.suggestionUpdateHistory)
        entries.add(this.emoji.suggestionCandidateShowName)
        entries.add(this.emoji.suggestionQueryMinLength)
        entries.add(this.emoji.suggestionCandidateMaxCount)

        // Gestures
        entries.add(this.gestures.swipeUp)
        entries.add(this.gestures.swipeDown)
        entries.add(this.gestures.swipeLeft)
        entries.add(this.gestures.swipeRight)
        entries.add(this.gestures.spaceBarSwipeUp)
        entries.add(this.gestures.spaceBarSwipeLeft)
        entries.add(this.gestures.spaceBarSwipeRight)
        entries.add(this.gestures.spaceBarLongPress)
        entries.add(this.gestures.deleteKeySwipeLeft)
        entries.add(this.gestures.deleteKeyLongPress)
        entries.add(this.gestures.swipeDistanceThreshold)
        entries.add(this.gestures.swipeVelocityThreshold)

        // Glide
        entries.add(this.glide.enabled)
        entries.add(this.glide.showTrail)
        entries.add(this.glide.trailDuration)
        entries.add(this.glide.showPreview)
        entries.add(this.glide.previewRefreshDelay)
        entries.add(this.glide.immediateBackspaceDeletesWord)

        // InputFeedback
        entries.add(this.inputFeedback.audioEnabled)
        entries.add(this.inputFeedback.audioActivationMode)
        entries.add(this.inputFeedback.audioVolume)
        entries.add(this.inputFeedback.audioFeatKeyPress)
        entries.add(this.inputFeedback.audioFeatKeyLongPress)
        entries.add(this.inputFeedback.audioFeatKeyRepeatedAction)
        entries.add(this.inputFeedback.audioFeatGestureSwipe)
        entries.add(this.inputFeedback.audioFeatGestureMovingSwipe)
        entries.add(this.inputFeedback.hapticEnabled)
        entries.add(this.inputFeedback.hapticActivationMode)
        entries.add(this.inputFeedback.hapticVibrationMode)
        entries.add(this.inputFeedback.hapticVibrationDuration)
        entries.add(this.inputFeedback.hapticVibrationStrength)
        entries.add(this.inputFeedback.hapticFeatKeyPress)
        entries.add(this.inputFeedback.hapticFeatKeyLongPress)
        entries.add(this.inputFeedback.hapticFeatKeyRepeatedAction)
        entries.add(this.inputFeedback.hapticFeatGestureSwipe)
        entries.add(this.inputFeedback.hapticFeatGestureMovingSwipe)

        // Internal
        entries.add(this.internal.homeIsBetaToolboxCollapsed)
        entries.add(this.internal.isImeSetUp)
        entries.add(this.internal.versionOnInstall)
        entries.add(this.internal.versionLastUse)
        entries.add(this.internal.versionLastChangelog)
        entries.add(this.internal.notificationPermissionState)

        // Keyboard
        entries.add(this.keyboard.numberRow)
        entries.add(this.keyboard.hintedNumberRowEnabled)
        entries.add(this.keyboard.hintedNumberRowMode)
        entries.add(this.keyboard.hintedSymbolsEnabled)
        entries.add(this.keyboard.hintedSymbolsMode)
        entries.add(this.keyboard.utilityKeyEnabled)
        entries.add(this.keyboard.utilityKeyAction)
        entries.add(this.keyboard.spaceBarMode)
        entries.add(this.keyboard.capitalizationBehavior)
        entries.add(this.keyboard.fontSizeMultiplierPortrait)
        entries.add(this.keyboard.fontSizeMultiplierLandscape)
        entries.add(this.keyboard.landscapeInputUiMode)
        entries.add(this.keyboard.keySpacingVertical)
        entries.add(this.keyboard.keySpacingHorizontal)
        entries.add(this.keyboard.popupEnabled)
        entries.add(this.keyboard.mergeHintPopupsEnabled)
        entries.add(this.keyboard.longPressDelay)
        entries.add(this.keyboard.spaceBarSwitchesToCharacters)
        entries.add(this.keyboard.incognitoDisplayMode)

        // Localization
        entries.add(this.localization.displayLanguageNamesIn)
        entries.add(this.localization.displayKeyboardLabelsInSubtypeLanguage)
        entries.add(this.localization.subtypes)

        // Other
        entries.add(this.other.settingsTheme)
        entries.add(this.other.settingsLanguage)
        entries.add(this.other.showAppIcon)

        // PhysicalKeyboard
        entries.add(this.physicalKeyboard.showOnScreenKeyboard)

        // Smartbar
        entries.add(this.smartbar.enabled)
        entries.add(this.smartbar.layout)
        entries.add(this.smartbar.flipToggles)
        entries.add(this.smartbar.sharedActionsExpanded)
        entries.add(this.smartbar.sharedActionsAutoExpandCollapse)
        entries.add(this.smartbar.sharedActionsExpandWithAnimation)
        entries.add(this.smartbar.extendedActionsExpanded)
        entries.add(this.smartbar.extendedActionsPlacement)

        // Spelling
        entries.add(this.spelling.languageMode)
        entries.add(this.spelling.useContacts)
        entries.add(this.spelling.useUdmEntries)

        // Suggestion
        entries.add(this.suggestion.api30InlineSuggestionsEnabled)
        entries.add(this.suggestion.enabled)
        entries.add(this.suggestion.displayMode)
        entries.add(this.suggestion.blockPossiblyOffensive)
        entries.add(this.suggestion.incognitoMode)
        entries.add(this.suggestion.forceIncognitoModeFromDynamic)

        // Theme
        entries.add(this.theme.mode)
        entries.add(this.theme.editorColorRepresentation)
        entries.add(this.theme.editorDisplayKbdAfterDialogs)
        entries.add(this.theme.editorLevel)

        val map = mutableMapOf<PreferenceModel.TypedKey, PreferenceData<*>>()
        for (entry in entries) {
            map[entry.typedKey] = entry
        }
        map
    }
}
