package views;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class RacunovodstvoSpaseniObracuniJPanel extends JPanel {
    private JTable obracuniJTable;
    private JComboBox obracunZaJComboBox;
    private JButton obrisiObracunJButton;
    private JButton napraviNoviObracunJButton;
    private JButton kreirajPdfJButton;

    /**
     * Create the panel.
     */
    public RacunovodstvoSpaseniObracuniJPanel() {
        setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Spa\u0161eni obra\u010Duni:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{0, 0};
        gridBagLayout.rowHeights = new int[]{0, 0, 0, 0};
        gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
        gridBagLayout.rowWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
        setLayout(gridBagLayout);

        JPanel obracunZaJPanel = new JPanel();
        GridBagConstraints gbc_obracunZaJPanel = new GridBagConstraints();
        gbc_obracunZaJPanel.insets = new Insets(0, 0, 5, 0);
        gbc_obracunZaJPanel.fill = GridBagConstraints.HORIZONTAL;
        gbc_obracunZaJPanel.gridx = 0;
        gbc_obracunZaJPanel.gridy = 0;
        add(obracunZaJPanel, gbc_obracunZaJPanel);
        GridBagLayout gbl_obracunZaJPanel = new GridBagLayout();
        gbl_obracunZaJPanel.columnWidths = new int[]{46, 392, 0};
        gbl_obracunZaJPanel.rowHeights = new int[]{141, 0};
        gbl_obracunZaJPanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
        gbl_obracunZaJPanel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
        obracunZaJPanel.setLayout(gbl_obracunZaJPanel);

        JLabel obracunZaJLabel = new JLabel("Obra\u010Dun za:");
        obracunZaJLabel.setHorizontalAlignment(SwingConstants.TRAILING);
        GridBagConstraints gbc_obracunZaJLabel = new GridBagConstraints();
        gbc_obracunZaJLabel.fill = GridBagConstraints.BOTH;
        gbc_obracunZaJLabel.insets = new Insets(0, 0, 0, 5);
        gbc_obracunZaJLabel.gridx = 0;
        gbc_obracunZaJLabel.gridy = 0;
        obracunZaJPanel.add(obracunZaJLabel, gbc_obracunZaJLabel);

        obracunZaJComboBox = new JComboBox();
        GridBagConstraints gbc_obracunZaJComboBox = new GridBagConstraints();
        gbc_obracunZaJComboBox.fill = GridBagConstraints.HORIZONTAL;
        gbc_obracunZaJComboBox.gridx = 1;
        gbc_obracunZaJComboBox.gridy = 0;
        obracunZaJPanel.add(obracunZaJComboBox, gbc_obracunZaJComboBox);

        JPanel podaciOObracunimaJPanel = new JPanel();
        podaciOObracunimaJPanel.setBorder(null);
        GridBagConstraints gbc_podaciOObracunimaJPanel = new GridBagConstraints();
        gbc_podaciOObracunimaJPanel.insets = new Insets(0, 0, 5, 0);
        gbc_podaciOObracunimaJPanel.fill = GridBagConstraints.BOTH;
        gbc_podaciOObracunimaJPanel.gridx = 0;
        gbc_podaciOObracunimaJPanel.gridy = 1;
        add(podaciOObracunimaJPanel, gbc_podaciOObracunimaJPanel);
        GridBagLayout gbl_podaciOObracunimaJPanel = new GridBagLayout();
        gbl_podaciOObracunimaJPanel.columnWidths = new int[]{0, 0, 0};
        gbl_podaciOObracunimaJPanel.rowHeights = new int[]{245, 0};
        gbl_podaciOObracunimaJPanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
        gbl_podaciOObracunimaJPanel.rowWeights = new double[]{1.0, Double.MIN_VALUE};
        podaciOObracunimaJPanel.setLayout(gbl_podaciOObracunimaJPanel);

        JLabel obracuniJLabel = new JLabel("Obra\u010Duni:");
        obracuniJLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        GridBagConstraints gbc_obracuniJLabel = new GridBagConstraints();
        gbc_obracuniJLabel.anchor = GridBagConstraints.EAST;
        gbc_obracuniJLabel.insets = new Insets(0, 0, 0, 5);
        gbc_obracuniJLabel.gridx = 0;
        gbc_obracuniJLabel.gridy = 0;
        podaciOObracunimaJPanel.add(obracuniJLabel, gbc_obracuniJLabel);

        JScrollPane obracuniJScrollPane = new JScrollPane();
        GridBagConstraints gbc_obracuniJScrollPane = new GridBagConstraints();
        gbc_obracuniJScrollPane.fill = GridBagConstraints.BOTH;
        gbc_obracuniJScrollPane.gridx = 1;
        gbc_obracuniJScrollPane.gridy = 0;
        podaciOObracunimaJPanel.add(obracuniJScrollPane, gbc_obracuniJScrollPane);

        obracuniJTable = new JTable();
        obracuniJTable.setModel(new DefaultTableModel(
                new Object[][] {
                },
                new String[] {
                        "Datum", "Broj", "Iznos", "Pla\u0107en", "Obra\u010Dunao", "Po\u010Detak obra\u010Duna", "Kraj obra\u010Duna"
                }
        ) {
            Class[] columnTypes = new Class[] {
                    Object.class, Object.class, Object.class, Boolean.class, Object.class, Object.class, Object.class
            };
            public Class getColumnClass(int columnIndex) {
                return columnTypes[columnIndex];
            }
        });
        obracuniJScrollPane.setViewportView(obracuniJTable);

        JPanel dugmadJPanel = new JPanel();
        GridBagConstraints gbc_dugmadJPanel = new GridBagConstraints();
        gbc_dugmadJPanel.fill = GridBagConstraints.BOTH;
        gbc_dugmadJPanel.gridx = 0;
        gbc_dugmadJPanel.gridy = 2;
        add(dugmadJPanel, gbc_dugmadJPanel);
        GridBagLayout gbl_dugmadJPanel = new GridBagLayout();
        gbl_dugmadJPanel.columnWidths = new int[]{0, 0, 0};
        gbl_dugmadJPanel.rowHeights = new int[]{0, 0, 0};
        gbl_dugmadJPanel.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
        gbl_dugmadJPanel.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
        dugmadJPanel.setLayout(gbl_dugmadJPanel);

        obrisiObracunJButton = new JButton("Obri\u0161i obra\u010Dun");
        GridBagConstraints gbc_obrisiObracunJButton = new GridBagConstraints();
        gbc_obrisiObracunJButton.anchor = GridBagConstraints.SOUTH;
        gbc_obrisiObracunJButton.fill = GridBagConstraints.HORIZONTAL;
        gbc_obrisiObracunJButton.insets = new Insets(0, 0, 5, 5);
        gbc_obrisiObracunJButton.gridx = 0;
        gbc_obrisiObracunJButton.gridy = 0;
        dugmadJPanel.add(obrisiObracunJButton, gbc_obrisiObracunJButton);

        napraviNoviObracunJButton = new JButton("Napravi novi obra\u010Dun");
        GridBagConstraints gbc_napraviNoviObracunJButton = new GridBagConstraints();
        gbc_napraviNoviObracunJButton.insets = new Insets(0, 0, 5, 0);
        gbc_napraviNoviObracunJButton.anchor = GridBagConstraints.SOUTH;
        gbc_napraviNoviObracunJButton.fill = GridBagConstraints.HORIZONTAL;
        gbc_napraviNoviObracunJButton.gridx = 1;
        gbc_napraviNoviObracunJButton.gridy = 0;
        dugmadJPanel.add(napraviNoviObracunJButton, gbc_napraviNoviObracunJButton);

        kreirajPdfJButton = new JButton("Kreiraj PDF");
        GridBagConstraints gbc_kreirajPdfJButton = new GridBagConstraints();
        gbc_kreirajPdfJButton.fill = GridBagConstraints.HORIZONTAL;
        gbc_kreirajPdfJButton.gridwidth = 2;
        gbc_kreirajPdfJButton.insets = new Insets(0, 0, 0, 5);
        gbc_kreirajPdfJButton.gridx = 0;
        gbc_kreirajPdfJButton.gridy = 1;
        dugmadJPanel.add(kreirajPdfJButton, gbc_kreirajPdfJButton);

    }

    public JTable getObracuniJTable() {
        return obracuniJTable;
    }

    public JComboBox getObracunZaJComboBox() {
        return obracunZaJComboBox;
    }

    public JButton getObrisiObracunJButton() {
        return obrisiObracunJButton;
    }

    public JButton getNapraviNoviObracunJButton() {
        return napraviNoviObracunJButton;
    }

    public JButton getKreirajPdfJButton() {
        return kreirajPdfJButton;
    }

    public void popuniSaSvimPodacimaIzBaze() {

    }
}
