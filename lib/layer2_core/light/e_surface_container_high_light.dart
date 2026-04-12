import '../../layer1_raw/design_token.dart';
import '../../layer1_raw/light/system.dart';
import '../../layer1_raw/light/standard.dart';
import '../../layer1_raw/light/blue.dart';
import '../../layer1_raw/light/green.dart';
import '../../layer1_raw/light/red.dart';
import '../../layer1_raw/light/nothing.dart';

class ESurfaceContainerHighLight {
  static DesignToken getToken(dynamic activeTheme) {
    switch (activeTheme.toString().split('.').last) {
      case 'system': return csyl12;
      case 'standard': return cstl12;
      case 'blue': return cbl12;
      case 'green': return cgl12;
      case 'red': return crl12;
      case 'nothing': return cnol12;
      default: return cstl12;
    }
  }
}
