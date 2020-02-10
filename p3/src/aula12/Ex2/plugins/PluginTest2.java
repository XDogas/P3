package aula12.Ex2.plugins;

import aula12.Ex2.IPlugin;

public class PluginTest2 implements IPlugin {

	@Override
	public void fazQualQuerCoisa() {
		System.out.print("teste 2:");
		int r = 1 - 2;
		System.out.println(" 1-2=" + r);
	}

}
