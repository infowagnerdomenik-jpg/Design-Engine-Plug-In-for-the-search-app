import '../../layer1_raw/design_token.dart';
import '../../layer1_raw/dark/system.dart';
import '../../layer1_raw/dark/standard.dart';
import '../../layer1_raw/dark/blue.dart';
import '../../layer1_raw/dark/green.dart';
import '../../layer1_raw/dark/red.dart';
import '../../layer1_raw/dark/nothing.dart';

class ESurfaceContainerHighDark {
  static DesignToken getToken(dynamic activeTheme) {
    switch (activeTheme.toString().split('.').last) {
      case 'system': return csyd12;
      case 'standard': return cstd12;
      case 'blue': return cbd12;
      case 'green': return cgd12;
      case 'red': return crd12;
      case 'nothing': return cnod12;
      default: return cstd12;
    }
  }
}
