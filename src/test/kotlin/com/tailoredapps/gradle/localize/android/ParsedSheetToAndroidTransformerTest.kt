package com.tailoredapps.gradle.localize.android

import com.tailoredapps.gradle.localize.localization.LocalizationSheetParser
import org.amshove.kluent.shouldBeEqualTo
import org.junit.Before
import org.junit.Test


internal class ParsedSheetToAndroidTransformerTest {

    private lateinit var transformer: ParsedSheetToAndroidTransformer

    @Before
    fun setUp() {
        transformer = ParsedSheetToAndroidTransformer()
    }

    @Test
    fun `parsed real example sheet extracts correct german values`() {
        val realExampleParsedSheet = LocalizationSheetParser.ParsedSheet(
            worksheets = listOf(
                LocalizationSheetParser.ParsedSheet.WorkSheet(
                    title = "_Template",
                    entries = listOf(
                        LocalizationSheetParser.ParsedSheet.LocalizationEntry(
                            identifier = mapOf(
                                LocalizationSheetParser.Platform.iOS to "example.example.test",
                                LocalizationSheetParser.Platform.Android to "example.example",
                                LocalizationSheetParser.Platform.Web to "example.example"
                            ),
                            values = mapOf(
                                "de" to "Mario hat %1s eine %2s gegessen",
                                "en" to "Mario ate a %2s %1s"
                            ),
                            comment = "beispiel beispiel"
                        ),
                        LocalizationSheetParser.ParsedSheet.LocalizationEntry(
                            identifier = mapOf(
                                LocalizationSheetParser.Platform.iOS to "hallo.test",
                                LocalizationSheetParser.Platform.Android to "TBD",
                                LocalizationSheetParser.Platform.Web to "TBD"
                            ),
                            values = mapOf(
                                "de" to "Mario hat %1d eine %2d gegessen",
                                "en" to "Mario ate a %2d %1d"
                            ),
                            comment = null
                        ),
                        LocalizationSheetParser.ParsedSheet.LocalizationEntry(
                            identifier = mapOf(
                                LocalizationSheetParser.Platform.iOS to "ios.test01",
                                LocalizationSheetParser.Platform.Android to "android.test01",
                                LocalizationSheetParser.Platform.Web to "web.test01"
                            ),
                            values = mapOf(
                                "de" to "Test01",
                                "en" to "TBD"
                            ),
                            comment = "Test01 is used because de is the default language"
                        ),
                        LocalizationSheetParser.ParsedSheet.LocalizationEntry(
                            identifier = mapOf(
                                LocalizationSheetParser.Platform.iOS to "ios.test02",
                                LocalizationSheetParser.Platform.Android to "android.test02",
                                LocalizationSheetParser.Platform.Web to "web.test02"
                            ),
                            values = mapOf(
                                "de" to "Bitte drücken Sie \"Fortsetzen\"",
                                "en" to "Please press \"Continue\""
                            ),
                            comment = null
                        ),
                        LocalizationSheetParser.ParsedSheet.LocalizationEntry(
                            identifier = mapOf(
                                LocalizationSheetParser.Platform.iOS to "ios.test03",
                                LocalizationSheetParser.Platform.Android to "android.test03",
                                LocalizationSheetParser.Platform.Web to "web.test03"
                            ),
                            values = mapOf(
                                "de" to "Hallo",
                                "en" to null
                            ),
                            comment = "Hallo is used because de is the default language"
                        ),
                        LocalizationSheetParser.ParsedSheet.LocalizationEntry(
                            identifier = mapOf(
                                LocalizationSheetParser.Platform.iOS to "continue",
                                LocalizationSheetParser.Platform.Android to "continue",
                                LocalizationSheetParser.Platform.Web to "continue"
                            ),
                            values = mapOf(
                                "de" to "Continue test",
                                "en" to "Continue test"
                            ),
                            comment = "Continue is supported as a Variable name "
                        ),
                        LocalizationSheetParser.ParsedSheet.LocalizationEntry(
                            identifier = mapOf(
                                LocalizationSheetParser.Platform.iOS to "switch",
                                LocalizationSheetParser.Platform.Android to "switch",
                                LocalizationSheetParser.Platform.Web to "switch"
                            ),
                            values = mapOf(
                                "de" to "Switch test",
                                "en" to "Switch test"
                            ),
                            comment = "Switch is supported as a Variable name "
                        ),
                        LocalizationSheetParser.ParsedSheet.LocalizationEntry(
                            identifier = mapOf(
                                LocalizationSheetParser.Platform.iOS to "ios.test04",
                                LocalizationSheetParser.Platform.Android to "android.test04",
                                LocalizationSheetParser.Platform.Web to "web.test04"
                            ),
                            values = mapOf(
                                "de" to "Los geht's",
                                "en" to "Los geht's"
                            ),
                            comment = "\"'\"test for Android"
                        ),
                        LocalizationSheetParser.ParsedSheet.LocalizationEntry(
                            identifier = mapOf(
                                LocalizationSheetParser.Platform.iOS to "viewController.purchaseButton.title",
                                LocalizationSheetParser.Platform.Android to "viewController.purchaseButton.title",
                                LocalizationSheetParser.Platform.Web to "viewController.purchaseButton.title"
                            ),
                            values = mapOf(
                                "de" to "upcase, downcase test ",
                                "en" to "upcase, downcase test "
                            ),
                            comment = null
                        ),
                        LocalizationSheetParser.ParsedSheet.LocalizationEntry(
                            identifier = mapOf(
                                LocalizationSheetParser.Platform.iOS to "simulation.time.hour",
                                LocalizationSheetParser.Platform.Android to "simulation.time.hour",
                                LocalizationSheetParser.Platform.Web to "NR"
                            ),
                            values = mapOf(
                                "de" to "one|%d Stunde\nother|%d Stunden",
                                "en" to "one|%d Hour\nother|%d Hours"
                            ),
                            comment = "Plurals example "
                        ),
                        LocalizationSheetParser.ParsedSheet.LocalizationEntry(
                            identifier = mapOf(
                                LocalizationSheetParser.Platform.iOS to "simulation.time.hour1",
                                LocalizationSheetParser.Platform.Android to null,
                                LocalizationSheetParser.Platform.Web to "NR"
                            ),
                            values = mapOf(
                                "de" to "one|%d Stunde\nother|%d Stunden",
                                "en" to null
                            ),
                            comment = null
                        ),
                        LocalizationSheetParser.ParsedSheet.LocalizationEntry(
                            identifier = mapOf(
                                LocalizationSheetParser.Platform.iOS to "ios.test05",
                                LocalizationSheetParser.Platform.Android to "android.test05",
                                LocalizationSheetParser.Platform.Web to "web.test05"
                            ),
                            values = mapOf(
                                "de" to "Es ist ein %s",
                                "en" to "It is a %s"
                            ),
                            comment = "Always use %s for strings, on iOS its converted to %@"
                        ),
                        LocalizationSheetParser.ParsedSheet.LocalizationEntry(
                            identifier = mapOf(
                                LocalizationSheetParser.Platform.iOS to "TBD",
                                LocalizationSheetParser.Platform.Android to "TBD",
                                LocalizationSheetParser.Platform.Web to "TBD"
                            ),
                            values = mapOf(
                                "de" to "hallo",
                                "en" to "hi"
                            ),
                            comment = "Test TBD"
                        ),
                        LocalizationSheetParser.ParsedSheet.LocalizationEntry(
                            identifier = mapOf(
                                LocalizationSheetParser.Platform.iOS to "NR",
                                LocalizationSheetParser.Platform.Android to "NR",
                                LocalizationSheetParser.Platform.Web to "NR"
                            ),
                            values = mapOf(
                                "de" to "hallo",
                                "en" to "hi"
                            ),
                            comment = "Test NR"
                        ),
                        LocalizationSheetParser.ParsedSheet.LocalizationEntry(
                            identifier = mapOf(
                                LocalizationSheetParser.Platform.iOS to "NR",
                                LocalizationSheetParser.Platform.Android to "strings.array.test",
                                LocalizationSheetParser.Platform.Web to "NR"
                            ),
                            values = mapOf(
                                "de" to "[\"test0\", \"test1\", \"test2\"]",
                                "en" to "[\"test0\", \"test1\", \"test2\"]"
                            ),
                            comment = "String array example"
                        ),
                        LocalizationSheetParser.ParsedSheet.LocalizationEntry(
                            identifier = mapOf(
                                LocalizationSheetParser.Platform.iOS to "ios.test06",
                                LocalizationSheetParser.Platform.Android to "android.test06",
                                LocalizationSheetParser.Platform.Web to "NR"
                            ),
                            values = mapOf(
                                "de" to "Links oder Rechts doppelklicken, um %d Sekunden zu überspringen",
                                "en" to "Double-click left or right to skip %d seconds."
                            ),
                            comment = null
                        ),
                        LocalizationSheetParser.ParsedSheet.LocalizationEntry(
                            identifier = mapOf(
                                LocalizationSheetParser.Platform.iOS to "NR",
                                LocalizationSheetParser.Platform.Android to "strings.array.test1",
                                LocalizationSheetParser.Platform.Web to "NR"
                            ),
                            values = mapOf(
                                "de" to "[\"Message vocal\",\"Message d'image\",\"Message d'emplacement\"]",
                                "en" to "[\"Message vocal\",\"Message d'image\",\"Message d'emplacement\"]"
                            ),
                            comment = "Test array with '"
                        ),
                        LocalizationSheetParser.ParsedSheet.LocalizationEntry(
                            identifier = mapOf(
                                LocalizationSheetParser.Platform.iOS to "i_am_a_test",
                                LocalizationSheetParser.Platform.Android to null,
                                LocalizationSheetParser.Platform.Web to null
                            ),
                            values = mapOf(
                                "de" to "snake_case",
                                "en" to null
                            ),
                            comment = null
                        )
                    )
                ),
                LocalizationSheetParser.ParsedSheet.WorkSheet(
                    title = "_Template2", entries = listOf(
                        LocalizationSheetParser.ParsedSheet.LocalizationEntry(
                            identifier = mapOf(
                                LocalizationSheetParser.Platform.iOS to "template2.example.example.test",
                                LocalizationSheetParser.Platform.Android to "template2.example.example",
                                LocalizationSheetParser.Platform.Web to "template2.example.example"
                            ),
                            values = mapOf(
                                "de" to "Mario hat %1s eine %2s gegessen",
                                "en" to "Mario ate a %2s %1s"
                            ),
                            comment = "beispiel beispiel"
                        )
                    )
                )
            )
        )

        val values = transformer.transformForLanguage(
            language = "de",
            parsedSheet = realExampleParsedSheet
        )

        val expected = listOf(
            ParsedSheetToAndroidTransformer.AndroidValue.Plain(
                identifier = "example.example",
                value = "Mario hat %1s eine %2s gegessen",
                comment = "beispiel beispiel"
            ),
            ParsedSheetToAndroidTransformer.AndroidValue.Plain(
                identifier = "TBD",
                value = "Mario hat %1d eine %2d gegessen",
                comment = null
            ),
            ParsedSheetToAndroidTransformer.AndroidValue.Plain(
                identifier = "android.test01",
                value = "Test01",
                comment = "Test01 is used because de is the default language"
            ),
            ParsedSheetToAndroidTransformer.AndroidValue.Plain(
                identifier = "android.test02",
                value = "Bitte drücken Sie \"Fortsetzen\"",
                comment = null
            ),
            ParsedSheetToAndroidTransformer.AndroidValue.Plain(
                identifier = "android.test03",
                value = "Hallo",
                comment = "Hallo is used because de is the default language"
            ),
            ParsedSheetToAndroidTransformer.AndroidValue.Plain(
                identifier = "continue",
                value = "Continue test",
                comment = "Continue is supported as a Variable name "
            ),
            ParsedSheetToAndroidTransformer.AndroidValue.Plain(
                identifier = "switch",
                value = "Switch test",
                comment = "Switch is supported as a Variable name "
            ),
            ParsedSheetToAndroidTransformer.AndroidValue.Plain(
                identifier = "android.test04", value = "Los geht's", comment = "\"'\"test for Android"
            ),
            ParsedSheetToAndroidTransformer.AndroidValue.Plain(
                identifier = "viewController.purchaseButton.title", value = "upcase, downcase test ", comment = null
            ),
            ParsedSheetToAndroidTransformer.AndroidValue.Plural(
                identifier = "simulation.time.hour",
                entries = listOf("one" to "%d Stunde", "other" to "%d Stunden"),
                comment = "Plurals example "
            ),
            ParsedSheetToAndroidTransformer.AndroidValue.Plain(
                identifier = "android.test05",
                value = "Es ist ein %s",
                comment = "Always use %s for strings, on iOS its converted to %@"
            ),
            ParsedSheetToAndroidTransformer.AndroidValue.Plain(
                identifier = "TBD",
                value = "hallo",
                comment = "Test TBD"
            ),
            ParsedSheetToAndroidTransformer.AndroidValue.Plain(identifier = "NR", value = "hallo", comment = "Test NR"),
            ParsedSheetToAndroidTransformer.AndroidValue.Array(
                identifier = "strings.array.test",
                values = listOf("test0", "test1", "test2"),
                comment = "String array example"
            ),
            ParsedSheetToAndroidTransformer.AndroidValue.Plain(
                identifier = "android.test06",
                value = "Links oder Rechts doppelklicken, um %d Sekunden zu überspringen",
                comment = null
            ),
            ParsedSheetToAndroidTransformer.AndroidValue.Array(
                identifier = "strings.array.test1",
                values = listOf("Message vocal", "Message d'image", "Message d'emplacement"),
                comment = "Test array with '"
            ),
            ParsedSheetToAndroidTransformer.AndroidValue.Plain(
                identifier = "template2.example.example",
                value = "Mario hat %1s eine %2s gegessen",
                comment = "beispiel beispiel"
            )
        )

        values shouldBeEqualTo expected
    }

    @Test
    fun `parsed real example sheet extracts correct english values`() {
        val realExampleParsedSheet = LocalizationSheetParser.ParsedSheet(
            worksheets = listOf(
                LocalizationSheetParser.ParsedSheet.WorkSheet(
                    title = "_Template",
                    entries = listOf(
                        LocalizationSheetParser.ParsedSheet.LocalizationEntry(
                            identifier = mapOf(
                                LocalizationSheetParser.Platform.iOS to "example.example.test",
                                LocalizationSheetParser.Platform.Android to "example.example",
                                LocalizationSheetParser.Platform.Web to "example.example"
                            ),
                            values = mapOf(
                                "de" to "Mario hat %1s eine %2s gegessen",
                                "en" to "Mario ate a %2s %1s"
                            ),
                            comment = "beispiel beispiel"
                        ),
                        LocalizationSheetParser.ParsedSheet.LocalizationEntry(
                            identifier = mapOf(
                                LocalizationSheetParser.Platform.iOS to "hallo.test",
                                LocalizationSheetParser.Platform.Android to "TBD",
                                LocalizationSheetParser.Platform.Web to "TBD"
                            ),
                            values = mapOf(
                                "de" to "Mario hat %1d eine %2d gegessen",
                                "en" to "Mario ate a %2d %1d"
                            ),
                            comment = null
                        ),
                        LocalizationSheetParser.ParsedSheet.LocalizationEntry(
                            identifier = mapOf(
                                LocalizationSheetParser.Platform.iOS to "ios.test01",
                                LocalizationSheetParser.Platform.Android to "android.test01",
                                LocalizationSheetParser.Platform.Web to "web.test01"
                            ),
                            values = mapOf(
                                "de" to "Test01",
                                "en" to "TBD"
                            ),
                            comment = "Test01 is used because de is the default language"
                        ),
                        LocalizationSheetParser.ParsedSheet.LocalizationEntry(
                            identifier = mapOf(
                                LocalizationSheetParser.Platform.iOS to "ios.test02",
                                LocalizationSheetParser.Platform.Android to "android.test02",
                                LocalizationSheetParser.Platform.Web to "web.test02"
                            ),
                            values = mapOf(
                                "de" to "Bitte drücken Sie \"Fortsetzen\"",
                                "en" to "Please press \"Continue\""
                            ),
                            comment = null
                        ),
                        LocalizationSheetParser.ParsedSheet.LocalizationEntry(
                            identifier = mapOf(
                                LocalizationSheetParser.Platform.iOS to "ios.test03",
                                LocalizationSheetParser.Platform.Android to "android.test03",
                                LocalizationSheetParser.Platform.Web to "web.test03"
                            ),
                            values = mapOf(
                                "de" to "Hallo",
                                "en" to null
                            ),
                            comment = "Hallo is used because de is the default language"
                        ),
                        LocalizationSheetParser.ParsedSheet.LocalizationEntry(
                            identifier = mapOf(
                                LocalizationSheetParser.Platform.iOS to "continue",
                                LocalizationSheetParser.Platform.Android to "continue",
                                LocalizationSheetParser.Platform.Web to "continue"
                            ),
                            values = mapOf(
                                "de" to "Continue test",
                                "en" to "Continue test"
                            ),
                            comment = "Continue is supported as a Variable name "
                        ),
                        LocalizationSheetParser.ParsedSheet.LocalizationEntry(
                            identifier = mapOf(
                                LocalizationSheetParser.Platform.iOS to "switch",
                                LocalizationSheetParser.Platform.Android to "switch",
                                LocalizationSheetParser.Platform.Web to "switch"
                            ),
                            values = mapOf(
                                "de" to "Switch test",
                                "en" to "Switch test"
                            ),
                            comment = "Switch is supported as a Variable name "
                        ),
                        LocalizationSheetParser.ParsedSheet.LocalizationEntry(
                            identifier = mapOf(
                                LocalizationSheetParser.Platform.iOS to "ios.test04",
                                LocalizationSheetParser.Platform.Android to "android.test04",
                                LocalizationSheetParser.Platform.Web to "web.test04"
                            ),
                            values = mapOf(
                                "de" to "Los geht's",
                                "en" to "Los geht's"
                            ),
                            comment = "\"'\"test for Android"
                        ),
                        LocalizationSheetParser.ParsedSheet.LocalizationEntry(
                            identifier = mapOf(
                                LocalizationSheetParser.Platform.iOS to "viewController.purchaseButton.title",
                                LocalizationSheetParser.Platform.Android to "viewController.purchaseButton.title",
                                LocalizationSheetParser.Platform.Web to "viewController.purchaseButton.title"
                            ),
                            values = mapOf(
                                "de" to "upcase, downcase test ",
                                "en" to "upcase, downcase test "
                            ),
                            comment = null
                        ),
                        LocalizationSheetParser.ParsedSheet.LocalizationEntry(
                            identifier = mapOf(
                                LocalizationSheetParser.Platform.iOS to "simulation.time.hour",
                                LocalizationSheetParser.Platform.Android to "simulation.time.hour",
                                LocalizationSheetParser.Platform.Web to "NR"
                            ),
                            values = mapOf(
                                "de" to "one|%d Stunde\nother|%d Stunden",
                                "en" to "one|%d Hour\nother|%d Hours"
                            ),
                            comment = "Plurals example "
                        ),
                        LocalizationSheetParser.ParsedSheet.LocalizationEntry(
                            identifier = mapOf(
                                LocalizationSheetParser.Platform.iOS to "simulation.time.hour1",
                                LocalizationSheetParser.Platform.Android to null,
                                LocalizationSheetParser.Platform.Web to "NR"
                            ),
                            values = mapOf(
                                "de" to "one|%d Stunde\nother|%d Stunden",
                                "en" to null
                            ),
                            comment = null
                        ),
                        LocalizationSheetParser.ParsedSheet.LocalizationEntry(
                            identifier = mapOf(
                                LocalizationSheetParser.Platform.iOS to "ios.test05",
                                LocalizationSheetParser.Platform.Android to "android.test05",
                                LocalizationSheetParser.Platform.Web to "web.test05"
                            ),
                            values = mapOf(
                                "de" to "Es ist ein %s",
                                "en" to "It is a %s"
                            ),
                            comment = "Always use %s for strings, on iOS its converted to %@"
                        ),
                        LocalizationSheetParser.ParsedSheet.LocalizationEntry(
                            identifier = mapOf(
                                LocalizationSheetParser.Platform.iOS to "TBD",
                                LocalizationSheetParser.Platform.Android to "TBD",
                                LocalizationSheetParser.Platform.Web to "TBD"
                            ),
                            values = mapOf(
                                "de" to "hallo",
                                "en" to "hi"
                            ),
                            comment = "Test TBD"
                        ),
                        LocalizationSheetParser.ParsedSheet.LocalizationEntry(
                            identifier = mapOf(
                                LocalizationSheetParser.Platform.iOS to "NR",
                                LocalizationSheetParser.Platform.Android to "NR",
                                LocalizationSheetParser.Platform.Web to "NR"
                            ),
                            values = mapOf(
                                "de" to "hallo",
                                "en" to "hi"
                            ),
                            comment = "Test NR"
                        ),
                        LocalizationSheetParser.ParsedSheet.LocalizationEntry(
                            identifier = mapOf(
                                LocalizationSheetParser.Platform.iOS to "NR",
                                LocalizationSheetParser.Platform.Android to "strings.array.test",
                                LocalizationSheetParser.Platform.Web to "NR"
                            ),
                            values = mapOf(
                                "de" to "[\"test0\", \"test1\", \"test2\"]",
                                "en" to "[\"test0\", \"test1\", \"test2\"]"
                            ),
                            comment = "String array example"
                        ),
                        LocalizationSheetParser.ParsedSheet.LocalizationEntry(
                            identifier = mapOf(
                                LocalizationSheetParser.Platform.iOS to "ios.test06",
                                LocalizationSheetParser.Platform.Android to "android.test06",
                                LocalizationSheetParser.Platform.Web to "NR"
                            ),
                            values = mapOf(
                                "de" to "Links oder Rechts doppelklicken, um %d Sekunden zu überspringen",
                                "en" to "Double-click left or right to skip %d seconds."
                            ),
                            comment = null
                        ),
                        LocalizationSheetParser.ParsedSheet.LocalizationEntry(
                            identifier = mapOf(
                                LocalizationSheetParser.Platform.iOS to "NR",
                                LocalizationSheetParser.Platform.Android to "strings.array.test1",
                                LocalizationSheetParser.Platform.Web to "NR"
                            ),
                            values = mapOf(
                                "de" to "[\"Message vocal\",\"Message d'image\",\"Message d'emplacement\"]",
                                "en" to "[\"Message vocal\",\"Message d'image\",\"Message d'emplacement\"]"
                            ),
                            comment = "Test array with '"
                        ),
                        LocalizationSheetParser.ParsedSheet.LocalizationEntry(
                            identifier = mapOf(
                                LocalizationSheetParser.Platform.iOS to "i_am_a_test",
                                LocalizationSheetParser.Platform.Android to null,
                                LocalizationSheetParser.Platform.Web to null
                            ),
                            values = mapOf(
                                "de" to "snake_case",
                                "en" to null
                            ),
                            comment = null
                        )
                    )
                ),
                LocalizationSheetParser.ParsedSheet.WorkSheet(
                    title = "_Template2", entries = listOf(
                        LocalizationSheetParser.ParsedSheet.LocalizationEntry(
                            identifier = mapOf(
                                LocalizationSheetParser.Platform.iOS to "template2.example.example.test",
                                LocalizationSheetParser.Platform.Android to "template2.example.example",
                                LocalizationSheetParser.Platform.Web to "template2.example.example"
                            ),
                            values = mapOf(
                                "de" to "Mario hat %1s eine %2s gegessen",
                                "en" to "Mario ate a %2s %1s"
                            ),
                            comment = "beispiel beispiel"
                        )
                    )
                )
            )
        )

        val values = transformer.transformForLanguage(
            language = "en",
            parsedSheet = realExampleParsedSheet
        )
        val expected = listOf(
            ParsedSheetToAndroidTransformer.AndroidValue.Plain(
                identifier = "example.example",
                value = "Mario ate a %2s %1s",
                comment = "beispiel beispiel"
            ),
            ParsedSheetToAndroidTransformer.AndroidValue.Plain(
                identifier = "TBD",
                value = "Mario ate a %2d %1d",
                comment = null
            ),
            ParsedSheetToAndroidTransformer.AndroidValue.Plain(
                identifier = "android.test01",
                value = "TBD",
                comment = "Test01 is used because de is the default language"
            ),
            ParsedSheetToAndroidTransformer.AndroidValue.Plain(
                identifier = "android.test02",
                value = "Please press \"Continue\"",
                comment = null
            ),
            ParsedSheetToAndroidTransformer.AndroidValue.Blank(
                identifier = "android.test03",
                comment = "Hallo is used because de is the default language"
            ),
            ParsedSheetToAndroidTransformer.AndroidValue.Plain(
                identifier = "continue",
                value = "Continue test",
                comment = "Continue is supported as a Variable name "
            ),
            ParsedSheetToAndroidTransformer.AndroidValue.Plain(
                identifier = "switch",
                value = "Switch test",
                comment = "Switch is supported as a Variable name "
            ),
            ParsedSheetToAndroidTransformer.AndroidValue.Plain(
                identifier = "android.test04",
                value = "Los geht's",
                comment = "\"'\"test for Android"
            ),
            ParsedSheetToAndroidTransformer.AndroidValue.Plain(
                identifier = "viewController.purchaseButton.title",
                value = "upcase, downcase test ",
                comment = null
            ),
            ParsedSheetToAndroidTransformer.AndroidValue.Plural(
                identifier = "simulation.time.hour",
                entries = listOf("one" to "%d Hour", "other" to "%d Hours"),
                comment = "Plurals example "
            ),
            ParsedSheetToAndroidTransformer.AndroidValue.Plain(
                identifier = "android.test05",
                value = "It is a %s",
                comment = "Always use %s for strings, on iOS its converted to %@"
            ),
            ParsedSheetToAndroidTransformer.AndroidValue.Plain(identifier = "TBD", value = "hi", comment = "Test TBD"),
            ParsedSheetToAndroidTransformer.AndroidValue.Plain(identifier = "NR", value = "hi", comment = "Test NR"),
            ParsedSheetToAndroidTransformer.AndroidValue.Array(
                identifier = "strings.array.test",
                values = listOf("test0", "test1", "test2"),
                comment = "String array example"
            ),
            ParsedSheetToAndroidTransformer.AndroidValue.Plain(
                identifier = "android.test06",
                value = "Double-click left or right to skip %d seconds.",
                comment = null
            ),
            ParsedSheetToAndroidTransformer.AndroidValue.Array(
                identifier = "strings.array.test1",
                values = listOf("Message vocal", "Message d'image", "Message d'emplacement"),
                comment = "Test array with '"
            ),
            ParsedSheetToAndroidTransformer.AndroidValue.Plain(
                identifier = "template2.example.example",
                value = "Mario ate a %2s %1s",
                comment = "beispiel beispiel"
            )
        )

        values shouldBeEqualTo expected
    }

}