const fs = require('fs');
const path = "/run/host/data/Programierung/Projekte/Plugins/design_engine/android/src/main/kotlin/com/example/design_engine/layer3_logic/DesignEngineController.kt";

let content = fs.readFileSync(path, 'utf8');

// Use 'private set' to avoid naming clashes with manual setter functions
content = content.replace("var currentTheme by mutableStateOf(AppTheme.BLUE)", "var currentTheme by mutableStateOf(AppTheme.BLUE)\n        private set");
content = content.replace("var themeMode by mutableStateOf(ThemeMode.SYSTEM)", "var themeMode by mutableStateOf(ThemeMode.SYSTEM)\n        private set");
content = content.replace("var isAmoled by mutableStateOf(false)", "var isAmoled by mutableStateOf(false)\n        private set");

fs.writeFileSync(path, content);
console.log("Kotlin variable visibility fixed.");
