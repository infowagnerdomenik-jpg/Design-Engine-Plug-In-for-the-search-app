import '../../layer1_raw/design_token.dart';
import '../../layer1_raw/dark/system.dart';
import '../../layer1_raw/dark/standard.dart';
import '../../layer1_raw/dark/blue.dart';
import '../../layer1_raw/dark/green.dart';
import '../../layer1_raw/dark/red.dart';
import '../../layer1_raw/dark/nothing.dart';

class EPrimaryFixedDark {
  static DesignToken getToken(dynamic activeTheme) {
    switch (activeTheme.toString().split('.').last) {
      case 'system': return csyd20;
      case 'standard': return cstd20;
      case 'blue': return cbd20;
      case 'green': return cgd20;
      case 'red': return crd20;
      case 'nothing': return cnod20;
      default: return cstd20;
    }
  }
}
