package bancodedadosloja;

import DAO.ClienteDAO;
import DAO.DistribuidoresDAO;
import DAO.ItensVendasDAO;
import DAO.ProdutosDAO;
import DAO.VendasDAO;
import conversores.Conversor;
import modelos.Clientes;
import modelos.Distribuidores;
import modelos.ItensVendas;
import modelos.Produtos;
import modelos.Vendas;

public class BancoDeDadosLoja {

    public static void main(String[] args) {
       //CLIENTES
        
        ClienteDAO cliDAO = new ClienteDAO();
        
        Clientes c1 = new Clientes();
        
        
        c1.setCodCliente(1);
        c1.setNome("Daniel Felipe Mizan");
        c1.setDataNasc(Conversor.StringParaData("03/04/1998"));
        c1.setEndereco("Rua Vinte e Quatro, Nª 250 - Dom Pedro II");
        c1.setTelefone("(12)98141-4143");
        c1.setEmail("daniel.mizanbr@hotmail.com");     
        cliDAO.create(c1);
        
        Clientes c2 = new Clientes();
        
        c2.setCodCliente(2);
        c2.setNome("Rodrigo Felipe Silva de Jesus");
        c2.setDataNasc(Conversor.StringParaData("11/02/1998"));
        c2.setEndereco("Rua Odete Garcia, Nª 302 - Jardim Morumbi");
        c2.setTelefone("(11)98437-4857");
        c2.setEmail("rodrigofelipej@hotmail.com");  
        
        cliDAO.create(c2);
        
        Clientes c3 = new Clientes();
        
        c3.setCodCliente(3);
        c3.setNome("João Vitor Nunes");
        c3.setDataNasc(Conversor.StringParaData("01/05/2004"));
        c3.setEndereco("Rua Alfredo Coslop, Nª 100 - Bosque dos Eucaliptos");
        c3.setTelefone("(12)98888-4444");   
        
        cliDAO.create(c3);
        
        Clientes c4 = new Clientes();
        
        c4.setCodCliente(4); 
        c4.setNome("Júlia Freitas Silva");
        c4.setDataNasc(Conversor.StringParaData("13/01/1999"));
        c4.setEndereco("Rua México, Nª 373 - Vista Verde");
        c4.setTelefone("(12)99999-9999"); 
        
        cliDAO.create(c4);
        
        Clientes c5 = new Clientes();
        
        c5.setCodCliente(5);
        c5.setNome("Joana Lopes Carvalho");
        c5.setDataNasc(Conversor.StringParaData("10/07/1990"));
        c5.setEndereco("Rua Odete Garcia, Nª 200 - Jardim Morumbi");
        c5.setTelefone("(11)98111-2222");  
      
        cliDAO.create(c5); 
       
        //DISTRIBUIDORES
        DistribuidoresDAO DisDAO = new DistribuidoresDAO();
        Distribuidores d1 = new Distribuidores();
        
        d1.setCodDistribuidor(1);
        d1.setNomeFantasia("TechInfo");
        d1.setRazaoSocial("TechInfo Indústrias Ltda");
        d1.setTelefone("(12) 3966-3119");
        d1.setEmail("tech_info@techinfo.com.br"); 
        DisDAO.create(d1); 
        
        Distribuidores d2 = new Distribuidores();
        
        d2.setCodDistribuidor(2);
        d2.setNomeFantasia("CableTech");
        d2.setRazaoSocial("CableTech Indústrias Ltda");
        d2.setTelefone("(12) 3966-5745");
        d2.setEmail("cabo_tech@cabletech.com.br");
        DisDAO.create(d2);
        
        //PRODUTOS
        ProdutosDAO ProDAO = new ProdutosDAO();
        Distribuidores distribuidores = new Distribuidores();
        
        Produtos p1 = new Produtos();
        distribuidores.setCodDistribuidor(1);
        p1.setCodProduto(1);
        p1.setPrecoVenda(50.00);
        p1.setDescricao("Alcool Isopropilico 500ml - Com Bico Bga Smd Limpeza De Placa");
        p1.setDataValidade(Conversor.StringParaData("07/10/2020"));
        p1.setPrecoCusto(20.00);
        p1.setEstoque(10);
        p1.SetDistribuidores(distribuidores);    
        ProDAO.create(p1);
        
        Produtos p2 = new Produtos();        
        distribuidores.setCodDistribuidor(1);
        p2.setCodProduto(2);
        p2.setPrecoVenda(18.00);
        p2.setDescricao("Pasta Térmica A Base De Metais Pratas C/ 5g Dex - Ps15");
        p2.setDataValidade(Conversor.StringParaData("07/10/2020"));
        p2.setPrecoCusto(8.00);
        p2.setEstoque(1);
        p2.SetDistribuidores(distribuidores); 
        ProDAO.create(p2);
        
        Produtos p3 = new Produtos();        
        distribuidores.setCodDistribuidor(1);
        p3.setCodProduto(3);
        p3.setPrecoVenda(15.00);
        p3.setDescricao("10 Baterias De Lítio Elgin Cr2032 - 2 Cartelas Com 5 Unidades");
        p3.setDataValidade(Conversor.StringParaData("07/10/2022"));
        p3.setPrecoCusto(5.00);
        p3.setEstoque(1);
        p3.SetDistribuidores(distribuidores);        
        ProDAO.create(p3);
        
        Produtos p4 = new Produtos();        
        distribuidores.setCodDistribuidor(1);
        p4.setCodProduto(4);
        p4.setPrecoVenda(17.00);
        p4.setDescricao("Limpa Contato Elétrico Spray Eletronico 300ml Orbi");
        p4.setDataValidade(Conversor.StringParaData("10/01/2020"));
        p4.setPrecoCusto(9.00);
        p4.setEstoque(1);
        p4.SetDistribuidores(distribuidores); 
        ProDAO.create(p4);
        
        Produtos p5 = new Produtos();        
        distribuidores.setCodDistribuidor(1);
        p5.setCodProduto(5);
        p5.setPrecoVenda(24.99);
        p5.setDescricao("Kit Limpa Telas Lentes Note Tv Tablet Celular Bactericida");
        p5.setDataValidade(Conversor.StringParaData("07/10/2021"));
        p5.setPrecoCusto(10.00);
        p5.setEstoque(1);
        p5.SetDistribuidores(distribuidores); 
        ProDAO.create(p5);
        
        Produtos p6 = new Produtos();        
        distribuidores.setCodDistribuidor(2);
        p6.setCodProduto(6);
        p6.setPrecoVenda(278.88);
        p6.setDescricao("Cabo De Rede Furukawa Cat5e Cmx Soho Plus Azul 100 Metros");
        p6.setDataValidade(Conversor.StringParaData("07/10/2024"));
        p6.setPrecoCusto(50.00);
        p6.setEstoque(1);
        p6.SetDistribuidores(distribuidores); 
        ProDAO.create(p6);
        
        Produtos p7 = new Produtos();        
        distribuidores.setCodDistribuidor(2);
        p7.setCodProduto(7);
        p7.setPrecoVenda(414.72);
        p7.setDescricao("Cabo Lan Cat6 Furukawa Soho Plus 24awgx4p Azul 100 Metros");
        p7.setDataValidade(Conversor.StringParaData("07/10/2025"));
        p7.setPrecoCusto(180.00);
        p7.setEstoque(1);
        p7.SetDistribuidores(distribuidores); 
        ProDAO.create(p7);
        
        Produtos p8 = new Produtos();        
        distribuidores.setCodDistribuidor(2);
        p8.setCodProduto(8);
        p8.setPrecoVenda(21.98);
        p8.setDescricao("Conector Rj45 Plug Cat 5e 8x8 Soho Plus Furukawa 10 Pçs");
        p8.setDataValidade(Conversor.StringParaData("07/10/2028"));
        p8.setPrecoCusto(5.00);
        p8.setEstoque(1);
        p8.SetDistribuidores(distribuidores); 
        ProDAO.create(p8);
        
        Produtos p9 = new Produtos();
        distribuidores.setCodDistribuidor(2);
        p9.setCodProduto(9);
        p9.setPrecoVenda(62.99);
        p9.setDescricao("500pcs Plug Conector Rj11 6x4 Crimpar 4 Vias Telefonia Pct");
        p9.setDataValidade(Conversor.StringParaData("07/10/2024"));
        p9.setPrecoCusto(20.00);
        p9.setEstoque(1);
        p9.SetDistribuidores(distribuidores); 
        ProDAO.create(p9);
        
        Produtos p10 = new Produtos();        
        distribuidores.setCodDistribuidor(2);
        p10.setCodProduto(10);
        p10.setPrecoVenda(79.00);
        p10.setDescricao("Alicate Crimpar Rj45 +testador +bateria+decapador+10rj");
        p10.setDataValidade(Conversor.StringParaData("07/10/2025"));
        p10.setPrecoCusto(30.00);
        p10.setEstoque(1);
        p10.SetDistribuidores(distribuidores);           
        ProDAO.create(p10);         
        
        //VENDAS
        Vendas v1 = new Vendas();
        VendasDAO VenDAO = new VendasDAO();
        Clientes clientes = new Clientes();
       
        v1.setCodVenda(1);
        clientes.setCodCliente(1);
        v1.setTotal(83);
        v1.setClientes(clientes);
        v1.setData(Conversor.StringParaData("11/10/2020"));
        v1.setHora("13:30");
        VenDAO.create(v1);
        
        Vendas v2 = new Vendas();
        clientes.setCodCliente(1);
        v2.setCodVenda(2);
        v2.setTotal(320.87);
        v2.setClientes(clientes);
        v2.setData(Conversor.StringParaData("20/1/2021"));
        v2.setHora("9:37");    
        VenDAO.create(v2);
        
        Vendas v3 = new Vendas();
        clientes.setCodCliente(2);
        v3.setCodVenda(3);
        v3.setTotal(499.69);
        v3.setClientes(clientes);
        v3.setData(Conversor.StringParaData("15/01/2020"));
        v3.setHora("11:00");   
        VenDAO.create(v3);
        
        Vendas v4 = new Vendas();
        clientes.setCodCliente(2);
        v4.setCodVenda(4);
        v4.setTotal(147);
        v4.setClientes(clientes);
        v4.setData(Conversor.StringParaData("03/04/2020"));
        v4.setHora("13:00");     
        VenDAO.create(v4);
        
        Vendas v5 = new Vendas();
        clientes.setCodCliente(3);
        v5.setCodVenda(5);
        v5.setTotal(150);
        v5.setClientes(clientes);
        v5.setData(Conversor.StringParaData("07/07/2020"));
        v5.setHora("10:30");         
        VenDAO.create(v5);
        
        Vendas v6 = new Vendas();
        clientes.setCodCliente(3);
        v6.setCodVenda(6);
        v6.setTotal(54);
        v6.setClientes(clientes);
        v6.setData(Conversor.StringParaData("05/1/2021"));
        v6.setHora("9:30");      
        VenDAO.create(v6);
        
        Vendas v7 = new Vendas();
        clientes.setCodCliente(4);
        v7.setCodVenda(7);
        v7.setTotal(45);
        v7.setClientes(clientes);
        v7.setData(Conversor.StringParaData("05/04/2020"));
        v7.setHora("15:00");       
        VenDAO.create(v7);
        
        Vendas v8 = new Vendas();
        clientes.setCodCliente(4);
        v8.setCodVenda(8);
        v8.setTotal(51);
        v8.setClientes(clientes);
        v8.setData(Conversor.StringParaData("13/09/2020"));
        v8.setHora("8:00");    
        VenDAO.create(v8);
        
        Vendas v9 = new Vendas();
        clientes.setCodCliente(5);
        v9.setCodVenda(9);
        v9.setTotal(74.97);
        v9.setClientes(clientes);
        v9.setData(Conversor.StringParaData("20/1/2021"));
        v9.setHora("10:00");      
        VenDAO.create(v9);
        
        Vendas v10 = new Vendas();
        clientes.setCodCliente(5);
        v10.setCodVenda(10);
        v10.setTotal(836.64);
        v10.setClientes(clientes);
        v10.setData(Conversor.StringParaData("20/1/2021"));
        v10.setHora("12:00");     
        VenDAO.create(v10);
        
        
        //ItensVendas
        ItensVendas iv1 = new ItensVendas();
        ItensVendasDAO ivDAO = new ItensVendasDAO();
        Vendas vd = new Vendas();
        
        iv1.setVendas(v1);
        iv1.setProdutos(p1);
        iv1.setQuantidade(1);
        iv1.setProdutos(p2);
        iv1.setQuantidade(1);
        iv1.setProdutos(p3);
        iv1.setQuantidade(1);
        iv1.setSubTotal(p1.getPrecoVenda() + p2.getPrecoVenda() + p3.getPrecoVenda());
        ivDAO.create(iv1);
        
        ItensVendas iv2 = new ItensVendas();

        iv2.setVendas(v2);
        iv2.setProdutos(p4);
        iv2.setQuantidade(1);
        iv2.setProdutos(p5);
        iv2.setQuantidade(1);
        iv2.setProdutos(p6);
        iv2.setQuantidade(1);
        iv2.setSubTotal(p4.getPrecoVenda() + p5.getPrecoVenda() + p6.getPrecoVenda());
        ivDAO.create(iv2);
        
        ItensVendas iv3 = new ItensVendas();

        iv3.setVendas(v3);
        iv3.setProdutos(p7);
        iv3.setQuantidade(1);
        iv3.setProdutos(p8);
        iv3.setQuantidade(1);
        iv3.setProdutos(p9);
        iv3.setQuantidade(1);
        iv3.setSubTotal(p7.getPrecoVenda() + p8.getPrecoVenda() + p9.getPrecoVenda());
        ivDAO.create(iv3);
        
        ItensVendas iv4 = new ItensVendas();

        iv4.setVendas(v4);
        iv4.setProdutos(p10);
        iv4.setQuantidade(1);
        iv4.setProdutos(p1);
        iv4.setQuantidade(1);
        iv4.setProdutos(p2);
        iv4.setQuantidade(1);
        iv4.setSubTotal(p10.getPrecoVenda() + p1.getPrecoVenda() + p2.getPrecoVenda());        
        ivDAO.create(iv4);
        
        ItensVendas iv5 = new ItensVendas();

        iv5.setVendas(v5);
        iv5.setProdutos(p1);
        iv5.setQuantidade(1);
        iv5.setProdutos(p1);
        iv5.setQuantidade(1);
        iv5.setProdutos(p1);
        iv5.setQuantidade(1);
        iv5.setSubTotal(p1.getPrecoVenda() + p1.getPrecoVenda() + p1.getPrecoVenda());    
        ivDAO.create(iv5);
        
        ItensVendas iv6 = new ItensVendas();

        iv6.setVendas(v6);
        iv6.setProdutos(p2);
        iv6.setQuantidade(1);
        iv6.setProdutos(p2);
        iv6.setQuantidade(1);
        iv6.setProdutos(p2);
        iv6.setQuantidade(1);
        iv6.setSubTotal(p2.getPrecoVenda() + p2.getPrecoVenda() + p2.getPrecoVenda());    
        ivDAO.create(iv6);
        
        ItensVendas iv7 = new ItensVendas();

        iv7.setVendas(v7);
        iv7.setProdutos(p3);
        iv7.setQuantidade(1);
        iv7.setProdutos(p3);
        iv7.setQuantidade(1);
        iv7.setProdutos(p3);
        iv7.setQuantidade(1);
        iv7.setSubTotal(p3.getPrecoVenda() + p3.getPrecoVenda() + p3.getPrecoVenda());    
        ivDAO.create(iv7);
        
        ItensVendas iv8 = new ItensVendas();

        iv8.setVendas(v8);
        iv8.setProdutos(p4);
        iv8.setQuantidade(1);
        iv8.setProdutos(p4);
        iv8.setQuantidade(1);
        iv8.setProdutos(p4);
        iv8.setQuantidade(1);
        iv8.setSubTotal(p4.getPrecoVenda() + p4.getPrecoVenda() + p4.getPrecoVenda());  
        ivDAO.create(iv8);
        
        ItensVendas iv9 = new ItensVendas();

        iv9.setVendas(v9);
        iv9.setProdutos(p5);
        iv9.setQuantidade(1);
        iv9.setProdutos(p5);
        iv9.setQuantidade(1);
        iv9.setProdutos(p5);
        iv9.setQuantidade(1);
        iv9.setSubTotal(p5.getPrecoVenda() + p5.getPrecoVenda() + p5.getPrecoVenda());  
        ivDAO.create(iv9);
        
        ItensVendas iv10 = new ItensVendas();

        iv10.setVendas(v10);
        iv10.setProdutos(p6);
        iv10.setQuantidade(1);
        iv10.setProdutos(p6);
        iv10.setQuantidade(1);
        iv10.setProdutos(p6);
        iv10.setQuantidade(1);
        iv10.setSubTotal(p6.getPrecoVenda() + p6.getPrecoVenda() + p6.getPrecoVenda());  
        ivDAO.create(iv10);
        
        // EX3 RETORNO EMAIL NULO E PRODUTOS VENCIDOS //
        
        ClienteDAO cliDao = new ClienteDAO();          
        cliDao.ExibirEmailNull();
        
        System.out.println("\n");
        
        ProdutosDAO proDao = new ProdutosDAO();
        proDao.ExibirData_Validade();
        
    }   
}