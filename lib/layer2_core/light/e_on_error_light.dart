import '../../layer1_raw/design_token.dart';
import '../../layer1_raw/light/system.dart';
import '../../layer1_raw/light/standard.dart';
import '../../layer1_raw/light/blue.dart';
import '../../layer1_raw/light/green.dart';
import '../../layer1_raw/light/red.dart';
import '../../layer1_raw/light/nothing.dart';

class EOnErrorLight {
  static DesignToken getToken(dynamic activeTheme) {
    switch (activeTheme.toString().split('.').last) {
      case 'system': return csyl42;
      case 'standard': return cstl42;
      case 'blue': return cbl42;
      case 'green': return cgl42;
      case 'red': return crl42;
      case 'nothing': return cnol42;
      default: return cstl42;
    }
  }
}
