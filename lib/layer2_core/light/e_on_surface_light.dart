import '../../layer1_raw/design_token.dart';
import '../../layer1_raw/light/system.dart';
import '../../layer1_raw/light/standard.dart';
import '../../layer1_raw/light/blue.dart';
import '../../layer1_raw/light/green.dart';
import '../../layer1_raw/light/red.dart';
import '../../layer1_raw/light/nothing.dart';

class EOnSurfaceLight {
  static DesignToken getToken(dynamic activeTheme) {
    switch (activeTheme.toString().split('.').last) {
      case 'system': return csyl4;
      case 'standard': return cstl4;
      case 'blue': return cbl4;
      case 'green': return cgl4;
      case 'red': return crl4;
      case 'nothing': return cnol4;
      default: return cstl4;
    }
  }
}
