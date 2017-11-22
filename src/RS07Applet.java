import javax.swing.*;
import java.applet.AppletContext;
import java.applet.AppletStub;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class RS07Applet implements AppletStub {

    public static final boolean RSPS = true;

    private final String host = RSPS ? "127.0.0.1" : "oldschool5.runescape.com";

    private final Map<String, String> parameters = new HashMap<>();

    /**
     * The main entry point of the current application.
     *
     * @param args
     *            The command line arguments.
     * @throws IOException
     * @throws MalformedURLException
     */
    public static void main(final String[] args) throws Exception {
        final RS07Applet applet = new RS07Applet();
        applet.initialize();
        Client client = new Client();

        final JFrame frame = new JFrame("RuneX #157");

        frame.add(client);
        frame.setVisible(true);
        frame.setSize(775, 531);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        client.setStub(applet);
        client.init();
        client.start();
    }

    /**
     * Reads the parameters text file, and stores the parameters.
     *
     * @throws IOException
     * @throws MalformedURLException
     */
    private void initialize() throws IOException {
        parameters.put("11", "true");
        parameters.put("image", "http://www.runescape.com/img/rsp777/oldschool_ani.gif");
        parameters.put("12", "301");
        parameters.put("13", "");
        parameters.put("14", ".runescape.com");
        parameters.put("15", "0");
        parameters.put("java_arguments", "-Xmx256m -Xss2m -Dsun.java2d.noddraw=true -XX:CompileThreshold=1500 -Xincgc -XX:+UseConcMarkSweepGC -XX:+UseParNewGC");
        parameters.put("separate_jvm", "true");
        parameters.put("haveie6", "true");
        parameters.put("boxbgcolor", "black");
        parameters.put("1", "false");
        parameters.put("2", "0");
        parameters.put("3", "0");
        parameters.put("4", "http://www.runescape.com/g=oldscape/slr.ws?order=LPWM");
        parameters.put("centerimage", "true");
        parameters.put("5", "true");
        parameters.put("6", "5");
        parameters.put("7", "ElZAIrq5NpKN6D3mDdihco3oPeYN2KFy2DCquj7JMmECPmLrDP3Bnw");
        parameters.put("8", "0");
        parameters.put("9", "0");
        parameters.put("boxborder", "false");
        parameters.put("10", "13366");
    }

    /*
     * (non-Javadoc)
     *
     * @see java.applet.AppletStub#getParameter(java.lang.String)
     */
    @Override
    public String getParameter(final String paramName) {
        return parameters.get(paramName);
    }

    /*
     * (non-Javadoc)
     *
     * @see java.applet.AppletStub#getDocumentBase()
     */
    @Override
    public URL getDocumentBase() {
        return getCodeBase();
    }

    /*
     * (non-Javadoc)
     *
     * @see java.applet.AppletStub#getCodeBase()
     */
    @Override
    public URL getCodeBase() {
        try {
            return new URL("http://" + host);
        } catch (final MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.applet.AppletStub#isActive()
     */
    @Override
    public boolean isActive() {
        return true;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.applet.AppletStub#getAppletContext()
     */
    @Override
    public AppletContext getAppletContext() {
        return null;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.applet.AppletStub#appletResize(int, int)
     */
    @Override
    public void appletResize(final int width, final int height) {
    }

    public class Crawler {

        /**
         * Map of general configs
         */
        private final Map<String, String> configs = new HashMap<>();

        /**
         * Map of msg configs
         */
        private final Map<String, String> msgs = new HashMap<>();

        /**
         * Map of param configs
         */
        private final Map<String, String> params = new HashMap<>();

        /**
         * Stores the configs from the jav_config
         *
         * @throws IOException
         */
        public void crawl() throws IOException {
            final URL url = new URL("http://oldschool.runescape.com/jav_config.ws");
            final HttpURLConnection con = (HttpURLConnection) url.openConnection();

            try (BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()))) {
                String line;
                String key;
                String value;
                while ((line = reader.readLine()) != null) {
                    int index = line.indexOf('=');

                    if (line.startsWith("msg")) {
                        line = line.substring(index + 1);
                        index = line.indexOf('=');

                        key = line.substring(0, index);
                        value = line.substring(index + 1);
                        msgs.put(key, value);
                    } else if (line.startsWith("param")) {
                        line = line.substring(index + 1);
                        index = line.indexOf('=');

                        key = line.substring(0, index);
                        value = line.substring(index + 1);
                        params.put(key, value);
                    } else {
                        key = line.substring(0, index);
                        value = line.substring(index + 1);
                        configs.put(key, value);
                    }
                }
            }
        }

        /**
         * Downloads and saves the gamepack. Also saves the configs
         *
         * @return
         * @throws IOException
         */
        public String download() throws IOException {
            final String gamepack = configs.get("initial_jar");
            final URL url = new URL(configs.get("codebase") + gamepack);

            final int hash = Integer.valueOf(gamepack.substring(gamepack.indexOf('_') + 1, gamepack.indexOf('.')));
            final File file = new File("./repository/gamepack/" + hash);
            file.mkdirs();

            try (InputStream is = new BufferedInputStream(url.openStream());
                 OutputStream os = new BufferedOutputStream(
                         new FileOutputStream(file.getPath() + "/gamepack.jar"))) {
                int read;
                final byte[] buffer = new byte[4096];
                while ((read = is.read(buffer, 0, buffer.length)) != -1) {
                    os.write(buffer, 0, read);
                }
            }

            final StringBuilder bldr = new StringBuilder();
            configs.entrySet().forEach(e -> {
                bldr.append("configs.put(\"").append(e.getKey()).append(", \"").append(e.getValue()).append("\");\n");
            });
            msgs.entrySet().forEach(e -> {
                bldr.append("msgs.put(\"").append(e.getKey()).append(", \"").append(e.getValue()).append("\");\n");
            });
            params.entrySet().forEach(e -> {
                bldr.append("params.put(\"").append(e.getKey()).append(", \"").append(e.getValue()).append("\");\n");
            });

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file.getPath() + "/config.txt"))) {
                writer.write(bldr.toString());
            }

            return file.getAbsolutePath();
        }

        /**
         * Gets a value from the configs params
         *
         * @param key
         * @return
         */
        public final String getConfig(final String key) {
            return configs.get(key);
        }

        /**
         * Gets a value from the msgs params
         *
         * @param key
         * @return
         */
        public final String getMsg(final String key) {
            return msgs.get(key);
        }

        /**
         * Gets a value from the params params
         *
         * @param key
         * @return
         */
        public final String getParam(final String key) {
            return params.get(key);
        }
    }
}