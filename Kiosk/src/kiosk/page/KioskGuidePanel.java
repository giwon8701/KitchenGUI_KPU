package kiosk.page;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Class Role : ���α׷����� ���������� ���ǰ� �ִ� ���̵� �г��̴�.
 * ���̵��г��� BorderLayout������ ������ ������
 * ��� Ÿ��Ʋ(TitleLabel)��, �߰� �׸��巹�̾ƿ� ������ ������ �гη� �����Ǿ� �ִ�.
 */
public class KioskGuidePanel {
	private static final Color BACKGROUND_COLOR = Color.BLACK;
	
	private final JPanel GUIDE_PANEL = new JPanel();
	private final JPanel ITEM_PANEL = new JPanel();
	
	public KioskGuidePanel() {
	}
	
	public KioskGuidePanel(final int itemRow, final int itemCol) {
		this(null, itemRow, itemCol);
	}
	
	public KioskGuidePanel(String title, final int itemRow, final int itemCol) {
		initGuidePanel(title);
		initItemPanel(itemRow, itemCol);
	}
	
	private void initGuidePanel(String title){
		GUIDE_PANEL.setLayout(new BorderLayout());
		GUIDE_PANEL.setBackground(BACKGROUND_COLOR);
		if (title != null)
			GUIDE_PANEL.add(new TitleLabel(title, JLabel.CENTER), BorderLayout.NORTH);
		
		GUIDE_PANEL.add(ITEM_PANEL, BorderLayout.CENTER);
	}
	
	private void initItemPanel(final int row, final int col){
		ITEM_PANEL.setLayout(new GridLayout(row, col));
	}
	
	public void addItem(Component... comps){
		for(Component comp : comps) ITEM_PANEL.add(comp);
	}
	
	public void setTitleColor(Color color, Font font){
		if(GUIDE_PANEL.getComponentCount() == 2) {
			GUIDE_PANEL.getComponent(0).setForeground(color);
			GUIDE_PANEL.getComponent(0).setFont(font);
		}
	}
	
	public JComponent getPanel(){
		return GUIDE_PANEL;
	}


}