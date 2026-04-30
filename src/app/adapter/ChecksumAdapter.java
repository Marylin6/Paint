package app.adapter;

import api.DataProcessor;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * Adapter for external plugin:
 * org.example.plugins.ChecksumPlugin
 *
 * No compile-time dependency.
 * Loaded dynamically through Reflection.
 */
public class ChecksumAdapter implements DataProcessor {

    private Object foreignPlugin;

    private Method getNameMethod;
    private Method beforeSaveMethod;
    private Method afterLoadMethod;

    public ChecksumAdapter() {
        try {
            File file = new File("external/ChecksumPlugin.jar");
            URL url = file.toURI().toURL();
            URLClassLoader loader = new URLClassLoader(new URL[]{url});

            Class<?> clazz = loader.loadClass("org.example.plugins.ChecksumPlugin");

            foreignPlugin = clazz.getDeclaredConstructor().newInstance();
            getNameMethod = clazz.getMethod("getName");
            beforeSaveMethod = clazz.getMethod("processBeforeSave", byte[].class);
            afterLoadMethod = clazz.getMethod("processAfterLoad", byte[].class);

        } catch (Exception e) {
            throw new RuntimeException("Cannot load plugins/ChecksumPlugin.jar", e);
        }
    }

    @Override
    public String getName() {
        try {
            return (String) getNameMethod.invoke(foreignPlugin);
        } catch (Exception e) {
            return "Checksum Adapter";
        }
    }

    @Override
    public String processBeforeSave(String data) {
        try {
            byte[] input = data.getBytes(StandardCharsets.UTF_8);
            byte[] result = (byte[]) beforeSaveMethod.invoke(foreignPlugin, (Object) input);
            return Base64.getEncoder().encodeToString(result);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String processAfterLoad(String data) {
        try {
            byte[] encoded = Base64.getDecoder().decode(data);
            byte[] result =(byte[]) afterLoadMethod.invoke(foreignPlugin, (Object) encoded);
            return new String(result, StandardCharsets.UTF_8);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void configure() {
    }
}