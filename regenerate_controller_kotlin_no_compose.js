const fs = require('fs');

const tokens = [
    "Background", "On Background", "Surface", "On Surface", "Surface Variant",
    "On Surface Variant", "Inverse Surface", "Inverse On Surface", "Surface Bright",
    "Surface Dim", "Surface Container Low", "Surface Container High",
    "Surface Container Lowest", "Surface Container Highest", "Surface Container",
    "Primary", "On Primary", "Primary Container", "On Primary Container",
    "Primary Fixed", "Primary Fixed Dim", "On Primary Fixed", "On Primary Fixed Variant",
    "Inverse Primary", "Secondary", "On Secondary", "Secondary Container",
    "On Secondary Container", "Secondary Fixed", "Secondary Fixed Dim",
    "On Secondary Fixed", "On Secondary Fixed Variant", "Tertiary", "On Tertiary",
    "Tertiary Container", "On Tertiary Container", "Tertiary Fixed", "Tertiary Fixed Dim",
    "On Tertiary Fixed", "On Tertiary Fixed Variant", "Error", "On Error",
    "Error Container", "On Error Container", "Outline", "Outline Variant",
    "erPrimary", "erOnPrimary", "erPrimaryContainer", "erOnPrimaryContainer"
];

function getFullClassName(token, suffix) {
    let base = "";
    if (token.startsWith("er")) {
        base = "EEr" + token.slice(2).toLowerCase();
    } else {
        base = "E" + token.split(" ").map(word => word.charAt(0).toUpperCase() + word.slice(1)).join("");
    }
    return base + (suffix.charAt(0).toUpperCase() + suffix.slice(1));
}

function formatGetterName(token) {
    return "e" + token.toLowerCase().replace(/ /g, "");
}

const controllerPath = "/run/host/data/Programierung/Projekte/Plugins/design_engine/android/src/main/kotlin/com/example/design_engine/layer3_logic/DesignEngineController.kt";

let content = fs.readFileSync(controllerPath, 'utf8');

// We need to remove @Composable from all the Light and Dark functions inside DesignEngineController as well, 
// because they no longer depend on Compose if an explicit context is provided.
// The dynamic getters (which still use systemInDarkTheme without a context) can keep @Composable, but they don't even use Compose stuff anymore except LocalContext!
// ACTUALLY: Let's remove @Composable from ALL Light/Dark methods.

content = content.replace(/@Composable\n\s*fun ([a-zA-Z0-9_]+Light)\(explicitContext: Context\? = null\): Color/g, "fun $1(explicitContext: Context? = null): Color");
content = content.replace(/@Composable\n\s*fun ([a-zA-Z0-9_]+Dark)\(explicitContext: Context\? = null\): Color/g, "fun $1(explicitContext: Context? = null): Color");

// Also remove from resolveToken and resolveMaterialCommand
content = content.replace(/@Composable\n\s*private fun resolveToken/g, "private fun resolveToken");
content = content.replace(/@Composable\n\s*private fun resolveMaterialCommand/g, "private fun resolveMaterialCommand");

// We need to fix the case where LocalContext is called without @Composable.
// If explicitContext is null, we can't use LocalContext.current without @Composable.
// THIS IS THE CATCH. 
// If we remove @Composable, we CANNOT use LocalContext.current.
// So, we MUST require a non-null Context for non-Composable usage, OR keep the methods @Composable.

// Let's rethink. Your prompt says: "Die gute Nachricht: Wir müssen nicht eine einzige Zeile in deiner geliebten Schicht 3 oder 4 ändern! Wir bauen dem Widget einfach eine kleine Brücke"
