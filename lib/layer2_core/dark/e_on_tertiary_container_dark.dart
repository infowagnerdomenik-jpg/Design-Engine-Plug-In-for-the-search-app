import '../../layer1_raw/design_token.dart';
import '../../layer1_raw/dark/system.dart';
import '../../layer1_raw/dark/standard.dart';
import '../../layer1_raw/dark/blue.dart';
import '../../layer1_raw/dark/green.dart';
import '../../layer1_raw/dark/red.dart';
import '../../layer1_raw/dark/nothing.dart';

class EOnTertiaryContainerDark {
  static DesignToken getToken(dynamic activeTheme) {
    switch (activeTheme.toString().split('.').last) {
      case 'system': return csyd36;
      case 'standard': return cstd36;
      case 'blue': return cbd36;
      case 'green': return cgd36;
      case 'red': return crd36;
      case 'nothing': return cnod36;
      default: return cstd36;
    }
  }
}
