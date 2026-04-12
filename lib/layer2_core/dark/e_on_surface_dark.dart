import '../../layer1_raw/design_token.dart';
import '../../layer1_raw/dark/system.dart';
import '../../layer1_raw/dark/standard.dart';
import '../../layer1_raw/dark/blue.dart';
import '../../layer1_raw/dark/green.dart';
import '../../layer1_raw/dark/red.dart';
import '../../layer1_raw/dark/nothing.dart';

class EOnSurfaceDark {
  static DesignToken getToken(dynamic activeTheme) {
    switch (activeTheme.toString().split('.').last) {
      case 'system': return csyd4;
      case 'standard': return cstd4;
      case 'blue': return cbd4;
      case 'green': return cgd4;
      case 'red': return crd4;
      case 'nothing': return cnod4;
      default: return cstd4;
    }
  }
}
