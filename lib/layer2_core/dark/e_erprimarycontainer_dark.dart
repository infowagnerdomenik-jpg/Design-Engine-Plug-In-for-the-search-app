import '../../layer1_raw/design_token.dart';
import '../../layer1_raw/dark/system.dart';
import '../../layer1_raw/dark/standard.dart';
import '../../layer1_raw/dark/blue.dart';
import '../../layer1_raw/dark/green.dart';
import '../../layer1_raw/dark/red.dart';
import '../../layer1_raw/dark/nothing.dart';

class EErprimarycontainerDark {
  static DesignToken getToken(dynamic activeTheme) {
    switch (activeTheme.toString().split('.').last) {
      case 'system': return csyd18;
      case 'standard': return cstd18;
      case 'blue': return cbd18;
      case 'green': return cgd18;
      case 'red': return crd18;
      case 'nothing': return cnod49;
      default: return cstd18;
    }
  }
}
