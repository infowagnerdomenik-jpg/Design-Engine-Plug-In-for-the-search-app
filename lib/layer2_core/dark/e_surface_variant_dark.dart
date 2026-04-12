import '../../layer1_raw/design_token.dart';
import '../../layer1_raw/dark/system.dart';
import '../../layer1_raw/dark/standard.dart';
import '../../layer1_raw/dark/blue.dart';
import '../../layer1_raw/dark/green.dart';
import '../../layer1_raw/dark/red.dart';
import '../../layer1_raw/dark/nothing.dart';

class ESurfaceVariantDark {
  static DesignToken getToken(dynamic activeTheme) {
    switch (activeTheme.toString().split('.').last) {
      case 'system': return csyd5;
      case 'standard': return cstd5;
      case 'blue': return cbd5;
      case 'green': return cgd5;
      case 'red': return crd5;
      case 'nothing': return cnod5;
      default: return cstd5;
    }
  }
}
