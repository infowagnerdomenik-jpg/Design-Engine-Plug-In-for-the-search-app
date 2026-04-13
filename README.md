<div align="center">
  <img src="https://raw.githubusercontent.com/infowagnerdomenik-jpg/Universal-Search-for-Android/main/assets/icons/original/Search_App_Icon.svg" width="120" alt="Universal Search Icon">
  
  <h1>Design Engine Plug-In</h1>
  <p><b>The core accent color switching framework powering the Universal Search ecosystem.</b></p>
  
  [![Android Support](https://img.shields.io/badge/Android-14_to_16_QPR2_(API_34--36.1)-3DDC84?style=for-the-badge&logo=android)](https://www.android.com/)
  [![Flutter](https://img.shields.io/badge/Flutter-UI_Framework-02569B?style=for-the-badge&logo=flutter)](https://flutter.dev/)
  <br><br>
</div>

---

## 🎨 What is this?

This repository contains the **Design Engine**, a specialized Flutter plug-in developed for the [Universal Search App](https://github.com/infowagnerdomenik-jpg/Universal-Search-for-Android).

It serves as the logical backbone for managing and applying different **color accent themes**. It allows the application to switch either dynamically with the Android system theme or to be manually overridden with a predefined selection of accent colors. This decouples the core color logic from the main application.

> [!NOTE]
> **Developer Resource:**
> This is a code-only plug-in. There is no polished final UI in this repository. Developers can use this as a reference or dependency to implement basic color accent switching logic.

---

## 📦 Ecosystem Overview

While this plug-in provides the color logic, the actual applications are found in the following repositories:

| Component | Type | Link |
| :--- | :--- | :--- |
| **Main Search App** | Android App (Flutter/Kotlin) | [View Repository](https://github.com/infowagnerdomenik-jpg/Universal-Search-for-Android) |
| **File Companion** | Android App (Kotlin) | [View Repository](https://github.com/infowagnerdomenik-jpg/Search-Files-Companion) |
| **Internet Companion** | Android App (Kotlin) | [View Repository](https://github.com/infowagnerdomenik-jpg/Search-Internet-Companion) |
| **Design Engine** | **Flutter Plug-In (Code)** | **[Current Repository](#)** |

---

## ✨ Features

Based strictly on the demonstration UI in this repository, the engine provides the following color management capabilities:

<table>
  <tr>
    <td width="50%">
      <b>🎨 Manual Color Overrides</b><br>
      Provides functionality to force the application to use specific accent colors: Standard, Red, Green, Blue, and a dedicated Nothing OS theme.
    </td>
    <td width="50%">
      <b>🔄 Dynamic System Integration</b><br>
      Supports inheriting the active accent color from the Android system theme, keeping the app consistent with the device’s dynamic coloring.
    </td>
  </tr>
</table>

---

## 🛠️ Usage for Developers

To use this color engine in your own Flutter environment:

1. Clone this repository.
2. Add the path to your `pubspec.yaml`:
   ```yaml
   dependencies:
     design_engine:
       path: ../Design-Engine-Plug-In-for-the-search-app
