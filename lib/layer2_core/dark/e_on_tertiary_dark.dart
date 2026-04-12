import '../../layer1_raw/design_token.dart';
import '../../layer1_raw/dark/system.dart';
import '../../layer1_raw/dark/standard.dart';
import '../../layer1_raw/dark/blue.dart';
import '../../layer1_raw/dark/green.dart';
import '../../layer1_raw/dark/red.dart';
import '../../layer1_raw/dark/nothing.dart';

class EOnTertiaryDark {
  static DesignToken getToken(dynamic activeTheme) {
    switch (activeTheme.toString().split('.').last) {
      case 'system': return csyd34;
      case 'standard': return cstd34;
      case 'blue': return cbd34;
      case 'green': return cgd34;
      case 'red': return crd34;
      case 'nothing': return cnod34;
      default: return cstd34;
    }
  }
}
