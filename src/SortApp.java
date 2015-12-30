

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
 * Displays the main app window, controls the UI
 * elements and handles start/stop behavior.
 * @author Jason
 *
 */

public class SortApp {
	
	/*
	 * These values should be set by the user in the future.
	 */
	static int size = 20;
	static int sortIncrement = 1;
	static int sortRapidInterval = 10;
	
	static JButton normBtn, stepBtn, rapidBtn, scrambleBtn;
	
	static RandomArray rArrayObj = new RandomArray(size,RandomArray.GENTYPE_RANDOM);
	public static GraphPanel displayPanel;
	static ComparisonSort sortOp;
	static Timer rapidTimer;
	
	private static void createAndShowGUI() {
		JFrame frame = new JFrame("Sorting Algorithm Visualizer");
		frame.setPreferredSize(new Dimension(800,610));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel contentPanel = new JPanel();
		contentPanel.setPreferredSize(new Dimension(800,610));
		frame.getContentPane().add(contentPanel);
		
		JPanel inputPanel = new JPanel();
		contentPanel.add(inputPanel);
		
		JTextField inputArea = new JTextField(60);
		
		inputPanel.add(inputArea);
		inputArea.setText("input a list here (not yet implemented)");
		inputArea.setEnabled(false); // manual input not yet implemented
		
		displayPanel = new GraphPanel(rArrayObj);
		displayPanel.setPreferredSize(new Dimension(750,500));
		contentPanel.add(displayPanel);
		
		normBtn = new JButton("Sort now");
		normBtn.addActionListener(new ActionListener()
        {
        	  public void actionPerformed(ActionEvent e)
        	  {
        		  sortOp.normSort();
        		  refreshGraphPanel();
        	  }
        });
		contentPanel.add(normBtn);
		
		stepBtn = new JButton("Step");
		stepBtn.addActionListener(new ActionListener()
        {
        	  public void actionPerformed(ActionEvent e)
        	  {
        		  sortOp.stepSort(sortIncrement);
        		  refreshGraphPanel();
        	  }
        });
	    contentPanel.add(stepBtn);
	    	    
	    final ActionListener rapidBtnsort = new ActionListener()
        {
      	  public void actionPerformed(ActionEvent e)
      	  {
      		sortOp.stepSort(sortIncrement);
      		if (sortOp.sortDone()){
  			  rapidTimer.stop();
  		    }
      		refreshGraphPanel();
      	  }
        }; 
	    
        rapidTimer = new Timer(sortRapidInterval,rapidBtnsort);
        
	    rapidBtn = new JButton("Rapidstep");
	    rapidBtn.addActionListener(new ActionListener()
        {
        	  public void actionPerformed(ActionEvent e)
        	  {
        		  stepBtn.setEnabled(false);
        		  rapidBtn.setEnabled(false);
        		  rapidTimer.start();
        	  }
        });
	    contentPanel.add(rapidBtn);
	    
	    /**/
	    
	    scrambleBtn = new JButton("Scramble");
	    scrambleBtn.addActionListener(new ActionListener()
        {
        	  public void actionPerformed(ActionEvent e)
        	  {
        		  rArrayObj.genArray(RandomArray.GENTYPE_RANDOM);
        		  rapidTimer.stop();
        		  normBtn.setText("Sort now");
              	  normBtn.setEnabled(true);
              	  stepBtn.setText("Step");
              	  stepBtn.setEnabled(true);
              	  rapidBtn.setText("Rapidstep");
              	  rapidBtn.setEnabled(true);
        		  sortOp = new BubbleSort(rArrayObj);
        		  //sortOp = new SelectionSort(rArrayObj);
        		  /*
        		   * Sort object needs to be re-initialized.
        		   * There has to be a better way to do this.
        		   */
        		  displayPanel.initArray(rArrayObj);
        		  refreshGraphPanel();
        	  }
        });
	    contentPanel.add(scrambleBtn);
	    
	    /**/
	    
		frame.pack();
		frame.setVisible(true);
	}
	 
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
        sortOp = new BubbleSort(rArrayObj);
        // sortOp = new SelectionSort(rArrayObj);
        /*
         * User selection of sorting algorithms is not yet implemented.
         */
    }
    public static void refreshGraphPanel(){
		displayPanel.repaint();
		if (sortOp.sortDone()){
        	normBtn.setText("SORT DONE");
        	normBtn.setEnabled(false);
        	stepBtn.setText("HOO");
        	stepBtn.setEnabled(false);
        	rapidBtn.setText("RAY");
        	rapidBtn.setEnabled(false);
        }
    }
}

/**
 * Creates a graphical representation of the array being sorted.
 * Indices are represented by the x-coordinates on a sorted graph,
 * while the y-coordinates represent the array values at those indices.
 * 
 * Could I add the updateDraw() method right into paintComponent()?
 * 
 * Both methods run every time I repaint anyway. I'll think about it.
 * @author Jason
 *
 */

class GraphPanel extends JPanel{
	/**
	 * This isn't important.
	 */
	private static final long serialVersionUID = 1L;
	int size, spaceWidth, topSpacer, headingSpaceWidth, totalBarWidth;
	int[] plotX, plotY, array;
	boolean separateBars = true;
	public GraphPanel(RandomArray a){
		initArray(a);
	}
	public void initArray(RandomArray a){
		this.array = a.getArray();
		size = array.length;
		plotX = new int[size];
		plotY = new int[size];
		spaceWidth = Math.round((float)670/size);
		topSpacer = Math.round((float)400/size);
		if (topSpacer>40){
			topSpacer = 40;
		}
		if(separateBars){
			headingSpaceWidth = spaceWidth/16;
			totalBarWidth = 7*spaceWidth/8;
		}
		else{
			headingSpaceWidth = 0;
			totalBarWidth = spaceWidth;
		}
	}
	public void paintComponent(Graphics g){
		for(int i = 0; i< size; i++){
			plotX[i] = (int)(i*(670.0/size)) + 40;
			plotY[i] = (int)((double)array[i]/size*400);
		}
		g.setColor(Color.WHITE);
		g.fillRect(10, 10, 730, 480);
		g.setColor(Color.BLACK);
		g.drawRect(10, 10, 730, 480);
		g.drawLine(40, 460, 710, 460);
		for (int i = 0; i < plotX.length; i++){
			drawBar(i,g);
		}
		drawIndicator(g);
	}
	public void drawBar(int i, Graphics g){

		g.setColor(Color.LIGHT_GRAY);
		g.fillRect((plotX[i]+headingSpaceWidth), (460-plotY[i]),
				totalBarWidth, plotY[i]);
		g.setColor(Color.BLACK);
		g.fillRect((plotX[i]+headingSpaceWidth), 460-plotY[i]-topSpacer,
				totalBarWidth, topSpacer);
	}
	public void drawIndicator(Graphics g){
		/*
		 * drawIndicators(): includes differentiation of different indicator
		 * class types (not yet implemented)
		 */
		//SortApp.sortOp.drawIndicators();
		g.setColor(Color.RED);
		g.fillRect(plotX[SortApp.sortOp.getIndex()]+headingSpaceWidth, 480,
				totalBarWidth, 10);
	}
}
