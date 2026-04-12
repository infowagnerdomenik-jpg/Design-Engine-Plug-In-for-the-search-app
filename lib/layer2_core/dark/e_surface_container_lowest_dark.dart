import '../../layer1_raw/design_token.dart';
import '../../layer1_raw/dark/system.dart';
import '../../layer1_raw/dark/standard.dart';
import '../../layer1_raw/dark/blue.dart';
import '../../layer1_raw/dark/green.dart';
import '../../layer1_raw/dark/red.dart';
import '../../layer1_raw/dark/nothing.dart';

class ESurfaceContainerLowestDark {
  static DesignToken getToken(dynamic activeTheme) {
    switch (activeTheme.toString().split('.').last) {
      case 'system': return csyd13;
      case 'standard': return cstd13;
      case 'blue': return cbd13;
      case 'green': return cgd13;
      case 'red': return crd13;
      case 'nothing': return cnod13;
      default: return cstd13;
    }
  }
}
