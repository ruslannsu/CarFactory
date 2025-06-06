package UI;

import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.*;

import com.formdev.flatlaf.FlatLaf;
import observer_subject.Observer;

import javax.swing.border.LineBorder;
import javax.swing.plaf.FontUIResource;
import java.awt.*;
import java.util.Properties;

public class View extends JFrame implements Observer {
    Properties properties;
    SlidersPanel slidersPanel;
    FactoryPlan factoryPlan;
    public View(Properties properties) {
        super();
        this.properties = properties;
        FlatLightLaf.setup();
        UIManager.put("Button.arc", 20);
        UIManager.put("Component.arc", 15);
        UIManager.put("ProgressBar.arc", 10);
        UIManager.put("Component.focusWidth", 2);
        UIManager.put("Component.focusColor", Color.WHITE);
        UIManager.put("defaultFont", new FontUIResource("Segoe UI", Font.PLAIN, 14));
        UIManager.put("Table.showHorizontalLines", false);
        UIManager.put("Table.showVerticalLines", false);
        UIManager.put("Table.selectionBackground", new Color(255, 220, 150));
        UIManager.put("Table.selectionForeground", Color.BLACK);
        FlatLaf.updateUI();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 600);
        setResizable(false);
        int bottomShift = 175;
        factoryPlan = new FactoryPlan(bottomShift);
        factoryPlan.setPreferredSize(new Dimension(getWidth(), getHeight() - bottomShift));
        //factoryPlan.setBorder(new LineBorder(Color.BLACK, 2));
        slidersPanel = new SlidersPanel(properties);
        slidersPanel.setLayout(new FlowLayout());
        slidersPanel.setPreferredSize(new Dimension(getWidth(), bottomShift));
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.add(factoryPlan);
        mainPanel.add(slidersPanel);
        setContentPane(mainPanel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public SlidersPanel getSlidersPanel() {
        return slidersPanel;
    }

    @Override
    public void update(int value, String source) {
        factoryPlan.updateSizes(value, source);
    }
}
