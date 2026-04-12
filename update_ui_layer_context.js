const fs = require('fs');

const uiPath = "/run/host/data/Programierung/Projekte/Plugins/design_engine/android/src/main/kotlin/com/example/design_engine/layer4_ui/DesignEngineUI.kt";
let uiContent = fs.readFileSync(uiPath, 'utf8');

// The functions were created as:
// fun ebackground(context: Context? = null): Color = DesignEngineController.ebackground(isSystemInDarkTheme(), context)
// But isSystemInDarkTheme() requires a @Composable context. So we can't just pass the explicit context to it directly.
// The trick is: If the caller provides a Context (like a Widget), they shouldn't call the dynamic `ebackground()` which relies on Compose's `isSystemInDarkTheme()`.
// They should call `ebackgroundLight()` or `ebackgroundDark()` directly, which we already set up correctly.

// HOWEVER, the compiler error from before might have been because `DesignEngineUI` functions STILL had the `@Composable` annotation on the `Light` and `Dark` variants, which forces Compose context even when passing an explicit Context!

// Let's remove @Composable from ALL Light and Dark functions in DesignEngineUI, making them pure Kotlin functions that take a Context.
// We keep @Composable on the dynamic ones because they call `isSystemInDarkTheme()`.

uiContent = uiContent.replace(/@Composable\n\s*fun ([a-zA-Z0-9_]+Light)\(context: Context\? = null\): Color/g, "fun $1(context: Context? = null): Color");
uiContent = uiContent.replace(/@Composable\n\s*fun ([a-zA-Z0-9_]+Dark)\(context: Context\? = null\): Color/g, "fun $1(context: Context? = null): Color");

fs.writeFileSync(uiPath, uiContent);
console.log("UI Layer Composable annotations fixed.");
