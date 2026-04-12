import '../../layer1_raw/design_token.dart';
import '../../layer1_raw/dark/system.dart';
import '../../layer1_raw/dark/standard.dart';
import '../../layer1_raw/dark/blue.dart';
import '../../layer1_raw/dark/green.dart';
import '../../layer1_raw/dark/red.dart';
import '../../layer1_raw/dark/nothing.dart';

class EOnErrorDark {
  static DesignToken getToken(dynamic activeTheme) {
    switch (activeTheme.toString().split('.').last) {
      case 'system': return csyd42;
      case 'standard': return cstd42;
      case 'blue': return cbd42;
      case 'green': return cgd42;
      case 'red': return crd42;
      case 'nothing': return cnod42;
      default: return cstd42;
    }
  }
}
