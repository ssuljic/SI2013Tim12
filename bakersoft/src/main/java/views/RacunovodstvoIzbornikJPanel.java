package views;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class RacunovodstvoIzbornikJPanel extends JPanel {
    private JButton korisnickiRacuniJButton;
    private JButton klijentiJButton;
    private JButton obracunavanjeJButton;
    private JButton spaseniObracuniJButton;
    private JButton evidencijaPecivaJButton;
    private JButton odjavaJButton;

    /**
     * Create the panel.
     */
    public RacunovodstvoIzbornikJPanel() {
        setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Izbornik:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
        setLayout(new GridLayout(9, 1, 0, 0));

        korisnickiRacuniJButton = new JButton("Korisni\u010dki ra\u010duni");
        add(korisnickiRacuniJButton);

        klijentiJButton = new JButton("Klijenti");
        add(klijentiJButton);

        obracunavanjeJButton = new JButton("Obra\u010dunavanje");
        add(obracunavanjeJButton);

        spaseniObracuniJButton = new JButton("Spa\u0161eni obra\u010duni");
        add(spaseniObracuniJButton);

        evidencijaPecivaJButton = new JButton("Evidencija peciva");
        add(evidencijaPecivaJButton);

        JPanel odjavaJButtonPozicioner1JPanel = new JPanel();
        add(odjavaJButtonPozicioner1JPanel);
        odjavaJButtonPozicioner1JPanel.setLayout(null);

        JPanel odjavaJButtonPozicioner2JPanel = new JPanel();
        add(odjavaJButtonPozicioner2JPanel);

        JPanel odjavaJButtonPozicioner3JPanel = new JPanel();
        add(odjavaJButtonPozicioner3JPanel);

        odjavaJButton = new JButton("Odjava");
        add(odjavaJButton);
    }

    public JButton getKorisnickiRacuniJButton() {
        return korisnickiRacuniJButton;
    }

    public JButton getKlijentiJButton() {
        return klijentiJButton;
    }

    public JButton getObracunavanjeJButton() {
        return obracunavanjeJButton;
    }

    public JButton getSpaseniObracuniJButton() {
        return spaseniObracuniJButton;
    }

    public JButton getEvidencijaPecivaJButton() {
        return evidencijaPecivaJButton;
    }

    public JButton getOdjavaJButton() {
        return odjavaJButton;
    }
}
