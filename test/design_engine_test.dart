import 'package:flutter_test/flutter_test.dart';
import 'package:design_engine/design_engine.dart';
import 'package:design_engine/design_engine_platform_interface.dart';
import 'package:design_engine/design_engine_method_channel.dart';
import 'package:plugin_platform_interface/plugin_platform_interface.dart';

class MockDesignEnginePlatform
    with MockPlatformInterfaceMixin
    implements DesignEnginePlatform {
  @override
  Future<String?> getPlatformVersion() => Future.value('42');
}

void main() {
  final DesignEnginePlatform initialPlatform = DesignEnginePlatform.instance;

  test('$MethodChannelDesignEngine is the default instance', () {
    expect(initialPlatform, isInstanceOf<MethodChannelDesignEngine>());
  });

  test('getPlatformVersion', () async {
    DesignEngine designEnginePlugin = DesignEngine();
    MockDesignEnginePlatform fakePlatform = MockDesignEnginePlatform();
    DesignEnginePlatform.instance = fakePlatform;

    expect(await designEnginePlugin.getPlatformVersion(), '42');
  });
}
