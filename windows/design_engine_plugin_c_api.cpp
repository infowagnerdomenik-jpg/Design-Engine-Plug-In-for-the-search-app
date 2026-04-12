#include "include/design_engine/design_engine_plugin_c_api.h"

#include <flutter/plugin_registrar_windows.h>

#include "design_engine_plugin.h"

void DesignEnginePluginCApiRegisterWithRegistrar(
    FlutterDesktopPluginRegistrarRef registrar) {
  design_engine::DesignEnginePlugin::RegisterWithRegistrar(
      flutter::PluginRegistrarManager::GetInstance()
          ->GetRegistrar<flutter::PluginRegistrarWindows>(registrar));
}
