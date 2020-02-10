package aula12.Ex3;

public abstract class PluginManager {
	public static IPlugin load(String name) throws Exception {
        Class<?> c = Class.forName(name);
        return (IPlugin) c.newInstance(); }
}
