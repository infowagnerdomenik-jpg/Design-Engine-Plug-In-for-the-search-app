import '../../layer1_raw/design_token.dart';
import '../../layer1_raw/dark/system.dart';
import '../../layer1_raw/dark/standard.dart';
import '../../layer1_raw/dark/blue.dart';
import '../../layer1_raw/dark/green.dart';
import '../../layer1_raw/dark/red.dart';
import '../../layer1_raw/dark/nothing.dart';

class ESecondaryDark {
  static DesignToken getToken(dynamic activeTheme) {
    switch (activeTheme.toString().split('.').last) {
      case 'system': return csyd25;
      case 'standard': return cstd25;
      case 'blue': return cbd25;
      case 'green': return cgd25;
      case 'red': return crd25;
      case 'nothing': return cnod25;
      default: return cstd25;
    }
  }
}
