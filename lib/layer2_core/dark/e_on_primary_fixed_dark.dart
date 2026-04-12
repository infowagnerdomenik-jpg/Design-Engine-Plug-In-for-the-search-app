import '../../layer1_raw/design_token.dart';
import '../../layer1_raw/dark/system.dart';
import '../../layer1_raw/dark/standard.dart';
import '../../layer1_raw/dark/blue.dart';
import '../../layer1_raw/dark/green.dart';
import '../../layer1_raw/dark/red.dart';
import '../../layer1_raw/dark/nothing.dart';

class EOnPrimaryFixedDark {
  static DesignToken getToken(dynamic activeTheme) {
    switch (activeTheme.toString().split('.').last) {
      case 'system': return csyd22;
      case 'standard': return cstd22;
      case 'blue': return cbd22;
      case 'green': return cgd22;
      case 'red': return crd22;
      case 'nothing': return cnod22;
      default: return cstd22;
    }
  }
}
