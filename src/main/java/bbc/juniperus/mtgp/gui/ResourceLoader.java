package bbc.juniperus.mtgp.gui;

import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;

public class ResourceLoader {
	
	private static int ICON_HEIGHT = 20;
	private static int ICON_WIDTH = 20;
	public static final ImageIcon ICON_ADD = loadIcon("/icons/file_add.png",ICON_WIDTH,ICON_HEIGHT);
	public static final ImageIcon ICON_REMOVE = loadIcon("/icons/file_delete2.png",ICON_WIDTH,ICON_HEIGHT);
	//Slightly thinner as its not symmetric.
	public static final ImageIcon ICON_IMPORT = loadIcon("/icons/import1.png",ICON_WIDTH-1,ICON_HEIGHT);
	/*
	private static final ImageIcon ICON_EXPORT = loadIcon("/icons/103.png",ICON_WIDTH,ICON_HEIGHT);
	private static final ImageIcon ICON_SAVE = loadIcon("/icons/095.png",ICON_WIDTH,ICON_HEIGHT);
	*/
	public static final ImageIcon ICON_GO = loadIcon("/icons/play.png",ICON_WIDTH,ICON_HEIGHT);
	public static final ImageIcon ICON_STOP = loadIcon("/icons/stop-icon_40.png",ICON_WIDTH,ICON_HEIGHT);
	public static final ImageIcon ICON_BROWSER = loadIcon("/icons/browser.png",ICON_WIDTH,ICON_HEIGHT);
	public static final ImageIcon ICON_APP = loadIcon("/icons/app_icon.png",ICON_WIDTH,ICON_HEIGHT);
	public static final ImageIcon ICON_LOADING = loadIcon("/icons/loading.gif");
	public static final ImageIcon ICON_STOPPING = loadIcon("/icons/stopping.gif");
	public static final ImageIcon ICON_SEARCH_FINISHED = loadIcon("/icons/tick_1.png",10,10);
	public static final ImageIcon ICON_SEARCH_SETTINGS = loadIcon("/icons/panel_settings.png",12,12);
	
	private static ImageIcon loadIcon(String path, int width, int height){
		ImageIcon icon = loadIcon(path);
		Image img = icon.getImage();
		img = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		icon.setImage(img);
		return icon;
	}
	
	

	private static ImageIcon loadIcon(String path){
		URL url = MainView.class.getResource(path);
		ImageIcon icon = new ImageIcon(url);
		return icon;
	}
}
