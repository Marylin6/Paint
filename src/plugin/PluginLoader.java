package plugin;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;

public class PluginLoader {

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
}