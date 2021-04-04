package machineACafePro;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.Blend;
import javafx.scene.effect.BlendMode;
import javafx.scene.effect.ColorInput;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import model.BacCollecteur;
import model.FiltreAeau;
import model.ReservoirCafe;
import model.ReservoirEau;
import stateChart_gen.CafePro;
import stateChart_gen.CafePro.State;
import stateChart_gen.TimerService;
import stateChart_gen.*;
import view.ConfigUsine;
import view.ViewBandeau;
import view.ViewEcran;
import view.ViewMenu;
import view.ViewPanne;


public class CafeController {
	@FXML
	private Pane paneEcran,panePrincipale,panePanne;
	@FXML
	public Label lblCafeMoulu,lblNbreCafe,lblMouture,lblFiltreEau,lblIntensiteCafe,lblQteBoisson
	,lblReservoirLait,lblQtiteEau,lblQteCafe,lblQteDechet,lblTubeTuyau,lblTuyauAlait,lblPanneMoulin,lblPanneMousseur,lblDefaillance,
	lblPanneFiltre,lblPanneBandeau,lblPanneEcran,lblAffichInfo,lblAffichInfo1,lblDegreMouture,
	lblLedExpreso,lblLedExpressoMacch,lblLedCappucino,lblLedCafe,lblLedMachiato,lblLedCafeLait,lblLedMousseLait,lblLedBoissonSpecial,lblLedDoubleTasse;
	@FXML
	TextField txtNomProfil;
	@FXML
	private Button btnCafeMoulu,btnMouture,btnFiltreEau ,btnMenu,btnReservoirLait,btnAromDouble,btnQteBoisson,btnPanne,btnReservoirEau,btnRemplirCafe,btnVideBacCollect,btnTubeTuyau,btnTuyauAlait
	,btnPanneMoulin,btnPanneMousseur,btnDefaillance,btnPanneFiltre,btnPanneBandeau,btnPanneEcran,btnVoirRecervois;
	@FXML
	private ImageView btnExpresso,btnExpressoMacch,btnCafe,btnCappucino,btnMacchiato,btnCafeLait,btnMousseLait,btnBoissonSpecial,btnStopPlay,btnFavori,btnDoubleTasse,btnIntensiteCafe,btnClesVerrou
	,btnDown,btnPreceding,btnOk;
	@FXML
	private HBox ll;
	@FXML
	private VBox vbxRecervoir,vbxLait,vbxQteRecervoir;
	
	ViewBandeau viewBandeau;
	ViewEcran viewEcran;
	ViewMenu viewMenu;
	ViewPanne viewPanne;
	CafePro cafePro = new CafePro(); 
	String message = null;
	ConfigUsine configUsine=  new ConfigUsine();
    public void initialize() {
    	viewBandeau = new ViewBandeau(btnExpresso,btnExpressoMacch,btnCafe,btnCappucino,btnMacchiato,btnCafeLait,btnMousseLait,btnBoissonSpecial,configUsine);
    	viewPanne = new ViewPanne( btnPanneMoulin,btnPanneMousseur,btnDefaillance, btnPanneFiltre,btnPanneBandeau,btnPanneEcran);
    	viewEcran = new ViewEcran();
    	viewMenu  = new ViewMenu();
    	cafePro.setSizeTabArretAuto(viewMenu.getListArretAuto().size());
    	cafePro.setSizeTabBipSonore(viewMenu.getListOptBipSonore().size());
    	cafePro.setSizeTabDureteEau(viewMenu.getListDureteEau().size());
    	cafePro.setSizeTabFiltreEau(viewMenu.getListOptionFiltreEau().size());
    	cafePro.setSizeTabLangue(viewMenu.getListLangue().size());
    	cafePro.setSizeTabProfil(configUsine.getListProfilFavori().size());
    	cafePro.setSizeTabProportion(configUsine.getListProportionLaitCafe().size());
    	cafePro.setSizeTabQteBoisson(configUsine.getListQteBoisson().size());
    	cafePro.setSizeTabBoisson(configUsine.getListBoissons().size());
    	cafePro.setSizeTabBoissonLactee(configUsine.getListBoissonsLactee().size());
    	cafePro.setSizeTabBoissonLactee(configUsine.getListProfilFavori().size());
    	cafePro.setSizeTabTemperature(viewMenu.getListTemperatureCafe().size());
    	cafePro.setSizeTabBoissonSpecial(viewBandeau.getListBoissonSpecial().size());
    	
    	cafePro.setTimerService(new TimerService());
    	cafePro.enter();
    	
    	lblDegreMouture.setText((cafePro.getDegreMouture()+1)+"");
    	
    /*            ********************* creation d'un timer qui sera execute tous les x temps *******************************  */
		Timer timer = new Timer(1000, new ActionListener() {
		    public void actionPerformed(ActionEvent evt) {
		    	if(!cafePro.isStateActive(State.MAIN_PREPARATION_R1_SETTINGS)){
					lblLedExpreso.setVisible(false);
					lblLedExpressoMacch.setVisible(false);
					lblLedCappucino.setVisible(false);
					lblLedCafe.setVisible(false);
					lblLedMachiato.setVisible(false);
					lblLedCafeLait.setVisible(false);
					lblLedMousseLait.setVisible(false);
					lblLedBoissonSpecial.setVisible(false);
		    	}
				/*  ******************************    quand la machine est eteinte    ****************************** */
				if(cafePro.isStateActive(State.MAIN_STOP) || cafePro.isStateActive(State.MAIN_RINÇAGE)) {
					Platform.runLater(() ->paneEcran.setStyle("-fx-background-color: #"+"000000")); 
					Platform.runLater(() ->lblIntensiteCafe.setVisible(false));
					Platform.runLater(() ->lblQteBoisson.setVisible(false));
					Platform.runLater(() ->lblAffichInfo.setVisible(false));
					Platform.runLater(() ->lblAffichInfo1.setVisible(false));
					
					Platform.runLater(() ->btnExpresso.setDisable(true));
					Platform.runLater(() ->btnExpressoMacch.setDisable(true));
					Platform.runLater(() ->btnCafe.setDisable(true));
					Platform.runLater(() ->btnCappucino.setDisable(true));
					Platform.runLater(() ->btnMacchiato.setDisable(true));
					Platform.runLater(() ->btnCafeLait.setDisable(true));
					Platform.runLater(() ->btnMousseLait.setDisable(true));
					Platform.runLater(() ->btnBoissonSpecial.setDisable(true));
					
					Platform.runLater(() ->btnPanne.setDisable(true));
					Platform.runLater(() ->panePanne.setVisible(false));
					Platform.runLater(() ->btnVoirRecervois.setDisable(true));
					Platform.runLater(() ->vbxRecervoir.setVisible(false));
					Platform.runLater(() ->vbxLait.setVisible(false));
					Platform.runLater(() ->vbxQteRecervoir.setVisible(false));
					Platform.runLater(() ->txtNomProfil.setVisible(false));
					Platform.runLater(()->btnClesVerrou.setVisible(false));
					Platform.runLater(()->lblLedDoubleTasse.setVisible(false));
					cafePro.setDoubleTasse(false);
		 			cafePro.setCafeMoulu(false);
		 			Platform.runLater(()->lblCafeMoulu.setText("0"));
					
					if( cafePro.isStateActive(State.MAIN_RINÇAGE)) {
						Platform.runLater(() ->lblAffichInfo.setVisible(true));
						Platform.runLater(() ->lblAffichInfo.setText("rincage en cours ..."));
					}
				}
				
				Platform.runLater(() ->lblNbreCafe.setText(cafePro.getNbreBoissonCook()+"")); // affiche le monbre de boisson preparee
				reservoirCafe.afficherNivoCafe(lblQteCafe);//permet d'afficher le nivo de cafe 
				reservoirEau.afficherNivoEau(lblQtiteEau);//permet d'afficher le nivo de l'eau
				bacCollecteur.affichNivoBacCollecteur(lblQteDechet);//permet d'afficher le nivo de dechet
				/* *****************               ecrand quand je suis dans l'etat setting **************************** */
				if(cafePro.isStateActive(State.MAIN_PREPARATION_R1_SETTINGS)) {
					Platform.runLater(() ->lblIntensiteCafe.setVisible(true));
					Platform.runLater(() ->lblQteBoisson.setVisible(true));
					Platform.runLater(() ->lblAffichInfo.setVisible(true));
					Platform.runLater(() ->lblAffichInfo1.setVisible(false));
				}
				/* ************************************** ecran quand je suis dans l'etat idle  ********************************** */
				if(cafePro.isStateActive(State.MAIN_IDLE)) {
					Platform.runLater(() ->paneEcran.setStyle("-fx-background-color: #"+"ffffff"));
					Platform.runLater(() ->btnExpresso.setDisable(false));
					Platform.runLater(() ->btnExpressoMacch.setDisable(false));
					Platform.runLater(() ->btnCafe.setDisable(false));
					Platform.runLater(() ->btnCappucino.setDisable(false));
					Platform.runLater(() ->btnMacchiato.setDisable(false));
					Platform.runLater(() ->btnCafeLait.setDisable(false));
					Platform.runLater(() ->btnMousseLait.setDisable(false));
					Platform.runLater(() ->btnBoissonSpecial.setDisable(false));
					Platform.runLater(() ->lblIntensiteCafe.setVisible(false));
					Platform.runLater(() ->lblQteBoisson.setVisible(false));
					Platform.runLater(() ->lblAffichInfo.setVisible(false));
					Platform.runLater(() ->lblAffichInfo1.setVisible(false));
					Platform.runLater(() ->txtNomProfil.setVisible(false));
					Platform.runLater(() ->btnVoirRecervois.setDisable(false));
					Platform.runLater(() ->btnPanne.setDisable(false));
					
					/**********      permet d'afficher le message d'interruption d'une boisson     */
					if(cafePro.getBreakCooking()==true) {
						Platform.runLater(() ->lblAffichInfo.setVisible(true));
						Platform.runLater(() ->lblAffichInfo.setText(" preparation  interrompu."));
						try {
							Thread.sleep(3000);
							Platform.runLater(() ->lblAffichInfo.setVisible(false));
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					/**********      affiche les messages   **********************/
				    if(filtreAeau.controlEtatFiltre(lblFiltreEau)!=null) {
						Platform.runLater(() ->lblAffichInfo1.setVisible(true));
						Platform.runLater(() ->lblAffichInfo1.setText(filtreAeau.controlEtatFiltre(lblFiltreEau)));
						try {
							Thread.sleep(1000);
							Platform.runLater(() ->lblAffichInfo1.setVisible(false));
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				    }
					if(message!=null) {
						Platform.runLater(() ->lblAffichInfo.setVisible(true));
						Platform.runLater(() ->lblAffichInfo.setText(message));
						try {
							Thread.sleep(3000);
							Platform.runLater(() ->lblAffichInfo.setVisible(false));
							message=null;
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
				/* *****************                      ce qui doit etre affiche quand je suis dans l'etat Erreur *************************/	
				if(cafePro.isStateActive(State.MAIN_ERREUR)) {
					Platform.runLater(() ->lblAffichInfo.setVisible(true));
					Platform.runLater(() ->lblIntensiteCafe.setVisible(false));
					Platform.runLater(() ->lblQteBoisson.setVisible(false));
					Platform.runLater(() -> lblAffichInfo.setText(configUsine.getListCodeErreur().get((int) cafePro.getCodeErreur())));
				}
				/* *****************                      ce qui doit etre affiche quand je suis dans l'etat Panne  *************************/	
				if(cafePro.isStateActive(State.MAIN_PANNE)) {
					if(cafePro.getPbDefailanceSys()==true) {
							Platform.runLater(() ->lblAffichInfo.setVisible(true));
							Platform.runLater(() -> lblAffichInfo.setText("defaillance systeme \n veuillez contacter le service clientele."));
					}
					if(cafePro.getPbEcran()==true){
						paneEcran.setStyle("-fx-background-color: #"+"ff0000");
					}
					else
						paneEcran.setStyle("-fx-background-color: #"+"ffffff");
				}
				/*  ******************************    affiche  le temps de maintenance    ****************************** */
				
				if(cafePro.isStateActive(State.MAIN_MENU_R1_EFFECTUERMAINTENANCE_R1_DETARTRE)) {
					Platform.runLater(() ->lblAffichInfo.setVisible(false));
					Platform.runLater(() ->lblAffichInfo1.setVisible(true));
					if(cafePro.getTimeMaintenance()>0) {
						Platform.runLater(() -> lblAffichInfo1.setText("detartrage en cours ... fin dans : "+cafePro.getTimeMaintenance()+"s"));
					}
					if(cafePro.getTimeMaintenance()==0)
						Platform.runLater(() ->lblAffichInfo1.setText(" fin de la maintenance "));
				}
				if(cafePro.isStateActive(State.MAIN_MENU_R1_EFFECTUERMAINTENANCE_R1_CALC_CLEAN)) {
					Platform.runLater(() ->lblAffichInfo.setVisible(false));
					Platform.runLater(() ->lblAffichInfo1.setVisible(true));
					if(cafePro.getTimeMaintenance()>0)
						Platform.runLater(() ->lblAffichInfo1.setText(" CALC_CLEAN en cours ...fin dans :"+cafePro.getTimeMaintenance()+"s"));
					if(cafePro.getTimeMaintenance()==0)
						Platform.runLater(() ->lblAffichInfo1.setText(" fin de la maintenance "));
				}
				if(cafePro.isStateActive(State.MAIN_MENU_R1_EFFECTUERMAINTENANCE_R1_NETOYAGE)) {
					Platform.runLater(() ->lblAffichInfo.setVisible(false));
					Platform.runLater(() ->lblAffichInfo1.setVisible(true));
					if(cafePro.getTimeMaintenance()>0)
						Platform.runLater(() ->lblAffichInfo1.setText("nettoyage en cours ... temps restant :"+cafePro.getTimeMaintenance()+"s"));
					if(cafePro.getTimeMaintenance()==0)
						Platform.runLater(() ->lblAffichInfo1.setText(" fin de la maintenance "));
				}
				
				if(cafePro.isStateActive(State.MAIN_MENU_R1_EFFECTUERMAINTENANCE_R1_NETOYAGEMOUSSEURLAIT)) {
					Platform.runLater(() ->lblAffichInfo.setVisible(false));
					Platform.runLater(() ->lblAffichInfo1.setVisible(true));
					if(cafePro.getTimeMaintenance()>0)
						Platform.runLater(() ->lblAffichInfo1.setText("netoyage mousseur de lait en cours ...fin dans :"+cafePro.getTimeMaintenance()+"s"));
					if(cafePro.getTimeMaintenance()==0)
						Platform.runLater(() ->lblAffichInfo1.setText(" fin de la maintenance "));
				}
				
				
				
				/* *****************            affiche le timer de preparation d'une boisson          **********************/ 
				
				
				if(cafePro.isStateActive(State.MAIN_PREPARATION_R1_COOKINGCAFE)){
					Platform.runLater(() ->lblAffichInfo.setVisible(true));
					Platform.runLater(() ->lblAffichInfo1.setVisible(true));
					if(cafePro.getTimeCooking()>0)
						Platform.runLater(() ->lblAffichInfo1.setText("Preparation boisson en cours fin dans ... : "+cafePro.getTimeCooking()));
					if(cafePro.getTimeCooking()==0) {
						Platform.runLater(() ->lblAffichInfo1.setText(" preparation terminée !! "));
						try {
							Thread.sleep(2000);
							Platform.runLater(() ->lblAffichInfo1.setText(" Regalez vous !! "));
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
		    	if(cafePro.isStateActive(State.MAIN_PREPARATION_R1_COOKINGCAFELACTE)){
		    		Platform.runLater(() ->lblAffichInfo.setVisible(true));
		    		Platform.runLater(() ->lblAffichInfo1.setVisible(true));
		    		if(cafePro.isStateActive(State.MAIN_PREPARATION_R1_COOKINGCAFELACTE_R1_LAIT)) {
			    		if(cafePro.getTimeTampon()>0)
							Platform.runLater(() ->lblAffichInfo1.setText("Preparation lait en cours ... : "+cafePro.getTimeTampon()));
			    		if(cafePro.getTimeTampon()==0) {
							Platform.runLater(() ->lblAffichInfo1.setText(" fin preparation lait !! "));
						}
		    		}

		    		if(cafePro.isStateActive(State.MAIN_PREPARATION_R1_COOKINGCAFELACTE_R1_CAFE)) {
			    		if(cafePro.getTimeCooking()>0)
							Platform.runLater(() ->lblAffichInfo1.setText("Preparation cafe en cours ... : "+cafePro.getTimeCooking()));
			    		if(cafePro.getTimeCooking()==0) {
							Platform.runLater(() ->lblAffichInfo1.setText(" Fin preparation cafe lacte !! "));
							try {
								Thread.sleep(2000);
								Platform.runLater(() ->lblAffichInfo1.setText(" Regalez vous !! "));
								Thread.sleep(2000);
								Platform.runLater(() ->lblAffichInfo1.setVisible(false));
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
		    		}
		    		cafePro.setLait(false); // ici j'ai mis le recervoir de lait à false pour dire que le recervoir est vide
		    		Platform.runLater(() ->lblReservoirLait.setText(0+""));
		    	}
		    	if(cafePro.isStateActive(State.MAIN_PREPARATION_R1_COOKINGEAUCHAUD)){
		    		Platform.runLater(() ->lblAffichInfo.setVisible(true));
		    		Platform.runLater(() ->lblAffichInfo1.setVisible(true));
		    		if(cafePro.getTimeCooking()>0)
						Platform.runLater(() ->lblAffichInfo1.setText("Preparation boisson en cours fin dans ... : "+cafePro.getTimeCooking()));
		    		if(cafePro.getTimeCooking()==0) {
						Platform.runLater(() ->lblAffichInfo1.setText(" preparation terminée !! "));
						try {
							Thread.sleep(3000);
							Platform.runLater(() ->lblAffichInfo1.setText(" Regalez vous !! "));
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
		    	}
		    	if(cafePro.isStateActive(State.MAIN_PREPARATION_R1_COOKINGLAIT)){
		    		Platform.runLater(() ->lblAffichInfo.setVisible(true));
		    		Platform.runLater(() ->lblAffichInfo1.setVisible(true));
		    		if(cafePro.getTimeCooking()>0)
						Platform.runLater(() ->lblAffichInfo1.setText("Preparation boisson en cours fin dans ... : "+cafePro.getTimeCooking()));
		    		if(cafePro.getTimeCooking()==0) {
						Platform.runLater(() ->lblAffichInfo1.setText(" preparation terminée !! "));
						try {
							Thread.sleep(3000);
							Platform.runLater(() ->lblAffichInfo1.setText(" Regalez vous !! "));
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
		    		cafePro.setLait(false); // ici j'ai mis le recervoir de lait à false pour dire que le recervoir est vide
		    		Platform.runLater(() ->lblReservoirLait.setText(0+""));
		    	}
		    } 
		});
		timer.start();
    }
    public void boissonChoisie(MouseEvent event) {
    	if(cafePro.getBipSonnore()==true)
    		java.awt.Toolkit.getDefaultToolkit().beep();
    	viewBandeau.selectBoisson(event, cafePro,lblQteBoisson,lblIntensiteCafe,lblAffichInfo, lblLedExpreso,lblLedExpressoMacch,lblLedCappucino,lblLedCafe,lblLedMachiato,lblLedCafeLait,lblLedMousseLait,lblLedBoissonSpecial);
    }
    public void choisirBoissonSpecial(MouseEvent event) {
    	if(cafePro.getBipSonnore()==true)
    		java.awt.Toolkit.getDefaultToolkit().beep();
    	viewBandeau.gestionBoissonSpecial(cafePro,lblAffichInfo,lblQteBoisson,lblIntensiteCafe,lblLedExpreso,lblLedExpressoMacch,lblLedCappucino,lblLedCafe,lblLedMachiato,lblLedCafeLait,lblLedMousseLait,lblLedBoissonSpecial);
    }
    public void regleIntensiteCafe(MouseEvent event) {
    	viewEcran.choisirIntensiteCafe(cafePro,lblIntensiteCafe);
    	if(cafePro.getBipSonnore()==true)
    		java.awt.Toolkit.getDefaultToolkit().beep();
    }
    public void regleQteBoisson(MouseEvent event) {
    	viewEcran.choisirQteBoisson(cafePro,lblQteBoisson);
    	if(cafePro.getBipSonnore()==true)
    		 java.awt.Toolkit.getDefaultToolkit().beep();
    }
    public void menu(MouseEvent event) {
    	cafePro.raiseMenu();
    	if(cafePro.isStateActive(State.MAIN_MENU)) {
    		lblAffichInfo.setVisible(true);
    		lblAffichInfo.setText(cafePro.getTxtOptionMenu());
        	if(cafePro.getBipSonnore()==true)
        		java.awt.Toolkit.getDefaultToolkit().beep();
    	}
    	
    }
    public void SeDeplacerDsMenu(MouseEvent event) {
    	if(cafePro.getBipSonnore()==true)
    		java.awt.Toolkit.getDefaultToolkit().beep();
    	viewMenu.seDeplacer( cafePro,lblAffichInfo,lblAffichInfo1,configUsine , txtNomProfil);
    }
    /* **************************************************              permet de valider ou de memoriser dans le Menu *************************************** */
    public void comfirmOuMemoriser(MouseEvent event){
    	if(cafePro.getBipSonnore()==true)
    		java.awt.Toolkit.getDefaultToolkit().beep();
    	txtNomProfil.setVisible(false);
    	message = viewMenu.confirmer( cafePro, lblPanneFiltre,lblAffichInfo1,lblAffichInfo,configUsine,txtNomProfil);
    }
    
    public void precedant(MouseEvent event) {
    	viewMenu.precedant( cafePro,lblAffichInfo,lblAffichInfo1);
    	if(cafePro.getBipSonnore()==true)
    		java.awt.Toolkit.getDefaultToolkit().beep();
    }
    public void start(MouseEvent event) {
    	if(cafePro.getBipSonnore()==true)
    		java.awt.Toolkit.getDefaultToolkit().beep();
    	viewBandeau.playStop( cafePro);
    	message=viewEcran.preparerBoissonFavori(cafePro, configUsine);
    }
    public void recervoirLait(MouseEvent event) { // va permettre de tire le recervoir de lait est place et qu'il ya du lait dedans
    	cafePro.setLait(true);
    	lblReservoirLait.setText(1+"");
    	if(cafePro.getBipSonnore()==true)
    		java.awt.Toolkit.getDefaultToolkit().beep();
    }
    public void afficheRecervoirs(MouseEvent event) { 
    	if(cafePro.getBipSonnore()==true)
    		java.awt.Toolkit.getDefaultToolkit().beep();
		if(vbxRecervoir.isVisible()==true) {
			Platform.runLater(() ->vbxRecervoir.setVisible(false));
			Platform.runLater(() ->vbxLait.setVisible(false));
			Platform.runLater(() ->vbxQteRecervoir.setVisible(false));
		}else {
			Platform.runLater(() ->vbxRecervoir.setVisible(true));
			Platform.runLater(() ->vbxLait.setVisible(true));
			Platform.runLater(() ->vbxQteRecervoir.setVisible(true));	
		}
    }
  /* ****************                 permet de rendre la partie permettant de declanche une panne visible ou de la cacher     ***************/
    public void afficheOptionsPanne(MouseEvent event) { 
    	if(cafePro.getBipSonnore()==true)
    		java.awt.Toolkit.getDefaultToolkit().beep();
		if(panePanne.isVisible()==true) {
			panePanne.setVisible(false);
		}else {
			panePanne.setVisible(true);	
		}
    }
    
    /* ************************          permet de gerer la securite enfant et les boisson favori           ******************************/
    int compteur = 0;
    public void favoriEtSecuriteEnfant1(MouseEvent event){
    	compteur=(int) cafePro.getTemps();
    }
    public void favoriEtSecuriteEnfant2(MouseEvent event){
    	if(cafePro.getBipSonnore()==true)
    		java.awt.Toolkit.getDefaultToolkit().beep();
    	if(cafePro.getTemps()-compteur<3)
    		viewEcran.appelBoissonFavori(cafePro, lblAffichInfo, configUsine);
    	else
    		if(cafePro.getTemps()-compteur>=3)
    			cafePro.raiseBtnSecurite();
    			if(cafePro.isStateActive(State.MAIN_SECURITE)){
    				btnClesVerrou.setVisible(true);
    			}
    			else {
    				btnClesVerrou.setVisible(false);
    			}
    				
    }
    public void doubleTasse(MouseEvent event) { 
    	if(cafePro.getBipSonnore()==true)
    		java.awt.Toolkit.getDefaultToolkit().beep();
    	if(cafePro.isStateActive(State.MAIN_PREPARATION))
	 		if(cafePro.getDoubleTasse()==true) {
	 			cafePro.setDoubleTasse(false);
	 			lblLedDoubleTasse.setVisible(false);
	 		}else {
	 			cafePro.setDoubleTasse(true);
	 			lblLedDoubleTasse.setVisible(true);
	 		}
     }
    public void mettreCafeMoulu(MouseEvent event) { //permet de remplir ou de vide le recervoir du cafe moulu.
    	if(cafePro.getBipSonnore()==true)
    		java.awt.Toolkit.getDefaultToolkit().beep();
    	if(cafePro.isStateActive(State.MAIN_STOP) ||cafePro.isStateActive(State.MAIN_IDLE))
	    	if(cafePro.getCafeMoulu()==true) {
		 		cafePro.setCafeMoulu(false);
		 		lblCafeMoulu.setText("0");
		 	}else {
		 		cafePro.setCafeMoulu(true);
		 		lblCafeMoulu.setText("1");
		 	}
     }
    public void regleDegreMouture(MouseEvent event) { 
    	if(cafePro.isStateActive(State.MOULIN_ACTIVEM)){
    		cafePro.raiseBtnMouture();
    		lblDegreMouture.setText((cafePro.getDegreMouture()+1)+"");
    	}
     }
    FiltreAeau filtreAeau = new FiltreAeau(cafePro);
    public void gestionFiltreEau(MouseEvent event) { 
    	if(cafePro.getBipSonnore()==true)
    		java.awt.Toolkit.getDefaultToolkit().beep();
    	filtreAeau.FiltreRemplace(lblFiltreEau,lblPanneFiltre);
     }
    public void gestionTuyauALait(MouseEvent event) { 
    	if(cafePro.getBipSonnore()==true)
    		java.awt.Toolkit.getDefaultToolkit().beep();
    	if(cafePro.getTuyauAlait()==true) {
	 		cafePro.setTuyauAlait(false);
	 		lblTuyauAlait.setText("0");
	 	}else {
	 		cafePro.setTuyauAlait(true);
	 		lblTuyauAlait.setText("1");
	 	}
     }
    public void connectTuyauEtTubeAspi(MouseEvent event){ 
    	if(cafePro.getBipSonnore()==true)
    		java.awt.Toolkit.getDefaultToolkit().beep();
    	if(cafePro.getConnectTubeEtTuyau()==true) {
	 		cafePro.setConnectTubeEtTuyau(false);
	 		lblTubeTuyau.setText("0");
	 	}else {
	 		cafePro.setConnectTubeEtTuyau(true);
	 		lblTubeTuyau.setText("1");
	 	}
     }
    ReservoirCafe reservoirCafe= new ReservoirCafe(cafePro);
    public void gestionRecervoirCafe(MouseEvent event) { 
    	if(cafePro.getBipSonnore()==true)
    		java.awt.Toolkit.getDefaultToolkit().beep();
    	reservoirCafe.ajouterCafe(5);
     }
    ReservoirEau reservoirEau= new ReservoirEau(cafePro);
    public void gestionRecervoirEau(MouseEvent event) { 
    	reservoirEau.ajouterEau(10);
    	if(cafePro.getBipSonnore()==true)
    		java.awt.Toolkit.getDefaultToolkit().beep();
     }
    BacCollecteur bacCollecteur = new BacCollecteur(cafePro);
    public void gestionBacCollecteur(MouseEvent event) { 
    	if(cafePro.getBipSonnore()==true)
    		java.awt.Toolkit.getDefaultToolkit().beep();
    	bacCollecteur.viderBacCollecteur();
     }
    public void gestionPanne(MouseEvent event) { 
    	if(cafePro.getBipSonnore()==true)
    		java.awt.Toolkit.getDefaultToolkit().beep();
    	 viewPanne.panne(event, cafePro,paneEcran, lblPanneMoulin, lblPanneMousseur, lblDefaillance, lblPanneFiltre, lblPanneBandeau, lblPanneEcran);
     }
}

