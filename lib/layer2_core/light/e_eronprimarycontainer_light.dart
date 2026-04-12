import '../../layer1_raw/design_token.dart';
import '../../layer1_raw/light/system.dart';
import '../../layer1_raw/light/standard.dart';
import '../../layer1_raw/light/blue.dart';
import '../../layer1_raw/light/green.dart';
import '../../layer1_raw/light/red.dart';
import '../../layer1_raw/light/nothing.dart';

class EEronprimarycontainerLight {
  static DesignToken getToken(dynamic activeTheme) {
    switch (activeTheme.toString().split('.').last) {
      case 'system': return csyl19;
      case 'standard': return cstl19;
      case 'blue': return cbl19;
      case 'green': return cgl19;
      case 'red': return crl19;
      case 'nothing': return cnol50;
      default: return cstl19;
    }
  }
}
