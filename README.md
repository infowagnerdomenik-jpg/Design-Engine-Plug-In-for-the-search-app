<div align="center">
  <img src="https://raw.githubusercontent.com/infowagnerdomenik-jpg/Universal-Search-for-Android/main/assets/icons/original/Search_App_Icon.svg" width="120" alt="Universal Search Icon">
  
  <h1>Design Engine Plug-In</h1>
  <p><b>The core UI & UX framework powering the Universal Search ecosystem.</b></p>
  
  [![Android Support](https://img.shields.io/badge/Android-14_to_16_QPR2_(API_34--36.1)-3DDC84?style=for-the-badge&logo=android)](https://www.android.com/)
  [![Flutter](https://img.shields.io/badge/Flutter-UI_Framework-02569B?style=for-the-badge&logo=flutter)](https://flutter.dev/)
  <br><br>
</div>

---

## 🎨 What is this?

This repository contains the **Design Engine**, a specialized Flutter plug-in developed to provide a consistent, highly customizable, and modern user interface for the [Universal Search App](https://github.com/infowagnerdomenik-jpg/Universal-Search-for-Android).

It acts as the "visual brain" of the ecosystem, managing everything from complex stacked-card layouts to granular transparency settings and AMOLED-ready dark modes. By separating the design logic into this plug-in, the main app remains lightweight and focused on orchestration.

> [!NOTE]
> **Developer Resource:**
> This is a code-only plug-in. There is no APK to install. Developers can use this repository as a reference or dependency to implement the same "Universal Search" design language in their own Flutter projects.

---

## 📦 Ecosystem Overview

While this plug-in provides the UI components, the actual applications are found in the following repositories:

| Component | Type | Link |
| :--- | :--- | :--- |
| **Main Search App** | Android App (Flutter/Kotlin) | [View Repository](https://github.com/infowagnerdomenik-jpg/Universal-Search-for-Android) |
| **File Companion** | Android App (Kotlin) | [View Repository](https://github.com/infowagnerdomenik-jpg/Search-Files-Companion) |
| **Internet Companion** | Android App (Kotlin) | [View Repository](https://github.com/infowagnerdomenik-jpg/Search-Internet-Companion) |
| **Design Engine** | **Flutter Plug-In (Code)** | **[Current Repository](#)** |

---

## ✨ Features

<table>
  <tr>
    <td width="50%">
      <b>🔳 Stacked Card System</b><br>
      A modular UI system that groups settings and results into elegant, overlapping cards, following the latest Google design standards.
    </td>
    <td width="50%">
      <b>🌗 AMOLED Intelligence</b><br>
      Built-in support for true black themes, ensuring maximum power efficiency and visual depth on modern OLED displays.
    </td>
  </tr>
  <tr>
    <td width="50%">
      <b>🎚️ Granular Customization</b><br>
      Provides the logic for real-time transparency adjustments, corner radius control, and dynamic layout reordering (Drag & Drop).
    </td>
    <td width="50%">
      <b>🚀 High-Performance Rendering</b><br>
      Optimized for Flutter to ensure that even with over 1,200 lines of UI logic, the interface remains stutter-free and responsive on API 34 through 36.1.
    </td>
  </tr>
</table>

---

## 🛠️ Usage for Developers

To use this engine in your own Flutter environment:

1. Clone this repository.
2. Add the path to your `pubspec.yaml`:
   ```yaml
   dependencies:
     design_engine:
       path: ../Design-Engine-Plug-In-for-the-search-app
   
