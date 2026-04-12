import '../../layer1_raw/design_token.dart';
import '../../layer1_raw/dark/system.dart';
import '../../layer1_raw/dark/standard.dart';
import '../../layer1_raw/dark/blue.dart';
import '../../layer1_raw/dark/green.dart';
import '../../layer1_raw/dark/red.dart';
import '../../layer1_raw/dark/nothing.dart';

class EOnBackgroundDark {
  static DesignToken getToken(dynamic activeTheme) {
    switch (activeTheme.toString().split('.').last) {
      case 'system': return csyd2;
      case 'standard': return cstd2;
      case 'blue': return cbd2;
      case 'green': return cgd2;
      case 'red': return crd2;
      case 'nothing': return cnod2;
      default: return cstd2;
    }
  }
}
