package kiosk.page;

import java.awt.Image;

import javax.swing.ImageIcon;

/**
 * Class Role : 이미지관련된 편집을 담당한다.
 * 
 * 기능-
 * 1. 이미지아이콘을 리사이징 한다.
 */
public class ImageEdit {
	// 이미지 아이콘을 리사이징 한다.
	public static ImageIcon getResizeIcon(String path, final int WIDTH, final int HEIGHT) {
		ImageIcon imageIcon = new ImageIcon(path);
		Image image = imageIcon.getImage().getScaledInstance(WIDTH, HEIGHT, Image.SCALE_SMOOTH);

		return new ImageIcon(image);
	}
}