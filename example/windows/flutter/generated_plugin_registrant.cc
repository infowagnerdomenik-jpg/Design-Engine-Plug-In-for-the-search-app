//
//  Generated file. Do not edit.
//

// clang-format off

#include "generated_plugin_registrant.h"

#include <design_engine/design_engine_plugin_c_api.h>
#include <dynamic_color/dynamic_color_plugin_c_api.h>

void RegisterPlugins(flutter::PluginRegistry* registry) {
  DesignEnginePluginCApiRegisterWithRegistrar(
      registry->GetRegistrarForPlugin("DesignEnginePluginCApi"));
  DynamicColorPluginCApiRegisterWithRegistrar(
      registry->GetRegistrarForPlugin("DynamicColorPluginCApi"));
}
