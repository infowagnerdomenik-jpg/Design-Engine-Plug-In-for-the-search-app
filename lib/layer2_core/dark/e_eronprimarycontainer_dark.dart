import '../../layer1_raw/design_token.dart';
import '../../layer1_raw/dark/system.dart';
import '../../layer1_raw/dark/standard.dart';
import '../../layer1_raw/dark/blue.dart';
import '../../layer1_raw/dark/green.dart';
import '../../layer1_raw/dark/red.dart';
import '../../layer1_raw/dark/nothing.dart';

class EEronprimarycontainerDark {
  static DesignToken getToken(dynamic activeTheme) {
    switch (activeTheme.toString().split('.').last) {
      case 'system': return csyd19;
      case 'standard': return cstd19;
      case 'blue': return cbd19;
      case 'green': return cgd19;
      case 'red': return crd19;
      case 'nothing': return cnod50;
      default: return cstd19;
    }
  }
}
