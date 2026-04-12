import '../../layer1_raw/design_token.dart';
import '../../layer1_raw/dark/system.dart';
import '../../layer1_raw/dark/standard.dart';
import '../../layer1_raw/dark/blue.dart';
import '../../layer1_raw/dark/green.dart';
import '../../layer1_raw/dark/red.dart';
import '../../layer1_raw/dark/nothing.dart';

class EErrorContainerDark {
  static DesignToken getToken(dynamic activeTheme) {
    switch (activeTheme.toString().split('.').last) {
      case 'system': return csyd43;
      case 'standard': return cstd43;
      case 'blue': return cbd43;
      case 'green': return cgd43;
      case 'red': return crd43;
      case 'nothing': return cnod43;
      default: return cstd43;
    }
  }
}
