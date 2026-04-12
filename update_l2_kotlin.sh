#!/bin/bash
DIR="/run/host/data/Programierung/Projekte/Plugins/design_engine/android/src/main/kotlin/com/example/design_engine/layer2_core"
# Update Light
find "$DIR/light" -name "*.kt" -exec sed -i 's/AppTheme.SYSTEM -> R.color.csyl/AppTheme.SYSTEM -> R.string.csyl/g' {} +
# Update Dark
find "$DIR/dark" -name "*.kt" -exec sed -i 's/AppTheme.SYSTEM -> R.color.csyd/AppTheme.SYSTEM -> R.string.csyd/g' {} +
echo "Layer 2 Kotlin updated to use R.string for System theme."
