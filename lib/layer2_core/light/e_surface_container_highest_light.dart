import '../../layer1_raw/design_token.dart';
import '../../layer1_raw/light/system.dart';
import '../../layer1_raw/light/standard.dart';
import '../../layer1_raw/light/blue.dart';
import '../../layer1_raw/light/green.dart';
import '../../layer1_raw/light/red.dart';
import '../../layer1_raw/light/nothing.dart';

class ESurfaceContainerHighestLight {
  static DesignToken getToken(dynamic activeTheme) {
    switch (activeTheme.toString().split('.').last) {
      case 'system': return csyl14;
      case 'standard': return cstl14;
      case 'blue': return cbl14;
      case 'green': return cgl14;
      case 'red': return crl14;
      case 'nothing': return cnol14;
      default: return cstl14;
    }
  }
}
