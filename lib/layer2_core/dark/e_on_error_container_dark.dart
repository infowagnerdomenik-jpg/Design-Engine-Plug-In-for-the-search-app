import '../../layer1_raw/design_token.dart';
import '../../layer1_raw/dark/system.dart';
import '../../layer1_raw/dark/standard.dart';
import '../../layer1_raw/dark/blue.dart';
import '../../layer1_raw/dark/green.dart';
import '../../layer1_raw/dark/red.dart';
import '../../layer1_raw/dark/nothing.dart';

class EOnErrorContainerDark {
  static DesignToken getToken(dynamic activeTheme) {
    switch (activeTheme.toString().split('.').last) {
      case 'system': return csyd44;
      case 'standard': return cstd44;
      case 'blue': return cbd44;
      case 'green': return cgd44;
      case 'red': return crd44;
      case 'nothing': return cnod44;
      default: return cstd44;
    }
  }
}
