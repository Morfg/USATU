package Version_1;

import javax.swing.*;

import Version_1.MyFrame.eHandler;

import java.awt.*;
import java.awt.event.*;

public class MyFrame extends JFrame {
	
	JButton b1, b2,JButtonDecideAllCameras,JCreateObject, JButtonSaveParam ; //��������� ���������� ���� JButton
	JLabel JLabelVideoBitrate,JLabelVideoLength, JLabelAudioFrequency, JLabelWithAudio,JLabelBitCapacity,JLabelResult, JLabelFullResult,JLabelResultCameras,JLabelResultCamerasNumber, l3, l4; //��������� ���������� ���� JLabel
	JTextField JTextFieldVideoBitrate,JTextFieldVideoLength,JTextFieldAudioFrequency,JTextFieldAudioBitCapacity,JTextFieldResult, t2; //��������� ���������� ���� JTextField
	JComboBox JComboBoxNumberObject; //��������� ���������� ���� JComboBox
	String StringForJComboBox,SelectedObject,a, b; //��������� ���������� ���� String
	JCheckBox JCheckBoxAudioFile; //��������� ���������� ���� JCheckBox
	int ObjectNumberName = 0,j; //��������� ���������� ���� int � ������ �������� ��� ���������� ObjectNumberName = 0 ,������� �������� ������� �����
	VideoObject[] VideoCamera = new VideoObject[1024]; //������� ��������� ������ VideoObject[1024] � ���������� ������ �� ����� ��������� ������
	//boolean BolleanCheckEdit=true;//������� ���������� ���� boolean � ������ �� �������� true, �� ���� ��� ����, �� ����� ��� ���������� false
	float i, k, CheckEdit=0,VideoBitrate,VideoLength,AudioFrequency,BitCapacity,FullResult,AudioResult,VideoResult,AllCameraResult=0;//������� ���������� ���� float
	eHandler handler = new eHandler(); //������� ��������� ������ eHandler � ���������� ������ �� ����� ��������� ������
	public MyFrame(String s) {//��������� ����� MyFrame
		
		super(s);// ������� ����������
		setLayout(null);//������������� �������� null ��� "��������� ����������"
		//b1 = new JButton("Clear VSEEEEE");
		//b1.setBounds(10,10,200,200);
		//b2 = new JButton("���������");
		JLabelVideoBitrate = new JLabel("������� ������� �����(����/���)");// ����������� ������ ��� ������� JLabelVideoBitrate
		JLabelVideoBitrate.setBounds(10,10,250,25); // ����� setBounds, ������� �������� �� ������ ����������.������ ���������� 4 ��������: ������ �����, ������ ������, ����� ����������, ������ ����������.
		JLabelVideoBitrate.setForeground(Color.ORANGE);
		JTextFieldVideoBitrate = new JTextField(10);// ����������� ������ ��� ������� JTextFieldVideoBitrate
		JTextFieldVideoBitrate.setBounds(10,40,250,25);// ����� setBounds, ������� �������� �� ������ ����������.������ ���������� 4 ��������: ������ �����, ������ ������, ����� ����������, ������ ����������.
		//JTextFieldVideoBitrate.setBackground(Color.WHITE);
		//JTextFieldVideoBitrate.setEditable(false);
		JLabelVideoLength = new JLabel("������� ������������ �����(���)");
		JLabelVideoLength.setBounds(10,70,250,25);// ����� setBounds, ������� �������� �� ������ ����������.������ ���������� 4 ��������: ������ �����, ������ ������, ����� ����������, ������ ����������.
		JLabelVideoLength.setForeground(Color.ORANGE);
		JTextFieldVideoLength = new JTextField(10);// ����������� ������ ��� ������� JTextFieldVideoLength
		JTextFieldVideoLength.setBounds(10,100,250,25);// ����� setBounds, ������� �������� �� ������ ����������.������ ���������� 4 ��������: ������ �����, ������ ������, ����� ����������, ������ ����������.
		//JTextFieldVideoBitrate.setEditable(false);
		JLabelWithAudio = new JLabel("����� �� ������");// ����������� ������ ��� ������� JLabelWithAudio
		JLabelWithAudio.setBounds(10,150,250,25);// ����� setBounds, ������� �������� �� ������ ����������.������ ���������� 4 ��������: ������ �����, ������ ������, ����� ����������, ������ ����������.
		JLabelWithAudio.setForeground(Color.ORANGE);
		
		JCheckBoxAudioFile = new JCheckBox();// ����������� ������ ��� ������� JCheckBoxAudioFile
		JCheckBoxAudioFile.setSelected(false);
		JCheckBoxAudioFile.setBounds(10,170,25,25);// ����� setBounds, ������� �������� �� ������ ����������.������ ���������� 4 ��������: ������ �����, ������ ������, ����� ����������, ������ ����������.
		JCheckBoxAudioFile.setBackground(Color.black);
		
		JLabelAudioFrequency = new JLabel("������� ������� �������������(��)");// ����������� ������ ��� ������� JLabelAudioFrequency
		JLabelAudioFrequency.setBounds(10, 200, 250, 25);// ����� setBounds, ������� �������� �� ������ ����������.������ ���������� 4 ��������: ������ �����, ������ ������, ����� ����������, ������ ����������.
		JLabelAudioFrequency.setForeground(Color.ORANGE);
		JTextFieldAudioFrequency = new JTextField(10);// ����������� ������ ��� ������� JTextFieldAudioFrequency
		JTextFieldAudioFrequency.setBounds(10, 230, 250, 25);// ����� setBounds, ������� �������� �� ������ ����������.������ ���������� 4 ��������: ������ �����, ������ ������, ����� ����������, ������ ����������.
		JTextFieldAudioFrequency.setEditable(false);
		JLabelBitCapacity = new JLabel("������� ����������� ��������");// ����������� ������ ��� ������� JLabelBitCapacity
		JLabelBitCapacity.setBounds(10, 260, 250, 25);// ����� setBounds, ������� �������� �� ������ ����������.������ ���������� 4 ��������: ������ �����, ������ ������, ����� ����������, ������ ����������.
		JLabelBitCapacity.setForeground(Color.ORANGE);
		JTextFieldAudioBitCapacity = new JTextField(10);// ����������� ������ ��� ������� JTextFieldAudioBitCapacity
		JTextFieldAudioBitCapacity.setBounds(10, 290, 250, 25);// ����� setBounds, ������� �������� �� ������ ����������.������ ���������� 4 ��������: ������ �����, ������ ������, ����� ����������, ������ ����������.
		JTextFieldAudioBitCapacity.setEditable(false);
		JButtonDecideAllCameras = new JButton("��������� ��� ���� �����");// ����������� ������ ��� ������� JButtonDecideAllCameras
		JButtonDecideAllCameras.setBounds(10, 420, 200, 25);// ����� setBounds, ������� �������� �� ������ ����������.������ ���������� 4 ��������: ������ �����, ������ ������, ����� ����������, ������ ����������.
		JButtonDecideAllCameras.setBackground(Color.ORANGE);
		JLabelResult = new JLabel("��������� ������:");// ����������� ������ ��� ������� JLabelResult
		JLabelResult.setBounds(10,360,250,25);// ����� setBounds, ������� �������� �� ������ ����������.������ ���������� 4 ��������: ������ �����, ������ ������, ����� ����������, ������ ����������.
		JLabelResult.setForeground(Color.ORANGE);
		JLabelFullResult = new JLabel("_____________");// ����������� ������ ��� ������� JLabelFullResult
		JLabelFullResult.setBounds(140, 360, 250, 25);// ����� setBounds, ������� �������� �� ������ ����������.������ ���������� 4 ��������: ������ �����, ������ ������, ����� ����������, ������ ����������.
		JLabelFullResult.setForeground(Color.WHITE);
		//JTextFieldResult = new JTextField();
		//JTextFieldResult.setBounds(10, 380, 250, 25);
		//JTextFieldResult.setEnabled(false);
		//JTextFieldResult.setEnabled(false);
		//JTextFieldAudioFrequency.setEditable(false);
		JLabelResultCameras = new JLabel("��� ��������� ������:");// ����������� ������ ��� ������� JLabelResultCameras
		JLabelResultCameras.setBounds(10,390,250,25);// ����� setBounds, ������� �������� �� ������ ����������.������ ���������� 4 ��������: ������ �����, ������ ������, ����� ����������, ������ ����������.
		JLabelResultCameras.setForeground(Color.ORANGE);
		JLabelResultCamerasNumber = new JLabel("_____________");// ����������� ������ ��� ������� JLabelResultCamerasNumber
		JLabelResultCamerasNumber.setBounds(165,390,250,25);// ����� setBounds, ������� �������� �� ������ ����������.������ ���������� 4 ��������: ������ �����, ������ ������, ����� ����������, ������ ����������.
		JLabelResultCamerasNumber.setForeground(Color.WHITE);
		JCreateObject = new JButton("�������� ������");// ����������� ������ ��� ������� JCreateObject
		JCreateObject.setBounds(290, 50, 150, 25);// ����� setBounds, ������� �������� �� ������ ����������.������ ���������� 4 ��������: ������ �����, ������ ������, ����� ����������, ������ ����������.
		JCreateObject.setBackground(Color.ORANGE);
		JComboBoxNumberObject = new JComboBox();// ����������� ������ ��� ������� JComboBoxNumberObject 
		JComboBoxNumberObject.setBounds(290, 100, 150, 25);// ����� setBounds, ������� �������� �� ������ ����������.������ ���������� 4 ��������: ������ �����, ������ ������, ����� ����������, ������ ����������.
		JButtonSaveParam = new JButton("��������� � ��������� ��������� ��� ���� ������");// ����������� ������ ��� ������� JButtonSaveParam
		JButtonSaveParam.setBounds(10, 330, 340, 25);// ����� setBounds, ������� �������� �� ������ ����������.������ ���������� 4 ��������: ������ �����, ������ ������, ����� ����������, ������ ����������.
		JButtonSaveParam.setBackground(Color.ORANGE);
		l3 = new JLabel("");// ����������� ������ ��� ������� l3
		l4 = new JLabel("");// ����������� ������ ��� ������� l4
		t2 = new JTextField(10);// ����������� ������ ��� ������� t2
		//add(b1);
	//	add(b2);
		add(JLabelVideoBitrate); // ��������� ������� 
		add(JTextFieldVideoBitrate); // ��������� ������� 
		add(JLabelVideoLength); // ��������� ������� 
		add(JTextFieldVideoLength); // ��������� ������� 
		add(JCheckBoxAudioFile); // ��������� ������� 
		add(JLabelAudioFrequency); // ��������� ������� 
		add(JLabelWithAudio); // ��������� ������� 
		add(JTextFieldAudioFrequency); // ��������� ������� 
		add(JLabelBitCapacity); // ��������� ������� 
		add(JTextFieldAudioBitCapacity); // ��������� ������� 
		add(JButtonDecideAllCameras); // ��������� ������� 
		add(JLabelResult); // ��������� ������� 
		add(JLabelFullResult); // ��������� ������� 
		add(JCreateObject); // ��������� ������� 
		add(JComboBoxNumberObject); // ��������� ������� 
		add(JButtonSaveParam); // ��������� ������� 
		add(JLabelResultCameras); // ��������� ������� 
		add(JLabelResultCamerasNumber); // ��������� ������� 
		//add(JTextFieldResult);
		//add(l4);
		JCheckBoxAudioFile.addActionListener(handler); // �������� ����� addActionListener ��� ���������� ��������� handler � ��������� ������� JCheckBoxAudioFile
		JButtonDecideAllCameras.addActionListener(handler); // �������� ����� addActionListener ��� ���������� ��������� handler � ��������� ������� JButtonDecideAllCameras
		JCreateObject.addActionListener(handler); // �������� ����� addActionListener ��� ���������� ��������� handler � ��������� ������� JCreateObject
		JComboBoxNumberObject.addActionListener(handler); // �������� ����� addActionListener ��� ���������� ��������� handler � ��������� ������� JComboBoxNumberObject
		JButtonSaveParam.addActionListener(handler); // �������� ����� addActionListener ��� ���������� ��������� handler � ��������� ������� JButtonSaveParam
	    setDefaultCloseOperation(EXIT_ON_CLOSE); //��� ����� ��� ���� ����� ��� �������� ���� ����������� � ���������, ����� ��� ��������� ������ � ���������
	    
	    																							//������� ������ ������
		ObjectNumberName++; // ������ � �������� = 1, �� � ������ �� ���� �� 0
		StringForJComboBox=String.valueOf(ObjectNumberName); // � StringForJComboBox ���������� �������� 1, "������" ������
		//JOptionPane.showMessageDialog(null, "dasd");
		//VideoObject[] VideoCamera = new VideoObject[32];
		VideoCamera[ObjectNumberName] = new VideoObject();
		//VideoCameraGlobal[ObjectNumberName] = new VideoObject();
		JComboBoxNumberObject.addItem(StringForJComboBox);
		//JOptionPane.showMessageDialog(null, "dasd");
		//System.out.println(VideoCamera[ObjectNumberName].ObjectVideoLength);
		//JOptionPane.showMessageDialog(null, "dasd");
		JTextFieldVideoBitrate.setText(String.valueOf(VideoCamera[ObjectNumberName].ObjectVideoBitrate));
		//JOptionPane.showMessageDialog(null, "dasd");
		JTextFieldVideoLength.setText(String.valueOf(VideoCamera[ObjectNumberName].ObjectVideoLength));
		JTextFieldAudioFrequency.setText(String.valueOf(VideoCamera[ObjectNumberName].ObjectAudioFrequency));
		JTextFieldAudioBitCapacity.setText(String.valueOf(VideoCamera[ObjectNumberName].ObjectAudioBitCapacity));
		
		
		/*i = Integer.parseInt(t1.getText());
		k = Integer.parseInt(t2.getText());
		a = " ���� ������ ����� ������ ����� "+ i;
		b = " ���� ������ ����� ������ ����� "+ k;
		l3.setText(a);
		l4.setText(b);*/
	    
		JTextFieldVideoBitrate.addKeyListener(new KeyAdapter() {
		    public void keyTyped(KeyEvent e) { 
		        if (JTextFieldVideoBitrate.getText().length() >= 9 ) // limit textfield to 3 characters
		            e.consume(); 
		    }  
		});
		JTextFieldVideoLength.addKeyListener(new KeyAdapter() {
		    public void keyTyped(KeyEvent e) { 
		        if (JTextFieldVideoLength.getText().length() >= 9 ) // limit textfield to 3 characters
		            e.consume(); 
		    }  
		});
		JTextFieldAudioFrequency.addKeyListener(new KeyAdapter() {
		    public void keyTyped(KeyEvent e) { 
		        if (JTextFieldAudioFrequency.getText().length() >= 9 ) // limit textfield to 3 characters
		            e.consume(); 
		    }  
		});
		JTextFieldAudioBitCapacity.addKeyListener(new KeyAdapter() {
		    public void keyTyped(KeyEvent e) { 
		        if (JTextFieldAudioBitCapacity.getText().length() >= 9 ) // limit textfield to 3 characters
		            e.consume(); 
		    }  
		});
		
		
	}
	public class eHandler implements ActionListener{


		public void actionPerformed(ActionEvent e) {
			
			
			try {
			if(e.getSource()==JCreateObject) {
				ObjectNumberName++;
				StringForJComboBox=String.valueOf(ObjectNumberName);
				//JOptionPane.showMessageDialog(null, "dasd");
				//VideoObject[] VideoCamera = new VideoObject[32];
				VideoCamera[ObjectNumberName] = new VideoObject();
				//VideoCameraGlobal[ObjectNumberName] = new VideoObject();
				JComboBoxNumberObject.addItem(StringForJComboBox);
				//JOptionPane.showMessageDialog(null, "dasd");
				//System.out.println(VideoCamera[ObjectNumberName].ObjectVideoLength);
				//JOptionPane.showMessageDialog(null, "dasd");
				JTextFieldVideoBitrate.setText(String.valueOf(VideoCamera[ObjectNumberName].ObjectVideoBitrate));
				//JOptionPane.showMessageDialog(null, "dasd");
				JTextFieldVideoLength.setText(String.valueOf(VideoCamera[ObjectNumberName].ObjectVideoLength));
				JTextFieldAudioFrequency.setText(String.valueOf(VideoCamera[ObjectNumberName].ObjectAudioFrequency));
				JTextFieldAudioBitCapacity.setText(String.valueOf(VideoCamera[ObjectNumberName].ObjectAudioBitCapacity));
				JComboBoxNumberObject.setSelectedIndex(ObjectNumberName-1);
				
				/*i = Integer.parseInt(t1.getText());
				k = Integer.parseInt(t2.getText());
				a = " ���� ������ ����� ������ ����� "+ i;
				b = " ���� ������ ����� ������ ����� "+ k;
				l3.setText(a);
				l4.setText(b);*/
			}
			}
			catch (Exception ep) {JOptionPane.showMessageDialog(null, "������ �� ���������");}
			
			try {
				if(e.getSource()==JComboBoxNumberObject) {
					
					SelectedObject=(String) JComboBoxNumberObject.getSelectedItem();
					JTextFieldVideoBitrate.setText(String.valueOf(VideoCamera[Integer.valueOf(SelectedObject)].ObjectVideoBitrate));
					JTextFieldVideoLength.setText(String.valueOf(VideoCamera[Integer.valueOf(SelectedObject)].ObjectVideoLength));
					JTextFieldAudioFrequency.setText(String.valueOf(VideoCamera[Integer.valueOf(SelectedObject)].ObjectAudioFrequency));
					JTextFieldAudioBitCapacity.setText(String.valueOf(VideoCamera[Integer.valueOf(SelectedObject)].ObjectAudioBitCapacity));
					JCheckBoxAudioFile.setSelected(VideoCamera[Integer.valueOf(SelectedObject)].Audio);
			//		BolleanCheckEdit=VideoCamera[Integer.valueOf(SelectedObject)].Audio;
					if (VideoCamera[Integer.valueOf(SelectedObject)].ObjectCameraTotal!=0) {
						JLabelFullResult.setText(String.valueOf(VideoCamera[Integer.valueOf(SelectedObject)].ObjectCameraTotal)+" ��");
					}else {
						JLabelFullResult.setText(String.valueOf("_____________"));
					}
					
					if (!(JCheckBoxAudioFile.isSelected())){
						JTextFieldAudioFrequency.setEditable(false);
						JTextFieldAudioBitCapacity.setEditable(false);
						
					}
					else {
						JTextFieldAudioFrequency.setEditable(true);
						JTextFieldAudioBitCapacity.setEditable(true);
					}
					
				/*	if ((VideoCamera[Integer.valueOf(SelectedObject)].audio)){
						JTextFieldAudioFrequency.setEditable(true);
						JTextFieldAudioBitCapacity.setEditable(true);
						
					}
					else {
						JTextFieldAudioFrequency.setEditable(false);
						JTextFieldAudioBitCapacity.setEditable(false);
					}*/
					//JTextFieldVideoBitrate.setText(Float.toString(VideoCamera[ObjectNumberName].ObjectVideoLength));
					//JOptionPane.showMessageDialog(null, SelectedObject);
				}
			}catch (Exception ep) {JOptionPane.showMessageDialog(null, "������ �� ���������");}
			
			try {
				if(e.getSource()==JButtonSaveParam) {
					
					SelectedObject=(String) JComboBoxNumberObject.getSelectedItem();
					//JOptionPane.showMessageDialog(null, SelectedObject);
					if((JTextFieldAudioFrequency.getText().equals("") )||(JTextFieldAudioFrequency.getText().equals(" "))||(JTextFieldAudioFrequency.getText().equals("  "))) {
						//System.out.println("� ��������");
						JTextFieldAudioFrequency.setText("0");
					}
					if((JTextFieldAudioBitCapacity.getText().equals("") )||(JTextFieldAudioBitCapacity.getText().equals(" "))||(JTextFieldAudioBitCapacity.getText().equals("  "))) {
						//System.out.println("� ��������");
						JTextFieldAudioBitCapacity.setText("0");
					}
					//JOptionPane.showMessageDialog(null, SelectedObject);
					if((JTextFieldVideoBitrate.getText().equals("") )||(JTextFieldVideoBitrate.getText().equals(" "))||(JTextFieldVideoBitrate.getText().equals("  "))) {
						//System.out.println("� ��������");
						JTextFieldVideoBitrate.setText("0");
					}
					if((JTextFieldVideoLength.getText().equals("") )||(JTextFieldVideoLength.getText().equals(" "))||(JTextFieldVideoLength.getText().equals("  "))) {
						//System.out.println("� ��������");
						JTextFieldVideoLength.setText("0");
					}
					VideoCamera[Integer.valueOf(SelectedObject)].ObjectVideoBitrate=Integer.parseInt(JTextFieldVideoBitrate.getText());
					VideoCamera[Integer.valueOf(SelectedObject)].ObjectVideoLength=Integer.parseInt(JTextFieldVideoLength.getText());
					VideoCamera[Integer.valueOf(SelectedObject)].ObjectAudioFrequency=Integer.parseInt(JTextFieldAudioFrequency.getText());
					VideoCamera[Integer.valueOf(SelectedObject)].ObjectAudioBitCapacity=Integer.parseInt(JTextFieldAudioBitCapacity.getText());
					VideoCamera[Integer.valueOf(SelectedObject)].Audio=JCheckBoxAudioFile.isSelected();
					
					
					
				
						if((JCheckBoxAudioFile.isSelected())) {
							//System.out.println("� ��������");

							VideoBitrate=Integer.parseInt(JTextFieldVideoBitrate.getText());
							VideoLength=Integer.parseInt(JTextFieldVideoLength.getText());
							AudioFrequency=Integer.parseInt(JTextFieldAudioFrequency.getText());
							BitCapacity=Integer.parseInt(JTextFieldAudioBitCapacity.getText());
							AudioResult=AudioFrequency*VideoLength*BitCapacity/1024;
							VideoResult=VideoBitrate*VideoLength*60/8192;
							FullResult=AudioResult+VideoResult;
							//VideoCamera[Integer.valueOf(SelectedObject)].ObjectCameraTotal=FullResult;
							JLabelFullResult.setText(String.valueOf(FullResult+" ��"));
							}
						if(!(JCheckBoxAudioFile.isSelected())) {
							//System.out.println("�� � ��������");
							VideoBitrate=Integer.parseInt(JTextFieldVideoBitrate.getText());
							VideoLength=Integer.parseInt(JTextFieldVideoLength.getText());
							VideoResult=VideoBitrate*VideoLength*60/8192;
							FullResult=VideoResult;
							JLabelFullResult.setText(String.valueOf(FullResult+" ��"));
							VideoCamera[Integer.valueOf(SelectedObject)].ObjectCameraTotal=FullResult;
							}
						VideoCamera[Integer.valueOf(SelectedObject)].ObjectCameraTotal=FullResult;
					
					//JTextFieldVideoBitrate.setText(String.valueOf(VideoCamera[Integer.valueOf(SelectedObject)].ObjectVideoBitrate));
					//JTextFieldVideoLength.setText(String.valueOf(VideoCamera[ObjectNumberName].ObjectVideoLength));
					//JTextFieldAudioFrequency.setText(String.valueOf(VideoCamera[ObjectNumberName].ObjectAudioFrequency));
					//JTextFieldAudioBitCapacity.setText(String.valueOf(VideoCamera[ObjectNumberName].ObjectAudioBitCapacity));
					//JTextFieldVideoBitrate.setText(Float.toString(VideoCamera[ObjectNumberName].ObjectVideoLength));
					//JOptionPane.showMessageDialog(null, SelectedObject);
				}
			}catch (Exception ep) {JOptionPane.showMessageDialog(null, "��������� ������ �������");}
			
			
			
			
			if(e.getSource()==JCheckBoxAudioFile) {
				//BolleanCheckEdit=!(BolleanCheckEdit);
				if (!(JCheckBoxAudioFile.isSelected())){
					JTextFieldAudioFrequency.setEditable(false);
					JTextFieldAudioBitCapacity.setEditable(false);
					
				}
				else {
					JTextFieldAudioFrequency.setEditable(true);
					JTextFieldAudioBitCapacity.setEditable(true);
				}
				
				/*i = Integer.parseInt(t1.getText());
				k = Integer.parseInt(t2.getText());
				a = " ���� ������ ����� ������ ����� "+ i;
				b = " ���� ������ ����� ������ ����� "+ k;
				l3.setText(a);
				l4.setText(b);*/
			}
			if (e.getSource()==JButtonDecideAllCameras) {
				for (j=0;j<ObjectNumberName;j++) {
					AllCameraResult=AllCameraResult+VideoCamera[Integer.valueOf(j+1)].ObjectCameraTotal;
					
				}
			JLabelResultCamerasNumber.setText(String.valueOf(AllCameraResult+" ��"));
			}
			AllCameraResult=0;
			/*if(e.getSource()==b1) {
				t2.setText(null);
				//t1.setText(null);
				l3.setText("");
				l4.setText("");
			}*/
		/*	try {
				if((e.getSource()==JButtonDecide)&&(JCheckBoxAudioFile.isSelected())) {
					VideoBitrate=Integer.parseInt(JTextFieldVideoBitrate.getText());
					VideoLength=Integer.parseInt(JTextFieldVideoLength.getText());
					AudioFrequency=Integer.parseInt(JTextFieldAudioFrequency.getText());
					BitCapacity=Integer.parseInt(JTextFieldAudioBitCapacity.getText());
					AudioResult=AudioFrequency*VideoLength*BitCapacity/1024;
					VideoResult=VideoBitrate*VideoLength*60/8192;
					FullResult=AudioResult+VideoResult;
					VideoCamera[Integer.valueOf(SelectedObject)].ObjectCameraTotal=FullResult;
					JLabelFullResult.setText(String.valueOf(FullResult+" ��"));
					}
				if((e.getSource()==JButtonDecide)&&(!(JCheckBoxAudioFile.isSelected()))) {
					VideoBitrate=Integer.parseInt(JTextFieldVideoBitrate.getText());
					VideoLength=Integer.parseInt(JTextFieldVideoLength.getText());
					VideoResult=VideoBitrate*VideoLength*60/8192;
					FullResult=VideoResult;
					JLabelFullResult.setText(String.valueOf(FullResult+" ��"));
					VideoCamera[Integer.valueOf(SelectedObject)].ObjectCameraTotal=FullResult;
					}
			}catch (Exception ex) {JOptionPane.showMessageDialog(null, "������� � ���� �����");
			
*/
			
			/*try {
				if((e.getSource()==JButtonDecide)&&(CheckEdit%2==0)) {
					VideoBitrate=Integer.parseInt(JTextFieldVideoBitrate.getText());
					VideoLength=Integer.parseInt(JTextFieldVideoLength.getText());
					VideoResult=VideoBitrate*VideoLength*60/8192;
					FullResult=VideoResult;
					JTextFieldResult.setText(String.valueOf(FullResult));
					}
			}catch (Exception ex1) {JOptionPane.showMessageDialog(null, "������� � ���� �����");
			} */
	}}
	}
