import '../../layer1_raw/design_token.dart';
import '../../layer1_raw/dark/system.dart';
import '../../layer1_raw/dark/standard.dart';
import '../../layer1_raw/dark/blue.dart';
import '../../layer1_raw/dark/green.dart';
import '../../layer1_raw/dark/red.dart';
import '../../layer1_raw/dark/nothing.dart';

class ETertiaryFixedDimDark {
  static DesignToken getToken(dynamic activeTheme) {
    switch (activeTheme.toString().split('.').last) {
      case 'system': return csyd38;
      case 'standard': return cstd38;
      case 'blue': return cbd38;
      case 'green': return cgd38;
      case 'red': return crd38;
      case 'nothing': return cnod38;
      default: return cstd38;
    }
  }
}
