package testCom;

import java.awt.Image;

import javax.swing.ImageIcon;

public class ImageEdit {
	// �̹��� �������� ������¡ �Ѵ�.
	public static ImageIcon getResizeIcon(String path, final int WIDTH, final int HEIGHT) {
		ImageIcon imageIcon = new ImageIcon(path);
		Image image = imageIcon.getImage().getScaledInstance(WIDTH, HEIGHT, Image.SCALE_SMOOTH);

		return new ImageIcon(image);
	}
}