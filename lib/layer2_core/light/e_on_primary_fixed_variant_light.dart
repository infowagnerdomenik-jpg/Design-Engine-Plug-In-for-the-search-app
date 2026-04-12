import '../../layer1_raw/design_token.dart';
import '../../layer1_raw/light/system.dart';
import '../../layer1_raw/light/standard.dart';
import '../../layer1_raw/light/blue.dart';
import '../../layer1_raw/light/green.dart';
import '../../layer1_raw/light/red.dart';
import '../../layer1_raw/light/nothing.dart';

class EOnPrimaryFixedVariantLight {
  static DesignToken getToken(dynamic activeTheme) {
    switch (activeTheme.toString().split('.').last) {
      case 'system': return csyl23;
      case 'standard': return cstl23;
      case 'blue': return cbl23;
      case 'green': return cgl23;
      case 'red': return crl23;
      case 'nothing': return cnol23;
      default: return cstl23;
    }
  }
}
