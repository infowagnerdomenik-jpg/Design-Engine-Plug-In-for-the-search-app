import '../../layer1_raw/design_token.dart';
import '../../layer1_raw/dark/system.dart';
import '../../layer1_raw/dark/standard.dart';
import '../../layer1_raw/dark/blue.dart';
import '../../layer1_raw/dark/green.dart';
import '../../layer1_raw/dark/red.dart';
import '../../layer1_raw/dark/nothing.dart';

class EEronprimaryDark {
  static DesignToken getToken(dynamic activeTheme) {
    switch (activeTheme.toString().split('.').last) {
      case 'system': return csyd17;
      case 'standard': return cstd17;
      case 'blue': return cbd17;
      case 'green': return cgd17;
      case 'red': return crd17;
      case 'nothing': return cnod48;
      default: return cstd17;
    }
  }
}
