package tela;

// Importando as bibliotecas de interface gráfica
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginGUI {
    private static JTextField loginSpace;
    private static JTextField senhaSpace;

    public static void main(String[] args) {
        // Criação da janela principal
        JFrame tela = new JFrame("Tela de Login");

         // Componentes da interface de login
        JLabel textLogin = new JLabel("Login");
        JLabel textSenha = new JLabel("Senha");
        loginSpace = new JTextField();
        senhaSpace = new JPasswordField();
        JButton limpar = new JButton("LIMPAR");
        JButton enviar = new JButton("ENVIAR");

         // Configuração do layout absoluto (null layout)
        tela.setLayout(null);

         // Configuração das posições e tamanhos dos componentes
        textLogin.setBounds(155, 30, 90, 30);
        loginSpace.setBounds(155, 55, 150, 30);
        textSenha.setBounds(155, 100, 90, 30);
        senhaSpace.setBounds(155, 125, 150, 30);
        limpar.setBounds(120, 180, 110, 30);
        enviar.setBounds(250, 180, 110, 30);

         // Adição dos componentes à tela
        tela.getContentPane().add(textLogin);
        tela.getContentPane().add(loginSpace);
        tela.getContentPane().add(textSenha);
        tela.getContentPane().add(senhaSpace);
        tela.getContentPane().add(limpar);
        tela.getContentPane().add(enviar);

         // Configuração do tamanho da janela
        tela.setSize(480, 300);

         // Centralização da janela na tela
        tela.setLocationRelativeTo(null);

        // Torna a janela visível
        tela.setVisible(true);

         // Configuração do listener para o botão "Limpar"
        limpar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limparCampos();
            }
        });

         // Configuração do listener para o botão "Enviar"
        enviar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtenção dos valores digitados nos campos de login e senha
                String login = loginSpace.getText();
                String senha = senhaSpace.getText();

                 // Verificação das credenciais
                if (login.equals("user") && senha.equals("12345")) {
                    // Se as credenciais estiverem corretas, abre a GUI do fornecedor
                    abrirFornecedorGUI();
                    // Esconde a janela de login
                    tela.setVisible(false);
                } else {
                    // Exibe uma mensagem de erro se as credenciais estiverem incorretas
                    JOptionPane.showMessageDialog(null, "Usuário ou senha inválidos. Tente novamente.");
                }
            }
        });
    }

     // Método para limpar os campos de login e senha
    private static void limparCampos() {
        loginSpace.setText("");
        senhaSpace.setText("");
    }

    // Método para abrir a GUI do fornecedor
    private static void abrirFornecedorGUI() {
        FornecedorGUI fornecedorGUI = new FornecedorGUI();
        fornecedorGUI.setVisible(true);
    }

}