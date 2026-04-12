class DesignToken {
  final int? hexValue;
  final String? systemId;

  const DesignToken.hex(this.hexValue) : systemId = null;
  const DesignToken.system(this.systemId) : hexValue = null;

  bool get isSystem => systemId != null;
  bool get isHex => hexValue != null;
}
