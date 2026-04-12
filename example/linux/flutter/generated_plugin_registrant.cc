//
//  Generated file. Do not edit.
//

// clang-format off

#include "generated_plugin_registrant.h"

#include <design_engine/design_engine_plugin.h>
#include <dynamic_color/dynamic_color_plugin.h>

void fl_register_plugins(FlPluginRegistry* registry) {
  g_autoptr(FlPluginRegistrar) design_engine_registrar =
      fl_plugin_registry_get_registrar_for_plugin(registry, "DesignEnginePlugin");
  design_engine_plugin_register_with_registrar(design_engine_registrar);
  g_autoptr(FlPluginRegistrar) dynamic_color_registrar =
      fl_plugin_registry_get_registrar_for_plugin(registry, "DynamicColorPlugin");
  dynamic_color_plugin_register_with_registrar(dynamic_color_registrar);
}
