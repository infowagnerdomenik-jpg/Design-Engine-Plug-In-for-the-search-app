import '../../layer1_raw/design_token.dart';
import '../../layer1_raw/dark/system.dart';
import '../../layer1_raw/dark/standard.dart';
import '../../layer1_raw/dark/blue.dart';
import '../../layer1_raw/dark/green.dart';
import '../../layer1_raw/dark/red.dart';
import '../../layer1_raw/dark/nothing.dart';

class ESecondaryFixedDark {
  static DesignToken getToken(dynamic activeTheme) {
    switch (activeTheme.toString().split('.').last) {
      case 'system': return csyd29;
      case 'standard': return cstd29;
      case 'blue': return cbd29;
      case 'green': return cgd29;
      case 'red': return crd29;
      case 'nothing': return cnod29;
      default: return cstd29;
    }
  }
}
