
package view;

import java.awt.*;
import javax.swing.*;
import java.awt.AWTEvent.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class CaixaView extends JFrame implements ActionListener{
    
    public static JTextField txtCampos[];
    public static JLabel lblCampos [];
    public static JButton btnsair,btnvender;
    public static Container ctnCaixa;
    public static String strCampos []={"CodProduto:","Produtos:","Quantidade:","Preço:","Nome Cliente","CPF:","Total:","Dinheiro Recebido",
        "Troco:"};
    
    
    
    public CaixaView(){
        super("Modulo Caixa");
        
        this.setResizable(false);
        this.show();
        this.setSize(1000,600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ctnCaixa = new Container();
        ctnCaixa.setLayout(null);
        this.add(ctnCaixa);//adicionando o container na tela
        
         lblCampos = new JLabel[strCampos.length];
        txtCampos = new JTextField[strCampos.length];
        
        for(int i=0;i<strCampos.length;i++){
            lblCampos[i]=new JLabel(strCampos[i]);
            txtCampos[i]=new JTextField();
            lblCampos[i].setBounds(10, 40+(50*i),150,20);
            txtCampos[i].setBounds(155,40+(50*i),300,20);
            
            ctnCaixa.add(lblCampos[i]);
            ctnCaixa.add(txtCampos[i]);   
            
        }
        
        
         btnvender = new JButton("Efetuar Venda");
        btnvender.setBounds(100, 500, 150, 20);
        btnvender.addActionListener(this);
        ctnCaixa.add(btnvender);
        
        
          btnsair = new JButton("Voltar");
        btnsair.setBounds(300, 500, 100, 20);
        btnsair.addActionListener(this);
        ctnCaixa.add(btnsair);
    }
    
    
    
    public void actionPerformed(ActionEvent evt){
       if(evt.getSource()== btnsair){
          this.setExtendedState(JFrame.ICONIFIED);//minimizando
          
          
          
          
       }
    }
        public static Dimension montarTela (){ //pegando a resolução  da tela
            Dimension res;//resolução
            Toolkit info = Toolkit.getDefaultToolkit();
            res = info.getScreenSize();
            return res;
        }//fechando montartela
   
}
