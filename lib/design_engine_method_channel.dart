import 'package:flutter/foundation.dart';
import 'package:flutter/services.dart';

import 'design_engine_platform_interface.dart';

/// An implementation of [DesignEnginePlatform] that uses method channels.
class MethodChannelDesignEngine extends DesignEnginePlatform {
  /// The method channel used to interact with the native platform.
  @visibleForTesting
  final methodChannel = const MethodChannel('design_engine');

  @override
  Future<String?> getPlatformVersion() async {
    final version = await methodChannel.invokeMethod<String>(
      'getPlatformVersion',
    );
    return version;
  }
}
