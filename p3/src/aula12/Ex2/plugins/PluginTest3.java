package aula12.Ex2.plugins;

import aula12.Ex2.IPlugin;

public class PluginTest3 implements IPlugin {

	@Override
	public void fazQualQuerCoisa() {
		System.out.print("teste 3:");
		System.out.println(" 1x2=" + 1*2);
	}

}
