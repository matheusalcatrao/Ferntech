package view;
import javax.swing.*;//importando pacote swing
import java.awt.*;// importando pacote awt
import java.awt.AWTEvent.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ClientesView extends JFrame implements ActionListener{
    public static JTextField txtCampos[];
    public static JLabel lblCampos [];
    public static JButton btnsair,btncadastro,btnconsulta;
    public static Container ctnClientes;
    public static String strCampos []={"CodCliente:","Nome Cliente:","CPF:","Telefone:","Email"};
        
    
    
    public ClientesView(){
        super("Modulo Cadastro de Clientes ");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(1000,600);
        this.setLocationRelativeTo(null);
        this.show();
        this.setResizable(false);
        ctnClientes = new Container();
        ctnClientes.setLayout(null);
        this.add(ctnClientes);//adicionando o container na tela
        
         lblCampos = new JLabel[strCampos.length];
        txtCampos = new JTextField[strCampos.length];
        
        for(int i=0;i<strCampos.length;i++){
            lblCampos[i]=new JLabel(strCampos[i]);
            txtCampos[i]=new JTextField();
            lblCampos[i].setBounds(10, 40+(50*i),150,20);
            txtCampos[i].setBounds(155,40+(50*i),300,20);
            
            ctnClientes.add(lblCampos[i]);
            ctnClientes.add(txtCampos[i]);   
            
        }
        
        //Botoes
        btncadastro = new JButton("Cadastrar");
        btncadastro.setBounds(100, 400, 150, 20);
        btncadastro.addActionListener(this);
        ctnClientes.add(btncadastro);
        
        btncadastro = new JButton("Consultar");
        btncadastro.setBounds(300, 400, 150, 20);
        btncadastro.addActionListener(this);
        ctnClientes.add(btncadastro);
        
        
        btnsair = new JButton("Voltar");
        btnsair.setBounds(100, 500, 100, 20);
        btnsair.addActionListener(this);
        ctnClientes.add(btnsair);
        
        
        
        
    }//fechando metodo
       public void actionPerformed(ActionEvent evt){
                if(evt.getSource()== btnsair){
                     this.setExtendedState(JFrame.ICONIFIED);//fechando ao clicar no sair
                }
        }//fechando adction
}//fechando classe