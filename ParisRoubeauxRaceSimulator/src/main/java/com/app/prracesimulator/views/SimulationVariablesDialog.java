package com.app.prracesimulator.views;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.SwingConstants;

import com.app.prracesimulator.controllers.Actions;
import com.app.prracesimulator.controllers.Controller;
import com.app.prracesimulator.models.entities.RaceConstants;

public class SimulationVariablesDialog extends JFrame {

	private static final long serialVersionUID = 1L;
	private JButton btnIniciar;
	private JSpinner jSpLongitud;
	private JSpinner jSpNumCiclistas;
	private JSpinner jSpFitnessMax;
	private JSpinner jSpFatigaMin;
	private JSpinner jSpCansancio;
	private JSpinner jSpDescanso;
	private JSpinner jSpFitnessMin;
	private JSpinner jSpFatigaMax;

	public SimulationVariablesDialog(Controller controller) {
		designWindow();
		setSize(400, 500);
		setLocationRelativeTo(null);
		initComponents();
		setActions(controller);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	private void initComponents() {
		GridSystem gridSystem = new GridSystem(this);
		gridSystem.addExternalBorder(10, 0, 10, 0);
		JLabel longitud = new JLabel("Longitud: ");
		jSpLongitud = new JSpinner();
		jSpLongitud.setValue(RaceConstants.RACE_LENGTH);
		add(longitud, gridSystem.insertComponent(1, 2, 6, 1));
		add(jSpLongitud, gridSystem.insertComponent(1, 5, 5, 1));

		JLabel numCiclistas = new JLabel("# Ciclistas: ");
		jSpNumCiclistas = new JSpinner();
		jSpNumCiclistas.setValue(RaceConstants.NUMBER_OF_CYCLISTS);
		add(numCiclistas, gridSystem.insertComponent(3, 2, 6, 1));
		add(jSpNumCiclistas, gridSystem.insertComponent(3, 5, 5, 1));
		JLabel fitness = new JLabel("Fitness ");
		jSpFitnessMin = new JSpinner();
		jSpFitnessMin.setValue(RaceConstants.MIN_FITNESS);

		add(fitness, gridSystem.insertComponent(4, 2, 6, 1));
		add(new JLabel("Min:", SwingConstants.RIGHT), gridSystem.insertComponent(5, 3, 1, 1));
		add(jSpFitnessMin, gridSystem.insertComponent(5, 5, 1, 1));

		jSpFitnessMax = new JSpinner();
		jSpFitnessMax.setValue(RaceConstants.MAX_FITNESS);
		add(new JLabel("Max:"), gridSystem.insertComponent(5, 7, 1, 1));
		add(jSpFitnessMax, gridSystem.insertComponent(5, 8, 1, 1));

		JLabel fatiga = new JLabel("Rango Fatiga Inicial ");
		add(fatiga, gridSystem.insertComponent(6, 2, 6, 1));
		jSpFatigaMin = new JSpinner();
		jSpFatigaMin.setValue(RaceConstants.MIN_FATIGUE_INIT);
		add(new JLabel("Min:", SwingConstants.RIGHT), gridSystem.insertComponent(7, 3, 1, 1));
		add(jSpFatigaMin, gridSystem.insertComponent(7, 5, 1, 1));

		jSpFatigaMax = new JSpinner();
		jSpFatigaMax.setValue(RaceConstants.MAX_FATIGUE_INIT);
		add(new JLabel("Max:"), gridSystem.insertComponent(7, 7, 1, 1));
		add(jSpFatigaMax, gridSystem.insertComponent(7, 8, 1, 1));

		JLabel cansancio = new JLabel("Cansancio: ");
		jSpCansancio = new JSpinner();
		jSpCansancio.setValue(RaceConstants.TIREDNESS_FACTOR);
		add(cansancio, gridSystem.insertComponent(8, 2, 6, 1));
		add(jSpCansancio, gridSystem.insertComponent(8, 5, 5, 1));

		JLabel descanso = new JLabel("Descanso: ");
		jSpDescanso = new JSpinner();
		jSpDescanso.setValue(RaceConstants.RESTENESS_FACTOR);
		add(descanso, gridSystem.insertComponent(9, 2, 6, 1));
		add(jSpDescanso, gridSystem.insertComponent(9, 5, 5, 1));

		btnIniciar = new JButton("Empezar");
		add(btnIniciar, gridSystem.insertComponent(10, 5, 3, 1));
	}

	/**
	 * 
	 * @param controller
	 */
	public void setActions(Controller controller) {
		btnIniciar.setActionCommand(Actions.SIMULATE.name());
		btnIniciar.addActionListener(controller);
	}

	public String getjSpLongitud() {
		return jSpLongitud.getValue().toString().replace(".", "");
	}

	public String getjSpNumCiclistas() {
		return jSpNumCiclistas.getValue().toString().replace(".", "");
	}

	public String getjSpFitnessMax() {
		return jSpFitnessMax.getValue().toString().replace(".", "");
	}

	public String getjSpFatigaMin() {
		return jSpFatigaMin.getValue().toString().replace(".", "");
	}

	public String getjSpFitnessMin() {
		return jSpFitnessMin.getValue().toString().replace(".", "");
	}

	public String getjSpFatigaMax() {
		return jSpFatigaMax.getValue().toString().replace(".", "");
	}

	public String getjSpCansancio() {
		return jSpCansancio.getValue().toString().replace(".", "");
	}

	public String getjSpDescanso() {
		return jSpDescanso.getValue().toString().replace(".", "");
	}

	private static void designWindow() {
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(SimulationVariablesDialog.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(SimulationVariablesDialog.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(SimulationVariablesDialog.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(SimulationVariablesDialog.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		}
	}
}
