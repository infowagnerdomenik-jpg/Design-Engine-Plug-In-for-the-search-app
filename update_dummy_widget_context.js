const fs = require('fs');

const widgetPath = "/run/host/data/Programierung/Projekte/Plugins/design_engine/android/src/main/kotlin/com/example/design_engine/layer4_ui/DesignDummyWidget.kt";
let widgetContent = fs.readFileSync(widgetPath, 'utf8');

// Change property access to function calls with explicit Context
widgetContent = widgetContent.replace(/DesignEngineUI\.ewbackgroundLight/g, "DesignEngineUI.ewbackgroundLight(context)");
widgetContent = widgetContent.replace(/DesignEngineUI\.ewbackgroundDark/g, "DesignEngineUI.ewbackgroundDark(context)");
widgetContent = widgetContent.replace(/DesignEngineUI\.ewprimaryLight/g, "DesignEngineUI.ewprimaryLight(context)");
widgetContent = widgetContent.replace(/DesignEngineUI\.ewprimaryDark/g, "DesignEngineUI.ewprimaryDark(context)");
widgetContent = widgetContent.replace(/DesignEngineUI\.ewonbackgroundLight/g, "DesignEngineUI.ewonbackgroundLight(context)");
widgetContent = widgetContent.replace(/DesignEngineUI\.ewonbackgroundDark/g, "DesignEngineUI.ewonbackgroundDark(context)");

// Also we need to pass the context from provideGlance down to WidgetContent
widgetContent = widgetContent.replace(/WidgetContent\(isSystemDark\)/g, "WidgetContent(isSystemDark, context)");
widgetContent = widgetContent.replace(/private fun WidgetContent\(isDark: Boolean\)/g, "private fun WidgetContent(isDark: Boolean, context: Context)");

fs.writeFileSync(widgetPath, widgetContent);
console.log("Dummy Widget refactored for explicit Context.");
