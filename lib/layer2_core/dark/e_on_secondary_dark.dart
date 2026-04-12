import '../../layer1_raw/design_token.dart';
import '../../layer1_raw/dark/system.dart';
import '../../layer1_raw/dark/standard.dart';
import '../../layer1_raw/dark/blue.dart';
import '../../layer1_raw/dark/green.dart';
import '../../layer1_raw/dark/red.dart';
import '../../layer1_raw/dark/nothing.dart';

class EOnSecondaryDark {
  static DesignToken getToken(dynamic activeTheme) {
    switch (activeTheme.toString().split('.').last) {
      case 'system': return csyd26;
      case 'standard': return cstd26;
      case 'blue': return cbd26;
      case 'green': return cgd26;
      case 'red': return crd26;
      case 'nothing': return cnod26;
      default: return cstd26;
    }
  }
}
