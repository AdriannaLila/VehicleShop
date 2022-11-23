package org.makerminds.jcoaching.finalexam.console.gui;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import org.makerminds.jcoaching.finalexam.controller.VehicleFileManager;
import org.makerminds.jcoaching.finalexam.controller.VehicleTransformer;
import org.makerminds.jcoaching.finalexam.model.Vehicle;
public class VehicleShopGUI {

	private JFrame frame;
	private final String VEHICLE_FILE_PATH ="/vehicle-list.txt";
	private DefaultTableModel vehicleDefaultTableModel=new DefaultTableModel();
	JTable vehicleDataTable=new JTable(vehicleDefaultTableModel);

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VehicleShopGUI window = new VehicleShopGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VehicleShopGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1000, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JLabel applicationNameLabel = new JLabel("VEHICLE SHOP");
		applicationNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(applicationNameLabel,BorderLayout.NORTH);
		
         prepareVehicleDataTable();
         
		JScrollPane scrollPane=new JScrollPane(vehicleDataTable);
		scrollPane.setBorder(BorderFactory.createTitledBorder("AVAIABLE VEHICLES"));
		frame.getContentPane().add(scrollPane);
		
		JPanel panel=new JPanel();
		JButton sellButtonCreated=createSellButton();
		panel.add(sellButtonCreated);
		panel.add(scrollPane);
		frame.getContentPane().add(panel);
	}	
	private void prepareVehicleDataTable() {
		String  [] tableHeader= {"ID","Manufacturer","Model","Velocity","Price","Color","Kilometer","Production Year","Fuel Type","Transmission"};
			String [] [] vehicleItemListMultidimensionalArray= createVehicleArray();
			vehicleDefaultTableModel.setDataVector(vehicleItemListMultidimensionalArray, tableHeader);	
		}
	private JButton createSellButton() {
		JButton sellButton=new JButton("SELL");
		sellButton.setBounds(90,115,90,36);	
		sellButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
					int i=vehicleDataTable.getSelectedRow();
				vehicleDefaultTableModel.removeRow(i);
				
			}
		});
		return sellButton;
	}
	private List<Vehicle> getVehicleListAsList() {
		
		VehicleFileManager vehicleFileManager=new VehicleFileManager(VEHICLE_FILE_PATH);
		List<String> vehicleDataAsStringList =vehicleFileManager.importVehiclesFromFile();
		VehicleTransformer vehicleTransformer=new VehicleTransformer();
		List<Vehicle> vehicleList = vehicleTransformer.transformDataArrayToVehicleObjects(vehicleDataAsStringList);
		
		return vehicleList;
	}
	
	private String[][] createVehicleArray() {
		
		List<Vehicle>vehicles=getVehicleListAsList();
		String [][]  vehicleListMultidimensionalArray=new String[vehicles.size()][10];
		Iterator<Vehicle>it=vehicles.iterator();
		int i=0;
	while(it.hasNext()) {
			Vehicle vehicle = it.next();
			vehicleListMultidimensionalArray[i][0] = Integer.toString(vehicle.getID());
			vehicleListMultidimensionalArray[i][1]=vehicle.getManufacturer().toString();
			vehicleListMultidimensionalArray[i][2]=vehicle.getModel();
			vehicleListMultidimensionalArray[i][3]=Integer.toString(vehicle.getVelocity());
			vehicleListMultidimensionalArray[i][4]=Double.toString(vehicle.getPrice());
			vehicleListMultidimensionalArray[i][5]=vehicle.getColor().toString();
			vehicleListMultidimensionalArray[i][6]=Integer.toString(vehicle.getKilometers());
			vehicleListMultidimensionalArray[i][7]=Integer.toString(vehicle.getProductionYear());
			vehicleListMultidimensionalArray[i][8]=vehicle.getFuelType().toString();
			vehicleListMultidimensionalArray[i][9]=vehicle.getTransmission().toString();
			i++;
			
		}
		return vehicleListMultidimensionalArray;
	}

}
