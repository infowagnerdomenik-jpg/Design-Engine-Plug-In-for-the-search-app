import '../../layer1_raw/design_token.dart';
import '../../layer1_raw/dark/system.dart';
import '../../layer1_raw/dark/standard.dart';
import '../../layer1_raw/dark/blue.dart';
import '../../layer1_raw/dark/green.dart';
import '../../layer1_raw/dark/red.dart';
import '../../layer1_raw/dark/nothing.dart';

class ETertiaryDark {
  static DesignToken getToken(dynamic activeTheme) {
    switch (activeTheme.toString().split('.').last) {
      case 'system': return csyd33;
      case 'standard': return cstd33;
      case 'blue': return cbd33;
      case 'green': return cgd33;
      case 'red': return crd33;
      case 'nothing': return cnod33;
      default: return cstd33;
    }
  }
}
