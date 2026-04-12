#ifndef FLUTTER_PLUGIN_DESIGN_ENGINE_PLUGIN_H_
#define FLUTTER_PLUGIN_DESIGN_ENGINE_PLUGIN_H_

#include <flutter/method_channel.h>
#include <flutter/plugin_registrar_windows.h>

#include <memory>

namespace design_engine {

class DesignEnginePlugin : public flutter::Plugin {
 public:
  static void RegisterWithRegistrar(flutter::PluginRegistrarWindows *registrar);

  DesignEnginePlugin();

  virtual ~DesignEnginePlugin();

  // Disallow copy and assign.
  DesignEnginePlugin(const DesignEnginePlugin&) = delete;
  DesignEnginePlugin& operator=(const DesignEnginePlugin&) = delete;

  // Called when a method is called on this plugin's channel from Dart.
  void HandleMethodCall(
      const flutter::MethodCall<flutter::EncodableValue> &method_call,
      std::unique_ptr<flutter::MethodResult<flutter::EncodableValue>> result);
};

}  // namespace design_engine

#endif  // FLUTTER_PLUGIN_DESIGN_ENGINE_PLUGIN_H_
