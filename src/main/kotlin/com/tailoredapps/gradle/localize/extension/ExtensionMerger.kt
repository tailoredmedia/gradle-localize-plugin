package com.tailoredapps.gradle.localize.extension

import com.tailoredapps.gradle.localize.LocalizationConfig
import com.tailoredapps.gradle.localize.util.PathToFileManager

class ExtensionMerger(
    private val pathToFileManager: PathToFileManager
) {

    fun merge(
        baseConfig: BaseLocalizeExtension,
        productConfigName: String,
        productConfig: ProductLocalizeExtension
    ): LocalizationConfig {
        val serviceAccountCredentialsPath = productConfig.serviceAccountCredentialsFile
            ?: baseConfig.serviceAccountCredentialsFile

        val localizationPath = productConfig.localizationPath

        return LocalizationConfig(
            productName = productConfigName,
            serviceAccountCredentialsFile = pathToFileManager.pathToFile(
                serviceAccountCredentialsPath
            ),
            sheetId = productConfig.sheetId,
            languageTitles = productConfig.languageTitles,
            baseLanguage = productConfig.baseLanguage ?: baseConfig.baseLanguage,
            localizationPath = pathToFileManager.pathToFile(localizationPath),
            addToCheckTask = baseConfig.addToCheckTask,
            addComments = productConfig.addComments ?: baseConfig.addComments
        )
    }


}