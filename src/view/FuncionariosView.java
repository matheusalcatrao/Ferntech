package view;
import javax.swing.*;//importando pacote swing
import java.awt.*;// importando pacote awt
import java.awt.AWTEvent.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import model.ConnectionDao;

public class FuncionariosView extends JFrame implements ActionListener{
    public static JTextField txtCampos[];
    public static JLabel lblCampos [];
    public static JButton btnsair,btncadastro,btnconsulta;
    public static Container ctnFuncionarios;
    public static String strCampos []={"Nome Funcionario:","Endereco:","CPF:","RG:","Telefone:","Email"};
        
    
    
    public FuncionariosView(){
        super("Modulo Cadastro de Funcionarios ");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(1000,600);
        this.setLocationRelativeTo(null);
        this.show();
        this.setResizable(false);
        ctnFuncionarios = new Container();
        ctnFuncionarios.setLayout(null);
        this.add(ctnFuncionarios);//adicionando o container na tela
        
         lblCampos = new JLabel[strCampos.length];
        txtCampos = new JTextField[strCampos.length];
        
        for(int i=0;i<strCampos.length;i++){
            lblCampos[i]=new JLabel(strCampos[i]);
            txtCampos[i]=new JTextField();
            lblCampos[i].setBounds(10, 40+(50*i),150,20);
            txtCampos[i].setBounds(155,40+(50*i),300,20);
            
            ctnFuncionarios.add(lblCampos[i]);
            ctnFuncionarios.add(txtCampos[i]);   
            
        }
        
        //Botoes
        btncadastro = new JButton("Cadastrar");
        btncadastro.setBounds(100, 400, 150, 20);
        btncadastro.addActionListener(this);
        ctnFuncionarios.add(btncadastro);
        
        btnconsulta = new JButton("Consultar");
        btnconsulta.setBounds(300, 400, 150, 20);
        btnconsulta.addActionListener(this);
        ctnFuncionarios.add(btnconsulta);
        
        
        btnsair = new JButton("Voltar");
        btnsair.setBounds(100, 500, 100, 20);
        btnsair.addActionListener(this);
        ctnFuncionarios.add(btnsair);
        
        
        
        
    }//fechando metodo
       public void actionPerformed(ActionEvent evt){
           Statement st;
           ResultSet rs;
           String sql = "";
           int i;
           
                if(evt.getSource()== btnsair){
                     this.setExtendedState(JFrame.ICONIFIED);//fechando ao clicar no sair
                }
                
                if(evt.getSource() == btncadastro){
                try {
                    ConnectionDao.abreConexao();
                    st = ConnectionDao.con.createStatement();
                                                           
                    sql = "INSERT INTO funcionario(nome, endereco, cpf, rg, telefone, email) VALUES (?,?,?,?,?,?)";

                    PreparedStatement stmt = ConnectionDao.con.prepareStatement(sql);
                    
                    stmt.setString(1, sql);
                    
                } catch (Exception e) {
                    System.out.println("Erro ao inserir");

                }
                
                }
                
        }//fechando action
       
}