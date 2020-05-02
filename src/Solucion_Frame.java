import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 * Clase Solucion_Frame
 * @author Pedro Miguel Carmona & Ruben Marin Lucas
 */
public class Solucion_Frame extends javax.swing.JFrame {

  private JButton [][] botones = new JButton[8][8];
  private String[] solucion;
  private int indexSolucion;
  private GestorSolucion g;

  /**
   * Creates new form Solucion_Frame
   */
  public Solucion_Frame(GestorSolucion g, String puzzle, String metodo) {
    this.g = g;
    initComponents();
    indexSolucion = 0;
    jLabel1.setText("Solución " + puzzle + ":");
    labelSolucion.setText(g.getSolucionFinal());
    labelSolucion.setFont(new java.awt.Font("Roboto Lt", 2, 20)); // NOI18N
    numNodosInt.setText(g.getNumNodos() + "");
    numNodosInt1.setText(String.format("%.0f",g.getTiempoEjecucion())+ " ns");
    setBotones();
    setValores();
    ocultarNulos();
    trozearSolucion();   
    printSolucion(puzzle, metodo);
    ImageIcon img = new ImageIcon("resources/unex.png");
    setIconImage(img.getImage());
    this.setResizable(true);
    setVisible(true);
  }
  
  
  private void moverNorte(String numero, int i, int j) {
	  ocultar(i,j);
	  mostrar(i-1, j, numero);
  }
  
  private void moverSur(String numero, int i, int j) {
	  ocultar(i,j);
	  mostrar(i+1, j, numero);
  }
  
  private void moverEste(String numero, int i, int j) {
	  ocultar(i,j);
	  mostrar(i,j+1,numero);
  }
  
  private void moverOeste(String numero, int i, int j) {
	  ocultar(i,j);
	  mostrar(i, j-1,numero);
  }
  
  private void accion(String numero, char direccion) {
	 
	  boolean enc = false;
	  int i = 0;
	  int j = 0;
	  
	  while(i < botones.length && !enc) {
		  j = 0;
		  while(j < botones.length && !enc) {
			  if(botones[i][j].getText().equals(numero)) enc = true;
			  j++;
		  }
		  i++;
	  }

	 switch (direccion) {
	case 'N':
		moverNorte(numero, i-1, j-1);
		break;
	case 'S':
		moverSur(numero, i-1, j-1);
		break;
	case 'E':
		moverEste(numero, i-1, j-1);
		break;
	case 'O':
		moverOeste(numero, i-1, j-1);
		break;
	default:
		break;
	}
	  
  }
  
  private boolean isLetra(String s) {
	  if(s.equals("N") || s.equals("S") || s.equals("O") || s.equals("E")) return true;
	  else return false;
  }
  
  private void printSolucion(String puzzle, String metodo) {
	  
	  System.out.println("Solución del " + puzzle + " resuelto por el metodo " + metodo + ":");
	  
	  for (String s : solucion) System.out.print(s + " ");
	  
	  System.out.println();
	  System.out.println();
	  
	  
  }
  
  private void trozearSolucion() {
	  String[] s = g.getSolucionFinal().replace(" ", "").split("");
	  int j = 0;
	  String palabra = "";
	  int cont = 0;
	  
	  for (int i = 0; i < s.length; i++) {
		 if(isLetra(s[i])) {
			palabra += s[i];
			s[j] = palabra;
			j++;
			cont++;
			palabra = "";
		 }else {
			 palabra += s[i];
					 
		 }
	  }
	  
	  solucion = new String[cont];
	  for (int i = 0; i < cont; i++) 
		  solucion[i] = s[i];
		
  }
  
  private void mostrar(int i, int j, String numero) {
	  botones[i][j].setText(numero);
	  botones[i][j].setBorderPainted(true);
  }
  
  private void ocultar(int i, int j) {
	  botones[i][j].setText("");
	  botones[i][j].setBorderPainted(false);
  }
  
  private void ocultarNulos() {

    for (int i = 0; i < botones.length; i++) {
    	 for (int j = 0; j < botones.length; j++) {
       	  	if (botones[i][j].getText().equals("0")) {
       	      ocultar(i,j);
       	  	}
    	 }
    }
     
    

  }
  
  private void setValores() { 
	    for (int i = 0; i < g.getTamTablero(); i++) 
	    	 for (int j = 0; j < g.getTamTablero(); j++) 
	    		 botones[i][j].setText(g.getValor(i, j) + "");    
  }
  
  private void setBotones(){
	  	
        botones [0][0] = boton00;
        botones [0][1] = boton01;
        botones [0][2] = boton02;
        botones [0][3] = boton03;
        botones [0][4] = boton04;
        botones [0][5] = boton05;
        botones [0][6] = boton06;
        botones [0][7] = boton07;
        botones [1][0] = boton10;
        botones [1][1] = boton11;
        botones [1][2] = boton12;
        botones [1][3] = boton13;
        botones [1][4] = boton14;
        botones [1][5] = boton15;
        botones [1][6] = boton16;
        botones [1][7] = boton17;
        botones [2][0] = boton20;
        botones [2][1] = boton21;
        botones [2][2] = boton22;
        botones [2][3] = boton23;
        botones [2][4] = boton24;
        botones [2][5] = boton25;
        botones [2][6] = boton26;
        botones [2][7] = boton27;
        botones [3][0] = boton30;
        botones [3][1] = boton31;
        botones [3][2] = boton32;
        botones [3][3] = boton33;
        botones [3][4] = boton34;
        botones [3][5] = boton35;
        botones [3][6] = boton36;
        botones [3][7] = boton37;
        botones [4][0] = boton40;
        botones [4][1] = boton41;
        botones [4][2] = boton42;
        botones [4][3] = boton43;
        botones [4][4] = boton44;
        botones [4][5] = boton45;
        botones [4][6] = boton46;
        botones [4][7] = boton47;
        botones [5][0] = boton50;
        botones [5][1] = boton51;
        botones [5][2] = boton52;
        botones [5][3] = boton53;
        botones [5][4] = boton54;
        botones [5][5] = boton55;
        botones [5][6] = boton56;
        botones [5][7] = boton57;
        botones [6][0] = boton60;
        botones [6][1] = boton61;
        botones [6][2] = boton62;
        botones [6][3] = boton63;
        botones [6][4] = boton64;
        botones [6][5] = boton65;
        botones [6][6] = boton66;
        botones [6][7] = boton67;
        botones [7][0] = boton70;
        botones [7][1] = boton71;
        botones [7][2] = boton72;
        botones [7][3] = boton73;
        botones [7][4] = boton74;
        botones [7][5] = boton75;
        botones [7][6] = boton76;
        botones [7][7] = boton77;

    }

  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jToggleButton1 = new javax.swing.JToggleButton();
        jToggleButton2 = new javax.swing.JToggleButton();
        jPanel2 = new javax.swing.JPanel();
        labelSolucion = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        boton00 = new javax.swing.JButton();
        boton01 = new javax.swing.JButton();
        boton02 = new javax.swing.JButton();
        boton03 = new javax.swing.JButton();
        boton04 = new javax.swing.JButton();
        boton05 = new javax.swing.JButton();
        boton06 = new javax.swing.JButton();
        boton07 = new javax.swing.JButton();
        boton10 = new javax.swing.JButton();
        boton11 = new javax.swing.JButton();
        boton12 = new javax.swing.JButton();
        boton13 = new javax.swing.JButton();
        boton14 = new javax.swing.JButton();
        boton15 = new javax.swing.JButton();
        boton16 = new javax.swing.JButton();
        boton17 = new javax.swing.JButton();
        boton20 = new javax.swing.JButton();
        boton21 = new javax.swing.JButton();
        boton22 = new javax.swing.JButton();
        boton23 = new javax.swing.JButton();
        boton24 = new javax.swing.JButton();
        boton25 = new javax.swing.JButton();
        boton26 = new javax.swing.JButton();
        boton27 = new javax.swing.JButton();
        boton30 = new javax.swing.JButton();
        boton31 = new javax.swing.JButton();
        boton32 = new javax.swing.JButton();
        boton33 = new javax.swing.JButton();
        boton34 = new javax.swing.JButton();
        boton35 = new javax.swing.JButton();
        boton36 = new javax.swing.JButton();
        boton37 = new javax.swing.JButton();
        boton40 = new javax.swing.JButton();
        boton41 = new javax.swing.JButton();
        boton42 = new javax.swing.JButton();
        boton43 = new javax.swing.JButton();
        boton44 = new javax.swing.JButton();
        boton45 = new javax.swing.JButton();
        boton46 = new javax.swing.JButton();
        boton47 = new javax.swing.JButton();
        boton50 = new javax.swing.JButton();
        boton51 = new javax.swing.JButton();
        boton52 = new javax.swing.JButton();
        boton53 = new javax.swing.JButton();
        boton54 = new javax.swing.JButton();
        boton55 = new javax.swing.JButton();
        boton56 = new javax.swing.JButton();
        boton57 = new javax.swing.JButton();
        boton60 = new javax.swing.JButton();
        boton61 = new javax.swing.JButton();
        boton62 = new javax.swing.JButton();
        boton63 = new javax.swing.JButton();
        boton64 = new javax.swing.JButton();
        boton65 = new javax.swing.JButton();
        boton66 = new javax.swing.JButton();
        boton67 = new javax.swing.JButton();
        boton70 = new javax.swing.JButton();
        boton71 = new javax.swing.JButton();
        boton72 = new javax.swing.JButton();
        boton73 = new javax.swing.JButton();
        boton74 = new javax.swing.JButton();
        boton75 = new javax.swing.JButton();
        boton76 = new javax.swing.JButton();
        boton77 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        numNodosString = new javax.swing.JLabel();
        numNodosInt = new javax.swing.JLabel();
        numNodosString1 = new javax.swing.JLabel();
        numNodosInt1 = new javax.swing.JLabel();
        otro_puzzle = new javax.swing.JButton();

      

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jToggleButton1.setBackground(new java.awt.Color(255, 255, 255));
        jToggleButton1.setIcon(new ImageIcon("resources/flec_der.png"));
        jToggleButton1.setBorderPainted(false);
        jToggleButton1.setContentAreaFilled(false);
        jToggleButton1.setFocusPainted(false);
        jToggleButton1.setFocusable(false);
        jToggleButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jToggleButton1MouseClicked(evt);
            }
        });
      

        jToggleButton2.setBorderPainted(false);
        jToggleButton2.setIcon(new ImageIcon("resources/flec_izq.png"));
        jToggleButton2.setContentAreaFilled(false);
        jToggleButton2.setFocusPainted(false);
        jToggleButton2.setFocusable(false);
        jToggleButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jToggleButton2MouseClicked(evt);
            }
        });
       

        jPanel2.setBackground(new java.awt.Color(51, 153, 255));

        labelSolucion.setFont(new java.awt.Font("Roboto Lt", 2, 36)); // NOI18N
        labelSolucion.setForeground(new java.awt.Color(255, 255, 255));
        labelSolucion.setText("7N 3O 5E");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelSolucion, javax.swing.GroupLayout.PREFERRED_SIZE, 494, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelSolucion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setFont(new java.awt.Font("Roboto Lt", 0, 24)); // NOI18N

        boton00.setBackground(new java.awt.Color(255, 255, 255));
        boton00.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        boton00.setText("1");
        boton00.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 153, 255), 2, true));
        boton00.setContentAreaFilled(false);
        boton00.setFocusPainted(false);
        boton00.setFocusable(false);
        boton00.setRequestFocusEnabled(false);
        boton00.setRolloverEnabled(false);

        boton01.setBackground(new java.awt.Color(255, 255, 255));
        boton01.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        boton01.setText("2");
        boton01.setToolTipText("");
        boton01.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 153, 255), 2, true));
        boton01.setContentAreaFilled(false);
        boton01.setFocusPainted(false);
        boton01.setFocusable(false);
        boton01.setRequestFocusEnabled(false);
        boton01.setRolloverEnabled(false);

        boton02.setBackground(new java.awt.Color(255, 255, 255));
        boton02.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        boton02.setText("0");
        boton02.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 153, 255), 2, true));
        boton02.setContentAreaFilled(false);
        boton02.setFocusPainted(false);
        boton02.setFocusable(false);
        boton02.setRequestFocusEnabled(false);
        boton02.setRolloverEnabled(false);

        boton03.setBackground(new java.awt.Color(255, 255, 255));
        boton03.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        boton03.setText("4");
        boton03.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 153, 255), 2, true));
        boton03.setContentAreaFilled(false);
        boton03.setFocusPainted(false);
        boton03.setFocusable(false);
        boton03.setRequestFocusEnabled(false);
        boton03.setRolloverEnabled(false);

        boton04.setBackground(new java.awt.Color(255, 255, 255));
        boton04.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        boton04.setText("0");
        boton04.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 153, 255), 2, true));
        boton04.setContentAreaFilled(false);
        boton04.setFocusPainted(false);
        boton04.setFocusable(false);
        boton04.setRequestFocusEnabled(false);
        boton04.setRolloverEnabled(false);

        boton05.setBackground(new java.awt.Color(255, 255, 255));
        boton05.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        boton05.setText("0");
        boton05.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 153, 255), 2, true));
        boton05.setContentAreaFilled(false);
        boton05.setFocusPainted(false);
        boton05.setFocusable(false);
        boton05.setRequestFocusEnabled(false);
        boton05.setRolloverEnabled(false);

        boton06.setBackground(new java.awt.Color(255, 255, 255));
        boton06.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        boton06.setText("0");
        boton06.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 153, 255), 2, true));
        boton06.setContentAreaFilled(false);
        boton06.setFocusPainted(false);
        boton06.setFocusable(false);
        boton06.setRequestFocusEnabled(false);
        boton06.setRolloverEnabled(false);


        boton07.setBackground(new java.awt.Color(255, 255, 255));
        boton07.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        boton07.setText("0");
        boton07.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 153, 255), 2, true));
        boton07.setContentAreaFilled(false);
        boton07.setFocusPainted(false);
        boton07.setFocusable(false);
        boton07.setRequestFocusEnabled(false);
        boton07.setRolloverEnabled(false);

        boton10.setBackground(new java.awt.Color(255, 255, 255));
        boton10.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        boton10.setText("5");
        boton10.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 153, 255), 2, true));
        boton10.setContentAreaFilled(false);
        boton10.setFocusPainted(false);
        boton10.setFocusable(false);
        boton10.setRequestFocusEnabled(false);
        boton10.setRolloverEnabled(false);

        boton11.setBackground(new java.awt.Color(255, 255, 255));
        boton11.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        boton11.setText("6");
        boton11.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 153, 255), 2, true));
        boton11.setContentAreaFilled(false);
        boton11.setFocusPainted(false);
        boton11.setFocusable(false);
        boton11.setRequestFocusEnabled(false);
        boton11.setRolloverEnabled(false);

        boton12.setBackground(new java.awt.Color(255, 255, 255));
        boton12.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        boton12.setText("3");
        boton12.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 153, 255), 2, true));
        boton12.setContentAreaFilled(false);
        boton12.setFocusPainted(false);
        boton12.setFocusable(false);
        boton12.setRequestFocusEnabled(false);
        boton12.setRolloverEnabled(false);

        boton13.setBackground(new java.awt.Color(255, 255, 255));
        boton13.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        boton13.setText("7");
        boton13.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 153, 255), 2, true));
        boton13.setContentAreaFilled(false);
        boton13.setFocusPainted(false);
        boton13.setFocusable(false);
        boton13.setRequestFocusEnabled(false);
        boton13.setRolloverEnabled(false);

        boton14.setBackground(new java.awt.Color(255, 255, 255));
        boton14.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        boton14.setText("0");
        boton14.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 153, 255), 2, true));
        boton14.setContentAreaFilled(false);
        boton14.setFocusPainted(false);
        boton14.setFocusable(false);
        boton14.setRequestFocusEnabled(false);
        boton14.setRolloverEnabled(false);

        boton15.setBackground(new java.awt.Color(255, 255, 255));
        boton15.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        boton15.setText("0");
        boton15.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 153, 255), 2, true));
        boton15.setContentAreaFilled(false);
        boton15.setFocusPainted(false);
        boton15.setFocusable(false);
        boton15.setRequestFocusEnabled(false);
        boton15.setRolloverEnabled(false);

        boton16.setBackground(new java.awt.Color(255, 255, 255));
        boton16.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        boton16.setText("0");
        boton16.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 153, 255), 2, true));
        boton16.setContentAreaFilled(false);
        boton16.setFocusPainted(false);
        boton16.setFocusable(false);
        boton16.setRequestFocusEnabled(false);
        boton16.setRolloverEnabled(false);

        boton17.setBackground(new java.awt.Color(255, 255, 255));
        boton17.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        boton17.setText("0");
        boton17.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 153, 255), 2, true));
        boton17.setContentAreaFilled(false);
        boton17.setFocusPainted(false);
        boton17.setFocusable(false);
        boton17.setRequestFocusEnabled(false);
        boton17.setRolloverEnabled(false);

        boton20.setBackground(new java.awt.Color(255, 255, 255));
        boton20.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        boton20.setText("9");
        boton20.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 153, 255), 2, true));
        boton20.setContentAreaFilled(false);
        boton20.setFocusPainted(false);
        boton20.setFocusable(false);
        boton20.setRequestFocusEnabled(false);
        boton20.setRolloverEnabled(false);

        boton21.setBackground(new java.awt.Color(255, 255, 255));
        boton21.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        boton21.setText("0");
        boton21.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 153, 255), 2, true));
        boton21.setContentAreaFilled(false);
        boton21.setFocusPainted(false);
        boton21.setFocusable(false);
        boton21.setRequestFocusEnabled(false);
        boton21.setRolloverEnabled(false);

        boton22.setBackground(new java.awt.Color(255, 255, 255));
        boton22.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        boton22.setText("11");
        boton22.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 153, 255), 2, true));
        boton22.setContentAreaFilled(false);
        boton22.setFocusPainted(false);
        boton22.setFocusable(false);
        boton22.setRequestFocusEnabled(false);
        boton22.setRolloverEnabled(false);

        boton23.setBackground(new java.awt.Color(255, 255, 255));
        boton23.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        boton23.setText("8");
        boton23.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 153, 255), 2, true));
        boton23.setContentAreaFilled(false);
        boton23.setFocusPainted(false);
        boton23.setFocusable(false);
        boton23.setRequestFocusEnabled(false);
        boton23.setRolloverEnabled(false);

        boton24.setBackground(new java.awt.Color(255, 255, 255));
        boton24.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        boton24.setText("0");
        boton24.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 153, 255), 2, true));
        boton24.setContentAreaFilled(false);
        boton24.setFocusPainted(false);
        boton24.setFocusable(false);
        boton24.setRequestFocusEnabled(false);
        boton24.setRolloverEnabled(false);

        boton25.setBackground(new java.awt.Color(255, 255, 255));
        boton25.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        boton25.setText("0");
        boton25.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 153, 255), 2, true));
        boton25.setContentAreaFilled(false);
        boton25.setFocusPainted(false);
        boton25.setFocusable(false);
        boton25.setRequestFocusEnabled(false);
        boton25.setRolloverEnabled(false);

        boton26.setBackground(new java.awt.Color(255, 255, 255));
        boton26.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        boton26.setText("0");
        boton26.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 153, 255), 2, true));
        boton26.setContentAreaFilled(false);
        boton26.setFocusPainted(false);
        boton26.setFocusable(false);
        boton26.setRequestFocusEnabled(false);
        boton26.setRolloverEnabled(false);

        boton27.setBackground(new java.awt.Color(255, 255, 255));
        boton27.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        boton27.setText("0");
        boton27.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 153, 255), 2, true));
        boton27.setContentAreaFilled(false);
        boton27.setFocusPainted(false);
        boton27.setFocusable(false);
        boton27.setRequestFocusEnabled(false);
        boton27.setRolloverEnabled(false);

        boton30.setBackground(new java.awt.Color(255, 255, 255));
        boton30.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        boton30.setText("13");
        boton30.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 153, 255), 2, true));
        boton30.setContentAreaFilled(false);
        boton30.setFocusPainted(false);
        boton30.setFocusable(false);
        boton30.setRequestFocusEnabled(false);
        boton30.setRolloverEnabled(false);

        boton31.setBackground(new java.awt.Color(255, 255, 255));
        boton31.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        boton31.setText("10");
        boton31.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 153, 255), 2, true));
        boton31.setContentAreaFilled(false);
        boton31.setFocusPainted(false);
        boton31.setFocusable(false);
        boton31.setRequestFocusEnabled(false);
        boton31.setRolloverEnabled(false);

        boton32.setBackground(new java.awt.Color(255, 255, 255));
        boton32.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        boton32.setText("14");
        boton32.setToolTipText("");
        boton32.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 153, 255), 2, true));
        boton32.setContentAreaFilled(false);
        boton32.setFocusPainted(false);
        boton32.setFocusable(false);
        boton32.setRequestFocusEnabled(false);
        boton32.setRolloverEnabled(false);

        boton33.setBackground(new java.awt.Color(255, 255, 255));
        boton33.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        boton33.setText("10");
        boton33.setToolTipText("");
        boton33.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 153, 255), 2, true));
        boton33.setContentAreaFilled(false);
        boton33.setFocusPainted(false);
        boton33.setFocusable(false);
        boton33.setRequestFocusEnabled(false);
        boton33.setRolloverEnabled(false);

        boton34.setBackground(new java.awt.Color(255, 255, 255));
        boton34.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        boton34.setText("0");
        boton34.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 153, 255), 2, true));
        boton34.setContentAreaFilled(false);
        boton34.setFocusPainted(false);
        boton34.setFocusable(false);
        boton34.setRequestFocusEnabled(false);
        boton34.setRolloverEnabled(false);

        boton35.setBackground(new java.awt.Color(255, 255, 255));
        boton35.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        boton35.setText("0");
        boton35.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 153, 255), 2, true));
        boton35.setContentAreaFilled(false);
        boton35.setFocusPainted(false);
        boton35.setFocusable(false);
        boton35.setRequestFocusEnabled(false);
        boton35.setRolloverEnabled(false);

        boton36.setBackground(new java.awt.Color(255, 255, 255));
        boton36.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        boton36.setText("0");
        boton36.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 153, 255), 2, true));
        boton36.setContentAreaFilled(false);
        boton36.setFocusPainted(false);
        boton36.setFocusable(false);
        boton36.setRequestFocusEnabled(false);
        boton36.setRolloverEnabled(false);

        boton37.setBackground(new java.awt.Color(255, 255, 255));
        boton37.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        boton37.setText("0");
        boton37.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 153, 255), 2, true));
        boton37.setContentAreaFilled(false);
        boton37.setFocusPainted(false);
        boton37.setFocusable(false);
        boton37.setRequestFocusEnabled(false);
        boton37.setRolloverEnabled(false);

        boton40.setBackground(new java.awt.Color(255, 255, 255));
        boton40.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        boton40.setText("0");
        boton40.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 153, 255), 2, true));
        boton40.setContentAreaFilled(false);
        boton40.setFocusPainted(false);
        boton40.setFocusable(false);
        boton40.setRequestFocusEnabled(false);
        boton40.setRolloverEnabled(false);

        boton41.setBackground(new java.awt.Color(255, 255, 255));
        boton41.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        boton41.setText("0");
        boton41.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 153, 255), 2, true));
        boton41.setContentAreaFilled(false);
        boton41.setFocusPainted(false);
        boton41.setFocusable(false);
        boton41.setRequestFocusEnabled(false);
        boton41.setRolloverEnabled(false);

        boton42.setBackground(new java.awt.Color(255, 255, 255));
        boton42.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        boton42.setText("0");
        boton42.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 153, 255), 2, true));
        boton42.setContentAreaFilled(false);
        boton42.setFocusPainted(false);
        boton42.setFocusable(false);
        boton42.setRequestFocusEnabled(false);
        boton42.setRolloverEnabled(false);

        boton43.setBackground(new java.awt.Color(255, 255, 255));
        boton43.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        boton43.setText("0");
        boton43.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 153, 255), 2, true));
        boton43.setContentAreaFilled(false);
        boton43.setFocusPainted(false);
        boton43.setFocusable(false);
        boton43.setRequestFocusEnabled(false);
        boton43.setRolloverEnabled(false);

        boton44.setBackground(new java.awt.Color(255, 255, 255));
        boton44.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        boton44.setText("0");
        boton44.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 153, 255), 2, true));
        boton44.setContentAreaFilled(false);
        boton44.setFocusPainted(false);
        boton44.setFocusable(false);
        boton44.setRequestFocusEnabled(false);
        boton44.setRolloverEnabled(false);

        boton45.setBackground(new java.awt.Color(255, 255, 255));
        boton45.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        boton45.setText("0");
        boton45.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 153, 255), 2, true));
        boton45.setContentAreaFilled(false);
        boton45.setFocusPainted(false);
        boton45.setFocusable(false);
        boton45.setRequestFocusEnabled(false);
        boton45.setRolloverEnabled(false);

        boton46.setBackground(new java.awt.Color(255, 255, 255));
        boton46.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        boton46.setText("0");
        boton46.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 153, 255), 2, true));
        boton46.setContentAreaFilled(false);
        boton46.setFocusPainted(false);
        boton46.setFocusable(false);
        boton46.setRequestFocusEnabled(false);
        boton46.setRolloverEnabled(false);

        boton47.setBackground(new java.awt.Color(255, 255, 255));
        boton47.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        boton47.setText("0");
        boton47.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 153, 255), 2, true));
        boton47.setContentAreaFilled(false);
        boton47.setFocusPainted(false);
        boton47.setFocusable(false);
        boton47.setRequestFocusEnabled(false);
        boton47.setRolloverEnabled(false);

        boton50.setBackground(new java.awt.Color(255, 255, 255));
        boton50.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        boton50.setText("0");
        boton50.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 153, 255), 2, true));
        boton50.setContentAreaFilled(false);
        boton50.setFocusPainted(false);
        boton50.setFocusable(false);
        boton50.setRequestFocusEnabled(false);
        boton50.setRolloverEnabled(false);

        boton51.setBackground(new java.awt.Color(255, 255, 255));
        boton51.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        boton51.setText("0");
        boton51.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 153, 255), 2, true));
        boton51.setContentAreaFilled(false);
        boton51.setFocusPainted(false);
        boton51.setFocusable(false);
        boton51.setRequestFocusEnabled(false);
        boton51.setRolloverEnabled(false);

        boton52.setBackground(new java.awt.Color(255, 255, 255));
        boton52.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        boton52.setText("0");
        boton52.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 153, 255), 2, true));
        boton52.setContentAreaFilled(false);
        boton52.setFocusPainted(false);
        boton52.setFocusable(false);
        boton52.setRequestFocusEnabled(false);
        boton52.setRolloverEnabled(false);

        boton53.setBackground(new java.awt.Color(255, 255, 255));
        boton53.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        boton53.setText("0");
        boton53.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 153, 255), 2, true));
        boton53.setContentAreaFilled(false);
        boton53.setFocusPainted(false);
        boton53.setFocusable(false);
        boton53.setRequestFocusEnabled(false);
        boton53.setRolloverEnabled(false);

        boton54.setBackground(new java.awt.Color(255, 255, 255));
        boton54.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        boton54.setText("0");
        boton54.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 153, 255), 2, true));
        boton54.setContentAreaFilled(false);
        boton54.setFocusPainted(false);
        boton54.setFocusable(false);
        boton54.setRequestFocusEnabled(false);
        boton54.setRolloverEnabled(false);

        boton55.setBackground(new java.awt.Color(255, 255, 255));
        boton55.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        boton55.setText("0");
        boton55.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 153, 255), 2, true));
        boton55.setContentAreaFilled(false);
        boton55.setFocusPainted(false);
        boton55.setFocusable(false);
        boton55.setRequestFocusEnabled(false);
        boton55.setRolloverEnabled(false);

        boton56.setBackground(new java.awt.Color(255, 255, 255));
        boton56.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        boton56.setText("0");
        boton56.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 153, 255), 2, true));
        boton56.setContentAreaFilled(false);
        boton56.setFocusPainted(false);
        boton56.setFocusable(false);
        boton56.setRequestFocusEnabled(false);
        boton56.setRolloverEnabled(false);

        boton57.setBackground(new java.awt.Color(255, 255, 255));
        boton57.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        boton57.setText("0");
        boton57.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 153, 255), 2, true));
        boton57.setContentAreaFilled(false);
        boton57.setFocusPainted(false);
        boton57.setFocusable(false);
        boton57.setRequestFocusEnabled(false);
        boton57.setRolloverEnabled(false);

        boton60.setBackground(new java.awt.Color(255, 255, 255));
        boton60.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        boton60.setText("0");
        boton60.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 153, 255), 2, true));
        boton60.setContentAreaFilled(false);
        boton60.setFocusPainted(false);
        boton60.setFocusable(false);
        boton60.setRequestFocusEnabled(false);
        boton60.setRolloverEnabled(false);

        boton61.setBackground(new java.awt.Color(255, 255, 255));
        boton61.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        boton61.setText("0");
        boton61.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 153, 255), 2, true));
        boton61.setContentAreaFilled(false);
        boton61.setFocusPainted(false);
        boton61.setFocusable(false);
        boton61.setRequestFocusEnabled(false);
        boton61.setRolloverEnabled(false);

        boton62.setBackground(new java.awt.Color(255, 255, 255));
        boton62.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        boton62.setText("0");
        boton62.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 153, 255), 2, true));
        boton62.setContentAreaFilled(false);
        boton62.setFocusPainted(false);
        boton62.setFocusable(false);
        boton62.setRequestFocusEnabled(false);
        boton62.setRolloverEnabled(false);

        boton63.setBackground(new java.awt.Color(255, 255, 255));
        boton63.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        boton63.setText("0");
        boton63.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 153, 255), 2, true));
        boton63.setContentAreaFilled(false);
        boton63.setFocusPainted(false);
        boton63.setFocusable(false);
        boton63.setRequestFocusEnabled(false);
        boton63.setRolloverEnabled(false);

        boton64.setBackground(new java.awt.Color(255, 255, 255));
        boton64.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        boton64.setText("0");
        boton64.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 153, 255), 2, true));
        boton64.setContentAreaFilled(false);
        boton64.setFocusPainted(false);
        boton64.setFocusable(false);
        boton64.setRequestFocusEnabled(false);
        boton64.setRolloverEnabled(false);

        boton65.setBackground(new java.awt.Color(255, 255, 255));
        boton65.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        boton65.setText("0");
        boton65.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 153, 255), 2, true));
        boton65.setContentAreaFilled(false);
        boton65.setFocusPainted(false);
        boton65.setFocusable(false);
        boton65.setRequestFocusEnabled(false);
        boton65.setRolloverEnabled(false);

        boton66.setBackground(new java.awt.Color(255, 255, 255));
        boton66.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        boton66.setText("0");
        boton66.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 153, 255), 2, true));
        boton66.setContentAreaFilled(false);
        boton66.setFocusPainted(false);
        boton66.setFocusable(false);
        boton66.setRequestFocusEnabled(false);
        boton66.setRolloverEnabled(false);

        boton67.setBackground(new java.awt.Color(255, 255, 255));
        boton67.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        boton67.setText("0");
        boton67.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 153, 255), 2, true));
        boton67.setContentAreaFilled(false);
        boton67.setFocusPainted(false);
        boton67.setFocusable(false);
        boton67.setRequestFocusEnabled(false);
        boton67.setRolloverEnabled(false);

        boton70.setBackground(new java.awt.Color(255, 255, 255));
        boton70.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        boton70.setText("0");
        boton70.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 153, 255), 2, true));
        boton70.setContentAreaFilled(false);
        boton70.setFocusPainted(false);
        boton70.setFocusable(false);
        boton70.setRequestFocusEnabled(false);
        boton70.setRolloverEnabled(false);

        boton71.setBackground(new java.awt.Color(255, 255, 255));
        boton71.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        boton71.setText("0");
        boton71.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 153, 255), 2, true));
        boton71.setContentAreaFilled(false);
        boton71.setFocusPainted(false);
        boton71.setFocusable(false);
        boton71.setRequestFocusEnabled(false);
        boton71.setRolloverEnabled(false);

        boton72.setBackground(new java.awt.Color(255, 255, 255));
        boton72.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        boton72.setText("0");
        boton72.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 153, 255), 2, true));
        boton72.setContentAreaFilled(false);
        boton72.setFocusPainted(false);
        boton72.setFocusable(false);
        boton72.setRequestFocusEnabled(false);
        boton72.setRolloverEnabled(false);

        boton73.setBackground(new java.awt.Color(255, 255, 255));
        boton73.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        boton73.setText("0");
        boton73.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 153, 255), 2, true));
        boton73.setContentAreaFilled(false);
        boton73.setFocusPainted(false);
        boton73.setFocusable(false);
        boton73.setRequestFocusEnabled(false);
        boton73.setRolloverEnabled(false);

        boton74.setBackground(new java.awt.Color(255, 255, 255));
        boton74.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        boton74.setText("0");
        boton74.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 153, 255), 2, true));
        boton74.setContentAreaFilled(false);
        boton74.setFocusPainted(false);
        boton74.setFocusable(false);
        boton74.setRequestFocusEnabled(false);
        boton74.setRolloverEnabled(false);

        boton75.setBackground(new java.awt.Color(255, 255, 255));
        boton75.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        boton75.setText("0");
        boton75.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 153, 255), 2, true));
        boton75.setContentAreaFilled(false);
        boton75.setFocusPainted(false);
        boton75.setFocusable(false);
        boton75.setRequestFocusEnabled(false);
        boton75.setRolloverEnabled(false);

        boton76.setBackground(new java.awt.Color(255, 255, 255));
        boton76.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        boton76.setText("0");
        boton76.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 153, 255), 2, true));
        boton76.setContentAreaFilled(false);
        boton76.setFocusPainted(false);
        boton76.setFocusable(false);
        boton76.setRequestFocusEnabled(false);
        boton76.setRolloverEnabled(false);

        boton77.setBackground(new java.awt.Color(255, 255, 255));
        boton77.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        boton77.setText("0");
        boton77.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 153, 255), 2, true));
        boton77.setContentAreaFilled(false);
        boton77.setFocusPainted(false);
        boton77.setFocusable(false);
        boton77.setRequestFocusEnabled(false);
        boton77.setRolloverEnabled(false);


        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(boton40, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(boton41, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(boton42, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(boton43, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(boton44, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(boton45, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(boton46, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(boton30, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(boton31, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(boton32, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(boton33, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(boton34, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(boton35, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(boton36, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(boton20, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(boton21, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(boton22, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(boton23, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(boton24, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(boton25, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(boton26, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(boton10, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(boton11, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(boton12, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(boton13, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(boton14, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(boton15, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(boton16, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(boton00, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(boton01, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(boton02, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(boton03, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(boton04, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(boton05, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(boton06, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(boton50, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(boton51, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(boton52, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(boton53, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(boton54, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(boton55, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(boton56, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(boton60, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(boton61, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(boton62, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(boton63, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(boton64, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(boton65, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(boton66, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(boton47, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(boton37, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(boton17, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(boton57, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(boton67, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(boton07, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(boton27, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(boton70, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(boton71, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(boton72, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(boton73, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(boton74, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(boton75, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(boton76, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(boton77, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(boton01, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(boton02, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(boton03, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(boton00, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(boton04, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(boton05, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(boton06, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(boton11, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(boton12, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(boton13, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(boton10, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(boton14, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(boton15, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(boton16, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(boton21, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(boton22, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(boton23, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(boton20, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(boton24, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(boton25, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(boton26, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(boton31, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(boton32, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(boton33, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(boton30, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(boton34, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(boton35, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(boton36, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(boton41, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(boton42, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(boton43, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(boton40, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(boton44, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(boton45, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(boton46, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(boton51, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(boton52, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(boton53, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(boton50, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(boton54, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(boton55, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(boton56, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(boton61, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(boton62, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(boton63, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(boton60, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(boton64, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(boton65, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(boton66, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(boton71, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(boton72, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(boton73, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(boton70, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(boton74, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(boton75, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(boton76, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(boton77, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(boton07, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(boton17, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(boton27, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(174, 174, 174)
                            .addComponent(boton57, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(79, 79, 79))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(boton37, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(boton47, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(96, 96, 96)
                            .addComponent(boton67, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(0, 0, 0));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Solución:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel5.setBackground(new java.awt.Color(0, 0, 0));

        numNodosString.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        numNodosString.setForeground(new java.awt.Color(255, 255, 255));
        numNodosString.setText("Número de nodos:");

        numNodosInt.setBackground(new java.awt.Color(255, 255, 255));
        numNodosInt.setForeground(new java.awt.Color(255, 255, 255));
        numNodosInt.setText("33");

        numNodosString1.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        numNodosString1.setForeground(new java.awt.Color(255, 255, 255));
        numNodosString1.setText("Tiempo ejecución:");

        numNodosInt1.setForeground(new java.awt.Color(255, 255, 255));
        numNodosInt1.setText("23 ns");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(numNodosString)
                    .addComponent(numNodosString1))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(numNodosInt1)
                    .addComponent(numNodosInt))
                .addGap(0, 31, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numNodosString)
                    .addComponent(numNodosInt))
                .addGap(7, 7, 7)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numNodosString1, javax.swing.GroupLayout.DEFAULT_SIZE, 19, Short.MAX_VALUE)
                    .addComponent(numNodosInt1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        otro_puzzle.setBackground(new java.awt.Color(51, 153, 255));
        otro_puzzle.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        otro_puzzle.setForeground(new java.awt.Color(255, 255, 255));
        otro_puzzle.setText("ELEGIR OTRO PUZZLE");
        otro_puzzle.setBorderPainted(false);
        otro_puzzle.setDefaultCapable(false);
        otro_puzzle.setFocusPainted(false);
        otro_puzzle.setFocusable(false);
        otro_puzzle.setInheritsPopupMenu(true);
        otro_puzzle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                otro_puzzleMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jToggleButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jToggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(228, 228, 228)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(308, 308, 308)
                .addComponent(otro_puzzle)
                .addGap(243, 243, 243))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(78, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(otro_puzzle))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jToggleButton1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jToggleButton2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(12, 12, 12))
        );

        jScrollPane2.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void otro_puzzleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_otro_puzzleMouseClicked
        dispose();
        new Main_Frame();
    }//GEN-LAST:event_otro_puzzleMouseClicked

  private void jToggleButton1MouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jToggleButton1MouseClicked
	  
	if(indexSolucion < solucion.length) {
		
	    char[] s = solucion[indexSolucion].toCharArray();
	    indexSolucion++;
	    String numero = "";
	    for (int i = 0; i < s.length-1; i++) 
			numero += s[i];
		char direccion = s[s.length-1];
		
		accion(numero, direccion);
		
	}  
	
  }// GEN-LAST:event_jToggleButton1MouseClicked

  private void jToggleButton2MouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jToggleButton2MouseClicked
	  
	  
	  if(indexSolucion > 0) {
		  indexSolucion--;
		    char[] s = solucion[indexSolucion].toCharArray();
		    String numero = "";
		    for (int i = 0; i < s.length-1; i++) 
				numero += s[i];
			char direccion = s[s.length-1];
			
			switch (direccion) {
			case 'N':
				direccion = 'S';
				break;
			case 'S':
				direccion = 'N';
				break;
			case 'O':
				direccion = 'E';
				break;
			case 'E':
				direccion = 'O';
				break;

			default:
				break;
			}
			
			accion(numero, direccion);
		  
	  }
	  
	
  }// GEN-LAST:event_jToggleButton2MouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boton00;
    private javax.swing.JButton boton01;
    private javax.swing.JButton boton02;
    private javax.swing.JButton boton03;
    private javax.swing.JButton boton04;
    private javax.swing.JButton boton05;
    private javax.swing.JButton boton06;
    private javax.swing.JButton boton07;
    private javax.swing.JButton boton10;
    private javax.swing.JButton boton11;
    private javax.swing.JButton boton12;
    private javax.swing.JButton boton13;
    private javax.swing.JButton boton14;
    private javax.swing.JButton boton15;
    private javax.swing.JButton boton16;
    private javax.swing.JButton boton17;
    private javax.swing.JButton boton20;
    private javax.swing.JButton boton21;
    private javax.swing.JButton boton22;
    private javax.swing.JButton boton23;
    private javax.swing.JButton boton24;
    private javax.swing.JButton boton25;
    private javax.swing.JButton boton26;
    private javax.swing.JButton boton27;
    private javax.swing.JButton boton30;
    private javax.swing.JButton boton31;
    private javax.swing.JButton boton32;
    private javax.swing.JButton boton33;
    private javax.swing.JButton boton34;
    private javax.swing.JButton boton35;
    private javax.swing.JButton boton36;
    private javax.swing.JButton boton37;
    private javax.swing.JButton boton40;
    private javax.swing.JButton boton41;
    private javax.swing.JButton boton42;
    private javax.swing.JButton boton43;
    private javax.swing.JButton boton44;
    private javax.swing.JButton boton45;
    private javax.swing.JButton boton46;
    private javax.swing.JButton boton47;
    private javax.swing.JButton boton50;
    private javax.swing.JButton boton51;
    private javax.swing.JButton boton52;
    private javax.swing.JButton boton53;
    private javax.swing.JButton boton54;
    private javax.swing.JButton boton55;
    private javax.swing.JButton boton56;
    private javax.swing.JButton boton57;
    private javax.swing.JButton boton60;
    private javax.swing.JButton boton61;
    private javax.swing.JButton boton62;
    private javax.swing.JButton boton63;
    private javax.swing.JButton boton64;
    private javax.swing.JButton boton65;
    private javax.swing.JButton boton66;
    private javax.swing.JButton boton67;
    private javax.swing.JButton boton70;
    private javax.swing.JButton boton71;
    private javax.swing.JButton boton72;
    private javax.swing.JButton boton73;
    private javax.swing.JButton boton74;
    private javax.swing.JButton boton75;
    private javax.swing.JButton boton76;
    private javax.swing.JButton boton77;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JToggleButton jToggleButton2;
    private javax.swing.JLabel labelSolucion;
    private javax.swing.JLabel numNodosInt;
    private javax.swing.JLabel numNodosInt1;
    private javax.swing.JLabel numNodosString;
    private javax.swing.JLabel numNodosString1;
    private javax.swing.JButton otro_puzzle;
    // End of variables declaration//GEN-END:variables
}
