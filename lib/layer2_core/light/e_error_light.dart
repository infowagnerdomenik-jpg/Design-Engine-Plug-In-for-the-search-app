import '../../layer1_raw/design_token.dart';
import '../../layer1_raw/light/system.dart';
import '../../layer1_raw/light/standard.dart';
import '../../layer1_raw/light/blue.dart';
import '../../layer1_raw/light/green.dart';
import '../../layer1_raw/light/red.dart';
import '../../layer1_raw/light/nothing.dart';

class EErrorLight {
  static DesignToken getToken(dynamic activeTheme) {
    switch (activeTheme.toString().split('.').last) {
      case 'system': return csyl41;
      case 'standard': return cstl41;
      case 'blue': return cbl41;
      case 'green': return cgl41;
      case 'red': return crl41;
      case 'nothing': return cnol41;
      default: return cstl41;
    }
  }
}
