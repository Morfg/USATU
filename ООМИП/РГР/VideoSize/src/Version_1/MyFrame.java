package Version_1;

import javax.swing.*;

import Version_1.MyFrame.eHandler;

import java.awt.*;
import java.awt.event.*;

public class MyFrame extends JFrame {
	
	JButton b1, b2,JButtonDecideAllCameras,JCreateObject, JButtonSaveParam ; //Объявляем переменные типа JButton
	JLabel JLabelVideoBitrate,JLabelVideoLength, JLabelAudioFrequency, JLabelWithAudio,JLabelBitCapacity,JLabelResult, JLabelFullResult,JLabelResultCameras,JLabelResultCamerasNumber, l3, l4; //Объявляем переменные типа JLabel
	JTextField JTextFieldVideoBitrate,JTextFieldVideoLength,JTextFieldAudioFrequency,JTextFieldAudioBitCapacity,JTextFieldResult, t2; //Объявляем переменные типа JTextField
	JComboBox JComboBoxNumberObject; //Объявляем переменные типа JComboBox
	String StringForJComboBox,SelectedObject,a, b; //Объявляем переменные типа String
	JCheckBox JCheckBoxAudioFile; //Объявляем переменные типа JCheckBox
	int ObjectNumberName = 0,j; //Объявляем переменные типа int и задаем значение для переменной ObjectNumberName = 0 ,которое является началом счёта
	VideoObject[] VideoCamera = new VideoObject[1024]; //Создаем экземпляр класса VideoObject[1024] и возвращает ссылку на вновь созданный объект
	//boolean BolleanCheckEdit=true;//Создаем переменную типа boolean и задаем ей значение true, не знаю для чего, тк потом она становится false
	float i, k, CheckEdit=0,VideoBitrate,VideoLength,AudioFrequency,BitCapacity,FullResult,AudioResult,VideoResult,AllCameraResult=0;//Создаем переменные типа float
	eHandler handler = new eHandler(); //Создаем экземпляр класса eHandler и возвращает ссылку на вновь созданный объект
	public MyFrame(String s) {//Объявляем метод MyFrame
		
		super(s);// Создаем суперкласс
		setLayout(null);//Устанавливаем значение null для "менеджера размещения"
		//b1 = new JButton("Clear VSEEEEE");
		//b1.setBounds(10,10,200,200);
		//b2 = new JButton("Посчитать");
		JLabelVideoBitrate = new JLabel("Введите битрейт видео(кбит/сек)");// резервируем память для объекта JLabelVideoBitrate
		JLabelVideoBitrate.setBounds(10,10,250,25); // метод setBounds, который отвечает за точное размещение.Методу передаются 4 значения: отступ слева, отступ сверху, длина компонента, высота компонента.
		JLabelVideoBitrate.setForeground(Color.ORANGE);
		JTextFieldVideoBitrate = new JTextField(10);// резервируем память для объекта JTextFieldVideoBitrate
		JTextFieldVideoBitrate.setBounds(10,40,250,25);// метод setBounds, который отвечает за точное размещение.Методу передаются 4 значения: отступ слева, отступ сверху, длина компонента, высота компонента.
		//JTextFieldVideoBitrate.setBackground(Color.WHITE);
		//JTextFieldVideoBitrate.setEditable(false);
		JLabelVideoLength = new JLabel("Введите длительность видео(сек)");
		JLabelVideoLength.setBounds(10,70,250,25);// метод setBounds, который отвечает за точное размещение.Методу передаются 4 значения: отступ слева, отступ сверху, длина компонента, высота компонента.
		JLabelVideoLength.setForeground(Color.ORANGE);
		JTextFieldVideoLength = new JTextField(10);// резервируем память для объекта JTextFieldVideoLength
		JTextFieldVideoLength.setBounds(10,100,250,25);// метод setBounds, который отвечает за точное размещение.Методу передаются 4 значения: отступ слева, отступ сверху, длина компонента, высота компонента.
		//JTextFieldVideoBitrate.setEditable(false);
		JLabelWithAudio = new JLabel("Видео со звуком");// резервируем память для объекта JLabelWithAudio
		JLabelWithAudio.setBounds(10,150,250,25);// метод setBounds, который отвечает за точное размещение.Методу передаются 4 значения: отступ слева, отступ сверху, длина компонента, высота компонента.
		JLabelWithAudio.setForeground(Color.ORANGE);
		
		JCheckBoxAudioFile = new JCheckBox();// резервируем память для объекта JCheckBoxAudioFile
		JCheckBoxAudioFile.setSelected(false);
		JCheckBoxAudioFile.setBounds(10,170,25,25);// метод setBounds, который отвечает за точное размещение.Методу передаются 4 значения: отступ слева, отступ сверху, длина компонента, высота компонента.
		JCheckBoxAudioFile.setBackground(Color.black);
		
		JLabelAudioFrequency = new JLabel("Введите частоту дескритизации(Гц)");// резервируем память для объекта JLabelAudioFrequency
		JLabelAudioFrequency.setBounds(10, 200, 250, 25);// метод setBounds, который отвечает за точное размещение.Методу передаются 4 значения: отступ слева, отступ сверху, длина компонента, высота компонента.
		JLabelAudioFrequency.setForeground(Color.ORANGE);
		JTextFieldAudioFrequency = new JTextField(10);// резервируем память для объекта JTextFieldAudioFrequency
		JTextFieldAudioFrequency.setBounds(10, 230, 250, 25);// метод setBounds, который отвечает за точное размещение.Методу передаются 4 значения: отступ слева, отступ сверху, длина компонента, высота компонента.
		JTextFieldAudioFrequency.setEditable(false);
		JLabelBitCapacity = new JLabel("Введите разрядность регистра");// резервируем память для объекта JLabelBitCapacity
		JLabelBitCapacity.setBounds(10, 260, 250, 25);// метод setBounds, который отвечает за точное размещение.Методу передаются 4 значения: отступ слева, отступ сверху, длина компонента, высота компонента.
		JLabelBitCapacity.setForeground(Color.ORANGE);
		JTextFieldAudioBitCapacity = new JTextField(10);// резервируем память для объекта JTextFieldAudioBitCapacity
		JTextFieldAudioBitCapacity.setBounds(10, 290, 250, 25);// метод setBounds, который отвечает за точное размещение.Методу передаются 4 значения: отступ слева, отступ сверху, длина компонента, высота компонента.
		JTextFieldAudioBitCapacity.setEditable(false);
		JButtonDecideAllCameras = new JButton("Посчитать для всех камер");// резервируем память для объекта JButtonDecideAllCameras
		JButtonDecideAllCameras.setBounds(10, 420, 200, 25);// метод setBounds, который отвечает за точное размещение.Методу передаются 4 значения: отступ слева, отступ сверху, длина компонента, высота компонента.
		JButtonDecideAllCameras.setBackground(Color.ORANGE);
		JLabelResult = new JLabel("Выбранная камера:");// резервируем память для объекта JLabelResult
		JLabelResult.setBounds(10,360,250,25);// метод setBounds, который отвечает за точное размещение.Методу передаются 4 значения: отступ слева, отступ сверху, длина компонента, высота компонента.
		JLabelResult.setForeground(Color.ORANGE);
		JLabelFullResult = new JLabel("_____________");// резервируем память для объекта JLabelFullResult
		JLabelFullResult.setBounds(140, 360, 250, 25);// метод setBounds, который отвечает за точное размещение.Методу передаются 4 значения: отступ слева, отступ сверху, длина компонента, высота компонента.
		JLabelFullResult.setForeground(Color.WHITE);
		//JTextFieldResult = new JTextField();
		//JTextFieldResult.setBounds(10, 380, 250, 25);
		//JTextFieldResult.setEnabled(false);
		//JTextFieldResult.setEnabled(false);
		//JTextFieldAudioFrequency.setEditable(false);
		JLabelResultCameras = new JLabel("Все созданные камеры:");// резервируем память для объекта JLabelResultCameras
		JLabelResultCameras.setBounds(10,390,250,25);// метод setBounds, который отвечает за точное размещение.Методу передаются 4 значения: отступ слева, отступ сверху, длина компонента, высота компонента.
		JLabelResultCameras.setForeground(Color.ORANGE);
		JLabelResultCamerasNumber = new JLabel("_____________");// резервируем память для объекта JLabelResultCamerasNumber
		JLabelResultCamerasNumber.setBounds(165,390,250,25);// метод setBounds, который отвечает за точное размещение.Методу передаются 4 значения: отступ слева, отступ сверху, длина компонента, высота компонента.
		JLabelResultCamerasNumber.setForeground(Color.WHITE);
		JCreateObject = new JButton("Добавить камеру");// резервируем память для объекта JCreateObject
		JCreateObject.setBounds(290, 50, 150, 25);// метод setBounds, который отвечает за точное размещение.Методу передаются 4 значения: отступ слева, отступ сверху, длина компонента, высота компонента.
		JCreateObject.setBackground(Color.ORANGE);
		JComboBoxNumberObject = new JComboBox();// резервируем память для объекта JComboBoxNumberObject 
		JComboBoxNumberObject.setBounds(290, 100, 150, 25);// метод setBounds, который отвечает за точное размещение.Методу передаются 4 значения: отступ слева, отступ сверху, длина компонента, высота компонента.
		JButtonSaveParam = new JButton("Посчитать и сохранить параметры для этой камеры");// резервируем память для объекта JButtonSaveParam
		JButtonSaveParam.setBounds(10, 330, 340, 25);// метод setBounds, который отвечает за точное размещение.Методу передаются 4 значения: отступ слева, отступ сверху, длина компонента, высота компонента.
		JButtonSaveParam.setBackground(Color.ORANGE);
		l3 = new JLabel("");// резервируем память для объекта l3
		l4 = new JLabel("");// резервируем память для объекта l4
		t2 = new JTextField(10);// резервируем память для объекта t2
		//add(b1);
	//	add(b2);
		add(JLabelVideoBitrate); // Добавляем элемент 
		add(JTextFieldVideoBitrate); // Добавляем элемент 
		add(JLabelVideoLength); // Добавляем элемент 
		add(JTextFieldVideoLength); // Добавляем элемент 
		add(JCheckBoxAudioFile); // Добавляем элемент 
		add(JLabelAudioFrequency); // Добавляем элемент 
		add(JLabelWithAudio); // Добавляем элемент 
		add(JTextFieldAudioFrequency); // Добавляем элемент 
		add(JLabelBitCapacity); // Добавляем элемент 
		add(JTextFieldAudioBitCapacity); // Добавляем элемент 
		add(JButtonDecideAllCameras); // Добавляем элемент 
		add(JLabelResult); // Добавляем элемент 
		add(JLabelFullResult); // Добавляем элемент 
		add(JCreateObject); // Добавляем элемент 
		add(JComboBoxNumberObject); // Добавляем элемент 
		add(JButtonSaveParam); // Добавляем элемент 
		add(JLabelResultCameras); // Добавляем элемент 
		add(JLabelResultCamerasNumber); // Добавляем элемент 
		//add(JTextFieldResult);
		//add(l4);
		JCheckBoxAudioFile.addActionListener(handler); // Вызываем метод addActionListener для добавления слушателя handler к источнику событий JCheckBoxAudioFile
		JButtonDecideAllCameras.addActionListener(handler); // Вызываем метод addActionListener для добавления слушателя handler к источнику событий JButtonDecideAllCameras
		JCreateObject.addActionListener(handler); // Вызываем метод addActionListener для добавления слушателя handler к источнику событий JCreateObject
		JComboBoxNumberObject.addActionListener(handler); // Вызываем метод addActionListener для добавления слушателя handler к источнику событий JComboBoxNumberObject
		JButtonSaveParam.addActionListener(handler); // Вызываем метод addActionListener для добавления слушателя handler к источнику событий JButtonSaveParam
	    setDefaultCloseOperation(EXIT_ON_CLOSE); //это нужно для того чтобы при закрытии окна закрывалась и программа, иначе она останется висеть в процессах
	    
	    																							//создаем первую камеру
		ObjectNumberName++; // Делаем её значение = 1, тк в начале мы дали ей 0
		StringForJComboBox=String.valueOf(ObjectNumberName); // В StringForJComboBox записываем значение 1, "индекс" камеры
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
		a = " Ваше первое число теперь равно "+ i;
		b = " Ваше второе число теперь равно "+ k;
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
				a = " Ваше первое число теперь равно "+ i;
				b = " Ваше второе число теперь равно "+ k;
				l3.setText(a);
				l4.setText(b);*/
			}
			}
			catch (Exception ep) {JOptionPane.showMessageDialog(null, "Модель не создалась");}
			
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
						JLabelFullResult.setText(String.valueOf(VideoCamera[Integer.valueOf(SelectedObject)].ObjectCameraTotal)+" Мб");
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
			}catch (Exception ep) {JOptionPane.showMessageDialog(null, "модель не выбралась");}
			
			try {
				if(e.getSource()==JButtonSaveParam) {
					
					SelectedObject=(String) JComboBoxNumberObject.getSelectedItem();
					//JOptionPane.showMessageDialog(null, SelectedObject);
					if((JTextFieldAudioFrequency.getText().equals("") )||(JTextFieldAudioFrequency.getText().equals(" "))||(JTextFieldAudioFrequency.getText().equals("  "))) {
						//System.out.println("В проверке");
						JTextFieldAudioFrequency.setText("0");
					}
					if((JTextFieldAudioBitCapacity.getText().equals("") )||(JTextFieldAudioBitCapacity.getText().equals(" "))||(JTextFieldAudioBitCapacity.getText().equals("  "))) {
						//System.out.println("В проверке");
						JTextFieldAudioBitCapacity.setText("0");
					}
					//JOptionPane.showMessageDialog(null, SelectedObject);
					if((JTextFieldVideoBitrate.getText().equals("") )||(JTextFieldVideoBitrate.getText().equals(" "))||(JTextFieldVideoBitrate.getText().equals("  "))) {
						//System.out.println("В проверке");
						JTextFieldVideoBitrate.setText("0");
					}
					if((JTextFieldVideoLength.getText().equals("") )||(JTextFieldVideoLength.getText().equals(" "))||(JTextFieldVideoLength.getText().equals("  "))) {
						//System.out.println("В проверке");
						JTextFieldVideoLength.setText("0");
					}
					VideoCamera[Integer.valueOf(SelectedObject)].ObjectVideoBitrate=Integer.parseInt(JTextFieldVideoBitrate.getText());
					VideoCamera[Integer.valueOf(SelectedObject)].ObjectVideoLength=Integer.parseInt(JTextFieldVideoLength.getText());
					VideoCamera[Integer.valueOf(SelectedObject)].ObjectAudioFrequency=Integer.parseInt(JTextFieldAudioFrequency.getText());
					VideoCamera[Integer.valueOf(SelectedObject)].ObjectAudioBitCapacity=Integer.parseInt(JTextFieldAudioBitCapacity.getText());
					VideoCamera[Integer.valueOf(SelectedObject)].Audio=JCheckBoxAudioFile.isSelected();
					
					
					
				
						if((JCheckBoxAudioFile.isSelected())) {
							//System.out.println("В проверке");

							VideoBitrate=Integer.parseInt(JTextFieldVideoBitrate.getText());
							VideoLength=Integer.parseInt(JTextFieldVideoLength.getText());
							AudioFrequency=Integer.parseInt(JTextFieldAudioFrequency.getText());
							BitCapacity=Integer.parseInt(JTextFieldAudioBitCapacity.getText());
							AudioResult=AudioFrequency*VideoLength*BitCapacity/1024;
							VideoResult=VideoBitrate*VideoLength*60/8192;
							FullResult=AudioResult+VideoResult;
							//VideoCamera[Integer.valueOf(SelectedObject)].ObjectCameraTotal=FullResult;
							JLabelFullResult.setText(String.valueOf(FullResult+" Мб"));
							}
						if(!(JCheckBoxAudioFile.isSelected())) {
							//System.out.println("не В проверке");
							VideoBitrate=Integer.parseInt(JTextFieldVideoBitrate.getText());
							VideoLength=Integer.parseInt(JTextFieldVideoLength.getText());
							VideoResult=VideoBitrate*VideoLength*60/8192;
							FullResult=VideoResult;
							JLabelFullResult.setText(String.valueOf(FullResult+" Мб"));
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
			}catch (Exception ep) {JOptionPane.showMessageDialog(null, "Заполните строки числами");}
			
			
			
			
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
				a = " Ваше первое число теперь равно "+ i;
				b = " Ваше второе число теперь равно "+ k;
				l3.setText(a);
				l4.setText(b);*/
			}
			if (e.getSource()==JButtonDecideAllCameras) {
				for (j=0;j<ObjectNumberName;j++) {
					AllCameraResult=AllCameraResult+VideoCamera[Integer.valueOf(j+1)].ObjectCameraTotal;
					
				}
			JLabelResultCamerasNumber.setText(String.valueOf(AllCameraResult+" Мб"));
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
					JLabelFullResult.setText(String.valueOf(FullResult+" Мб"));
					}
				if((e.getSource()==JButtonDecide)&&(!(JCheckBoxAudioFile.isSelected()))) {
					VideoBitrate=Integer.parseInt(JTextFieldVideoBitrate.getText());
					VideoLength=Integer.parseInt(JTextFieldVideoLength.getText());
					VideoResult=VideoBitrate*VideoLength*60/8192;
					FullResult=VideoResult;
					JLabelFullResult.setText(String.valueOf(FullResult+" Мб"));
					VideoCamera[Integer.valueOf(SelectedObject)].ObjectCameraTotal=FullResult;
					}
			}catch (Exception ex) {JOptionPane.showMessageDialog(null, "Введите в поля числа");
			
*/
			
			/*try {
				if((e.getSource()==JButtonDecide)&&(CheckEdit%2==0)) {
					VideoBitrate=Integer.parseInt(JTextFieldVideoBitrate.getText());
					VideoLength=Integer.parseInt(JTextFieldVideoLength.getText());
					VideoResult=VideoBitrate*VideoLength*60/8192;
					FullResult=VideoResult;
					JTextFieldResult.setText(String.valueOf(FullResult));
					}
			}catch (Exception ex1) {JOptionPane.showMessageDialog(null, "Введите в поля числа");
			} */
	}}
	}
