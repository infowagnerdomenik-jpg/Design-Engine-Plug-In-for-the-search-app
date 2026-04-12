
import 'design_engine_platform_interface.dart';

class DesignEngine {
  Future<String?> getPlatformVersion() {
    return DesignEnginePlatform.instance.getPlatformVersion();
  }
}
