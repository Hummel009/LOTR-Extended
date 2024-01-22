package lotre.content;

import lotr.client.gui.LOTRMapLabels;
import lotre.util.LEAPI;

@SuppressWarnings({"WeakerAccess", "PublicField"})
public class LELabels {
	public static LOTRMapLabels darkland;
	public static LOTRMapLabels sunland;

	public static void onInit() {
		darkland = LEAPI.addLabel("DARKLAND", "darkland", 2376, 4139, 40.0f, -30, -6.0f, -1.0f);
		sunland = LEAPI.addLabel("SUNLAND", "sunland", 3686, 2784, 20.0f, 0, -6.0f, -1.0f);
	}
}