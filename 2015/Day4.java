class Day4 {
  public static void main(String[] args) {
    String key = "ckczppom";
    int i = 1;
    while (true) {
      String md = MD5(key + i);
      if (md.startsWith("000000")) {
        System.out.println(i);
        break;
      }
      i++;
    }
  }

  public static String MD5(String md5) {
   try {
        java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
        byte[] array = md.digest(md5.getBytes());
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < array.length; ++i) {
          sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1,3));
       }
        return sb.toString();
    } catch (java.security.NoSuchAlgorithmException e) {
    }
    return null;
}

}
