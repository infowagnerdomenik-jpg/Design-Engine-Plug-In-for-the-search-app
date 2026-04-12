import '../../layer1_raw/design_token.dart';
import '../../layer1_raw/dark/system.dart';
import '../../layer1_raw/dark/standard.dart';
import '../../layer1_raw/dark/blue.dart';
import '../../layer1_raw/dark/green.dart';
import '../../layer1_raw/dark/red.dart';
import '../../layer1_raw/dark/nothing.dart';

class EErrorDark {
  static DesignToken getToken(dynamic activeTheme) {
    switch (activeTheme.toString().split('.').last) {
      case 'system': return csyd41;
      case 'standard': return cstd41;
      case 'blue': return cbd41;
      case 'green': return cgd41;
      case 'red': return crd41;
      case 'nothing': return cnod41;
      default: return cstd41;
    }
  }
}
