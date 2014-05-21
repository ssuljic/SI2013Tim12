package views;

import controllers.DostavljacIzbornikController;

import javax.swing.*;
import java.awt.*;

public class DostavljacJFrame extends JFrame {

    private JFrame pozivaocJFrame;

    private JPanel contentPane;
    private DostavljacPreuzimanjePecivaJPanel dostavljacPreuzimanjePecivaJPanel;
    private DostavljacPotvrdaDostaveJPanel dostavljacPotvrdaDostaveJPanel;
    private DostavljacIzbornikJPanel dostavljacIzbornikJPanel;

    /**
     * Create the frame.
     */
    public DostavljacJFrame(JFrame pozivaocJFrame) {
        this.pozivaocJFrame = pozivaocJFrame;

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 800, 600);
        contentPane = new JPanel();
        BorderLayout borderLayout = new BorderLayout();
        contentPane.setLayout(borderLayout);
        setContentPane(contentPane);

        dostavljacPreuzimanjePecivaJPanel = new DostavljacPreuzimanjePecivaJPanel();
        dostavljacPotvrdaDostaveJPanel = new DostavljacPotvrdaDostaveJPanel();
        dostavljacIzbornikJPanel = new DostavljacIzbornikJPanel();

        dodajIzbornik();
        postaviPreuzimanjePecivaJPanel();
        dodajListeners();
    }

    public void dodajIzbornik() {
        contentPane.add(dostavljacIzbornikJPanel, BorderLayout.WEST);
    }

    public void postaviPreuzimanjePecivaJPanel() {
        ukloniPostojecePanele();
        dostavljacPreuzimanjePecivaJPanel.popuniSaSvimPodacimaIzBaze();
        contentPane.add(dostavljacPreuzimanjePecivaJPanel, BorderLayout.CENTER);
        this.validate();
        this.repaint();
    }

    private void ukloniPostojecePanele() {
        contentPane.remove(dostavljacPotvrdaDostaveJPanel);
        contentPane.remove(dostavljacPreuzimanjePecivaJPanel);
    }

    public void postaviPotvrdaDostaveJPanel() {
        ukloniPostojecePanele();
        dostavljacPotvrdaDostaveJPanel.popuniSaSvimPodacimaIzBaze();
        contentPane.add(dostavljacPotvrdaDostaveJPanel, BorderLayout.CENTER);
        this.validate();
        this.repaint();
    }

    public void dodajListeners() {
        DostavljacIzbornikController dostavljacIzbornikController = new DostavljacIzbornikController(this);

        this.addWindowListener(dostavljacIzbornikController.getZatvorenJFrameActionListener());

        dostavljacIzbornikJPanel.getPreuzimanjePecivaJButton().addActionListener(dostavljacIzbornikController.getIzbornikPreuzimanjePecivaJButtonActionListener());
        dostavljacIzbornikJPanel.getPotvrdaDostaveJButton().addActionListener(dostavljacIzbornikController.getIzbornikPotvrdaDostaveJButtonActionListener());
        dostavljacIzbornikJPanel.getOdjavaJButton().addActionListener(dostavljacIzbornikController.getIzbornikOdjavaJButtonActionListener());

        /*dostavljacPotvrdaDostaveJPanel.getDostavaIzvrsenaJButton().addActionListener(dostavljacController.getPotvrdaDostaveDostavaIzvrsenaJButtonActionListener());

        dostavljacPreuzimanjePecivaJPanel.getUkloniPecivoJButton().addActionListener(dostavljacController.getPreuzimanjePecivaUkloniPecivoJButtonActionListener());
        dostavljacPreuzimanjePecivaJPanel.getDodajPecivoJButton().addActionListener(dostavljacController.getPreuzimanjePecivaDodajPecivoJButtonActionListener());
        dostavljacPreuzimanjePecivaJPanel.getPreuzmiDostavuJButton().addActionListener(dostavljacController.getPreuzimanjePecivaPreuzmiDostavuJButtonActionListener());*/
    }

    public JFrame getPozivaocJFrame() {
        return pozivaocJFrame;
    }

}