import '../../layer1_raw/design_token.dart';
import '../../layer1_raw/dark/system.dart';
import '../../layer1_raw/dark/standard.dart';
import '../../layer1_raw/dark/blue.dart';
import '../../layer1_raw/dark/green.dart';
import '../../layer1_raw/dark/red.dart';
import '../../layer1_raw/dark/nothing.dart';

class EOnSecondaryContainerDark {
  static DesignToken getToken(dynamic activeTheme) {
    switch (activeTheme.toString().split('.').last) {
      case 'system': return csyd28;
      case 'standard': return cstd28;
      case 'blue': return cbd28;
      case 'green': return cgd28;
      case 'red': return crd28;
      case 'nothing': return cnod28;
      default: return cstd28;
    }
  }
}
