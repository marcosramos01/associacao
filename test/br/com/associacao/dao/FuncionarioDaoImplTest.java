/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.associacao.dao;

import br.com.associacao.entidade.Endereco;
import br.com.associacao.entidade.Funcionario;
import br.com.utilitario.UtilGerador;
import java.util.List;
import org.junit.Test;

/**
 *
 * @author Win10
 */
public class FuncionarioDaoImplTest {

    private Funcionario funcionario;
    private FuncionarioDaoImpl funcionarioDaoImpl;

    public FuncionarioDaoImplTest() {
        funcionarioDaoImpl = new FuncionarioDaoImpl();
    }

//    @Test
    public void testSalvar() throws Exception {
        System.out.println("salvar");
        funcionario = new Funcionario(
                null,
                UtilGerador.gerarNome(),
                UtilGerador.gerarEmail(),
                UtilGerador.gerarTelefoneFixo(),
                UtilGerador.gerarNumero(5));

        Endereco endereco = new Endereco(null, UtilGerador.gerarCaracter(10), UtilGerador.gerarNumero(3),
                UtilGerador.gerarCaracter(10), UtilGerador.gerarCaracter(10), UtilGerador.gerarCaracter(2),
                UtilGerador.gerarNumero(5) + "-" + UtilGerador.gerarNumero(3));

        funcionario.setEndereco(endereco);
        funcionarioDaoImpl.salvar(funcionario);

    }

//    @Test
    public void testPesquisarPorId() throws Exception {
        System.out.println("pesquisarPorId");
        funcionario = funcionarioDaoImpl.pesquisarPorId(12);

    }

    private void mostraFuncionario(Funcionario funcionario) {
        System.out.println("id Funcionario" + funcionario.getId());
        System.out.println("Funcionario" + funcionario.getNome());
        System.out.println("E-mail" + funcionario.getEmail());
        System.out.println("Telefone" + funcionario.getTelefone());
        System.out.println("Cracha" + funcionario.getNumeroCracha());
        System.out.println("id Endereço" + funcionario.getEndereco().getId());
        System.out.println("Logradouro" + funcionario.getEndereco().getLogradouro());
        System.out.println("Número" + funcionario.getEndereco().getNumero());
        System.out.println("Bairro" + funcionario.getEndereco().getBairro());
        System.out.println("Cidade" + funcionario.getEndereco().getCidade());
        System.out.println("Estado" + funcionario.getEndereco().getEstado());
        System.out.println("CEP" + funcionario.getEndereco().getCep());
        System.out.println("");

    }

//    @Test
    public void testExcluir() throws Exception {
        System.out.println("excluir");
        funcionarioDaoImpl.excluir(27);

    }

//    @Test
    public void testPesquisarPorNome() throws Exception {
        System.out.println("pesquisarPorNome");
        List<Funcionario> funcionarios = funcionarioDaoImpl.pesquisarPorNome("oliveira");
        for (Funcionario func : funcionarios) {
            mostraFuncionario(func);

        }

    }

//    @Test
    public void testAlterar() throws Exception {
        System.out.println("alterar");
       funcionario = funcionarioDaoImpl.pesquisarPorId(41);
       funcionario.setEmail("email alterado");
       funcionario.setNumeroCracha("000001");
       funcionario.getEndereco().setLogradouro("outra rua");
       funcionarioDaoImpl.alterar(funcionario);
    }

}
