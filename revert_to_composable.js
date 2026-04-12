const fs = require('fs');

// We are going to revert Layer 3 and Layer 4 to the state BEFORE we tried passing the Context manually,
// because you specifically instructed me to use the `CompositionLocalProvider` bridge INSTEAD of changing the engine!

const controllerPath = "/run/host/data/Programierung/Projekte/Plugins/design_engine/android/src/main/kotlin/com/example/design_engine/layer3_logic/DesignEngineController.kt";
let content = fs.readFileSync(controllerPath, 'utf8');

// 1. Remove explicitContext from resolveToken
content = content.replace(/,\n\s*explicitContext: Context\? = null\n\s*\): Color/g, "\n    ): Color");
// Revert Context handling in resolveToken
content = content.replace(/val context = explicitContext \?: LocalContext\.current/g, "val context = LocalContext.current");
// Revert resolveMaterialCommand call
content = content.replace(/return resolveMaterialCommand\(command, dark, context\)/g, "return resolveMaterialCommand(command, dark)");

// 2. Remove explicitContext from resolveMaterialCommand
content = content.replace(/private fun resolveMaterialCommand\(command: String, isDark: Boolean, context: Context\): Color/g, "private fun resolveMaterialCommand(command: String, isDark: Boolean): Color");
content = content.replace(/val context = explicitContext \?: LocalContext\.current\n\s*/g, ""); // Remove the explicit context line inside if it exists, but we passed it as parameter. Wait, we changed the signature. Let's do a regex.
content = content.replace(/private fun resolveMaterialCommand\(command: String, isDark: Boolean, context: Context\)/g, "private fun resolveMaterialCommand(command: String, isDark: Boolean)");

// Actually, it's easier to just use the `regenerate_controller_kotlin_final_v2.js` script to regenerate it clean without the context changes.
