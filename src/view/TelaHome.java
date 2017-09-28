package view;
import view.CaixaView;
import view.ProdutosView;
import view.FuncionariosView;
import view.ClientesView;
import javax.swing.*;
import java.awt.*;
import java.util.Date;
import java.awt.AWTEvent.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;




public class TelaHome extends JFrame implements ActionListener{
        public static JButton  btnmenu []; 
        public static JLabel lblbanner;
        public static Container ctnmenu,ctntopo,ctnprincipal;
        public static String stmenu[] = {"Caixa","Clientes","Cadastro F.","Produtos","Sair"};
    
    public TelaHome(){
        super("PHARMACIC SYSTEM BETA 4.0");
        ctnprincipal = new Container();
        ctnprincipal.setLayout(new BorderLayout());
        ctntopo = new Container();//instanciando o container 
        ctntopo.setLayout(new GridLayout(2,1));//defindo o layout
        ctnmenu = new Container();
        ctnmenu.setLayout(new GridLayout(1,5));
        
        lblbanner = new JLabel(new ImageIcon("img/banner.JPG"));
        this.add(ctnprincipal);//adicionando Container principal a janela
        ctnprincipal.setForeground(Color.RED);
        ctnprincipal.add(ctntopo,BorderLayout.NORTH);//adicionando topo ao principal
        ctntopo.add(lblbanner);//adicionado banner na primeir linha do topo
        ctntopo.add(ctnmenu);//adicionando menu a segunda linha do topo
        this.show();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(montarTela());
        
        btnmenu = new JButton[5];
        
              
         for(int i=0;i<btnmenu.length;i++){
                btnmenu[i]= new JButton(stmenu[i]);
                btnmenu[i].setToolTipText(stmenu[i]);
        
                    ctnmenu.add(btnmenu[i]);  //adicionando bot�es no ctnmenu
                   btnmenu [i].setBackground(Color.LIGHT_GRAY);
                   btnmenu[i].addActionListener(this); 
             }
    
    
    }
    public void actionPerformed(ActionEvent evt){
       if(evt.getSource()== btnmenu[0]){
           CaixaView telacaixa = new CaixaView();
            telacaixa.setVisible(true);
       }
              
       if(evt.getSource()== btnmenu[1]){
           ClientesView telaclientes = new ClientesView();
           telaclientes.setVisible(true);
       }
       
       if(evt.getSource()== btnmenu[2]){
           FuncionariosView telafunc = new FuncionariosView();
           telafunc.setVisible(true);
       }if(evt.getSource()== btnmenu[3]){
           ProdutosView telaprodutos = new ProdutosView();
           telaprodutos.setVisible(true);
       }
       if(evt.getSource()== btnmenu[4]){
         
          System.exit(0);//fechando ao clicar no sair
       }
    }//fechando action
    public static Dimension montarTela (){ //pegando a resolução  da tela
            Dimension res;//resolução
            Toolkit info = Toolkit.getDefaultToolkit();
            res = info.getScreenSize();
            return res;
        }//fechando montartela
   
    
}
