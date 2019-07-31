import java.io.*;

    public class textUtil {

        public static String readText(File file) {
            return readText(file, null);
        }

        public static String readText(File file, String charset) {
            FileInputStream in = null;
            ByteArrayOutputStream out = null;
            try {
                in = new FileInputStream(file);
                out = new ByteArrayOutputStream();
                byte[] data = new byte[1024];
                int p;
                while ((p = in.read(data)) != -1) {
                    out.write(data, 0, p);
                }
                if (charset == null) {
                    return out.toString();
                } else {
                    return new String(out.toByteArray(), charset);
                }
            } catch (IOException e) {
                e.printStackTrace();
                return "";
            } finally {
                if (in != null) {
                    try {
                        in.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (out != null) {
                    try {
                        out.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        public static void writeText(File file, String context) {
            writeText(file, context, null);
        }

        public static void writeText(File file, String context, String charset) {
            ByteArrayInputStream in = null;
            FileOutputStream out = null;
            try {
                if (charset == null) {
                    in = new ByteArrayInputStream(context.getBytes());
                } else {
                    in = new ByteArrayInputStream(context.getBytes(charset));
                }
                out = new FileOutputStream(file);
                byte[] data = new byte[1024];
                int p;
                while ((p = in.read(data)) != -1) {
                    out.write(data, 0, p);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (in != null) {
                    try {
                        in.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (out != null) {
                    try {
                        out.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }




