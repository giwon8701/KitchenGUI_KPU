package kiosk;

import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.Toolkit;

/**
 * Class Role : ���÷��� ȭ���� ������ �����Ѵ�.
 * ���÷��� ȭ���� ������ ��ũ�� �������, ������ ����� �ִ�.
 */
public final class Display {
	/* �ٸ� ������Ʈ���� ���� ������ �Ҵ� �� ���� �ϱ����ؼ� static���� ����Ͽ� ������ ����ξ���. */
	// ��ũ�� ������
	public static final int SCREEN_WIDTH;
	public static final int SCREEN_HEIGHT;
	
	// ������ ������
	public static final int WINDOWS_WIDTH;
	public static final int WINDOWS_HEIGHT;
	
	static {
		final Dimension DIMEN = Toolkit.getDefaultToolkit().getScreenSize();
		// ȭ�鿡 ���� ����� �̰� �����Ұ�!!!!!!!!!!!!!
		SCREEN_WIDTH = (int) DIMEN.getWidth();
//		SCREEN_HEIGHT = (int) DIMEN.getHeight() - 40;
		SCREEN_HEIGHT = (int) DIMEN.getHeight();
		
		final GraphicsEnvironment GE = GraphicsEnvironment.getLocalGraphicsEnvironment();
		final Rectangle REC = GE.getMaximumWindowBounds();
		WINDOWS_WIDTH = (int) REC.getWidth();
		WINDOWS_HEIGHT = (int) REC.getHeight();
	}
	
	private Display() { }
}