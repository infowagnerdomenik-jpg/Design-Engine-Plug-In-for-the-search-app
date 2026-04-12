import '../../layer1_raw/design_token.dart';
import '../../layer1_raw/dark/system.dart';
import '../../layer1_raw/dark/standard.dart';
import '../../layer1_raw/dark/blue.dart';
import '../../layer1_raw/dark/green.dart';
import '../../layer1_raw/dark/red.dart';
import '../../layer1_raw/dark/nothing.dart';

class EOutlineDark {
  static DesignToken getToken(dynamic activeTheme) {
    switch (activeTheme.toString().split('.').last) {
      case 'system': return csyd45;
      case 'standard': return cstd45;
      case 'blue': return cbd45;
      case 'green': return cgd45;
      case 'red': return crd45;
      case 'nothing': return cnod45;
      default: return cstd45;
    }
  }
}
