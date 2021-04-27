
package algorithmvisualizer;
/*================== Took help from this - "https://github.com/greerviau/Visual-Sort" site ================================*/
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public final class Visualization extends JFrame{
    // Variable Declare
    
    private boolean sorting=false,shuffled=true;
    private boolean getInput=false;
    private boolean inputTaken=false;
    private boolean found=false;
    private boolean got=false;
    
    private int crntIndex=0;
    private int len=70;
    private int width_size = 800;//780
    private int height_size = 680;
    private int width=width_size/((crntIndex==5 || crntIndex==6) ? (len-1):len);
    private int speed=20;
    private int current=-1;
    private int check=-1;
    private int type=0;
    private int key=0;
    private int currentKey=-1;
    private int currentKey2=-1;
    private int mid=-1;
    private int value=-1;
    private int height;
    
    ArrayList<Integer> a=new ArrayList<Integer>();
    private int arr[];
    private final String[] algorithms={"Bubble Sort","Selection Sort","Insertion Sort","Merge Sort","Quick Sort",
                                "Linear Search","Binary Search"
    };
    
    private final String[] barName={"Bar Graph","Dot Graph"};
    
    private final String[] algoComplexity={
                                "Bubble Sort:\n\nTime Complexity:\n\nBest Case: O(n^2)\nAverage Case: O(n^2)\nWorst Case: O(n^2)\n\nSpace Complexity: O(1)\n",
                                "Selection Sort:\n\nTime Complexity:\n\nBest Case: O(n^2)\nAverage Case: O(n^2)\nWorst Case: O(n^2)\n\nSpace Complexity: O(1)\n",
                                "Insertion Sort:\n\nTime Complexity:\n\nBest Case: O(n)\nAverage Case: O(n^2)\nWorst Case: O(n^2)\n\nSpace Complexity: O(1)\n",
                                "Merge Sort:\n\nTime Complexity:\n\nBest Case: O(nlogn)\nAverage Case: O(nlogn)\nWorst Case: O(nlogn)\n\nSpace Complexity: O(n)\n",
                                "Quick Sort:\n\nTime Complexity:\n\nBest Case: O(nlogn)\nAverage Case: O(nlogn)\nWorst Case: O(n^2)\n\nSpace Complexity: O(n)\n",
                                "Linear Search:\n\nTime Complexity:\n\nBest Case: O(1)\nAverage Case: O(n/2)\nWorst Case: O(n)\n\nSpace Complexity: O(1)\n",
                                "Binary Search:\n\nTime Complexity:\n\nBest Case: O(1)\nAverage Case: O(logn)\nWorst Case: O(logn)\n\nSpace Complexity: O(1)\n"
    };
     
    private final String[] showCode={"public void bubbleSort()\n{\n    int i=1;\n    boolean noSwap=false;\n    for(;!noSwap && sorting;)\n    {\n        current=len-i;\n        noSwap=true;\n\n        for(int j=0;j<len-i;j++)\n        {\n            if(!sorting) break;\n            if(arr[j]>arr[j+1])\n            {\n                noSwap=false;\n\n                int temp=arr[j];\n                arr[j]=arr[j+1];\n                arr[j+1]=temp;\n            }\n            check=j+1;\n            update();\n            delay();\n        }\n        i++;\n    }\n}",
        "public void selectionSort()\n{\n    for(int i=0;i<len && sorting;i++)\n    {\n        int item=i;\n        current=i;\n        for(int j=i+1;j<len;j++)\n        {\n            if(!sorting) break;\n            if(arr[j]<arr[item])\n            {\n                item=j;\n            }\n            check=j;\n            update();\n            delay();\n        }\n        if(i!=item)\n        {\n            int tmp = arr[i];\n            arr[i] = arr[item];\n            arr[item] = tmp;\n        }\n    }\n}\n",
        "public void insertionSort()\n{\n    for(int i = 1; i < len; i++)\n    {\n        current = i;\n        int j = i;\n        while(arr[j] < arr[j-1] && sorting)\n        {\n            int tmp = arr[j];\n            arr[j] = arr[j-1];\n            arr[j-1] = tmp;\n\n            check = j;\n            update();\n            delay();\n\n            if(j > 1)\n                j--;\n        }\n    }\n}\n",
        "public void doMerge(int l,int m,int r)\n{\n    int s1=m-l+1;\n    int s2=r-m;\n    int left_auxi[]=new int[s1];\n    int right_auxi[]=new int[s2];\n    for(int i=0;i<s1;i++)\n    {\n        left_auxi[i]=arr[l+i];\n    }\n    for(int i=0;i<s2;i++)\n    {\n        right_auxi[i]=arr[m+1+i];\n    }\n    int i=0,j=0,k=l;\n    while(i<s1 && j<s2 && sorting)\n    {\n        check=k;\n        if(left_auxi[i]<=right_auxi[j])\n        {\n            arr[k]=left_auxi[i];\n            i++;\n            k++;\n        }\n        else\n        {\n            arr[k]=right_auxi[j];\n            j++;\n            k++;\n        }\n        update();\n        delay();\n    }\n    while(i<s1 && sorting)\n    {\n        arr[k]=left_auxi[i];\n        i++;\n        k++;\n        update();\n        delay();\n    }\n    while(j<s2 && sorting)\n    {\n        arr[k]=right_auxi[j];\n        j++;\n        k++;\n        update();\n        delay();\n    }\n}\n\npublic void mergeSort(int l,int r)\n{\n    if(l<r)\n    {\n        int m=l+(r-l)/2;\n        current=r;\n        mergeSort(l,m);\n        mergeSort(m+1,r);\n        doMerge(l,m,r);\n    }\n}\n",
        "public int partition(int low,int high)\n{\n    int pivot=arr[high];\n    int i=low-1;\n    for(int j=low;j<=high-1;j++)\n    {\n        check=j;\n        if(arr[j]<pivot)\n        {\n            i++;\n            int tmp = arr[i];\n            arr[i] = arr[j];\n            arr[j] = tmp;\n        }\n        update();\n        delay();\n    }\n    int tmp = arr[i+1];\n    arr[i+1] = arr[high];\n    arr[high] = tmp;\n    update();\n    delay();\n    return (i+1);\n}\n\npublic void quickSort(int low,int high)\n{\n    current=high;\n    if(low<high)\n    {\n        int pi=partition(low,high);\n\n        quickSort(low,pi-1);\n        quickSort(pi+1,high);\n    }\n}\n",
        "public void linearSearch()\n{\n    for(int i=0;i<len-1 && sorting;i++)\n    {\n        if(arr[i]==key)\n        {\n            System.out.println(\"found\");\n            currentKey=i;\n            got=true;\n            break;\n        }\n        else \n        {\n            currentKey=i;\n            System.out.println(\"not found\");\n            got=false;\n        }\n        check=i;\n        update();\n        delay();\n    }\n}\n",
        "public void binarySearch()\n{\n    Arrays.sort(arr);\n    int low=0,high=arr.length-1;\n    found=false;\n    while(low<=high && sorting)\n    {\n        mid=low+(high-low)/2;\n        currentKey2=mid;\n        if(arr[mid]==key)\n        {\n            System.out.println(\"found\");\n            found=true;\n            break;\n        }\n        else if(arr[mid]>key)\n        {\n            high=mid-1;\n        }\n        else\n        {\n            low=mid+1;\n        }\n        check=mid;\n        update();\n        delay();\n    }\n    if(!found)\n    {\n        System.out.println(\"not found\");\n    }\n}\n"};
        
   
    private Container c;
   
    Font font=new Font("Arial",Font.BOLD,14);
    Font font2=new Font("Arial",Font.BOLD,12);
    Font font3=new Font("Arial",Font.BOLD,18);
    
    JPanel controlPanel=new JPanel();
    JLabel controlLabel1=new JLabel("Algorithms: ");
    
    JComboBox algoType=new JComboBox(algorithms);
    
    JLabel controlLabel2=new JLabel("Graph Types: ");
    JComboBox barType=new JComboBox(barName);
    JButton sortBtn=new JButton("Sort");
    JButton stopBtn=new JButton("Exit");
    JButton shuffleBtn=new JButton("Shuffle");
    JLabel arraySize=new JLabel("Array Size: ");
    JSlider arraySizeSlider=new JSlider(50,200,50);
    JLabel delay=new JLabel("Delay (ms) : ");
    JSlider delaySlider=new JSlider(0,100,20);
    JLabel complexity=new JLabel("Complexity:");
    JTextArea complexityField=new JTextArea(algoComplexity[crntIndex]);
    JScrollPane complexityScroll=new JScrollPane(complexityField,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    JButton creditBtn=new JButton("Credit");
    JPanel codePanel=new JPanel();
    JLabel codeLabel1=new JLabel("Code: ");
    JTextArea codeField=new JTextArea(showCode[crntIndex]);
    JScrollPane codeScroll=new JScrollPane(codeField,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    
    JLabel inputLabel=new JLabel("Insert Data:");
    JLabel noNegative=new JLabel("1) Negative value is not allowed");
    JLabel whichIsKey=new JLabel("2) Last value is the key");
    
    JTextField inputField=new JTextField();
    JButton okBtn=new JButton("Ok");
    
    private final Random rand=new Random();
    GraphCanvas canvas;
    SortingAlgorithms WhichAlgo=new SortingAlgorithms();
    
    
    
    Visualization(){
        shuffleList();
        initComponents();
    }
    public void createArray(){
        int newLen=((crntIndex==5 || crntIndex==6) ? len-1:len);
        arr=new int[newLen];
        
        for(int i=0;i<newLen;i++){
            arr[i]=rand.nextInt(newLen); 
            //arr[i]=i+1;
            
        }
        key=arr[arr.length-1];
    }
    
    public void createInputArray(){
        
        if(crntIndex==5 || crntIndex==6){// search algo
            arr=new int[len-1];
            for(int i=0;i<len-1;i++){
                arr[i]=a.get(i); 
                
            }
        }
        else{
            arr=new int[len];
            for(int i=0;i<len;i++){
                arr[i]=a.get(i); 
                
            }
        }
        
        reset();
        update();
        
    }
    
    public void shuffleList() {
        if(!getInput){
            createArray();
            for(int i = 0; i < 500; i++) {
                for(int j = 0; j < ((crntIndex==5 || crntIndex==6) ? len-1:len); j++) {
                    int random = rand.nextInt(((crntIndex==5 || crntIndex==6) ? len-1:len));

                    int temp = arr[j];		
                    arr[j] = arr[random];		
                    arr[random] = temp;			
                }
            }
        }
        else{
            createInputArray();
            
            if(crntIndex==5 || crntIndex==6){// search algo
                
                for(int i = 0; i < 500; i++) {
                    //System.out.println("---------------"+len);

                    for(int j = 0; j < len-1; j++) {
                        int random = rand.nextInt(len-1);

                        int temp = arr[j];		
                        arr[j] = arr[random];		
                        arr[random] = temp;			
                    }
                }
            }
            else{
                for(int i = 0; i < 500; i++) {
                   for(int j = 0; j < len; j++) {
                        int random = rand.nextInt(len);

                        int temp = arr[j];		
                        arr[j] = arr[random];		
                        arr[random] = temp;			
                    }
                }
            }
            
        }
	sorting = false;
	shuffled = true;
    }
    
    public void initComponents(){
        
        // Frame Create
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(150,20,1280,720);
        this.setTitle("HT Algorithm Visualizer");
        this.setResizable(false);
    
        
        
        c=getContentPane();
        c.setLayout(null);
        c.setBackground(Color.GRAY);
   
        
        /* --------------------  Control Panel Start  -------------------- */
        
        // Control Panel create and add into ContentPane
        //controlPanel=new JPanel();
        controlPanel.setLayout(null);
        controlPanel.setBounds(0,0,150,720);
        controlPanel.setBackground(new Color(31,56,78));
        c.add(controlPanel);
     
        // "Algorithms" label create
        //controlLabel1=new JLabel("Algorithms: ");
        controlLabel1.setBounds(30,5,100,15);
        controlLabel1.setForeground(Color.WHITE);
        controlLabel1.setFont(font);
        controlPanel.add(controlLabel1);
        
        // Combo-box for Algorithms
        //algoType=new JComboBox(algorithms);
        algoType.setBounds(15,27,120,20);
        algoType.setFont(font2);
        algoType.setEditable(true);
        controlPanel.add(algoType);
        
        // "Graph Types" label create
        //controlLabel2=new JLabel("Graph Types: ");
        controlLabel2.setBounds(25,55,100,15);
        controlLabel2.setForeground(Color.WHITE);
        controlLabel2.setFont(font);
        controlPanel.add(controlLabel2);
        
        // Combo-box for Graph Types
        //barType=new JComboBox(barName);
        barType.setBounds(15,75,120,20);
        barType.setFont(font2);
        barType.setEditable(true);
        controlPanel.add(barType);
        
        // Sort Button create
        //sortBtn=new JButton("Sort");
        sortBtn.setBounds(35,105,80,20);
        sortBtn.setFont(font2);
        controlPanel.add(sortBtn);
        
        // Stop Button create
        //stopBtn=new JButton("Stop");
        stopBtn.setBounds(35,130,80,20);
        stopBtn.setFont(font2);
        controlPanel.add(stopBtn);
        
        // Shuffle Button create
        //shuffleBtn=new JButton("Shuffle");
        shuffleBtn.setBounds(35,155,80,20);
        shuffleBtn.setFont(font2);
        controlPanel.add(shuffleBtn);
        
        // "Array Size" label create
        //arraySize=new JLabel("Array Size: ");
        arraySize.setBounds(5,198,100,20);
        arraySize.setForeground(Color.WHITE);
        arraySize.setFont(font);
        controlPanel.add(arraySize);
        
        // "JSlider" for Array Size
        //arraySizeSlider=new JSlider(50,300,50);
        arraySizeSlider.setBounds(0,230,150,40);
        arraySizeSlider.setBackground(new Color(31,56,78));
        arraySizeSlider.setForeground(Color.WHITE);
        arraySizeSlider.setMajorTickSpacing(50);
        arraySizeSlider.setPaintTicks(true);
        arraySizeSlider.setPaintLabels(true);
        controlPanel.add(arraySizeSlider);
        
        // "Delay" label create
        //delay=new JLabel("Delay (ms) : ");
        delay.setBounds(10,300,100,20);
        delay.setForeground(Color.WHITE);
        delay.setFont(font);
        controlPanel.add(delay);
        
        // "JSlider" for Delay
        //delaySlider=new JSlider(0,100,20);
        delaySlider.setBounds(0,330,150,40);
        delaySlider.setBackground(new Color(31,56,78));
        delaySlider.setForeground(Color.WHITE);
        delaySlider.setMajorTickSpacing(25);
        delaySlider.setPaintTicks(true);
        delaySlider.setPaintLabels(true);
        controlPanel.add(delaySlider);
        
        
        // "Complexity" label create
        //complexity=new JLabel("Complexity:");
        complexity.setBounds(10,405,100,20);
        complexity.setForeground(Color.WHITE);
        complexity.setFont(font);
        controlPanel.add(complexity);
        
        // "Complexity" text-field to show the complexity of the algorithm
        //complexityField=new JTextArea(algoComplexity[crntIndex]);
        complexityField.setFont(font2);
        complexityField.setLineWrap(true);
        complexityField.setWrapStyleWord(true);
        
        complexityScroll.setBounds(5,430,140,200);
        controlPanel.add(complexityScroll);
        
        // "Credit" Button create
        //creditBtn=new JButton("Credit");
        creditBtn.setBounds(35,650,80,20);
        creditBtn.setFont(font2);
        controlPanel.add(creditBtn);
        
        this.setVisible(true);
        
        /* --------------------  Control Panel End  -------------------- */
        
        
        /* ---------------  Graph & Compare Panel Start  --------------- */
        
        canvas=new GraphCanvas();
        canvas.setBounds(155,5,780,680);
        c.add(canvas);
        
        /* ---------------  Graph & Compare Panel Start  --------------- */
        
        
        /* --------------------   Code Panel Start   ------------------- */
        
        // Code Panel create
       
        codePanel.setLayout(null);
        codePanel.setBounds(940,0,340,720);
        codePanel.setBackground(new Color(21,49,75));
        c.add(codePanel);
        
        // "Code" label create
        //codeLabel1=new JLabel("Code: ");
        codeLabel1.setBounds(10,5,100,15);
        codeLabel1.setFont(font);
        codeLabel1.setForeground(Color.WHITE);
        codePanel.add(codeLabel1);
        
        // "Code-Field" create to show code
        //codeField=new JTextArea();
        codeField.setFont(font);
        codeField.setBackground(new Color(65,68,73));// new Color(8,82,70)
        codeField.setForeground(Color.WHITE);
        
        codeScroll=new JScrollPane(codeField,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        codeScroll.setBounds(5,25,320,460);
        codePanel.add(codeScroll);
        
        // "Insert data" label create
        //inputLabel=new JLabel("Insert Data: ");
        inputLabel.setBounds(5,495,100,15);
        inputLabel.setForeground(Color.WHITE);
        inputLabel.setFont(font);
        codePanel.add(inputLabel);
        
        noNegative.setBounds(5,515,320,15);
        noNegative.setForeground(Color.WHITE);
        noNegative.setFont(font);
        codePanel.add(noNegative);
        
        whichIsKey.setBounds(5,535,320,15);
        whichIsKey.setForeground(Color.WHITE);
        whichIsKey.setFont(font);
        codePanel.add(whichIsKey);
        
        
        // "Input-Field" create to take input
        
        inputField.setBounds(5,565,320,70);
        inputField.setBackground(new Color(65,68,73));
        inputField.setForeground(Color.WHITE);
        inputField.setFont(font3);
        codePanel.add(inputField);
       
        
        okBtn.setBounds(130,650,80,25);
        okBtn.setFont(font2);
        codePanel.add(okBtn);
        
        /* --------------------   Code Panel End   ------------------- */
        
        algoType.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent ie) {
                reset();update();
                crntIndex=algoType.getSelectedIndex();
                complexityField.setText(algoComplexity[crntIndex]);
                
                
                codeField.setText(showCode[crntIndex]);
            }
        });
        
        barType.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent ie) {
                type = barType.getSelectedIndex();
                
                shuffleList();
                reset();
                update();
            }
        });
        
        sortBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(shuffled){
                    sorting=true;
                    //sorting();
                }
            }
            
        });
        
        stopBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                System.exit(0);
            }
            
        });
        
        shuffleBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                shuffleList();
                reset();
               
            }
            
        });
        
        arraySizeSlider.addChangeListener(new ChangeListener(){
            @Override
            public void stateChanged(ChangeEvent ce) {
                value=arraySizeSlider.getValue();
                //System.out.println(value+"--------");
                len=value;
                if(arr.length!=len){
                    shuffleList();
                }
                reset();
            }
        });
        
        delaySlider.addChangeListener(new ChangeListener(){
            @Override
            public void stateChanged(ChangeEvent ce) {
                speed=(int)delaySlider.getValue();
                
            }
        });
        
        creditBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                JOptionPane.showMessageDialog(null,"Golam Ibne Hamza\nID: 190104029\nAUST\n\n"
                        + "Md Tanvir Hossain\nID: 190104036\nAUST", "Credit",JOptionPane.INFORMATION_MESSAGE);
            }
        });
       
        okBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                String str=inputField.getText();
                //System.out.println(str);
                
                if(str.equals("")){
                   
                    getInput=false;
                    update();
                    reset();
                    
                    shuffleList();
                    
                }
                else{
                    a.clear();
                    String[] val=str.split(" ");
                    inputTaken=true;
                    
                    for(String ss:val){
                       
                        a.add(Integer.parseInt(ss));
                      
                    }
                    
                    len=a.size();
                    key=a.get(len-1);
                    
                    getInput=true;
                    got=false;
                    found=false;
                    shuffleList();
                    
                    
                }
                
            }
            
        });
                
        sorting();
    }
    
    public void sorting(){
        if(sorting){
            switch (crntIndex) {
                case 0:
                    WhichAlgo.bubbleSort();
                    break;
                case 1:
                    WhichAlgo.selectionSort();
                    break;
                case 2:
                    WhichAlgo.insertionSort();
                    break;
                case 3:
                    WhichAlgo.mergeSort(0,arr.length-1);
                    break;
                case 4:
                    WhichAlgo.quickSort(0,arr.length-1);
                    break;
                case 5:
                    WhichAlgo.linearSearch();
                    break;
                case 6:
                    WhichAlgo.binarySearch();
                    break;
               
            }
        }
        reset();
        pause();
    }
    
    public void pause(){
        int i=0;
        while(!sorting){
            i++;
            if(i>100)
                i=0;
            try {
            Thread.sleep(0);
            } catch (InterruptedException ex) {
                Logger.getLogger(Visualization.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        sorting();
    }
     
    public void reset(){
        sorting=false;
        current=-1;
        check=-1;
        update();
    }
    
     public void delay(){
        try {
            Thread.sleep(speed);
        } catch (InterruptedException ex) {
            Logger.getLogger(Visualization.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
    public void update(){

        width=width_size/((crntIndex==5 || crntIndex==6) ? (len-1):len);
        canvas.repaint();
    }
    
    public class GraphCanvas extends JPanel{
        GraphCanvas(){
            setBackground(Color.BLACK);
        }
        public void paintComponent(Graphics graph){
            super.paintComponent(graph);
            
            //len=value;
            int changeLength=((crntIndex==5 || crntIndex==6) ? len-1:len);
            //System.out.println(changeLength+"======");
            for(int i=0;i<changeLength;i++){
                //int height;
                try {
                    height = (arr[i]*width);
                } catch (Exception e) {
                }
                
                if(type==0){
                    graph.setColor(new Color(64,135,252));//new Color(64,135,252)
                    
                    if(crntIndex==5){// linear search
                        if(currentKey>-1 && i==check){
                            graph.setColor(Color.RED);
                        }
                        if(currentKey==i && i<len-2 && got){
                            graph.setColor(Color.GREEN);
                            
                        }
                       
                    }
                    else if(crntIndex==6){// binary search
                        if(currentKey2>-1 && check==i){
                            graph.setColor(Color.RED);
                        }
                        
                        if(i==mid && found && i<len-2){
                            graph.setColor(Color.GREEN);
                            
                        }
                        
                    }
                    else{
                        if(current>-1 && i==current){
                            graph.setColor(Color.GREEN);
                        }
                        if(check>-1 && i==check){
                            graph.setColor(Color.RED);
                        }
                    }
                    graph.fillRect(i*width, width_size-height, width, height);
                    graph.setColor(Color.BLACK);
                    graph.drawRect(i*width, width_size-height, width, height);
                }
                
                else if(type==1){
                    graph.setColor(new Color(64,135,252));
                    
                    if(crntIndex==5){// linear search
                        if(currentKey>-1 && i==check){
                            graph.setColor(Color.RED);
                        }
                        if(currentKey==i && i<len-2 && got){
                            graph.setColor(Color.GREEN);
                            
                        }
                       
                    }
                    else if(crntIndex==6){// binary search
                        if(currentKey2>-1 && check==i){
                            graph.setColor(Color.RED);
                        }
                        
                        if(i==mid && found && i<len-2){
                            graph.setColor(Color.GREEN);
                            
                        }
                    } 
                    else{
                        if(current>-1 && i==current){
                            graph.setColor(Color.GREEN);
                        }
                        if(check>-1 && i==check){
                            graph.setColor(Color.RED);
                        }
                    }
                    graph.fillOval(i*width, width_size-height, width, width);
                }
            }
        }
    }
    
    public class SortingAlgorithms{
        public void bubbleSort(){
            int i=1;
            boolean noSwap=false;
            for(;!noSwap && sorting;){
                current=len-i;
                noSwap=true;
                for(int j=0;j<len-i;j++){
                    if(!sorting) break;
                    
                    if(arr[j]>arr[j+1]){
                        noSwap=false;
                        
                        int temp=arr[j];
                        arr[j]=arr[j+1];
                        arr[j+1]=temp;
                        
                    }
                    check=j+1;
                    update();
                    delay();
                }
                i++;
            }
        }
        public void selectionSort(){
            
            for(int i=0;i<len && sorting;i++){
                int item=i;
                current=i;
                for(int j=i+1;j<len;j++){
                    if(!sorting) break;
                    if(arr[j]<arr[item]){
                        item=j;
                    }
                    check=j;
                    update();
                    delay();
                }
                if(i!=item){
                    int tmp = arr[i];
                    arr[i] = arr[item];
                    arr[item] = tmp;
                }
            }
        }
        public void insertionSort(){
            for(int i = 1; i < len; i++) {
		current = i;
		int j = i;
		while(arr[j] < arr[j-1] && sorting) {
              
                    int tmp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = tmp;
                    check = j;
                    update();
                    delay();
                    if(j > 1)
                        j--;
		}
            }
        }
        
        public void doMerge(int l,int m,int r){

            int s1=m-l+1;
            int s2=r-m;
            int left_auxi[]=new int[s1];
            int right_auxi[]=new int[s2];

            for(int i=0;i<s1;i++){
                left_auxi[i]=arr[l+i];
            }

            for(int i=0;i<s2;i++){
                right_auxi[i]=arr[m+1+i];
            }

            int i=0,j=0,k=l;

            while(i<s1 && j<s2 && sorting){

                check=k;
                if(left_auxi[i]<=right_auxi[j]){
                    arr[k]=left_auxi[i];
                    i++;
                    k++;
                }
                else{
                    arr[k]=right_auxi[j];
                    j++;
                    k++;
                }
                update();
                delay();

            }

            while(i<s1 && sorting){
                arr[k]=left_auxi[i];
                i++;
                k++;
                update();
                delay();
            }
            while(j<s2 && sorting){
                arr[k]=right_auxi[j];
                j++;
                k++;
                update();
                delay();
            }
        }
        public void mergeSort(int l,int r){
            if(l<r){
                int m=l+(r-l)/2;
                
                current=r;
                
                mergeSort(l,m);
                mergeSort(m+1,r);

                doMerge(l,m,r);
            }
        }
        
        public int partition(int low,int high){

            int pivot=arr[high];
            int i=low-1;
            for(int j=low;j<=high-1;j++){
                check=j;
                if(arr[j]<pivot){
                    i++;
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
                update();
                delay();
            }
            
            int tmp = arr[i+1];
            arr[i+1] = arr[high];
            arr[high] = tmp;
            
            update();
            delay();
                
            return (i+1);
        }
        
        public void quickSort(int low,int high){
            current=high;
            if(low<high){
                int pi=partition(low,high);
                quickSort(low,pi-1);
                quickSort(pi+1,high);
            }
        }
        public void linearSearch(){
            
            for(int i=0;i<len-1 && sorting;i++){
                //currentKey=i;
                if(arr[i]==key){
                    //System.out.println("found");
                    currentKey=i;
                    got=true;
                   
                    break;
                }
                else {
                    currentKey=i;
                    //System.out.println("not found");
                    got=false;
                }
                check=i;
                update();
                delay();
            }
            
        }
        public void binarySearch(){
            Arrays.sort(arr);
            int low=0,high=arr.length-1;
            found=false;
            while(low<=high && sorting){
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Visualization.class.getName()).log(Level.SEVERE, null, ex);
                }
                mid=low+(high-low)/2;
                currentKey2=mid;
                if(arr[mid]==key){
                    //System.out.println("found");
                    found=true;
                    break;
                }
                else if(arr[mid]>key){
                    high=mid-1;
                }
                else{
                    low=mid+1;
                }
                check=mid;
                update();
                delay();
            }
            if(!found){
                //System.out.println("not found");
            }
        }
    }
}
