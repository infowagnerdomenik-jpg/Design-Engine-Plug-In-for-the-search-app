import 'package:plugin_platform_interface/plugin_platform_interface.dart';

import 'design_engine_method_channel.dart';

abstract class DesignEnginePlatform extends PlatformInterface {
  /// Constructs a DesignEnginePlatform.
  DesignEnginePlatform() : super(token: _token);

  static final Object _token = Object();

  static DesignEnginePlatform _instance = MethodChannelDesignEngine();

  /// The default instance of [DesignEnginePlatform] to use.
  ///
  /// Defaults to [MethodChannelDesignEngine].
  static DesignEnginePlatform get instance => _instance;

  /// Platform-specific implementations should set this with their own
  /// platform-specific class that extends [DesignEnginePlatform] when
  /// they register themselves.
  static set instance(DesignEnginePlatform instance) {
    PlatformInterface.verifyToken(instance, _token);
    _instance = instance;
  }

  Future<String?> getPlatformVersion() {
    throw UnimplementedError('platformVersion() has not been implemented.');
  }
}
