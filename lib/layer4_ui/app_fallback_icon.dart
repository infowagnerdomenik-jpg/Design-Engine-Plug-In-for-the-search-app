import 'package:flutter/material.dart';
// Importiert die Layer-4-Getter aus derselben Ebene
import 'design_engine_ui.dart';
import '../layer3_logic/design_engine_controller.dart';

class AppFallbackIcon extends StatelessWidget {
  final IconData icon;
  final double size;
  final double iconSize;
  final Color? backgroundColor;
  final Color? iconColor;

  const AppFallbackIcon({
    super.key,
    required this.icon,
    this.size = 44,
    this.iconSize = 22,
    this.backgroundColor,
    this.iconColor,
  });

  @override
  Widget build(BuildContext context) {
    return ListenableBuilder(
      listenable: DesignEngineController(),
      builder: (context, _) {
        final Color finalBgColor = backgroundColor ?? context.esurface;
        final Color finalIconColor = iconColor ?? context.eonbackground;

        return Container(
          width: size,
          height: size,
          decoration: BoxDecoration(
            color: finalBgColor,
            shape: BoxShape.circle,
          ),
          child: Center(
            child: Icon(
              icon,
              color: finalIconColor,
              size: iconSize,
            ),
          ),
        );
      },
    );
  }
}
