import '../../layer1_raw/design_token.dart';
import '../../layer1_raw/dark/system.dart';
import '../../layer1_raw/dark/standard.dart';
import '../../layer1_raw/dark/blue.dart';
import '../../layer1_raw/dark/green.dart';
import '../../layer1_raw/dark/red.dart';
import '../../layer1_raw/dark/nothing.dart';

class ESecondaryContainerDark {
  static DesignToken getToken(dynamic activeTheme) {
    switch (activeTheme.toString().split('.').last) {
      case 'system': return csyd27;
      case 'standard': return cstd27;
      case 'blue': return cbd27;
      case 'green': return cgd27;
      case 'red': return crd27;
      case 'nothing': return cnod27;
      default: return cstd27;
    }
  }
}
