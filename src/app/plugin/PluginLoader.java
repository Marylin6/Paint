package app.plugin;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

public class PluginLoader {
    private static PublicKey publicKey;
    public static List<Plugin> loadPlugins(String folderPath) {

        List<Plugin> plugins = new ArrayList<>();

        File folder = new File(folderPath);

        File[] files = folder.listFiles((dir, name) -> name.endsWith(".jar"));

        if (files == null)
            return plugins;

        for (File file : files) {
            try {
                URL jarUrl = file.toURI().toURL();
                URLClassLoader loader = new URLClassLoader(new URL[]{jarUrl});

                Class<?> clazz = loader.loadClass("pluginimpl.PluginImpl"); //maybe, but not ok
                Path jarPath = file.toPath();
                Path sigPath = Path.of(file.getAbsolutePath() + ".sig");

                if (!Files.exists(sigPath)) {
                    System.out.println("No signature for " + file.getName());
                    continue;
                }

                if (!SecurityUtil.verify(jarPath, sigPath, publicKey)) {
                    System.out.println("Invalid signature: " + file.getName());
                    continue;
                }
                if (Plugin.class.isAssignableFrom(clazz)) {
                    Plugin plugin = (Plugin) clazz.getDeclaredConstructor().newInstance();
                    plugins.add(plugin);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return plugins;
    }

    static {
        try {
            String key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAqQJe0CLVjDpGK0C2QZx8O2Ebs12lLaE0k4n6atCzGrJYIeVLNhKe3JqaDkQEbQqnnkpvp9Syc4pXZ2G6LyfRt0foxDM2OUitGRtgR7qLCQdJCQFRp5rbgU9I7V/PjwMjhnoOzlG/IH2Nh+G/kPhpizrt+hz3IrOz6tV5+L9/X3XPoLmMdL9dfm8ceWmFtLzrrAklhJznD7I48GpuUMvUoR/lSUiSPLZUEUI99/tu1ReMPAe7EFcmrcSHTgfmvAnh1pU1AdOEnWYnRFZuTBsUHJugDfOxJJjcPCJHBItYhMG5uCPwMP+tStoTJ712r742VOizn5pnEu5rnJYFg+BWTQIDAQAB";

            byte[] keyBytes = java.util.Base64.getDecoder().decode(key);
            publicKey = SecurityUtil.loadPublicKey(keyBytes);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}