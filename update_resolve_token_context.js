const fs = require('fs');
const path = "/run/host/data/Programierung/Projekte/Plugins/design_engine/android/src/main/kotlin/com/example/design_engine/layer3_logic/DesignEngineController.kt";

let content = fs.readFileSync(path, 'utf8');

// 1. Add android.content.Context import if missing
if (!content.includes("import android.content.Context")) {
    content = content.replace("import android.os.Build", "import android.content.Context\nimport android.os.Build");
}

// 2. Update resolveToken signature and implementation
const oldResolveTokenSignature = `    @Composable
    private fun resolveToken(
        name: String,
        lightRes: (AppTheme) -> Int,
        darkRes: (AppTheme) -> Int,
        systemInDarkTheme: Boolean
    ): Color {`;

const newResolveTokenSignature = `    @Composable
    private fun resolveToken(
        name: String,
        lightRes: (AppTheme) -> Int,
        darkRes: (AppTheme) -> Int,
        systemInDarkTheme: Boolean,
        explicitContext: Context? = null
    ): Color {`;

content = content.replace(oldResolveTokenSignature, newResolveTokenSignature);

// Update context usage inside resolveToken
const oldContextUsage = `        val resId = if (!dark) lightRes(activeTheme) else darkRes(activeTheme)
        val context = LocalContext.current
        val resType = try { context.resources.getResourceTypeName(resId) } catch(e: Exception) { "color" }`;

const newContextUsage = `        val resId = if (!dark) lightRes(activeTheme) else darkRes(activeTheme)
        val context = explicitContext ?: LocalContext.current
        val resType = try { context.resources.getResourceTypeName(resId) } catch(e: Exception) { "color" }`;

content = content.replace(oldContextUsage, newContextUsage);

// Update resolveMaterialCommand call inside resolveToken
const oldMaterialCall = `        if (resType == "string") {
            val command = context.getString(resId)
            return resolveMaterialCommand(command, dark) 
        }`;
// The existing code has:
//        if (resType == "string") {
//            val command = stringResource(id = resId)
//            return resolveMaterialCommand(command, dark) 
//        }
const oldMaterialCallActual = `        if (resType == "string") {
            val command = stringResource(id = resId)
            return resolveMaterialCommand(command, dark) 
        }`;

const newMaterialCallActual = `        if (resType == "string") {
            val command = context.getString(resId)
            return resolveMaterialCommand(command, dark, explicitContext) 
        }`;

content = content.replace(oldMaterialCallActual, newMaterialCallActual);

// Update colorResource call
const oldColorResourceCall = `        return colorResource(id = resId)`;
const newColorResourceCall = `        return Color(context.getColor(resId))`;
content = content.replace(oldColorResourceCall, newColorResourceCall);


// 3. Update resolveMaterialCommand signature and implementation
const oldMaterialCommandSignature = `    @Composable
    private fun resolveMaterialCommand(command: String, isDark: Boolean): Color {
        val context = LocalContext.current`;

const newMaterialCommandSignature = `    @Composable
    private fun resolveMaterialCommand(command: String, isDark: Boolean, explicitContext: Context? = null): Color {
        val context = explicitContext ?: LocalContext.current`;

content = content.replace(oldMaterialCommandSignature, newMaterialCommandSignature);


// 4. We also need to update ALL eprimaryForTheme / efprimaryForTheme / ewprimaryForTheme signatures to accept explicitContext
const primaryRegex = /(@Composable\s+fun e[few]?primaryForTheme\([^)]+\):\s*Color\s*\{)([\s\S]+?)(return colorResource\(id = resId\)\s*\})/g;

content = content.replace(primaryRegex, (match, signature, body, returnStmt) => {
    let newSignature = signature.replace("): Color {", ", explicitContext: Context? = null): Color {");
    let newBody = body.replace("val context = LocalContext.current", "val context = explicitContext ?: LocalContext.current");
    newBody = newBody.replace("stringResource(id = resId)", "context.getString(resId)");
    newBody = newBody.replace("resolveMaterialCommand(stringResource(id = resId), dark)", "resolveMaterialCommand(context.getString(resId), dark, explicitContext)");
    // Some bodies have different variable names or don't inline the call
    newBody = newBody.replace(/resolveMaterialCommand\(([^,]+),\s*dark\)/g, "resolveMaterialCommand($1, dark, explicitContext)");
    
    let newReturn = "return Color(context.getColor(resId))\n    }";
    return newSignature + newBody + newReturn;
});

// 5. Update ALL 150 getter functions to accept the context
// We need to match things like:
//    @Composable
//    fun ebackground(systemInDarkTheme: Boolean): Color {
//        return resolveToken("ebackground", EBackgroundLight::getResId, EBackgroundDark::getResId, systemInDarkTheme)
//    }

const methodsRegex = /(@Composable\s+fun [a-zA-Z0-9_]+\([^)]*\):\s*Color\s*\{[\s\S]+?\n    \})/g;

content = content.replace(methodsRegex, (match) => {
    if (match.includes("resolveToken") && !match.includes("private fun resolveToken")) {
        // Change signature
        let modified = match.replace("): Color {", ", explicitContext: Context? = null): Color {");
        
        // If it's a simple resolveToken call
        if (modified.includes("return resolveToken(")) {
             modified = modified.replace(/return resolveToken\("([^"]+)",([^,]+),([^,]+),([^)]+)\)/, 'return resolveToken("$1",$2,$3,$4, explicitContext)');
        }
        
        // If it's a Light/Dark method with direct colorResource
        if (modified.includes("val context = LocalContext.current")) {
             modified = modified.replace("val context = LocalContext.current", "val context = explicitContext ?: LocalContext.current");
             modified = modified.replace("stringResource(id = resId)", "context.getString(resId)");
             modified = modified.replace(/resolveMaterialCommand\(([^,]+),\s*(true|false)\)/, "resolveMaterialCommand($1, $2, explicitContext)");
             modified = modified.replace("return colorResource(id = resId)", "return Color(context.getColor(resId))");
        }
        return modified;
    }
    return match;
});

fs.writeFileSync(path, content);
console.log("DesignEngineController refactored for explicit Context.");
