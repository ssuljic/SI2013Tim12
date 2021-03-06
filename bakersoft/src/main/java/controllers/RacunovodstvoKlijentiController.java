package controllers;

import entities.Klijent;
import entities.ProdajnoMjesto;
import exceptions.PodaciNisuValidniException;
import utilities.Baza;
import utilities.JComboBoxItem;
import views.RacunovodstvoKlijentiJPanel;

import javax.swing.*;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;

public class RacunovodstvoKlijentiController {
    private RacunovodstvoKlijentiJPanel racunovodstvoKlijentiJPanel;

    
    public int brojKlikova = 0;
    public int brojKlikova2 = 0;
    public RacunovodstvoKlijentiController(RacunovodstvoKlijentiJPanel racunovodstvoKlijentiJPanel) {
        this.racunovodstvoKlijentiJPanel = racunovodstvoKlijentiJPanel;
    }

    public ItemListener getKlijentiTraziJComboBoxItemListener() {
        return new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    long idSelektiranogKlijenta = ((JComboBoxItem) racunovodstvoKlijentiJPanel.getTraziJComboBox().getSelectedItem()).getId();
                    Baza baza = Baza.getBaza();
                    List<Klijent> sviKlijenti = baza.dajSveNeobrisano(Klijent.class);
                    racunovodstvoKlijentiJPanel.popuniSaPodacima(sviKlijenti, idSelektiranogKlijenta);
                }
            }
        };
    }
    

    public ActionListener getKlijentiObrisiJButtonActionListener() {
        return new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                try {
					long idSelektiranogKlijenta = 0;
					if (racunovodstvoKlijentiJPanel.getTraziJComboBox().getItemCount() > 0) {
					    idSelektiranogKlijenta = ((JComboBoxItem) racunovodstvoKlijentiJPanel.getTraziJComboBox().getSelectedItem()).getId();
					}

					Baza baza = Baza.getBaza();
					
					List<ProdajnoMjesto> svaProdajnaMjesta = baza.dajSveNeobrisano(ProdajnoMjesto.class);
					
					if(svaProdajnaMjesta.size() == 1)
					    throw new IllegalArgumentException("Ne mo\u017eete obrisati posljednjeg i jedinog klijenta.");

					
					for(ProdajnoMjesto pm : svaProdajnaMjesta){
						if(pm.getKlijent().getId() == idSelektiranogKlijenta){
							pm.setObrisano(true);
							baza.azuriraj(pm);
						}
					}
					List<Klijent> sviKlijenti = baza.dajSveNeobrisano(Klijent.class);
					int index = (int)(idSelektiranogKlijenta-1);
					if (idSelektiranogKlijenta > 0) {
						sviKlijenti.get(index).setObrisano(true);
					    baza.azuriraj(sviKlijenti.get(index));
					}
					
					List<Klijent> sviKlijenti2 = baza.dajSveNeobrisano(Klijent.class);
					long idPrvogKlijenta = 0;
					if (sviKlijenti2.size() > 0) {
					    idPrvogKlijenta = sviKlijenti2.get(0).getId();
					}
					
					racunovodstvoKlijentiJPanel.popuniSaPodacima(sviKlijenti2, idPrvogKlijenta); 
					JOptionPane.showMessageDialog(racunovodstvoKlijentiJPanel.getParent(), "Uspje\u0161no ste izbrisali klijenta!");
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
				    JOptionPane.showMessageDialog(racunovodstvoKlijentiJPanel.getParent(), e.getMessage());
				}
            }
        };
    }

    public ActionListener getKlijentiDodajJButtonActionListener() {
        return new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
            	try {
            		boolean imaklijent=false;
					if(brojKlikova2 == 0 && !racunovodstvoKlijentiJPanel.getNazivFirmeJTextField().getText().isEmpty() && !racunovodstvoKlijentiJPanel.getTelefonJTextField().getText().isEmpty()){
						racunovodstvoKlijentiJPanel.ocistiDonjiDioPanela();
						racunovodstvoKlijentiJPanel.ocistiGornjiDioPanela();
					    racunovodstvoKlijentiJPanel.sakrijDugmad();
						brojKlikova2=1;
					    JOptionPane.showMessageDialog(racunovodstvoKlijentiJPanel.getParent(), "Sada mo\u017eete unijeti podatke za novog klijenta");

					}
					else{
							Baza baza = Baza.getBaza();
			            	List<Klijent> sviKlijenti= baza.dajSve(Klijent.class);

						 for(Klijent k: sviKlijenti) {
						    	if(k.getIme().equals(racunovodstvoKlijentiJPanel.getNazivFirmeJTextField().getText()) || k.getTelefon().equals(racunovodstvoKlijentiJPanel.getTelefonJTextField().getText())) {
						    		imaklijent = true;
						    		break;
						    	}
						 }
						 if(!imaklijent) {
							Klijent noviKlijent;
							try {
								noviKlijent = racunovodstvoKlijentiJPanel.dajPodatkeONovomKlijentu();
								// Baza baza = Baza.getBaza();
							    baza.spasiUBazu(noviKlijent);
							    
							    List<Klijent> sviKlijenti2 = baza.dajSveNeobrisano(Klijent.class);
							    long idPrvogKlijenta = 0;
							    if (sviKlijenti2.size() > 0) {
							        idPrvogKlijenta = sviKlijenti2.get(0).getId();
							    }
							    
							    racunovodstvoKlijentiJPanel.popuniSaPodacima(sviKlijenti2, idPrvogKlijenta);
							    brojKlikova2=0;
							    racunovodstvoKlijentiJPanel.prikaziDugmad();
							    JOptionPane.showMessageDialog(racunovodstvoKlijentiJPanel.getParent(), "Uspje\u0161no ste dodali klijenta: " + noviKlijent.getIme());
							} catch (PodaciNisuValidniException e) {
								JOptionPane.showMessageDialog(racunovodstvoKlijentiJPanel, e.getMessage());
							}
						}
						else{
					    	JOptionPane.showMessageDialog(racunovodstvoKlijentiJPanel.getParent(),"Postoji klijent sa tim podacima!");
				    	}
					}
				} catch (IllegalArgumentException e) {					
				    JOptionPane.showMessageDialog(racunovodstvoKlijentiJPanel.getParent(), e.getMessage());
				}           	
            }
        };
    }
    
    public ActionListener getSljedeceProdajnoMjestoJButtonActionListener() {
        return new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
            	long idSelektiranogKlijenta = ((JComboBoxItem) racunovodstvoKlijentiJPanel.getTraziJComboBox().getSelectedItem()).getId();
                Baza baza = Baza.getBaza();
                List<Klijent> sviKlijenti = baza.dajSveNeobrisano(Klijent.class);
            	Klijent selektovaniKlijent = racunovodstvoKlijentiJPanel.popuniTraziJComboBoxSa(sviKlijenti,idSelektiranogKlijenta);
            	
            	String redniBrojPolje = racunovodstvoKlijentiJPanel.getLblBroj().getText();
            	int id; 
            	if(redniBrojPolje.equals("Kliknite dugme Sljede\u0107i") ){
            		id=1;
            	}
            	else{
            		id = Integer.parseInt(racunovodstvoKlijentiJPanel.getLblBroj().getText());
            	}
            	List<ProdajnoMjesto> svaProdajnaMjesta = baza.dajSveNeobrisano(ProdajnoMjesto.class);
            	List<ProdajnoMjesto> klijentovaProdajnaMjesta = new ArrayList<ProdajnoMjesto>();
                for(ProdajnoMjesto pm : svaProdajnaMjesta){
                	if(pm.getKlijent().getId() == selektovaniKlijent.getId())
                		klijentovaProdajnaMjesta.add(pm);
                }
                
                if(id == klijentovaProdajnaMjesta.size())
                	id=0;
                
                int novi_id = id+1;
                racunovodstvoKlijentiJPanel.getProdajnoMjestoNazivJTextField().setText(klijentovaProdajnaMjesta.get(id).getMjesto());
                racunovodstvoKlijentiJPanel.getProdajnoMjestoAdresaJTextField().setText(klijentovaProdajnaMjesta.get(id).getAdresa());
                racunovodstvoKlijentiJPanel.getLblBroj().setText(""+novi_id+"");

            }
        };
    }
    
    public ActionListener getDodajProdajnoMjestoJButtonActionListener() {
        return new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
            	 boolean imadostava=false;
            	
            	
            	try {
					if(brojKlikova == 0 && !racunovodstvoKlijentiJPanel.getProdajnoMjestoNazivJTextField().getText().isEmpty() && !racunovodstvoKlijentiJPanel.getProdajnoMjestoAdresaJTextField().getText().isEmpty()){
						racunovodstvoKlijentiJPanel.ocistiDonjiDioPanela();
						brojKlikova=1;
					    JOptionPane.showMessageDialog(racunovodstvoKlijentiJPanel.getParent(), "Sada mo\u017eete unijeti podatke za novo prodajno mjesto odabranog klijenta");
					}
					else if((racunovodstvoKlijentiJPanel.getProdajnoMjestoNazivJTextField().getText().isEmpty() || racunovodstvoKlijentiJPanel.getProdajnoMjestoAdresaJTextField().getText().isEmpty()) && brojKlikova==1){
						brojKlikova=0;
					    JOptionPane.showMessageDialog(racunovodstvoKlijentiJPanel.getParent(), "Morate unijeti neke podatke kako bi mogli dodati mjesto: ");
					}
					else if(!racunovodstvoKlijentiJPanel.getProdajnoMjestoNazivJTextField().getText().isEmpty() && !racunovodstvoKlijentiJPanel.getProdajnoMjestoAdresaJTextField().getText().isEmpty() && brojKlikova==1){
						long idSelektiranogKlijenta = ((JComboBoxItem) racunovodstvoKlijentiJPanel.getTraziJComboBox().getSelectedItem()).getId();
					    Baza baza = Baza.getBaza();
					    List<Klijent> sviKlijenti = baza.dajSveNeobrisano(Klijent.class);
						Klijent selektovaniKlijent = racunovodstvoKlijentiJPanel.popuniTraziJComboBoxSa(sviKlijenti,idSelektiranogKlijenta);
						
						int id = Integer.parseInt(racunovodstvoKlijentiJPanel.getLblBroj().getText())+1;
						
						List<ProdajnoMjesto> svaProdajnaMjesta = baza.dajSveNeobrisano(ProdajnoMjesto.class);
						List<ProdajnoMjesto> klijentovaProdajnaMjesta = new ArrayList<ProdajnoMjesto>();
					   
						for(ProdajnoMjesto pm : svaProdajnaMjesta){
					    	if(pm.getKlijent().getId() == selektovaniKlijent.getId())
					    		klijentovaProdajnaMjesta.add(pm);
					    }
					    
						 for(ProdajnoMjesto promje : svaProdajnaMjesta) {
						    	if(promje.getMjesto().equals(racunovodstvoKlijentiJPanel.getProdajnoMjestoNazivJTextField().getText()) || promje.getAdresa().equals(racunovodstvoKlijentiJPanel.getProdajnoMjestoAdresaJTextField().getText())) {
						    		imadostava = true;
						    		break;
						    	}
						 }
						    		
						    		if(!imadostava) {
						    	
						    			ProdajnoMjesto pm = new ProdajnoMjesto();
										pm.setMjesto(racunovodstvoKlijentiJPanel.getProdajnoMjestoNazivJTextField().getText());
										pm.setAdresa(racunovodstvoKlijentiJPanel.getProdajnoMjestoAdresaJTextField().getText());
										pm.setKlijent(selektovaniKlijent);
						baza.spasiUBazu(pm);
						brojKlikova = 0;
						racunovodstvoKlijentiJPanel.getLblBroj().setText("" + id + "");
						JOptionPane.showMessageDialog(racunovodstvoKlijentiJPanel.getParent(),"Uspje\u0161no ste dodali prodajno mjesto: "
										+ pm.getMjesto() + " sa adresom: "
										+ pm.getAdresa()); 
					
						    		}
						    		else{
							    		JOptionPane.showMessageDialog(racunovodstvoKlijentiJPanel.getParent(),"Prodajno mjesto ve� postoji!");
						    			}
					 
					}} catch (IllegalArgumentException e) {
				    JOptionPane.showMessageDialog(racunovodstvoKlijentiJPanel.getParent(), e.getMessage());
				} 
            	
            	}
        };
    }
    
    public ActionListener getObrisiProdajnoMjestoJButtonActionListener() {
        return new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {

				try {
					if(racunovodstvoKlijentiJPanel.getLblBroj().getText().equals("Kliknite dugme Sljede\u0107i") && racunovodstvoKlijentiJPanel.prodajnoMjestoNazivJTextField.getText().isEmpty() && racunovodstvoKlijentiJPanel.prodajnoMjestoAdresaJTextField.getText().isEmpty())
					    throw new IllegalArgumentException("Morate kliknuti dugme sljede\u0107i kao \u0161to pi\u0161e iznad.");

					long idSelektiranogKlijenta = ((JComboBoxItem) racunovodstvoKlijentiJPanel.getTraziJComboBox().getSelectedItem()).getId();
					Baza baza = Baza.getBaza();
					List<Klijent> sviKlijenti = baza.dajSveNeobrisano(Klijent.class);
					Klijent selektovaniKlijent = racunovodstvoKlijentiJPanel.popuniTraziJComboBoxSa(sviKlijenti,idSelektiranogKlijenta);

					int indexUlisti = Integer.parseInt(racunovodstvoKlijentiJPanel.getLblBroj().getText()) -1;
					
					List<ProdajnoMjesto> svaProdajnaMjesta = baza.dajSveNeobrisano(ProdajnoMjesto.class);
					List<ProdajnoMjesto> klijentovaProdajnaMjesta = new ArrayList<ProdajnoMjesto>();
					for (ProdajnoMjesto pm : svaProdajnaMjesta) {
						if (pm.getKlijent().getId() == selektovaniKlijent.getId())
							klijentovaProdajnaMjesta.add(pm);
					}
					
					if(indexUlisti==klijentovaProdajnaMjesta.size())
						indexUlisti=0;
					
					if(klijentovaProdajnaMjesta.size()==1)
					    throw new IllegalArgumentException("Svaki klijent mora imati barem jedno prodajno mjesto, tako da ne mo\u017eete obrisati njegovo zadnje.");

					klijentovaProdajnaMjesta.get(indexUlisti).setObrisano(true);
					baza.azuriraj(klijentovaProdajnaMjesta.get(indexUlisti));

					racunovodstvoKlijentiJPanel.getLblBroj().setText("Kliknite dugme Sljede\u0107i");
					racunovodstvoKlijentiJPanel.ocistiDonjiDioPanela();            	

					JOptionPane.showMessageDialog(racunovodstvoKlijentiJPanel.getParent(), "Uspje\u0161no ste izbrisali prodajno mjesto.");
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(racunovodstvoKlijentiJPanel.getParent(), e.getMessage());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                
            }
        };
    }

}
