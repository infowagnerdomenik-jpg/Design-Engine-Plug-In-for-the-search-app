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

// We just need to re-run the EW addition script to add the ew methods back, but the V2 script already did it. Let me check.
// Actually the V2 script I ran was 'regenerate_controller_kotlin_final_v2.js' which I modified earlier to include 'ew'.
// Wait, I need to make sure the controller has the crash-proof 'lightColorScheme()' logic from 'regenerate_controller_kotlin_final_safe.js'.
