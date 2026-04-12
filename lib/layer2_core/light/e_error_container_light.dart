import '../../layer1_raw/design_token.dart';
import '../../layer1_raw/light/system.dart';
import '../../layer1_raw/light/standard.dart';
import '../../layer1_raw/light/blue.dart';
import '../../layer1_raw/light/green.dart';
import '../../layer1_raw/light/red.dart';
import '../../layer1_raw/light/nothing.dart';

class EErrorContainerLight {
  static DesignToken getToken(dynamic activeTheme) {
    switch (activeTheme.toString().split('.').last) {
      case 'system': return csyl43;
      case 'standard': return cstl43;
      case 'blue': return cbl43;
      case 'green': return cgl43;
      case 'red': return crl43;
      case 'nothing': return cnol43;
      default: return cstl43;
    }
  }
}
