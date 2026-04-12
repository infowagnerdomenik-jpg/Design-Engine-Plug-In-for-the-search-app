import '../../layer1_raw/design_token.dart';
import '../../layer1_raw/light/system.dart';
import '../../layer1_raw/light/standard.dart';
import '../../layer1_raw/light/blue.dart';
import '../../layer1_raw/light/green.dart';
import '../../layer1_raw/light/red.dart';
import '../../layer1_raw/light/nothing.dart';

class ESurfaceVariantLight {
  static DesignToken getToken(dynamic activeTheme) {
    switch (activeTheme.toString().split('.').last) {
      case 'system': return csyl5;
      case 'standard': return cstl5;
      case 'blue': return cbl5;
      case 'green': return cgl5;
      case 'red': return crl5;
      case 'nothing': return cnol5;
      default: return cstl5;
    }
  }
}
