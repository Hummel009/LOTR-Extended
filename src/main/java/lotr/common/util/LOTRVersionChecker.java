package lotr.common.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import lotr.extended.LOTRExtended;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IChatComponent;

public class LOTRVersionChecker {
  private static String versionURL = "https://raw.githubusercontent.com/Hummel009/LOTR-Extended/master/version.txt";
  
  private static boolean checkedUpdate = false;
  
  public static void checkForUpdates() {
    if (!checkedUpdate) {
      Thread checkThread = new Thread("GOT Update Checker") {
          @Override
		public void run() {
            try {
              URL url = new URL(LOTRVersionChecker.versionURL);
              BufferedReader updateReader = new BufferedReader(new InputStreamReader(url.openStream()));
              String updateVersion = "";
              String line;
              while ((line = updateReader.readLine()) != null) {
				updateVersion = updateVersion.concat(line);
			} 
              updateReader.close();
              updateVersion = updateVersion.trim();
              String currentVersion = LOTRExtended.UPDATE;
              if (!updateVersion.equals(currentVersion)) {
                ChatComponentText chatComponentText = new ChatComponentText("LOTR Extended:");
                chatComponentText.getChatStyle().setColor(EnumChatFormatting.YELLOW);
                EntityClientPlayerMP entityClientPlayerMP = (Minecraft.getMinecraft()).thePlayer;
                if (entityClientPlayerMP != null) {
					entityClientPlayerMP.addChatMessage(new ChatComponentTranslation("chat.lotr.update", new Object[] { chatComponentText, updateVersion }));
				} 
              } 
            } catch (Exception e) {
              LOTRLog.logger.warn("LOTRE: Version check failed");
              e.printStackTrace();
            } 
          }
        };
      checkedUpdate = true;
      checkThread.setDaemon(true);
      checkThread.start();
    } 
  }
}


